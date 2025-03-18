##### **Студент**: Юшков Юрий
##### **Преподаватель**: Дмитрий Рогожников
# Аннотация @SpringBootApplication
Используется для обозначения главного класса Spring Boot, который является точкой входа в приложение.
Включает в себя функциональность некоторых других аннотация, таких как: @Configuration, @EnableAutoConfiguration, @ComponentScan.
Таким образом, аннотация @SpringBootApplication указывает, что класс является конфигурационным, позволяет автоматически настраивать параметры в *зависимости от зависимостей* и сканирует бины в проекте.
## Параметры
**scanBasePackages** - указывает, какие пакеты необходимо проверить на наличие бинов.\
**scanBasePackageClasses** - типо-безопасный вариант scanBasePackages, который сканирует пакет, в котором находиться указанный класс.\
**exclude** - исключает указанный класс автоконфигурации.\
**excludeName** - то же, что и exclude, но принимает строку.\
**nameGenerator** - генератор имен для бинов.\
**proxyBeanMethods** - что-то очень сложное про проксирование бинов, надеюсь мы это изучим.

