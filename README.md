# Cinema Backend

Spring Boot REST API for the cinema project.

---

## Tech stack

| Component        | Version / Notes                        |
|------------------|----------------------------------------|
| Language         | Java **25**                            |
| Framework        | Spring Boot                            |
| Build tool       | Gradle (Kotlin DSL) — wrapper included |
| Database         | PostgreSQL                             |
| ORM              | Spring Data JPA / Hibernate            |
| Security         | Spring Security + JWT                  |
| AI integration   | Spring AI OpenAI                       |

---

## Running locally

### Prerequisites
- JDK 25
- Docker (the `spring-boot-docker-compose` dependency auto-starts the Postgres in `compose.yaml` on app start)

### Run
```bash
./gradlew bootRun
```

The app boots on `http://localhost:8080`. Postgres is started automatically on a random host port (mapped to container `5432`).

### Run tests
```bash
./gradlew test
```
Tests use Testcontainers for Postgres — Docker must be running.

---

## API endpoints

Base URL: `http://localhost:8080`

Healthcheck URL: `http://localhost:8080/actuator/health`

Swagger/OpenAPI URL: `http://localhost:8080/swagger-ui/index.html`

Protected endpoints require a valid `Authorization: Bearer <jwt>` header.

## Dockerization

- **Build command:** `./gradlew clean bootJar` — produces `build/libs/cinema-backend-0.0.1-SNAPSHOT.jar`.
- **Run command:** `java -jar app.jar`
- **Exposed port:** **8080**
- **Build context excludes:** add a `.dockerignore` for `build/`, `.gradle/`, `.idea/`, `*.iml`, `out/`.

### PostgreSQL

See `compose.yaml` at the repo root used by the Spring Boot Docker Compose dev integration - should probably be removed
for dockerization.
