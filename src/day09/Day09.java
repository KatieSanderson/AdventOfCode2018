package day09;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Day09 {

	private final File file;
	private int playersNum;
	private int finalMarbleVal;
	private final List<Integer> circle;
	private final List<Player> players;
	private int highestScore;

	public Day09(File file) {
		this.file = file;
		players = new ArrayList<>();
		circle = new ArrayList<>();
	}

	public static void main(String[] args) throws FileNotFoundException {
		Day09 day = new Day09(new File("src\\day09\\inputDay09Long.txt"));
		//		Day09 day = new Day09(new File("src\\day09\\inputDay9Short.txt"));
		//		Day09 day = new Day09(new File("C:\\Users\\Katie\\Documents\\Advent of Code\\9\\input.txt"));
		day.solve();
	}

	private void solve() throws FileNotFoundException {
		importData();
		for (int i = 0; i < playersNum; i++) {
			players.add(new Player());
		}
		playGame();
		System.out.println("Highest score is: " + highestScore);
	}

	private void playGame() {
		int marble = 0;
		int current = -1;
		highestScore = 0;
		while (marble <= finalMarbleVal) {
			for (Player player : players) {
				//				for (int i = 0; i < circle.size(); i++) {
				//					System.out.print(circle.get(i) + " ");
				//				}
				//				System.out.println();
				if (marble > finalMarbleVal) {
					break;
				}
				if (marble > 0 && marble % 23 == 0) {
					current -= 7;
					current = (current + circle.size()) % circle.size();
					player.setScore(player.getScore() + marble + circle.get(current));
					highestScore = Math.max(player.getScore(), highestScore);
					circle.remove(current);
				} else {
					if (current + 2 >= circle.size() + 1) {
						if (circle.size() > 0) {
							circle.add(1, marble);
						} else {
							circle.add(circle.size(), marble);
						}
						current = 1;
					} else {
						circle.add(current + 2, marble);
						current += 2;
					}
				}
				marble++;
			}
		}
	}

	public void importData() throws FileNotFoundException {
		ImportData data = new ImportData(new BufferedReader(new FileReader(file)));
		data.readFile();
		finalMarbleVal = data.getFinalMarbleVal();
		playersNum = data.getPlayersNum();
	}
}
