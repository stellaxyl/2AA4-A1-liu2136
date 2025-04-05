package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CheckPathTest {

	private char[][] testMaze = { 
	 { '#', '#', '#', '#', '#', '#', '#' }, 
	 { '#', ' ', ' ', ' ', ' ', ' ', ' ' }, 
	 { '#', '#', '#', ' ', '#', '#', '#' }, 
	 { '#', ' ', ' ', ' ', ' ', ' ', '#' }, 
	 { '#', '#', '#', ' ', '#', '#', '#' }, 
	 { ' ', ' ', ' ', ' ', ' ', ' ', '#' }, 
	 { '#', '#', '#', '#', '#', '#', '#' } };


	@Test
	public void factorizedToCanonical() {
		CheckPath c = new CheckPath("5F2L2FR2FR2F2L2FR2FR3F", testMaze, 7, 7, 5, 1, Direction.RIGHT);
		String expected = "FFFFFLLFFRFFRFFLLFFRFFRFFF";
		String actual = c.factorizedToCanonical();

		assertEquals(expected, actual);
	}

	@Test
	public void checkPath() {
		CheckPath c = new CheckPath("FFFFFFFFLLFFRFFRFFLLFFRFFRFFF", testMaze, 7, 7, 5, 1, Direction.RIGHT);
		String expected = "Correct Path, you have solved the maze!";
		String actual = c.checkPath();

		assertEquals(expected, actual);
	}

	@Test
	public void checkPathTODO() {
		CheckPath c = new CheckPath("FFFFFLLFFRFFRFFLLFFRFFRFFF", testMaze, 7, 7, 5, 1, Direction.RIGHT);
		String expected = "Correct Path, you have solved the maze!";
		String actual = c.checkPath();

		assertEquals(expected, actual);
	}

	@Test
	public void checkPathTODOTODO() {
		CheckPath c = new CheckPath("5F 2L 2F R 2F R 2F 2L 2F R 2F R F", testMaze, 7, 7, 5, 1, Direction.RIGHT);
		String expected = "Incorrect Path, you have not solved the maze";
		String actual = c.checkPath();

		assertEquals(expected, actual);
	}

	@Test
	public void validateMove() {
		CheckPath c = new CheckPath("5F 2L 2F R 2F R 2F 2L 2F R 2F R 3F", testMaze, 7, 7, 5, 1, Direction.RIGHT);
		c.validateMove();
	}
}
