package unittests;

import java.sql.Date;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import myworldsim.CommandModel;
import myworldsim.Controller;
import myworldsim.SQLDBModel;
import myworldsim.SQLDBColModel;

public class TestDatabase {

	private Controller controller;
	
	public TestDatabase() {
		this.controller = new Controller();
	}
	
	public void menu() {
	
		int option 		 = 0;
		Scanner keyboard = new Scanner(System.in);
		
		while (option != 9) {
			
			System.out.println("\n" + "Database Tests" + "\n");
			
			System.out.println("1. Test Select all Commands");	
			System.out.println("2. Test Select a Command");
			System.out.println("3. Test Select a Command from Command Binary Search Tree");
			System.out.println("4. Test Select all Primary Commands");
			System.out.println("5. Test Select all Commands in order");
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
					getCommands();
					break;
				}
				case 2:
				{
					getCommand();
					break;
				}
				case 3:
				{
					getCommandFromTree();
					break;
				}
				case 4:
				{
					getPrimaryCommands();
					break;
				}
				case 5:
				{
					getCommandsInOrder();
					break;
				}
				case 9:
				{
					System.out.println("All Database Tests performed.\n");
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
	 * CRUD (Create, Read, Update, Delete) Operations 
	 */

	// Create
	private void addCommand() {
		
		System.out.println("\n" + "Insert Command test..." + "\n");
		
		CommandModel model = new CommandModel();
		
		model.setCommandName("");
		model.setDateAdded(new Date(Calendar.getInstance().getTimeInMillis()));
		model.setDateLastUpdated(new Date(Calendar.getInstance().getTimeInMillis()));
		model.setActive(true);
		
		if (controller.addCommand(model)) {
			System.out.println("\nCommand " + model.getCommandName() + " added." + "\n");
		}
		else {
			System.out.println("\nnCommand " + model.getCommandName() + " could not be added." + "\n");
		}
	}
	
	// Read
	private void getCommands() {
		
		List<CommandModel> commandList = controller.getCommands(SQLDBModel.COMMANDS_TABLE);
		
		System.out.println("\n" + "Select All Commands test...");

		if (commandList.size() > 0) {
		
			for (CommandModel model : commandList) {
				System.out.println("\nCommand ID: \t\t" + model.getCommandId());
				System.out.println("Command: \t\t" + model.getCommandName());
				System.out.println("Primary Command ID:\t" + model.getPrimaryCommandId());
				System.out.println("Primary Command:\t" + model.getPrimaryCommandName());
				System.out.println("Date Added: \t\t" + model.getDateAdded());
				System.out.println("Date Last Updated: \t" + model.getDateLastUpdated());
				System.out.println("Active: \t\t" + (model.isActive() ? "Yes" : "No"));
			}
		}
		else {
			System.out.println("\nTestDatabase::getCommands(): the Commands table is empty or MySQL Server is not connected.");
		}
	}
	
	// Read
	private void getCommand() {
		
		System.out.println("Select a Command by Command Id 5 (Open) test...\n");
		
		List<CommandModel> commandList = controller.getCommand(SQLDBModel.COMMANDS_TABLE_COMMAND_ID, "5", SQLDBModel.EQUAL_TO);
		
		if (commandList.size() > 0) {
			
			for (CommandModel model : commandList) {
				System.out.println("\nCommand ID: \t\t" + model.getCommandId());
				System.out.println("Command: \t\t" + model.getCommandName());
				
				// Check if this command is a Primary Command
				if (model.getPrimaryCommandId() == 0) {
					System.out.println("Primary Command: \t" + model.getCommandName());
				}
				else {
					List<CommandModel> primaryCommandList = controller.getCommand(SQLDBModel.COMMANDS_TABLE_COMMAND_ID,  String.valueOf(model.getPrimaryCommandId()), SQLDBModel.EQUAL_TO);
					
					if (primaryCommandList.size() > 0) {
						
						for (CommandModel primaryCommandModel : primaryCommandList) {
							System.out.println("Primary Command: \t" + primaryCommandModel.getCommandName());
						}
					}
					else {
						System.out.println("\nTestDatabase::getCommand(): Primary Command with Command ID " + model.getPrimaryCommandId() + " not found or MySQL Server is not connected.");
					}
				}
				
				System.out.println("Date Added: \t\t" + model.getDateAdded());
				System.out.println("Date Last Updated: \t" + model.getDateLastUpdated());
				System.out.println("Active: \t\t" + (model.isActive() ? "Yes" : "No"));
			}
		}
		else {
			System.out.println("\nTestDatabase::getCommand(): Command with Command ID 5 (Open) not found or MySQL Server is not connected.");
		}
		
		System.out.println("\nSelect a Command by Command Name Run test...\n");
		
		commandList = controller.getCommand(SQLDBModel.COMMANDS_TABLE_COMMAND_NAME, "run", SQLDBModel.EQUAL_TO);
		
		if (commandList.size() > 0) {
			
			for (CommandModel model : commandList) {
				System.out.println("\nCommand ID: \t\t" + model.getCommandId());
				System.out.println("Command: \t\t" + model.getCommandName());
				
				// Check if this command is a Primary Command
				if (model.getPrimaryCommandId() == 0) {
					System.out.println("Primary Command: \t" + model.getCommandName());
				}
				else {
					List<CommandModel> primaryCommandList = controller.getCommand(SQLDBModel.COMMANDS_TABLE_COMMAND_ID,  String.valueOf(model.getPrimaryCommandId()), SQLDBModel.EQUAL_TO);
					
					if (primaryCommandList.size() > 0) {
						
						for (CommandModel primaryCommandModel : primaryCommandList) {
							System.out.println("Primary Command: \t" + primaryCommandModel.getCommandName());
						}
					}
					else {
						System.out.println("\nTestDatabase::getCommand(): Primary Command with Command ID " + model.getPrimaryCommandId() + " not found or MySQL Server is not connected.");
					}
				}
				
				System.out.println("Date Added: \t\t" + model.getDateAdded());
				System.out.println("Date Last Updated: \t" + model.getDateLastUpdated());
				System.out.println("Active: \t\t" + (model.isActive() ? "Yes" : "No"));
			}
		}
		else {
			System.out.println("\nTestDatabase::getCommand(): Command 'RUN' not found or MySQL Server is not connected.");
		}
	}
	
	// Read
	private void getCommandFromTree() {
		
		System.out.println("Select a Command by Command Name (Open) test...\n");
		
		CommandModel commandModel = controller.getCommand("open");
		
		if (commandModel.getCommandId() > 0) {
			
				System.out.println("Command ID: \t\t" + commandModel.getCommandId());
				System.out.println("Command: \t\t" + commandModel.getCommandName());
				System.out.println("Primary Command ID: \t" + commandModel.getPrimaryCommandId());
				System.out.println("Primary Command: \t" + commandModel.getPrimaryCommandName());
				System.out.println("Date Added: \t\t" + commandModel.getDateAdded());
				System.out.println("Date Last Updated: \t" + commandModel.getDateLastUpdated());
				System.out.println("Active: \t\t" + (commandModel.isActive() ? "Yes" : "No"));
		}
		else {
			System.out.println("TestDatabase::getCommand(): Command Open not found or MySQL Server is not connected.");
		}
		
		System.out.println("\n" + "Select a Command by Command Name (Run) test...\n");
		
		commandModel = controller.getCommand("run");
		
		if (commandModel.getCommandId() > 0) {
			
				System.out.println("Command ID: \t\t" + commandModel.getCommandId());
				System.out.println("Command: \t\t" + commandModel.getCommandName());
				System.out.println("Primary Command ID: \t" + commandModel.getPrimaryCommandId());
				System.out.println("Primary Command: \t" + commandModel.getPrimaryCommandName());
				System.out.println("Date Added: \t\t" + commandModel.getDateAdded());
				System.out.println("Date Last Updated: \t" + commandModel.getDateLastUpdated());
				System.out.println("Active: \t\t" + (commandModel.isActive() ? "Yes" : "No"));
		}
		else {
			System.out.println("TestDatabase::getCommand(): Command Run not found or MySQL Server is not connected.");
		}
		
		System.out.println("\n" + "Select a Command by Command Name (Ask) test...\n");
		
		commandModel = controller.getCommand("ask");
		
		if (commandModel.getCommandId() > 0) {
			
				System.out.println("Command ID: \t\t" + commandModel.getCommandId());
				System.out.println("Command: \t\t" + commandModel.getCommandName());
				System.out.println("Primary Command ID: \t" + commandModel.getPrimaryCommandId());
				System.out.println("Primary Command: \t" + commandModel.getPrimaryCommandName());
				System.out.println("Date Added: \t\t" + commandModel.getDateAdded());
				System.out.println("Date Last Updated: \t" + commandModel.getDateLastUpdated());
				System.out.println("Active: \t\t" + (commandModel.isActive() ? "Yes" : "No"));
		}
		else {
			System.out.println("TestDatabase::getCommand(): Command Ask not found or MySQL Server is not connected.");
		}
	}
	
	// Read
	private void getPrimaryCommands() {
		
		List<CommandModel> commandList = controller.getPrimaryCommands();
		
		System.out.println("\n" + "Select All Primary Commands test...");

		if (commandList.size() > 0) {
		
			for (CommandModel model : commandList) {
				System.out.println("\nCommand ID: \t\t" + model.getCommandId());
				System.out.println("Command: \t\t" + model.getCommandName());			
				System.out.println("Date Added: \t\t" + model.getDateAdded());
				System.out.println("Date Last Updated: \t" + model.getDateLastUpdated());
				System.out.println("Active: \t\t" + (model.isActive() ? "Yes" : "No"));
			}
		}
		else {
			System.out.println("\nTestDatabase::getPrimaryCommands(): the Commands table is empty or MySQL Server is not connected.");
		}
	}

	// Read
	private void getCommandsInOrder() {

		List<CommandModel> commandList = controller.getCommandsInOrder();
		
		System.out.println("Select All Commands In Order test...");
		
		if (commandList.size() > 0) {
			
			for (CommandModel model : commandList) {
				System.out.println("\nCommand ID: \t\t" + model.getCommandId());
				System.out.println("Command: \t\t" + model.getCommandName());			
				System.out.println("Date Added: \t\t" + model.getDateAdded());
				System.out.println("Date Last Updated: \t" + model.getDateLastUpdated());
				System.out.println("Active: \t\t" + (model.isActive() ? "Yes" : "No"));
			}
		}
		else {
			System.out.println("\nTestDatabase::getCommandsInOrder(): the Commands table is empty or MySQL Server is not connected.");
		}
		
		controller.getCommandsInOrder();
	}
	
	/*
	 * main Method
	 * 
	 */
	
	public static void main(String[] args) {
		
		TestDatabase testDatabase = new TestDatabase();
		testDatabase.menu();
	}
}
