package com.todolistdev.todoList3.Login;

public class LoginDto {
    private Long id;
    private String userId;
    private String userPw;

    public LoginDto(){

    }

    public LoginDto(Long id, String userId, String userPw) {
        this.id = id;
        this.userId = userId;
        this.userPw = userPw;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }
}
