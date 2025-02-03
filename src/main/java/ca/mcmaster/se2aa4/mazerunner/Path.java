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
    private String move;

    private Direction dir;

    private StringBuffer path = new StringBuffer();
    private String strPath;
    private StringBuffer factorizedPath = new StringBuffer();
    private String strFactorizedPath;
    private int count = 0;
    private String strCount;
    private char prevLetter;

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
        direction = dir.getDirection();
        row = dir.getRow();
        col = dir.getCol();

        RightHandAlgorithm rightAlgo = new RightHandAlgorithm(maze);


        while (coord[0] != exit || coord[1] != width-1) {
            if (validateMove(coord[0]+row, coord[1]+col)) {
                move = rightAlgo.checkRight(direction, coord[0], coord[1], row, col);
                
                dir.updateDirection(move);
                dir.setMovement();
                direction = dir.getDirection();
                row = dir.getRow();
                col = dir.getCol();
                //System.out.print(move + ", " + direction + ", " + coord[0] + ", " + coord[1] + ", " + row + ", " + col);

                path.append(move);
                if (move.contains("F")) {
                    coord[0] += row;
                    coord[1] += col;
                }
                //System.out.print("hi" + coord[0] + coord[1] + entry + exit + width);
            }

        }

        strPath = path.toString();

        return strPath;
    }

    public String findPathFactorized() {
        for (int pointer = 0; pointer < findPath().length(); pointer++) {
            if (pointer == 0) {
                prevLetter = findPath().charAt(pointer);
                count++;
            }
            else {
                if (findPath().charAt(pointer) == prevLetter) {
                    count++;
                }
                else {
                    strCount = Integer.toString(count);
                    factorizedPath.append(String.format("%s%c ", strCount, prevLetter));
                    count = 1;
                    prevLetter = findPath().charAt(pointer);
                }
            }
        }
        if (count > 0) {
            strCount = Integer.toString(count);
            factorizedPath.append(strCount);
            factorizedPath.append(prevLetter);
        }

        strFactorizedPath = factorizedPath.toString();
        return strFactorizedPath;
    }

    public boolean validateMove(int newRow, int newCol) {
        if (newRow >= 0 && newRow < length && newCol >= 0 && newCol < width) {
            return true;
        }

        return false;
    }
}