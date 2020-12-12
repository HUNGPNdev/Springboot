package project1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String getHome() {
        return "home";
    }
    @GetMapping("/")
    public String getHome2() {
        return "home";
    }
}
