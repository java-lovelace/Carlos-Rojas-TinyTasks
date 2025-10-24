const API_URL = "http://localhost:8080/api/todos";

const taskList = document.getElementById("taskList");
const addBtn = document.getElementById("addBtn");
const taskInput = document.getElementById("taskInput");
const errorMsg = document.getElementById("errorMsg");

async function loadTodos() {
    const res = await fetch(API_URL);
    const todos = await res.json();
    renderTodos(todos);
}

function renderTodos(todos) {
    taskList.innerHTML = "";
    todos.forEach(todo => {
        const li = document.createElement("li");
        li.className = "list-group-item d-flex justify-content-between align-items-center";
        li.innerHTML = `
      <span class="${todo.done ? 'text-decoration-line-through text-success' : ''}">
        ${todo.title}
      </span>
      <div>
        <button class="btn btn-sm btn-outline-success me-2" onclick="toggleTodo(${todo.id})">Toggle</button>
        <button class="btn btn-sm btn-outline-danger" onclick="deleteTodo(${todo.id})">Delete</button>
      </div>
    `;
        taskList.appendChild(li);
    });
}

addBtn.addEventListener("click", async () => {
    const title = taskInput.value.trim();
    errorMsg.style.display = "none";

    if (!title) {
        errorMsg.textContent = "Title is required";
        errorMsg.style.display = "block";
        return;
    }

    try {
        const res = await fetch(API_URL, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ title })
        });

        if (res.ok) {
            taskInput.value = "";
            loadTodos();
        } else {
            const data = await res.json();
            errorMsg.textContent = data.error || "Error creating task";
            errorMsg.style.display = "block";
        }
    } catch (err) {
        errorMsg.textContent = "Network error";
        errorMsg.style.display = "block";
    }
});

async function toggleTodo(id) {
    const res = await fetch(`${API_URL}/${id}/toggle`, { method: "PUT" });
    if (res.ok) {
        loadTodos();
    } else {
        alert("Error: Task not found");
    }
}

async function deleteTodo(id) {
    const res = await fetch(`${API_URL}/${id}`, { method: "DELETE" });
    if (res.ok) {
        loadTodos();
    } else {
        alert("Error: Task not found");
    }
}

loadTodos();