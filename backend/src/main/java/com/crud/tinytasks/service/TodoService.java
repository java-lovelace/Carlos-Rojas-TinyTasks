package com.crud.tinytasks.service;

import com.crud.tinytasks.model.Todo;
import com.crud.tinytasks.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository repository;

    public TodoService() {
        this.repository = new TodoRepository();
    }

    public List<Todo> getAllTodos() {
        return repository.findAll();
    }

    public Todo createTodo(String title) {
        if (title == null || title.trim().length() < 3) {
            throw new IllegalArgumentException("Title is required and must be at least 3 characters long");
        }
        return repository.create(title.trim());
    }

    public Optional<Todo> toggleTodo(int id) {
        return repository.toggle(id);
    }

    public boolean deleteTodo(int id) {
        return repository.delete(id);
    }
}