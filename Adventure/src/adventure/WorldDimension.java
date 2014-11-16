package adventure;

public class WorldDimension
{
	/*
	 * Class Instance Variables
	 * 
	 */
	
	private short	width;		// Along the X coordinate
	private short	length;		// Along the Y coordinate
	
	/*
	 * Getters
	 * 
	 */
	
	public short getWidth()
	{
		return width;
	}
	public short getLength()
	{
		return length;
	}
	
	/*
	 * Constructor
	 * 
	 */
	
	public WorldDimension(short width, short length)
	{
		this.width	= width;
		this.length = length;
	}
}
