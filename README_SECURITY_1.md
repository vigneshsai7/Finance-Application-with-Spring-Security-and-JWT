# README_SECURITY — How Security Works

## Flow (matches the diagram)
```
User (Customer / Admin / Staff)
  -> JWT Authentication (login -> token)
  -> Spring Security (Authentication + Authorization)
  -> Protected APIs (Account / Transaction / User / Admin API)
  -> Backend Services (AccountService / TransactionService / UserService / NotificationService)
  -> Database MySQL (User / Account / Transaction / Audit Logs)
```

## JWT Flow
1. `POST /api/auth/login` with email + password
2. `AuthenticationManager` checks password with BCrypt
3. `JwtService.generate()` creates token: `subject=email, claim=role, expiry=24h`
4. Client sends `Authorization: Bearer <token>`
5. `JwtAuthFilter` (OncePerRequestFilter) validates token -> sets SecurityContext with `ROLE_<role>`
6. `SecurityConfig` allows / denies by URL + role

## Role-Based Access (RBAC)
| Role | Can do |
|---|---|
| CUSTOMER | View own accounts, transfer from own account, view own history |
| ADMIN | All above + view ALL accounts, freeze / unfreeze any account |
| STAFF | Same as CUSTOMER (extendable) |

Rules enforced in 2 places:
- `SecurityConfig`: `/api/admin/**` requires `ROLE_ADMIN`
- `BankingService.transfer()`: `fromAccount.owner.email == logged-in email`

## Transaction Handling — @Transactional
`BankingService.transfer()` is `@Transactional`:
- Debit sender + Credit receiver + Save Transaction record
- If ANY step fails (e.g. insufficient balance, frozen, crash), ALL roll back.
- This keeps balances consistent — no money lost / created.

## Passwords
- Stored as BCrypt hash, never plain text.
- Never returned in any API response.
