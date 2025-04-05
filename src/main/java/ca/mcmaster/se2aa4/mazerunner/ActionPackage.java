package ca.mcmaster.se2aa4.mazerunner;

public abstract class ActionPackage implements Action{
    Direction direction;

    @Override
    public <T> T execute(Direction direction) {
        updateDirection(direction);
        determineDirection();
        return returnResult();
    }

    @Override
    public abstract void determineDirection();
    @Override
    public abstract <T> T returnResult();

    public void updateDirection(Direction direction) {
        this.direction = direction;
    }

    
}
