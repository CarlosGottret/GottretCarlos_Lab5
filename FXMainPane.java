import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {
	private Button English, Country, Chinese, Spanish, Clear, Exit;
	private Label Feedback;
	private TextField TextField;
	HBox topBox = new HBox();
	HBox bottomBox = new HBox();
	private DataManager dataManager;
	//student Task #2:
	//  declare five buttons, a label, and a textfield
	//  declare two HBoxes
	
	//student Task #4:
	//  declare an instance of DataManager
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		//  instantiate the HBoxes
		English =new Button("Hello");
		Country=new Button("Howdy");
		Chinese=new Button("Ni Hao");
		Spanish = new Button("Hola");
		Clear=new Button("Clear");
		Exit=new Button("Exit");
		Feedback=new Label("Feedback");
		TextField=new TextField();
		topBox=new HBox();
		bottomBox=new HBox();
		topBox.getChildren().addAll(English,Country,Chinese,Spanish,Clear,Exit);
		bottomBox.getChildren().addAll(Feedback,TextField);
		this.getChildren().addAll(topBox,bottomBox);
		//student Task #4:
		//  instantiate the DataManager instance
		//  set margins and set alignment of the components
		dataManager=new DataManager();
		Insets inset= new Insets(10);
		HBox.setMargin(Spanish,inset);
		HBox.setMargin(English, inset);
		HBox.setMargin(Country, inset);
		HBox.setMargin(Chinese, inset);
		HBox.setMargin(Clear, inset);
		HBox.setMargin(Exit, inset);
		HBox.setMargin(Feedback, inset);
		HBox.setMargin(TextField, inset);
		//student Task #3:
		English.setOnAction(new ButtonHandler());
		Country.setOnAction(new ButtonHandler());
		Chinese.setOnAction(new ButtonHandler());
		Spanish.setOnAction(new ButtonHandler());
		Clear.setOnAction(new ButtonHandler());
		Exit.setOnAction(new ButtonHandler());
		//  add the label and textfield to one of the HBoxes
		//  add the buttons to the other HBox
		//  add the HBoxes to this FXMainPanel (a VBox)
		
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	class ButtonHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			if (event.getTarget().equals(Country)) 
				TextField.setText(dataManager.getHowdy());
			if (event.getTarget().equals(English))
				TextField.setText(dataManager.getHello());
			if (event.getTarget().equals(Chinese))
				TextField.setText(dataManager.getChinese());
			if (event.getTarget().equals(Spanish))
				TextField.setText(dataManager.getSpanish());
			if (event.getTarget().equals(Clear))
				TextField.setText("");
			if (event.getTarget().equals(Exit)){
				Platform.exit(); 
				System.exit(0); 
			}
			
		}
		
	}
}