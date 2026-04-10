# Recruitment App (Spring Boot + PostgreSQL)

Recruitment domain REST API built with **Java 21**, **Spring Boot 3.x**, **Maven**, **JPA/Hibernate**, and **PostgreSQL**.

## Tech Stack
- Java 21
- Spring Boot 3.3.x
- Spring Web
- Spring Data JPA
- Spring Validation
- PostgreSQL JDBC Driver
- Lombok

## Project Structure
- `controller` - REST controllers
- `service` - service interfaces
- `service/impl` - service implementations
- `repository` - JPA repositories
- `entity` - JPA entities
- `dto` - request/response DTOs
- `mapper` - manual mapper classes
- `exception` - API exceptions and global handler
- `config` - app config
- `enums` - enum types

## Run PostgreSQL with Docker Compose
```bash
docker compose up -d
```

PostgreSQL defaults (from `docker-compose.yml`):
- DB: `recruitment_db`
- User: `recruitment_user`
- Password: `recruitment_pass`
- Port: `5432`

## Configure the app
Main configuration file: `src/main/resources/application.yml`.

Default connection URL:
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/recruitment_db
    username: recruitment_user
    password: recruitment_pass
```

## Run the project
```bash
mvn spring-boot:run
```

Or build and run jar:
```bash
mvn clean package
java -jar target/recruitment-app-0.0.1-SNAPSHOT.jar
```

## API Base Path
`/api`

## Endpoints (CRUD)
Each resource exposes:
- `POST /api/{resource}`
- `GET /api/{resource}/{id}`
- `GET /api/{resource}`
- `PUT /api/{resource}/{id}`
- `DELETE /api/{resource}/{id}`

Resources:
- `/profiles`
- `/recruitments`
- `/applications`
- `/application-scores`
- `/profile-stage-templates`
- `/profile-question-templates`
- `/profile-stage-score-templates`
- `/recruitment-stages`
- `/recruitment-questions`
- `/recruitment-stage-score-templates`
- `/application-files`

## Notes
- No Spring Security/authentication/authorization is implemented.
- DTO-based API to avoid exposing entities directly.
- Relationships in requests are handled using foreign key IDs.
- Enum fields are persisted as strings.
- PostgreSQL-reserved/risky column names are mapped explicitly:
  - `order` -> `displayOrder`
  - `start` -> `startDate`
  - `end` -> `endDate`
