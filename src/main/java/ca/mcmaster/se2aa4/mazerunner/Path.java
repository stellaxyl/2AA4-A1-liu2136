package ca.mcmaster.se2aa4.mazerunner;

public class Path{
    private char[][] maze;
    private int width;
    private int length;
    private String direction;
    private int[] coord;
    private int row;
    private int col;
    private int entry;
    private int exit;

    private Direction dir;

    private StringBuffer path = new StringBuffer();
    private String strPath;

    public Path(char[][] maze, int width, int length, int entry, int exit, String direction) {
        this.maze = maze;
        this.width = width;
        this.length = length;
        this.coord = new int[]{entry, 0};
        this.entry = entry;
        this.exit = exit;
        this.direction = direction;
    }

    public String findPath() {
        
        dir = new Direction(direction, maze, width, length);
        dir.setMovement();
        dir.getDirection();
        row = dir.getRow();
        col = dir.getCol();


        while (coord[0] != exit || coord[1] != width-1) {
            if (validateMove(coord[0]+row, coord[1]+col)) {
                path.append("F");
                coord[0] += row;
                coord[1] += col;
            }

            /*else {
                if (direction == "UP") {

                }
            }*/
        }

        strPath = path.toString();

        return strPath;
    }

    public boolean validateMove(int newRow, int newCol) {
        if (newRow >= 0 && newRow < length && newCol >= 0 && newCol < width && maze[newRow][newCol] == ' ') {
            return true;
        }

        return false;
    }
}