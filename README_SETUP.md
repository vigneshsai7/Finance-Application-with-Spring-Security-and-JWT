# README_SETUP — How to Run

## Prerequisites
- Java 17+
- Maven 3.8+
- MySQL 8 running on localhost:3306
- Postman (optional, collection included)

## 1. Database
```sql
CREATE DATABASE banking_db;
```
Or skip this — `createDatabaseIfNotExist=true` in `application.properties` creates it.

## 2. Configure
Edit `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/banking_db?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true
spring.datasource.username=root
spring.datasource.password=root
app.jwt.secret=CHANGE-THIS-TO-A-LONG-RANDOM-SECRET-AT-LEAST-32-CHARS
app.jwt.expiration-ms=86400000
```

## 3. Run
```bash
mvn clean install
mvn spring-boot:run
```

Expected output:
```
Started BankingApplication in 3.2 seconds
Tomcat started on port 8080
```

## 4. Test in Postman
Import `postman_collection.json` -> Register -> Login -> copy token ->
Header: `Authorization: Bearer <token>`

## Troubleshooting
| Problem | Fix |
|---|---|
| Access denied for user 'root' | Check MySQL username/password in application.properties |
| Port 8080 already in use | Change `server.port=8081` |
| JWT invalid / 403 | Token expired (24h) or missing `Bearer ` prefix, or role is CUSTOMER trying /api/admin/** |
| Table not created | `spring.jpa.hibernate.ddl-auto=update` must be set, MySQL must be running |
