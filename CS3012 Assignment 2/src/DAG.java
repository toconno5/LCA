import java.util.ArrayList;
import java.util.List;

class Node
{
	int nodeNumber;
	Node left;
	Node right;
	ArrayList<Node> ancestors;
	Node(int value)
	{
		nodeNumber=value;
		left = null;
		right = null;
		ancestors=null;
	}
}

public class DAG 
{
	Node root;
	List<Integer> Node1Path = new ArrayList<>();
	List<Integer> Node2Path = new ArrayList<>();

	int LowestCommonAncestorFunctionDAG (Node n1, Node n2)
	{
		return findLowestCommonAncestor(root, n1, n2);
	}
	
	int findLowestCommonAncestor(Node node, Node n1, Node n2) 
	{
		if(n1!=null && n2!=null) 
		{
			if(n1.ancestors!=null && n2.ancestors!=null) 
			{
				for(int i=0; i<n2.ancestors.size(); i++) 
				{
					for(int j=0; j<node.ancestors.size(); j++) 
					{
						if(n2.ancestors.get(i)==n1.ancestors.get(j)) 
						{
							return n2.ancestors.get(i).nodeNumber;
						}
					}
				}
			}
			else return root.nodeNumber;
		}
		return 0; //returns null if tree is empty
	}
	
	public boolean nodesPresent (Node root, int num, List<Integer> path) //check to see if a node is present in the tree.
	{ 
		if (root == null) return false; //checks if desired node is null
		path.add(root.nodeNumber);
		if (root.nodeNumber == num) return true; //checks if desired node is the current node 
		if (root.left!=null && nodesPresent(root.left, num, path)) return true; //checks left subtree
		if (root.right!=null && nodesPresent(root.right, num, path)) return true; //checks right subtree
		path.remove(path.size()-1);
		return false;
	}
}