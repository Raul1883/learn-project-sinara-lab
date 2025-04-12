package com.night.learn_project.controllers;


import com.night.learn_project.models.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MySecureController {

    @GetMapping(path = "public/test")
    public ResponseEntity<String> getPublicEndPoint() {
        String response_text = "Public API";
        return ResponseEntity.ok(response_text);
    }

    @GetMapping(path = "support/info")
    public ResponseEntity<UserDTO> getSupportUserInfo(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(UserDTO.of(user));
    }

    @GetMapping(path = "admin/info")
    public ResponseEntity<UserDTO> getAdminUserInfo(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(UserDTO.of(user));
    }
}
