package com.todolistdev.todoList3.Todo;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TodoDto {
    private Long id;
    private String userId;
    private String content;
    private boolean done;

    public static TodoDto toDto(TodoBoard todoBoard){
        return TodoDto.builder()
                .id(todoBoard.getId())
                .userId(todoBoard.getUserId())
                .content(todoBoard.getContent())
                .done(todoBoard.getDone())
                .build();
    }
}
