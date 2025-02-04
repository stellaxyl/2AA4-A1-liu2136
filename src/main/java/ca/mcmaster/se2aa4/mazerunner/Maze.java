package ca.mcmaster.se2aa4.mazerunner;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Maze{
    private BufferedReader reader;
    private BufferedReader reader2;
    private int length = 0;
    private int width = 0;
    private char[][] maze;
    private String line;
    
    private int entry;
    private int exit;

    public Maze(BufferedReader reader, BufferedReader reader2) {
        this.reader = reader;
        this.reader2 = reader2;
    }

    // Method to calculate and set the dimensions (length and width) of the maze
    public void setDimensions() {
        try{
            while ((line = reader.readLine()) != null) {
                length++;
                for (int idx = 0; idx < line.length(); idx++) {
                    width = line.length();
                }
            }

        } catch(Exception e) {
            System.out.print("/!\\ An error has occured /!\\");
        }
    }

    // Method to create and return the maze as a 2D char array
    public char[][] setMaze() {
        maze = new char[length][width];
        int count = 0;
        try{

            while ((line = reader2.readLine()) != null) {
                for (int i = 0; i < width; i++) {
                    if (i > line.length()-1) {
                        maze[count][i] = ' ';
                    }
                    else {
                        maze[count][i] = line.charAt(i);
                    }
                }
                count++;
            }
        } catch(Exception e) {
            System.out.print("/!\\ An error has occured /!\\");
        }
        return maze;
    }

    // Method to print the maze to the console
    public void getMaze() {
        for (char[] length : maze) {
            for (char width : length) {
                System.out.print(width);
            }
            System.out.println();
        }
    }

    // Gets the width of the maze
    public int getWidth() {
        return width;
    }

    // Gets the length of the maze
    public int getLength() {
        return length;
    }

    // Method to check and return the row index of the maze entry point
    public int checkEntry() {
        for (int i = 0; i < length; i++) {
            if (maze[i][0] == ' ') {
                entry = i;
            }
        }
        return entry;
    }

    // Method to check and return the row index of the maze exit point
    public int checkExit() {
        for (int j = 0; j < length; j++) {
            if (maze[j][width-1] == ' ') {
                exit = j;
            }
        }
        return exit;
    }

}