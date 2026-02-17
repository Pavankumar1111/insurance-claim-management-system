# Insurance Claim Management System

A microservices-based backend application built using Spring Boot, Spring Security, JWT, Eureka, API Gateway, and MySQL.

This system allows users to submit insurance claims and administrators to approve or reject them using role-based authorization.

---

## 🏗 Architecture

Microservices Architecture:

- discovery-server (Eureka Service Discovery)
- api-gateway (Centralized Routing + JWT Validation)
- user-service (Authentication & Role Management)
- policy-service (Policy Management)
- claim-service (Claim Submission & Approval)

Each service has its own database to ensure loose coupling and scalability.

Architecture Flow:

Client → API Gateway → Microservices → MySQL  
Service discovery handled by Eureka.

---

## 🔐 Security Features

- JWT Authentication
- Role-Based Authorization (ADMIN / USER)
- Method-Level Security using @PreAuthorize
- Stateless Architecture
- API Gateway request filtering

Roles:

- ROLE_USER → Create and view claims
- ROLE_ADMIN → Approve or reject claims

---

## 🛠 Technologies Used

- Java 17
- Spring Boot 3
- Spring Security
- Spring Cloud Gateway
- Eureka Server
- MySQL
- Maven
- Postman (API Testing)

---

## ⚙ Database Setup

Create databases in MySQL:

```sql
CREATE DATABASE user_db;
CREATE DATABASE policy_db;
CREATE DATABASE claim_db;
