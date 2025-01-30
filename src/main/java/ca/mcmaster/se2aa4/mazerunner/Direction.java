package ca.mcmaster.se2aa4.mazerunner;

//import java.

public class Direction {
    private String direction;
    private char[][] maze;
    private int width;
    private int length;
    private int row;
    private int col;

    public Direction(String direction, char[][] maze, int width, int length) {
        this.direction = direction;
        this.maze = maze;
        this.width = width;
        this.length = length;
    }

    public void setMovement() {
        if (direction == "UP") {
            row = -1;
            col = 0;
        }
        else if (direction == "DOWN") {
            row = 1;
            col = 0;
        }
        else if (direction == "LEFT") {
            row = 0;
            col = -1;
        }
        else if (direction == "RIGHT") {
            row = 0;
            col = 1;
        }
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public String getDirection() {
        return direction;
    }

    public void updateDirection(String move) {
        if (direction == "UP") {
            if (move.contains("R")) {
                direction = "RIGHT";
            }
            if (move.contains("L")) {
                direction = "LEFT";
            }
        }
        else if (direction == "DOWN") {
            if (move.contains("R")) {
                direction = "LEFT";
            }            
            if (move.contains("L")) {
                direction = "RIGHT";
            }
        }
        else if (direction == "LEFT") {
            if (move.contains("R")) {
                direction = "UP";
            }
            if (move.contains("L")) {
                direction = "DOWN";
            }
        }
        else if (direction == "RIGHT") {
            if (move.contains("R")) {
                direction = "DOWN";
            }
            if (move.contains("L")) {
                direction = "UP";
            }
        }
    }
}