package myworldsim;

public class TreeModel
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
	
	public TreeModel()
	{
		treeNumberOfBranches 	= DEFAULT_NUMBER_OF_BRANCHES;
		treeNumberOfRoots		= DEFAULT_NUMBER_OF_ROOTS;
	}
	
	public TreeModel(int number, int branches, int roots)
	{
		treeNumber				= number;
		treeNumberOfBranches	= branches;
		treeNumberOfRoots		= roots;
	}
}
