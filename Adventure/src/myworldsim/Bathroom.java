package myworldsim;

public class Bathroom extends Room
{
	/*
	 * Class Instance Variables
	 * 
	 */
	
	private int			numberOfSinks;
	private int			numberOfShowers;
	private int			numberOfToilets;
	private int			numberOfMirrors;
	private int			numberOfCabinets;
	
	/*
	 * Class Constants
	 * 
	 */

	public static 	final WorldDimension  	DEFAULT_BATHROOM_DIMENSION	= new WorldDimension((short)(1), (short)(1));		// In Locations
	
	private final 	int						DEFAULT_BATHROOM_SINKS		= 1;
	private final 	int						DEFAULT_BATHROOM_SHOWERS	= 1;
	private final 	int						DEFAULT_BATHROOM_TOILETS	= 1;
	private final 	int						DEFAULT_BATHROOM_MIRRORS	= 1;
	private final 	int						DEFAULT_BATHROOM_CABINETS	= 2;
		
	/*
	 * Constructor Methods
	 * 
	 */
	
	public Bathroom(WorldLocation location)
	{
		super(location, DEFAULT_BATHROOM_DIMENSION);
		
		numberOfSinks 		= DEFAULT_BATHROOM_SINKS;
		numberOfShowers 	= DEFAULT_BATHROOM_SHOWERS;
		numberOfToilets		= DEFAULT_BATHROOM_TOILETS;
		numberOfMirrors 	= DEFAULT_BATHROOM_MIRRORS;
		numberOfCabinets 	= DEFAULT_BATHROOM_CABINETS;
	}
	
	public Bathroom(WorldLocation location, WorldDimension locationDimension, String description, int windows, int sinks, int showers, int toilets, int mirrors, int cabinets)
	{
		super(location, locationDimension, description, windows);
		
		numberOfSinks 		= sinks;
		numberOfShowers 	= showers;
		numberOfToilets		= toilets;
		numberOfMirrors 	= mirrors;
		numberOfCabinets 	= cabinets;
	}
}
