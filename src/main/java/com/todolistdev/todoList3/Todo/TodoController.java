package com.todolistdev.todoList3.Todo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
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

    @GetMapping("/todo/add-todo")
    public String add(@RequestParam String content){
        todoService.addTodo(content);

        return "redirect:/todo";
    }

    @PostMapping("/update-todo/{id}")
    public String update(@PathVariable Long id){
        todoService.updateTodo(id);
        return "redirect:/todo";
    }

    @PostMapping("/delete-todo/{id}")
    public String delete(@PathVariable Long id){
        System.out.println(id);
        todoService.deleteTodo(id);
        return "redirect:/todo";
    }

}
