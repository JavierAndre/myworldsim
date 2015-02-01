package myworldsim;

public class RPG extends Weapon
{
	/*
	 * Class Instance Variables
	 * 
	 */
	
	private int	RPGBlastRadious;
	
	/*
	 * Class Constants
	 * 
	 */
	
	private 		final int	DEFAULT_RPG_BLAST_RADIUS	= 200;										// Square feet (10 x 20)
	
	private static final int	DEFAULT_RPG_DAMAGE			= 70;										// Percentage
	private static final int	DEFAULT_RPG_WEIGHT			= 15;										// Pounds
	private static final int	DEFAULT_RPG_ACCURACY		= 654;										// Feet;
	private static final int	DEFAULT_RPG_RANGE			= 3000;										// Feet
	private static final int	DEFAULT_RPG_MOBILITY		= Weapon.DEFAULT_MEDIUM_WEIGHT_MOBILITY;
	
	/*
	 * Constructor Methods
	 * 
	 */
	
	public RPG()
	{
		super(DEFAULT_RPG_DAMAGE, DEFAULT_RPG_WEIGHT, DEFAULT_RPG_ACCURACY, DEFAULT_RPG_RANGE, DEFAULT_RPG_MOBILITY);
		
		RPGBlastRadious = DEFAULT_RPG_BLAST_RADIUS;
	}
	
	public RPG(int damage, double weight, int accuracy, int range, int mobility, int blastRadious)
	{
		super(damage, weight, accuracy, range, mobility);
		
		RPGBlastRadious = blastRadious;
	}
}
