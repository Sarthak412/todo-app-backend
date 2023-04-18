package com.sarthak.todoappbackend.services;

import com.sarthak.todoappbackend.model.Todo;

import java.util.List;

public interface TodoServices {
    Todo addTodo(Todo todo);

    List<Todo> getAllTasks();

    boolean deleteTask(Long id);

    Todo getTasksById(Long id);

    Todo editTask(Long id, Todo todo);
}
