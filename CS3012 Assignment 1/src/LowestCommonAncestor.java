import static org.junit.Assert.assertEquals;

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
		if(!numsPresent(root, n1) || !numsPresent(root, n2)) { //if one of the nodes isn't present, return null.
			return null;
		}
		if (node.nodeNumber == n1 || node.nodeNumber == n2) { //checks if one of the numbers is equal to the node's value.
			return node;
		}
		Node leftNode = findLowestCommonAncestor(node.left,n1,n2); //checks if there nodes in left subtree
		Node rightNode = findLowestCommonAncestor(node.right,n1,n2); //checks if there are nodes in right subtree
		if(leftNode!=null && rightNode!=null) 
		{
			return node;
		}
		if(leftNode!=null) 
		{
			return leftNode;
		}
		else return rightNode;
	}
	public boolean numsPresent (Node node, int num) //check to see if a node is present in the tree.
	{ 
		
		if (node == null) return false;
		if (node.nodeNumber == num) return true;
		if (numsPresent(node.left, num)) return true;
		if (numsPresent(node.right, num)) return true;
		
		return false;
	}
	public static void main (String[]args) 
	{
		LowestCommonAncestor tree= new LowestCommonAncestor();
		tree.root=new Node(1);
		tree.root.left=new Node(2);
		tree.root.right=new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		System.out.print(tree.findLowestCommonAncestor(4,5));
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