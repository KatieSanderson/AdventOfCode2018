package day3;
import java.util.HashMap;
import java.util.Map;

public class FindSums {
	
	public static Map<Character, Integer> findSums(String id) {
		Map<Character, Integer> charCounts = new HashMap<>();
		for (char c = 'a'; c <= 'z'; c++) {
			charCounts.put(c, 0);
		}
		for (char c : id.toCharArray()) {
			if (charCounts.containsKey(c)) {
				charCounts.put(c, charCounts.get(c) + 1);
			} else {
				charCounts.put(c, 1);
			}
		}
		return charCounts;
	}
}
