package myworldsim;

public enum PrimaryCommands
{
	MOVE (0),
	THROW (1),
	SHOOT (2),
	GET (3),
	OPEN (4),		// WHAT: FAUCET
	CLOSE (5),		// WHAT: FAUCET
	SIT (6),
	STAND (7),
	HIT (8),
	BREAK (9),
	LIGHT (10),		// WHAT: FIRE
	CUT (11),
	COOK (12),
	KILL (13),
	EAT(14),
	LAUNCH(15),
	PICKUP(16),
	TAKE(17),
	SHUTOFF(18),
	TURNON (19);
	
	/*
	 * Class Instance Variables
	 * 
	 */
	
	private int value;
	
	/*
	 * Construtor Method
	 */
	
	private PrimaryCommands(int command)
	{
		value = command;
	}
	
	/*
	 * toString Method
	 * 
	 */
	
	@Override
	public String toString()
	{
		return this.name().toLowerCase();
	}
}
