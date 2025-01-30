package ca.mcmaster.se2aa4.mazerunner;

public class RightHandAlgorithm {

    private char[][] maze;
    private String direction;
    private int currentX;
    private int currentY;
    private int row;
    private int col;

    public RightHandAlgorithm(char[][] maze) {
        this.maze = maze;
        //this.direction = direction;
        /*this.currentX = currentX;
        this.currentY = currentY;
        this.row = row;
        this.col = col;*/
    }

    public String checkRight(String direction, int currentY, int currentX, int row, int col) {

        if (direction == "RIGHT") {
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
                    currentY += row;
                    currentX += col;
                    return "RF";
                }
                else {
                    return "R";
                }
            }
        }
        else if (direction == "LEFT") {
            if (maze[currentY-1][currentX] == '#') {
                if (maze[currentY+row][currentX+col] == ' ') {
                    currentY += row;
                    currentX += col;
                    return "F";
                }
                else {
                    return "L";
                }
            }
            else {
                if (maze[currentY+col][currentX+row] == ' ') {
                    currentY += row;
                    currentX += col;
                    return "RF";
                }
                else {
                    return "R";
                }
                
            }
        }
        else if (direction == "UP") {
            if (maze[currentY][currentX+1] == '#') {
                if (maze[currentY+row][currentX+col] == ' ') {
                    currentY += row;
                    currentX += col;
                    return "F";
                }
                else {
                    return "L";
                }
            }
            else {
                if (maze[currentY-col][currentX-row] == ' ') {
                    currentY += row;
                    currentX += col;
                    return "RF";
                }
                else {
                    return "R";
                }
            }
        }
        else if (direction == "DOWN") {
            if (maze[currentY][currentX-1] == '#') {
                if (maze[currentY+row][currentX+col] == ' ') {
                    currentY += row;
                    currentX += col;
                    return "F";
                }
                else {
                    return "L";
                }
            }
            else {
                if (maze[currentY-col][currentX-row] == ' ') {
                    currentY += row;
                    currentX += col;
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