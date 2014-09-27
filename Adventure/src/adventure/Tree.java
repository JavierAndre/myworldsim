package adventure;

public class Tree
{
	/*
	 * Class Instance Variables
	 * 
	 */
	
	private int		treeNumber;
	private int		treeNumberOfBranches;
	private int		treeNumberOfRoots;

	/*
	 * Class Constants
	 * 
	 */
	
	private final int	DEFAULT_NUMBER_OF_BRANCHES	= 10;
	private final int	DEFAULT_NUMBER_OF_ROOTS		= 10;
	
	/*
	 * Constructor Methods
	 * 
	 */
	
	public Tree()
	{
		treeNumberOfBranches 	= DEFAULT_NUMBER_OF_BRANCHES;
		treeNumberOfRoots		= DEFAULT_NUMBER_OF_ROOTS;
	}
	
	public Tree(int number, int branches, int roots)
	{
		treeNumber				= number;
		treeNumberOfBranches	= branches;
		treeNumberOfRoots		= roots;
	}
}
