package adventure;

public class WorldLocation
{
	/*
	 * Class Instance Variables
	 * 
	 */
	
	private short	x;		// Width (columns)
	private short	y;		// Length (rows)
	
	/*
	 * Class Constants
	 * 
	 */
	
	public static final short	NOWHERE = -1;
	
	/*
	 * Getters
	 * 
	 */
	
	public short getX()
	{
		return x;
	}
	
	public short getY()
	{
		return y;
	}
		
	/*
	 * Constructor
	 * 
	 */
	
	public WorldLocation(short x, short y)
	{
		this.x = x;
		this.y = y;
	}
}
