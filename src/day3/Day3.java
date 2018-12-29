package day3;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class Day3 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("src\\day3\\inputDay3.txt");
		Scanner sc = new Scanner(file);
		int dupSum = 0;
		int tripSum = 0;
		while (sc.hasNextLine()) {
			Map<Character, Integer> nextSums = FindSums.findSums(sc.nextLine());
			boolean dupFound = false;
			boolean tripFound = false;
			for (Map.Entry<Character, Integer> entry : nextSums.entrySet()) {
				if (entry.getValue() == 2) {
					dupFound = true;
				} else if (entry.getValue() == 3) {
					tripFound = true;
				}
			}
			dupSum += dupFound ? 1 : 0;
			tripSum += tripFound ? 1 : 0;
		}
		sc.close();
		System.out.println(dupSum * tripSum);
	}
}
