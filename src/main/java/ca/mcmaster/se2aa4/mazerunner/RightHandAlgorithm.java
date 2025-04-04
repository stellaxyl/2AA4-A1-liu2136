package ca.mcmaster.se2aa4.mazerunner;

public class RightHandAlgorithm implements Algorithm {

    private char[][] maze;

    public RightHandAlgorithm(char[][] maze) {
        this.maze = maze;
    }

    // The method implements the Right-Hand Algorithm for moving through the maze
    @Override
    public String implementAlgorithm(Direction direction, int currentY, int currentX, int row, int col) {

        if (maze[currentY+col][currentX-row] == '#') {
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
        
}