package adventureunittests;

import adventure.Door;
import adventure.DoorHardware;

public class TestApp
{
	public static void main(String[] args)
	{
		TestDoor door = new TestDoor(DoorHardware.HANDLESET_TYPE, DoorHardware.KNOB_LOCK_TYPE, DoorHardware.KEY_LOCK_TYPE);
		
		door.run();
	}
}
