package myworldsim;

public class Weapon
{
	/*
	 * Class Instance Variables
	 * 
	 */
	
	private int		weaponDamage;
	private double	weaponWeight;
	private int		weaponAccuracy;			// In feet
	private int		weaponRange;			// In feet
	private int 	weaponMobility;
	
	/*
	 * Class Constants
	 * 
	 */
	
	public static final int	DEFAULT_LIGHT_WEIGHT_MOBILITY	= 1;
	public static final int	DEFAULT_MEDIUM_WEIGHT_MOBILITY	= 2;
	public static final int	DEFAULT_HEAVY_WEIGTH_MOBILITY	= 3;
	
	/*
	 * Constructor MethodS
	 * 
	 */
	
	public Weapon(int damage, double weight, int accuracy, int range, int mobility)
	{
		weaponDamage 	= damage;
		weaponWeight 	= weight;
		weaponAccuracy	= accuracy;
		weaponRange		= range;
		weaponMobility	= mobility;
	}
	
	/*
	 * Actions
	 * 
	 */
	
	public void aim()
	{
		
	}
	
	public void harm()
	{
		
	}
}
