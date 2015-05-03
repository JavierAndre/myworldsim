package myworldsim;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

public class Controller {

	/*
	 * Class Instance Variables
	 * 
	 */
	
	private SQLDBModel				sqlDBModel;
	private CommandInterpreterModel commandInterpreterModel;
	
	/*
	 * Class Constants
	 * 
	 */
	
	public static final String	VERSION	= "0.3";

	/*
	 * Getters
	 * 
	 */
	
	public SQLDBModel getSQLDBModel() {
		return sqlDBModel;
	}
	
	/*
	 * Constructors
	 * 
	 */
	
	public Controller() {
		sqlDBModel 				= new SQLDBModel();
		commandInterpreterModel = new CommandInterpreterModel();

		List<CommandModel> commandList = getCommands(SQLDBModel.COMMANDS_TABLE);
		buildBinarySearchCommandTree(commandList);
	}
	
	/*
	 * Build Command Binary Search Tree
	 * 
	 */
	
	private boolean buildBinarySearchCommandTree(List<CommandModel> commandList) {
		return commandInterpreterModel.buildBinarySearchCommandTree(commandList);
	}

	/*
	 * Execute Commands
	 * 
	 */
	
	public String executeCommand(String command) {

		String executionMessage = "";
		boolean executed 		= false;

		// Find the command
		CommandModel commandModel = commandInterpreterModel.findCommand(command);

		if (commandModel.getCommandId() > 0) {
		
			// Execute the command
			executionMessage = commandInterpreterModel.executeCommand(commandModel.getCommandName());
			executed 		 = commandInterpreterModel.getStatus();
		}
		else {
			executionMessage = CommandInterpreterModel.COMMAND_NOT_FOUND;
		}
		
		return executionMessage;
	}
	
	/*
	 * Commands
	 * 
	 * Binary Command Search Tree
	 * 
	 */
	
	public CommandModel getCommand(String command) {
		return commandInterpreterModel.findCommand(command);
	}

	public List<CommandModel> getPrimaryCommands() {
		return commandInterpreterModel.getPrimaryCommands();
	}
	
	public List<CommandModel> getSynonymCommands() {
		return commandInterpreterModel.getSynonymCommands();
	}
	
	public List<CommandModel> getCommands() {	
		return commandInterpreterModel.getCommands();
	}
	
	public List<CommandModel> getCommandsInOrder() {	
		return commandInterpreterModel.getCommandsInOrder();
	}
	
	/*
	 * Commands
	 * 
	 * SQL DB CRUD
	 * 
	 */

	// CRUD: Create (INSERT)
	public boolean addCommand(CommandModel model) {
		
		List<SQLDBColModel> list = new LinkedList<SQLDBColModel>();
		
		SQLDBColModel colModel = new SQLDBColModel(SQLDBModel.COMMANDS_TABLE_COMMAND_ID, model.getCommandId());
		list.add(colModel);
		colModel = new SQLDBColModel(SQLDBModel.COMMANDS_TABLE_COMMAND_NAME, model.getCommandName());
		list.add(colModel);
		colModel = new SQLDBColModel(SQLDBModel.COMMANDS_TABLE_DATE_ADDED, model.getDateAdded());
		list.add(colModel);
		colModel = new SQLDBColModel(SQLDBModel.COMMANDS_TABLE_DATE_LAST_UPDATED, model.getDateLastUpdated());
		list.add(colModel);
		colModel = new SQLDBColModel(SQLDBModel.COMMANDS_TABLE_ACTIVE, model.isActive());
		list.add(colModel);
		
		return sqlDBModel.add(SQLDBModel.COMMANDS_TABLE, list);
	}

	// CRUD: READ (SELECT)
	public List<CommandModel> getCommands(String tableName) {
		
		List<CommandModel> commandList = new LinkedList<CommandModel>();
		
		List<Object> sqlDBRowModelList = sqlDBModel.get(tableName);
		
		for (int index = 0; index < sqlDBRowModelList.size(); index++) {
			
			// Extract the current SQL table row
			Object sqlTableRow = sqlDBRowModelList.get(index);
			
			CommandModel commandModel 				= new CommandModel();
			List<SQLDBColModel> sqlDBColModelList 	= ((SQLDBRowModel) sqlTableRow).getRow();

			// Use reflection instead of a lot of constants!
			Class<?> cls = CommandModel.class;
			Field[] variables = cls.getDeclaredFields();
			
			// For each SQLDBCol
			for (int col = 0; col < sqlDBColModelList.size(); col++) {
				
				// Match the current SQLDBCol with its corresponding PropertyModel class instance variable and fill in the current Property Model via Reflection
				for (int field = 0; field < variables.length; field++) {
				
					if (variables[field].getName().equalsIgnoreCase(sqlDBColModelList.get(col).getSqlDBColName())) {
					
						try {
							variables[field].set(commandModel, sqlDBColModelList.get(col).getSqlDBColValue());
						}
						catch (IllegalAccessException e) {
							System.out.println("Controller::getCommands(): Unable to set CommandModel variable " + variables[field].getName() + " from SQL Commands table col " + sqlDBColModelList.get(index).getSqlDBColName());
						}
					}
				}
			}
			
			commandList.add(commandModel);
		}
		
		return commandList;
	}

	// CRUD: READ (SELECT)
	public List<CommandModel> getCommand(String columnName, String searchValue, String operator) {
		
		List<CommandModel> commandList = new LinkedList<CommandModel>();
		
		List<Object> sqlDBRowModelList = sqlDBModel.get(SQLDBModel.COMMANDS_TABLE, columnName, searchValue, operator);
		
		for (int index = 0; index < sqlDBRowModelList.size(); index++) {
			
			// Extract the current SQL table row
			Object sqlTableRow = sqlDBRowModelList.get(index);
			
			CommandModel propertyModel 				= new CommandModel();
			List<SQLDBColModel> sqlDBColModelList 	= ((SQLDBRowModel) sqlTableRow).getRow();

			// Use reflection instead of a lot of constants!
			Class<?> cls = CommandModel.class;
			Field[] variables = cls.getDeclaredFields();
			
			// For each SQLDBCol
			for (int col = 0; col < sqlDBColModelList.size(); col++) {
				
				// Match the current SQLDBCol with its corresponding PropertyModel class instance variable and fill in the current Property Model via Reflection
				for (int field = 0; field < variables.length; field++) {
				
					if (variables[field].getName().equalsIgnoreCase(sqlDBColModelList.get(col).getSqlDBColName())) {
					
						try {
							variables[field].set(propertyModel, sqlDBColModelList.get(col).getSqlDBColValue());
						}
						catch (IllegalAccessException e) {
							System.out.println("Controller::getCommands(): Unable to set CommandModel variable " + variables[field].getName() + " from SQL Commands table col " + sqlDBColModelList.get(index).getSqlDBColName());
						}
					}
				}
			}
			
			commandList.add(propertyModel);
		}
		
		return commandList;
	}
}
