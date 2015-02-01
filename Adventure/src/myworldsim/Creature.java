package myworldsim;

/*
 * Create Class
 * 
 * Ryan's Idea
 * 
 */

public class Creature
{
	/*
	 * Class Instance Variables
	 * 
	 */
	
	private int 						creatureHealth;
	private int 						creatureLives;
	private int 						creatureSpeed;
	private int 						creatureFangLength;
	private int							creatureClawLength;
	private int							creatureArmor;
	private CreatureDimension 			creatureDimension;
	private CreatureVision				creatureVision;
	private int							creatureJump;
	private int							creatureLegs;
	private int							creatureHearing;
	private	int							creatureChompingPower;
	private int							creatureStompingPower;
	
	/*
	 * Class Constants
	 * 
	 */
	
	private final int					DEFAULT_CREATURE_HEALTH				= 100;
	private final int					DEFAULT_CREATURE_LIVES				= 2;
	private final int					DEFAULT_CREATURE_SPEED				= 40;							// In MPH
	private final int					DEFAULT_CREATURE_FANG_LENGTH		= 10;							// In inches
	private final int					DEFAULT_CREATURE_LENGTH				= 6;							// In feet
	private final int					DEFAULT_CREATURE_WIDTH				= 3;							// In feet
	private final int					DEFAULT_CREATURE_HEIGHT				= 4;							// In feet
	private final int					DEFAULT_CREATURE_JUMPING_ABILITY	= 6;							// In feet
	private final int					DEFAULT_CREATURE_CLAW_LENGTH		= 3;							// In inches
	private final int					DEFAULT_CREATURE_ARMOR				= 2;							// In inches
	private final CreatureVision		DEFAULT_CREATURE_VISION				= CreatureVision.HORSE_VISION;	// Best eyesight: hawk - 1 mile or 5280 feet
	private final int					DEFAULT_CREATURE_LEGS				= 4;
	private final int					DEFAULT_CREATURE_HEARING			= 100;							// In feet
	private final int					DEFAULT_CREATURE_CHOMPING_POWER		= 50;							// Percent
	private final int					DEFAULT_CREATURE_STOMPING_POWER		= 30;
	
	public static enum CreatureVision
	{
		BLIND,						// int 0
		DOG_VISION,					// int 1
		HUMAN_VISION,				// int 2
		HORSE_VISION,				// int 3
		DRAGON_FLY_VISION,			// int 4
		BIRD_VISION,				// int 5
		SNAKE_VISION,				// int 6
		CAMELEON_VISION,			// int 7
		OGRE_FACED_SPIDER_VISION,	// int 8
		GECKO_VISION,				// int 9
		MANTIS_SHRIMP_VISION,		// int 10
		GOAT_VISION,				// int 11
		HAWK_VISION					// int 12
	}
	
	/*
	 * Constructor Methods
	 * 
	 */
	
	public Creature()
	{
		creatureHealth			= DEFAULT_CREATURE_HEALTH;
		creatureLives			= DEFAULT_CREATURE_LIVES;
		creatureSpeed			= DEFAULT_CREATURE_SPEED;
		creatureFangLength		= DEFAULT_CREATURE_FANG_LENGTH;
		creatureClawLength		= DEFAULT_CREATURE_CLAW_LENGTH;
		creatureArmor			= DEFAULT_CREATURE_ARMOR;
		creatureDimension		= new CreatureDimension(DEFAULT_CREATURE_LENGTH, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT);
		creatureVision			= DEFAULT_CREATURE_VISION;
		creatureJump			= DEFAULT_CREATURE_JUMPING_ABILITY;
		creatureLegs			= DEFAULT_CREATURE_LEGS;
		creatureHearing			= DEFAULT_CREATURE_HEARING;
		creatureChompingPower 	= DEFAULT_CREATURE_CHOMPING_POWER;
		creatureStompingPower	= DEFAULT_CREATURE_STOMPING_POWER;
	}
	
	// Used by Troll class
	
	public Creature(int height)
	{
		creatureHealth			= DEFAULT_CREATURE_HEALTH;
		creatureLives			= DEFAULT_CREATURE_LIVES;
		creatureSpeed			= DEFAULT_CREATURE_SPEED;
		creatureFangLength		= DEFAULT_CREATURE_FANG_LENGTH;
		creatureClawLength		= DEFAULT_CREATURE_CLAW_LENGTH;
		creatureArmor			= DEFAULT_CREATURE_ARMOR;
		creatureDimension		= new CreatureDimension(DEFAULT_CREATURE_LENGTH, DEFAULT_CREATURE_WIDTH, height);
		creatureVision			= DEFAULT_CREATURE_VISION;
		creatureJump			= DEFAULT_CREATURE_JUMPING_ABILITY;
		creatureLegs			= DEFAULT_CREATURE_LEGS;
		creatureHearing			= DEFAULT_CREATURE_HEARING;
		creatureChompingPower 	= DEFAULT_CREATURE_CHOMPING_POWER;
		creatureStompingPower	= DEFAULT_CREATURE_STOMPING_POWER;
	}
	
	// Used by TRex class
	
	public Creature(int length, int height, int speed, int jump, int armor, CreatureVision vision, int legs)
	{
		creatureHealth			= DEFAULT_CREATURE_HEALTH;
		creatureLives			= DEFAULT_CREATURE_LIVES;
		creatureSpeed			= speed;
		creatureFangLength		= DEFAULT_CREATURE_FANG_LENGTH;
		creatureClawLength		= DEFAULT_CREATURE_CLAW_LENGTH;
		creatureArmor			= armor;
		creatureDimension		= new CreatureDimension(length, height, DEFAULT_CREATURE_HEIGHT);
		creatureVision			= vision;
		creatureJump			= jump;
		creatureLegs			= legs;
		creatureHearing			= DEFAULT_CREATURE_HEARING;
		creatureChompingPower 	= DEFAULT_CREATURE_CHOMPING_POWER;
		creatureStompingPower	= DEFAULT_CREATURE_STOMPING_POWER;
	}
	
	public Creature(int health, int lives, int speed, int fangLength, int clawLength, int armor, int length, int width, int height, CreatureVision vision, int jump, int legs, int hearing, int chomping, int stomping)
	{
		creatureHealth			= health;
		creatureLives			= lives;
		creatureSpeed			= speed;
		creatureFangLength		= fangLength;
		creatureClawLength		= clawLength;
		creatureArmor			= armor;
		creatureDimension		= new CreatureDimension(length, width, height);
		creatureVision			= vision;
		creatureJump			= jump;
		creatureLegs			= legs;
		creatureHearing			= hearing;
		creatureChompingPower 	= chomping;
		creatureStompingPower	= stomping;
	}
	
	/*
	 * Getters and Setters
	 * 
	 */
	
	public int getHealth()
	{
		return creatureHealth;
	}

	public void setHealth(int health)
	{
		creatureHealth = health;
	}

	public int getLives()
	{
		return creatureLives;
	}

	public void setLives(int lives)
	{
		creatureLives = lives;
	}

	public int getSpeed()
	{
		return creatureSpeed;
	}

	public void setSpeed(int speed)
	{
		creatureSpeed = speed;
	}

	public int getFangLength()
	{
		return creatureFangLength;
	}

	public void setFangLength(int fangLength)
	{
		creatureFangLength = fangLength;
	}

	public int getClawLength()
	{
		return creatureClawLength;
	}

	public void setClawLength(int clawLength)
	{
		creatureClawLength = clawLength;
	}

	public int getArmor()
	{
		return creatureArmor;
	}

	public void setArmor(int armor)
	{
		creatureArmor = armor;
	}

	public CreatureDimension getDimension()
	{
		return creatureDimension;
	}

	public void setDimension(CreatureDimension dimension)
	{
		creatureDimension = dimension;
	}

	public CreatureVision getVision()
	{
		return creatureVision;
	}

	public void setVision(CreatureVision vision)
	{
		creatureVision = vision;
	}

	public int getJumpingAblity()
	{
		return creatureJump;
	}

	public void setJumpingAblity(int jump)
	{
		creatureJump = jump;
	}

	public int getLegs()
	{
		return creatureLegs;
	}

	public void setLegs(int legs)
	{
		creatureLegs = legs;
	}

	public int getHearing()
	{
		return creatureHearing;
	}

	public void setHearing(int hearing)
	{
		creatureHearing = hearing;
	}

	public int getChompingPower()
	{
		return creatureChompingPower;
	}

	public void setChompingPower(int chompingPower)
	{
		creatureChompingPower = chompingPower;
	}

	public int getStompingPower()
	{
		return creatureStompingPower;
	}

	public void setStompingPower(int stompingPower)
	{
		creatureStompingPower = stompingPower;
	}
	
	/*
	 * Actions
	 * 
	 */
	
	public void find()
	{
		
	}
	
	public void eat()
	{
		
	}
	
	public void sleep()
	{
		
	}
	
	public void heal()
	{
		
	}
	
	public void jump()
	{
		
	}
}
