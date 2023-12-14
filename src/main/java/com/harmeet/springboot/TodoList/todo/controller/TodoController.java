package com.harmeet.springboot.TodoList.todo.controller;

import com.harmeet.springboot.TodoList.todo.model.Todo;
import com.harmeet.springboot.TodoList.todo.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
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

    @RequestMapping(value="add-todo",method = RequestMethod.GET)
    public String showNewTodo() {
        return "todo";
    }
    @RequestMapping(value="add-todo",method = RequestMethod.POST)
    public String addNewTodo(@RequestParam String description, ModelMap model) {
        String name=(String)model.get("name");
        todoService.addTodo(name,description, LocalDate.now().plusYears(1),false);
        return "redirect:list-todos";
    }
}
