package adventure;

public class WorldDimension
{
	/*
	 * Class Instance Variables
	 * 
	 */
	
	private int	worldWidth;			// Along the X coordinate
	private int	worldHeight;		// Along the Y coordinate (aka Depth)
	private int	worldLength;		// Along the Z coordinate
	
	/*
	 * Getters
	 * 
	 */
	
	public int getWidth()
	{
		return worldWidth;
	}
	public int getHeight()
	{
		return worldHeight;
	}
	public int getLength()
	{
		return worldLength;
	}
	
	/*
	 * Constructor
	 * 
	 */
	
	public WorldDimension(int width, int height, int length)
	{
		worldWidth	= width;
		worldHeight = height;
		worldLength	= length;
	}
}
