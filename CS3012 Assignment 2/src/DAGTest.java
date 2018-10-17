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
	
	@Test
	public void testOneNodeTree() 
	{
		binaryTree.root = new Node(1);
		assertEquals("LCA of one node tree", -1, binaryTree.LowestCommonAncestorBST(1, 0));
	}
	
	@Test 
	public void testTwoNodeTree()  //tests a tree with only two nodes
	{
		binaryTree.root=new Node(1);
		binaryTree.root.left=new Node(2);
		assertEquals("Find LCA when tree is two nodes: ", 1, binaryTree.LowestCommonAncestorBST(1, 2));
	}
	
	@Test 
	public void testWhenTwoNodesAreSame()//tests a tree when asked for LCA of two nodes that are the same
	{
		binaryTree.root=new Node(1);
		binaryTree.root.left=new Node(2);
		binaryTree.root.right=new Node(3);
		assertEquals("Find LCA when two entered nodes are the same",3,binaryTree.LowestCommonAncestorBST(3, 3));
	}

	@Test
	public void test12NodeBT() //tests Function returns correct LCA
	{
		binaryTree.root = new Node(1);
		binaryTree.root.left=new Node(2);
		binaryTree.root.right=new Node(3);
		binaryTree.root.left.left = new Node(4);
		binaryTree.root.left.right= new Node (5);
		binaryTree.root.right.left=new Node(6);
		binaryTree.root.right.right=new Node(7);
		binaryTree.root.left.left.left = new Node(8);
		binaryTree.root.right.left.left = new Node(9);
		binaryTree.root.right.right.right=new Node(10);
		binaryTree.root.right.right.right.right=new Node(11);
		binaryTree.root.right.right.left= new Node(12);
		assertEquals("Find LCA for node 2&3",1,binaryTree.LowestCommonAncestorBST(2,3));
		assertEquals("Find LCA for nodes 4&5",2,binaryTree.LowestCommonAncestorBST(4,5));
		assertEquals("Find LCA for nodes 5&8",2,binaryTree.LowestCommonAncestorBST(5,8));
		assertEquals("Find LCA for nodes 7&9",3,binaryTree.LowestCommonAncestorBST(7,9));
		assertEquals("Find LCA for nodes 9&11",3,binaryTree.LowestCommonAncestorBST(9,11));
		assertEquals("Find LCA for nodes 10&12",7,binaryTree.LowestCommonAncestorBST(10,12));
		assertEquals("Find LCA for nodes 9&12",3,binaryTree.LowestCommonAncestorBST(9,12));
	}

	@Test
	public void testForNonExistentNodes()//tests for asked to find lowest common ancestor for nodes that don't exist in the binary tree
	{
		binaryTree.root = new Node(1);
		binaryTree.root.left=new Node(2);
		binaryTree.root.right=new Node(3);
		binaryTree.root.left.left = new Node(4);
		binaryTree.root.left.right= new Node (5);
		assertEquals("Find LCA for one non existent node",-1,binaryTree.LowestCommonAncestorBST(3, 10));
		assertEquals("Find LCA for two non existent nodes",-1,binaryTree.LowestCommonAncestorBST(6, 10));
		assertEquals("Find LCA for two common non existent nodes",-1,binaryTree.LowestCommonAncestorBST(6, 10));
	}
	
	@Test
	public void testForAncestors() //tests for when one node is a direct ancestor of the other node
	{
		binaryTree.root = new Node(1);
		binaryTree.root.left=new Node(2);
		binaryTree.root.right = new Node(3);
		binaryTree.root.left.left=new Node(4);
		assertEquals("Find LCA for two nodes which are an ancestor and child",2,binaryTree.LowestCommonAncestorBST(2, 4));
	}
	
	@Test 
	public void testOneSidedTree() //tests a tree that is a straight line i.e. each node is an ancestor of the previous node.
	{
		binaryTree.root= new Node(1);
		binaryTree.root.left = new Node (2);
		binaryTree.root.left.left= new Node(3);
		binaryTree.root.left.left.left = new Node(4);
		binaryTree.root.left.left.left.left = new Node(5);
		assertEquals("Find LCA in one sided tree",2,binaryTree.LowestCommonAncestorBST(2, 3));
		assertEquals("Find LCA in one sided tree",2,binaryTree.LowestCommonAncestorBST(2, 4));
		assertEquals("Find LCA in one sided tree",3,binaryTree.LowestCommonAncestorBST(3, 5));
	}


	@Test
	public void outOfOrderTest() //tests a tree where the order of the nodes is not linear
	{
		binaryTree.root = new Node(5);
		binaryTree.root.left = new Node(3);
		binaryTree.root.right = new Node(1);
		binaryTree.root.left.left = new Node(4);
		binaryTree.root.left.right = new Node(7);
		binaryTree.root.right.left = new Node(2);
		binaryTree.root.right.right = new Node(6);

		assertEquals("Find LCA for tree out of order", 5, binaryTree.LowestCommonAncestorBST(6, 4));
		assertEquals("Find LCA for tree out of order", 3, binaryTree.LowestCommonAncestorBST(3, 4));
		assertEquals("Find LCA for tree out of order", 1, binaryTree.LowestCommonAncestorBST(6, 2));
		assertEquals("Find LCA for tree out of order", 5, binaryTree.LowestCommonAncestorBST(7, 2));
	}
}