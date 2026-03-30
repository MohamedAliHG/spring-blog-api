# 📝 spring-blog-api

A **RESTful Blog API** built with **Spring Boot 3** and **Java 17**, backed by a **MySQL** database. Features full blog management with server-side rendering via Thymeleaf and robust input validation.

---

## 📋 Table of Contents

- [Overview](#overview)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [Configuration](#configuration)
- [Database Setup](#database-setup)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Contributing](#contributing)

---

## Overview

**spring-blog-api** is a backend web application for managing blog content. Built on Spring Boot 3.4.5, it exposes a REST API for blog operations and uses Thymeleaf for server-side HTML rendering. Data is persisted in a MySQL database through Spring Data JPA.

---

## Tech Stack

| Component | Technology |
|---|---|
| Language | Java 17 |
| Framework | Spring Boot 3.4.5 |
| ORM | Spring Data JPA (Hibernate) |
| Database | MySQL |
| View Layer | Thymeleaf |
| Validation | Spring Boot Validation (Bean Validation / JSR-380) |
| Build Tool | Maven (Maven Wrapper included) |
| Testing | Spring Boot Test |

---

## Project Structure

```
spring-blog-api/
│
├── src/
│   ├── main/
│   │   ├── java/gl2/example/apiBlog/   # Application source code
│   │   └── resources/
│   │       ├── application.properties  # App configuration
│   │       └── templates/              # Thymeleaf HTML templates
│   └── test/                           # Unit & integration tests
│
├── .mvn/wrapper/                        # Maven wrapper config
├── mvnw / mvnw.cmd                      # Maven wrapper scripts
├── pom.xml                              # Project dependencies
└── .gitignore
```

---

## Getting Started

### Prerequisites

- [Java 17+](https://adoptium.net/)
- [Maven 3.8+](https://maven.apache.org/) *(or use the included `mvnw` wrapper)*
- [MySQL 8+](https://www.mysql.com/)

### Clone

```bash
git clone https://github.com/MohamedAliHG/spring-blog-api.git
cd spring-blog-api
```

---

## Configuration

Edit `src/main/resources/application.properties` with your MySQL credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/blog_db
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

> **Tip:** Use environment variables or Spring profiles to avoid committing credentials to source control.

---

## Database Setup

Create the database in MySQL before running the app:

```sql
CREATE DATABASE blog_db;
```

Hibernate will automatically create/update the schema on first run (`ddl-auto=update`).

---

## Running the Application

Using the Maven wrapper (no local Maven install needed):

```bash
# Linux / macOS
./mvnw spring-boot:run

# Windows
mvnw.cmd spring-boot:run
```

The application will start at `http://localhost:8080` by default.

---

## API Endpoints

> These are the expected REST endpoints based on the project structure. Update this section to match your actual controller mappings.

| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/api/posts` | Get all blog posts |
| `GET` | `/api/posts/{id}` | Get a single post by ID |
| `POST` | `/api/posts` | Create a new post |
| `PUT` | `/api/posts/{id}` | Update an existing post |
| `DELETE` | `/api/posts/{id}` | Delete a post |

---

## Contributing

1. Fork the repository
2. Create a feature branch: `git checkout -b feature/your-feature`
3. Commit your changes: `git commit -m "Add your feature"`
4. Push: `git push origin feature/your-feature`
5. Open a Pull Request

---

## Author

**Mohamed Ali HG** — [@MohamedAliHG](https://github.com/MohamedAliHG)

---

*Built using Spring Boot 3 and Java 17.*
