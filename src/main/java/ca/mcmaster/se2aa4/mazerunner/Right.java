package ca.mcmaster.se2aa4.mazerunner;

public class Right extends ActionPackage{
    private Direction direction;

    public Right(Direction direction) {
        this.direction = direction;
    }

    @Override
    public void determineDirection() {
        if (direction == Direction.UP) {
            direction = Direction.RIGHT;
        }
        else if (direction == Direction.DOWN) {
            direction = Direction.LEFT;
        }
        else if (direction == Direction.LEFT) {
            direction = Direction.UP;
        }
        else if (direction == Direction.RIGHT) {
                direction = Direction.DOWN;
        }
    }

    @Override
    public Direction returnResult() {
        return direction;
    }
}
