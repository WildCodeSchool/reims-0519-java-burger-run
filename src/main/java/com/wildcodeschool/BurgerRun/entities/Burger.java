package com.wildcodeschool.BurgerRun.entities;

public class Burger {
    private int life = 1;
    private int idBurger;

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getIdBurger() {
        return idBurger;
    }

    public void setIdBurger(int idBurger) {
		this.idBurger = idBurger;
	}

    public Burger(int life, int idBurger) {
		this.life = life;
		this.idBurger = idBurger;
    }
}