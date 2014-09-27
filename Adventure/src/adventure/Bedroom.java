package adventure;

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
	
	public static final WorldDimension	DEFAULT_BEDROOM_DIMENSION = new WorldDimension(2, 2, 1);		// In Locations
	
	
	/*
	 * Constructor Methods
	 * 
	 */
	
	public Bedroom(WorldLocation location)
	{
		super(location, DEFAULT_BEDROOM_DIMENSION);
	}
	
	
}
