package day10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class Day10Test {

	@Mock private BufferedReader reader;
	Import imported;
	List<Point> points;
	Day10 day;

	@Before
	public void setup() throws FileNotFoundException {
		imported = new Import(reader);
		day = new Day10(new File ("src\\day10\\inputDay10Long.txt"));
	}

	@Test
	public void onePoint() throws IOException {
		Mockito.when(reader.readLine()).thenReturn("position=< 9,  1> velocity=< 0,  2>").thenReturn(null);

		imported.readFile();
		points = imported.getPoints();

		for (Point point : points) {
			Assert.assertEquals(9, point.getxCurrent());
			Assert.assertEquals(1, point.getyCurrent());
			Assert.assertEquals(0, point.getxVelocity());
			Assert.assertEquals(2, point.getyVelocity());
		}
	}

	public void firstWasMinimumTest() {
		//can't test because they're all private
	}


}
