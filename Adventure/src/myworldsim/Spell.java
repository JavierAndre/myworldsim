package myworldsim;

public class Spell
{
	/*
	 * Class Instance Variables
	 * 
	 */
	
	private int		spellType;
	private String	spellName;
	private String	spell;
	
	/*
	 * Class Constants
	 * 
	 */
	
	public static int		HEALING			= 1;
	public static int		CURSE			= 2;
	public static int		TRANSFIGURATION	= 3;
	public static int		CHARM			= 4;	// Changes what an object can do, not what it is (e.g., make a human fly)
	public static int		PROTECTIVE		= 5;	// Protects an area, not a person
	public static int		JINX			= 6;	// Meant for ammusement, causes enbarraswment or light disconfort
	public static int		HEX				= 7;	// Moderate harm, less than Dark Magic and more than a Jinx
	
	public static String[]	HEALING_SPELLS = 
		{
			"Ferula Spell",				// Heals fractures
			"Episky Spell",				// Heals mild to moderate injuries
			"Vulnera Spell"				// Heals deep gashes
		};
	
	public static String[]	CURSE_SPELLS = 
		{
			"Killing Curse",
			"Jelly-Legs Curse",
			"Leg-Locker Curse",
			"Imperious Curse",			// Places the victim in a dream-like state
			"Basting Curse",			// Causes anyting the spell comes into contact with to explode
			"Disintegration Curse",
			"Floating Eye Curse"
		};
	
	public static String[] TRANSFIGURATION_SPELLS =
		{
			"Vanishment Spell",			// Causes things to vanish
			"Conjuration Spell",		// Causes things to appear
			"Wolf into Rat Spell",
			"T-Rex into Lizard Spell",
			"Human into Monkey Spell",
			"Gun into Flowrer Spell"
		};
	
	public static String[]	CHARM_SPELLS =
		{
			"Amplifying Charm",
			"Anti-Unlocking Charm",
			"Banishing Charm",
			"Disarming Charm",
			"Fixing Charm",
			"Shrinking Charm",
			"Talon-Clipping Charm",
			"Tooth-Shrinking Charm",
			"Unlocking Charm",
			"Stream of Flames Charm",
			"Repairing Charm",
			"Lightning Charm",
			"Invisibility Charm"
		};
	
	public static String[]	PROTECTIVE_SPELLS =
		{
			"Invisibility Spell",			// Hides a person
			"Force Field Spell",
			"Total Protection Speel",		// Protects an area for an extended period of time
			"Invibility Shield Spell"		// Hides an area
		};
	
	public static String[] JINX_SPELLS = 
		{
			"Backfiring Jinx",
			"Cantis Jinx",					// Causes victim to only want to sing
			"Dancing Feet Jinx",
			"Ebublio Jinx",					// Traps victim in a bubble
			"Finger-Removing Jinx",
			"Jelly-Brain Jinx",
			"Knockback Jinx",
			"Levicorpus Jink",				// Causes victim to be lifted in air by their feet
			"Vermiculus Jink"				// Transforms victim into a worm
		};
	
	public static String[] HEX_SPELLS = 
		{
			"Redactum Skullus Hex",			// Shrinks the head of the victim
			"Stickfast Hex"					// Makes the victim feet stick to the ground
		};
	
	/*
	 * Constructor Method
	 * 
	 */
	
	public Spell(int type, String name)
	{
		spellType = type;
		spellName = name;
	}

	/*
	 * Getters and Setters
	 * 
	 */
	
	public int getSpellType()
	{
		return spellType;
	}

	public void setSpellType(int type)
	{
		spellType = type;
	}

	public String getSpellName()
	{
		return spellName;
	}

	public void setSpellName(String name)
	{
		spellName = name;
	}

	public String getSpell()
	{
		return spell;
	}

	public void setSpell(String spell)
	{
		this.spell = spell;
	}
}
