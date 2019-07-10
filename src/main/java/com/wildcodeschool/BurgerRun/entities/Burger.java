package com.wildcodeschool.BurgerRun.entities;

public class Burger {
    private String burgerName;
    private int lifeStart = 1;
    private int newLife;
    private int xBurger;
    private int yBurger;

    public Burger(String burgerName, int lifeStart, int newLife, int xBurger, int yBurger) {
        this.burgerName = burgerName;
        this.lifeStart = lifeStart;
        this.newLife = newLife;
        this.xBurger = xBurger;
        this.yBurger = yBurger;
    }

    public String getBurgerName() {
        return burgerName;
    }

    public void setBurgerName(String burgerName) {
        this.burgerName = burgerName;
    }

    public int getLifeStart() {
        return lifeStart;
    }

    public void setLifeStart(int lifeStart) {
        this.lifeStart = lifeStart;
    }

    public int getNewLife() {
        return newLife;
    }

    public void setNewLife(int newLife) {
        this.newLife = newLife;
    }

    public int getxBurger() {
        return xBurger;
    }

    public void setxBurger(int xBurger) {
        this.xBurger = xBurger;
    }

    public int getyBurger() {
        return yBurger;
    }

    public void setyBurger(int yBurger) {
        this.yBurger = yBurger;
    }
}