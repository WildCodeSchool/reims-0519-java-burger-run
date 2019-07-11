package com.wildcodeschool.BurgerRun.entities;

public class Cell {
    private int id;
    private boolean burger;
    private boolean human;
    private boolean wall;

    public Cell(int id, boolean burger, boolean human, boolean wall) {
        this.id = id;
        this.burger = burger;
        this.human = human;
        this.wall = wall;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isBurger() {
        return burger;
    }

    public void setBurger(boolean burger) {
        this.burger = burger;
    }

    public boolean isHuman() {
        return human;
    }

    public void setHuman(boolean human) {
        this.human = human;
    }

    public boolean isWall() {
        return wall;
    }

    public void setWall(boolean wall) {
        this.wall = wall;
    }
}