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

    public char[][] setMaze() {
        maze = new char[length][width];
        int count = 0;
        try{

            while ((line = reader2.readLine()) != null) {
                if (line.isEmpty()) {
                    for (int j = 0; j < width; j++) {
                        maze[count][j] = ' ';
                    }
                }
                else {
                    for (int i = 0; i < line.length(); i++) {
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

    public void getMaze() {
        for (char[] length : maze) {
            for (char width : length) {
                System.out.print(width);
            }
            System.out.println();
        }
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }


    public int checkEntry() {
        for (int i = 0; i < length; i++) {
            if (maze[i][0] == ' ') {
                entry = i;
            }
        }
        return entry;
    }

    public int checkExit() {
        for (int j = 0; j < length; j++) {
            if (maze[j][0] == ' ') {
                exit = j;
            }
        }
        return exit;
    }

}