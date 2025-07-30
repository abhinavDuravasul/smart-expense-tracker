# 💸 Smart Expense Tracker API

A simple Java-based backend REST API to track daily expenses by category, with features like monthly summaries, JWT authentication, and PostgreSQL database integration. Ideal for personal use and demonstration in job interviews.

---

## 📌 Features

- ✅ Add, update, delete expenses
- ✅ Track expenses by category (food, travel, shopping, etc.)
- ✅ View total and monthly summaries
- ✅ Secure endpoints with JWT authentication
- ✅ Scheduled job to auto-generate monthly reports
- ✅ PostgreSQL database integration
- ✅ Clean REST API structure (Controller → Service → Repository)

---

## 🧑‍💻 Tech Stack

| Layer         | Technology           |
|---------------|----------------------|
| Language      | Java 21              |
| Framework     | Spring Boot 3.x      |
| ORM           | Spring Data JPA      |
| Security      | Spring Security + JWT |
| Database      | PostgreSQL           |
| Scheduler     | Spring `@Scheduled`  |
| Build Tool    | Gradle       |
| IDE           | IntelliJ IDEA        |

---

## 🔐 Authentication

This project uses JWT (JSON Web Token) to secure endpoints.  
You must log in and obtain a valid token, then include it in the `Authorization` header as:


---

## 📄 API Endpoints (Sample)

| Method | Endpoint             | Description             |
|--------|----------------------|-------------------------|
| POST   | `/api/auth/login`    | Authenticate & get token |
| POST   | `/api/expenses`      | Add a new expense       |
| GET    | `/api/expenses`      | Get all expenses        |
| GET    | `/api/summary/monthly` | Monthly report summary |
| DELETE | `/api/expenses/{id}` | Delete an expense       |


Step	Action	Endpoint	Output
1	Add a new expense	POST /api/expenses	Expense saved in DB
2	View all expenses	GET /api/expenses	List of all user expenses
3	Delete an expense	DELETE /api/expenses/{id}	Expense removed
4	Get monthly summary	GET /api/summary/monthly	Total spent per month
5	Scheduled monthly auto-summary	(internal @Scheduled)	Report generated monthly
---

## ⚙️ Getting Started

1. **Clone the repo**

```bash
git clone https://github.com/your-username/smart-expense-tracker.git
cd smart-expense-tracker


🧾 Smart Expense Tracker – Core Functional Flow
1. User Creates an Expense
The user sends a POST request to /api/expenses with details like:

category (e.g., food, travel, shopping)

amount (e.g., 500.00)

description (optional)

date (e.g., 2025-07-30)

✅ This expense is saved in the database, associated with the user.

2. User Views All Expenses
The user sends a GET request to /api/expenses

The system retrieves all expenses stored for that user, ordered by date (optional)

✅ This helps the user see all their expenses in one list.

3. User Deletes an Expense
The user sends a DELETE request to /api/expenses/{id}

The system finds and deletes that expense (if it belongs to the user)

✅ Used to clean up accidental or old records.

4. User Views Monthly Summary
The user sends a GET request to /api/summary/monthly

The system:

Groups expenses by month and year

Aggregates the total spending for each month

Optionally breaks it down by category

✅ Helps the user analyze spending patterns over time.

5. Automated Monthly Report (Optional Feature)
A scheduled job runs on the 1st of every month.

It:

Aggregates the total expenses for the previous month

Sends a summary to the user (could be email or just logs for now)

✅ Automates reporting without user needing to request it manually.

🧩 Flow Summary
Step	Action	Endpoint	Output
1	Add a new expense	POST /api/expenses	Expense saved in DB
2	View all expenses	GET /api/expenses	List of all user expenses
3	Delete an expense	DELETE /api/expenses/{id}	Expense removed
4	Get monthly summary	GET /api/summary/monthly	Total spent per month
5	Scheduled monthly auto-summary	(internal @Scheduled)	Report generated monthly

Let me know if you want a visual flowchart or database diagram too.








You said:
Let me know if you want a visual flowchart or database diagram too.


ChatGPT said:
Great! Since you're working on the expense part now, here are two helpful visual aids you can use:

📊 1. Visual Flowchart – Smart Expense Flow (excluding authentication)
plaintext
Copy
Edit
┌───────────────┐
│ Start (User)  │
└──────┬────────┘
       │
       ▼
┌──────────────────────────────┐
│  Add Expense (POST /expenses)│
│  - Category                  │
│  - Amount                    │
│  - Date                      │
└──────┬───────────────────────┘
       │
       ▼
┌──────────────────────────────┐
│ View All Expenses            │
│ (GET /expenses)              │
└──────┬───────────────────────┘
       │
       ▼
┌──────────────────────────────┐
│ View Monthly Summary         │
│ (GET /summary/monthly)       │
│ - Total/month                │
│ - Per-category (optional)    │
└──────┬───────────────────────┘
       │
       ▼
┌──────────────────────────────┐
│ Delete Expense               │
│ (DELETE /expenses/{id})      │
└──────┬───────────────────────┘
       │
       ▼
┌──────────────────────────────┐
│ Scheduled Monthly Job        │
│ (Runs on 1st each month)     │
│ → Generates report           │
└──────────────────────────────┘
🧩 2. Database Design Diagram
plaintext
Copy
Edit
┌────────────────────────────┐
│          users             │
├──────────────┬─────────────┤
│ id (PK)      │ UUID        │
│ username     │ String      │
│ password     │ String      │
│ email        │ String      │
└──────────────┴─────────────┘

        1 ────────┐
                 │
                 ▼

┌────────────────────────────┐
│         expenses           │
├────────────────────────────┤
│ id (PK)        │ UUID      │
│ user_id (FK)   │ UUID      │
│ category       │ String    │
│ amount         │ Decimal   │
│ description    │ String    │
│ date           │ Date      │
└────────────────────────────┘
A user can have many expenses

Each expense belongs to only one user

date is used for filtering and monthly grouping

