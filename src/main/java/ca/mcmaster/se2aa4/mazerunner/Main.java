package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    // Initialize the logger to log messages
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");

        // Define command-line options for the program
        Options options = new Options();
        options.addOption("i", true, "Maze file input");
        options.addOption(Option.builder("p")
            .hasArgs()
            .desc("Path to check for validity")
            .build());

        // Command line parser to parse the arguments
        CommandLineParser parser = new DefaultParser();

        try {

            CommandLine cmd = parser.parse(options, args);

            // Check if the maze file input option '-i' is present
            if (!cmd.hasOption("i")) {
                logger.error("Missing argument '-i' before inputting a maze file");
                System.exit(1);
            }

            // Retrieve the input maze file path
            String inputFile = cmd.getOptionValue("i");

            // Check if the file path is valid
            if (inputFile == null) {
                logger.error("No file path argument detected");
                System.exit(1);
            }

            // Log the maze file being read
            logger.info("**** Reading the maze from file " + inputFile);
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String line;

            // Read and log each line of the maze file
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

            // Initialize two readers for further processing (this may be redundant and could be optimized)
            BufferedReader reader1 = new BufferedReader(new FileReader(inputFile));
            BufferedReader reader2 = new BufferedReader(new FileReader(inputFile));
            // Create a Maze object to store the maze data
            Maze maze = new Maze(reader1, reader2);
            maze.setDimensions();
            char[][] mazeArr = maze.setMaze();
            int width = maze.getWidth();
            int length = maze.getLength();
            int entry = maze.checkEntry();
            int exit = maze.checkExit();
            String givenPath = null;

            // If the path to check is provided, join all path parts together
            if (cmd.hasOption("p")) {
                givenPath = String.join("", cmd.getOptionValues("p"));
            }

            // Error check if path is not provided and there are other arguments
            if (!cmd.hasOption("p") && cmd.getArgList().size() > 0) {
                logger.error("Current system function is to find path to exit. To input and check your path, include argument '-p'");
                System.exit(1);
            }

            // If no valid path argument is provided, log an error and exit
            if (cmd.hasOption("p") && (cmd.getOptionValues("p") == null || cmd.getOptionValues("p").length == 0)) {
                logger.error("Missing argument to check user input path. Please input a valid path");
                System.exit(1);
            }

            // If no given path, compute the path using the maze and print the computed path
            if (givenPath == null) {
                Direction direction = Direction.RIGHT;

                logger.info("**** Computing path");
                
                Path path = new Path(mazeArr, width, length, entry, exit, direction);
                System.out.println(path.findPathFactorized());
            }
            
            // Otherwise, check the validity of the provided path
            else {
                Direction direction = Direction.RIGHT;
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