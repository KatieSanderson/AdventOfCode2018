package day10;

public class Point {

	private final int xPosition;
	private final int yPosition;
	private final int xVelocity;
	private final int yVelocity;
	private int xCurrent;
	private int yCurrent;

	public Point(int[] input) {
		this.xPosition = input[1];
		this.yPosition = input[2];
		this.xVelocity = input[3];
		this.yVelocity = input[4];
		this.setxCurrent(xPosition);
		this.setyCurrent(yPosition);
	}

	public int getxPosition() {
		return xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

	public int getxVelocity() {
		return xVelocity;
	}

	public int getyVelocity() {
		return yVelocity;
	}

	public int getxCurrent() {
		return xCurrent;
	}

	public void setxCurrent(int xCurrent) {
		this.xCurrent = xCurrent;
	}

	public int getyCurrent() {
		return yCurrent;
	}

	public void setyCurrent(int yCurrent) {
		this.yCurrent = yCurrent;
	}
}
