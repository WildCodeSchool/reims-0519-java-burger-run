package com.wildcodeschool.BurgerRun.repositories;

import com.wildcodeschool.BurgerRun.repositories.MazeRepository;
import com.wildcodeschool.BurgerRun.entities.Burger;
import com.wildcodeschool.BurgerRun.entities.Human;

public class GameRepository {
    private static GameRepository instance;
    private Burger burger;
    private Human human;
    private MazeRepository maze;

    private static GameRepository getInstance() {
        if (instance == null) {
            instance = new GameRepository();
            instance.burger = new Burger(null, 1, 1, 4, 0);
            instance.maze = new MazeRepository();
        }
        return instance;
    }

    private GameRepository() {}
}