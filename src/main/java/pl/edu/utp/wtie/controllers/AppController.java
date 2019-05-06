package pl.edu.utp.wtie.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import pl.edu.utp.wtie.RegexpValidator;
import pl.edu.utp.wtie.VInputText;
import pl.edu.utp.wtie.Validator;

public class AppController {
	
	@FXML
	private VBox vBox;
	
	@FXML
	void initialize() {
		
		VInputText input = new VInputText(5);
		Validator v = new RegexpValidator();
		
		input.registerValidator(v);
		
		Button confirmButton = new Button("Confirm");
		confirmButton.disableProperty().bind(input.getConfirmButtonProperty());
		
		vBox.getChildren().addAll(input, confirmButton);
		
	}
}
