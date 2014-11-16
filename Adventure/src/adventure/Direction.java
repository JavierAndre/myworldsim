package adventure;

public enum Direction
{
	NOWHERE((byte)(0)),
	NORTH((byte)(1)),
	SOUTH((byte)(2)),
	EAST((byte)(3)),
	WEST((byte)(4)),
	NORTHEAST((byte)(5)),
	NORTHWEST((byte)(6)),
	SOUTHEAST((byte)(7)),
	SOUTHWEST((byte)(8)),
	UP((byte)(9)),
	DOWN((byte)(10));
	
	/*
	 * Class Instance Variables
	 * 
	 */
	
	private byte value;
	
	/*
	 * Constants
	 * 
	 */
	
	
	
	/*
	 * Construtor Method
	 */
	
	private Direction(byte direction)
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
