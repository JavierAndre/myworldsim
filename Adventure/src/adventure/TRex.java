package adventure;

public class TRex extends Creature
{
	/*
	 * Class Instance Variables
	 * 	
	 */
	
	private int								trexArms;
	private int								trexTailLength;
	private int								trexWhippingPower;
	
	/*
	 * Class Constants
	 * 
	 */
	
	private final int						DEFAULT_TREX_ARMS							= 2;
	private final int						DEFAULT_TREX_TAIL_LENGTH					= 10;							// In feet
	private final int						DEFAULT_TREX_CHOMPING_POWER					= 90;							// Percent
	private final int						DEFAULT_TREX_WHIPPING_POWER					= 70;
	private final int						DEFAULT_TREX_STOMPING_POWER					= 90;
	
	// Override Monster defaults
	
	private static final int				DEFAULT_TREX_LENGTH							= 40;							// In feet at the hips
	private static final int				DEFAULT_TREX_HEIGHT_STANDING				= 39;							// Overrides Monster DEFAULT_MONSTER_HEIGHT
	private static final int				DEFAULT_TREX_SPEED							= 25;							// Overrides Monster DEFAULT_MONSTER_SPEED
	private static final int				DEFAULT_TREX_JUMPING_ABILITY				= 2;							// Overrides Monster DEFAULT_MONSTER_JUMPING_ABILITY
	private static final int				DEFAULT_TREX_ARMOR							= 4;							// Overrides Monster DEFAULT_MONSTER_ARMOR
	private static final CreatureVision		DEFAULT_TREX_VISION							= CreatureVision.SNAKE_VISION;	// Overrides Monster DEFAULT_MONSTER_VISION
	private static final int				DEFAULT_TREX_LEGS							= 2;							// Overrides Monster DEFAULT_MONSTER_LEGS 
	
	
	/*
	 * Getters and Setters
	 * 
	 */
	
	public int getTrexArms()
	{
		return trexArms;
	}

	public void setTrexArms(int arms)
	{
		trexArms = arms;
	}

	public int getTrexTailLength()
	{
		return trexTailLength;
	}

	public void setTrexTailLength(int tailLength)
	{
		trexTailLength = tailLength;
	}
	
	public int getWhippingPower()
	{
		return trexWhippingPower;
	}
	
	public void setWhippingPower(int whipping)
	{
		trexWhippingPower = whipping;
	}
	
	/*
	 * Constructor Methods
	 * 
	 */
	
	public TRex()
	{
		super(DEFAULT_TREX_LENGTH, DEFAULT_TREX_HEIGHT_STANDING, DEFAULT_TREX_SPEED, DEFAULT_TREX_JUMPING_ABILITY, DEFAULT_TREX_ARMOR, DEFAULT_TREX_VISION, DEFAULT_TREX_LEGS);
		
		trexArms			= DEFAULT_TREX_ARMS;
		trexTailLength		= DEFAULT_TREX_TAIL_LENGTH;
		trexWhippingPower 	= DEFAULT_TREX_WHIPPING_POWER;
	}
	
	public TRex(int health, int lives, int speed, int fangLength, int clawLength, int armor, int length, int width, int height, CreatureVision vision, int jump, int legs, int hearing, int chomping, int stomping, int arms, int tailLength, int whipping)
	{
		super(health, lives, speed, fangLength, clawLength, armor, length, width, height, vision, jump, legs, hearing, chomping, stomping);
		
		trexArms 			= arms;
		trexTailLength 		= tailLength;
		trexWhippingPower	= whipping;
	}
	
	/*
	 * Actions
	 * 
	 */
	
	public void attack()
	{
		
	}
	
	public void walk()
	{
		
	}
	
	public void chomp()
	{
		
	}
	
	public void stomp()
	{
		
	}
	
	public void whip()
	{
		
	}
}
