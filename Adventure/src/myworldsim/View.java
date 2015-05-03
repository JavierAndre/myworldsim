package myworldsim;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
	private String			commandSaveArea;
	private TextArea		gameLogTextArea;

	/*
	 * Class Variables
	 * 
	 */
	
	public final String			GREETINGS 			= "Welcome to My World Sim!." + "\n" + "Enter your command at the > prompt on the command box." + "\n";
	public final String			PROMPT 	  			= "> ";
	public final int			PROMPT_CHAR_POS		= 0;
	public final int			PROMPT_SPACER_POS	= 1;
	public final String			PROMPT_PLUS_ENTER	= PROMPT + "\n";
	
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
		commandTextArea.setId("command-textarea");
		commandTextArea.setMinSize(200, 400);
		commandTextArea.setMaxSize(200, 400);
		commandTextArea.setFont(Font.font("Buxton Sketch", FontWeight.MEDIUM, 24));
		commandTextArea.setStyle("-fx-border-color:blue");
		commandTextArea.setPromptText(PROMPT);
		commandTextArea.setFocusTraversable(false);
		commandTextArea.setOnKeyReleased(new TextAreaKeyReleasedEventHandler());
		
		Platform.runLater(new Runnable() {
		     @Override
		     public void run() {
		    	 commandTextArea.requestFocus();
		     }
		});
		
		innerPane.getChildren().add(commandTextArea);
		
		/*
		 * Create the game log area
		 * 
		 */
		
		gameLogTextArea = new TextArea();
		gameLogTextArea.setId("gamelog-textarea");
		gameLogTextArea.setEditable(false);
		gameLogTextArea.setMinSize(600, 400);
		gameLogTextArea.setMaxSize(600, 400);
		gameLogTextArea.setFont(Font.font("Buxton Sketch", FontWeight.MEDIUM, 24));
		gameLogTextArea.setStyle("-fx-border-color:blue");
		gameLogTextArea.setText(GREETINGS);

		innerPane.getChildren().add(gameLogTextArea);

		/*
		 *  Create the Scene and setup the Primary Stage
		 *  
		 */
		
		Scene scene = new Scene(outerPane);
		String css = View.class.getResource("css/styles.css").toExternalForm();
        scene.getStylesheets().add(css);
		
		// Setup the primary stage (the Window frame)
		primaryStage.setScene(scene);
		primaryStage.setTitle("Our World Sim - Version " + Controller.VERSION);
		primaryStage.setResizable(false);
		
		// Display the primary stage	
		primaryStage.show();
	}

	public void setCommandTextArea(String message) {
		commandTextArea.setText(commandTextArea.getText().substring(0, commandTextArea.getText().length() - 1) + "\n" + message);
		commandTextArea.positionCaret(commandTextArea.getText().length());
	}
	
	public void setGameLogLabel(String message) {
		this.gameLogTextArea.setText(gameLogTextArea.getText() + message + "\n");
	}
	
	private class TextAreaKeyReleasedEventHandler implements EventHandler<KeyEvent> {
    
		public void handle(KeyEvent keyEvent) {
		
			if (keyEvent.getCode() == KeyCode.ENTER)  {
				
				// Check if the player entered a command
				if (!commandTextArea.getText().endsWith(PROMPT_PLUS_ENTER)) {

					// Extract the command
					String text = commandTextArea.getText();
					int promptIndex = text.lastIndexOf(PROMPT, text.length() - 1);
					int startIndex = promptIndex + 1;
					String command = text.substring(startIndex, text.length()).trim().toLowerCase();

					setGameLogLabel(PROMPT + command);
					
					if (command.length() > 0) {
						
						setGameLogLabel(controller.executeCommand(command));
					}
					
					commandSaveArea = commandTextArea.getText();
					commandTextArea.setText("");
					commandTextArea.positionCaret(commandTextArea.getText().length());
					gameLogTextArea.positionCaret(gameLogTextArea.getText().length());
					
					Platform.runLater(new Runnable() {
					     @Override
					     public void run() {
					    	 commandTextArea.requestFocus();
					     }
					});
				}
				else {
					// Remove the Enter character
					commandTextArea.setText(commandSaveArea);
					commandSaveArea = commandTextArea.getText();
					commandTextArea.positionCaret(commandTextArea.getText().length());
					gameLogTextArea.positionCaret(gameLogTextArea.getText().length());
					
					Platform.runLater(new Runnable() {
					     @Override
					     public void run() {
					    	 commandTextArea.requestFocus();
					     }
					});
				}
	        }
		}
    }
}
