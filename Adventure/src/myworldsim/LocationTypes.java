package myworldsim;

public enum LocationTypes
{
	BLOCKED((byte)(0)),
	WORLD((byte)(1)),
	HOUSE((byte)(2)),
	ROOM((byte)(3)),
	HALLWAY((byte)(4)),
	ENTRANCE((byte)(5)),
	DOOR((byte)(6)),
	WINDOW((byte)(7));
	
	/*
	 * Class Instance Variables
	 * 
	 */
	
	private byte value;
	
	/*
	 * Constructor
	 * 
	 */
	
	private LocationTypes(byte type)
	{
		value = type;
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
