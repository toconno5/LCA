public class LowestCommonAncestor 
{
	Node root;
	Node findLowestCommonAncestor(int n1, int n2) 
	{
		return findLowestCommonAncestor(root,n1,n2);
	}
	Node findLowestCommonAncestor(Node n, int n1, int n2) 
	{
		if(n==null) return null; //returns null if tree is empty
		if(n.equals(n1) || n.equals(n2)) return n; //returns n if either node is the root
		Node leftLowestCommonAncestor = findLowestCommonAncestor(n.left,n1,n2); //checks if there nodes in left subtree
		Node rightLowestCommonAncestor = findLowestCommonAncestor(n.right,n1,n2); //checks if there are nodes in right subtree
		if(leftLowestCommonAncestor!=null && rightLowestCommonAncestor!=null) return n;
		return (leftLowestCommonAncestor!=null)?leftLowestCommonAncestor:rightLowestCommonAncestor; //returns Lowest Common Ancestor of subtrees
	}
}

class Node
{
	int nodeNumber;
	Node left,right;
	public Node(int value)
	{
		nodeNumber=value;
		left = right = null;
	}
}