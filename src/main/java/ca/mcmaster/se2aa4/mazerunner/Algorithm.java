package ca.mcmaster.se2aa4.mazerunner;

// This interface defines a contract for algorithms that will be implemented to solve the maze
public interface Algorithm {
    String implementAlgorithm(Direction direction, int currentY, int currentX, int row, int col);
}