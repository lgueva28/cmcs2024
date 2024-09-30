


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
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

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	Label feedbackLabel;
	Button helloBtn;
	Button howdyBtn;
	Button chineseBtn;
	Button clearBtn;
	Button exitBtn;
	TextField myTextField;
	//  declare two HBoxes
	HBox hbox1;
	HBox hbox2;
	//student Task #4:
	//  declare an instance of DataManager
	DataManager dataManager;
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		feedbackLabel = new Label("Feedback:");
		helloBtn = new  Button("Hello");
		howdyBtn  = new  Button("Howdy");
		chineseBtn = new  Button("Chinese");
		clearBtn = new  Button("Clear");
		exitBtn = new  Button("Exit");
		myTextField = new TextField();
		//  instantiate the HBoxes
		hbox1 = new HBox();
		hbox2 = new HBox();
		
		helloBtn.setOnAction(new ButtonHandler());
		howdyBtn.setOnAction(new ButtonHandler());
		chineseBtn.setOnAction(new ButtonHandler());
		clearBtn.setOnAction(new ButtonHandler());
		exitBtn.setOnAction(new ButtonHandler());
		
		//student Task #4:
		//  instantiate the DataManager instance
		dataManager = new DataManager();
		//  set margins and set alignment of the components
		HBox.setMargin(feedbackLabel, new Insets(5));
		HBox.setMargin(helloBtn, new Insets(5));
		HBox.setMargin(howdyBtn, new Insets(5));
		HBox.setMargin(chineseBtn, new Insets(5));
		HBox.setMargin(clearBtn, new Insets(5));
		HBox.setMargin(exitBtn, new Insets(5));
		HBox.setMargin(myTextField, new Insets(5));
		
		hbox1.setAlignment(Pos.CENTER);
		hbox2.setAlignment(Pos.CENTER);
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		hbox1.getChildren().addAll(feedbackLabel,  myTextField);
		//  add the buttons to the other HBox
		hbox2.getChildren().addAll(helloBtn, howdyBtn, chineseBtn, clearBtn, exitBtn);
		//  add the HBoxes to this FXMainPanel (a VBox)
		getChildren().addAll(hbox1, hbox2);
		
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	private class ButtonHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			EventTarget target = event.getTarget();
			Button clickedButton = (Button) event.getSource();
			
			if (clickedButton  == helloBtn) {
				myTextField.setText(dataManager.getHello());
				
			}else if(clickedButton == howdyBtn) {
				myTextField.setText(dataManager.getHowdy());
				
			}else if(clickedButton == chineseBtn) {
				myTextField.setText(dataManager.getChinese());
			}else if(clickedButton == clearBtn) {
				myTextField.setText("");
			}else{
				Platform.exit();
				System.exit(0);
			}
			
		}
		
	}
}
	
