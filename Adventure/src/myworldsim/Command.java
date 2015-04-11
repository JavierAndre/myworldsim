package myworldsim;

public class Command implements Comparable<Command> {

	/*
	 * Class Instance Variables
	 * 
	 */
	
	private String	command;
	private String	primaryCommand;
	
	/*
	 * Class Constants
	 * 
	 */
	
	
	/*
	 * Getters and Setters
	 * 
	 */
	
	public String getCommand() {
		return command;
	}

	public String getPrimaryCommand() {
		return primaryCommand;
	}
	
	/*
	 * Constructors
	 * 
	 */
	
	public Command(String command, String primaryCommand) {
		this.command 		= command;
		this.primaryCommand = primaryCommand;
	}

	@Override
	public int compareTo(Command o) {
		
		
		return 0;
	}
}
