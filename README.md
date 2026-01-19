# LendFlow – Loan Operations Backend

LendFlow is a backend service that simulates an internal loan operations system similar to those used in financial institutions.  
It demonstrates how loan data, internal notes, and business rules are handled in a modern enterprise backend, I utilized my first hand
experience at Wells Fargo as a Bilingual Representative to simulate this environment.

This project was built to practice real-world backend concepts such as REST APIs, service-layer business logic, and cloud database integration.

---

## 🧠 What This Project Does

LendFlow allows internal systems (or a future frontend) to:

- Create and retrieve loan records
- Update loan interest rates with business rule enforcement
- Update loan status with lifecycle restrictions
- Add internal employee notes to loans
- Retrieve full loan histories, including embedded notes
- Persist all data in a cloud-hosted database

---

## 🏗 Architecture Overview
Client (Postman / Frontend)
↓
REST Controllers (Spring Boot)
↓
Service Layer (Business Rules)
↓
MongoDB Repository
↓
MongoDB Atlas (Cloud Database)

- **Controllers** handle HTTP requests and responses
- **Services** enforce business rules and application logic
- **Repositories** manage database access
- **MongoDB Atlas** stores loan documents and embedded notes

---

## 🛠 Tech Stack

- **Java**
- **Spring Boot**
- **MongoDB Atlas**
- **Spring Data MongoDB**
- **Maven**
- **Postman**
- **Git & GitHub**

---

## 📌 Core Features

### Loan Management
- Create loans with type, amount, interest rate, and status
- Retrieve all loans
- Update interest rates (restricted for delinquent loans)
- Update loan status with lifecycle safeguards

### Internal Notes System
- Add internal employee notes to a loan
- Each note includes:
  - Employee ID
  - Department
  - Category
  - Timestamp
- Notes are embedded directly within loan records

### Business Rules
- Delinquent loans cannot have interest rates modified
- Closed loans cannot be modified
- Status transitions are validated at the service layer
- Rules are enforced server-side (cannot be bypassed by clients)

---

## 🌐 API Endpoints

### Create Loan

### Get All Loans

### Update Interest Rate

### Update Loan Status

### Add Note to Loan

### Get Notes for Loan

---

## 🧪 Testing

All endpoints were tested using **Postman**.  
Data persistence was verified by restarting the application and confirming records remained stored in MongoDB Atlas.

---

## 🔐 Data Persistence

- Uses **MongoDB Atlas** for cloud-based persistence
- Loan records are stored as documents
- Internal notes are stored as embedded sub-documents
- Database is created automatically on first write

---

## 🚀 Why This Project Matters

This project reflects real backend patterns used in enterprise systems:

- Layered architecture
- Separation of concerns
- Cloud database integration
- Business rule enforcement
- RESTful API design

It is intended as a learning and portfolio project rather than a production banking system.

---

## 📎 Versioning

This project is versioned using Git tags.

- **v1.0-lendflow** — Initial stable backend implementation

---

## 👤 Author

**Edgar Colmenero**  
Backend-focused software engineering project built for learning and professional development.


