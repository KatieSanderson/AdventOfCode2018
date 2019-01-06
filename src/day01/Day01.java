package day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Day01 {

	public static void main(String[] args) throws FileNotFoundException {
		Set<Integer> frequencies = new HashSet<>();
		File file = new File("src\\day01\\inputDay01.txt");
		Scanner sc = new Scanner(file);
		int currentFrequency = 0;
		while (true) {
			while (sc.hasNextLine()) {
				currentFrequency += Integer.parseInt(sc.nextLine());
				if (frequencies.contains(currentFrequency)) {
					sc.close();
					System.out.println("First duplicate frequency: " + currentFrequency);
					return;
				} else {
					frequencies.add(currentFrequency);
				}
			}
			sc = new Scanner(file);
		}
	}
}
