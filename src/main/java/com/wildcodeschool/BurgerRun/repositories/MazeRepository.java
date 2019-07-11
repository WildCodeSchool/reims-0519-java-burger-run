package com.wildcodeschool.BurgerRun.repositories;

import com.wildcodeschool.BurgerRun.entities.Maze;

public class MazeRepository {
    private Maze maze;

    public MazeRepository() {
        this.maze = new Maze();
        initMaze();
    }

    public void initMaze() {
        String strings = 
            "#######" +
            "#   # S" +
            "# # # #" +
            "# # # #" +
            "E #   #" +
            "#######";
        String[] cells = strings.split("");
        maze.setCells(cells);
    }

    public boolean canGoUp(int id) {
        return maze.getCells()[id].equals("");
    }

    public boolean canGoDown(int id) {
        return maze.getCells()[id].equals("");
    }

    public boolean canGoRight(int id) {
        return maze.getCells()[id].equals("");
    }

    public boolean canGoLeft(int id) {
        return maze.getCells()[id].equals("");
    }

    public int getUp(int id) {
        return id - maze.getSize();
    }

    public int getDown(int id) {
        return id + maze.getSize();
    }

    public int getRight(int id) {
        return id + 1;
    }

    public int getLeft(int id) {
        return id - 1;
    }
}