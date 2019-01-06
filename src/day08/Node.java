package day08;

import java.util.ArrayList;
import java.util.List;

public class Node {

	int childrenCount;
	int metadataCount;
	int nodeSum;
	public List<Node> children;
	public List<Integer> metadata;

	public Node(int childrenCount, int metadataCount) {
		this.childrenCount = childrenCount;
		this.metadataCount = metadataCount;
		children = new ArrayList<>(childrenCount);
		metadata = new ArrayList<>(metadataCount);
	}

	public int getNodeSum() {
		return nodeSum;
	}

	public void setNodeSum(int nodeSum) {
		this.nodeSum = nodeSum;
	}

}
