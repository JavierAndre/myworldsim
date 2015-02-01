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
	LIGHT (10),		// WHAT: A LIGHT	HOW: ON/OFF		WHAT: FIRE
	CUT (11),
	COOK (12),
	KILL (13);
	
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
