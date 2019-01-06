package day08;

import java.io.BufferedReader;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import day08.Import;

@RunWith(MockitoJUnitRunner.class)
public class ImportTest {

	@Mock private BufferedReader reader;
	Import imported;

	@Before
	public void setup() {
		imported = new Import(reader);
	}

	@Test
	public void oneNode() throws IOException {
		Mockito.when(reader.readLine()).thenReturn("0 3 10 11 12").thenReturn(null);

		imported.readFile();

		Assert.assertArrayEquals(new int[] {0, 3, 10, 11, 12}, imported.getNums());

	}

	@Test
	public void TwoNodes() throws IOException {
		Mockito.when(reader.readLine()).thenReturn("1 3 0 2 11 12 90 21 19").thenReturn(null);

		imported.readFile();

		Assert.assertArrayEquals(new int[] {1, 3, 0, 2, 11, 12, 90, 21, 19}, imported.getNums());

	}
}
