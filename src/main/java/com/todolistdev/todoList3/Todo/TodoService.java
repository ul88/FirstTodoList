package com.todolistdev.todoList3.Todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private List<TodoDto> todoList = new ArrayList<>();
    private Long id = 0L;

    public void addTodo(String content){
        todoList.add(new TodoDto(id++,"admin",content,false));
    }

    public List<TodoDto> readAll() {
        return todoList;
    }
}
