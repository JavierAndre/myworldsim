package myworldsim;

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
	
	public static final Direction NOWHERE = null;
	
	/*
	 * Constructor Methods
	 * 
	 */
	
	public Exit()
	{
		exitDirection	= NOWHERE;
		exitToLocation	= null;
	}
	
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
	
	/*
	 * Setters
	 * 
	 */
	
	public void setLocation(Location location)
	{
		exitToLocation = location;
	}
}
