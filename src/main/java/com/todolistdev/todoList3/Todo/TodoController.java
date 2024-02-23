package com.todolistdev.todoList3.Todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("todo")
    public String home(Model model){
//        model.addAttribute("userId",userId);
        model.addAttribute("todoDto", new TodoDto());
        model.addAttribute("todoList",todoService.readAll());
        return "todoPage";

    }

    @PostMapping("add-todo")
    public String add(@RequestParam String content,
                      Model model){
        todoService.addTodo(content);
        return "redirect:/todo";
    }
}
