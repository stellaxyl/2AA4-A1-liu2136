package ca.mcmaster.se2aa4.mazerunner;

public class CheckPath {
    private String givenPath;
    private StringBuilder canonicalForm = new StringBuilder();
    private String strCanonicalForm;
    private int pointer = 0;
    private StringBuilder strFrequencyOfMove = new StringBuilder();
    private int frequencyOfMove;
    private char currentMove;
    private String pathToCheck;
    private String path;

    private ActionPackage forward;
    private ActionPackage right;
    private ActionPackage left;
    
    private char[][] maze;
    private int width;
    private int length;
    private int[] coord;
    private int row;
    private int col;
    private int entry;
    private int exit;

    private char move;
    private Direction direction;
    private String validPath = "Correct Path, you have solved the maze!";
    
    public CheckPath(String givenPath, char[][] maze, int width, int length, int entry, int exit, Direction direction) {
        this.givenPath = givenPath;
        this.maze = maze;
        this.width = width;
        this.length = length;
        this.coord = new int[]{entry, 0};
        this.entry = entry;
        this.exit = exit;
        this.direction = direction;
        this.forward = (ActionPackage) new Forward(this.direction);
        this.left = (ActionPackage) new Left(this.direction);
        this.right = (ActionPackage) new Right(this.direction);
    }

    // Method to factorize the given path
    public String factorizedToCanonical() {
        while (pointer < givenPath.length()) {
            if (Character.isDigit(givenPath.charAt(pointer))) {
                strFrequencyOfMove.append(givenPath.charAt(pointer));
            }
            else if (givenPath.charAt(pointer) == ' ') {
                pointer++;
            }
            else {
                if (strFrequencyOfMove.length() == 0) {
                    currentMove = givenPath.charAt(pointer);
                    canonicalForm.append(currentMove);
                }
                else {
                    frequencyOfMove = Integer.parseInt(strFrequencyOfMove.toString());
                    currentMove = givenPath.charAt(pointer);
                    for (int i = 0; i < frequencyOfMove; i++) {
                        canonicalForm.append(currentMove);
                    }
                }
                
                strFrequencyOfMove.setLength(0);
            }
            pointer++;
        }
        
        strCanonicalForm = canonicalForm.toString();
        return strCanonicalForm;

    }

    // Method to get the path that needs to be checked, factorize if needed
    public String getPathToCheck() {
        if (givenPath.matches("^[FLR\\s]+$")) {
            pathToCheck = givenPath;
        }
        else {
            pathToCheck = factorizedToCanonical();
        }

        return pathToCheck;
    }

    // Method to check the validity of the given path
    public String checkPath() {
        int[] forwardMove = forward.execute(direction);
        
        row =  forwardMove[0];
        col = forwardMove[1];
        path = getPathToCheck();
        validateMove();

        for (int i = 0; i < path.length(); i++) {
            move = path.charAt(i);

            if (move == 'R') {
                direction = right.execute(direction);
            }
            if (move == 'L') {
                direction = left.execute(direction);
            }

            forward.updateDirection(direction);
            forwardMove = forward.execute(direction);
            row =  forwardMove[0];
            col = forwardMove[1];

            if (move == 'F' && maze[coord[0]+row][coord[1]+col] == ' ') {
                coord[0] += row;
                coord[1] += col;
            }

        }

        if (coord[0] != exit || coord[1] != width-1) {
            validPath = "Incorrect Path, you have not solved the maze";
        }

        return validPath;
    }

    // Method to validate the moves in the path
    public void validateMove() {
        path = getPathToCheck();
        for (int j = 0; j < path.length(); j++) {
            if (path.charAt(j) != 'F' && path.charAt(j) != 'R' && path.charAt(j) != 'L') {
                System.err.println("Error: Please enter a valid path");
                System.exit(1);
            }
        }
    }
}