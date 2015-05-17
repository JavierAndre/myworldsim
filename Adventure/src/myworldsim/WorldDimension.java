package myworldsim;

public class WorldDimension
{
	/*
	 * Class Instance Variables
	 * 
	 */
	
	private short	width;		// Along the X coordinate
	private short	height;		// Along the Y coordinate
	
	/*
	 * Getters
	 * 
	 */
	
	public short getWidth()
	{
		return width;
	}
	public short getHeight()
	{
		return height;
	}
	
	/*
	 * Constructor
	 * 
	 */
	
	public WorldDimension(short width, short height)
	{
		this.width	= width;
		this.height = height;
	}
}
