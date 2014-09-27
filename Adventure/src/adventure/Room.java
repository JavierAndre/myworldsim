package adventure;

public class Room extends Location
{
	/*
	 * Class Instance Variables
	 * 
	 */
	
	// Every room will have a Door or a Window at each Exit. Randomly decide which Exits have Doors, Windows or no Exit (an Exit that leads NOWHERE).
	
	private Window[]	roomWindows;
	
	/*
	 * Class Constants
	 * 
	 */
	
	public static final WorldDimension	DEFAULT_ROOM_DIMENSION				= new WorldDimension(1, 1, 1);		// In Locations
	public static final String			DEFAULT_ROOM_DESCRIPTION			= "This is a confy room for your creatures to use!";
	public static final int				DEFAULT_ROOM_WINDOWS				= 1;
	
	/*
	 * Constructor Methods
	 * 
	 */
	
	public Room(WorldLocation location, WorldDimension locationDimension)
	{
		super(location, locationDimension, DEFAULT_ROOM_DESCRIPTION, LocationTypes.ROOM);
		
		roomWindows = new Window[DEFAULT_ROOM_WINDOWS];
	}
	
	public Room(WorldLocation location, WorldDimension locationDimension, String description, int windows)
	{
		super(location, locationDimension, description, LocationTypes.ROOM);
		
		roomWindows = new Window[windows];
	}
}
