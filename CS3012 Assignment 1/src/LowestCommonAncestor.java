public class LowestCommonAncestor 
{
	Node root;
	Node findLowestCommonAncestor(int n1, int n2) 
	{
		return findLowestCommonAncestor(root,n1,n2);
	}
	Node findLowestCommonAncestor(Node node, int n1, int n2) 
	{
		if(node==null) 
		{
			return null; //returns null if tree is empty
		}
		if(!nodesPresent(root, n1) || !nodesPresent(root, n2)) 
		{ 
			return null; //if one of the nodes isn't present, return null.
		}
		if (node.nodeNumber == n1 || node.nodeNumber == n2) 
		{ 
			return node; //checks if one of the numbers is equal to the node's value.
		}
		Node leftNode = findLowestCommonAncestor(node.left,n1,n2); //checks if there nodes in left subtree
		Node rightNode = findLowestCommonAncestor(node.right,n1,n2); //checks if there are nodes in right subtree
		if(leftNode!=null && rightNode!=null) 
		{
			return node;
		}
		if(leftNode!=null) //if the left subtree is not empty, return it 
		{
			return leftNode;
		}
		else return rightNode; //otherwise return the right subtree
	}
	public boolean nodesPresent (Node node, int num) //check to see if a node is present in the tree.
	{ 
		if (node == null) return false; //checks if desired node is null
		if (node.nodeNumber == num) return true; //checks if desired node is the current node 
		if (nodesPresent(node.left, num)) return true; //checks left subtree
		if (nodesPresent(node.right, num)) return true; //checks right subtree
		return false;
	}
}

class Node
{
	int nodeNumber;
	Node left;
	Node right;
	public Node(int value)
	{
		nodeNumber=value;
		left = null;
		right = null;
	}
}