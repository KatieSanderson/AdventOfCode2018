<<<<<<< HEAD
package day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Import {

	private int[] nums;

	public Import(File file) throws FileNotFoundException {
		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNext()) {
				String str = scanner.nextLine();
				System.out.println(str);
				setNums(importNums(str));
			}
		}
	}

	public int[] importNums(String str) {
		String[] strSplit = str.split(" ");
		int[] lineNumbers = new int[strSplit.length];
		for (int i = 0; i < strSplit.length; i++) {
			lineNumbers[i] = Integer.parseInt(strSplit[i]);
		}
		return lineNumbers;
	}

	public int[] getNums() {
		return nums;
	}

	public void setNums(int[] nums) {
		this.nums = nums;
	}
}
=======
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
		}
		return lineNumbers;
	}

	public int[] getNums() {
		return nums;
	}

	public void setNums(int[] nums) {
		this.nums = nums;
	}
}
>>>>>>> Added tests to Day8
