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
	
	@Test 
	void testTwoNodeTree() 
	{
		tree.root=new Node(1);
		tree.root.left=new Node(2);
		assertEquals("Find LCA when tree is two nodes: ", tree.root, tree.findLowestCommonAncestor(1, 2));
	}
	
	@Test 
	void testWhenTwoNodesAreSame()
	{
		tree.root=new Node(1);
		tree.root.left=new Node(2);
		tree.root.right=new Node(3);
		assertEquals("Find LCA when two entered nodes are the same",tree.root.right,tree.findLowestCommonAncestor(3, 3));
	}
	
	@Test 
	void testCorrectNodeIsChosen()
	{
		tree.root = new Node(1);
		tree.root.left=new Node(2);
		tree.root.right=new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right= new Node (5);
		tree.root.right.left=new Node(6);
		tree.root.right.right=new Node(7);
		tree.root.left.left.left = new Node(8);
		tree.root.right.left.left = new Node(9);
		tree.root.right.right.right=new Node(10);
		tree.root.right.right.right.right=new Node(11);
		tree.root.right.right.left= new Node(12);
		assertEquals("Find LCA",tree.root,tree.findLowestCommonAncestor(2,3));
		assertEquals("Find LCA",tree.root.left,tree.findLowestCommonAncestor(4,5));
		assertEquals("Find LCA",tree.root,tree.findLowestCommonAncestor(2,3));
		assertEquals("Find LCA",tree.root.left,tree.findLowestCommonAncestor(5,8));
		assertEquals("Find LCA",tree.root.right,tree.findLowestCommonAncestor(7,9));
		assertEquals("Find LCA",tree.root.right,tree.findLowestCommonAncestor(9,11));
		assertEquals("Find LCA",tree.root.right.right,tree.findLowestCommonAncestor(10,12));
		assertEquals("Find LCA",tree.root.right,tree.findLowestCommonAncestor(9,12));
		
	}
	
	@Test
	void testForNonExistentNodes()
	{
		tree.root = new Node(1);
		tree.root.left=new Node(2);
		tree.root.right=new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right= new Node (5);
		assertEquals("Find LCA",tree.root.left,tree.findLowestCommonAncestor(4,5));
		assertEquals("Find LCA",null,tree.findLowestCommonAncestor(3, 10));
	}
	
	@Test
	void testForAncestors()
	{
		tree.root = new Node(1);
		tree.root.left=new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left=new Node(4);
		assertEquals("Find LCA",tree.root.left,tree.findLowestCommonAncestor(2, 4));
	}
	
	@Test
	void testWithMissingNodes()
	{
		tree.root = new Node(1);
		tree.root.left=new Node(3);
		tree.root.right = new Node(6);
		tree.root.left.left=new Node(10);
		tree.root.right.left=new Node(12);
		assertEquals("Find LCA",tree.root.right,tree.findLowestCommonAncestor(6,10));
	}

}
