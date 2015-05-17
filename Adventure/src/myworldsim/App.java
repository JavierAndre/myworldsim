package myworldsim;

import com.sun.javafx.css.StyleManager;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application
{
	public static void main(String[] args)
	{
		//Application.setUserAgentStylesheet(null);
		//StyleManager.getInstance().addUserAgentStylesheet("/css/styles.css");
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
	
		Controller controller = new Controller();
		View view = new View(primaryStage, controller);
	}
}
