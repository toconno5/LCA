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
	Node root; //initialises root
	List<Integer> n1Path = new ArrayList<>(); //creates list for node 1's path
	List<Integer> n2Path = new ArrayList<>(); // creates list for node 2's path
	
	int LowestCommonAncestorDAG (Node n1, Node n2) //function for lowest common ancestor in DAG
	{
		return findLowestCommonAncestorDAG(root, n1, n2);
	}
	
	int findLowestCommonAncestorDAG(Node node, Node n1, Node n2)  //function to find lowest common ancestor 
	{
		if(n1!=null && n2!=null) //returns 0 if n1 or n2 are null
		{
			if(n1.ancestors!=null && n2.ancestors!=null) // returns root if n1 or n2's ancestors are null
			{
				for(int i=0; i<n2.ancestors.size(); i++) //loops through number of ancestors of n2
				{
					for(int j=0; j<node.ancestors.size(); j++) //loops through selected nodes ancestors
					{
						if(n2.ancestors.get(i)==n1.ancestors.get(j)) //checks if n1 or n2 share ancestors
						{
							return n2.ancestors.get(i).nodeNumber; //if so returns lowest one
						}
					}
				}
			}
			else return root.nodeNumber; 
		}
		return 0;
	}
	
	public boolean nodesPresent (Node root, int num, List<Integer> path) //check to see if a node is present in the tree.
	{ 
		if (root == null) return false; //checks if desired node is null
		path.add(root.nodeNumber); //adds node
		if (root.nodeNumber == num) return true; //checks if desired node is the current node 
		if (root.left!=null && nodesPresent(root.left, num, path)) return true; //checks left subtree
		if (root.right!=null && nodesPresent(root.right, num, path)) return true; //checks right subtree
		path.remove(path.size()-1); //removes last node
		return false; //default return is false
	}
	
	public void addToGraph(Node n1) //function to add node to DAG
	{
		n1.ancestors = new ArrayList <Node> (); //creates an array list to stores ancestors for node 1
		n1.ancestors.add(n1); //adds node 1 to the list of ancestors for itself
		
	}
	
	public void addAncestorsToNode(Node n1, Node n2) 
	{
		for (int i=0; i < n1.ancestors.size(); i++) //loops through ancestors of node 1
		{
			if(!n2.ancestors.contains(n1.ancestors.get(i))) //if node 2's ancestors aren't the same as node 1 at particular index
			{
				n2.ancestors.add(n1.ancestors.get(i)); //add it
			}
		}
	}
	public void addAncestorsToNodeAtPosition(int pos, Node n1, Node n2) //function to add nodes at particular position in list
	{
		for (int i=0; i < n1.ancestors.size(); i++) //loops through ancestors of node 1 
		{
			if(!n2.ancestors.contains(n1.ancestors.get(i))) //if node 2's ancestors aren't the same as node 1 at particular index
			{
				n2.ancestors.add(pos, n1.ancestors.get(i)); //add it in correct position
			}
		}
	}
}