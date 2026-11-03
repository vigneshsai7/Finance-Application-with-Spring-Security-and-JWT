# README_API — Endpoints + Sample Output

Base URL: `http://localhost:8080`
Auth header (all except /api/auth/**): `Authorization: Bearer <token>`

## 1. Register — POST /api/auth/register
Request:
```json
{"fullName":"Vignesh Sai","email":"vignesh@test.com","password":"password123","role":"CUSTOMER"}
```
Output:
```json
{"token":"eyJhbGciOiJIUzI1NiJ9...","email":"vignesh@test.com","role":"CUSTOMER"}
```
Note: New account auto-created with balance 1000 (demo).

## 2. Login — POST /api/auth/login
Request:
```json
{"email":"vignesh@test.com","password":"password123"}
```
Output:
```json
{"token":"eyJhbGciOiJIUzI1NiJ9...","email":"vignesh@test.com","role":"CUSTOMER"}
```

## 3. My Accounts — GET /api/accounts/me
Output:
```json
[{"id":1,"accountNumber":"ACCAB12CD34","balance":1000.00,"frozen":false,
  "owner":{"id":1,"email":"vignesh@test.com","fullName":"Vignesh Sai","role":"CUSTOMER"}}]
```

## 4. Transfer — POST /api/accounts/transfer
Request:
```json
{"fromAccount":"ACCAB12CD34","toAccount":"ACCEF56GH78","amount":100}
```
Output:
```
Transfer successful
```
Errors:
- `Insufficient balance` (400)
- `You can only transfer from your own account` (403-style)
- `Account is frozen`
- `Amount must be positive`

## 5. Transaction History — GET /api/accounts/{id}/transactions?page=0&size=10
Output:
```json
{"content":[{"id":1,"fromAccount":"ACCAB12CD34","toAccount":"ACCEF56GH78",
"amount":100,"type":"TRANSFER","createdAt":"2026-11-04T10:15:00"}],
"totalElements":1,"totalPages":1,"size":10,"number":0}
```

## 6. Admin — All Accounts — GET /api/admin/accounts (ADMIN only)
Output: list of all accounts (same shape as #3).

## 7. Admin — Freeze — POST /api/admin/accounts/{id}/freeze (ADMIN only)
Output:
```json
{"id":1,"accountNumber":"ACCAB12CD34","balance":900.00,"frozen":true,"owner":{...}}
```

## 8. Admin — Unfreeze — POST /api/admin/accounts/{id}/unfreeze (ADMIN only)
Output: same, with `"frozen":false`

## Postman
Import `postman_collection.json` — all 6 requests pre-filled.
