# 🏨 Hotel Management System (Treebo)

## 📘 Overview

The **Hotel Management System (Treebo)** is a robust backend application designed to streamline hotel operations.  
Built using modern **Java technologies**, it focuses on performance, scalability, and security.

Key modules include:
- OTP-based user registration
- Room management
- Feedback collection
- Automated PDF invoice generation  
The system is secured with **Spring Security** and **JWT**, and integrates third-party APIs for **email/SMS notifications**.

---

## 🚀 Features

### ✅ Core Functionalities

- **User Registration with OTP Verification**  
  Secure and seamless user onboarding using OTP-based authentication.

- **Room Management**  
  Efficient handling of room availability, booking, and status updates.

- **Feedback Management**  
  Collect and manage guest feedback to improve services.

- **Room Search**  
  Optimized room search functionality using JPQL with joins.

- **PDF Invoice Generation**  
  Automated generation of invoices using **iTextPDF**.

---

### 🔐 Security Features

- **Spring Security & JWT**  
  Token-based authentication to ensure secure access and session safety.

- **Third-party API Integration**  
  Email and SMS notifications for user activities using external services.

---

### ⚙️ Performance Enhancements

- Optimized database queries with **JPQL joins** — improved performance by **20%**
- Utilized **Java 8 features** (Stream API, Optional) for clean and maintainable code
- Integrated **Lombok** and **ModelMapper** to reduce boilerplate and improve development speed

---

## ☁️ Deployment

The application is deployed on **AWS**, leveraging cloud scalability and reliability for production environments.

---

## 🧰 Tech Stack

| Component         | Technology           |
|------------------|----------------------|
| **Language**      | Java 8               |
| **Framework**     | Spring Boot          |
| **Database**      | MySQL                |
| **ORM**           | Hibernate JPA        |
| **Security**      | Spring Security, JWT |
| **PDF Generator** | iTextPDF             |
| **Tools**         | Maven, Lombok, ModelMapper |
| **Cloud**         | AWS                  |

---

## 🏗️ Project Architecture

- **Controller Layer**: Manages HTTP requests and routes them to appropriate services  
- **Service Layer**: Contains core business logic  
- **Repository Layer**: Handles database interactions using Hibernate JPA  
- **Security Layer**: Configures Spring Security and JWT authentication  
- **Utility Classes**: For PDF generation, notifications, and mapping logic

---

## 📡 API Endpoints

### 👤 User Management
- `POST /api/users/register` — Register a new user with OTP verification  
- `POST /api/users/login` — Authenticate and retrieve JWT token  

### 🛏 Room Management
- `GET /api/rooms` — Retrieve list of available rooms  
- `POST /api/rooms/book` — Book a room  

### 📝 Feedback
- `POST /api/feedback` — Submit guest feedback  

### 🧾 Invoice
- `GET /api/invoice/{bookingId}` — Generate and download PDF invoice

---

## ⚙️ Application Properties Configuration

Create a file named `application.properties` in `src/main/resources` and add the following configuration:

```properties
spring.application.name=hms

# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/{your_database_name}
spring.datasource.username={your_mysql_username}
spring.datasource.password={your_mysql_password}
spring.jpa.hibernate.ddl-auto=update
#spring.jpa.show-sql=true

# JWT Configuration
jwt.algorithm.key={your_jwt_secret_key}
jwt.issuer={your_issuer_name}
jwt.expiry.duration={jwt_expiry_duration}
```

---

## 🤝 Contributions

Contributions are welcome!  
Fork the repo, create a feature branch, and submit a pull request to improve the system.
