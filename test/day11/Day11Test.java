package day11;

import java.io.BufferedReader;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class Day11Test {

	@Mock private BufferedReader reader;

	@Test
	public void sq1sn1() throws IOException {
		Day11 day = new Day11(1, 1);

		day.solve();

		Assert.assertArrayEquals(new int[] {0, 0}, day.maxCoordinate);
		Assert.assertEquals(-5, day.maxPower);
	}

	@Test
	public void firstGivenTest18() throws IOException {
		Day11 day = new Day11(18, 300);

		day.solve();

		Assert.assertArrayEquals(new int[] {33, 45}, day.maxCoordinate);
		Assert.assertEquals(29, day.maxPower);
	}

	@Test
	public void firstGivenTest42() throws IOException {
		Day11 day = new Day11(42, 300);

		day.solve();

		Assert.assertArrayEquals(new int[] {21, 61}, day.maxCoordinate);
		Assert.assertEquals(30, day.maxPower);
	}
}
