package com.harmeet.springboot.TodoList.todo.controller;

import com.harmeet.springboot.TodoList.todo.dao.TodoRepository;
import com.harmeet.springboot.TodoList.todo.model.Todo;
import com.harmeet.springboot.TodoList.todo.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class TodoControllerJpa {
    private TodoService todoService;

    private TodoRepository todoRepository;

    public TodoControllerJpa(TodoService todoService, TodoRepository todoRepository) {
        super();
        this.todoService = todoService;
        this.todoRepository = todoRepository;
    }

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model) {
        String userName = getLoggedInUsername(model);
        List<Todo> todos = todoRepository.findByUsername(userName);
        model.addAttribute("todos", todos);
        return "listTodos";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewTodo(ModelMap model) {
        String name = getLoggedInUsername(model);
        Todo todo = new Todo(0, name, "", LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

        if (result.hasErrors()) {
            return "todo";
        }
        String name = getLoggedInUsername(model);
        todo.setUserName(name);
        todoRepository.save(todo);
//        todoService.addTodo(name, todo.getDescription(), todo.getTargetDate(), todo.isDone());
        return "redirect:list-todos";
    }


    @RequestMapping("delete-todo")
    public String deleteTodos(@RequestParam int id) {
        todoService.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String updateTodos(@RequestParam int id, ModelMap model) {
//        todoService.updateById(id);
        Todo todo = todoService.findById(id);
        model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

        if (result.hasErrors()) {
            return "todo";
        }
        String name = (String) model.get("name");
        todo.setUserName(name);
        todoService.updateTodo(todo);
        return "redirect:list-todos";
    }

    private String getLoggedInUsername(ModelMap model) {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
