<<<<<<< HEAD
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
=======
package day8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Day8 {

	private final File file;

	public static void main(String[] args) throws FileNotFoundException {
		Day8 day = new Day8(new File("src\\day8\\inputDay8.txt"));
		//		Day8 day = new Day8(new File("C:\\Users\\Katie\\Documents\\Advent of Code\\8\\input.txt"));
		day.solve();
	}

	public Day8(File file2) {
		this.file = file2;
	}

	public void solve() throws FileNotFoundException {
		Import importData = new Import(new BufferedReader(new FileReader(file)));
		importData.readFile();
		int[] importNums = importData.getNums();
		FormatNodes formatNodes = new FormatNodes(importNums);
		formatNodes.findNodes();
		System.out.println("Metadata sum: " + formatNodes.getMetadataSum());
	}
}
>>>>>>> Added tests to Day8
