package day02;

public class Claim {
	
	private int claimNumber;
	private int leftEdge;
	private int upperEdge;
	private int width;
	private int height;
	
	public Claim(String line) {
		String[] lineNumbersInString = line.split("\\D+");
		int[] lineNumbers = new int[lineNumbersInString.length];
		for(int i = 1; i < lineNumbersInString.length; i++) {
			lineNumbers[i] = Integer.parseInt(lineNumbersInString[i]);
		}
		setClaimNumber(lineNumbers[1]);
		setLeftEdge(lineNumbers[2]);
		setUpperEdge(lineNumbers[3]);
		setWidth(lineNumbers[4]);
		setHeight(lineNumbers[5]);
	}

	public int getClaimNumber() {
		return claimNumber;
	}

	public void setClaimNumber(int claimNumber) {
		this.claimNumber = claimNumber;
	}

	public int getLeftEdge() {
		return leftEdge;
	}

	public void setLeftEdge(int leftEdge) {
		this.leftEdge = leftEdge;
	}

	public int getUpperEdge() {
		return upperEdge;
	}

	public void setUpperEdge(int upperEdge) {
		this.upperEdge = upperEdge;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	
}
