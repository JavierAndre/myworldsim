package myworldsim;

public class Room extends Location
{
	/*
	 * Class Instance Variables
	 * 
	 */
	
	// Every room may have a Door or a Window at some Exits.
	private Window[]	roomWindows;
	private Door[]		roomDoors;
	
	/*
	 * Class Constants
	 * 
	 */
	
	public static final WorldDimension	DEFAULT_ROOM_DIMENSION				= new WorldDimension((short)(1), (short)(1));		// In Locations
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
