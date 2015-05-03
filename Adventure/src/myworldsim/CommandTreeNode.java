package myworldsim;

public class CommandTreeNode<T extends Comparable<T>> {
	
	/*
	 * Class Instance Variables
	 * 
	 */
	
	private CommandTreeNode<T> 	parentNode;
	private CommandTreeNode<T> 	leftNode;
	private T 					nodeData;
	private CommandTreeNode<T> 	rightNode;

	/*
	 * Class Constants
	 * 
	 */
	
	public static final Object 	NOT_FOUND = null;
	
	/*
	 * Getters and Setters
	 * 
	 */
	
	public CommandTreeNode<T> getParent() {
		return parentNode;	
	}
	
	public void setParent(CommandTreeNode<T> node) {
		parentNode = node;	
	}
	
	public CommandTreeNode<T> getLeft() {
		return leftNode;
	}
	
	public void setLeft(CommandTreeNode<T> node) {
		leftNode = node;	
	}
	
	public T getData() {
		return nodeData;	
	}
	
	public void setData(T data) {
		nodeData = data;	
	}
	
	public CommandTreeNode<T> getRight() {
		return rightNode;	
	}

	public void setRight(CommandTreeNode<T> node) {
		rightNode = node;	
	}
	
	/*
	 * Constructors
	 * 
	 */
	
	public CommandTreeNode() {
		parentNode	= (CommandTreeNode<T>)NOT_FOUND;
		leftNode 	= (CommandTreeNode<T>)NOT_FOUND;
		nodeData 	= (T)NOT_FOUND;
		rightNode 	= (CommandTreeNode<T>)NOT_FOUND;
	}
	
	public CommandTreeNode(T nodeData) {
		this.nodeData 	= nodeData;		
		parentNode		= null;
		leftNode 		= null;
		rightNode 		= null;
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
				leftNode = new CommandTreeNode<T>(newNodeData);
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
				rightNode = new CommandTreeNode<T>(newNodeData);
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
