package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");

        Options options = new Options();
        options.addOption("i", true, "Maze file input");

        CommandLineParser parser = new DefaultParser();

        try {
            CommandLine cmd = parser.parse(options, args);
            String inputFile = cmd.getOptionValue("i");

            logger.info("**** Reading the maze from file " + inputFile);
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String line;

            while ((line = reader.readLine()) != null) {
                for (int idx = 0; idx < line.length(); idx++) {
                    if (line.charAt(idx) == '#') {
                        logger.info("WALL ");
                    } else if (line.charAt(idx) == ' ') {
                        logger.info("PASS ");
                    }

                }
                logger.info(System.lineSeparator());
            }

            BufferedReader reader1 = new BufferedReader(new FileReader(inputFile));
            BufferedReader reader2 = new BufferedReader(new FileReader(inputFile));
            Maze maze = new Maze(reader1, reader2);
            maze.setDimensions();
            char[][] mazeArr = maze.setMaze();
            maze.getMaze();
            int width = maze.getWidth();
            int length = maze.getLength();
            int entry = maze.checkEntry();
            int exit = maze.checkExit();
            
            //System.out.println(maze.checkEntry() + ",0");
            //System.out.println(maze.checkExit() + "," + maze.getWidth());
            String direction = "RIGHT";

            logger.info("**** Computing path");
            
            Path path = new Path(mazeArr, width, length, entry, exit, direction);
            System.out.println(path.findPath());
            System.out.println(path.findPathFactorized());


        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\" + e.getMessage());
        }

        //logger.info("**** Computing path");
        //logger.warn("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }
}