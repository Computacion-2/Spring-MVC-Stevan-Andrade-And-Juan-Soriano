package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.interf.IUserService;

import lombok.RequiredArgsConstructor;

@Controller 
@RequestMapping("/app/users")
@RequiredArgsConstructor 
public class UserMVCController {

    private final IUserService userService;
    
    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("userList", userService.findAll());
        //Sori here must be security logic
        return "users/users-list";
    }

}
