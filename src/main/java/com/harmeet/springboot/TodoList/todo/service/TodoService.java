package com.harmeet.springboot.TodoList.todo.service;

import com.harmeet.springboot.TodoList.todo.model.Todo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    private static int todosCount=0;

    static {
        todos.add(new Todo(++todosCount, "harmeet", "Learn AWS", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todosCount, "harmeet", "Learn GCP", LocalDate.now().plusYears(2), false));
        todos.add(new Todo(++todosCount, "harmeet", "Learn Azure", LocalDate.now().plusYears(3), false));
    }

    public List<Todo> findByUserName(String username) {
        return todos;
    }

    public void addTodo(String username,String description,LocalDate targetDate,boolean done){
        Todo todo=new Todo(++todosCount,username,description,targetDate,done);
        todos.add(todo);
    }
}
