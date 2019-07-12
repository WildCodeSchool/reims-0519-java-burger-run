package com.wildcodeschool.BurgerRun.entities;

public class Cell {
    private int id;
    private boolean burger;
    private boolean human;
    private boolean steak;
    private boolean wallTop;
    private boolean wallBottom;
    private boolean wallLeft;
    private boolean wallRight;

    public Cell(int id, boolean burger, boolean human, boolean steak, int wallTop, int wallBottom, int wallLeft, int wallRight) {
        this.id = id;
        this.burger = burger;
        this.human = human;
        this.steak = steak;
        this.wallTop = (wallTop == 1 ? true : false);
        this.wallBottom = (wallBottom == 1 ? true : false);
        this.wallLeft = (wallLeft == 1 ? true : false);
        this.wallRight = (wallRight == 1 ? true : false);
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

    public boolean isSteak() {
        return steak;
    }

    public void setSteak(boolean steak) {
        this.steak = steak;
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