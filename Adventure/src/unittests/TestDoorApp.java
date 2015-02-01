package unittests;

import myworldsim.DoorHardware;

public class TestDoorApp
{
	public static void main(String[] args)
	{
		TestDoor door = new TestDoor(DoorHardware.HANDLESET_TYPE, DoorHardware.KNOB_LOCK_TYPE, DoorHardware.KEY_LOCK_TYPE);
		door.run();
	}
}
