package com.wildcodeschool.BurgerRun.entities;

public class Cell {
    private int id;
    private boolean burger;
    private boolean human;
    private boolean wallTop;
    private boolean wallBottom;
    private boolean wallLeft;
    private boolean wallRight;

    public Cell(int id, boolean burger, boolean human, boolean wallTop, boolean wallBottom, boolean wallLeft,
            boolean wallRight) {
        this.id = id;
        this.burger = burger;
        this.human = human;
        this.wallTop = wallTop;
        this.wallBottom = wallBottom;
        this.wallLeft = wallLeft;
        this.wallRight = wallRight;
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

    public boolean isWallTop() {
        return wallTop;
    }

    public void setWallTop(boolean wallTop) {
        this.wallTop = wallTop;
    }

    public boolean isWallBottom() {
        return wallBottom;
    }

    public void setWallBottom(boolean wallBottom) {
        this.wallBottom = wallBottom;
    }

    public boolean isWallLeft() {
        return wallLeft;
    }

    public void setWallLeft(boolean wallLeft) {
        this.wallLeft = wallLeft;
    }

    public boolean isWallRight() {
        return wallRight;
    }

    public void setWallRight(boolean wallRight) {
        this.wallRight = wallRight;
    }  
}