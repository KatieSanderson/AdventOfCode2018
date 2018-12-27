package day4;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ExportEntry {

	public static List<Entry> exportAndSort() throws FileNotFoundException {
		List<Entry> entries = new ArrayList<>();
		File file = new File("src\\day4\\inputDay4.txt");
		Scanner scanner = new Scanner(file);
		while (scanner.hasNext()) {
			Entry nextEntry = new Entry(scanner.nextLine());
			entries.add(nextEntry);
		}
		Collections.sort(entries, new Comparator<Entry>() {
			@Override
			public int compare(Entry e1, Entry e2) {
				return e1.getDate().compareTo(e2.getDate());
			}
		});
		scanner.close();
		return entries;
	}
}