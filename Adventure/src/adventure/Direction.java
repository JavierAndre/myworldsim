package adventure;

public enum Direction
{
	NOWHERE(0),
	NORTH(1),
	SOUTH(2),
	EAST(3),
	WEST(4),
	NORTHEAST(5),
	NORTHWEST(6),
	SOUTHEAST(7),
	SOUTHWEST(8),
	UP(9),
	DOWN(10);
	
	/*
	 * Class Instance Variables
	 * 
	 */
	
	private int	value;
	
	/*
	 * Constants
	 * 
	 */
	
	
	
	/*
	 * Construtor Method
	 */
	
	private Direction(int direction)
	{
		value = direction;
	}
	
	/*
	 * toString Method
	 * 
	 */
	
	@Override
	public String toString()
	{
		return this.name().toLowerCase();
	}
}
