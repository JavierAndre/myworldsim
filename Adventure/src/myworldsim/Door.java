package myworldsim;

public class Door
{
	/*
	 * Class Instance Variables
	 * 
	 */
	
	private Location		doorLocation;
	private Direction		doorEntryDirection;
	private Direction		doorExitDirection;
	private DoorHardware	doorHardware;			// Object-Oriented Programming Principle: Composition: the Door HAS A DoorHardware
	
	/*
	 * Class Constants
	 * 
	 */
	
	
	
	/*
	 * Constructors
	 * 
	 */
	
	public Door(int hardwareType, int insideLockType, int outsideLockType, Location location, String locationDescription, Direction entryDirection, Direction exitDirection)
	{
		doorLocation 		= location;
		doorEntryDirection 	= entryDirection;
		doorExitDirection 	= exitDirection;
		doorHardware 		= new DoorHardware(hardwareType, insideLockType, outsideLockType);
		
		// Reclassify World Location as type DOOR
		doorLocation.setType(LocationTypes.DOOR);
		doorLocation.setDescription(locationDescription);
		
		// Redefine World Location Exits as leading NOWHERE
		for (int direction = 0; direction < Direction.values().length; direction++)
		{
			// Set each Exit to lead to NOWHERE
			doorLocation.getExit(Direction.values()[direction].ordinal()).setLocation(new Location());
		}
		
		// A Door enters and exits in whatever directions the Floorplan determines.
		// The Floorplan will specify the enter and exit Directions when it creates the Doors.
		Location doorEntryLocation 	= doorLocation.getExit(doorEntryDirection.ordinal()).getExitToLocation();
		Location doorExitLocation 	= doorLocation.getExit(doorExitDirection.ordinal()).getExitToLocation();
		
		doorLocation.getExit(entryDirection.ordinal()).setLocation(doorEntryLocation);
		doorLocation.getExit(exitDirection.ordinal()).setLocation(doorExitLocation);
	}
	
	/*
	 * Getters
	 * 
	 */
	
	public Direction getEntry()
	{
		return doorEntryDirection;
	}
	
	public Direction getExit()
	{
		return doorExitDirection;
	}

	public boolean isOpened()
	{
		return !doorHardware.isLatched();
	}
	
	public boolean isClosed()
	{
		return doorHardware.isLatched();
	}

	public boolean isLocked()
	{
		return doorHardware.isLocked();
	}

	public boolean isBusted()
	{
		return doorHardware.isBroken();
	}

	public boolean isBlocked()
	{
		return doorLocation.getExit(doorEntryDirection.ordinal()).getExitToLocation().getType() == LocationTypes.BLOCKED &&
			   doorLocation.getExit(doorExitDirection.ordinal()).getExitToLocation().getType() == LocationTypes.BLOCKED;
	}
	
	public boolean canLock()
	{
		return doorHardware.canLockFromInside() || doorHardware.canLockFromOutside();
	}
	
	public DoorKey getKey()
	{
		return doorHardware.getKey();
	}

	/*
	 * Action/Set Methods
	 * 
	 */
	
	public boolean open()
	{
		return doorHardware.unlatch();
	}
	
	public boolean close()
	{
		return doorHardware.latch();
	}
	
	// Object-Oriented Programming: Method overloading (multiple versions of a method): use same method name, DIFFERENT method parameter lists
	public boolean lockDoor()
	{
		return doorHardware.lockFromInside();
	}
	
	public boolean lockDoor(DoorKey key)
	{
		return doorHardware.lockFromOutside(key);
	}
	
	public boolean unlockDoor()
	{
		return doorHardware.unlockFromInside();
	}
	
	public boolean unlockDoor(DoorKey key)
	{
		return doorHardware.unlockFromOutside(key);
	}
	
	public boolean breakDoor()
	{
		boolean doorBroken = false;
		
		// How much force can you extert on the door? Randomize the amout of force???
		// Google "residential building code for doors"
		
		return doorBroken;
	}
}
