package adventure;

public class CommandInterpreter
{
	/*
	 * Class Instance Variables
	 * 
	 */
	
	private boolean		validCommand;
	private String		reasonInvalid;
	
	/*
	 * Class Constants
	 * 
	 */
	
	// Commands
	
	private final String				EXIT					= "EXIT";
	private final String				X						= "X";
	private final String				QUIT					= "QUIT";
	private final String				Q						= "Q";
	private final String				IN						= "IN";
	private final String				I						= "I";
	private final String				OUT						= "OUT";
	private final String				O						= "O";
	private final String				GO						= "GO";
	private final String				G						= "G";
	private final String				TO						= "TO";
	private final String				T						= "T";
	private final String				GOTO					= "GOTO";
	private final String				NORTH					= "NORTH";
	private final String				N						= "N";
	private final String				SOUTH					= "SOUTH";
	private final String				S						= "S";
	private final String				EAST					= "EAST";
	private final String				E						= "E";
	private final String				WEST					= "WEST";
	private final String				W						= "W";
	private final String				NORTHEAST				= "NORTHEAST";
	private final String				NEAST					= "NEAST";
	private final String				NE						= "NE";
	private final String				NORTHWEST				= "NORTHWEST";
	private final String				NWEST					= "NWEST";
	private final String				NW						= "NW";
	private final String				SOUTHEAST				= "SOUTHEAST";
	private final String				SEAST					= "SEAST";
	private final String				SE						= "SE";
	private final String				SOUTHWEST				= "SOUTHWEST";
	private final String				SWEST					= "SWEST";
	private final String				SW						= "SW";
	
	// Invalid Command Reasons
	
	public static final String			UNKNOWN_COMMAND			= "I don't know that command!";
	public static final String			DEAD_END_DIRECTION		= "You can't go that way!";
	
	/*
	 * Getters
	 * 
	 */
	
	public boolean isCommandValid()
	{
		return validCommand;
	}
	
	public String getReasonInvalid()
	{
		return reasonInvalid;
	}
	
	/*
	 * Constructor Method
	 * 
	 */
	
	public CommandInterpreter()
	{
		validCommand 	= true;
		reasonInvalid 	= "";
	}
	
	/*
	 * Run Method
	 * 
	 */
	
	public boolean run(String command)
	{
		validCommand = true;
		
		/*
		 * Execute Command
		 * 
		 */
		
		command = command.toUpperCase();
		
		switch (command)
		{
			/*
			 * Direction Commands
			 * 
			 */
		
			case NORTH:
			case N:
			{
				AdventureLocation location = currentPlayerLocation.getExit(AdventureExitDirection.NORTH.ordinal()).getExitToLocation();
				
				if (location != AdventureExitDirection.NOWHERE)
				{
					currentPlayerLocation = location;
				}
				else
				{
					validCommand 	= false;
					reasonInvalid 	= DEAD_END_DIRECTION;
				}
				
				break;
			}
			
			case SOUTH:
			case S:
			{
				AdventureLocation location = currentPlayerLocation.getExit(AdventureExitDirection.SOUTH.ordinal()).getExitToLocation();
				
				if (location != AdventureExit.DEAD_END)
				{
					currentPlayerLocation = location;
				}
				else
				{
					validCommand 	= false;
					reasonInvalid 	= DEAD_END_DIRECTION;
				}
				
				break;
			}
			
			case EAST:
			case E:
			{
				AdventureLocation location = currentPlayerLocation.getExit(AdventureExitDirection.EAST.ordinal()).getExitToLocation();
				
				if (location != AdventureExit.DEAD_END)
				{
					currentPlayerLocation = location;
				}
				else
				{
					validCommand 	= false;
					reasonInvalid 	= DEAD_END_DIRECTION;
				}
				
				break;
			}
			
			case WEST:
			case W:
			{
				AdventureLocation location = currentPlayerLocation.getExit(AdventureExitDirection.WEST.ordinal()).getExitToLocation();
				
				if (location != AdventureExit.DEAD_END)
				{
					currentPlayerLocation = location;
				}
				else
				{
					validCommand 	= false;
					reasonInvalid 	= DEAD_END_DIRECTION;
				}
				
				break;
			}
			
			case NORTHEAST:
			case NEAST:
			case NE:
			{
				AdventureLocation location = currentPlayerLocation.getExit(AdventureExitDirection.NORTHEAST.ordinal()).getExitToLocation();
				
				if (location != AdventureExit.DEAD_END)
				{
					currentPlayerLocation = location;
				}
				else
				{
					validCommand 	= false;
					reasonInvalid 	= DEAD_END_DIRECTION;
				}
				
				break;
			}
			
			case NORTHWEST:
			case NWEST:
			case NW:
			{
				AdventureLocation location = currentPlayerLocation.getExit(AdventureExitDirection.NORTHWEST.ordinal()).getExitToLocation();
				
				if (location != AdventureExit.DEAD_END)
				{
					currentPlayerLocation = location;
				}
				else
				{
					validCommand 	= false;
					reasonInvalid 	= DEAD_END_DIRECTION;
				}
				
				break;
			}
			
			case SOUTHEAST:
			case SEAST:
			case SE:
			{
				AdventureLocation location = currentPlayerLocation.getExit(AdventureExitDirection.SOUTHEAST.ordinal()).getExitToLocation();
				
				if (location != AdventureExit.DEAD_END)
				{
					currentPlayerLocation = location;
				}
				else
				{
					validCommand 	= false;
					reasonInvalid 	= DEAD_END_DIRECTION;
				}
				
				break;
			}
		
			case SOUTHWEST:
			case SWEST:
			case SW:
			{
				AdventureLocation location = currentPlayerLocation.getExit(AdventureExitDirection.SOUTHWEST.ordinal()).getExitToLocation();
				
				if (location != AdventureExit.DEAD_END)
				{
					currentPlayerLocation = location;
				}
				else
				{
					validCommand 	= false;
					reasonInvalid 	= DEAD_END_DIRECTION;
				}
				
				break;
			}
			
			case IN:
			case I:
			{
				break;
			}
			
			case OUT:
			case O:
			{
				break;
			}
			
			case EXIT:
			case X:
			case QUIT:
			case Q:
			{
				gameOver = true;
				
				break;
			}
			
			default:
			{
				validCommand 	= false;
				reasonInvalid 	= UNKNOWN_COMMAND;
				
				break;
			}
		}
		
		return validCommand;
	}
}
