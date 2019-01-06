package day09;

import java.io.BufferedReader;
import java.io.IOException;

public class ImportData {

	private int playersNum;
	private int finalMarbleVal;
	private final java.io.BufferedReader reader;

	public ImportData(BufferedReader reader) {
		this.reader = reader;
	}

	public void readFile() {
		String line;
		try {
			while ((line = reader.readLine()) != null) {
				int[] nums = importNums(line);
				setPlayersNum(nums[0]);
				setFinalMarbleVal(nums[1]);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public int[] importNums(String str) {
		String[] strSplit = str.split("\\D+");
		int[] lineNumbers = new int[strSplit.length];
		for (int i = 0; i < strSplit.length; i++) {
			lineNumbers[i] = Integer.parseInt(strSplit[i]);
		}
		return lineNumbers;
	}

	public int getPlayersNum() {
		return playersNum;
	}

	public void setPlayersNum(int playersNum) {
		this.playersNum = playersNum;
	}

	public int getFinalMarbleVal() {
		return finalMarbleVal;
	}

	public void setFinalMarbleVal(int finalMarbleVal) {
		this.finalMarbleVal = finalMarbleVal;
	}

}
