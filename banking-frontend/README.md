# Banking Frontend — React
Dashboard / My Accounts / Send Money / Transactions / Admin — from the diagram.

## Run
```bash
cd banking-frontend
npm install
npm run dev   # http://localhost:5173
# Backend must be running: mvn spring-boot:run  (http://localhost:8080)
```
## How it connects
- `src/api.js` — fetch wrapper, adds `Authorization: Bearer <token>` from localStorage
- Login/Register -> saves token + role -> Dashboard
- CUSTOMER sees: Dashboard, Accounts, Send Money, Transactions
- ADMIN sees: + Admin panel (All Accounts, Freeze / Unfreeze)

## Pages / Files
```
banking-frontend/
├── package.json, vite.config.js, index.html
└── src/
    ├── main.jsx, App.jsx, api.js, styles.css
    └── pages/
        ├── Login.jsx, Register.jsx, Dashboard.jsx
        ├── Accounts.jsx, Transfer.jsx, Transactions.jsx, Admin.jsx
```
