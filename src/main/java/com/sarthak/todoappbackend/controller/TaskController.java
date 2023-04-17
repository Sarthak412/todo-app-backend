package com.sarthak.todoappbackend.controller;

import com.sarthak.todoappbackend.model.Todo;
import com.sarthak.todoappbackend.services.TodoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/")
public class TaskController {

    @Autowired
    private TodoServices todoServices;

    public TaskController(TodoServices todoServices) {
        this.todoServices = todoServices;
    }

    @PostMapping("/todos")
    public Todo addTodo(@RequestBody Todo todo){
        return todoServices.addTodo(todo);
    }

    @GetMapping("/todos")
    public List<Todo> listAllTasks(){
        return todoServices.getAllTasks();
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteTask(@PathVariable Long id){
        boolean deleted = false;
        deleted = todoServices.deleteTask(id);
        Map<String, Boolean> response = new HashMap<>();

        response.put("deleted", deleted);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<Todo> getTasksById(@PathVariable Long id){
        Todo todo = null;
        todo = todoServices.getTasksById(id);
        return ResponseEntity.ok(todo);
    }

    @PutMapping("/todos/{id}")
    public ResponseEntity<Todo> editTask(@PathVariable Long id, @RequestBody Todo todo){
        todo = todoServices.editTask(id, todo);
        return ResponseEntity.ok(todo);
    }
}
