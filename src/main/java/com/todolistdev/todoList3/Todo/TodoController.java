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

    @RequestMapping("/todo/{userId}")
    public String home(Model model,
                       @PathVariable("userId") String userId){
        model.addAttribute("userId",userId);
        model.addAttribute("contentDto", new ContentDto());
        model.addAttribute("todoList",todoService.readAll(userId));
        return "todoPage";
    }

    @RequestMapping("/todo/{userId}/add-todo")
    public String add(@PathVariable String userId,
                      @RequestParam String content,
                      Model model){

        model.addAttribute("userId",userId);
        todoService.addTodo(userId, content);

        return "redirect:/todo/{userId}";
    }

    @PostMapping("/todo/{userId}/update-todo/{id}")
    public String update(@PathVariable String userId,
                         @PathVariable Long id,
                         Model model){
        model.addAttribute("userId", userId);
        todoService.updateTodo(id);

        return "redirect:/todo/{userId}";
    }

    @PostMapping("/todo/{userId}/delete-todo/{id}")
    public String delete(@PathVariable String userId,
                         @PathVariable Long id,
                         Model model){
        log.info("{} {}",userId,id);
        model.addAttribute("userId",userId);
        todoService.deleteTodo(id);
        return "redirect:/todo/{userId}";
    }

}
