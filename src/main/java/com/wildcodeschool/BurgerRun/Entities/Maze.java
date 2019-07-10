package com.wildcodeschool.BurgerRun.Entities;

public class Maze {
    private String[][] matrice;
    private int size = 7;

    public String[][] getMatrice() {
        return matrice;
    }

    public void setMatrice(String[][] matrice) {
        this.matrice = matrice;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public Maze() {
        this.matrice = new String[size][size];
    }
}