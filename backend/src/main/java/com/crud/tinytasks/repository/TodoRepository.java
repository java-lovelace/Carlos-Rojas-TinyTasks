package com.crud.tinytasks.repository;

import com.crud.tinytasks.model.Todo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TodoRepository {

    private final List<Todo> tasks = new ArrayList<>();
    private int nextId = 1;

    public List<Todo> findAll() {
        return tasks;
    }

    public Optional<Todo> findById(int id) {
        return tasks.stream()
                .filter(task -> task.getId() == id)
                .findFirst();
    }

    public Todo create(String title) {
        Todo task = new Todo(nextId++, title, false);
        tasks.add(task);
        return task;
    }

    public Optional<Todo> toggle(int id) {
        Optional<Todo> taskOpt = findById(id);
        taskOpt.ifPresent(task -> task.setDone(!task.isDone()));
        return taskOpt;
    }

    public boolean delete(int id) {
        return tasks.removeIf(task -> task.getId() == id);
    }
}