package com.sarthak.todoappbackend.services;

import com.sarthak.todoappbackend.entities.todoEntity;
import com.sarthak.todoappbackend.model.Todo;
import com.sarthak.todoappbackend.repository.todoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class todoServiceImpl implements TodoServices{

    private final todoRepository todoRepo;

    public todoServiceImpl(todoRepository todoRepo) {
        this.todoRepo = todoRepo;
    }

    @Override
    public Todo addTodo(Todo todo) {

        todoEntity todo_entity = new todoEntity();

        BeanUtils.copyProperties(todo, todo_entity);

        todoRepo.save(todo_entity);

        return todo;
    }

    @Override
    public List<Todo> getAllTasks() {
        List <todoEntity> todoEntities = todoRepo.findAll();

        List <Todo> todos = todoEntities
                .stream()
                .map(todo -> new Todo(todo.getId(), todo.getTaskDescription(), todo.getTaskType()))
                .toList();

        return todos;
    }

    @Override
    public boolean deleteTask(Long id) {
        todoEntity todo_entity = todoRepo.findById(id).get();
        todoRepo.delete(todo_entity);
        return true;
    }

    @Override
    public Todo getTasksById(Long id) {
        todoEntity todo_entity = todoRepo.findById(id).get();
        Todo todo = new Todo();
        BeanUtils.copyProperties(todo_entity, todo);
        return todo;
    }

    @Override
    public Todo editTask(Long id, Todo todo) {

        todoEntity todo_entity = todoRepo.findById(id).get();

        return null;
    }
}
