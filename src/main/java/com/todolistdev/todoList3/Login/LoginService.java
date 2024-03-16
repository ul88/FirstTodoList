package com.todolistdev.todoList3.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

@Service
public class LoginService {
    private final BoardRepository boardRepository;
    public LoginService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public boolean checkLogin(String userId, String userPw){
        return userId.equals(boardRepository.findByUserId(userId).getUserId())
                && userPw.equals(boardRepository.findByUserId(userId).getUserPw());
    }

    public void signUp(String userId, String userPw){

        boardRepository.save(Board.builder()
                .userId(userId)
                .userPw(userPw)
                .build());
    }
    
}
