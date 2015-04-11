package myworldsim;

public class Location
{
	/*
	 * Class Instance Variables
	 * 
	 */
	
	private WorldLocation	location;				// Where it is: world location coordinates: x, y
	private LocationTypes	locationType;			// Initially, when a Location is created it is a World-type Location
	private String			locationDescription;	// Initially, when a Location is created it is described as a World-type Location
	private Exit[]			locationExits;			// One-way exits: inside direction is NOWHERE, such as Emergency Exits
	
	/*
	 * Class Constants
	 * 
	 */
	
	
	
	/*
	 * Consructor Methods
	 * 
	 */

	public Location()
	{
		// A Location is NOWHERE if its WorldLocation is null
		location 			= null;
		locationType		= LocationTypes.BLOCKED;
		locationDescription	= null;
		locationExits 	  	= null;
	}
	
	public Location(WorldLocation loc, WorldDimension dimension, String description, LocationTypes type)
	{
		location		  	= loc;
		locationDescription = description;
		locationType		= type;
		locationExits 	  	= new Exit[Direction.values().length];
		
		// Create the Exits
		for (int exit = 0; exit < Direction.values().length; exit++)
		{
			locationExits[exit] = new Exit();
		}
	}

	/*
	 * Getters
	 * 
	 */

	public WorldLocation getLocation()
	{
		return location;
	}

	public String getDescription()
	{
		return locationDescription;
	}

	public LocationTypes getType()
	{
		return locationType;
	}
	
	public Exit getExit(int exit)
	{
		return locationExits[exit];
	}
	
	/*
	 * Setters
	 * 
	 */
	
	public void setDescription(String description)
	{
		locationDescription = description;
	}

	public void setType(LocationTypes type)
	{
		locationType = type;
	}

	public void setExit(Direction direction, Location location)
	{
		locationExits[direction.ordinal()].setLocation(location);
	}
	
	/*
	 * Action Methods
	 * 
	 */
	
	public void build(LocationTypes type)
	{
		locationType = type;
	}
}
