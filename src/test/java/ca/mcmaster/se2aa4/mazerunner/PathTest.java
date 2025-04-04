package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PathTest {
	private final char[][] testMaze = {
		{'#','#','#','#','#','#','#'},
		{'#',' ',' ',' ',' ',' ',' '},
		{'#','#','#',' ','#','#','#'},
		{'#',' ',' ',' ',' ',' ','#'},
		{'#','#','#',' ','#','#','#'},
		{' ',' ',' ',' ',' ',' ','#'},
		{'#','#','#','#','#','#','#'}
	};

	@Test
	public void findPath() {
		Path p = new Path(testMaze, 7, 7, 5, 1, "RIGHT");
		String expected = "FFFFFLLFFRFFRFFLLFFRFFRFFF";
		String actual = p.findPath();

		assertEquals(expected, actual);
	}

	@Test
	public void findPathFactorized() {
		Path p = new Path(testMaze, 7, 7, 5, 1, "RIGHT");
		String expected = "5F 2L 2F R 2F R 2F 2L 2F R 2F R 3F";
		String actual = p.findPathFactorized();

		assertEquals(expected, actual);
	}
}
