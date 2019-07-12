package com.wildcodeschool.BurgerRun.repositories;

import com.wildcodeschool.BurgerRun.entities.Cell;

public class MazeRepository {
    private Cell[] cells;
    private int size = 16;
    private int idExit = 248;
    private int [] topWalls = {
        1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,
        0,1,1,1,0,0,0,0,0,0,1,1,0,0,1,1,
        0,0,1,1,0,1,1,0,1,1,1,0,1,1,1,0,
        0,1,0,1,1,0,1,1,0,0,0,1,0,1,1,1,
        0,0,1,1,1,0,1,1,0,1,1,0,1,0,0,0,
        0,0,1,0,0,0,0,1,1,1,0,0,0,0,0,1,
        1,1,0,0,1,1,1,1,1,0,0,0,0,0,0,0,
        0,1,1,0,0,1,1,0,0,1,0,1,0,1,1,0,
        1,1,0,0,1,1,0,0,1,0,1,0,1,0,1,0,
        0,1,1,1,0,0,1,1,0,1,0,0,0,0,0,0,
        0,0,1,0,1,0,1,0,0,0,0,1,0,0,0,1,
        0,1,0,1,0,1,0,1,1,0,1,1,0,0,1,0,
        1,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,
        0,1,0,0,0,1,1,1,1,0,1,0,0,1,0,0,
        0,1,1,1,0,1,1,1,1,0,0,1,1,0,0,0,
        1,0,0,0,1,1,0,0,0,1,0,1,0,1,0,0
    };

    private int[] rightWalls = {
        0,0,0,0,1,1,0,1,0,1,0,0,1,0,0,1,
        0,0,0,0,0,0,1,0,1,0,0,0,1,0,0,1,
        0,1,0,0,1,0,0,0,0,1,0,0,0,0,0,1,
        1,0,0,0,0,1,0,0,1,0,1,0,0,1,0,1,
        1,0,0,0,1,1,0,0,0,0,1,1,1,1,0,1,
        0,0,0,1,0,0,0,0,0,1,1,1,1,1,0,1,
        0,0,1,0,0,0,0,1,0,1,0,1,0,0,1,1,
        0,0,0,0,0,0,1,1,0,0,1,0,1,0,0,1,
        0,0,1,0,1,0,1,0,0,0,1,0,1,1,0,1,
        1,0,0,0,1,0,0,1,1,0,0,1,1,1,1,1,
        1,0,1,1,0,1,1,0,1,1,0,0,0,1,0,1,
        0,1,0,0,0,0,0,0,1,1,0,1,1,1,0,1,
        0,1,1,1,0,0,0,0,0,0,1,1,1,0,1,1,
        0,0,1,0,0,0,0,0,0,1,1,0,0,1,1,1,
        0,1,0,1,0,0,0,1,0,1,0,0,0,1,0,1,
        0,0,1,0,0,0,1,0,0,0,0,1,0,0,1,1
    };

    private int[] bottomWalls = {
        0,1,1,1,0,0,0,0,0,0,1,1,0,0,1,1,
        0,0,1,1,0,1,1,0,1,1,1,0,1,1,1,0,
        0,1,0,1,1,0,1,1,0,0,0,1,0,1,1,1,
        0,0,1,1,1,0,1,1,0,1,1,0,1,0,0,0,
        0,0,1,0,0,0,0,1,1,1,0,0,0,0,0,1,
        1,1,0,0,1,1,1,1,1,0,0,0,0,0,0,0,
        0,1,1,0,0,1,1,0,0,1,0,1,0,1,1,0,
        1,1,0,0,1,1,0,0,1,0,1,0,1,0,1,0,
        0,1,1,1,0,0,1,1,0,1,0,0,0,0,0,0,
        0,0,1,0,1,0,1,0,0,0,0,1,0,0,0,1,
        0,1,0,1,0,1,0,1,1,0,1,1,0,0,1,0,
        1,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,
        0,1,0,0,0,1,1,1,1,0,1,0,0,1,0,0,
        0,1,1,1,0,1,1,1,1,0,0,1,1,0,0,0,
        1,0,0,0,1,1,0,0,0,1,0,1,0,1,0,0,
        1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1
    };
    private int[] leftWalls = {
        1,0,0,0,0,1,1,0,1,0,1,0,0,1,0,0,
        1,1,0,0,0,0,0,1,0,1,0,0,0,1,0,0,
        1,0,1,0,0,1,0,0,0,0,1,0,0,0,0,0,
        1,1,0,0,0,0,1,0,0,1,0,1,0,0,1,0,
        1,1,0,0,0,1,1,0,0,0,0,1,1,1,1,0,
        1,0,0,0,1,0,0,0,0,0,1,1,1,1,1,0,
        1,0,0,1,0,0,0,0,1,0,1,0,1,0,0,1,
        1,0,0,0,0,0,0,1,1,0,0,1,0,1,0,0,
        1,0,0,1,0,1,0,1,0,0,0,1,0,1,1,0,
        1,1,0,0,0,1,0,0,1,1,0,0,1,1,1,1,
        1,1,0,1,1,0,1,1,0,1,1,0,0,0,1,0,
        1,0,1,0,0,0,0,0,0,1,1,0,1,1,1,0,
        1,0,1,1,1,0,0,0,0,0,0,1,1,1,0,1,
        1,0,0,1,0,0,0,0,0,0,1,1,0,0,1,1,
        1,0,1,0,1,0,0,0,1,0,1,0,0,0,1,0,
        1,0,0,1,0,0,0,1,0,0,0,0,1,0,0,1
    };

    public MazeRepository(int idBurgerStart, int idHumanStart) {
        this.cells = new Cell[size*size];
        for (int i = 0; i < size*size; i++) {
            boolean isSteak = (int)(Math.random()*100) > 90;
            this.cells[i] = new Cell(i, false, false, isSteak, topWalls[i], bottomWalls[i], leftWalls[i], rightWalls[i]);
        }
        this.cells[idBurgerStart].setBurger(true);
        this.cells[idHumanStart].setHuman(true);
    }

    public boolean canGoUp(int id) {
        return (!cells[id].isWallTop() && (id/size > 0));
    }

    public boolean canGoDown(int id) {
        return (!cells[id].isWallBottom() && (id/size < size-1));
    }

    public boolean canGoLeft(int id) {
        return (!cells[id].isWallLeft() && (id%size > 0));
    }

    public boolean canGoRight(int id) {
        return (!cells[id].isWallRight() && (id%size < size-1));
    }

    public int goUpBurger(int id) {
        cells[id].setBurger(false);
        cells[id - size].setBurger(true);
        return id - size;
    }

    public int goDownBurger(int id) {
        cells[id].setBurger(false);
        cells[id + size].setBurger(true);
        return id + size;
    }

    public int goRightBurger(int id) {
        cells[id].setBurger(false);
        cells[id + 1].setBurger(true);
        return id + 1;
    }

    public int goLeftBurger(int id) {
        cells[id].setBurger(false);
        cells[id - 1].setBurger(true);
        return id - 1;
    }

    public int goUpHuman(int id) {
        cells[id].setHuman(false);
        cells[id - size].setHuman(true);
        return id - size;
    }

    public int goDownHuman(int id) {
        cells[id].setHuman(false);
        cells[id + size].setHuman(true);
        return id + size;
    }

    public int goRightHuman(int id) {
        cells[id].setHuman(false);
        cells[id + 1].setHuman(true);
        return id + 1;
    }

    public int goLeftHuman(int id) {
        cells[id].setHuman(false);
        cells[id - 1].setHuman(true);
        return id - 1;
    }

    public Cell[] getCells() {
        return cells;
    }

    public int getSize() {
        return size;
    }
    
    public int getIdExit() {
        return idExit;
    }
}
