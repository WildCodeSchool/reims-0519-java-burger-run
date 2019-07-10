package com.wildcodeschool.BurgerRun.Repositories;

import com.wildcodeschool.BurgerRun.Entities.Maze;

public class MazeRepository {
    private static Maze maze;

    public Maze getMaze() {
        if (maze == null) {
            maze = new Maze();
        }
        return maze;
    }

}