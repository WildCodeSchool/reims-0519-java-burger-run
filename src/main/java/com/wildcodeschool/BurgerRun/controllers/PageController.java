package com.wildcodeschool.BurgerRun.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class PageController {

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/rules")
    public String rules(Model model) {
        return "rules";
    }

    @GetMapping("/game")
    public String game(Model model, HttpSession session) {
        if(session.getAttribute("currentPlayer") == null) {
            session.setAttribute("currentPlayer", 1);
        }

        model.addAttribute("currentPlayer", session.getAttribute("currentPlayer").equals(1) ? "Burger" : "Human");

        return "game";
    }

    @GetMapping("/ranking")
    public String ranking(Model model) {
        return "ranking";
    }

}