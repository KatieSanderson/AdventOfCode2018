package day06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExportEntry {

	private int maxX = Integer.MIN_VALUE;
	private int maxY = Integer.MIN_VALUE;
	private int minX = Integer.MAX_VALUE;
	private int minY = Integer.MAX_VALUE;
	private List<int[]> entries;

	public ExportEntry(File file) throws FileNotFoundException {
		entries = new ArrayList<>();
		Scanner scanner = new Scanner(file);
		while (scanner.hasNext()) {
			int[] coords = formatEntry(scanner.nextLine());
			entries.add(coords);
		}
		scanner.close();
	}

	public int[] formatEntry(String line) {
		int[] lineNumbers = new int[2];
		String[] lineNumbersInString = line.split("\\D+");
		for(int i = 0; i < lineNumbersInString.length; i++) {
			lineNumbers[i] = Integer.parseInt(lineNumbersInString[i]);
		}
		this.setMaxX(Math.max(this.getMaxX(), lineNumbers[0]));
		this.setMaxY(Math.max(this.getMaxY(), lineNumbers[1]));
		this.setMinX(Math.min(this.getMinX(), lineNumbers[0]));
		this.setMinY(Math.min(this.getMinY(), lineNumbers[1]));
		return lineNumbers;
	}

	public int getMaxX() {
		return maxX;
	}

	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}

	public int getMaxY() {
		return maxY;
	}

	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}

	public List<int[]> getEntries() {
		return entries;
	}

	public void setEntries(List<int[]> entries) {
		this.entries = entries;
	}

	public int getMinX() {
		return minX;
	}

	public void setMinX(int minX) {
		this.minX = minX;
	}

	public int getMinY() {
		return minY;
	}

	public void setMinY(int minY) {
		this.minY = minY;
	}

}
