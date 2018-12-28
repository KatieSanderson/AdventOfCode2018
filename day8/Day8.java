package day8;

import java.io.File;
import java.io.FileNotFoundException;

public class Day8 {

	private final File file;

	public static void main(String[] args) throws FileNotFoundException {
		Day8 day = new Day8(new File("src\\day8\\inputDay8.txt"));
		//		Day8 day = new Day8(new File("C:\\Users\\Katie\\Documents\\Advent of Code\\8\\input.txt"));
		day.solve();
	}

	public Day8(File file) {
		this.file = file;
	}

	@SuppressWarnings("unused")
	public void solve() throws FileNotFoundException {
		Import importData = new Import(file);
		int[] importNums = importData.getNums();
		FormatNodes formatNodes = new FormatNodes(importNums);
	}
}
