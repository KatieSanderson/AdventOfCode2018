package day03;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class FindCorrectBoxes {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("input.txt");
		Scanner sc = new Scanner(file);
		try (Scanner next = new Scanner(file)) {
			while (sc.hasNextLine()) {
				String currentLine = sc.nextLine();
				Map<Character, Integer> currentSums = FindSums.findSums(currentLine);
				while (next.hasNextLine()) {
					String nextLine = next.nextLine();
					Map<Character, Integer> nextSums = FindSums.findSums(nextLine);
					int charsDifferent = 0;
					for (char c = 'a'; c <= 'z'; c++) {
						if (currentSums.get(c) != nextSums.get(c)) {
							charsDifferent += Math.abs(currentSums.get(c) - nextSums.get(c));
						}
					}
					if (charsDifferent == 2) {
						charsDifferent = 0;
						for (int i = 0; i < nextLine.length(); i++) {
							if (nextLine.charAt(i) != currentLine.charAt(i)) {
								charsDifferent++;
								if (charsDifferent > 1) {
									System.out.println(" Not a valid solution");
									break;
								}
							} else {
								System.out.print(nextLine.charAt(i));
							}
						}
						System.out.println("");
					}
				}
			}
		}
		sc.close();
	}
}
