package day11;

public class Day11 {

	private final int serialNumber;
	public final int[][] grid;
	public final int[] maxCoordinate;
	private final int squareSize;

	public int maxPower;
	private int maxSquareSize;

	public static void main(String[] args) {
		Day11 day = new Day11(18, 300);
		day.solve();
	}

	public Day11(int serialNumber, int gridDimension, int squareSize) {
		this.serialNumber = serialNumber;
		this.squareSize = squareSize;
		grid = new int[gridDimension][gridDimension];
		maxCoordinate = new int[2];
		this.maxPower = Integer.MIN_VALUE;
	}

	public Day11(int serialNumber, int gridDimension) {
		this.serialNumber = serialNumber;
		this.squareSize = 3;
		grid = new int[gridDimension][gridDimension];
		maxCoordinate = new int[2];
		this.maxPower = Integer.MIN_VALUE;
	}

	public void solve() {
		initializeGrid();
		if (squareSize == 3) {
			findMaxPower(squareSize);
		} else {
			for (int dimension = 1; dimension < squareSize; dimension++) {
				findMaxPower(dimension);
			}
		}
		System.out.println("Max power: " + maxPower + " at " + maxCoordinate[0] + ", " + maxCoordinate[1] + " when square size is " + maxSquareSize);
	}

	public void findMaxPower(int squareSize) {
		for (int i = 0; i < grid.length - squareSize; i++) {
			for (int j = 0; j < grid[0].length - squareSize; j++) {
				int currentPower = 0;
				for (int k = 0; k < squareSize; k++) {
					for (int l = 0; l < squareSize; l++) {
						currentPower += grid[i + k][j + l];
					}
				}
				if (currentPower > maxPower) {
					maxPower = currentPower;
					maxCoordinate[0] = i;
					maxCoordinate[1] = j;
					maxSquareSize = squareSize;
				}
			}
		}
	}

	public void initializeGrid() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				int rackID = i + 10;
				int beforeHundreds = (rackID * j + serialNumber) * rackID;
				grid[i][j] = (beforeHundreds % 1000 / 100) - 5;
			}
		}
	}

	@SuppressWarnings("unused")
	private void printGrid() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] >= 0) {
					System.out.print(" ");
				}
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}
}
