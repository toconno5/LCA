import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

class LowestCommonAncestorTest 
{
	LowestCommonAncestor tree = new LowestCommonAncestor();
	@Test
	void testWhenTreeIsNull() 
	{
		assertEquals("Find LCA when tree is empty: ",null,tree.findLowestCommonAncestor(1, 2));
	}
	
	@Test 
	void testOneNodeTree()
	{
		tree.root = new Node(1);
		assertEquals("Find LCA when tree is one node: ",null,tree.findLowestCommonAncestor(1, 2));
	}
}
