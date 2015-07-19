package unittests;

import java.lang.reflect.Method;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import myworldsim.CommandInterpreterModel;
import myworldsim.CommandModel;
import myworldsim.Controller;

public class TestCommandInterpreter {
	
private Controller controller;
	
	public TestCommandInterpreter() {
		this.controller = new Controller();
	}

	public void menu() {
		
		int option 		 = 0;
		Scanner keyboard = new Scanner(System.in);
		
		while (option != 9) {
			
			System.out.println("\n" + "Command Interpreter Tests" + "\n");
			
			System.out.println("1. Test a Primary Command");
			System.out.println("2. Test all Primary Commands");
			System.out.println("3. Test all Primary Commands by Reflection");
			System.out.println("4. Test a Synonym Command");
			System.out.println("5. Test all Synonym Commands");
			System.out.println("9. Exit");
	
			try {
				System.out.print("\nEnter your Menu choice: ");
				option = keyboard.nextInt();
				System.out.println();
			}
			catch (InputMismatchException e) {
				keyboard.nextLine();
			}
			
			switch (option) {
			
				case 1:
				{
					executePrimaryCommand();
					break;
				}
				case 2:
				{
					executeAllPrimaryCommands();
					break;
				}
				case 3:
				{
					executeAllPrimaryCommandsByReflection();
					break;
				}
				case 4:
				{
					executeSynonymCommand();
					break;
				}
				case 5:
				{
					executeAllSynonymCommands();
					break;
				}
				case 9:
				{
					System.out.println("All Command Interpreter Tests performed.\n");
					break;
				}
				default:
				{
					System.out.println("Invalid Menu Option.\n");
					break;
				}
			}
		}
	}
	
	/*
	 * Commands
	 * 
	 */
	
	private void executePrimaryCommand() {
		
		System.out.println("Command Interpreter Primary Command Test: Move" + "\n");
		
		// Commands needs to be all lowercase in order to match the method names
		CommandModel commandModel = new CommandModel();
		commandModel.setCommandName("move");
		String executionMessage = controller.executeCommand(commandModel);
		
		System.out.println("\n" + executionMessage + "\n");
		
		System.out.println("Command Interpreter Primary Command Test: List" + "\n");
		
		// Commands needs to be all lowercase in order to match the method names
		commandModel.setCommandName("list");
		executionMessage = controller.executeCommand(commandModel);
		
		System.out.println(executionMessage);
	}
	
	private void executeAllPrimaryCommands() {

		List<CommandModel> primaryCommandList = controller.getPrimaryCommands();
		
		System.out.println("Command Interpreter All Primary Commands Test" + "\n");
		
		for (CommandModel commandModel : primaryCommandList) {

			// Commands needs to be all lowercase in order to match the method names
			commandModel.setCommandName(commandModel.getCommandName());
			String executionMessage = controller.executeCommand(commandModel);
			
			System.out.println("\n" + executionMessage + "\n");
        }
	}
	
	private void executeAllPrimaryCommandsByReflection() {
		
		try {
			System.out.println("Command Interpreter All Primary Commands by Reflection Test" + "\n");
			
            Class<?> cls = CommandInterpreterModel.class;
            Method[] method = cls.getDeclaredMethods();
            CommandModel commandModel = new CommandModel();
            
            for (int index = 0; index < method.length; index++) {

            	// Commands needs to be all lowercase in order to match the method names
            	commandModel.setCommandName(method[index].getName());
            	String executionMessage = controller.executeCommand(commandModel);
            	
            	System.out.println("\n" + executionMessage + "\n");
            }
        } 
		catch (Throwable e) {
			System.out.println("Command Interpreter All Primary Commands by Reflection Test failed." + "\n");
        }
	}
	
	private void executeSynonymCommand() {
		
		System.out.println("Command Interpreter Synonym Command Test: Amble" + "\n");
		
		// Commands needs to be all lowercase in order to match the method names
		CommandModel commandModel = new CommandModel();
		commandModel.setCommandName("amble");
		
		String executionMessage = controller.executeCommand(commandModel);
		
		System.out.println("\n" + executionMessage + "\n");
		
		System.out.println("Command Interpreter Synonym Command Test: List" + "\n");
		
		// Commands needs to be all lowercase in order to match the method names
		commandModel.setCommandName("list");
		executionMessage = controller.executeCommand(commandModel);
		
		System.out.println(executionMessage);
	}

	private void executeAllSynonymCommands() {

		List<CommandModel> primaryCommandList = controller.getSynonymCommands();
		
		System.out.println("Command Interpreter All Synonym Commands Test" + "\n");
		
		for (CommandModel commandModel : primaryCommandList) {
	
			// Commands needs to be all lowercase in order to match the method names
			commandModel.setCommandName(commandModel.getCommandName());
			String executionMessage = controller.executeCommand(commandModel);
			
			System.out.println("\n" + executionMessage + "\n");
        }
	}
	
	/*
	 * main Method
	 * 
	 */
	
	public static void main(String[] args) {
		
		TestCommandInterpreter testCommandInterpreter = new TestCommandInterpreter();
		testCommandInterpreter.menu();
	}
}
