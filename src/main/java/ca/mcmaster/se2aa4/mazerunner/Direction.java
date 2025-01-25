package ca.mcmaster.se2aa4.mazerunner;

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
}