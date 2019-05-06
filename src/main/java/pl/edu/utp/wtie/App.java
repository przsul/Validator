package pl.edu.utp.wtie;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pl.edu.utp.wtie.controllers.AppController;

public class App extends Application {

	private FXMLLoader loader;
	private AnchorPane anchorPane;
	private Scene scene;
	public static Stage primaryStage;
	public static AppController controller;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		loader = new FXMLLoader(getClass().getResource("/fxml/AppScene.fxml"));
		anchorPane = loader.load();
		scene = new Scene(anchorPane);
		
		controller = (AppController)loader.getController();
		
		primaryStage.setScene(scene);
        
		primaryStage.setTitle("Validation");
		primaryStage.show();
			
		App.primaryStage = primaryStage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
