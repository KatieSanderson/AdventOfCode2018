package day8;

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
		children = new ArrayList<>();
		metadata = new ArrayList<>();
	}


}
