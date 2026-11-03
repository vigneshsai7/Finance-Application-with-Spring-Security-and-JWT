# README_INTERVIEW — What to Say in Interviews

Q1. How does JWT work here?
> Login -> server validates BCrypt password -> issues signed JWT (email + role + expiry) -> client sends it as Bearer token -> JwtAuthFilter validates signature + expiry -> SecurityContext set -> request allowed/denied.

Q2. How do you stop a CUSTOMER freezing an account?
> Two layers: SecurityConfig blocks /api/admin/** for non-ADMIN, and transfer() checks ownership. Even with a valid token, a CUSTOMER gets 403 on admin APIs.

Q3. What if transfer fails halfway?
> @Transactional — debit, credit, and transaction record are one atomic unit. Any exception rolls everything back.

Q4. Why BCrypt, not MD5 / plain?
> BCrypt is slow + salted, so rainbow-table / brute-force attacks are expensive. MD5 is fast and broken.

Q5. Why stateless, no sessions?
> JWT is stateless — no server session to store, scales horizontally, works for microservices / mobile.

Q6. How did you handle concurrent transfers?
> @Transactional + DB row handling; in production add optimistic locking (@Version) or pessimistic lock. Mention this as next improvement.

Q7. What would you add next?
> Refresh tokens, @Version optimistic locking, Kafka for transaction notifications, React frontend, unit tests (JUnit + Mockito), Docker + AWS deploy.

## Demo Script (2 minutes)
1. Register CUSTOMER + ADMIN in Postman
2. Login CUSTOMER -> My Accounts -> Transfer 100 -> History shows TRANSFER
3. Login ADMIN -> All Accounts -> Freeze -> Try transfer as CUSTOMER -> fails -> Unfreeze -> works
