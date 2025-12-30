# Simple REST Server

A Spring Boot REST API demonstration project showcasing modern Java features including Records for clean and immutable data models.

## Related Projects

This REST server has a companion client application:

**[SimpleRestClient](https://github.com/ronsonw/simplerestclient)** - A Java client application that demonstrates how to consume this REST API using modern HTTP client libraries.

## Technologies

- **Java**: 25
- **Spring Boot**: 4.0.1
- **Build Tool**: Maven
- **Packaging**: WAR
- **Libraries**:
  - Spring Web MVC
  - Lombok
  - Jackson (for JSON serialization)

## Prerequisites

- Java JDK 25 or higher
- Maven 3.6+
- IDE (IntelliJ IDEA, Eclipse, or VS Code recommended)

## Getting Started

### Build the Project

```bash
cd restserver
mvn clean install
```

### Run the Application

```bash
mvn spring-boot:run
```

The server will start on `http://localhost:8080`

### Package as WAR

```bash
mvn clean package
```

The WAR file will be generated at `target/restserver-0.0.1-SNAPSHOT.war`

## API Endpoints

### 1. Hello World - GET

Get a simple "Hello World" message.

**Endpoint:** `GET /api/hello`

**Response:**
```
Hello World
```

**Example:**
```bash
curl http://localhost:8080/api/hello
```

---

### 2. Hello with Name - POST

Send a name and receive a personalized greeting.

**Endpoint:** `POST /api/hello`

**Request Headers:**
```
Content-Type: application/json
```

**Request Body:**
```json
{
  "name": "Jim"
}
```

**Response:**
```
Hello Jim
```

**Example:**
```bash
curl -X POST http://localhost:8080/api/hello \
  -H "Content-Type: application/json" \
  -d '{"name":"Jim"}'
```

---

### 3. Get User - GET

Retrieve a User object as JSON.

**Endpoint:** `GET /api/user`

**Response:**
```json
{
  "name": "Jim"
}
```

**Example:**
```bash
curl http://localhost:8080/api/user
```

## Project Structure

```
restserver/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/rw/restserver/
│   │   │       ├── controller/
│   │   │       │   └── HelloWorldController.java    # REST endpoints
│   │   │       ├── service/
│   │   │       │   └── HelloWorldSvc.java           # Business logic
│   │   │       ├── model/
│   │   │       │   └── User.java                    # Data model (Record)
│   │   │       ├── RestserverApplication.java       # Main application
│   │   │       └── ServletInitializer.java          # WAR deployment config
│   │   └── resources/
│   │       └── application.properties               # Configuration
│   └── test/
│       └── java/                                    # Test files
├── pom.xml                                          # Maven configuration
└── README.md                                        # This file
```

## Key Features

### Java Records

This project uses modern Java **Records** for data models:

```java
public record User(String name) {}
```

Records provide:
- Immutable data structures
- Automatic constructor, getters, equals, hashCode, and toString
- Seamless JSON serialization/deserialization
- Less boilerplate code

### Service Layer Architecture

Clean separation of concerns:
- **Controller**: HTTP request/response handling
- **Service**: Business logic
- **Model**: Data structures

### Lombok Integration

Using Lombok annotations for reduced boilerplate:
- `@Slf4j` - Automatic logger injection
- Configured for compile-time annotation processing

## Testing

### Unit Tests

Run all tests:
```bash
mvn test
```

### Integration Testing with Client

For end-to-end integration testing, use the companion **[SimpleRestClient](https://github.com/ronsonw/simplerestclient)** project:

1. Start this REST server (`mvn spring-boot:run`)
2. Run the SimpleRestClient application
3. The client will demonstrate consuming all available API endpoints

## Configuration

Default configuration in `application.properties`:
- Application name: `restserver`
- Default port: `8080` (Spring Boot default)

To change the port, add to `application.properties`:
```properties
server.port=9090
```

## Development

### Adding New Endpoints

1. Create a model in `model/` package (use Records for DTOs)
2. Add business logic in `service/` package
3. Create controller endpoint in `controller/` package
4. Use `@RestController` and appropriate mapping annotations

### Example: Adding a New Record

```java
// model/Person.java
package com.rw.restserver.model;

import java.time.LocalDate;
import java.util.Map;

public record Person(
    String name,
    LocalDate date,
    Map<String, String> cityStatePairs
) {}
```

## Building for Production

1. Update version in `pom.xml`
2. Build the WAR file:
   ```bash
   mvn clean package -DskipTests
   ```
3. Deploy `target/restserver-0.0.1-SNAPSHOT.war` to your application server

## License

This is a demo project for learning purposes.

## Author

Ronson W.
