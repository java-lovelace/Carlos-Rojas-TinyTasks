package com.crud.tinytasks.repository;

import com.crud.tinytasks.model.Todo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TodoRepositoryTest {

    private TodoRepository repository;

    @BeforeEach
    void setUp() {
        repository = new TodoRepository();
    }

    @Test
    void create_shouldGenerateIncrementalIds() {
        Todo t1 = repository.create("Task 1");
        Todo t2 = repository.create("Task 2");

        assertEquals(1, t1.getId());
        assertEquals(2, t2.getId());
        assertNotEquals(t1.getId(), t2.getId());
    }

    @Test
    void findById_shouldReturnExistingTask() {
        Todo created = repository.create("Test");
        Optional<Todo> found = repository.findById(created.getId());

        assertTrue(found.isPresent());
        assertEquals(created.getTitle(), found.get().getTitle());
    }

    @Test
    void findById_shouldReturnEmptyIfNotFound() {
        Optional<Todo> result = repository.findById(999);
        assertTrue(result.isEmpty());
    }
}