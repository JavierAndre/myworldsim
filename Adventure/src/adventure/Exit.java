package adventure;

public class Exit
{
	/*
	 * Class Instance Variables
	 * 
	 */
	
	private Direction	exitDirection;
	private Location	exitToLocation;
	
	
	/*
	 * Class Constants
	 * 
	 */
	
	
	
	/*
	 * Constructor Methods
	 * 
	 */
	
	public Exit(Direction direction, Location location)
	{
		exitDirection	= direction;
		exitToLocation	= location;
	}
	
	/*
	 * Getters
	 * 
	 */
	
	public Direction getDirection()
	{
		return exitDirection;
	}
	
	public Location getExitToLocation()
	{
		return exitToLocation;
	}
}
