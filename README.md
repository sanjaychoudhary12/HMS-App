Hotel Management System (Treebo)

Overview

The Hotel Management System (Treebo) is a robust backend application designed and developed to streamline hotel operations.
Built using modern Java technologies, it focuses on performance, scalability, and security, offering modules such as 
OTP-based user registration, room management, feedback collection, and automated PDF invoice generation. 
The system is secured with Spring Security and JWT for authentication and integrates third-party APIs for email/SMS notifications.

Features

Core Functionalities
User Registration with OTP Verification: Secure and seamless user onboarding using OTP-based authentication.
Room Management: Efficient handling of room availability, booking, and status updates.
Feedback Management: Collect and manage guest feedback to improve services.
Room Search: Quick and optimized room search functionality using JPQL with joins.
PDF Invoice Generation: Automated generation of invoices using ITEXTPDF.

Security Features
Spring Security and JWT: Secure the application with token-based authentication, ensuring session safety.
Third-party API Integration: Email and SMS notifications for user activities.

Performance Enhancements
Optimized database queries using JPQL with joins, reducing query execution time by 20%.
Advanced Java 8 features (Stream API, Optional) to write efficient, maintainable code.
Utilization of Lombok and ModelMapper to reduce boilerplate code and improve productivity.
Deployment
The application is deployed on AWS, leveraging cloud scalability and reliability for production use.

Tech Stack
Programming Language: Java 8
Framework: Spring Boot
Database: MySQL
ORM: Hibernate JPA
Security: Spring Security, JWT
PDF Generation: ITEXTPDF
Tools & Libraries: Maven, Lombok, ModelMapper
Cloud Provider: AWS
Project Architecture
Controller Layer: Manages HTTP requests and routes them to the appropriate services.
Service Layer: Contains the business logic for the application.
Repository Layer: Handles database interactions using Hibernate JPA.
Security Layer: Configures Spring Security and JWT for authentication and authorization.
Utility Classes: Includes tools for PDF generation, email/SMS notifications, and model mapping.
Installation and Setup
Prerequisites
Java 8
Maven
MySQL Server
Steps to Run the Application
Clone the repository:
https://github.com/harshsinghcs/Hotel-Management-System-HMS-Wotif-.git
Navigate to the project directory:
cd hms
Configure the application.properties file with your MySQL and AWS credentials.
Build the project:
mvn clean install
Run the application:
mvn spring-boot:run
API Endpoints
User Management
POST /api/users/register - Register a new user with OTP verification.
POST /api/users/login - Authenticate and retrieve a JWT token.
Room Management
GET /api/rooms - Retrieve a list of available rooms.
POST /api/rooms/book - Book a room.
Feedback
POST /api/feedback - Submit guest feedback.
Invoice
GET /api/invoice/{bookingId} - Generate and download a PDF invoice.
Application Properties Configuration
To set up the application, create a file named application.properties in the src/main/resources directory with the following configuration:

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
Configuration Details
Database Configuration

Replace {your_database_name} with your MySQL database name
Replace {your_mysql_username} with your MySQL username
Replace {your_mysql_password} with your MySQL password
The ddl-auto=update setting automatically updates database schema
JWT Configuration

Replace {your_jwt_secret_key} with a secure secret key for JWT token signing
Replace {your_issuer_name} with your application's name or domain
Replace {jwt_expiry_duration} with the token expiry time (e.g., 86400000 for 24 hours)
Example Configuration
spring.application.name=hms

spring.datasource.url=jdbc:mysql://localhost:3306/hotel_db
spring.datasource.username=root
spring.datasource.password=mypassword
spring.jpa.hibernate.ddl-auto=update
#spring.jpa.show-sql=true

jwt.algorithm.key=your-256-bit-secret
jwt.issuer=hotel-management-system
jwt.expiry.duration=86400000
Note: Never commit your actual credentials to version control. Consider using environment variables or external configuration for sensitive data in production.

Contributions
Contributions are welcome! If you'd like to improve this project, feel free to fork the repository and submit a pull request.
