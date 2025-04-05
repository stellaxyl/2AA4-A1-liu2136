package ca.mcmaster.se2aa4.mazerunner;

public class Right extends ActionPackage{
    private Direction direction;

    public Right(Direction direction) {
        this.direction = direction;
    }

    @Override
    public void determineDirection() {
        if (super.direction == Direction.UP) {
            direction = Direction.RIGHT;
        }
        else if (super.direction == Direction.DOWN) {
            direction = Direction.LEFT;
        }
        else if (super.direction == Direction.LEFT) {
            direction = Direction.UP;
        }
        else if (super.direction == Direction.RIGHT) {
                direction = Direction.DOWN;
        }
    }

    @Override
    public Direction returnResult() {
        return direction;
    }
}
