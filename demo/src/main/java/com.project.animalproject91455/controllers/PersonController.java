package com.project.animalproject91455.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PersonController {

    @RequestMapping("/books")
    public String temp(Model model) {
        model.addAttribute("something", "this is coming from animal controller");
        return "books/list";
    }
}

