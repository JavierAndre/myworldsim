package adventure;

public class Door
{
	/*
	 * Class Instance Variables
	 * 
	 */
	
	private Location		doorStartLocation;		// Bottom-left-most corner World coordinates
	private WorldDimension	doorDimension;			// Door size
	private Exit			doorEnter;
	private Exit			doorExit;
	private DoorHardware	doorHardware;			// Object-Oriented Programming Composition: the Door HAS A DoorHardware
	
	/*
	 * Class Constants
	 * 
	 */
	
	
	
	/*
	 * Constructors
	 * 
	 */
	
	public Door(Location location, WorldDimension dimension, Exit enter, Exit exit, int hardwareType, int insideLockType, int outsideLockType)
	{
		doorStartLocation	= location;
		doorDimension		= dimension;
		
		// Reclassify Door Locations as type DOOR
		
		Location doorLocation 		= doorStartLocation;
		Location doorLocationNorth 	= doorLocation.getExit(Direction.NORTH).getExitToLocation();
		
		for (int z = 0; z < doorDimension.getHeight(); z++)
		{
			for (int x = doorStartLocation.getWorldLocation().getX(); x < doorStartLocation.getDimension().getWidth(); x++)
			{
				doorLocation.setType(LocationTypes.DOOR);
				doorLocation.setDescription("Front Door");
				
				doorLocation = doorLocation.getExit(Direction.EAST).getExitToLocation();
			}
			
			doorLocation = doorLocationNorth;
			doorLocationNorth = doorLocationNorth.getExit(Direction.NORTH).getExitToLocation();
		}

		doorEnter 	 	= enter;
		doorExit	 	= exit;
		doorHardware 	= new DoorHardware(hardwareType, insideLockType, outsideLockType);		
	}
	
	/*
	 * Getters
	 * 
	 */
	
	public Exit getEnter()
	{
		return doorEnter;
	}
	
	public Exit getExit()
	{
		return doorExit;
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
	
	public boolean bustDoor()
	{
		return doorHardware.setBroken();
	}
}
