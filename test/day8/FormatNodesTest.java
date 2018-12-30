package day8;

import org.junit.Assert;
import org.junit.Test;

public class FormatNodesTest {

	FormatNodes formatNodes;
	private static final int METADATA1 = 7;
	private static final int METADATA2 = 8;
	private static final  int METADATA3 = 9;

	@Test
	public void oneNode() {
		formatNodes = new FormatNodes(new int[] {0, 2, METADATA1, METADATA2});

		formatNodes.findNodes();

		Assert.assertEquals(15, formatNodes.getHeadNode().nodeSum);
	}

	@Test
	public void twoNodesOneChild() {
		formatNodes = new FormatNodes(new int[] {1, 3, 0, 2, METADATA1, METADATA2, METADATA1, METADATA2, METADATA3});

		formatNodes.findNodes();

		Assert.assertEquals(0, formatNodes.getHeadNode().nodeSum);
	}

	@Test
	public void twoNodesNoChildren() {
		formatNodes = new FormatNodes(new int[] {0, 3, METADATA1, METADATA2, METADATA3, 0, 2, METADATA1, METADATA2});

		formatNodes.findNodes();

		Assert.assertEquals(39, formatNodes.getHeadNode().nodeSum);
	}

	@Test
	public void givenTest() {
		formatNodes = new FormatNodes(new int[] {2, 3, 0, 3, 10, 11, 12, 1, 1, 0, 1, 99, 2, 1, 1, 2});

		formatNodes.findNodes();

		Assert.assertEquals(66, formatNodes.getHeadNode().nodeSum);
	}
}
