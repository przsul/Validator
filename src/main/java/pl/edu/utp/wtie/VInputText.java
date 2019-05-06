package pl.edu.utp.wtie;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class VInputText extends HBox {
	
	private FontAwesomeIconView icon;
	private TextInputControl textField;
	private Label label;
	private Tooltip tooltip;
	private Validator v;
	private BooleanProperty confirmButtonProperty = new SimpleBooleanProperty(true);
	
	public VInputText(double spacing) {
		
		this.setSpacing(spacing);
		this.setAlignment(Pos.CENTER_LEFT);
		this.setPrefSize(Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE);
		
		icon = new FontAwesomeIconView();
		icon.setSize("1.8em");
		icon.setGlyphName("TIMES_CIRCLE");
		icon.setVisible(false);
		
		tooltip = new Tooltip();
		
		textField = new TextField();
		
		textField.textProperty().addListener((observable, oldValue, newValue) -> {
			this.v.validate(textField.getText());
			
			icon.setVisible(true);
			
			if(v.isValid()) {
				icon.setGlyphName("CHECK_CIRCLE");
				icon.setGlyphStyle("-fx-fill:green");
				setConfirmButtonProperty(false);
			} else {
				icon.setGlyphName("TIMES_CIRCLE");
				icon.setGlyphStyle("-fx-fill:red");
				setConfirmButtonProperty(true);
			}
			
			if(newValue.equals(""))
				icon.setVisible(false);
				
		});
		
		HBox.setHgrow(textField, Priority.ALWAYS);
		
		label = new Label("<- my validated field");
		
		this.getChildren().addAll(icon, textField, label);
	}
	
	public void registerValidator(Validator v) {
		this.v = v;
		tooltip.setText(v.getMessage());
		textField.setTooltip(tooltip);
	}

	public BooleanProperty getConfirmButtonProperty() {
		return confirmButtonProperty;
	}

	public void setConfirmButtonProperty(boolean confirmButton) {
		this.confirmButtonProperty.set(confirmButton);;
	}
}
