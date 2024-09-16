package com.example.demo.controller2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/subjects")
public class HomeController {

    @GetMapping("/index")
    public String index() {
        return "subjects/index";
    }
    @GetMapping("/categories")
    public String categories() {
      return "subjects/categories";
    };
}
