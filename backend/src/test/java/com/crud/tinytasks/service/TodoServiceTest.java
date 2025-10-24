package com.crud.tinytasks.service;

import com.crud.tinytasks.model.Todo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TodoServiceTest {

    private TodoService service;

    @BeforeEach
    void setUp() {
        service = new TodoService();
    }

    @Test
    void createTodo_shouldCreateValidTask() {
        Todo created = service.createTodo("Learn Spring Boot");

        assertNotNull(created);
        assertEquals("Learn Spring Boot", created.getTitle());
        assertFalse(created.isDone());
    }

    @Test
    void createTodo_shouldThrowWhenTitleIsInvalid() {
        assertThrows(IllegalArgumentException.class, () -> service.createTodo("  "));
        assertThrows(IllegalArgumentException.class, () -> service.createTodo("ab"));
    }

    @Test
    void toggleTodo_shouldChangeState() {
        Todo created = service.createTodo("Toggle Test");
        boolean initial = created.isDone();

        Optional<Todo> toggled = service.toggleTodo(created.getId());
        assertTrue(toggled.isPresent());
        assertNotEquals(initial, toggled.get().isDone());
    }

    @Test
    void toggleTodo_shouldReturnEmptyIfNotFound() {
        Optional<Todo> result = service.toggleTodo(999);
        assertTrue(result.isEmpty());
    }

    @Test
    void deleteTodo_shouldRemoveTask() {
        Todo created = service.createTodo("Delete me");
        boolean deleted = service.deleteTodo(created.getId());
        assertTrue(deleted);

        List<Todo> all = service.getAllTodos();
        assertTrue(all.isEmpty());
    }

    @Test
    void deleteTodo_shouldReturnFalseIfNotFound() {
        boolean result = service.deleteTodo(999);
        assertFalse(result);
    }
}