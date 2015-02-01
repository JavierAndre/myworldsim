package myworldsim;

public class CommandInterpreter
{
	/*
	 * Class Instance Variables
	 * 
	 */
	
	
	
	/*
	 * Class Constants
	 * 
	 */
	
	// MOVE COMMANDS
	private final int 	GO 				= 1;
	private final int 	WALK			= 2;
	private final int	AMBLE			= 3;
	private final int	PROWL			= 4;
	private final int	STRIDE			= 5;
	private final int	RUN				= 6;
	private final int	JUMP			= 7;
	private final int	STAGGER 		= 8;
	private final int	STRUT			= 9;
	private final int	LEAVE			= 10;
	private final int	EXIT			= 11;	// WHAT: DOOR/WINDOW	HOW: DIRECTION
	private final int	GETIN			= 12;	// WHAT: DOOR/WINDOW	HOW: IN/OUT
	private final int	GETOUT			= 13;
	
	// THROW COMMANDS
	private final int	TOSS			= 10;
	private final int	FLICK			= 11;
	private final int	PITCH			= 12;
	private final int	HURL			= 13;
	
	// SHOOT COMMANDS
	private final int	FIRE			= 14;
	private final int	LAUNCH			= 13;
	
	// GET COMMANDS
	private final int	LIFT			= 15;
	private final int	PICKUP			= 16;
	private final int 	GRAB			= 17;
	private final int	TAKE			= 18;
	private final int	GET				= 19;	// WHAT: SOMETHING
	
	// OPEN COMMANDS

	
	// CLOSE COMMANDS
	private final int	SHUT			= 1;	// WHAT: DOOR/WINDOW
	private final int	SHUTOFF			= 2;	// WHAT: WATER/FAUCET/GAS/ENGINE/LIGHT
	private final int	SHUTUP			= 3;	// WHAT: TALKING
	
	// SIT COMMANDS
	
	
	// STAND COMMANDS
	
	
	// HIT COMMANDS
	private final int	SLAP			= 1;
	private final int	SWAT			= 2;
	private final int	PUNCH			= 3;
	private final int	SMACK			= 4;
	
	// BREAK COMMANDS
	private final int	SMASH			= 1;
	private final int	SHATTER			= 2;
	
	// LIGHT COMMANDS
	private final int	LIGHTS			= 3;	// WHAT: ALL LIGHTS		HOW: ON/OFF
	private final int	TURN			= 4;	// WHAT: LIGHT/LIGHTS 	HOW: ON/OFF			WHAT: KNOB
	private final int	SWITCH			= 5;	// WHAT: LIGHT			HOW: ON/OFF
	
	// CUT COMMANDS
	private final int	SLICE			= 1;
	private final int	DICE			= 2;
	
	// COOK COMMANDS
	private final int	ROAST			= 1;
	private final int	FRY				= 2;
	private final int	BOIL			= 3;
	
	// KILL COMMANDS
	
	
	
	
	private final int 	COMMANDS[][] 	= {
											{AMBLE, GO, JUMP, PROWL, RUN, STAGGER, STRIDE, STRUT, WALK},
											{FLICK, PITCH, TOSS},
											{FIRE, LAUNCH},
											{LIFT, PICKUP}
										
	};
	
	
	
	/*
	 * Constructor
	 * 
	 */
	
	public CommandInterpreter()
	{
		
	}
}
