package cst8284.assignment1;

import java.text.Format;
import java.text.SimpleDateFormat;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * @author Sae il Kim
 * @course CST8284
 * @section 300
 * @Lab_professor Dave Houtman
 * 
 * @Create_User
 * @Create_date 2017. 3. 22.
 */

public class TaskManager extends Application{
	
	private ToDo[] toDoArray;
	private static int currentToDoElement;
	private Stage primarystage;

	public ToDo[] getToDoArray() {
		return toDoArray;
	}

	public void setToDoArray(ToDo[] toDoArray) {
		this.toDoArray = toDoArray;
	}

	public static int getCurrentToDoElement() {
		return currentToDoElement;
	}

	public static void setToDoElement(int currentToDoElement) {
		TaskManager.currentToDoElement = currentToDoElement;
	}

	public Stage getPrimaryStage() {
		return primarystage;
	}

	public void setPrimaryStage(Stage stage) {
		this.primarystage = stage;
	}

	

	public Scene getDefaultScene(String defaultText) {
		
		Text txt = new Text(defaultText);
		
		//============== css==========================//
		
        txt.setFill(Paint.valueOf("#2A5058"));
        txt.setFont(Font.font("Verdana", FontWeight.BOLD, 32));

        txt.setCache(true);
        DropShadow ds=new DropShadow();
        ds.setOffsetX(3.0);
        ds.setOffsetY(3.0);
        txt.setEffect(ds);

        //============== css==========================//

        
        
        
		StackPane pane = new StackPane();
		pane.getChildren().add(txt);
		pane.setAlignment(Pos.CENTER);

		Scene scene = new Scene(pane,1000,600);
		
		scene.setOnMouseClicked((e)->{
			FileUtils futil = new FileUtils();
			
			setToDoArray(futil.getToDoArray(futil.getAbsPath()));
//			setToDoArray(futil.getToDoArray("src/cst8284/assignment1/file/ToDoList.todo"));
			newScene1(getCurrentToDoElement());
//			primarystage.setScene(getToDoScene(getToDoArray()[getCurrentToDoElement()]));
			
		});
		
        scene.getStylesheets().
        add(getClass().getResource("application.css").toExternalForm());
		
		return scene;
	}

	public Scene getToDoScene(ToDo td) {
		
		Pane pane = new Pane();
		pane = getToDoPane(td);

		String image = getClass().getResource("file/background3.jpg").toExternalForm();
		pane.setStyle("-fx-background-image: url('" + image + "'); " +
		           "-fx-background-position: center center; " +
		           "-fx-background-repeat: stretch;");		
		

        Scene scene = new Scene(pane,1000,600);
		return scene;
	}

	
	public HBox getTop(){
		HBox hBox = new HBox();

		return hBox;
	}


	public HBox getBottom(){
		HBox hBox = new HBox(35);
		Button btn1 = new Button("\u23EE");
		Button btn2 = new Button("\u23EA");
		Button btn3 = new Button("\u23E9");
		Button btn4 = new Button("\u23ED");

		
   	   	int i = getToDoArray().length -1;
   		while ((getToDoArray()[i].isEmptySet())&&(i>=0)){
   			i--;        			
   		}

   		int j = 0;
   		while ((getToDoArray()[j].isEmptySet())&&(j <= i)){
   			j++;        			
   		}
   		
   	    if ((getCurrentToDoElement() == 0) ||(getCurrentToDoElement() <= j ) ) {
   	    	btn1.setDisable(true);
   	    	btn2.setDisable(true);
  	    	
   	    } 
   	    if ((getCurrentToDoElement() == getToDoArray().length -1) ||(getCurrentToDoElement() >= i )){
   	    	btn3.setDisable(true);
   	    	btn4.setDisable(true);
   	    }
   	    
   		
   		//==================================================//
   	    
		btn1.setOnAction(e->newScene1(0));
		if(getCurrentToDoElement() > 0)	//remove out of range of array
			btn2.setOnAction(e-> newScene1(getCurrentToDoElement()-1));
		if (getCurrentToDoElement() < getToDoArray().length -1)
			btn3.setOnAction(e-> newScene(getCurrentToDoElement()+1));
		btn4.setOnAction(e-> newScene(getToDoArray().length-1));

		hBox.getChildren().addAll(btn1,btn2,btn3,btn4);
		hBox.setAlignment(Pos.TOP_CENTER);
		hBox.setMinHeight(100);

		return hBox;
	}
	
	public VBox getLeft(){
		VBox vBox = new VBox();
		vBox.setMinWidth(120);

		return vBox;
	}

	public VBox getRight(){
		VBox vBox = new VBox();
		vBox.setMinWidth(120);

		return vBox;
	}

	public HBox getRadio(int priority){
		HBox rB = new HBox();
		rB.setMaxWidth(700);

		ToggleGroup group = new ToggleGroup();
	    RadioButton fbtn = new RadioButton("1           ");
	    fbtn.setToggleGroup(group);
	    RadioButton sbtn = new RadioButton("2           ");
	    sbtn.setToggleGroup(group);
	    RadioButton tbtn = new RadioButton("3           ");
	    tbtn.setToggleGroup(group);

	    switch (priority) {
	    case 1:
		    fbtn.setSelected(true);
	    	break;
	    case 2:
	    	sbtn.setSelected(true);
	    	break;
	    case 3:
	    	tbtn.setSelected(true);
	    	break;
	    }
	    
	    rB.getChildren().addAll(fbtn,sbtn,tbtn);
	    return rB;
	}
	
	public Label getLabel(String title) {
	 	Label lb = new Label(title);
	 	
	 	lb.getStylesheets().
	 	add(getClass().getResource("application.css").toExternalForm());
	 	
	 	return lb;
	}
	
	
	public GridPane getCenter(ToDo td){
		
		GridPane gpane = new GridPane();

		gpane.setPadding(new Insets(40,40,40,10));
		gpane.setVgap(10);
		gpane.setHgap(30);

		gpane.add(getLabel("Task"), 0, 0);
		gpane.add(getLabel("Subject"), 0, 1);
		gpane.add(getLabel("Due Date"), 0, 2);
		gpane.add(getLabel("Priority"), 0, 3);
		
		Format format = new SimpleDateFormat("E MMM dd");
		
		gpane.add(new TextField(td.getTitle()), 1, 0);
		gpane.add(new TextArea(td.getSubject()), 1, 1);
//		gpane.add(new TextField(td.getDueDate().toString()), 1, 2);
		gpane.add(new TextField(format.format(td.getDueDate())), 1, 2);
		gpane.add(getRadio(td.getPriority()), 1, 3);
		gpane.setAlignment(Pos.CENTER);
		
		return gpane;
	}
	
	public Pane getToDoPane(ToDo td) {
		//============================ bottom ==end =================================//			
		
		BorderPane rootNode = new BorderPane();
		
		rootNode.setLeft(getLeft());
		rootNode.setRight(getRight());

		rootNode.setTop(getTop());
//		rootNode.setCenter(pane);
		rootNode.setCenter(getCenter(td));
		rootNode.setBottom(getBottom());
		rootNode.setVisible(true);

		
		return rootNode;
	}
	
	/**
	 * if data is not exist, skip that and go next exist data
	 * @param curr 
	 */
	private void newScene(int curr) {
		setToDoElement(curr);
    	int i = getToDoArray().length -1;

    	if (getToDoArray()[getCurrentToDoElement()].isEmptySet()) {
    		while (getToDoArray()[i].isEmptySet()){
    			i--;        			
    		}
    		
    		setToDoElement(i);
    	}
		primarystage.setScene(getToDoScene(getToDoArray()[getCurrentToDoElement()]));
    	
    	
	}

	private void newScene1(int curr) {
		setToDoElement(curr);
    	int i = getCurrentToDoElement() == 0 ? 0 : getCurrentToDoElement()-1;

    	if (getToDoArray()[getCurrentToDoElement()].isEmptySet()) {
    		while (getToDoArray()[i].isEmptySet()){
    			if (getCurrentToDoElement() == 0) {
    				i++;
    			} else {
    				i--;
    			}
    		}
    		
    		setToDoElement(i);
    	}
		primarystage.setScene(getToDoScene(getToDoArray()[getCurrentToDoElement()]));
    	
    	
	}
	
	
	@Override
	public void start(Stage primaryStage) {
		// TODO: you code to load the default scene into the primary stage goes here

		setPrimaryStage(primaryStage);
	       
		primaryStage.setTitle("To Do List");
		
		primaryStage.setScene(getDefaultScene("Click here to open"));
		primaryStage.show();
	}
	
   	// TODO: Your javafx code, executed following start(), goes here
	
	public static void main(String[] args) {
		Application.launch(args);
	}

    @Override
    public void stop()
    {
    	System.out.println("Bye-Bye");
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Bye-Bye");
    	alert.setHeaderText(null);
    	alert.setContentText("Bye-Bye!! Have a nice day!");

    	alert.showAndWait();
    	Platform.exit();
    }
	
}
