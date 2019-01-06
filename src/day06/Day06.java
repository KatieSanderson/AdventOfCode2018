package day06;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Day06 {

	public static void main(String[] args) throws FileNotFoundException {
		ExportEntry exportedEntries = new ExportEntry(new File("src\\day06\\inputDay06.txt"));
		List<int[]> coords = exportedEntries.getEntries();
		Set<Integer> edges = new HashSet<>();
		int maxX = exportedEntries.getMaxX();
		int maxY = exportedEntries.getMaxY();
		int minX = exportedEntries.getMinX();
		int minY = exportedEntries.getMinY();
		int nearbyLimit = 10000;
		int startI = 0;
		int startJ = 0;
		int endI = maxX + 4;
		int endJ = maxY + 4;
		int[][] grid = new int[maxX + 4][maxY + 4];
		int nearbyCount = 0;
		for (int i = startI; i < endI; i++) {
			for (int j = startJ; j < endJ; j++) {
				int minDistanceVal = 0;
				int minDistance = Integer.MAX_VALUE;
				int distance = 0;
				for (int k = 1; k <= coords.size(); k++) {
					int[] coord = coords.get(k - 1);
					int xDistance = Math.abs(coord[0] - j);
					int yDistance = Math.abs(coord[1] - i);
					distance += (xDistance + yDistance);
					if (distance < minDistance) {
						minDistanceVal = k;
						minDistance = distance;
					} else if (distance == minDistance) {
						minDistanceVal = 0;
					}
				}
				if (distance < nearbyLimit) {
					nearbyCount++;
				}
				grid[i][j] = minDistanceVal;
				if (i == startI || j == startJ || i == endI || j == endJ) {
					edges.add(minDistanceVal);
				}
			}
		}
		Map<Integer, Integer> counts = new HashMap<>();
		int maxCount = Integer.MIN_VALUE;
		for (int i = minX; i < maxX; i++) {
			for (int j = minY; j < maxY; j++) {
				int index = grid[i][j];
				if (index == 0 || edges.contains(index)) {
					continue;
				}
				if (!counts.containsKey(index)) {
					counts.put(index, 0);
				}
				counts.put(index, counts.get(index) + 1);
				maxCount = Math.max(maxCount, counts.get(index));
			}

		}
		System.out.println(maxCount);
		System.out.println(nearbyCount);
	}
}
