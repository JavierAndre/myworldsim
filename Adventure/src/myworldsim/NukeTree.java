package myworldsim;

public class NukeTree extends TreeModel
{
	/*
	 * Class Instance Variables
	 * 
	 */
	
	private int	treeNumberOfSilos;
	private int	treeNumberOfMissiles;
	
	/*
	 * Class Constants
	 * 
	 */
	
	private final int	DEFAULT_NUMBER_OF_SILOS			= 10;
	private final int	DEFAULT_NUMBER_OF_MISSILES		= 50;
	private final int	NUMBER_OF_MISSILES_PER_BRANCH	= 2;
	private final int	NUMBER_OF_MISSILES_PER_ROOT		= 10;
	
	/*
	 * Constructor Method
	 * 
	 */
	
	public NukeTree()
	{
		treeNumberOfSilos		= DEFAULT_NUMBER_OF_SILOS;
		treeNumberOfMissiles	= DEFAULT_NUMBER_OF_MISSILES;
	}
	
	public NukeTree(int number, int branches, int roots, int silos, int missiles)
	{
		super(number, branches, roots);
		
		treeNumberOfSilos 	 = silos;
		treeNumberOfMissiles = missiles;
	}
}
