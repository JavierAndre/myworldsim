package myworldsim;

import java.util.Random;

public class DoorKey
{
	/*
	 * Class Instance Variables
	 * 
	 */
	
	private long keyCode;
	
	/*
	 * Class Variables
	 * 
	 */
	
	public static final int	BLANK_KEY = 0;
	
	/*
	 * Getters and Setters
	 * 
	 */
	
	public long getKeyCode()
	{
		return keyCode;
	}
	
	public void newKeyCode()
	{
		keyCode = keyCodeRandomizer();
	}
	
	public DoorKey copyKey()
	{
		DoorKey key = new DoorKey(this);
		
		return key;
	}
	
	/*
	 * Constructors
	 * 
	 */
	
	public DoorKey()
	{
		keyCode = keyCodeRandomizer();
	}
	
	public DoorKey(int code)
	{
		// Pass a code of zero to create a blank hardware or key
		keyCode = code;
	}

	// Copy constructor
	public DoorKey(DoorKey key) {
		
		keyCode = key.getKeyCode();
	}

	/*
	 * Other Methods
	 * 
	 */
	
	private long keyCodeRandomizer()
	{
		long code = 0;
		
		Random random = new Random();
		code = random.nextLong();
		
		return code;
	}
}
