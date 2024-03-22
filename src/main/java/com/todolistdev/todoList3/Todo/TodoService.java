package com.todolistdev.todoList3.Todo;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TodoService {
    private final TodoBoardRepository todoBoardRepository;

    public TodoService(TodoBoardRepository todoBoardRepository) {
        this.todoBoardRepository = todoBoardRepository;
    }

    public List<TodoDto> readAll(String userId) {
        List<TodoBoard> todoBoardList = todoBoardRepository.findAll();
        List<TodoDto> todoList = new ArrayList<>();

        for(TodoBoard todoBoard : todoBoardList){
            if(todoBoard.getUserId().equals(userId)){
                todoList.add(new TodoDto(todoBoard.getId(), todoBoard.getUserId(), todoBoard.getContent(), todoBoard.getDone()));
            }
        }
        return todoList;
    }

    public void addTodo(String userId, String content){
        todoBoardRepository.save(TodoBoard.builder()
                        .userId(userId)
                        .content(content)
                        .done(false)
                        .build());
    }

    @Transactional
    public void updateTodo(Long id){
        TodoBoard todoBoard = todoBoardRepository.findById(id).orElse(null);
        todoBoard.setDone(!todoBoard.getDone());
        todoBoardRepository.save(todoBoard);
    }
    public void deleteTodo(Long id) {
        TodoBoard todoBoard = todoBoardRepository.findById(id).orElse(null);
        if(todoBoard != null){
            todoBoardRepository.delete(todoBoard);
        }
    }
}
