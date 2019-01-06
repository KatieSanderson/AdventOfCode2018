package day07;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Day07 {

	private final List<Elf> elves;
	private final File file;
	private final int numOfElves;

	private int time;

	public static void main(String[] args) throws FileNotFoundException {
		for (int i = 1; i <= 6; i++) {
			Day07 day = new Day07(new File ("src\\day07\\inputDay07.txt"), i);
			day.solve();
		}
	}

	public Day07(File file, int numOfElves) {
		this.numOfElves = numOfElves;
		this.file = file;
		this.elves = new ArrayList<>();
	}

	public void solve() throws FileNotFoundException {
		ImportAndFormatGraph importedGraph = new ImportAndFormatGraph(new BufferedReader(new FileReader(file)));
		Queue<Integer> availableSteps = new PriorityQueue<>();
		List<Character> stepsOrder = new ArrayList<>();
		for (int i = 0; i < numOfElves; i++) {
			elves.add(new Elf());
		}
		importedGraph.resetGraph();
		int[][] graph = importedGraph.getGraph();
		findStarterSteps(graph, availableSteps);
		time = 0;
		boolean isCountPositive = true;
		while (!availableSteps.isEmpty() || isCountPositive) {
			addSteps(availableSteps, stepsOrder, graph);
			isCountPositive = false;
			for (Elf elf : elves) {
				if (elf.getCount() > - 1) {
					isCountPositive = true;
					break;
				}
			}
		}
		for (int i = 0; i < stepsOrder.size(); i++) {
			System.out.print(stepsOrder.get(i));
		}
		System.out.println();
		System.out.println("Time: " + time);
	}

	private void addSteps(Queue<Integer> availableSteps, List<Character> stepsOrder, int[][] graph) {
		for (Elf elf : elves) {
			if (availableSteps.size() > 0 && elf.getCount() < 0) {
				elf.setStep(availableSteps.poll());
				elf.setCount(elf.getStep() + 60);
			}
		}
		for (Elf elf : elves) {
			countdownAdd(availableSteps, stepsOrder, graph, elf);
		}
		time++;
	}

	public void countdownAdd(Queue<Integer> availableSteps, List<Character> stepsOrder, int[][] graph, Elf elf) {
		if (elf.getCount() == 0) {
			for (int i = 0; i < graph[0].length; i++) {
				if (graph[elf.getStep()][i] == 1) {
					graph[elf.getStep()][i] = 0;
					if (isFreeStep(graph, i)) {
						availableSteps.add(i);
					}
				}
			}
			stepsOrder.add((char) (elf.getStep() + 'A'));
			elf.setCount(-1);
		} else if (elf.getStep() > -1 && elf.getCount() > -1) {
			elf.setCount(elf.getCount() - 1);
		}
	}

	private boolean isFreeStep(int[][] graph, int step) {
		for (int i = 0; i < graph.length; i++) {
			if (graph[i][step] != 0) {
				return false;
			}
		}
		return true;
	}

	private void findStarterSteps(int[][] graph, Queue<Integer> availableSteps) {
		for (int i = 0; i < graph[0].length; i++) {
			for (int j = 0; j < graph.length; j++) {
				if (graph[j][i] == 1) {
					break;
				} else if (j == graph.length - 1) {
					availableSteps.add(i);
				}
			}
		}
	}

	@SuppressWarnings("unused")
	private void printGraph(int[][] graph) {
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph.length; j++) {
				System.out.print(graph[i][j]);
			}
			System.out.println();
		}
	}
}
