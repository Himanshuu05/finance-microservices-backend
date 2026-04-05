# 💰 Finance Microservices Backend

## 🚀 Overview

This project is a **microservices-based backend system** for managing financial records and providing dashboard analytics with role-based access control.

It demonstrates:

* Backend architecture design
* REST API development
* Data modeling with JPA
* Inter-service communication
* Access control & validation

---

## 🧠 Architecture

```text
                ┌────────────────────┐
                │   Eureka Server    │
                │    (Port: 8761)    │
                └─────────┬──────────┘
                          │
     ┌────────────────────┼────────────────────┐
     │                    │                    │
┌──────────────┐  ┌──────────────┐  ┌────────────────┐
│ User Service │  │ Finance      │  │ Dashboard      │
│ (Port 8081)  │  │ Service      │  │ Service        │
│              │  │ (Port 8082)  │  │ (Port 8083)    │
└──────────────┘  └──────────────┘  └────────────────┘
```

---

## ⚙️ Tech Stack

* Java 21
* Spring Boot
* Spring Data JPA
* Spring Cloud (Eureka, OpenFeign)
* PostgreSQL
* Maven

---

## 📦 Services

### 🔹 User Service

* Create and manage users
* Assign roles (ADMIN, ANALYST, VIEWER)
* Mark user status as active or inactive

---

### 🔹 Finance Service

* Create financial records
* Update records
* Delete records
* Filter records (type, category, date)

---

### 🔹 Dashboard Service

* Total income
* Total expense
* Category-wise totals
* Recent activity
* Monthly trends

---

## 🔐 Access Control

Role-based access is implemented using a **filter (middleware)**.

| Role    | Access           |
| ------- | ---------------- |
| VIEWER  | Read-only        |
| ANALYST | Read + analytics |
| ADMIN   | Full CRUD        |

### Header Example:

```text
role: ADMIN
```

---

## ✅ Validation & Error Handling

### Validation

* `@NotNull`
* `@Positive`

### Example Error Response:

```json
{
  "error": "must be greater than 0",
  "status": 400
}
```

### Global Exception Handling

Implemented using `@RestControllerAdvice`.

---

## 🗄️ Database

Each microservice uses its own database:

| Service           | Database   |
| ----------------- | ---------- |
| User Service      | user_db    |
| Finance Service   | finance_db |
| Dashboard Service | No DB      |

---

## 📡 API Endpoints

### Finance Service

* `POST /records` → Create
* `GET /records` → Read
* `PUT /records/{id}` → Update
* `DELETE /records/{id}` → Delete
* `GET /records/filter` → Filter

---

### Dashboard Service

* `GET /dashboard/summary`
* `GET /dashboard/category`
* `GET /dashboard/recent`
* `GET /dashboard/monthly`

---

## 🧪 Sample Request

```json
{
  "amount": 5000,
  "type": "INCOME",
  "category": "Salary",
  "date": "2026-04-03",
  "description": "Monthly salary",
  "userId": 1
}
```

---

## 🚀 How to Run

### 1. Start PostgreSQL

Create databases:

```
users_db
finance_db
```

---

### 2. Run Services (Order)

```
1. Eureka Server
2. User Service
3. Finance Service
4. Dashboard Service
```

---

### 3. Open Eureka Dashboard

```
http://localhost:8761
```

---

## 📌 Assumptions

* Role is passed via request header (no JWT for simplicity)
* Services are independently deployable
* Finance Service stores only `userId` (no direct relation with User entity)

---

## 🔥 Key Features

* Microservices architecture
* Service discovery using Eureka
* Feign-based communication
* Role-based access control
* Input validation & error handling
* Clean and scalable design

---

## 🚀 Future Improvements

* JWT Authentication
* API Gateway
* Pagination
* Swagger documentation
* Unit testing

---

## 👨‍💻 Author

**Himanshu Paswan**

---

## ⭐ Conclusion

This project demonstrates a **scalable backend architecture** with proper separation of concerns, making it suitable for real-world applications and backend engineering roles.

---
