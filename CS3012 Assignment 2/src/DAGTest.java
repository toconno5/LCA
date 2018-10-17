import static org.junit.Assert.*;

import org.junit.Test;

public class DAGTest 
{

	DAG binaryTree = new DAG();
	@Test
	public void testEmptyTree() 
	{
		assertEquals("LCA of Empty tree", -1, binaryTree.LowestCommonAncestorBST(0, 0));
	}
}