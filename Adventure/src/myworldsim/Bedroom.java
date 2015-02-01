package myworldsim;

public class Bedroom extends Room
{
	/*
	 * Class Instance Variables
	 * 
	 */
	
	
	
	/*
	 * Class Constants
	 * 
	 */
	
	public static final WorldDimension	DEFAULT_BEDROOM_DIMENSION = new WorldDimension((short)(2), (short)(2));		// In Locations
	
	
	/*
	 * Constructor Methods
	 * 
	 */
	
	public Bedroom(WorldLocation location)
	{
		super(location, DEFAULT_BEDROOM_DIMENSION);
	}
	
	
}
