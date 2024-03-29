package com.todolistdev.todoList3.Todo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder(toBuilder = true)
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContentBoard {
    @Id
    @GeneratedValue
    private Long id;
    private String content;
    private Boolean done;
    @ManyToOne
    @JoinColumn(name="todo_id")
    private TodoBoard todo;
}
