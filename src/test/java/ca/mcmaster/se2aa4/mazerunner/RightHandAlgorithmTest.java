package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class RightHandAlgorithmTest {
	private char[][] testMaze = {
		{'#','#','#','#','#','#','#'},
		{'#',' ',' ',' ',' ',' ',' '},
		{'#','#','#',' ','#','#','#'},
		{'#',' ',' ',' ',' ',' ','#'},
		{'#','#','#',' ','#','#','#'},
		{' ',' ',' ',' ',' ',' ','#'},
		{'#','#','#','#','#','#','#'}
	};

	@Test
	public void implementAlgorithm() {
		RightHandAlgorithm r = new RightHandAlgorithm(testMaze);
		Direction direction = Direction.RIGHT;
		int currentY = 5;
		int currentX = 0;
		int row = 0;
		int col = 1;
		String expected = "F";
		String actual = r.implementAlgorithm(direction, currentY, currentX, row, col);

		assertEquals(expected, actual);
	}

	@Test
	public void implementAlgorithmTODO() {
		RightHandAlgorithm r = new RightHandAlgorithm(testMaze);
		Direction direction = Direction.RIGHT;
		int currentY = 5;
		int currentX = 5;
		int row = 0;
		int col = 1;
		String expected = "L";
		String actual = r.implementAlgorithm(direction, currentY, currentX, row, col);

		assertEquals(expected, actual);
	}

	@Test
	public void implementAlgorithmTODOTODO() {
		RightHandAlgorithm r = new RightHandAlgorithm(testMaze);
		Direction direction = Direction.UP;
		int currentY = 3;
		int currentX = 3;
		int row = -1;
		int col = 0;
		String expected = "RF";
		String actual = r.implementAlgorithm(direction, currentY, currentX, row, col);

		assertEquals(expected, actual);
	}

}
