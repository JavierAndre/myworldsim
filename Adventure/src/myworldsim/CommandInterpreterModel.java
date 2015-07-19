package myworldsim;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public class CommandInterpreterModel
{
	/*
	 * Class Instance Variables
	 * 
	 */
	
	private CommandTree<CommandModel> 	commandTree;
	private boolean 					executionStatus;
	
	/*
	 * Class Constants
	 * 
	 */
	
	private static final String			RESERVED_WORD 		= "_reserved";
	public static final String			COMMAND_NOT_FOUND 	= "I don't now how to do that.";
	
	/*
	 * Constructor
	 * 
	 */
	
	public CommandInterpreterModel() {
		commandTree = new CommandTree<CommandModel>();
	}
	
	/*
	 * Getters and Setters
	 * 
	 */
	
	public boolean getStatus() {
		return executionStatus;
	}
	
	/*
	 * buildBinarySearchCommandTree Methods
	 * 
	 */
	
	public boolean buildBinarySearchCommandTree(List<CommandModel> commandList) {
		
		boolean built = false;
			
		if (commandList.size() > 0) {

			for (CommandModel commandModel : commandList) {				
				commandTree.insert(commandModel);
			}
		}

		return built;
	}
	
	/*
	 * Get Commands Methods
	 * 
	 */
	
	public List<CommandModel> getCommands() {
		return commandTree.preOrder();
	}
	
	public List<CommandModel> getCommandsInOrder() {
		return commandTree.inOrder();
	}
	
	public List<CommandModel> getPrimaryCommands() {
		
		List<CommandModel> commandModelList 	= getCommandsInOrder();
		List<CommandModel> primaryCommandList 	= new LinkedList<CommandModel>();
		
		for (CommandModel commandModel: commandModelList) {
			
			if (commandModel.getPrimaryCommandId() == 0) {
				primaryCommandList.add(commandModel);
			}
		}
		
		return primaryCommandList;
	}
	
	public List<CommandModel> getSynonymCommands() {
		
		List<CommandModel> commandModelList 	= getCommandsInOrder();
		List<CommandModel> synonymCommandList 	= new LinkedList<CommandModel>();
		
		for (CommandModel commandModel: commandModelList) {
			
			if (commandModel.getPrimaryCommandId() > 0) {
				synonymCommandList.add(commandModel);
			}
		}
		
		return synonymCommandList;
	}

	/*
	 * findCommand Methods
	 * 
	 */
	
	public CommandModel findCommand(String command) {
		
		CommandModel commandModel = new CommandModel();
		commandModel.setCommandName(command);
		
		CommandTreeNode<CommandModel> commandTreeNode = commandTree.find(commandModel);

		// Check if the command was found
		if (commandTreeNode.getData() != CommandTreeNode.NOT_FOUND) {
			
			// Check if it is a Synonym Command
			commandModel = (CommandModel)commandTreeNode.getData();
			
			if (commandModel.getPrimaryCommandId() > 0) {
				
				// Find the Primary Command. Caller is responsible for testing whether or not it was found (call getCommandId()).
				commandModel = findCommand(commandModel.getPrimaryCommandName());
			}
		}
		
		return commandModel;
	}
	
	/*
	 * Commands
	 * 
	 */
	
	public String executeCommand(CommandModel commandModel, Object commandObject) {

		String	executionMessage = "";
		boolean executed 		 = false;
		
		// Find the command and get its command ID		
		CommandTreeNode<CommandModel> commandTreeNode = commandTree.find(commandModel);

		// Check if the command was found
		if (commandTreeNode.getData() != CommandTreeNode.NOT_FOUND) {
			
			commandModel = (CommandModel) commandTreeNode.getData();
		
			// String parameterl
			Class<?>[] paramString = new Class[2];
			paramString[0] = CommandModel.class;
			paramString[1] = Object.class;
			
			try {
				Class<?> cls = Class.forName("myworldsim.CommandInterpreterModel");
				Object obj = cls.newInstance();
		 
				// Call the Command method, pass a String param 
				Method method = cls.getDeclaredMethod(commandModel.getCommandName(), paramString);
				method.invoke(obj, commandModel, commandObject);

				executionMessage = commandModel.getCommandText();
				executed = true;
			}
			catch(ClassNotFoundException e){
				System.out.println("CommandInterpreterModel::executeCommand(): Class myworldsim.CommandInterpreterModel not found.");
			}
			catch(IllegalAccessException e){
				System.out.println("CommandInterpreterModel::executeCommand(): Class myworldsim.CommandInterpreterModel not found.");
			}
			catch(InstantiationException e){
				System.out.println("CommandInterpreterModel::executeCommand(): Class myworldsim.CommandInterpreterModel not found.");
			}
			catch(NoSuchMethodException e){
				
				// Check for a reserved word Command
				try {
					Class<?> cls = Class.forName("myworldsim.CommandInterpreterModel");
					Object obj = cls.newInstance();
			 
					// Call the Command method, pass a String param 
					Method method = cls.getDeclaredMethod(commandModel.getCommandName() + RESERVED_WORD, paramString);
					method.invoke(obj, commandModel, commandObject);

					executionMessage = commandModel.getCommandText();
					executed 		 = true;
				}
				catch(ClassNotFoundException ex){
					System.out.println("CommandInterpreterModel::executeCommand(): Class myworldsim.CommandInterpreterModel not found.");
				}
				catch(IllegalAccessException ex){
					System.out.println("CommandInterpreterModel::executeCommand(): Class myworldsim.CommandInterpreterModel not found.");
				}
				catch(InstantiationException ex){
					System.out.println("CommandInterpreterModel::executeCommand(): Class myworldsim.CommandInterpreterModel not found.");
				}
				catch(NoSuchMethodException ex){
					System.out.println("CommandInterpreterModel::executeCommand(): Method " + commandModel.getCommandName() + RESERVED_WORD + " in class myworldsim.CommandInterpreterModel not found.");
					executionMessage = COMMAND_NOT_FOUND;
				}
				catch(InvocationTargetException ex){
					System.out.println("CommandInterpreterModel::executeCommand(): Method " + commandModel.getCommandName() + RESERVED_WORD + " in class myworldsim.CommandInterpreterModel not found.");
					executionMessage = COMMAND_NOT_FOUND;
				}
			}
			catch(InvocationTargetException e){
				
				// Check for a reserved word Command
				try {
					Class<?> cls = Class.forName("myworldsim.CommandInterpreterModel");
					Object obj = cls.newInstance();
			 
					// Call the Command method, pass a String param 
					Method method = cls.getDeclaredMethod(commandModel.getCommandName() + RESERVED_WORD, paramString);
					method.invoke(obj, commandModel, commandObject);

					executionMessage = commandModel.getCommandText();
					executed 		 = true;
				}
				catch(ClassNotFoundException ex){
					System.out.println("CommandInterpreterModel::executeCommand(): Class myworldsim.CommandInterpreterModel not found.");
				}
				catch(IllegalAccessException ex){
					System.out.println("CommandInterpreterModel::executeCommand(): Class myworldsim.CommandInterpreterModel not found.");
				}
				catch(InstantiationException ex){
					System.out.println("CommandInterpreterModel::executeCommand(): Class myworldsim.CommandInterpreterModel not found.");
				}
				catch(NoSuchMethodException ex){
					System.out.println("CommandInterpreterModel::executeCommand(): Method " + commandModel.getCommandName() + RESERVED_WORD + " in class myworldsim.CommandInterpreterModel not found.");
					executionMessage = COMMAND_NOT_FOUND;
				}
				catch(InvocationTargetException ex){
					System.out.println("CommandInterpreterModel::executeCommand(): Method " + commandModel.getCommandName() + RESERVED_WORD + " in class myworldsim.CommandInterpreterModel not found.");
					executionMessage = COMMAND_NOT_FOUND;
				}
			}
		}
		
		executionStatus = executed;
		return executionMessage;
	}
		
	private void move(CommandModel commandModel, Object currentLocation) {
		
		if (commandModel.getNumberOfParameters() > 0) {
			
			String[] commandParameters = commandModel.getCommandParameters();
			
			String message = "Command: " + commandModel.getCommandName() + "\n";
			
			for (int index = 0; index < commandParameters.length; index++) {
				message = message + "Parameter: " + commandParameters[index] + "\n";
			}
			
			commandModel.setCommandText(message);
		}
		else {
			commandModel.setCommandText("Where would you like me to move?");
		}	
	}
	
	private void throw_reserved(String command) {
		
		//System.out.println("Let's " + command + "!");
	}
	
	private void shoot(String command) {
		
		//System.out.println("Let's " + command + "!");
	}
	
	private void get(String command) {
		
		//System.out.println("Let's " + command + "!");
	}
	
	private void open(String command) {
		
		//System.out.println("Let's " + command + "!");
	}
	
	private void close(String command) {
		
		//System.out.println("Let's " + command + "!");
	}
	
	private void sit(String command) {
		
		//System.out.println("Let's " + command + "!");
	}
	
	private void stand(String command) {
		
		//System.out.println("Let's " + command + "!");
	}
	
	private void hit(String command) {
		
		//System.out.println("Let's " + command + "!");
	}
	
	private void break_reserved(String command) {
		
		//System.out.println("Let's " + command + "!");
	}
	
	private void light(String command) {
		
		//System.out.println("Let's " + command + "!");
	}
	
	private void cut(String command) {
		
		//System.out.println("Let's " + command + "!");
	}
	
	private void cook(String command) {
		
		//System.out.println("Let's " + command + "!");
	}
	
	private void kill(String command) {
		
		//System.out.println("Let's " + command + "!");
	}
	
	private void eat(String command) {
		
		//System.out.println("Let's " + command + "!");
	}
	
	private void launch(String command) {
		
		//System.out.println("Let's " + command + "!");
	}
	
	private void pickup(String command) {
		
		//System.out.println("Let's " + command + "!");
	}
	
	private void take(String command) {
		
		//System.out.println("Let's " + command + "!");
	}
	
	private void shutoff(String command) {
		
		//System.out.println("Let's " + command + "!");
	}
	
	private void tighten(String command) {
		
		//System.out.println("Let's " + command + "!");
	}
	
	private void turnon(String command) {
		
		//System.out.println("Let's " + command + "!");
	}
	
	private void throwup(String command) {
		
		//System.out.println("Let's " + command + "!");
	}
}
