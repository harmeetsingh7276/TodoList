package com.harmeet.springboot.TodoList.todo.service;

import com.harmeet.springboot.TodoList.todo.model.Todo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();

    static {
        todos.add(new Todo(1, "harmeet", "Learn AWS", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(2, "harmeet", "Learn GCP", LocalDate.now().plusYears(2), false));
        todos.add(new Todo(1, "harmeet", "Learn Azure", LocalDate.now().plusYears(3), false));
    }

    public List<Todo> findByUserName(String username) {
        return todos;
    }
}
