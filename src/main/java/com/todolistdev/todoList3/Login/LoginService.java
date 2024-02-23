package com.todolistdev.todoList3.Login;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public boolean checkLogin(String userId, String userPw){
        return userId.equals("admin") && userPw.equals("1234");
    }

}
