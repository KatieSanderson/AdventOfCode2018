package day08;

public class FormatNodes {

	private int current;
	private int[] nums;
	private Node headNode;

	public FormatNodes(int[] nums) {
		this.nums = nums;
	}

	public void findNodes() {
		current = 0;
		headNode = new Node(nums[current], nums[current + 1]);
		current += 2;
		addChildren(headNode);
		calculateNodeSumWithChildren(headNode);
	}


	private void addChildren(Node parent) {
		int count = parent.childrenCount;
		for (int i = 0; i < count; i++) {
			Node currentChild = new Node(nums[current], nums[current + 1]);
			current += 2;
			parent.children.add(currentChild);
			if (currentChild.childrenCount == 0) {
				calculateNodeSumNoChildren(currentChild);
			} else {
				addChildren(currentChild);
				calculateNodeSumWithChildren(currentChild);
			}
		}
	}

	public int getNodeSum(Node node) {
		return node.nodeSum;
	}

	public void calculateNodeSumNoChildren(Node node) {
		int nodeSum = 0;
		int count = node.metadataCount;
		for (int i = 0; i < count; i++) {
			int currentMetaData = nums[current + i];
			node.metadata.add(currentMetaData);
			nodeSum += currentMetaData;
		}
		node.setNodeSum(nodeSum);
		current += count;
	}

	private void calculateNodeSumWithChildren(Node node) {
		int count = node.metadataCount;
		int nodeSum = 0;
		for (int i = 0; i < count; i++) {
			int currentMetaData = nums[current + i] - 1;
			node.metadata.add(currentMetaData);
			if (currentMetaData < node.children.size()) {
				int childSum = node.children.get(currentMetaData).getNodeSum();
				nodeSum += childSum;
			}
		}
		node.setNodeSum(nodeSum);
		current += count;
	}

	public Node getHeadNode() {
		return this.headNode;
	}

}