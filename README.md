# Banking Application — Spring Boot + Spring Security + JWT
Customers: register, login, view balance, transfer money, check transaction history.
Admin: view all accounts, freeze / unfreeze an account.
## Stack
Spring Boot 3.3, Spring Security, JWT (jjwt 0.12.6), Spring Data JPA, MySQL, Postman
## Run
1. Create MySQL DB or let Hibernate create it: `banking_db` — update `src/main/resources/application.properties` (username/password + `app.jwt.secret` — use a long random secret).
2. `mvn spring-boot:run` — runs on http://localhost:8080
## API (Postman)
- POST /api/auth/register {fullName,email,password,role: CUSTOMER|ADMIN} -> {token}
- POST /api/auth/login {email,password} -> {token}
- Header for all below: `Authorization: Bearer <token>`
- GET /api/accounts/me
- POST /api/accounts/transfer {fromAccount,toAccount,amount}
- GET /api/accounts/{id}/transactions?page=0&size=10
- GET /api/admin/accounts (ADMIN only)
- POST /api/admin/accounts/{id}/freeze (ADMIN only)
- POST /api/admin/accounts/{id}/unfreeze (ADMIN only)
## Design notes for interviews
- JWT: login -> token -> JwtAuthFilter validates -> SecurityContext with ROLE_*
- RBAC: SecurityConfig + @EnableMethodSecurity; /api/admin/** requires ADMIN; transfer checks ownership.
- Transfers are @Transactional + atomic: debit + credit + transaction record succeed or roll back together.
- Passwords: BCrypt, never stored plain. New accounts start with 1000 balance for demo.
