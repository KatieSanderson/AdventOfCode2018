package day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Import {

	private final BufferedReader reader;
	private final List<Point> points;
	private int maxX;
	private int maxY;
	private int minX;
	private int minY;

	public Import(BufferedReader reader) {
		this.reader = reader;
		setMaxX(Integer.MIN_VALUE);
		setMaxY(Integer.MIN_VALUE);
		setMinX(Integer.MAX_VALUE);
		setMinY(Integer.MAX_VALUE);
		points = new ArrayList<>();
		readFile();
	}

	public void readFile() {
		String line;
		try {
			while ((line = reader.readLine()) != null) {
				points.add(new Point(importNums(line)));
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public int[] importNums(String str) {
		String[] strSplit = str.split("[^\\d-]+");
		int[] lineNumbers = new int[strSplit.length];
		for (int i = 1; i < strSplit.length; i++) {
			lineNumbers[i] = Integer.parseInt(strSplit[i]);
		}
		setMaxX(Math.max(lineNumbers[1], maxX));
		setMinX(Math.min(lineNumbers[1], minX));
		setMaxY(Math.max(lineNumbers[2], maxY));
		setMinY(Math.min(lineNumbers[2], minY));
		return lineNumbers;
	}

	public List<Point> getPoints() {
		return points;
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
