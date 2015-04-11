package unittests;

import myworldsim.World;
import myworldsim.Direction;
import myworldsim.DoorHardware;
import myworldsim.WorldDimension;
import myworldsim.WorldLocation;
import myworldsim.Location;
import myworldsim.LocationTypes;

public class TestDoorApp
{
	public static void main(String[] args)
	{
		World world = new World();
		
		String locationDescription		= "Front Door";
		Location location 				= world.getWorldLocation(0, 1);		
		Direction enter 				= Direction.NORTH;
		Direction exit 					= Direction.SOUTH;		
		
		// Create the Door location exits
		TestDoor door = new TestDoor(DoorHardware.HANDLESET_TYPE, DoorHardware.KNOB_LOCK_TYPE, DoorHardware.KEY_LOCK_TYPE, location, locationDescription, enter, exit);
		door.run();
	}
}
	