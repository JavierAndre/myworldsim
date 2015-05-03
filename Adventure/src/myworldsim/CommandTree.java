package myworldsim;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CommandTree<T extends Comparable<T>> {

	/*
	 * Class Instance Variables
	 * 
	 */
	
	private CommandTreeNode<T> 	rootNode;
	private int 				size;

	/*
	 * size Method
	 * 
	 */
	
	public int size() {
		return size;	
	}
	
	/*
	 * isEmpty Method
	 * 
	 */
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	/*
	 * Constructors
	 * 
	 */
	
	public CommandTree() {
		rootNode = null;
		size 	 = 0;
	}

	/*
	 * find Methods
	 * 
	 */
	
	public CommandTreeNode<T> find(T value)
	{
		// Search for the value beginning at the root		
		CommandTreeNode<T> nodeFound 	= new CommandTreeNode<T>();
		CommandTreeNode<T> node 		= rootNode;

		// Check the tree is not empty
		if (rootNode != null) {		

			// Search the tree
			while ((node != null) && (value.compareTo(node.getData()) != 0)) {

				// If value is less than the current node's data, search the left subtree
				if (value.compareTo(node.getData()) < 0) {
					node = node.getLeft();
				}
				// If value is greater than the current node's data, search the right subtree
				else if (value.compareTo(node.getData()) > 0) {
					node = node.getRight();
				}
				else {
					// Node found
					nodeFound = node;
				}
			}
			
			if ((node != null) && (value.compareTo(node.getData()) == 0)) {
				// Node found
				nodeFound = node;
			}	
		}
		
		return nodeFound;	
	}
	
	/*
	 * min Methods
	 * 
	 */
	
	public CommandTreeNode<T> min() {
		
		CommandTreeNode<T> node 	= rootNode;
		CommandTreeNode<T> minNode 	= null;
		
		// Find the minimum value using in-order traversal of the left subtree
		while (node != null) {

			// Save the previous node
			minNode = node;
			// Traverse left subtree
			node = node.getLeft();
		}

		return minNode;	
	}
	
	public CommandTreeNode<T> min(CommandTreeNode<T> subtree) {
		
		CommandTreeNode<T> node 	= subtree;
		CommandTreeNode<T> minNode 	= null;
		
		// Find the minimum value using in-order traversal of the left subtree		
		while (node != null) {

			// Save the previous node
			minNode = node;
			// Traverse left subtree
			node = node.getLeft();
		}

		return minNode;	
	}
	
	/*
	 * max Methods
	 * 
	 */
	
	public CommandTreeNode<T> max()
	{
		CommandTreeNode<T> node 	= rootNode;
		CommandTreeNode<T> maxNode 	= null;
		
		// Find the maximum value using in-order traversal of the right subtree
		while (node != null) {
			
			// Save the previous node
			maxNode = node;
			// Traverse right subtree
			node = node.getRight();
		}

		return maxNode;	
	}
	
	public CommandTreeNode<T> max(CommandTreeNode<T> subtree) {
		
		CommandTreeNode<T> node 	= subtree;
		CommandTreeNode<T> maxNode 	= null;
		
		// Find the maximum value using in-order traversal of the right subtree
		while (node != null) {
			
			// Save the previous node
			maxNode = node;
			// Traverse right subtree
			node = node.getRight();
		}

		return maxNode;	
	}
	
	/*
	 * insert Method
	 * 
	 */
	
	public boolean insert(T newNodeData) {
		
		boolean inserted = false;
		
		// Check for an empty tree
		if (rootNode == null) {
			
			// If the tree is empty, create a new node and inserted as the root node
			rootNode = new CommandTreeNode<T>(newNodeData);
			// Increment the number of nodes on the tree
			size++;
			inserted = true;
		}
		else {
			// Recursively insert the value beginning at the root node
			inserted = insertNode(rootNode, newNodeData);
		}
		
		return inserted;
	}
	
	/*
	 * insertNode Method
	 * 
	 * Recursively insert a value. No duplicates allowed (ignore duplicates, return not inserted)
	 * 
	 */
	
	private boolean insertNode(CommandTreeNode<T> node, T newNodeData) {

		CommandTreeNode<T> newNode  = null;		
		boolean inserted 			= false;
				
		// If value is less than the current node's data, insert it in the left subtree		
		if (newNodeData.compareTo(node.getData()) < 0) {
			
			// If the left subtree is empty, create a new node and inserted in the left subtree
			if (node.getLeft() == null) {
				
				// Create a new node and save the parent node
				newNode = new CommandTreeNode<T>(newNodeData);
				newNode.setParent(node);
				
				// Link the new node to the parent's left subtree
				node.setLeft(newNode);
				
				// Increment the number of nodes on the tree
				size++;
				inserted = true;
			}
			else {
				// Recursively insert the value in the left subtree
				inserted = insertNode(node.getLeft(), newNodeData);
			}
		}

		// If value is greater than the current node's data, insert it in the right subtree
		else if (newNodeData.compareTo(node.getData()) > 0) {
			
			// If the right subtree is empty, create a new node and inserted in the right subtree
			if (node.getRight() == null) {
				
				// Create a new node and save the parent node
				newNode = new CommandTreeNode<T>(newNodeData);
				newNode.setParent(node);
				
				// Link the new node to the parent's right subtree
				node.setRight(newNode);

				// Increment the number of nodes on the tree
				size++;
				inserted = true;
			}
			else {
				// Recursively insert the value in the right subtree
				inserted = insertNode(node.getRight(), newNodeData);
			}
		}
					
		return inserted;	
	}
	
	/*
	 * remove Method
	 * 
	 */

	public boolean remove(T value) {
		
		boolean removed 					= false;
		CommandTreeNode<T> nodeToBeRemoved 	= null;
		CommandTreeNode<T> minimumNode 		= null;
		CommandTreeNode<T> leftSubtree 		= null;

		// Check the tree is not empty		
		if (rootNode != null)
		{
			// Search for the node to be removed
			nodeToBeRemoved = find(value);
			
			if (nodeToBeRemoved != null) {
				
				/*
				 *  Check if the node to be removed is the root node.
				 *  
				 */
			 
				if (nodeToBeRemoved == rootNode) {
					
					// Save the current root node's left subtree					
					leftSubtree = rootNode.getLeft();
	
					// Check if the current right subtree is null
					if (rootNode.getRight() != null) {
						
						// The parent of the current root node's right subtree becomes the new root node
						rootNode = rootNode.getRight();

						// Set the new parent of the new root node
						rootNode.setParent(null);
						
						// Find the minimum value of the new root node						
						minimumNode = min();
						
						if (minimumNode != null) {
							
							if (leftSubtree != null) {
								
								// Link the previous root node's left subtree to the minimum node of the new root node
								minimumNode.setLeft(leftSubtree);
								
								// Set the new parent of the left subtree
								leftSubtree.setParent(minimumNode);
							}
							else {
								// Link the previous root node's left subtree to the minimum node of the new root node
								minimumNode.setLeft(null);
							}
						}
						else {
							// Set the new parent of the left subtree
							leftSubtree.setParent(null);
						}
					}
					else {
						// The parent node of the current left subtree becomes the new root node
						rootNode = leftSubtree;
						
						if (rootNode != null)
						{
							// Set the new parent of the left subtree
							rootNode.setParent(null);
						}
					}
					
					removed = true;
				}
				
				/*
				 *  Check if the node to be removed is a leaf node
				 *  
				 */
				
				else if ((nodeToBeRemoved.getLeft() == null) && (nodeToBeRemoved.getRight() == null)) {
					
					if (nodeToBeRemoved.getData().compareTo(nodeToBeRemoved.getParent().getData()) < 0) {
						
						// Remove the node from the parent node
						nodeToBeRemoved.getParent().setLeft(null);
						removed = true;
					}
					else if (nodeToBeRemoved.getData().compareTo(nodeToBeRemoved.getParent().getData()) > 0) {
						
						// Remove the node from the parent node
						nodeToBeRemoved.getParent().setRight(null);
						removed = true;
					}
					
					// This should not happen. No duplicates are supposed to be allowed
					else {
						System.out.println("\n" + "CommandTree::remove(): error, duplicate value " + nodeToBeRemoved.getData() + " found, not removed." + "\n");
					}
				}
				
				/*
				 *  Check if the node to be removed has a single left subtree child
				 *  
				 */
				
				else if ((nodeToBeRemoved.getLeft() != null) && (nodeToBeRemoved.getRight() == null)) {
					
					/*
					 * 				   Parent
					 * 
					 * 			Node
					 * 
					 * 		L		 null
					 */
					
					// Check if the node is on the parent node's left subtree
					if (nodeToBeRemoved.getData().compareTo(nodeToBeRemoved.getParent().getData()) < 0) {
						
						// Link the parent's left subtree to the node's left subtree
						nodeToBeRemoved.getParent().setLeft(nodeToBeRemoved.getLeft());
						
						// Set the new parent of the node's left subtree 
						nodeToBeRemoved.getLeft().setParent(nodeToBeRemoved.getParent());
						removed = true;
					}
					
					/*
					 * 	 Parent
					 * 
					 * 			 Node
					 * 
					 * 	   L			null
					 */
					
					// Check if the node is on the parent node's right subtree
					else if (nodeToBeRemoved.getData().compareTo(nodeToBeRemoved.getParent().getData()) > 0) {
						
						// Link the parent's right subtree to the the node's left subtree
						nodeToBeRemoved.getParent().setRight(nodeToBeRemoved.getLeft());

						// Set the new parent of the node's left subtree
						nodeToBeRemoved.getLeft().setParent(nodeToBeRemoved.getParent());
						removed = true;
					}

					// This should not happen. No duplicates are supposed to be allowed
					else {
						System.out.println("\n" + "CommandTree::remove(): error, duplicate value " + nodeToBeRemoved.getData() + " found, not removed." + "\n");
					}
				}
				
				/*
				 *  Check if the node to be removed has a single right subtree child
				 *  
				 */
				
				else if ((nodeToBeRemoved.getLeft() == null) && (nodeToBeRemoved.getRight() != null)) {
					
					/*
					 * 				   Parent
					 * 
					 * 			Node
					 * 
					 * 	  null		   R
					 */
					
					// Check if the node is on the parent node's left subtree
					if (nodeToBeRemoved.getData().compareTo(nodeToBeRemoved.getParent().getData()) < 0) {
						
						// Link the parent's left subtree to the node's right subtree
						nodeToBeRemoved.getParent().setLeft(nodeToBeRemoved.getRight());
						
						// Set the new parent of the node's right subtree 
						nodeToBeRemoved.getRight().setParent(nodeToBeRemoved.getParent());
						removed = true;
					}
					
					/*
					 * 	Parent
					 * 
					 * 			Node
					 * 
					 * 	  null		   R
					 */
					
					// Check if the node is on the parent node's right subtree
					else if (nodeToBeRemoved.getData().compareTo(nodeToBeRemoved.getParent().getData()) > 0) {
						
						// Link the parent's right subtree to the node's right subtree
						nodeToBeRemoved.getParent().setRight(nodeToBeRemoved.getRight());
						
						// Set the new parent of the node's right subtree 
						nodeToBeRemoved.getRight().setParent(nodeToBeRemoved.getParent());
						removed = true;
					}
					
					// This should not happen. No duplicates are supposed to be allowed
					else {
						System.out.println("\n" + "CommandTree::remove(): error, duplicate value " + nodeToBeRemoved.getData() + " found, not removed." + "\n");
					}
				}
				
				/*
				 *  Otherwise the node to be removed must have two child nodes
				 *  
				 */
				
				else {
					
					/*
					 * 				   Parent
					 * 
					 * 			Node
					 * 
					 * 		L		   R
					 */
					
					// Check if the node is on the parent node's left subtree
					if (nodeToBeRemoved.getData().compareTo(nodeToBeRemoved.getParent().getData()) < 0) {
						
						// Link the parent's left subtree to the node's left subtree
						nodeToBeRemoved.getParent().setLeft(nodeToBeRemoved.getLeft());
						
						// Set the new parent of the node's left subtree 
						nodeToBeRemoved.getLeft().setParent(nodeToBeRemoved.getParent());

						// Link the right subtree to the right node of the left subtree
						nodeToBeRemoved.getLeft().setRight(nodeToBeRemoved.getRight());
						
						// Set the new parent of the right subtree
						nodeToBeRemoved.getRight().setParent(nodeToBeRemoved.getLeft());
						removed = true;
					}
					
					/*
					 * 	Parent
					 * 
					 * 			Node
					 * 
					 * 		L		   R
					 */
					
					// Check if the node is on the parent node's right subtree
					else if (nodeToBeRemoved.getData().compareTo(nodeToBeRemoved.getParent().getData()) > 0) {
						
						// Link the parent's right subtree to the node's right subtree
						nodeToBeRemoved.getParent().setRight(nodeToBeRemoved.getRight());
						
						// Set the new parent of the node's right subtree 
						nodeToBeRemoved.getRight().setParent(nodeToBeRemoved.getParent());

						// Find the minimum value of the right subtree
						minimumNode = min(nodeToBeRemoved.getRight());
						
						if (minimumNode != null) {
							
							// Link the left subtree to the minimum node of the right subtree
							minimumNode.setLeft(nodeToBeRemoved.getLeft());
							
							// Set the new parent of the left subtree
							nodeToBeRemoved.getLeft().setParent(minimumNode);
						}
						else {
							// Set the new parent of the left subtree
							nodeToBeRemoved.getLeft().setParent(nodeToBeRemoved.getParent());
						}
						
						removed = true;
					}
					
					// This should not happen. No duplicates are supposed to be allowed
					else {
						System.out.println("\n" + "CommandTree::remove(): error, duplicate value " + nodeToBeRemoved.getData() + " found, not removed." + "\n");
					}
				}
				
			}	// End of checking the value was found
			
		}	// End of checking the tree is not empty
		
		return removed;	
	}
	
	/*
	 * preOrder Method
	 * 
	 * Pre-Oder Traversal can be used to copy binary trees. It can also be used to make a prefix expression (Polish notation) from expression trees.
	 * 
	 */
	
	public List<T> preOrder() {

		List<T> commandList = new LinkedList<T>();
		
		// Begin at the tree root
		if (rootNode != null) {
			
			// Recursively traverse the tree beginning at the root node
			preOrderTraversal(rootNode, commandList);
		}
		else {
			// The tree is empty
			System.out.println("\n" + "CommandTree::preOrder(): the Command tree is empty." + "\n"); 
		}
		
		return commandList;
	}
	
	/*
	 * preOrderTraversal Method
	 * 
	 * Recursively traverse the tree in pre-order
	 * 
	 */
	
	private List<T> preOrderTraversal(CommandTreeNode<T> node, List<T> commandList) {

		if (node != null) {
			
			// Traverse left subtree
			preOrderTraversal(node.getLeft(), commandList);
						
			// Display the current node's data			
			commandList.add(node.getData());
			
			// Traverse right subtree
			preOrderTraversal(node.getRight(), commandList);
		}
		
		return commandList;
	}
	
	/*
	 * inOrder Method
	 * 
	 * In-Order Traversal returns values from the binary tree in order.
	 * 
	 */
	
	public List<T> inOrder() {
		
		List<T> commandList = new LinkedList<T>();
		
		// Begin at the tree root
		if (rootNode != null) {
			
			// Recursively traverse the tree beginning at the root node
			inOrderTraversal(rootNode, commandList);
		}
		else {
			// The tree is empty
			System.out.println("\n" + "CommandTree::inOrder(): the Command tree is empty." + "\n"); 
		}
		
		return commandList;
	}
	
	/*
	 * inOrderTraversal Method
	 * 
	 * Recursively traverse the tree in order
	 * 
	 */
	
	private List<T> inOrderTraversal(CommandTreeNode<T> node, List<T> commandList)
	{
		if (node != null) {
			
			// Traverse left subtree
			inOrderTraversal(node.getLeft(), commandList);
						
			// Display the current node's data			
			commandList.add(node.getData());
			
			// Traverse right subtree
			inOrderTraversal(node.getRight(), commandList);
		}
		
		return commandList;
	}
	
	/*
	 * postOrder Method
	 * 
	 * Post-Order Traversal can delete nodes or an entire binary tree.  It can also be used to generate a postfix (Reverse Polish Notation) representation of a binary tree.
	 * 
	 */
	
	public void postOrder() {
		
		// Begin at the tree root
		if (rootNode != null) {
			// Recursively traverse the tree beginning at the root node
			postOrderTraversal(rootNode);
		}
		else {
			// The tree is empty
			System.out.println("\n" + "CommandTree::postOrder(): the Command tree is empty." + "\n"); 
		}	
	}
	
	/*
	 * postOrderTraversal Method
	 * 
	 * Recursively traverse the tree in post-order
	 * 
	 */
	
	private void postOrderTraversal(CommandTreeNode<T> node) {
		
		if (node != null) {
			
			// Traverse left subtree
			postOrderTraversal(node.getLeft());
			
			// Traverse right subtree
			postOrderTraversal(node.getRight());
			
			// Display the current node's data
			System.out.println("[" + node.getData() + "]");
		}	
	}
	
	/*
	 * graph Method
	 * 
	 * 
	 * Breadth-first traversal
	 * 
	 */
	
	public void graph() {
		
		CommandTreeNode<T> node = null;
		
		// Create the parent and child nodes array lists
		ArrayList<CommandTreeNode <T>> childNodes	= new ArrayList<CommandTreeNode <T>>();
		ArrayList<CommandTreeNode <T>> subtreeNodes	= new ArrayList<CommandTreeNode <T>>();	
		
		/*
		 *  Display the root subtree showing null nodes
		 *  
		 */
		
		if (rootNode != null) {
			
			/* 
			 * Display the root node
			 * 
			 */
			
			System.out.println("[" + rootNode.getData() + "]");
						
			// Save the root node's child nodes (left and right subtrees)
			childNodes.add(rootNode.getLeft());
			childNodes.add(rootNode.getRight());
			
			/*
			 *  Display the rest of the tree
			 *  
			 */
			
			while (!childNodes.isEmpty()) {
				
				for (int nodeNumber = 0; nodeNumber < childNodes.size(); nodeNumber++) {
					
					// Retrieve the next child node
					node = childNodes.get(nodeNumber);
					
					// Display the child node data
					if (node != null) {
						
						System.out.print("[" + node.getData() + "]" + "\t");
						
						// Save the subtreee nodes
						subtreeNodes.add(node.getLeft());
						subtreeNodes.add(node.getRight());
					}
					else {
						System.out.print("[N]" + "\t");
					}
				}

				System.out.println();
				
				// Clear the child nodes already displayed
				childNodes.clear();
				
				// Copy the subtree nodes as the next child nodes
				childNodes.addAll(subtreeNodes);
				
				// Clear the subtree nodes already copied
				subtreeNodes.clear();	
			}
		}
		else {
			// The tree is empty
			System.out.println("\n" + "CommandTree::graph(): the Command tree is empty." + "\n"); 
		}	
	}
	
	/*
	 * dump Method
	 * 
	 */
	
	public void dump() {
		
		CommandTreeNode<T> node = null;
		
		// Create the parent and child nodes array lists
		ArrayList<CommandTreeNode <T>> childNodes   = new ArrayList<CommandTreeNode <T>>();
		ArrayList<CommandTreeNode <T>> subtreeNodes = new ArrayList<CommandTreeNode <T>>();	
		
		/*
		 *  Display the root subtree showing null nodes
		 *  
		 */
		
		if (rootNode != null) {
			
			/* 
			 * Display the root node
			 * 
			 */
			
			if (rootNode.getParent() == null) {
				System.out.print("Parent: [N]  ");
			}
			else {
				System.out.print("Parent: [" + rootNode.getParent().getData() + "]  ");
			}

			if (rootNode.getLeft() == null) {
				System.out.print("Left: [N]  ");
			}
			else {
				System.out.print("Left: [" + rootNode.getLeft().getData() + "]  ");
			}
			
			if (rootNode.getRight() == null) {
				System.out.print("Right: [N]  ");
			}
			else {
				System.out.print("Right: [" + rootNode.getRight().getData() + "]  ");
			}
			
			System.out.print("Data: [" + rootNode.getData() + "]");
			System.out.println();
						
			// Save the root node's child nodes (left and right subtrees)
			childNodes.add(rootNode.getLeft());
			childNodes.add(rootNode.getRight());
			
			/*
			 *  Display the rest of the tree
			 *  
			 */
			
			while (!childNodes.isEmpty()) {
				
				for (int nodeNumber = 0; nodeNumber < childNodes.size(); nodeNumber++) {
					
					// Retrieve the next child node
					node = childNodes.get(nodeNumber);
					
					// Display the child node data
					if (node != null) {
						if (node.getParent() == null) {
							System.out.print("Parent: [N]  ");
						}
						else {
							System.out.print("Parent: [" + node.getParent().getData() + "]  ");
						}

						if (node.getLeft() == null) {
							System.out.print("Left: [N]  ");
						}
						else {
							System.out.print("Left: [" + node.getLeft().getData() + "]  ");
						}
						
						if (node.getRight() == null) {
							System.out.print("Right: [N]  ");
						}
						else {
							System.out.print("Right: [" + node.getRight().getData() + "]  ");
						}
						
						System.out.print("Data: [" + node.getData() + "]");
						System.out.println();
						
						// Save the subtreee nodes
						subtreeNodes.add(node.getLeft());
						subtreeNodes.add(node.getRight());
					}
					else {
						System.out.println("Data: [N]");
					}
				}
				
				// Clear the child nodes already displayed
				childNodes.clear();
				
				// Copy the subtree nodes as the next child nodes
				childNodes.addAll(subtreeNodes);
				
				// Clear the subtree nodes already copied
				subtreeNodes.clear();
				
			}	// End of tree display loop
		}
		else {
			// The tree is empty
			System.out.println("\n" + "CommandTree::dump(): the Command tree is empty." + "\n"); 
		}		
	}
}
