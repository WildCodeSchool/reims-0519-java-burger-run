package com.wildcodeschool.BurgerRun.repositories;

import com.wildcodeschool.BurgerRun.repositories.MazeRepository;
import com.wildcodeschool.BurgerRun.entities.Burger;
import com.wildcodeschool.BurgerRun.entities.Human;

public class GameRepository {
    private static GameRepository instance;
    private Burger burger;
    private Human human;
    private MazeRepository maze;

    public static GameRepository getInstance() {
        if (instance == null) {
            instance = new GameRepository();
            instance.init();
        }
        return instance;
    }

    public void init() {
        instance.burger = new Burger(1, 0);
        instance.human = new Human((int)(Math.random()*256));
        instance.maze = new MazeRepository(instance.getBurger().getIdPosition(), instance.getHuman().getIdPosition());
    }

    private GameRepository() {}

    public Burger getBurger() {
        return burger;
    }

    public Human getHuman() {
        return human;
    }

    public MazeRepository getMaze() {
        return maze;
    }
}