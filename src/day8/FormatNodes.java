<<<<<<< HEAD
package day8;

import java.util.Stack;

public class FormatNodes {

	private int metadataSum;
	private int current;
	private Stack<Integer> childCount;
	private Stack<Integer> metadataCount;
	private int[] nums;


	public FormatNodes(int[] nums) {
		this.nums = nums;
		this.childCount = new Stack<>();
		this.metadataCount = new Stack<>();
		findNodes();
	}

	private void findNodes() {
		current = 0;
		while (current < nums.length) {
			addCounts();
			if (childCount.isEmpty()) {
				while (!metadataCount.isEmpty()) {
					addMetadata();
				}
			}
			while (!childCount.isEmpty() && childCount.peek() == 0) {
				addMetadata();
			}
		}
		System.out.println("metadataSum: " + metadataSum);
	}

	private void addMetadata() {
		childCount.pop();
		int count = metadataCount.pop();
		for (int i = 0; i < count; i++) {
			metadataSum += nums[current];
			current++;
		}
	}

	private void addCounts() {
		if (!childCount.isEmpty()) {
			childCount.push(childCount.pop() - 1);
		}
		childCount.push(nums[current]);
		current++;
		metadataCount.push(nums[current]);
		current++;
	}

	public int getMetadataSum() {
		return metadataSum;
	}

	public void setMetadataSum(int metadataSum) {
		this.metadataSum = metadataSum;
	}

}
=======
package day8;

import java.util.Stack;

public class FormatNodes {

	private int metadataSum;
	private int current;
	private Stack<Integer> childCount;
	private Stack<Integer> metadataCount;
	private int[] nums;


	public FormatNodes(int[] nums) {
		this.nums = nums;
		this.childCount = new Stack<>();
		this.metadataCount = new Stack<>();
	}

	public void findNodes() {
		current = 0;
		while (current < nums.length) {
			addCounts();
			if (childCount.isEmpty()) {
				while (!metadataCount.isEmpty()) {
					addMetadata();
				}
			}
			while (!childCount.isEmpty() && childCount.peek() == 0) {
				addMetadata();
			}
		}
	}

	private void addMetadata() {
		childCount.pop();
		int count = metadataCount.pop();
		for (int i = 0; i < count; i++) {
			metadataSum += nums[current];
			current++;
		}
	}

	private void addCounts() {
		if (!childCount.isEmpty()) {
			childCount.push(childCount.pop() - 1);
		}
		childCount.push(nums[current]);
		current++;
		metadataCount.push(nums[current]);
		current++;
	}

	public int getMetadataSum() {
		return metadataSum;
	}

}
>>>>>>> Added tests to Day8
