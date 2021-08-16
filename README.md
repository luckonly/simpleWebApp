# SimpleWebApp
REST сервис позволяющий выполнять CRUD операции над сотрудниками.

## Начало работы

Для запуска приложения:
1. cклонируйте репозиторий
2. скорректируйте настройки доступа к базе данных в соответствие от типа запуска (local/docker)
3. в каталоге с проектом выполните команду mvn package
4. выполните команду docker-compose up -d

## Описание приложения

После запуска сервис будет доступен по пути http://localhost:8080

При создании приложения были использованы:
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- Docker
- Slf4j
- JUnit, Mockito и Testcontainers
- Liquibase
