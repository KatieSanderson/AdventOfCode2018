package day02;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day02 {

	public static void main(String[] args) throws FileNotFoundException {
		int[][] fabric = new int[1000][1000];
		File file = new File("src\\day02\\inputDay02.txt");
		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				addClaim(fabric, scanner);
			}
		}
		try (Scanner check = new Scanner(file)) {
			while (check.hasNextLine()) {
				checkClaim(fabric, check);
			}
		}
		System.out.println(countOverlap(fabric));
		return;
	}

	private static boolean checkClaim(int[][] fabric, Scanner check) {
		Claim claim = new Claim(check.nextLine());
		int claimNumber = claim.getClaimNumber();
		int leftEdge = claim.getLeftEdge();
		int upperEdge = claim.getUpperEdge();
		int width = claim.getWidth();
		int height = claim.getHeight();
		for (int i = upperEdge; i < (upperEdge + height); i++) {
			for (int j = leftEdge; j < (leftEdge + width); j++) {
				if (fabric[i][j] != claimNumber) {
					return false;
				}
			}
		}
		System.out.println("Santa's Solution is Claim #" + claimNumber);
		return true;
	}

	private static int countOverlap(int[][] fabric) {
		int count = 0;
		for (int i = 0; i < fabric.length; i++) {
			for (int j = 0; j < fabric[0].length; j++) {
				if (fabric[i][j] == Integer.MAX_VALUE) {
					count++;
				}
			}
		}
		return count;
	}

	private static void addClaim(int[][] fabric, Scanner sc) {
		Claim claim = new Claim(sc.nextLine());
		int claimNumber = claim.getClaimNumber();
		int leftEdge = claim.getLeftEdge();
		int upperEdge = claim.getUpperEdge();
		int width = claim.getWidth();
		int height = claim.getHeight();
		for (int i = upperEdge; i < (upperEdge + height); i++) {
			for (int j = leftEdge; j < (leftEdge + width); j++) {
				if (fabric[i][j] == 0) {
					fabric[i][j] = claimNumber;
				} else {
					fabric[i][j] = Integer.MAX_VALUE;
				}
			}
		}
	}
}
