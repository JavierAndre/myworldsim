package adventure;

public class WorldLocation
{
	/*
	 * Class Instance Variables
	 * 
	 */
	
	private int	worldXCoordinate;
	private int	worldYCoordinate;
	private int	worldZCoordinate;
	
	/*
	 * Getters
	 * 
	 */
	
	public int getX()
	{
		return worldXCoordinate;
	}
	public int getY()
	{
		return worldYCoordinate;
	}
	public int getZ()
	{
		return worldZCoordinate;
	}
	
	/*
	 * Constructor
	 * 
	 */
	
	public WorldLocation(int x, int y, int z)
	{
		worldXCoordinate = x;
		worldYCoordinate = y;
		worldZCoordinate = z;
	}
}
