package adventure;

public class Location
{
	/*
	 * Class Instance Variables
	 * 
	 */
	
	private WorldLocation	location;				// Where it is: world location coordinates: X, X, Z
	private WorldDimension	locationDimension;		// How big it is: size in cubic feet expressed as width x length (depth) x height
	private LocationTypes	locationType;			// Initially, when a Location is created it is a World-type Location
	private String			locationDescription;	// Initially, when a Location is created it is described as a World-type Location
	private boolean			locationBuilt;			// Indicates whether or not some structure has already been built on this Location
	private Exit[]			locationExits;			// One-way exits: inside direction is NOWHERE, such as Emergency Exits
	
	/*
	 * Class Constants
	 * 
	 */
	
	
	
	/*
	 * Consructor Methods
	 * 
	 */
	
	public Location(WorldLocation loc, WorldDimension dimension, String description, LocationTypes type)
	{
		location		  	= loc;
		locationDimension 	= dimension;
		locationDescription = description;
		locationType		= type;
		locationBuilt		= false;
		locationExits 	  	= new Exit[Direction.values().length];		// The Location Exits are created in the AdventureWorld class
	}

	/*
	 * Getters
	 * 
	 */

	public WorldLocation getWorldLocation()
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
	
	public Exit getExit(Direction direction)
	{
		return locationExits[direction.ordinal() - 1];
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
		locationType	= type;
		locationBuilt 	= true;
	}
}
