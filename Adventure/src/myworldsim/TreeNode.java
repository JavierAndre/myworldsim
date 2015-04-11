package myworldsim;

public class TreeNode<T extends Comparable<T>> {
	
	/*
	 * Class Instance Variables
	 * 
	 */
	
	private TreeNode<T> leftNode;
	private T 			nodeData;
	private TreeNode<T> rightNode;
	
	/*
	 * Constructors
	 * 
	 */
	
	public TreeNode(T nodeData) {
		this.nodeData = nodeData;
		
		leftNode 	= null;
		rightNode 	= null;
	}

	/*
	 * Tree Node Operations
	 * 
	 */
	
	public boolean insert(T newNodeData) {
		boolean inserted = false;
		
		// Duplicates not allowed (EQUAL) 
		
		// Check if the new TreeNode belongs on the left subtree (LESS THAN)
		if (newNodeData.compareTo(nodeData) < 0) {
			
			if ( leftNode == null ) {
				leftNode = new TreeNode<T>(newNodeData);
			}
			else {
				// Continue traversing left subtree recursively
				leftNode.insert( newNodeData );
			}
			inserted = true;
		}
		// Check if the new TreeNode belongs on the right subtree (GREATER THAN)
		else if (newNodeData.compareTo(nodeData) > 0) {
			
			if ( rightNode == null ) {
				rightNode = new TreeNode<T>(newNodeData);
			}
			else {
				// Continue traversing left subtree recursively
				rightNode.insert( newNodeData );
			}
			inserted = true;
		}
		
		return inserted;
	}
}
