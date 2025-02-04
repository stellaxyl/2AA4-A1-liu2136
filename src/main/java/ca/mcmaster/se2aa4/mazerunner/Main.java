package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;
import java.util.Scanner;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");

        Options options = new Options();
        options.addOption("i", true, "Maze file input");
        options.addOption(Option.builder("p")
            .hasArgs()
            .desc("Path to check for validity")
            .build());

        CommandLineParser parser = new DefaultParser();

        try {

            CommandLine cmd = parser.parse(options, args);

            //CHECK IF HAS I IS THERE AND HAS VALID INPUT
            if (!cmd.hasOption("i")) {
                logger.error("Missing argument '-i' before inputting a maze file");
                System.exit(1);
            }

            String inputFile = cmd.getOptionValue("i");

            //CHECK IF ARGUMENT IS CORRECT
            if (inputFile == null) {
                logger.error("No file path argument detected");
                System.exit(1);
            }

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
            int width = maze.getWidth();
            int length = maze.getLength();
            int entry = maze.checkEntry();
            int exit = maze.checkExit();
            String givenPath = null;

            if (cmd.hasOption("p")) {
                givenPath = String.join("", cmd.getOptionValues("p"));
            }

            if (!cmd.hasOption("p") && cmd.getArgList().size() > 0) {
                logger.error("Current system function is to find path to exit. To input and check your path, include argument '-p'");
                System.exit(1);
            }


            if (cmd.hasOption("p") && (cmd.getOptionValues("p") == null || cmd.getOptionValues("p").length == 0)) {
                logger.error("Missing argument to check user input path. Please input a valid path");
                System.exit(1);
            }

            if (givenPath == null) {
                String direction = "RIGHT";

                logger.info("**** Computing path");
                
                Path path = new Path(mazeArr, width, length, entry, exit, direction);
                System.out.println(path.findPathFactorized());
            }
            else {
                String direction = "RIGHT";
                CheckPath check = new CheckPath(givenPath, mazeArr, width, length, entry, exit, direction);
                System.out.println(check.checkPath());
            }
            
        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }

        logger.info("**** Computing path");
        logger.warn("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }
}