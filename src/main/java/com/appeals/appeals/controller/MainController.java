package com.appeals.appeals.controller;

import com.appeals.appeals.application.AppealApp;
import com.appeals.appeals.domain.Appeal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    private final AppealApp appealApp;

    public MainController(AppealApp appealApp) {
        this.appealApp = appealApp;
    }

    @GetMapping("/")
    public String mainPage(Model model) {
//        model.addAttribute("appeals", appealApp.getAppeals());
         return "/main";
    }

    @GetMapping("/create_appeal")
    public String createAppeal() {
        return "/createAppeal";
    }

    @PostMapping("/save_appeal")
    public String saveAppeal(@ModelAttribute Appeal appeal) {
        appealApp.saveAppeal(appeal.toAppealDto());
        return "/main";
    }
}
