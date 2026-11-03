# Banking Application — Spring Boot + Spring Security + JWT

> Customers: register, login, view balance, transfer money, check transaction history.
> Admin: view all accounts, freeze / unfreeze an account.

**Stack:** Java 17, Spring Boot 3.3, Spring Security, JWT (jjwt 0.12.6), Spring Data JPA, MySQL, Postman

## 📁 Project Structure (Output Structure)
```
banking-app/
├── pom.xml
├── README.md
├── README_SETUP.md
├── README_API.md
├── README_SECURITY.md
├── README_INTERVIEW.md
├── postman_collection.json
├── src/main/java/com/vignesh/banking/
│   ├── BankingApplication.java
│   ├── controller/
│   │   ├── AuthController.java
│   │   ├── AccountController.java
│   │   └── AdminController.java
│   ├── service/
│   │   ├── AuthService.java
│   │   ├── BankingService.java
│   │   └── AdminService.java
│   ├── security/
│   │   ├── SecurityConfig.java
│   │   ├── JwtService.java
│   │   ├── JwtAuthFilter.java
│   │   └── CustomUserDetailsService.java
│   ├── model/
│   │   ├── User.java
│   │   ├── Account.java
│   │   ├── Transaction.java
│   │   └── Role.java
│   ├── repository/
│   │   ├── UserRepository.java
│   │   ├── AccountRepository.java
│   │   └── TransactionRepository.java
│   └── dto/
│       ├── AuthRequest.java
│       ├── AuthResponse.java
│       └── TransferRequest.java
└── src/main/resources/
    └── application.properties
```

## 🚀 Quick Start
See **README_SETUP.md** for full setup.

```bash
# 1. Create DB (or let Hibernate create it)
mysql -u root -p -e "CREATE DATABASE banking_db;"

# 2. Update src/main/resources/application.properties
#    spring.datasource.username / password / app.jwt.secret

# 3. Run
mvn spring-boot:run
# App runs on http://localhost:8080
```

## 🔌 API
See **README_API.md** + `postman_collection.json` for all endpoints + sample outputs.

## 🔐 Security
See **README_SECURITY.md** for JWT flow, RBAC, BCrypt, @Transactional.

## 🎤 Interview
See **README_INTERVIEW.md** for the 10 questions recruiters ask on this project.
