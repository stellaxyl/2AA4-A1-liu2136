package ca.mcmaster.se2aa4.mazerunner;

public class RightHandAlgorithm implements Algorithm {

    private char[][] maze;
    private Direction direction;
    private int currentX;
    private int currentY;
    private int row;
    private int col;

    public RightHandAlgorithm(char[][] maze) {
        this.maze = maze;
    }

    // The method implements the Right-Hand Algorithm for moving through the maze
    @Override
    public String implementAlgorithm(Direction direction, int currentY, int currentX, int row, int col) {

        if (direction == Direction.RIGHT) {
            if (maze[currentY+1][currentX] == '#') {
                if (maze[currentY+row][currentX+col] == ' ') {
                    return "F";
                }
                else {
                    return "L";
                }
            }
            else {
                if (maze[currentY+col][currentX+row] == ' ') {
                    return "RF";
                }
                else {
                    return "R";
                }
            }
        }
        else if (direction == Direction.LEFT) {
            if (maze[currentY-1][currentX] == '#') {
                if (maze[currentY+row][currentX+col] == ' ') {
                    return "F";
                }
                else {
                    return "L";
                }
            }
            else {
                if (maze[currentY+col][currentX+row] == ' ') {
                    return "RF";
                }
                else {
                    return "R";
                }
                
            }
        }
        else if (direction == Direction.UP) {
            if (maze[currentY][currentX+1] == '#') {
                if (maze[currentY+row][currentX+col] == ' ') {
                    return "F";
                }
                else {
                    return "L";
                }
            }
            else {
                if (maze[currentY-col][currentX-row] == ' ') {
                    return "RF";
                }
                else {
                    return "R";
                }
            }
        }
        else if (direction == Direction.DOWN) {
            if (maze[currentY][currentX-1] == '#') {
                if (maze[currentY+row][currentX+col] == ' ') {
                    return "F";
                }
                else {
                    return "L";
                }
            }
            else {
                if (maze[currentY-col][currentX-row] == ' ') {
                    return "RF";
                }
                else {
                    return "R";
                }
            }
        }
        else return "";
    }
}