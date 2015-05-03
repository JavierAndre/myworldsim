package myworldsim;

public enum PrimaryCommands
{
	MOVE (1),
	THROW (2),
	SHOOT (3),
	GET (4),
	OPEN (5),		// WHAT: FAUCET
	CLOSE (6),		// WHAT: FAUCET
	SIT (7),
	STAND (8),
	HIT (9),
	BREAK (10),
	LIGHT (11),		// WHAT: FIRE
	CUT (12),
	COOK (13),
	KILL (14),
	EAT(15),
	GO(16),
	WALK(17),
	AMBLE(18),
	PROWL(19),
	STRIDE(20),
	RUN(21),
	JUMP(22),
	STAGGER(23),
	STRUT(24),
	LEAVE(25),
	EXIT(26),
	TOSS(27),
	FLICK(28),
	PITCH(29),
	HURL(30),
	FIRE(31),
	LAUNCH(32),
	LIFT(33),
	PICKUP(34),
	GRAB(35),
	TAKE(36),
	SHUT(37),
	SHUTOFF(38),
	SHUTUP(39),
	SHUTDOWN(40),
	SLAP(41),
	SWAT(42),
	PUNCH(43),
	SMACK(44),
	SMASH(45),
	SHATTER(46),
	TIGHTEN(47),
	TURN(48),
	SWITCH(49),
	SLICE(50),
	TURNON (51);
	
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
