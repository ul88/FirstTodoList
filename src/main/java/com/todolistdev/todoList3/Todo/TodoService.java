package com.todolistdev.todoList3.Todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public void updateTodo(Long id){
        todoList.stream().
                filter(s -> s.getId() == id)
                .collect(Collectors.toList())
                .forEach(s -> s.setDone(!s.isDone()) );
    }
    public void deleteTodo(Long id) {
        System.out.println(id);
        todoList.stream().
                filter(s -> s.getId() == id)
                .collect(Collectors.toList())
                .forEach(s -> { todoList.remove(s); } );

        todoList.stream().forEach(s->System.out.println(s.getId() + " " + s.getContent()));
    }
}
