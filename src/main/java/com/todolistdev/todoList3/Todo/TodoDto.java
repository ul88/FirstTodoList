package com.todolistdev.todoList3.Todo;

public class TodoDto {
    private Long id;
    private String userId;
    private String content;
    private boolean done;

    public TodoDto(){

    }

    public TodoDto(Long id, String name, String content, boolean done) {
        this.id = id;
        this.userId = name;
        this.content = content;
        this.done = done;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return userId;
    }

    public void setName(String name) {
        this.userId = name;
    }

    public String getContent() {
        return content;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
