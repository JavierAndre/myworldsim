package myworldsim;

import java.util.Random;

import com.sun.glass.ui.Cursor;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class View
{
	/*
	 * Class Instance Variables
	 * 
	 */
	
	private Controller 		controller;
	private TextArea		commandTextArea;
	private TextArea		gameLogTextArea;

	/*
	 * Class Variables
	 * 
	 */
	
	public String			GREETINGS = "Welcome to My World Sim!." + "\n" + "Enter your commands below." + "\n";
	public String			PROMPT 	  = "> ";
	
	/*
	 * Constructors
	 * 
	 */
	
	public View(Stage primaryStage, Controller controller) {
		this.controller = controller;
		
		/*
		 * Create the Outer Pane (the content pane inside the Window Frame)
		 * and its boxes
		 * 
		 */
		
		VBox outerPane = new VBox();
		HBox innerPane = new HBox();
		// Set spacing between child elements
		innerPane.setSpacing(5);
		
		outerPane.getChildren().add(innerPane);
				
		/*
		 * Create the command area
		 * 
		 */
		
		commandTextArea = new TextArea();
		commandTextArea.setMinSize(600, 1000);
		commandTextArea.setMaxSize(600, 1000);
		commandTextArea.setFont(Font.font("Buxton Sketch", FontWeight.MEDIUM, 24));
		commandTextArea.setStyle("-fx-border-color:blue");
		commandTextArea.setText(GREETINGS + PROMPT);
		commandTextArea.positionCaret(commandTextArea.getText().length());
		commandTextArea.setOnKeyReleased(new TextAreaEventHandler());

		innerPane.getChildren().add(commandTextArea);
		
		/*
		 * Create the game log area
		 * 
		 */
		
		gameLogTextArea = new TextArea();
		gameLogTextArea.setEditable(false);
		gameLogTextArea.setMinSize(600, 1000);
		gameLogTextArea.setMaxSize(600, 1000);
		gameLogTextArea.setFont(Font.font("Buxton Sketch", FontWeight.MEDIUM, 24));
		gameLogTextArea.setStyle("-fx-border-color:blue");

		innerPane.getChildren().add(gameLogTextArea);

		/*
		 *  Create the Scene and setup the Primary Stage
		 *  
		 */
		
		Scene scene = new Scene(outerPane);
		
		// Setup the primary stage (the Window frame)
		primaryStage.setScene(scene);
		primaryStage.setTitle("Our World Sim Version 0.1");
		primaryStage.setMaximized(true);
		
		// Display the primary stage	
		primaryStage.show();
	}

	public void setCommandTextArea(String message) {
		this.commandTextArea.setText(commandTextArea.getText() + PROMPT + message + "\n" + PROMPT);
		this.commandTextArea.positionCaret(commandTextArea.getText().length());
	}
	
	public void setGameLogLabel(String message) {
		this.gameLogTextArea.setText(gameLogTextArea.getText() + message + "\n");
	}
	
	private class TextAreaEventHandler implements EventHandler<KeyEvent> {
    
		public void handle(KeyEvent keyEvent) {
		
			if (keyEvent.getCode() == KeyCode.ENTER)  {
				
				// Check if the player entered a command (> GO WESTcr)
				String text = commandTextArea.getText();
				int promptIndex = text.lastIndexOf(PROMPT, text.length() - 1);
				int startIndex = promptIndex + 1;
				String command = text.substring(startIndex, text.length() - 1).trim();
				
				// TEST
				String message 	= "";
				Random random 	= new Random();
				int number 		= random.nextInt(5) + 1;
				
				switch (number) {
					case 1: {
						message = "Why do you say that?!";
						break;
					}
					case 2: {
						message = "That's very interesting";
						break;
					}
					case 3: {
						message = "I don't know how to do that";
						break;
					}
					case 4: {
						message = "Sure, I'll get on it right away";
						break;
					}
					case 5: {
						message = "Really?!";
						break;
					}
					default: {
						message = "What?";
						break;
					}
				}
				
				setCommandTextArea(message);
				setGameLogLabel("Command: " + command);
	        }
		}
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
