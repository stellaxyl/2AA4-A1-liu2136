package ca.mcmaster.se2aa4.mazerunner;

public class Left extends ActionPackage{

    private Direction direction;

    public Left(Direction direction) {
        this.direction = direction;
    }

    @Override
    public void determineDirection() {
        if (super.direction == Direction.UP) {
            direction = Direction.LEFT;
        }
        else if (super.direction == Direction.DOWN) {
            direction = Direction.RIGHT;
        }
        else if (super.direction == Direction.LEFT) {
            direction = Direction.DOWN;
        }
        else if (super.direction == Direction.RIGHT) {
                direction = Direction.UP;
        }
    }

    @Override
    public Direction returnResult() {
        return direction;
    }

}
