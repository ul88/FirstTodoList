package com.todolistdev.todoList3.Login;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    private Long id;
    private String userId;
    private String userPw;
}
