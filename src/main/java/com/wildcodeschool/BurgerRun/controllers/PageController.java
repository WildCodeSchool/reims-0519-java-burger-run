package com.wildcodeschool.BurgerRun.controllers;

import javax.servlet.http.HttpSession;

import com.wildcodeschool.BurgerRun.entities.Burger;
import com.wildcodeschool.BurgerRun.entities.Human;
import com.wildcodeschool.BurgerRun.repositories.GameRepository;
import com.wildcodeschool.BurgerRun.repositories.MazeRepository;
import com.wildcodeschool.BurgerRun.repositories.SteakScoreRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
class PageController {

    GameRepository game = GameRepository.getInstance();

    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        if (session.getAttribute("gameStatus") == null) {
            session.setAttribute("gameStatus", true);
        }
        session.setAttribute("nickname", "AAA");
        return "index";
    }

    @GetMapping("/rules")
    public String rules(Model model) {
        return "rules";
    }

    @GetMapping("/win")
    public String win(Model model, HttpSession session) {
        if (session.getAttribute("gameStatus").equals(false)) {
            model.addAttribute("showInputNickname", true);
        }
        session.setAttribute("gameStatus", true);
        game.init();
        return "win";
    }

    @GetMapping("/loose")
    public String loose(Model model) {
        game.init();
        return "loose";
    }

    @GetMapping("/game")
    public String game(Model model, HttpSession session) {
        if(session.getAttribute("currentPlayer") == null) {
            session.setAttribute("currentPlayer", 1);
        }
        if (session.getAttribute("humanActionNumber") == null) {
            session.setAttribute("humanActionNumber", 1);
        }
        model.addAttribute("currentPlayer", session.getAttribute("currentPlayer").equals(1) ? "Burger" : "Human");
        model.addAttribute("burgerTurn", session.getAttribute("currentPlayer").equals(1) ? true : false);

        model.addAttribute("maze", game.getMaze().getCells());
        model.addAttribute("steakCount", game.getBurger().getLife());

        return "game";
    }

    @GetMapping("/ranking")
    public String ranking(Model model) {
        model.addAttribute("rankings", SteakScoreRepository.selectAll());
        return "ranking";
    }

    @PostMapping("/ranking")
    public String ranking(HttpSession session, @RequestParam(required=false) String nickname) {
        session.setAttribute("nickname", "AAA");
        if (nickname != null && !nickname.equals("")) {
            session.setAttribute("nickname", nickname);
        }
        SteakScoreRepository.insert(
            session.getAttribute("nickname").toString(),
            (int)session.getAttribute("steak_score")
        );
        session.setAttribute("nickname", null);
        session.setAttribute("steak_score", null);
        return "redirect:/ranking";
    }

    @PostMapping("/game")
    public String game(HttpSession session, @RequestParam(required = false) String move) {

        boolean gameStatus = true;
        MazeRepository maze = game.getMaze();
        Burger burger = game.getBurger();
        Human human = game.getHuman();
        int positionBurger = burger.getIdPosition();
        int positionHuman = human.getIdPosition();

        if(move != null) { 

            int currentOpponent = 2;
            if(!session.getAttribute("currentPlayer").equals(1)) {
                currentOpponent = 1;
            }

            if(session.getAttribute("currentPlayer").equals(1)) {
                if(move.equals("←")) {
                    if (maze.canGoLeft(positionBurger)) {
                        burger.setIdPosition(maze.goLeftBurger(positionBurger));
                    }
                }
                else if(move.equals("→")) {
                    if (maze.canGoRight(positionBurger)) {
                        burger.setIdPosition(maze.goRightBurger(positionBurger));
                    }
                } 
                else if(move.equals("↓")) {
                    if (maze.canGoDown(positionBurger)) {
                        burger.setIdPosition(maze.goDownBurger(positionBurger));
                    }
                }
                else if(move.equals("↑")) {
                    if (maze.canGoUp(positionBurger)) {
                        burger.setIdPosition(maze.goUpBurger(positionBurger));
                    }
                }
            }
            else {
                if(move.equals("←")) {
                    if (maze.canGoLeft(positionHuman)) {
                        human.setIdPosition(maze.goLeftHuman(positionHuman));
                    }
                }
                else if(move.equals("→")) {
                    if (maze.canGoRight(positionHuman)) {
                        human.setIdPosition(maze.goRightHuman(positionHuman));
                    }
                } 
                else if(move.equals("↓")) {
                    if (maze.canGoDown(positionHuman)) {
                        human.setIdPosition(maze.goDownHuman(positionHuman));
                    }
                }
                else if(move.equals("↑")) {
                    if (maze.canGoUp(positionHuman)) {
                        human.setIdPosition(maze.goUpHuman(positionHuman));
                    }
                }
            }

            positionBurger = burger.getIdPosition();
            positionHuman = human.getIdPosition();
            if (maze.getCells()[positionBurger].isSteak() && session.getAttribute("currentPlayer").equals(1)) {
                burger.setLife(burger.getLife() + 1);
                maze.getCells()[positionBurger].setSteak(false);
            }
            if (positionBurger == positionHuman) {
                burger.setLife(burger.getLife() - 1);
                maze.getCells()[positionHuman].setHuman(false);
                human.setIdPosition((int)(Math.random()*256));
                maze.getCells()[human.getIdPosition()].setHuman(true);
            }

            if(positionBurger == maze.getIdExit() || burger.getLife() == 0) {
                gameStatus = false;
            }
            else {
                if (session.getAttribute("humanActionNumber").equals(1) && session.getAttribute("currentPlayer").equals(2)) {
                    session.setAttribute("humanActionNumber", 2);
                }
                else {
                    session.setAttribute("currentPlayer", currentOpponent);
                    session.setAttribute("humanActionNumber", 1);
                }
            }
        }

        if(gameStatus) {
            return "redirect:/game";
        } 
        else {
            if(burger.getLife() > 0) {
                session.setAttribute("steak_score", burger.getLife());
                session.setAttribute("gameStatus", false);
                return "redirect:/win";
            }
            return "redirect:/loose";
        }
    }

}