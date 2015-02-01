package myworldsim;

public class WindowHardware {

	/*
	 * Class Instance Variables
	 * 
	 */
	
	private int					hardwareType;
	private int					hardwareLockType;
	private boolean				hardwareLatched;
	private boolean				hardwareLocked;
	private boolean				hardwareBroken;
	
	/*
	 * Class Constants
	 * 
	 */

	// Hardware types
	public static final int		WINDOW_BAY_TYPE			= 0;	// Does not open (equivalent to the Door's NO_HARDWARE_TYPE)
	public static final int		WINDOW_SLIDER_TYPE 		= 1;	// Slides on tracks, locks with levers (up/down)
	public static final int		WINDOW_HUNG_TYPE  		= 2;	// Slides up/down on cables
	public static final int		WINDOW_HINGED_TYPE		= 3;	// Opens on hinges
	
	// Lock types
	public static final int		NO_LOCK_TYPE			= 0;	// Cannot be locked
	public static final int		LEVER_LOCK_TYPE			= 1;	// Lock on the inside, used by sliding windows and hinged windows
	
	/*
	 * Getters
	 * 
	 */

	// Get Hardware and Lock Types
	
	public int getType()
	{
		return hardwareType;
	}

	public int getLockType()
	{
		return hardwareLockType;
	}
	
	public boolean canOpen()
	{
		return !hardwareBroken;
	}
	
	public boolean canLock()
	{
		return hardwareLockType != NO_LOCK_TYPE;
	}
	
	// Get Hardware Status

	public boolean isLatched()
	{
		return hardwareLatched;
	}
	
	public boolean isLocked()
	{
		return hardwareLocked;
	}

	public boolean isBroken()
	{
		return hardwareBroken;
	}
	
	/*
	 *  Action/Set Methods
	 *  
	 */

	public boolean latch()
	{
		if (!isBroken())
		{
			hardwareLatched = true;
		}
		
		return hardwareLatched;
	}
	
	public boolean unlatch()
	{
		boolean unLatched = false;
		
		if (!isBroken() && !isLocked())
		{
			hardwareLatched = false;
			unLatched		= true;
		}
		
		return unLatched;
	}
	
	public boolean lock()
	{
		if (!isBroken() & canLock() && !isLocked())
		{
			hardwareLocked = true;
		}
		
		return hardwareLocked;
	}
	
	public boolean unlock()
	{
		boolean unlocked = false;
		
		if (!isBroken() && canLock() && isLocked())
		{
			hardwareLocked 	= false;
			unlocked 		= true;
		}
		
		return unlocked;
	}
	
	public void setBroken()
	{
		hardwareBroken 	= true;
		hardwareLatched = false;
		hardwareLocked 	= false;
	}
	
	/*
	 * Constructors
	 * 
	 */

	// Hardware for a window that is not designed to be opened
	public WindowHardware()
	{
		hardwareType 		= WINDOW_BAY_TYPE;
		hardwareLockType	= NO_LOCK_TYPE;		
		hardwareLatched		= false;
		hardwareLocked		= false;
		hardwareBroken		= false;
	}
	
	public WindowHardware(int type, int lockType)
	{
		hardwareType 		= type;
		hardwareLockType	= lockType;
		hardwareLatched		= true;
		hardwareLocked		= false;
		hardwareBroken		= false;		
	}
}
