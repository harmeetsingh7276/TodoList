package com.harmeet.springboot.TodoList.todo.controller;

import com.harmeet.springboot.TodoList.todo.model.Todo;
import com.harmeet.springboot.TodoList.todo.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        super();
        this.todoService = todoService;
    }

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model) {
        List<Todo> todos = todoService.findByUserName("harmeet");
        model.addAttribute("todos", todos);
        return "listTodos";
    }
}
