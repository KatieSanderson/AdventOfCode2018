package day10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class Day10 {

	private final List<Point> points;

	private int second;
	private int widthX;
	private int widthY;
	//	private int[] max;
	//	private int[] min;
	private int maxX;
	private int minX;
	private int maxY;
	private int minY;

	public Day10(File file) throws FileNotFoundException {
		Import importData = new Import(new BufferedReader(new FileReader(file)));
		this.points = importData.getPoints();
	}

	public static void main(String[] args) throws FileNotFoundException {
		//			Day10 day = new Day10(new File ("src\\day10\\inputDay10Short.txt"), scanner);
		Day10 day = new Day10(new File ("src\\day10\\inputDay10Long.txt"));
		day.solve();
	}

	public void solve() {
		initializeValues();
		do {
			watch(1);
		} while (!wasMinimum());
		watch(-1);
		printGrid();
		System.out.println("Wow! It took " + second + " seconds to see that message!");
	}

	public boolean wasMinimum() {
		int currentWidthX = maxX - minX;
		int currentWidthY = maxY - minY;
		if (widthX < currentWidthX) {
			return true;
		} else {
			widthX = currentWidthX;
		}
		if (widthY < currentWidthY) {
			return true;
		} else {
			widthY = currentWidthY;
		}

		return false;
	}

	public void watch(int time) {
		int currentMaxX = Integer.MIN_VALUE;
		int currentMinX = Integer.MAX_VALUE;
		int currentMaxY = Integer.MIN_VALUE;
		int currentMinY = Integer.MAX_VALUE;
		for (Point point : points) {
			point.setxCurrent(point.getxCurrent() + point.getxVelocity() * time);
			point.setyCurrent(point.getyCurrent() + point.getyVelocity() * time);
			currentMaxX = Math.max(currentMaxX, point.getxCurrent());
			currentMinX = Math.min(currentMinX, point.getxCurrent());
			currentMaxY = Math.max(currentMaxY, point.getyCurrent());
			currentMinY = Math.min(currentMinY, point.getyCurrent());
		}
		maxX = currentMaxX;
		minX = currentMinX;
		maxY = currentMaxY;
		minY = currentMinY;
		second += time;
	}

	public void initializeValues() {
		second = 0;
		widthX = Integer.MAX_VALUE;
		widthY = Integer.MAX_VALUE;
		maxX = Integer.MIN_VALUE;
		minX = Integer.MAX_VALUE;
		maxY = Integer.MIN_VALUE;
		minY = Integer.MAX_VALUE;
	}

	public void printGrid() {
		char[][] grid = new char[maxY - minY + 1][maxX - minX + 1];
		for (Point point : points) {
			grid[point.getyCurrent() - minY][point.getxCurrent() - minX] = '#';
		}
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}
}
