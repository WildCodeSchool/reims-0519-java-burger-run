package com.wildcodeschool.BurgerRun.entities;

public class Burger{
    private int life = 1;
    private int idPosition;

    public Burger(int life, int idPosition) {
        this.life = life;
        this.idPosition = idPosition;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
    }
}