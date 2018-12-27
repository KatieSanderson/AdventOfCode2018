package day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImportAndFormatGraph {

	private int maxStep;
	private int[][] graph;
	private final java.io.BufferedReader reader;

	public ImportAndFormatGraph(BufferedReader reader) {
		this.reader = reader;
	}

	public int[] getSteps(String line) {
		int[] lineNumbers = new int[2];
		String[] wordsInString = line.split(" ");
		lineNumbers[0] = wordsInString[1].charAt(0) - 'A';
		lineNumbers[1] = wordsInString[7].charAt(0) - 'A';
		this.maxStep = Math.max(Math.max(maxStep, lineNumbers[0]), lineNumbers[1]);
		return lineNumbers;
	}

	public int[][] getGraph() {
		return graph;
	}

	public void resetGraph() {
		List<int[]> allSteps = new ArrayList<>();
		String line;
		try {
			while ((line = reader.readLine()) != null) {
				int[] steps = getSteps(line);
				allSteps.add(steps);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		setGraph(new int[maxStep + 1][maxStep + 1]);
		for (int i = 0; i < allSteps.size(); i++) {
			int[] steps = allSteps.get(i);
			graph[steps[0]][steps[1]] = 1;
		}
	}

	public void setGraph(int[][] graph) {
		this.graph = graph;
	}

}
