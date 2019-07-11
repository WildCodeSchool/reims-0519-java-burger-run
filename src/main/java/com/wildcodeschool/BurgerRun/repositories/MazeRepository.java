package com.wildcodeschool.BurgerRun.repositories;

import com.wildcodeschool.BurgerRun.entities.Cell;

public class MazeRepository {
    private Cell[] cells;
    private int size = 9;

    public MazeRepository(int idBurgerStart) {
        this.cells = new Cell[size];
        for (int i = 0; i < size; i++) {
            this.cells[i] = new Cell(i+1, false, false, false);
            if (i+1 == idBurgerStart) {
                this.cells[i].setBurger(true);
            }
        }
    }

    public boolean canGoTo(int id) {
        return !cells[id].isWall();
    }

    public void goUp(int id) {
        cells[id].setBurger(false);
        cells[id - size].setBurger(true);
    }

    public void getDown(int id) {
        cells[id].setBurger(false);
        cells[id + size].setBurger(true);
    }

    public void getRight(int id) {
        cells[id].setBurger(false);
        cells[id + 1].setBurger(true);
    }

    public void getLeft(int id) {
        cells[id].setBurger(false);
        cells[id - 1].setBurger(true);
    }

    public Cell[] getCells() {
        return cells;
    }

    public int getSize() {
        return size;
    }
}