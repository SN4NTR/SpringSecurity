package com.example.demo.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/login")
public class LoginController {

    private static final String LOGIN_PAGE_NAME = "login";

    @GetMapping
    public ModelAndView getLoginPage() {
        return new ModelAndView(LOGIN_PAGE_NAME);
    }
}
