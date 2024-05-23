# REST Microservices architecture for E-commerce website EASYSHOP with Spring Boot, Cloud, and multiple modules

This is an ecommerce REST API built using Java and Spring Boot. The API provides functionality for managing core functionalities like Product Catalog, Payment Gateway Integration, Order Service, User Service, Notification Service, etc. The API uses JSON Web Tokens (JWT) for authentication and authorization.

## Table of Contents
- [Features](#features)
- [Tools and Technologies](#tools-and-technologies)
- [Microservices](#microservices)
  - [User Service](#user-service)
  - [Authentication and Authorization](#authentication-and-authorization)  
  - [API Gateway](#api-gateway)
  - [Product Service](#product-service)
  - [Service Discovery](#service-discovery)
  - [Email Service](#email-service)
  - [Payment Service](#payment-service)            
- [Contact](#contact)

## Features

- OAuth 2.0 support for quick login.
- Regular Username/Password authentication.
- Stores user information in the MySQL database.
- Stores API data in Redis Cache to minimize network calls.
- Powerful sorting and filtering using ElasticSearch to allow for efficient discovery of products.
- Sort products by different parameters.
- Pagination to display max products on a single page.
- Stores authentication details like token information in db.
- Payment service using Stripe's API and Razorpay API to buy products.
- Email Service using Kafka.

## Tools and Technologies

- **Java 8**
- **Spring Boot:** Back-end JAVA framework to build microservices using Spring Rest Controller and Spring JPA.
- **Spring Web MVC**
- **Netflix Eureka Client/Server** - version 4.1.1
- **MySQL:** Stores product and user information.
- **Redis:** Stores API data in key-value pairs.
- **Spring Data Redis**
- **Spring Data JPA**
- **Kafka:** Used for implementing Email Service.
- **Google OAuth:** 3rd Party authentication service for quick login by retrieving user profile information.
- **Stripe:** Payment service API to handle user payment requests.
- **Razorpay:** Payment service API to handle user payment requests.
- **Docker-Compose:** Easy way to bring up the application using containerization and behaves similarly in the production environment.
- **Maven**

## Microservices

### User Service

Manages user-related functionalities such as registration, authentication, user profile management, and maintaining user-specific data like order history and preferences.

### Authentication and Authorization

The API uses JSON Web Tokens (JWT) for authentication and authorization. When a user logs in, they receive a JWT that must be included in the header of all subsequent requests. The JWT is verified on the server side to ensure that the user is authenticated and authorized to perform the requested action.

### API Gateway

The API Gateway service provides a single entry point for clients to access the various services in the system.

### Product Service

The Product Service handles all product-related operations, including managing product categories, and supports pagination, sorting, and filtering. It uses Redis caching to deliver faster results for product queries, optimizing the response time of APIs from ~500 ms to ~50 ms.

### Service Discovery

Service discovery in EASYSHOP, implemented using Netflix Eureka, ensures that microservices can dynamically locate and communicate with each other without hardcoded addresses, enabling seamless scaling and resilience.
![micro]([https://user-images.githubusercontent.com/50141193/58799788-845b1c00-8606-11e9-924b-1b4c03a9091c.png](https://github.com/kisjinn/EasyShop/blob/main/images-ss/spring-Eureka.png))

### Email Service

Implemented using Kafka, facilitates event-driven communication to send emails at scale across different microservices, ensuring reliable and asynchronous email notifications. We have implemented a feature where users receive an email upon signing up.

### Payment Service

The Payment Service integrates with Razorpay and Stripe to handle user payments. This service ensures secure and efficient payment processing, providing users with multiple payment options.

## Contact

For any questions or feedback, please contact:

Name: Sakshi Jinnewar  
Email: sakshijinnewar@gmail.com  
GitHub: [kisjinn](https://github.com/kisjinn)
