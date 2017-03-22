package cst8284.assignment1;

import java.time.LocalDate;
import java.util.Optional;

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
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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

// Your import libraries go here

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
		
		scene.setOnMousePressed((e)->{
			FileUtils futil = new FileUtils();
			
			setToDoArray(futil.getToDoArray(futil.getAbsPath()));
			Scene scene2 = getToDoScene(getToDoArray()[getCurrentToDoElement()]);

			primarystage.setScene(scene2);
			
		});
		
//		scene.setOnMousePressed(new EventHandler<MouseEvent>() {
//			
//			@Override
//			public void handle(MouseEvent event) {
//				
//				FileUtils futil = new FileUtils();
//				
////				setToDoArray(futil.getToDoArray(futil.getAbsPath()));
//				setToDoArray(futil.getToDoArray(""));
//				Scene scene2 = getToDoScene(getToDoArray()[getCurrentToDoElement()]);
//
//				primarystage.setScene(scene2);
//			}
//		});
//
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
		
//        pane.getStylesheets().
//        add(getClass().getResource("application.css").toExternalForm());

        Scene scene = new Scene(pane,1000,600);

		
		return scene;
	}

	
	public HBox getTop(){
		HBox hBox = new HBox();

		return hBox;
	}

	public Button getImgButton(String fileName,int seq){

	    Image img=new Image(getClass().getResourceAsStream(fileName));
	    
	    ImageView iv=new ImageView(img);
	    iv.setFitHeight(30);
	    iv.setFitWidth(30);
	    

	    Button btn=new Button("",iv);

   	    if (((getCurrentToDoElement() < 1) && ((seq == 0) || (seq == 1))) ||((getCurrentToDoElement() == getToDoArray().length -1) && ((seq == 2) || (seq == 3)))) {
	    	btn.setDisable(true);
	    }
		
		ButtonClickHandler hdlrBtnClick = new ButtonClickHandler(seq);
		btn.setOnAction(hdlrBtnClick);
	
	    return btn;
		
	}
	
	
	public HBox getBottom(){
		HBox hBox = new HBox();

		hBox.getChildren().addAll(getImgButton("file/4.jpg",0), getImgButton("file/2.jpg",1),getImgButton("file/1.jpg",2),getImgButton("file/3.jpg",3));
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
//	    fbtn.setSelected(true);
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
	    
	    rB.getChildren().add(fbtn);
	    rB.getChildren().add(sbtn);
	    rB.getChildren().add(tbtn);
	    return rB;
	}
	
	public VBox getCalandar(){
	    VBox vbox = new VBox(20);
	    DatePicker datePicker = new DatePicker();
	    datePicker.setValue(LocalDate.now());
	    vbox.getChildren().add(datePicker);
	    
	    return vbox;
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
		
		gpane.add(new TextField(td.getTitle()), 1, 0);
		gpane.add(new TextArea(td.getSubject()), 1, 1);
//		gpane.add(getCalandar(), 1, 2);
		gpane.add(new TextField(td.getDueDate().toString()), 1, 2);
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
	
	class ButtonClickHandler implements EventHandler<ActionEvent> {
		private int seq;
		public ButtonClickHandler(int i) {
			seq = i;
		}
		
		@Override
		public void handle(ActionEvent e) {

			switch(seq) {
        	case 0:
        		setToDoElement(seq);
        		break;
        	case 1:
        		if (getCurrentToDoElement() > 0)
            		setToDoElement(getCurrentToDoElement()-1);
        		break;
        	case 2:
        		if (getCurrentToDoElement() < getToDoArray().length -1)
        			setToDoElement(getCurrentToDoElement()+1);
        		break;
        	case 3:
        		setToDoElement(getToDoArray().length -1);
        		break;
        	}
        	
        	int i = getToDoArray().length -1;

        	if (getToDoArray()[getCurrentToDoElement()].isEmptySet()) {
        		while (getToDoArray()[i].isEmptySet()){
        			i--;        			
        		}
        		
        		setToDoElement(i);
        	}
        	
			Scene scene = getToDoScene(getToDoArray()[getCurrentToDoElement()]);
			primarystage.setScene(scene);

		}
	}

	
}
