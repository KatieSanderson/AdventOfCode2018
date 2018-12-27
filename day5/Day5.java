package day5;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day5 {

	private final File file;

	public static void main(String[] args) throws FileNotFoundException {
		Day5 day = new Day5(new File("src\\day5\\inputDay5.txt"));
		day.solve();
	}

	public void solve() throws FileNotFoundException {
		int minLength = Integer.MAX_VALUE;
		for (int i = 0; i < 26; i++) {
			Character current = new Character((char) (i + 'A'));
			minLength = Math.min(minLength, removeChar(current, file));
		}
		int maxOccur = 0;
		Map<Character, Integer> charOccurences = new HashMap<>();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < builder.length(); i++) {
			Character current = new Character(builder.charAt(i));
			current = Character.toLowerCase(current);
			if (charOccurences.containsKey(current)) {
				maxOccur = Math.max(maxOccur, charOccurences.get(current) + 1);
				charOccurences.put(current, charOccurences.get(current) + 1);
			} else {
				charOccurences.put(current, 1);
			}
		}
		for (Map.Entry <Character, Integer> entry : charOccurences.entrySet()) {
			System.out.println(entry.getKey() + " would have length " + (builder.length() - entry.getValue()));
		}
		System.out.println("The smallest length is " + (builder.length() - maxOccur));
	}

	public Day5(File file) {
		this.file = file;
	}

	public int removeChar(char key, File file) throws FileNotFoundException {
		try (Scanner scanner = new Scanner(file)) {
			String input = scanner.next();
			return removeChar(input, key).length();
		}
	}

	public String removeChar(String input, char key) {
		StringBuilder builder = new StringBuilder();
		int index = 0;
		if (input.length() == 0) {
			return "";
		}
		char previous = input.charAt(index);
		index++;
		while ((previous == key || previous == key + 32) && index < input.length()) {
			previous = input.charAt(index);
			index++;
		}
		while (index < input.length()) {
			char next = input.charAt(index);
			int distance = Math.abs(next - previous);
			if (next != key && next != (key + 32)) {
				if (distance == ('a' - 'A')) {
					if (builder.length() < 1) {
						previous = input.charAt(index);
					} else {
						previous = builder.charAt(builder.length() - 1);
						builder.deleteCharAt(builder.length() - 1);
					}
				} else {
					builder.append(previous);
					previous = next;
				}
			}
			index++;
		}
		char last = input.charAt(input.length() - 1);
		if ((last != key || last != (key + 32)) && index == input.length() - 1) {
			builder.append(last);
		}
		return builder.toString();
	}
}
