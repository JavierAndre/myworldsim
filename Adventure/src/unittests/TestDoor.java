package unittests;

import myworldsim.Direction;
import myworldsim.Door;
import myworldsim.DoorKey;
import myworldsim.Exit;
import myworldsim.Location;
import myworldsim.LocationTypes;
import myworldsim.World;
import myworldsim.WorldDimension;
import myworldsim.WorldLocation;

public class TestDoor
{
	/*
	 * Class Instance Variables
	 * 
	 */
	
	private Door door;
	
	/*
	 * Constructor
	 * 
	 */
	
	public TestDoor(int hardwareType, int insideLockType, int outsideLockType)
	{
		WorldLocation doorLocation	 	= new WorldLocation((short)(0), (short)(1));
		WorldDimension doorDimension 	= new WorldDimension((short)(3), (short)(8));

		Location location				= new Location(doorLocation, doorDimension, "Front Door", LocationTypes.DOOR);
		
		WorldLocation enterCoordinates	= new WorldLocation((short)(2),(short)(1));
		Location enterLocation 		 	= new Location(enterCoordinates, World.WORLD_LOCATION_DIMENSION, "entrance hall", LocationTypes.HALLWAY);
		
		WorldLocation exitCoordinates 	= new WorldLocation((short)(0),(short)(1));
		Location exitLocation 		 	= new Location(exitCoordinates, World.WORLD_LOCATION_DIMENSION, "entrance", LocationTypes.ENTRANCE);
		
		Exit enter 						= new Exit(Direction.NORTH, enterLocation);
		Exit exit 						= new Exit(Direction.SOUTH, exitLocation);
		
		door = new Door(location, doorDimension, enter, exit, hardwareType, insideLockType, outsideLockType);
	}
	
	/*
	 * Action Methods
	 * 
	 */
	
	public void run()
	{
		System.out.println("Opening the door...");
		
		boolean doorOpen = door.open();
		
		if (doorOpen)
		{
			System.out.println("The door is open.");
		}
		else
		{
			System.out.println("Can't open the door.");
		}
		
		System.out.println("Getting the key out of my pocket...");
		
		DoorKey key = door.getKey();
		
		// Test for a BLANK key
		if (key != null)
		{
			System.out.println("Found the key.");
			
			System.out.println("Locking the door from the outside...");
			
			boolean doorLocked = door.lockDoor(key);
			
			if (doorLocked) {
				System.out.println("Door is now locked.");
			}
			else {
				System.out.println("Door cannot be locked.");
			}
			
			// Try to lock the already locked door
			
			System.out.println("Locking the door from the outside...");
			
			if (!door.isLocked()) {
			
				doorLocked = door.lockDoor(key);
			
				if (doorLocked) {
					System.out.println("Door is now locked.");
				}
				else {
					System.out.println("Door cannot be locked.");
				}
			}
			else {
				System.out.println("The door is already locked.");
			}
			
			// Try to open the locked door
			
			System.out.println("Opening the door...");
			
			doorOpen = door.open();
			
			if (doorOpen)
			{
				System.out.println("The door is now open.");
			}
			else
			{
				System.out.println("Can't open the door. The door is " + (door.isLocked()? "locked." : door.isBusted()? "busted!" : "blocked, perhaps by a huge TRex. Do yu REEEALEY want to open the door?!") );
			}
			
			// Unlock the door
			
			System.out.println("Getting the key out of my pocket...");
			System.out.println("Unlocking the door...");
			
			boolean unlocked = door.unlockDoor(key);
			
			if (unlocked)
			{
				System.out.println("The door is now unlocked.");
			}
			else
			{
				System.out.println("Can't unlocked the door. The door is " + (door.isLocked()? "locked." : door.isBusted()? "busted!" : "blocked, perhaps by a huge TRex. Do yu REEEALEY want to open the door?!") );
			}
			
			// Open the door
			
			System.out.println("Opening the door...");
			
			doorOpen = door.open();
			
			if (doorOpen)
			{
				System.out.println("The door is now open.");
			}
			else
			{
				System.out.println("Can't open the door. The door is " + (door.isLocked()? "locked." : door.isBusted()? "busted!" : "blocked, perhaps by a huge TRex. Do yu REEEALEY want to open the door?!") );
			}
			
			// Lock the door from the inside. How can the game tell if the player is inside or outside the door???
			
			System.out.println("Locking the door from the inside...");
			
			boolean locked = door.lockDoor();
			
			if (locked)
			{
				System.out.println("The door is now locked.");
			}
			else
			{
				System.out.println("Can't lock the door. The door is " + (door.isLocked()? "already locked." : door.isBusted()? "busted!" : "blocked, perhaps by a nice, hungry TRex. PLEEEASE open the door!") );
			}
			
			// Unlock the door from the outside
			
			System.out.println("Getting the key out of my pocket...");
			System.out.println("Unlocking the door...");
			
			unlocked = door.unlockDoor(key);
			
			if (unlocked)
			{
				System.out.println("The door is now unlocked.");
			}
			else
			{
				System.out.println("Can't unlocked the door. The door is " + (door.isLocked()? "locked." : door.isBusted()? "busted!" : "blocked, perhaps by a huge TRex. Do yu REEEALEY want to open the door?!") );
			}
			
			// Lock the door from the outside
			
			System.out.println("Locking the door from the outside...");
			
			doorLocked = door.lockDoor(key);
			
			if (doorLocked) {
				System.out.println("Door is now locked.");
			}
			else {
				System.out.println("Door cannot be locked.");
			}
			
			// Unlock the door from the inside
			
			System.out.println("Unlocking the door from the outside...");
			
			unlocked = door.unlockDoor();
			
			if (unlocked)
			{
				System.out.println("The door is now unlocked.");
			}
			else
			{
				System.out.println("Can't unlocked the door. The door is " + (door.isLocked()? "locked." : door.isBusted()? "busted!" : "blocked, perhaps by a huge TRex. Do yu REEEALEY want to open the door?!") );
			}
			
			// Bust the door open!
			
			
			
			
			
			
		}
		else
		{
			System.out.println("Can't find the key.");
		}
	}
}
