package com.wildcodeschool.BurgerRun.entities;

public class Maze {
    private String[] cells;
    private int size = 7;

    public String[] getCells() {
        return cells;
    }

    public void setCells(String[] cells) {
        this.cells = cells;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public Maze() {
        this.cells = new String[size*size];
    }
}