package ca.mcmaster.se2aa4.mazerunner;

// This interface defines a contract for actions that will be implemented to solve the maze
public interface Action {

    public <T> T execute();
    public void determineDirection();
    public <T> T returnResult();
}
