# Spring security

## WebSecurityConfig.java
Основной файл конфигурации.
### userDetailsService()  
Создает два пользователя: Поддержка и администрация. Пароль хэширован при помощи passwordEncoder()

### passwordEncoder()
Возвращает экземпляр энкодера, реализован в качестве метода для использования с DI и уменьшения связности

### securityFilterChain(HttpSecurity http)
Создает основную цепь фильтров:
Используется basic авторизация;
Стандартная форма логина;
Заданы публичные и доступные только ролям url.

## MySecureController.java
Контроллер. Содержит три метода: публичный, для саппортов и админов.

### getPublicEndPoint()  
Публичный доступ. Возвращает строку-заглушку.

### getSupportUserInfo(@AuthenticationPrincipal User user)  
Доступен только пользователям с ролью SUPPORT. Возвращает DTO пользователя.


### getAdminUserInfo(@AuthenticationPrincipal User user)
Доступен только пользователям с ролью ADMIN. Возвращает DTO пользователя.


## UserDTO.java
Data-класс, отображающий пользователя. Содержит имя пользователя и list ролей пользователя.