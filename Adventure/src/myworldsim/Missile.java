package myworldsim;

public class Missile extends Weapon
{
	/*
	 * Class Instance Variables
	 * 
	 */
	
	private int	missileBlastRadius;
	
	/*
	 * Class Constants
	 * 
	 */
	
	private 		final int	DEFAULT_MISSILE_BLAST_RADIUS	= 400;										// Square feet (20 x 20)
		
	private static final int	DEFAULT_MISSILE_DAMAGE			= 100;										// Percentage
	private static final int	DEFAULT_MISSILE_WEIGHT			= 2900;										// Pounds (approx. 290 Dylans)
	private static final int	DEFAULT_MISSILE_ACCURACY		= 1150;										// Feet
	private static final int	DEFAULT_MISSILE_RANGE			= 5280;										// Feet (1 mile)
	private static final int	DEFAULT_MISSILE_MOBILITY		= Weapon.DEFAULT_HEAVY_WEIGTH_MOBILITY;
	
	/*
	 * Constructor Methods
	 * 
	 */
	
	public Missile()
	{
		super(DEFAULT_MISSILE_DAMAGE, DEFAULT_MISSILE_WEIGHT, DEFAULT_MISSILE_ACCURACY, DEFAULT_MISSILE_RANGE, DEFAULT_MISSILE_MOBILITY);
		
		missileBlastRadius = DEFAULT_MISSILE_BLAST_RADIUS;
	}
	
	public Missile(int damage, double weight, int accuracy, int range, int mobility, int blastRadius)
	{
		super(damage, weight, accuracy, range, mobility);
		
		missileBlastRadius = blastRadius;
	}
	
	/*
	 * Actions
	 * 
	 */
	
	public void arm()
	{
		
	}
	
	public void explode()
	{
		
	}
	
	public void launch()
	{
		
	}
	
	public void fly()
	{
		
	}
	
	// Explode the missle if not going where it is supposed to
	
	public void detonate()
	{
		
	}
}
