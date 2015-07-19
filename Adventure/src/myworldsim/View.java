package myworldsim;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
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
	public final String			PROMPT 	  			= ">";
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
		 * Create the Inner Pane (the content pane inside the Window Frame)
		 * and its boxes
		 * 
		 */
		
		VBox innerPane = new VBox();

		/*
		 * Create the game log area
		 * 
		 */
		
		gameLogTextArea = new TextArea();
		gameLogTextArea.setId("gamelog-textarea");
		gameLogTextArea.setEditable(false);
		gameLogTextArea.setPrefSize(600, 400);
		gameLogTextArea.setText(GREETINGS);

		innerPane.getChildren().add(gameLogTextArea);
		
		/*
		 * Create the command area
		 * 
		 */
		
		commandTextArea = new TextArea();
		commandTextArea.setId("command-textarea");
		commandTextArea.setPrefSize(600, 50);
		commandTextArea.setFocusTraversable(false);
		commandTextArea.setPromptText(PROMPT);
		commandTextArea.setOnKeyReleased(new TextAreaKeyReleasedEventHandler());
		
		innerPane.getChildren().add(commandTextArea);

		/*
		 *  Create the Scene and setup the Primary Stage
		 *  
		 */
		
		Scene scene = new Scene(innerPane);
		scene.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());

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
				if (commandTextArea.getText().length() > 1) {

					// Extract the command and the command parameters
					CommandModel commandModel = new CommandModel();
					String[] commandWords = commandTextArea.getText().trim().toLowerCase().split("\\s+");
					commandModel.setCommandName(commandWords[0]);

					if (commandWords.length > 1) {
						String[] commandParameters = new String[commandWords.length - 1];
						
						for (int index = 0; index < commandParameters.length; index++) {
							commandParameters[index] = commandWords[index + 1];
						}
						
						commandModel.setCommandParameters(commandParameters);
					}
										
					setGameLogLabel(PROMPT + commandModel.getCommandName());
					setGameLogLabel(controller.executeCommand(commandModel));
					
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
					commandTextArea.setText("");
					commandTextArea.positionCaret(commandTextArea.getText().length());
					
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
