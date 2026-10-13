# Portfolio Website

A personal portfolio website built using Java and Spring Boot, featuring a contact form and a secure admin dashboard for managing messages.

## Overview

This project showcases my portfolio development skills, backend programming, database integration, and authentication using Spring Boot.

Visitors can explore the portfolio and send messages through the contact form. The admin dashboard provides a card-based interface to view received messages and track their read status.

## Features

- Responsive portfolio website
- Contact form for receiving messages
- Backend REST API integration
- MySQL database integration
- Admin login and protected dashboard
- Card-based message management
- Read and unread message status
- Thymeleaf server-side rendering
- Git and GitHub version control

## Screenshots

### Portfolio Homepage

![Portfolio Homepage](screenshots/homepage.png)

### Admin Login

![Admin Login](screenshots/admin-login.png)

### Messages Dashboard

![Messages Dashboard](screenshots/messages-dashboard.png)

## Tech Stack

| Technology | Purpose |
|---|---|
| Java | Backend programming |
| Spring Boot | Application framework |
| Spring MVC | Request handling and routing |
| Spring Security | Authentication and access control |
| Spring Data JPA | Database operations |
| Hibernate | ORM |
| MySQL | Relational database |
| Thymeleaf | Server-side HTML templates |
| HTML and CSS | User interface |
| Maven | Dependency and build management |
| Git and GitHub | Version control |

## Project Structure

```text
portfolio/
├── src/
│   ├── main/
│   │   ├── java/com/aman/portfolio/
│   │   │   ├── config/
│   │   │   ├── controller/
│   │   │   ├── dto/
│   │   │   ├── entity/
│   │   │   ├── exception/
│   │   │   ├── repository/
│   │   │   ├── service/
│   │   │   └── PortfolioApplication.java
│   │   └── resources/
│   │       ├── templates/
│   │       ├── static/
│   │       └── application.properties
│   └── test/
├── pom.xml
└── README.md
```

## Run Locally

### Prerequisites

- Java 21
- Maven
- MySQL Server
- Git

### 1. Clone the repository

```bash
git clone https://github.com/amanpandey2025/portfolio.git
cd portfolio
```

### 2. Create the database

Open MySQL and execute:

```sql
CREATE DATABASE portfolio;
```

### 3. Configure environment variables

Configure the following environment variables in your IDE or terminal:

- `DB_URL`
- `DB_USERNAME`
- `DB_PASSWORD`
- `ADMIN_USERNAME`
- `ADMIN_PASSWORD`

Use your own local database credentials and a strong admin password. Never commit real credentials to GitHub.

### 4. Run the application

On Windows PowerShell:

```powershell
.\mvnw.cmd spring-boot:run
```

### 5. Open the website

- Homepage: http://localhost:8080/
- Admin login: http://localhost:8080/admin/login
- Messages dashboard: http://localhost:8080/admin/messages

## Security Notes

- Keep database and admin credentials outside source control.
- Use environment variables for sensitive configuration.
- Restrict admin dashboard access to authorized users.
- Use HTTPS and secure configuration when deploying publicly.

## Future Improvements

- Cloud deployment
- Cloud database integration
- Message search and filtering
- Pagination for large inboxes
- Automated testing and CI/CD

## Author

**Aman Pandey**

- GitHub: [@amanpandey2025](https://github.com/amanpandey2025)

---

This project is continuously evolving as I improve my Java, Spring Boot, database, and deployment skills.
