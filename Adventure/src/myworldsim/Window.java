package myworldsim;

public class Window
{
	/*
	 * Class Instance Variables
	 * 
	 */
	
	private Location		windowLocation;
	private Direction		windowEntryDirection;
	private Direction		windowExitDirection;
	private Direction		windowLookInDirection;
	private Direction		windowLookOutDirection;
	private WindowHardware	windowHardware;			// Object-Oriented Programming Principle: Composition: the Window HAS A WindowHardware

	/*
	 * Class Constants
	 * 
	 */
	
	
	
	/*
	 * Constructors
	 * 
	 */
	
	public Window(int type, int lockType, Location location, String locationDescription, Direction entryDirection, Direction exitDirection, Direction lookInDirection, Direction lookOutDirection)
	{	
		windowLocation = location;
		
		// Reclassify World Location as type WINDOW
		windowLocation.setType(LocationTypes.WINDOW);
		windowLocation.setDescription(locationDescription);
		
		// Redefine World Location Exits as leading NOWHERE
		for (int direction = 0; direction < Direction.values().length; direction++)
		{
			// Set each Exit to lead to NOWHERE
			windowLocation.getExit(Direction.values()[direction].ordinal()).setLocation(new Location());
		}
		
		// Check if the window cannot be opened because it is a bay window
		if (type == WindowHardware.WINDOW_BAY_TYPE)
		{
			windowHardware = new WindowHardware();
			
			windowEntryDirection = Exit.NOWHERE;
			windowExitDirection  = Exit.NOWHERE;
		}		
		// Check if the window is broken
		else if ((entryDirection == Exit.NOWHERE && exitDirection == Exit.NOWHERE))
		{
			windowHardware = new WindowHardware(type, lockType);
			windowHardware.setBroken();
			
			windowEntryDirection = Exit.NOWHERE;
			windowExitDirection  = Exit.NOWHERE;
		}
		// Normal type of window
		else
		{
			windowHardware = new WindowHardware(type, lockType);
			
			windowEntryDirection = entryDirection;
			windowExitDirection  = exitDirection;
		}
		
		windowLookInDirection 	= lookInDirection;
		windowLookOutDirection 	= lookOutDirection;

		
		// A Window enters and exits in whatever directions the Floorplan determines.
		// The Floorplan will specify the enter and exit Directions when it creates the Windows.
		Location windowEntryLocation 	= windowLocation.getExit(windowEntryDirection.ordinal()).getExitToLocation();
		Location windowExitLocation 	= windowLocation.getExit(windowExitDirection.ordinal()).getExitToLocation();
		
		windowLocation.getExit(entryDirection.ordinal()).setLocation(windowEntryLocation);
		windowLocation.getExit(exitDirection.ordinal()).setLocation(windowExitLocation);
	}
	
	/*
	 * Getters
	 * 
	 */
	
	public boolean isWindowOpen()
	{
		return !windowHardware.isLatched();
	}

	public boolean canWindowOpen()
	{
		return windowHardware.canOpen();
	}

	public boolean isWindowLocked()
	{
		return windowHardware.isLocked();
	}

	public boolean canWindowLock()
	{
		return windowHardware.canLock();
	}

	public boolean canLookIn()
	{
		return windowLookInDirection != Exit.NOWHERE;
	}
	
	public boolean canLookOut()
	{
		return windowLookOutDirection != Direction.NORTHWEST;
	}

	public Direction lookInDirection()
	{
		return windowLookInDirection;
	}
	
	public Direction lookOutDirecion()
	{
		return windowLookOutDirection;
	}
	
	public int getWindowType()
	{
		return windowHardware.getType();
	}

	/*
	 * Other Methods
	 * 
	 */
	
	public boolean openWindow()
	{
		boolean windowOpened = false;
		
		if (windowHardware.canOpen() && windowHardware.isLatched())
		{
			windowHardware.unlatch();
			windowOpened = true;
		}
		
		return windowOpened;
	}
	
	public boolean closeWindow()
	{
		boolean windowClosed = false;
		
		if (windowHardware.canOpen() && !windowHardware.isLatched())
		{
			windowHardware.latch();
			windowClosed = true;
		}
		
		return windowClosed;
	}
	
	public boolean lockWindow()
	{
		boolean windowLocked = false;
		
		if (windowHardware.canLock() && !windowHardware.isLocked())
		{
			windowHardware.lock();
			windowLocked = true;
		}
		
		return windowLocked;
	}
	
	public boolean unlockWindow()
	{
		boolean windowUnlocked = false;
		
		if (windowHardware.canLock() && windowHardware.isLocked())
		{
			windowHardware.unlock();
			windowUnlocked = true;
		}
		
		return windowUnlocked;
	}
	
	public boolean breakWindow()
	{
		boolean windowBroken = false;
		
		// How much force can you extert on the window? Randomize the amout of force???
		// Google "residential building code for window glass"
		// Nominal strength of untempered window glass (70 MPa) (143psi per MPa = 10KPsi), weight of the object hitting the window, distance of the object from the window
		// and the force used to throw the object against the window.
		// Nominal strength of tempered window glass: 210 MPa.
		// Use untempered glass for old house windows, and tempered glass for new houses.
		
		return windowBroken;
	}
	
	public boolean jumpIn()
	{
		boolean canJump = false;
		
		if (windowEntryDirection != Exit.NOWHERE && !windowHardware.isLatched())
		{
			canJump = true;
		}
		
		return canJump;
	}
	
	public boolean jumpOut()
	{
		boolean canJump = false;
		
		if (windowExitDirection != Exit.NOWHERE && !windowHardware.isLatched())
		{
			canJump = true;
		}
		
		return canJump;
	}
}