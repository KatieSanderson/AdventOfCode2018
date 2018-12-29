package day4;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day4 {
	
	public static void main(String[] args) throws FileNotFoundException {
		Map<Integer, int[]> minutesPerGuard = new HashMap<>();
		List<Entry> entries = ExportEntry.exportAndSort();
		int currentGuard = 0;
		int startSleep = 0;
		for (int i = 0; i < entries.size(); i++) {
			Entry nextEntry = entries.get(i);
			int guardID = nextEntry.getGuardID();
			if (guardID != 0) {
				currentGuard = guardID;
			} else {
				if (nextEntry.getIsAsleep()) {
					startSleep = nextEntry.getMinute();
				} else {
					if (minutesPerGuard.containsKey(currentGuard)) {
						int[] minutes = minutesPerGuard.get(currentGuard);
						for (int j = startSleep; j < nextEntry.getMinute(); j++) {
							minutes[j] = minutes[j] + 1;
						}
					} else {
						int[] minutes = new int[60];
						for (int j = startSleep; j < nextEntry.getMinute(); j++) {
							minutes[j] = 1;
						}
						minutesPerGuard.put(currentGuard, minutes);
					}					
				}
			}
		}
		int maxMinutesAsleep = 0;
		int maxGuardID = 0;
		int maxMinuteAsleep = 0;
		int maxMinuteAsleepMinute = 0;
		int maxMinuteAsleepGuard = 0;
		for (Map.Entry<Integer, int[]> entry : minutesPerGuard.entrySet()) {
			int currentMinutesAsleep = 0;
			int[] minutes = entry.getValue();
			for (int i = 0; i < minutes.length; i++) {
				currentMinutesAsleep += minutes[i];
				if (minutes[i] > maxMinuteAsleep) {
					maxMinuteAsleepMinute = i;
					maxMinuteAsleepGuard = entry.getKey();
					maxMinuteAsleep = minutes[i];
				}
			}
			if (currentMinutesAsleep > maxMinutesAsleep) {
				maxMinutesAsleep = currentMinutesAsleep;
				maxGuardID = entry.getKey();
			}
			currentMinutesAsleep = 0;
		}
		System.out.println("Guard " + maxMinuteAsleepGuard + " spent min " + maxMinuteAsleepMinute + " the most, for " + maxMinuteAsleep + "minutes");
		System.out.println("Part two answer is : " + maxMinuteAsleepGuard * maxMinuteAsleepMinute);
		int minuteAsleepMost = 0;
		int maxMinute = 0;
		for (int i = 0; i < minutesPerGuard.get(maxGuardID).length; i++) {
			int[] mins = minutesPerGuard.get(maxGuardID);
			if (minuteAsleepMost < mins[i]) {
				minuteAsleepMost = mins[i];
				maxMinute = i;
			}
		}
		System.out.println("Guard " + maxGuardID + " is asleep the most at minute" + maxMinute + " for answer of " + maxGuardID * maxMinute);
	}
}
