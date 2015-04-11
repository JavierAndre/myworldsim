package myworldsim;

public class Tree<T extends Comparable<T>> {

	/*
	 * Class Instance Variables
	 * 
	 */
	
	private TreeNode<T> rootNode;
	
	/*
	 * Constructors
	 * 
	 */
	
	public Tree() {
		rootNode = null;
	}
	
	/*
	 * Tree Operations
	 * 
	 */
	
	public boolean insert(T newNodeData) {
		
		boolean inserted = false;
		
		// Check for an empty tree
		if (rootNode == null) {
			
			rootNode = new TreeNode<T>(newNodeData);
		}
		else {
			inserted = rootNode.insert(newNodeData);
		}
		
		return inserted;
	}
}
