package cst8284.assignment1;
	
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Scanner;

import javafx.application.Application;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			HBox vbTop = new HBox();
			HBox vbBottom = new HBox();
			
			VBox vbLeft = new VBox();
			vbLeft.setMinWidth(120);
			
			VBox vbRight = new VBox();
			vbRight.setMinWidth(120);
			
//========================== center start ==========================//			
			
			Label lb1 = new Label("Task");
			Label lb2 = new Label("Subject");
			Label lb3 = new Label("Due Date");
			Label lb4 = new Label("Priority");
			
			TextField txtField1 = new TextField();
			txtField1.setMaxWidth(700);
			TextArea txtArea = new TextArea();
			txtArea.setMaxSize(700, 500);
			
			
			
//			TextField txtField2 = new TextField();
//			txtField2.setMaxWidth(700);
			
		    VBox vbox = new VBox(20);
		    DatePicker datePicker = new DatePicker();
		    datePicker.setValue(LocalDate.now());
		    vbox.getChildren().add(datePicker);

		    
			HBox rB = new HBox();
			rB.setMaxWidth(700);

			ToggleGroup group = new ToggleGroup();
		    RadioButton button1 = new RadioButton("1           ");
		    button1.setToggleGroup(group);
		    button1.setSelected(true);
		    RadioButton button2 = new RadioButton("2           ");
		    button2.setToggleGroup(group);
		    RadioButton button3 = new RadioButton("3           ");
		    button3.setToggleGroup(group);
		    
		    rB.getChildren().add(button1);
		    rB.getChildren().add(button2);
		    rB.getChildren().add(button3);
			
			GridPane gpane = new GridPane();

			gpane.setPadding(new Insets(50,100,50,10));
			gpane.setVgap(10);
			gpane.setHgap(20);

			gpane.add(lb1, 0, 0);
			gpane.add(lb2, 0, 1);
			gpane.add(lb3, 0, 2);
			gpane.add(lb4, 0, 3);
			
			gpane.add(txtField1, 1, 0);
			gpane.add(txtArea, 1, 1);
			gpane.add(vbox, 1, 2);
			gpane.add(rB, 1, 3);
			gpane.setAlignment(Pos.CENTER);
			
			
			Text text = new Text("Programming Test");
			
			StackPane pane= new StackPane();
			pane.getChildren().add(text);
			//========================== center end ==========================//			

//============================ bottom ==start =================================//			
			Button btnLeft = new Button("Left");
			Button btnRight = new Button("Right");

		    Image playI=new Image(getClass().getResourceAsStream("file/1.jpg"));
		    
		    ImageView iv1=new ImageView(playI);
		    iv1.setFitHeight(30);
		    iv1.setFitWidth(30);

		    Button playB=new Button("",iv1);	

		    Image playJ=new Image(getClass().getResourceAsStream("file/2.jpg"));
		    
		    ImageView iv2=new ImageView(playJ);
		    iv2.setFitHeight(67);
		    iv2.setFitWidth(69);

		    Button playC=new Button("",iv2);	
		    
		    
//			Button button = new Button();
//	
//			System.out.println(getClass());
//		    Image image = new Image(getClass().getResourceAsStream("1.jpg"));
//		    button.setOnAction(new EventHandler<ActionEvent>() {
//		        @Override public void handle(ActionEvent e) {
//		            Button button = (Button) e.getSource();
//		            button.setGraphic(new ImageView(image));
//		        }
//		    });		    
//		    
//		    
//			File f = new File("./src/cst8284/assignment1/file/1.jpg");
//			System.out.println(f.getAbsolutePath());
//			
//			if (f.exists()) {
//				System.out.println("yes");
//			} else {
//				System.out.println('b');
//			}
		    
		    
			HBox buttomPane = new HBox(50);
			buttomPane.getChildren().addAll(btnLeft, btnRight,playB,playC);
			buttomPane.setAlignment(Pos.CENTER);
			buttomPane.setMinHeight(100);

			//============================ bottom ==end =================================//			
			
			BorderPane rootNode = new BorderPane();
			
			rootNode.setLeft(vbLeft);
			rootNode.setRight(vbRight);

			rootNode.setTop(vbTop);
//			rootNode.setCenter(pane);
			rootNode.setCenter(gpane);
			rootNode.setBottom(buttomPane);
			rootNode.setVisible(true);
			
			
			Scene scene = new Scene(rootNode,1420,702);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("To Do List");
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
			ToDo toDos[] = new ToDo[4];

			int data = 0;
			
			File f = new File("ToDoList2.todo");
			
			ToDo td;
			
			try {
				FileInputStream fin = new FileInputStream(f);
				ObjectInputStream ojs = new ObjectInputStream(fin);
				
				for (int empCtr = 0; empCtr <2; empCtr ++) {
					td = (ToDo)(ojs.readObject());
					
					System.out.println("Employee Name: "+td.getSubject());
//					System.out.println("Employee Name: "+empInfo.getFullName());
//					System.out.println("Employee Address: "+ empInfo.getAddress());
								
					
				}
				
			} catch (IOException ex) {
				System.out.println("Array of employees has been transfered from file");
				
//			} catch (FileNotFoundException ex) {
//				
			} catch (ClassNotFoundException ex) {
				System.out.print("File not found");
			}
			

			try {
				FileOutputStream fout = new FileOutputStream(f);
				ObjectOutputStream oos = new ObjectOutputStream(fout);
				td = new ToDo();
//				td.setTitle("");
//				td.setDueDate(null);
//				td.setPriority(0);
				
					oos.writeObject(td);
				
			}
			catch (FileNotFoundException ex) {
				System.out.println("File not found: check the path for file " + f);
				
			} catch (IOException ex) {
				ex.printStackTrace();
			}

			
			
		
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
