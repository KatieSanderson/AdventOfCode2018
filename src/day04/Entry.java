package day04;

public class Entry {
	
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	private int guardID;
	private boolean isAsleep;
	private Integer date;
	
	public Entry(String line) {
		String[] lineNumbersInString = line.split("\\D+");
		int[] lineNumbers = new int[lineNumbersInString.length];
		for(int i = 1; i < lineNumbersInString.length; i++) {
			lineNumbers[i] = Integer.parseInt(lineNumbersInString[i]);
		}		
		setYear(lineNumbers[1]);
		setMonth(lineNumbers[2]);
		setDay(lineNumbers[3]);
		setHour(lineNumbers[4]);
		setMinute(lineNumbers[5]);
		setDate(getYear() * 100 * 100 * 100 * 100 + getMonth() * 100 * 100 * 100 + getDay() * 100 * 100 + getHour() * 100 + getMinute());
		if (lineNumbers.length > 6) {
			setGuardID(lineNumbers[6]);
		} else {
			setGuardID(0);
		}
		if (line.contains("falls asleep")) {
			setIsAsleep(true);
		}
		if (line.contains("wakes up")) {
			setIsAsleep(false);
		}

	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getGuardID() {
		return guardID;
	}

	public void setGuardID(int guardID) {
		this.guardID = guardID;
	}

	public boolean getIsAsleep() {
		return isAsleep;
	}

	public void setIsAsleep(boolean isAsleep) {
		this.isAsleep = isAsleep;
	}

	public Integer getDate() {
		return date;
	}

	public void setDate(Integer date) {
		this.date = date;
	}
	
}