package myworldsim;

public class WolfTree extends TreeModel
{
	/*
	 * Class Instance Variables
	 * 
	 */
	
	private int	treeNumberOfRooms;
	private int	treeNumberOfWolves;
	private int	treeNumberOfMachineguns;
	
	/*
	 * Class Constants
	 * 
	 */
	
	private final int	DEFAULT_NUMBER_OF_ROOMS			= 10;
	private final int	DEFAULT_NUMBER_OF_WOLVES		= 30;
	private final int	NUMBER_OF_WOLVES_PER_ROOM		= 3;
	private final int	NUMBER_OF_MACHINEGUNS_PER_ROOM	= 3;
	
	/*
	 * Constructor Method
	 * 
	 */
	
	public WolfTree()
	{
		treeNumberOfRooms		= DEFAULT_NUMBER_OF_ROOMS;
		treeNumberOfWolves		= DEFAULT_NUMBER_OF_WOLVES;
	}
	
	public WolfTree(int number, int branches, int roots, int rooms, int wolves)
	{
		super(number, branches, roots);
		
		treeNumberOfRooms 	 	= rooms;
		treeNumberOfWolves 	 	= wolves;
		treeNumberOfMachineguns = NUMBER_OF_MACHINEGUNS_PER_ROOM * treeNumberOfRooms;
	}
}
