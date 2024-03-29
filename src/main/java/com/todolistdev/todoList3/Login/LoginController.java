package com.todolistdev.todoList3.Login;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
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
    public String checkLogin(LoginDto loginDto,
                             RedirectAttributes re) {
        if (loginService.checkLogin(loginDto.getUserId(), loginDto.getUserPw())) {
            re.addAttribute("userId", loginDto.getUserId());
            return "redirect:/todo/{userId}";
        }
        return "redirect:/";
    }

    @PostMapping("sign-up-page")
    public String gotoSignUpPage(Model model){
        model.addAttribute("loginDto", new LoginDto());
        return "signUpPage";
    }

    @PostMapping("sign-up-page/sign-up")
    public String signUp(LoginDto loginDto){
        log.debug("userId={} userPw={}",loginDto.getUserId(),loginDto.getUserPw());
        loginService.signUp(loginDto.getUserId(),loginDto.getUserPw());
        return "redirect:/";
    }

}
