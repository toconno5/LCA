/*
 *
 *  @author Tiernan O'Connor (toconno5)
 *  @dateOfSubmission 2/10/18
 *
*/
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
class LowestCommonAncestorTest 
{
	LowestCommonAncestor tree = new LowestCommonAncestor();
	@Test
	void testWhenTreeIsNull()  //tests an empty or null tree
	{
		assertEquals("Find LCA when tree is empty: ",null,tree.findLowestCommonAncestor(1, 2));
	}
	
	@Test 
	void testOneNodeTree() //tests a tree that has only one node
	{
		tree.root = new Node(1);
		assertEquals("Find LCA when tree is one node: ",null,tree.findLowestCommonAncestor(1, 2));
	}
	
	@Test 
	void testTwoNodeTree()  //tests a tree with only two nodes
	{
		tree.root=new Node(1);
		tree.root.left=new Node(2);
		assertEquals("Find LCA when tree is two nodes: ", tree.root, tree.findLowestCommonAncestor(1, 2));
	}
	
	@Test 
	void testWhenTwoNodesAreSame()//tests a tree when asked for LCA of two nodes that are the same
	{
		tree.root=new Node(1);
		tree.root.left=new Node(2);
		tree.root.right=new Node(3);
		assertEquals("Find LCA when two entered nodes are the same",tree.root.right,tree.findLowestCommonAncestor(3, 3));
	}
	
	@Test 
	void testCorrectNodeIsChosen()//tests a tree of size 12 for correct LCA obtainment
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
		assertEquals("LCA for node 2&3",tree.root,tree.findLowestCommonAncestor(2,3));
		assertEquals("LCA for nodes 4&5",tree.root.left,tree.findLowestCommonAncestor(4,5));
		assertEquals("LCA for nodes 5&8",tree.root.left,tree.findLowestCommonAncestor(5,8));
		assertEquals("LCA for nodes 7&9",tree.root.right,tree.findLowestCommonAncestor(7,9));
		assertEquals("LCA for nodes 9&11",tree.root.right,tree.findLowestCommonAncestor(9,11));
		assertEquals("LCA for nodes 10&12",tree.root.right.right,tree.findLowestCommonAncestor(10,12));
		assertEquals("LCA for nodes 9&12",tree.root.right,tree.findLowestCommonAncestor(9,12));
		
	}
	
	@Test
	void testForNonExistentNodes()//tests for asked to find lowest common ancestor for nodes that don't exist in the binary tree
	{
		tree.root = new Node(1);
		tree.root.left=new Node(2);
		tree.root.right=new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right= new Node (5);
		assertEquals("LCA for one non existent node",null,tree.findLowestCommonAncestor(3, 10));
		assertEquals("LCA for two non existent nodes",null,tree.findLowestCommonAncestor(6, 10));
		assertEquals("LCA for two common non existent nodes",null,tree.findLowestCommonAncestor(6, 10));
	}
	
	@Test
	void testForAncestors() //tests for when one node is a direct ancestor of the other node
	{
		tree.root = new Node(1);
		tree.root.left=new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left=new Node(4);
		assertEquals("LCA for two nodes which are an ancestor and child",tree.root.left,tree.findLowestCommonAncestor(2, 4));
	}
	
	@Test 
	void testOneSidedTree() //tests a tree that is a straight line i.e. each node is an ancestor of the previous node.
	{
		tree.root= new Node(1);
		tree.root.left = new Node (2);
		tree.root.left.left= new Node(3);
		tree.root.left.left.left = new Node(4);
		tree.root.left.left.left.left = new Node(5);
		assertEquals("Find LCA in one sided tree",tree.root.left,tree.findLowestCommonAncestor(2, 3));
		assertEquals("Find LCA in one sided tree",tree.root.left,tree.findLowestCommonAncestor(2, 4));
		assertEquals("Find LCA in one sided tree",tree.root.left.left,tree.findLowestCommonAncestor(3, 5));
	}
}