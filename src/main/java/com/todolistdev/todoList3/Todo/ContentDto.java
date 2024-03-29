package com.todolistdev.todoList3.Todo;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ContentDto {
    private Long id;
    private String content;
    private Boolean done;

    public static ContentDto toDto(ContentBoard contentBoard){
        return ContentDto.builder()
                .id(contentBoard.getId())
                .done(contentBoard.getDone())
                .content(contentBoard.getContent())
                .build();
    }
}
