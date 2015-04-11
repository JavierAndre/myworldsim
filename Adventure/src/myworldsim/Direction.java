package myworldsim;

public enum Direction
{
	NORTH((byte)(0)),
	SOUTH((byte)(1)),
	EAST((byte)(2)),
	WEST((byte)(3)),
	NORTHEAST((byte)(4)),
	NORTHWEST((byte)(5)),
	SOUTHEAST((byte)(6)),
	SOUTHWEST((byte)(7)),
	UP((byte)(8)),
	DOWN((byte)(9));
	
	/*
	 * Class Instance Variables
	 * 
	 */
	
	private byte value;
	
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
