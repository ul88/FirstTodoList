package com.todolistdev.todoList3.Todo;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Builder(toBuilder = true)
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="todoTable")
public class TodoBoard implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String content;
    private Boolean done;
}
