package com.wildcodeschool.BurgerRun.entities;

public class Human {
    private String human_name;
    private int xHuman;
    private int yHuman;

    public String getHuman_name() {
        return human_name;
    }

    public void setHuman_name(String human_name) {
        this.human_name = human_name;
    }

    public int getxHuman() {
        return xHuman;
    }

    public void setxHuman(int xHuman) {
        this.xHuman = xHuman;
    }

    public int getyHuman() {
        return yHuman;
    }

    public void setyHuman(int yHuman) {
        this.yHuman = yHuman;
    }

    public Human(String human_name, int xHuman, int yHuman) {
        this.human_name = human_name;
        this.xHuman = xHuman;
        this.yHuman = yHuman;
    }
    
}