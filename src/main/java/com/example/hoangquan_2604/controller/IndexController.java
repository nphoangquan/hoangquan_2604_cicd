package com.example.hoangquan_2604.controller;

import com.example.hoangquan_2604.service.TodoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class IndexController {

    private final TodoService todoService;

    @Value("${portfolio.name}")
    private String name;
    @Value("${portfolio.mssv}")
    private String mssv;
    @Value("${portfolio.lop}")
    private String lop;
    @Value("${portfolio.email}")
    private String email;
    @Value("${portfolio.phone}")
    private String phone;
    @Value("${portfolio.bio}")
    private String bio;

    public IndexController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("name", name);
        model.addAttribute("mssv", mssv);
        model.addAttribute("lop", lop);
        model.addAttribute("email", email);
        model.addAttribute("phone", phone);
        model.addAttribute("bio", bio);
        model.addAttribute("todos", todoService.findAll());
        return "index";
    }

    @PostMapping("todos")
    public String addTodo(@RequestParam String title, RedirectAttributes redirectAttributes) {
        todoService.save(title);
        redirectAttributes.addFlashAttribute("message", "Đã thêm công việc!");
        return "redirect:/";
    }

    @PostMapping("todos/{id}/complete")
    public String completeTodo(@org.springframework.web.bind.annotation.PathVariable Long id) {
        todoService.complete(id);
        return "redirect:/";
    }

    @PostMapping("todos/{id}/delete")
    public String deleteTodo(@org.springframework.web.bind.annotation.PathVariable Long id) {
        todoService.delete(id);
        return "redirect:/";
    }
}
