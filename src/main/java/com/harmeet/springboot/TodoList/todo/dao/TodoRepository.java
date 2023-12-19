package com.harmeet.springboot.TodoList.todo.dao;

import com.harmeet.springboot.TodoList.todo.model.Todo;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Integer> {
    public List<Todo> findByUsername(String name);
}
