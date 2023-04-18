package com.sarthak.todoappbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Todo {

    private Long id;

    private String taskDescription;

    private String taskType;

}
