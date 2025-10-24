# 🧩 TinyTasks

TinyTasks is a small full-stack project built to practice a clean and minimal CRUD application using **Spring Boot (Java 21)** for the backend and **HTML + JavaScript + Bootstrap** for the frontend.
It demonstrates the complete flow: 

```text
┌────────────┐        ┌──────────────┐        ┌────────────┐        ┌────────────────┐
│  Frontend  │  --->  │   REST API   │  --->  │   Service  │  --->  │  Repository    │
│ (HTML/JS)  │        │ (Controller) │        │  (Logic)   │        │ (In-memory)    │
└────────────┘        └──────────────┘        └────────────┘        └────────────────┘
```

---

## 🚀 Features

- List all todos
- Create a new todo
- Toggle completion state
- Delete a todo
- In-memory data (no database required)
- Unit tests for service and repository layers

---

## 🧠 Tech Stack

**Backend**
- Java 21
- Spring Boot 3
- JUnit 5

**Frontend**
- HTML, CSS, JavaScript
- Bootstrap 5
- Served locally with VSCode Live Server

---

## 📁 Project Structure
```bash
tinytasks/
├─ backend/
│  └─ src/main/java/com/crud/tinytasks/
│     ├─ config/
│     │  └─ CorsConfig.java
│     ├─ controller/
│     │  └─ TodoController.java
│     ├─ model/
│     │  └─ Todo.java
│     ├─ repository/
│     │  └─ TodoRepository.java
│     ├─ service/
│     │  └─ TodoService.java
│     └─ TinytasksApplication.java
│
│  └─ src/test/java/com/crud/tinytasks/
│     ├─ repository/
│     │  └─ TodoRepositoryTest.java
│     └─ service/
│        └─ TodoServiceTest.java
│
├─ frontend/
│  ├─ index.html
│  ├─ app.js
└─ README.md
```

---

## 🌐 REST API Endpoints

| Method | Endpoint | Description |
|:-------|:----------|:-------------|
| GET | `/api/todos` | Get all todos |
| POST | `/api/todos` | Create a new todo |
| PUT | `/api/todos/{id}/toggle` | Toggle a todo's done state |
| DELETE | `/api/todos/{id}` | Delete a todo |

### ✅ Example Response
```json
{
  "id": 1,
  "title": "Learn Spring Boot",
  "done": false
}
```

### ❌ Error Responses
```json
400 → { "error": "Title is required and must be at least 3 characters long" }
404 → { "error": "Not found" }
```

---

## ⚙️ Running the App

### 🖥️ Backend

1. Open the project in **IntelliJ IDEA** (or your preferred IDE).
2. Run the main class:
```bash
TinytasksApplication.java
```
3. The API will be available at:  
   👉 [http://localhost:8080](http://localhost:8080)

### 💻 Frontend

1. Open the `frontend/` folder in **VSCode**.
2. Start **Live Server** (or any local web server).
3. Visit:  
   👉 [http://localhost:5500](http://localhost:5500)

---

## 🧪 Running Unit Tests

You don’t need the server running — tests run independently in memory.

### In IntelliJ IDEA:
Right-click on the `test` folder → **Run 'All Tests'**

### Or via command line:
```bash
mvn test
```

✅ **All tests validate the repository and service logic:**

- ID generation and retrieval
- Validation on creation
- Toggle and delete behavior
- Error handling for non-existent items

---

## 🔒 CORS Configuration

The backend allows requests only from:  
👉 [http://localhost:5500](http://localhost:5500)

*(defined in `CorsConfig.java`)*

---

## 📄 License

This project was created for educational and learning purposes.  
You are free to use, modify, and distribute it under the terms described in the [LICENSE](./LICENSE).
