package com.wildcodeschool.BurgerRun.Entities;

public class Maze {
    private String[][] matrix;
    private int size = 7;

    public String[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(String[][] matrix) {
        this.matrix = matrix;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public Maze() {
        this.matrix = new String[size][size];
    }
}