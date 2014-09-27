package adventure;

public enum LocationTypes
{
	NOWHERE(0),
	WORLD(1),
	HOUSE(2),
	ROOM(3),
	HALLWAY(4),
	ENTRANCE(5),
	DOOR(6),
	WINDOW(7);
	
	/*
	 * Class Instance Variables
	 * 
	 */
	
	private int	value;
	
	/*
	 * Constructor
	 * 
	 */
	
	private LocationTypes(int type)
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
