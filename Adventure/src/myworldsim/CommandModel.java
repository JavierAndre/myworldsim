package myworldsim;

import java.sql.Date;
import java.util.List;

public class CommandModel implements Comparable<CommandModel> {

	/*
	 * Class Instance Variables
	 * 
	 * Renamed variables to match SQL Properties table column names (except column names are all upper-case).
	 * Changed private to protected to allow use of reflection in Controller class.
	 */
	
	protected int		command_id;
	protected String	command_name;
	protected int		primary_command_id;
	protected String	primary_command_name;
	protected String	command_text;
	protected Date		date_added;
	protected Date		date_last_updated;
	protected boolean	active;

	private int			numberOfParameters;
	private String[]	commandParameters;
	
	/*
	 * Class Constants
	 * 
	 */
	
	
	/*
	 * Getters and Setters
	 * 
	 */
	
	public int getCommandId() {
		return command_id;
	}
	
	public void setCommandId(int commandId) {
		this.command_id = commandId;
	}
	
	public String getCommandName() {
		return command_name;
	}
	
	public void setCommandName(String commandName) {
		this.command_name = commandName;
	}

	public int getPrimaryCommandId() {
		return primary_command_id;
	}
	
	public void setPrimaryCommandId(int primaryCommandId) {
		this.primary_command_id = primaryCommandId;
	}
	
	public String getPrimaryCommandName() {
		return primary_command_name;
	}

	public void setPrimaryCommandName(String primaryCommandName) {
		this.primary_command_name = primaryCommandName;
	}
	
	public String getCommandText() {
		return command_text;
	}
	
	public void setCommandText(String commandText) {
		this.command_text = commandText;
	}
	
	public Date getDateAdded() {
		return date_added;
	}

	public void setDateAdded(Date dateAdded) {
		this.date_added = dateAdded;
	}

	public Date getDateLastUpdated() {
		return date_last_updated;
	}

	public void setDateLastUpdated(Date dateLastUpdated) {
		this.date_last_updated = dateLastUpdated;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getNumberOfParameters() {
		return numberOfParameters;
	}
	
	public String[] getCommandParameters() {
		return commandParameters;
	}
	
	public void setCommandParameters(String[] parameters) {
		commandParameters 	= parameters;
		numberOfParameters	= parameters.length;
	}
	
	/*
	 * Constructors
	 * 
	 */

	public CommandModel() {
		this.command_id				= 0;
		this.command_name 			= "";
		this.primary_command_id		= 0;
		this.primary_command_name	= "";
		this.command_text 			= "";
		this.date_added 			= new Date(0);
		this.date_last_updated		= new Date(0);
		this.active 				= false;
		this.commandParameters 		= new String[1];	// Array will be replaced by the caller of setCommandParameters()
		
		for (int index = 0; index < commandParameters.length; index++) {
			commandParameters[index] = "";
		}
		
		numberOfParameters 			 = 0;
	}
	
	public CommandModel(int commandId, String commandName, int primaryCommandId, String primaryCommandName, String commandText, String[] commandParameters, Date dateAdded, Date dateLastUpdated, boolean active) {
		this.command_id				= commandId;
		this.command_name 			= commandName;
		this.primary_command_id		= primaryCommandId;
		this.primary_command_name	= primaryCommandName;
		this.command_text 			= commandText;
		this.commandParameters		= commandParameters;
		numberOfParameters			= commandParameters.length;
		this.date_added 			= dateAdded;
		this.date_last_updated		= dateLastUpdated;
		this.active 				= active;
	}

	@Override
	public int compareTo(CommandModel model) {
		return command_name.compareTo(model.getCommandName());
	}
}
