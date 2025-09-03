package co.kr.example.sb2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Spring Boot 프로젝트");
        model.addAttribute("message", "환영합니다! Spring Boot + Thymeleaf + Tailwind CSS + Alpine.js + HTMX 프로젝트입니다.");
        return "index";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "소개");
        model.addAttribute("message", "이 프로젝트는 현대적인 웹 개발 스택으로 구성되었습니다.");
        return "about";
    }
}