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

---

## ⚙️ Getting Started

1. **Clone the repo**

```bash
git clone https://github.com/your-username/smart-expense-tracker.git
cd smart-expense-tracker
