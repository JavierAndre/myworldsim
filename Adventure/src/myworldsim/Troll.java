package myworldsim;

public class Troll extends Creature
{
	/*
	 * Class Instance Variables
	 * 
	 */
	
	
	
	/*
	 * Class Constants
	 * 
	 */
	
	private static final int	DEFAULT_TROLL_HEIGHT	= 2;		// Feet
	
	/*
	 * Constructor Methods
	 * 
	 */

	public Troll()
	{
		super(DEFAULT_TROLL_HEIGHT);
	}
	
	public Troll(int health, int lives, int speed, int fangLength, int clawLength, int armor, int length, int width, int height, CreatureVision vision, int jump, int legs, int hearing, int chomping, int stomping)
	{
		super(health, lives, speed, fangLength, clawLength, armor, length, width, height, vision, jump, legs, hearing, chomping, stomping);
	}
	
	/*
	 * Actions
	 * 
	 */
	
	public void build()
	{
		
	}
	
	public void repair()
	{
		
	}
	
	public void swim()
	{
		
	}
	
	public void carry()
	{
		
	}
	
	public void toss()
	{
		
	}
	
	public void run()
	{
		
	}
	
	public void walk()
	{
		
	}
}
