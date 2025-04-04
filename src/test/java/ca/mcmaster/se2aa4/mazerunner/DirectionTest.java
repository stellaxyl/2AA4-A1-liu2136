package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class DirectionTest {
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
	public void updateDirection() {
		Direction direction = new Direction("LEFT", testMaze, 7, 7);
		String move = "R";
		direction.updateDirection(move);
		assertEquals("UP", direction.getDirection());
	}
}
