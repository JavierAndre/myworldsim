package adventure;

public class Exit
{
	/*
	 * Class Instance Variables
	 * 
	 * An Exit leads nowhere if its Direction is NOWHERE and it exits to a Location that is NOWHERE
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
