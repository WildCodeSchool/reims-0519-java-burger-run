package com.wildcodeschool.BurgerRun.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping("/game")
    public String game(HttpSession session, @RequestParam(required = false) String move) {

        boolean gameStatus = true;

        if(move != null) { 

            int currentOpponent = 2;
            if(!session.getAttribute("currentPlayer").equals(1)) {
                currentOpponent = 1;
            }

            if(gameStatus == true) {
                session.setAttribute("currentPlayer", currentOpponent);
            } else {
                gameStatus = false;
            }
        }

        if(gameStatus) {
            return "redirect:/game";
        } 
        else { 
            return "redirect:/";
        }
    }

}