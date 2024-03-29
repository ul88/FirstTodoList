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
    private final ContentRepository contentRepository;
    public TodoService(TodoBoardRepository todoBoardRepository, ContentRepository contentRepository) {
        this.todoBoardRepository = todoBoardRepository;
        this.contentRepository = contentRepository;
    }

    public List<ContentDto> readAll(String userId) {
        TodoBoard todoBoard = todoBoardRepository.findByUserId(userId);
        if(todoBoard == null){
            return null;
        }
        List<ContentDto> contentDtoList = new ArrayList<>();
        for(ContentBoard iter : todoBoard.contentBoardList){
            contentDtoList.add(ContentDto.toDto(iter));
        }
        return contentDtoList;
    }

    public void addTodo(String userId, String content){
        TodoBoard todoBoard;
        if(todoBoardRepository.findByUserId(userId) == null){
            todoBoard = TodoBoard.builder()
                    .userId(userId)
                    .contentBoardList(new ArrayList<>())
                    .build();
            todoBoardRepository.save(todoBoard);
        }else{
            todoBoard = todoBoardRepository.findByUserId(userId);
        }


        ContentBoard contentBoard = ContentBoard.builder()
                .todo(todoBoard)
                .content(content)
                .done(false)
                .build();

        contentRepository.save(contentBoard);
    }

    @Transactional
    public void updateTodo(Long id){
        ContentBoard contentBoard = contentRepository.findById(id).orElse(null);
        if(contentBoard != null){
            contentRepository.save(contentBoard.toBuilder()
                            .done(!contentBoard.getDone())
                    .build());
        }
    }
    public void deleteTodo(Long id) {
        ContentBoard contentBoard = contentRepository.findById(id).orElse(null);
        if(contentBoard != null){
            contentRepository.delete(contentBoard);
        }
    }
}
