package com.example.SpringSecurityJWT.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/sign-in")
    public String signIn(Model model) {
        return "signIn";
    }
}
