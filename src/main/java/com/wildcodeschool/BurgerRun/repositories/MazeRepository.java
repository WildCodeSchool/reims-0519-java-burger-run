package com.wildcodeschool.BurgerRun.repositories;

import com.wildcodeschool.BurgerRun.entities.Cell;

public class MazeRepository {
    private Cell[] cells;
    private int size = 16;

    public MazeRepository(int idBurgerStart) {
        this.cells = new Cell[size*size];
        for (int i = 0; i < size*size; i++) {
            this.cells[i] = new Cell(i, false, false, true, true, false, false);

            // remove bottom wall on leftmost and rightmost cells
            if ((i%size == 0 && i%(size*2) == size) || (i%size == size-1 && i%(size*2) == size-1)) {
                this.cells[i].setWallBottom(false);
            }
            // remove top wall on leftmost and rightmost cells
            if ((i%size == 0 && i%(size*2) == 0) || (i%size == size-1 && i%(size*2) == size*2-1)) {
                this.cells[i].setWallTop(false);
            }

            // add left wall on leftmost cells
            if (i%size == 0) {
                this.cells[i].setWallLeft(true);
            }

            // add right wall on rightmost cells
            if (i%size == size-1) {
                this.cells[i].setWallRight(true);
            }
        }
        this.cells[idBurgerStart].setBurger(true);
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

    private int [] topwalls = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
       ,0,1,1,1,0,0,0,0,0,0,1,1,0,0,1,1,
        1,0,1,1,0,1,1,1,1,1,1,1,1,1,1,0,
       0,1,0,1,1,0,1,1,0,1,1,0,0,0,
        0,0,1,1,1,1,1,1,1,1,1,0,1,0,0,0,
       0,0,1,0,0,0,0,1,1,1,0,0,0,0,0,1,
       1,1,0,0,1,1,1,1,1,0,0,0,0,0,0,0,
       0,1,1,1,1,1,1,0,0,1,1,1,0,1,1,0,
      1,1,0,0,1,1,0,0,1,0,1,0,1,0,1,1,
      0,1,1,1,0,1,1,1,0,1,0,0,0,0,0,0,
      0,0,1,0,1,0,1,0,0,0,0,1,0,0,0,1,
      0,1,0,1,0,1,0,1,1,0,1,1,0,0,1,0,
      1,0,0,0,1,1,1,1,0,1,0,0,0,0,0,0,
      1,1,0,0,0,1,1,1,1,0,1,0,1,1,0,0,
      0,1,1,1,0,1,1,1,1,0,0,1,1,0,1,0,
      1,0,0,0,1,1,0,0,0,1,0,1,0,1,0,0,
    };

    private int[]rightwalls = {0,0,0,0,1,1,0,1,0,1,0,0,1,0,0,1,
           1,0,0,0,0,0,1,0,1,0,0,0,1,0,0,1,
           0,1,0,0,1,0,0,0,0,1,0,0,0,0,0,1,
           1,0,0,0,0,1,0,0,1,0,1,0,0,1,0,1,
           1,0,1,0,1,1,0,0,0,0,1,1,1,1,0,1,
           1,0,1,1,0,0,1,0,0,1,1,1,1,1,0,1,
           0,0,1,0,0,0,0,1,0,1,0,1,1,0,1,1,
           0,0,0,0,0,0,1,1,0,0,1,0,1,0,0,1,
          0,0,1,0,1,0,1,0,0,0,1,1,1,1,0,1,
          1,0,0,0,1,0,0,1,1,0,0,1,1,1,1,1,
          1,0,1,1,0,1,1,0,1,1,0,0,1,1,0,1,
          0,1,0,1,0,0,0,0,1,1,0,1,1,1,0,1,
          0,1,1,1,0,0,0,0,1,0,1,1,1,0,1,1,
          0,0,1,1,0,0,0,0,1,1,1,0,0,1,1,1,
          0,1,0,1,0,0,0,1,0,1,0,0,0,1,0,1,
          0,0,1,0,0,0,1,1,1,0,0,1,0,0,1,1,
    };

    private int[] bottomwalls = {0,1,1,1,0,0,0,0,0,0,1,1,0,0,1,1,
      1,0,1,1,0,1,1,1,1,1,1,1,1,1,1,0,
      0,1,0,1,1,0,1,1,0,0,0,1,1,1,1,1,
      0,0,1,1,1,1,1,1,1,1,1,0,1,0,0,0,
      0,0,1,0,0,0,0,1,1,1,0,0,0,0,0,1,
      1,1,0,0,1,1,1,1,1,0,0,0,0,0,0,0,
      0,1,1,1,1,1,1,0,0,1,1,1,0,1,1,0,
      1,1,0,0,1,1,0,0,1,0,1,0,1,0,1,1,
      0,1,1,1,0,1,1,1,0,1,0,0,0,0,0,0,
      0,0,1,0,1,0,1,0,0,0,0,1,0,0,0,1,
      0,1,0,1,0,1,0,1,1,0,1,1,0,0,1,0,
      1,0,0,0,1,1,1,1,0,1,0,0,0,0,0,0,
      1,1,0,0,0,1,1,1,1,0,1,0,1,1,0,0,
      0,1,1,1,0,1,1,1,1,0,0,1,1,0,1,0,
      1,0,0,0,1,1,0,0,0,1,0,1,0,1,0,0,
      1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
    };
    private int[] leftWalls = {
        1,0,0,0,0,1,1,0,1,0,1,0,0,1,0,0,
        1,1,0,0,0,0,0,1,0,1,0,0,0,1,0,0,
        1,0,1,0,0,1,0,0,0,0,1,0,0,0,0,0,
        1,1,0,0,0,0,1,0,0,1,0,1,0,0,1,0,
        1,1,0,1,0,1,1,0,0,0,0,1,1,1,1,0,
        1,1,0,1,1,0,0,1,0,0,1,1,1,1,1,0,
        1,0,0,1,0,0,0,0,1,0,1,0,1,1,0,1,
        1,0,0,0,0,0,0,1,1,0,0,1,0,1,0,0,
        1,0,0,1,0,1,0,1,0,0,0,1,1,1,1,0,
        1,1,0,0,0,1,0,0,1,1,0,0,1,1,1,1,
        1,1,0,1,1,0,1,1,0,1,1,0,0,1,1,0,
        1,0,1,0,1,0,0,0,0,1,1,0,1,1,1,0,
        1,0,1,1,1,0,0,0,0,1,0,1,1,1,0,1,
        1,0,0,1,1,0,0,0,0,1,1,1,0,0,1,1,
        1,0,1,0,1,0,0,0,1,0,1,0,0,0,1,0,
        1,0,0,1,0,0,0,1,1,1,0,0,1,0,0,1
     };
}


