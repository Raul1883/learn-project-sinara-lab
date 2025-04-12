package com.night.learn_project.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails support = User
                .builder()
                .username("support")
                .password(passwordEncoder().encode("support_password"))
                .roles("SUPPORT")
                .build();

        UserDetails admin = User
                .builder()
                .username("admin")
                .password(passwordEncoder().encode("admin_password"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(support, admin);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/admin/**")
                        .hasRole("ADMIN")
                        .requestMatchers("/support/**")
                        .hasRole("SUPPORT")
                        .requestMatchers("/public/**")
                        .permitAll());

        return http.build();
    }
}
