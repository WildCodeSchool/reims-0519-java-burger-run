package com.wildcodeschool.BurgerRun.controllers;

import javax.servlet.http.HttpSession;

import com.wildcodeschool.BurgerRun.entities.Burger;
import com.wildcodeschool.BurgerRun.repositories.GameRepository;
import com.wildcodeschool.BurgerRun.repositories.MazeRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
class PageController {

    GameRepository game = GameRepository.getInstance();

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/rules")
    public String rules(Model model) {
        return "rules";
    }

    @GetMapping("/win")
    public String win(Model model) {
        return "win";
    }

    @GetMapping("/loose")
    public String loose(Model model) {
        return "loose";
    }

    @GetMapping("/game")
    public String game(Model model, HttpSession session) {
        if(session.getAttribute("currentPlayer") == null) {
            session.setAttribute("currentPlayer", 1);
        }

        model.addAttribute("currentPlayer", session.getAttribute("currentPlayer").equals(1) ? "Burger" : "Human");
        model.addAttribute("maze", game.getMaze().getCells());

        return "game";
    }

    @GetMapping("/ranking")
    public String ranking(Model model) {
        return "ranking";
    }

    @PostMapping("/game")
    public String game(Model model, HttpSession session, @RequestParam(required = false) String move) {

        boolean gameStatus = true;
        MazeRepository maze = game.getMaze();
        Burger burger = game.getBurger();
        int positionBurger = burger.getIdBurger();

        if(move != null) { 

            int currentOpponent = 2;
            if(!session.getAttribute("currentPlayer").equals(1)) {
                currentOpponent = 1;
            }

            if(move.equals("left")) {
                if (maze.canGoLeft(positionBurger)) {
                    burger.setIdBurger(maze.goLeft(positionBurger));
                }
            }
            else if(move.equals("right")) {
                if (maze.canGoRight(positionBurger)) {
                    burger.setIdBurger(maze.goRight(positionBurger));
                }
            } 
            else if(move.equals("bottom")) {
                if (maze.canGoDown(positionBurger)) {
                    burger.setIdBurger(maze.goDown(positionBurger));
                }
            }
            else if(move.equals("top")) {
                if (maze.canGoUp(positionBurger)) {
                    burger.setIdBurger(maze.goUp(positionBurger));
                }
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