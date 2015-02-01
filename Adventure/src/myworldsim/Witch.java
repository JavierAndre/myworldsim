package myworldsim;

public class Witch extends Creature
{
	/*
	 * Class Instance Variables
	 * 
	 */
	
	private int	witchLives;
	private int witchSpeed;
	
	/*
	 * Class Constants
	 * 
	 */
	
	private final int	DEFAULT_WITCH_LIVES	= 3;
	private final int	DEFAULT_WICH_SPEED	= 10;		// Miles per hour
	
	/*
	 * Constructor Methods
	 * 
	 */
	
	public Witch()
	{
		witchLives = DEFAULT_WITCH_LIVES;
		witchSpeed = DEFAULT_WICH_SPEED;
	}
	
	public Witch(int lives, int speed)
	{
		witchLives = lives;
		witchSpeed = speed;
	}
	
	/*
	 * Actions
	 * 
	 */
	
	public void fly()
	{
		
	}
	
	public void run()
	{
		
	}
	
	public void walk()
	{
		
	}
	
	public void cook()
	{
		
	}
}
