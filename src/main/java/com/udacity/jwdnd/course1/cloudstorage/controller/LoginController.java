package com.udacity.jwdnd.course1.cloudstorage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {



    @GetMapping()
    public String loginView() {
        return "login";
    }

//    @GetMapping("/signup")
//    public String getSignUp(){
//        return "signup";
//    }
//    public String getLoginPage(@ModelAttribute("newLogin") LoginForm newLogin, Model model) {
////            model.addAttribute("greetings", this.messageListService.getMessages());
//
//        return "login";
//    }
//
//    @PostMapping("/login")
//    public String addMessage(@ModelAttribute("newLogin") LoginForm loginForm, Model model) {
//        loginFormService.addUsername(loginForm.getUsername());
//        loginFormService.addPassword(loginForm.getPassword());
////        model.addAttribute("greetings", messageListService.getMessages());
//        loginForm.setUsername("");
//        loginForm.setPassword("");
//        return "login";
//    }
}
