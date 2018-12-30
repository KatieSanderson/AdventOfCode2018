package day8;

import java.io.BufferedReader;
import java.io.IOException;

public class Import {

	private int[] nums;
	private final java.io.BufferedReader reader;

	public Import(BufferedReader reader) {
		this.reader = reader;
	}

	public void readFile() {
		String line;
		try {
			while ((line = reader.readLine()) != null) {
				setNums(importNums(line));
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public int[] importNums(String str) {
		String[] strSplit = str.split(" ");
		int[] lineNumbers = new int[strSplit.length];
		for (int i = 0; i < strSplit.length; i++) {
			lineNumbers[i] = Integer.parseInt(strSplit[i]);
			System.out.print(lineNumbers[i] + " ");
		}
		System.out.println();
		return lineNumbers;
	}

	public int[] getNums() {
		return nums;
	}

	public void setNums(int[] nums) {
		this.nums = nums;
	}
}