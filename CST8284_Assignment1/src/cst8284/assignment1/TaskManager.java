package cst8284.assignment1;

import java.time.LocalDate;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
	private static int currentToDoNumber;
	private Stage primarystage;

	public ToDo[] getToDoArray() {
		return toDoArray;
	}

	public void setToDoArray(ToDo[] toDoArray) {
		this.toDoArray = toDoArray;
	}

	public static int getCurrentToDoNumber() {
		return currentToDoNumber;
	}

	public static void setToDoNumber(int currentToDoNumber) {
		TaskManager.currentToDoNumber = currentToDoNumber;
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
		
		scene.setOnMousePressed(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				
				FileUtils futil = new FileUtils();
				
				setToDoArray(futil.getToDoArray(futil.getAbsPath()));
				Scene scene2 = getToDoScene(getToDoArray()[currentToDoNumber]);

				primarystage.setScene(scene2);
			}
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
	    
	    
//		ButtonClickHandler hdlrBtnClick = new ButtonClickHandler(seq);
//		btn.setOnAction(hdlrBtnClick);
	
	    btn.setOnAction(new EventHandler<ActionEvent>() {
        @Override 
        public void handle(ActionEvent e) {
        	currentToDoNumber = seq;
        	System.out.println(getToDoArray()[seq].isEmptySet());
        	
        	int i = seq;
        	while (getToDoArray()[i].isEmptySet()) {
        		i = (seq+1)%4;
        	}
        	
//			Scene scene = getToDoScene(getToDoArray()[seq]);
			Scene scene = getToDoScene(getToDoArray()[i]);
			primarystage.setScene(scene);

        }
    });		    
	    
	    
	    
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
//		TextField txtField2 = new TextField();
//		txtField2.setMaxWidth(700);
		
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


	class ButtonClickHandler implements EventHandler<ActionEvent> {
		
		public ButtonClickHandler(int i) {
			// TODO Auto-generated constructor stub
			System.out.println("sss===>"+i);
			currentToDoNumber = i;
		}
		
		@Override
		public void handle(ActionEvent e) {
			System.out.println("aaaaaaaa==>"+currentToDoNumber);
			System.out.println("aaaaaaaa==>"+getCurrentToDoNumber());
//			Scene scene = getToDoScene(getToDoArray()[seq]);
//			primarystage.setScene(scene);
						
		}
	}

	
}
