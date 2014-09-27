package adventure;

public class Window
{
	/*
	 * Class Instance Variables
	 * 
	 */
	
	private boolean 	windowOpened;
	private boolean 	windowCanOpen;
	private boolean		windowLocked;
	private boolean		windowCanLock;
	private boolean		windowCanLook;
	private int			windowType;
	
	
	/*
	 * Class Constants
	 * 
	 */
	
	private final int	WINDOW_SLIDER_TYPE 	= 1;
	private final int	WINDOW_HUNG_TYPE  	= 2;
	private final int	WINDOW_HINGED_TYPE	= 3;
	private final int	WINDOW_BAY_TYPE		= 4;
	
	/*
	 * Constructors
	 * 
	 */
	
	public Window(Direction insideExitDirection, Direction outsideExitDirection, Location location, int type)
	{
		if (outsideExitDirection == Direction.NOWHERE || type == WINDOW_BAY_TYPE)
		{
			windowOpened	= false;
			windowCanOpen 	= false;
			windowLocked	= false;
			windowCanLock	= false;
		}
		else
		{
			windowOpened	= false;
			windowCanOpen 	= true;
			windowLocked	= true;
			windowCanLock	= true;
		}
	}
	
	/*
	 * Getters
	 * 
	 */
	
	public boolean isWindowOpen()
	{
		return windowOpened;
	}

	public boolean canWindowOpen()
	{
		return windowCanOpen;
	}

	public boolean isWindowLocked()
	{
		return windowLocked;
	}

	public boolean canWindowLock()
	{
		return windowCanLock;
	}

	public boolean canLookThruWindow()
	{
		return windowCanLook;
	}
	
	public int getWindowType()
	{
		return windowType;
	}

	/*
	 * Other Methods
	 * 
	 */
	
	public boolean openWindow()
	{
		if (windowCanOpen && !windowOpened)
		{
			windowOpened = true;
		}
		
		return windowOpened;
	}
	
	public boolean closeWindow()
	{
		if (windowCanOpen && windowOpened)
		{
			windowOpened = false;
		}
		
		return windowOpened;
	}
	
	public boolean lockWindow()
	{
		if (windowCanLock && !windowLocked)
		{
			windowLocked = true;
		}
		
		return windowLocked;
	}
	
	public boolean unlockWindow()
	{
		if (windowCanLock && windowLocked)
		{
			windowLocked = false;
		}
		
		return windowLocked;
	}
	
	public boolean breakWindow()
	{
		windowOpened = true;
		
		return windowOpened;
	}
	
	public boolean jumpOutWindow()
	{
		boolean canJump = false;
		
		if (windowOpened)
		{
			canJump = true;
		}
		
		return canJump;
	}
}