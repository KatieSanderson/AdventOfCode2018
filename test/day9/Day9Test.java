package day9;

import java.io.BufferedReader;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class Day9Test {

	@Mock private BufferedReader reader;
	ImportData imported;

	@Before
	public void setup() {
		imported = new ImportData(reader);
	}

	@Test
	public void oneNode() throws IOException {
		Mockito.when(reader.readLine()).thenReturn("10 players; last marble is worth 1618 points: high score is 8317").thenReturn(null);

		imported.readFile();

		//		Assert.assertArrayEquals(new int[] {0, 3, 10, 11, 12}, imported.getNums());

	}
}
