package day07;

import java.io.BufferedReader;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import day07.ImportAndFormatGraph;

@RunWith(MockitoJUnitRunner.class)
public class ImportAndFormatGraphTest {

	@Mock private BufferedReader reader;
	ImportAndFormatGraph graph;

	@Before
	public void setup() {
		graph = new ImportAndFormatGraph(reader);
	}

	@Test
	public void testTwoSteps() throws IOException {
		Mockito.when(reader.readLine()).thenReturn("Step A must be finished before step B can begin.").thenReturn(null);

		graph.resetGraph();

		Assert.assertArrayEquals(new int[][] {{0, 1}, {0, 0}}, graph.getGraph());

	}

	@Test
	public void testLinkedList() throws IOException {
		ImportAndFormatGraph graph = new ImportAndFormatGraph(reader);
		Mockito.when(reader.readLine())
		.thenReturn("Step A must be finished before step B can begin.")
		.thenReturn("Step B must be finished before step C can begin.")
		.thenReturn(null);

		graph.resetGraph();

		Assert.assertArrayEquals(new int[][] {{0, 1, 0}, {0, 0, 1}, {0, 0, 0}}, graph.getGraph());

	}

	@Test
	public void testTree() throws IOException {
		ImportAndFormatGraph graph = new ImportAndFormatGraph(reader);
		Mockito.when(reader.readLine())
		.thenReturn("Step A must be finished before step B can begin.")
		.thenReturn("Step A must be finished before step C can begin.")
		.thenReturn(null);

		graph.resetGraph();

		Assert.assertArrayEquals(new int[][] {{0, 1, 1}, {0, 0, 0}, {0, 0, 0}}, graph.getGraph());

	}

	@Test
	public void testDoubleTree() throws IOException {
		ImportAndFormatGraph graph = new ImportAndFormatGraph(reader);
		Mockito.when(reader.readLine())
		.thenReturn("Step A must be finished before step B can begin.")
		.thenReturn("Step A must be finished before step C can begin.")
		.thenReturn("Step B must be finished before step D can begin.")
		.thenReturn("Step B must be finished before step E can begin.")
		.thenReturn(null);

		graph.resetGraph();

		Assert.assertArrayEquals(new int[][] {{0, 1, 1, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}}, graph.getGraph());
	}
}
