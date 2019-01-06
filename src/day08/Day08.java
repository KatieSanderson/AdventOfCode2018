package day08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Day08 {

	private final File file;

	public static void main(String[] args) throws FileNotFoundException {
		//		"src\\day09\\inputDay9Short.txt"
		//		Day08 day = new Day08(new File("src\\day08\\inputDay8.txt"));
		Day08 day = new Day08(new File("src\\day08\\inputDay08.txt"));
		//		Day08 day = new Day08(new File("C:\\Users\\Katie\\Documents\\Advent of Code\\8\\input.txt"));
		day.solve();
	}

	public Day08(File file2) {
		this.file = file2;
	}

	private void solve() throws FileNotFoundException {
		FormatNodes formatNodes = new FormatNodes(importData());
		formatNodes.findNodes();
		System.out.println("HeadNode sum: " + formatNodes.getHeadNode().getNodeSum());
	}

	private int[] importData() throws FileNotFoundException {
		Import importData = new Import(new BufferedReader(new FileReader(file)));
		importData.readFile();
		int[] importNums = importData.getNums();
		return importNums;
	}
}
