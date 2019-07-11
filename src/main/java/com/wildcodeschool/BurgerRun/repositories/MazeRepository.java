package com.wildcodeschool.BurgerRun.repositories;

import com.wildcodeschool.BurgerRun.entities.Cell;

public class MazeRepository {
    private Cell[] cells;
    private int size = 16;

    public MazeRepository(int idBurgerStart) {
        this.cells = new Cell[size*size];
        for (int i = 0; i < size*size; i++) {
            this.cells[i] = new Cell(i, false, false, false);
            if (i == idBurgerStart) {
                this.cells[i].setBurger(true);
            }
        }
    }

    public boolean canGoUp(int id) {
        return !cells[id].isWall() && (id/size > 0);
    }

    public boolean canGoDown(int id) {
        return !cells[id].isWall() && (id/size < size-1);
    }

    public boolean canGoLeft(int id) {
        return !cells[id].isWall() && (id%size > 0);
    }

    public boolean canGoRight(int id) {
        return !cells[id].isWall() && (id%size < size-1);
    }


    public int goUp(int id) {
        cells[id].setBurger(false);
        cells[id - size].setBurger(true);
        return id - size;
    }

    public int goDown(int id) {
        cells[id].setBurger(false);
        cells[id + size].setBurger(true);
        return id + size;
    }

    public int goRight(int id) {
        cells[id].setBurger(false);
        cells[id + 1].setBurger(true);
        return id + 1;
    }

    public int goLeft(int id) {
        cells[id].setBurger(false);
        cells[id - 1].setBurger(true);
        return id - 1;
    }

    public Cell[] getCells() {
        return cells;
    }

    public int getSize() {
        return size;
    }
}