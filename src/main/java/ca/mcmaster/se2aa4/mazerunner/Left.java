package ca.mcmaster.se2aa4.mazerunner;

public class Left extends ActionPackage{

    private Direction direction;

    public Left(Direction direction) {
        this.direction = direction;
    }

    @Override
    public void determineDirection() {
        if (direction == Direction.UP) {
            direction = Direction.LEFT;
        }
        else if (direction == Direction.DOWN) {
            direction = Direction.RIGHT;
        }
        else if (direction == Direction.LEFT) {
            direction = Direction.DOWN;
        }
        else if (direction == Direction.RIGHT) {
                direction = Direction.UP;
        }
    }

    @Override
    public Direction returnResult() {
        return direction;
    }

}
