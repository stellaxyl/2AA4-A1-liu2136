package ca.mcmaster.se2aa4.mazerunner;

public class Forward extends ActionPackage{
    private Direction direction;
    private int row;
    private int col;
    private int[] orientation;

    public Forward(Direction direction) {
        this.direction = direction;
        this.orientation = new int[] {this.row, this.col};
    }

    @Override
    public void determineDirection() {
        if (direction == Direction.UP) {
            row = -1;
            col = 0;
        }
        else if (direction == Direction.DOWN) {
            row = 1;
            col = 0;
        }
        else if (direction == Direction.LEFT) {
            row = 0;
            col = -1;
        }
        else if (direction == Direction.RIGHT) {
            row = 0;
            col = 1;
        }

        orientation[0] = row;
        orientation[1] = col;
    }

    @SuppressWarnings("unchecked")
    @Override
    public int[] returnResult() {
        return orientation;
    }

}
