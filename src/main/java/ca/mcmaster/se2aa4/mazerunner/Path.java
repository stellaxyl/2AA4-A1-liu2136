package ca.mcmaster.se2aa4.mazerunner;

public class Path {
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

    // Method to find the path through the maze
    public String findPath() {
        
        dir = new Direction(direction, maze, width, length);
        dir.setMovement();
        direction = dir.getDirection();
        row = dir.getRow();
        col = dir.getCol();

        Algorithm algorithm = new RightHandAlgorithm(maze);


        while (coord[0] != exit || coord[1] != width-1) {
            if (validateMove(coord[0]+row, coord[1]+col)) {
                move = algorithm.implementAlgorithm(direction, coord[0], coord[1], row, col);
                
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

    // Method to find the factorized version of the path (e.g., compress consecutive moves)
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
                    if (count > 1) {
                        factorizedPath.append(String.format(strCount));
                    }
                    factorizedPath.append(Character.toString(prevLetter));
                    factorizedPath.append(" ");
                    count = 1;
                    prevLetter = findPath().charAt(pointer);
                }
            }
        }
        if (count > 0) {
            strCount = Integer.toString(count);
            if (count > 1) {
                factorizedPath.append(strCount);
            }
            factorizedPath.append(prevLetter);
        }

        strFactorizedPath = factorizedPath.toString();
        return strFactorizedPath;
    }

    // Method to validate if the move to a new position is within the maze bounds
    public boolean validateMove(int newRow, int newCol) {
        if (newRow >= 0 && newRow < length && newCol >= 0 && newCol < width) {
            return true;
        }

        return false;
    }
}