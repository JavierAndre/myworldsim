package myworldsim;

public class DoorHardware
{
	/*
	 * Class Instance Variables
	 * 
	 */
	
	private int					hardwareType;
	private int					hardwareInsideLockType;
	private int					hardwareOutsideLockType;
	
	private boolean				hardwareLatched;
	private boolean				hardwareKeyInserted;
	private boolean				hardwareLocked;
	private boolean				hardwareBroken;
	
	private DoorKey				hardwareKeyHole;
	
	/*
	 * Class Constants
	 * 
	 */

	// Hardware types
	public static final int		NO_HARDWARE_TYPE			= 0;
	public static final int		KNOB_TYPE					= 1;	// Rounded handle
	public static final int		HANDLESET_TYPE				= 2;	// Pull handle
	public static final int		LEVER_TYPE					= 3;	// Lever handle

	// Lock types
	public static final int		NO_LOCK_TYPE				= 0;	// Cannot be locked
	public static final int		KEY_LOCK_TYPE				= 1;	// Lock on the outside
	public static final int		KNOB_LOCK_TYPE				= 2;	// Lock on the inside
	public static final int		PUSH_LOCK_TYPE				= 3;	// Lock on the inside
	
	/*
	 * Getters
	 * 
	 */

	// Get Hardware and Lock Types
	
	public int getType()
	{
		return hardwareType;
	}

	public int getInsideLockType()
	{
		return hardwareInsideLockType;
	}

	public int getOutsideLockType()
	{
		return hardwareOutsideLockType;
	}
	
	public boolean canOpen()
	{
		return !hardwareBroken;
	}
	
	public boolean canLockFromInside()
	{
		return hardwareInsideLockType != NO_LOCK_TYPE;
	}
	
	public boolean canLockFromOutside()
	{
		return hardwareOutsideLockType != NO_LOCK_TYPE;
	}
	
	public DoorKey getKey()
	{
		return hardwareKeyHole.copyKey();
	}

	// Get Hardware Status

	public boolean isLatched()
	{
		return hardwareLatched;
	}
	
	public boolean isKeyInserted()
	{
		return hardwareKeyInserted;
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
	
	public boolean lockFromInside()
	{
		if (!isBroken() & canLockFromInside() && !isLocked())
		{
			hardwareLocked = true;
		}
		
		return hardwareLocked;
	}
	
	public boolean lockFromOutside(DoorKey key)
	{
		if (!isBroken() && canLockFromOutside() && !isLocked())
		{
			if (hardwareOutsideLockType == KEY_LOCK_TYPE)
			{
				if (insertAndTurnKey(key)) {
					
					hardwareLocked = true;
					removeKey();
				}
			}
			else
			{
				hardwareLocked = false;
			}
		}
		
		return hardwareLocked;
	}

	public boolean unlockFromInside()
	{
		boolean unlocked = false;
		
		if (!isBroken() && canLockFromInside() && isLocked())
		{
			hardwareLocked 	= false;
			unlocked 		= true;
		}
		
		return unlocked;
	}

	public boolean unlockFromOutside(DoorKey key)
	{
		boolean unlocked = false;
		
		if (!isBroken() && canLockFromOutside() && isLocked())
		{
			if (hardwareOutsideLockType == KEY_LOCK_TYPE)
			{
				if (insertAndTurnKey(key)) {
					
					hardwareLocked  = false;
					unlocked 		= true;
					removeKey();
				}
			}
			else
			{
				hardwareLocked = false;
				unlocked 	   = true;
			}
		}
		
		return unlocked;
	}

	private boolean insertAndTurnKey(DoorKey key)
	{
		if (hardwareKeyHole.getKeyCode() != DoorKey.BLANK_KEY && key.getKeyCode() == hardwareKeyHole.getKeyCode())
		{
			// Insert the key if a key is not already inserted
			if (!isKeyInserted())
			{
				hardwareKeyInserted = true;
			}
			
			// If a key is already inserted, remove it and insert the new key
			else if (removeKey())
			{
				hardwareKeyInserted = true;
			}
		}
		
		return hardwareKeyInserted;
	}
	
	private boolean removeKey()
	{
		if (isKeyInserted())
		{
			hardwareKeyInserted = false;
		}
		
		return hardwareKeyInserted;
	}
	
	public void setBroken()
	{
		hardwareBroken 		= true;
		hardwareLatched 	= false;
		hardwareKeyInserted	= false;
		hardwareLocked 		= false;
	}
	
	/*
	 * Constructors
	 * 
	 */

	// Blank hardware
	public DoorHardware()
	{
		hardwareType 			= NO_HARDWARE_TYPE;
		hardwareInsideLockType	= NO_LOCK_TYPE;
		hardwareOutsideLockType	= NO_LOCK_TYPE;
		
		hardwareLatched			= false;
		hardwareKeyInserted		= false;
		hardwareLocked			= false;
		hardwareBroken			= false;

		// Avoid using null by creating a BLANK DoorKey object
		hardwareKeyHole			= new DoorKey(DoorKey.BLANK_KEY);
	}
	
	public DoorHardware(int type, int insideLockType, int outsideLockType)
	{
		hardwareType 			= type;
		hardwareInsideLockType	= insideLockType;
		hardwareOutsideLockType	= outsideLockType;
			
		if (outsideLockType == KEY_LOCK_TYPE)
		{
			hardwareKeyHole = new DoorKey();
		}
		
		hardwareLatched			= true;
		hardwareKeyInserted		= false;
		hardwareLocked			= false;
		hardwareBroken			= false;		
	}
}
