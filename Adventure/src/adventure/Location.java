package adventure;

public class Location
{
	/*
	 * Class Instance Variables
	 * 
	 */
	
	private WorldLocation	location;				// Where it is: world location coordinates: x, y, z
	private WorldDimension	locationDimension;		// How big it is: size in cubic feet expressed as width x length x height
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
		// A Location is nowhere if its WorldLocation is NOWHERE		
		location 			= null;
		locationDimension 	= null;
		locationType		= LocationTypes.NOWHERE;
		locationDescription	= null;
		locationExits 	  	= null;
	}
	
	public Location(WorldLocation loc, WorldDimension dimension, String description, LocationTypes type)
	{
		location		  	= loc;
		locationDimension 	= dimension;
		locationDescription = description;
		locationType		= type;
		locationExits 	  	= new Exit[Direction.values().length];		// The Location Exits are created in the World class
	}

	/*
	 * Getters
	 * 
	 */

	public WorldLocation getLocation()
	{
		return location;
	}
	
	public WorldDimension getDimension()
	{
		return locationDimension;
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

	public void setExit(Exit exit, Direction direction)
	{
		locationExits[direction.ordinal()] = exit;
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
