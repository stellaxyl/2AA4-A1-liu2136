package ca.mcmaster.se2aa4.mazerunner;

public abstract class ActionPackage implements Action{

    @Override
    public <T> T execute() {
        determineDirection();
        return returnResult();
    }

    @Override
    public abstract void determineDirection();
    @Override
    public abstract <T> T returnResult();

    
    
}
