package myworldsim;

public class AssaultRiffle extends Gun
{
	/*
	 * Class Instance Variables
	 * 
	 */
	
	
	
	/*
	 * Class Constants
	 * 
	 */
	
	private static final boolean DEFAULT_ASSAULT_RIFFLE_AUTOMATIC_SETTING	= true;
	private static final int	 DEFAULT_ASSAULT_RIFFLE_AMMO				= 40;						// M16
	private static final double  DEFAULT_ASSAULT_RIFFLE_CALIBER				= 5.56;						// M16 5.56x45mm NATO
	private static final double  DEFAULT_ASSAULT_RIFFLE_WEIGHT				= 8.79;						// M16 loaded weight
	
	private static final int	 DEFAULT_ASSAULT_RIFFLE_RPM					= 800;						// M16
	private static final int	 DEFAULT_ASSAULT_RIFFLE_DAMAGE				= 50;						// Percent of health
	private static final int	 DEFAULT_ASSAULT_RIFFLE_ACCURACY			= 210;						// In feet;
	
	/*
	 * Constructor Methods
	 * 
	 */
	
	public AssaultRiffle()
	{
		super(DEFAULT_ASSAULT_RIFFLE_CALIBER, DEFAULT_ASSAULT_RIFFLE_WEIGHT, DEFAULT_ASSAULT_RIFFLE_AMMO, DEFAULT_ASSAULT_RIFFLE_RPM, DEFAULT_ASSAULT_RIFFLE_AUTOMATIC_SETTING);
	}
	
}
