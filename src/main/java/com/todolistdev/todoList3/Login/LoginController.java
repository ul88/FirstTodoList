package com.todolistdev.todoList3.Login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("loginDto",new LoginDto());
        return "login";
    }

    @PostMapping("login-check")
    public String checkLogin(@RequestParam String userId,
                             @RequestParam String userPw,
                             RedirectAttributes re) {

        if (loginService.checkLogin(userId, userPw)) {

            re.addAttribute("userId", userId);
            return "redirect:/todo";
        }
        return "redirect:/";
    }

    @PostMapping("sign-up-page")
    public String gotoSignUpPage(Model model){
        model.addAttribute("loginDto", new LoginDto());
        return "signUpPage";
    }

    @PostMapping("sign-up-page/sign-up")
    public String signUp(@RequestParam String userId,
                         @RequestParam String userPw){
        System.out.println("1: "+userId +" "+userPw);
        loginService.signUp(userId,userPw);
        System.out.println("2: "+userId +" "+userPw);
        return "redirect:/";
    }

}
