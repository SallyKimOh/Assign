package cst8284.speedTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WordDump extends Application implements Serializable {

	private static final long serialVersionUID = 1L;
	//	private String wordFileName="D:\\LongWordList-UTF-7.txt";
	private static String wordFileName="LongWordList-UTF-7.txt";
	@SuppressWarnings("unused")
	private static final Stage primaryStage = null;
	
	
	public String getFileName() {
		return wordFileName;
	}



	public void setFileName(String f) {
		WordDump.wordFileName = f;
	}


	@SuppressWarnings("resource")
	public static String getStringFromFile() {
		String strList = "";
		
		try {
			File f = new File(wordFileName);
			
			Scanner data = new Scanner(f);
			
			if (f.exists()) {
			while(data.hasNext()) {
				if (strList!="")	{
					strList = strList +  "\n  " + data.next();
				} else {
					strList = "  "+data.next();
				}
					
			}
		}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return strList;
	}

	@SuppressWarnings("resource")
	public static StringBuilder getStringBuilderFromFile() {
		StringBuilder strList = new StringBuilder();
		
		try {
			File f = new File(wordFileName);
			Scanner data = new Scanner(f);
			
			if (f.exists()) {
			while(data.hasNext()) {
				strList.append(data.next());
			}
		}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return strList;
	}
	@SuppressWarnings("resource")
	public static ArrayList<String> getArrayListFromFile() {
		ArrayList<String> strList = new ArrayList<String>();
		
		try {
			File f = new File(wordFileName);
			Scanner data = new Scanner(f);
			
			if (f.exists()) {
			while(data.hasNext()) {
					strList.add(data.next());
			}
		}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return strList;
	}
	
	@Override
	public void start(Stage primaryStage) {

		setFileName(wordFileName);
		
		ListView<String> list = new ListView<String>();
		ObservableList<String> objItem = FXCollections.observableList(getArrayListFromFile());

		list.setItems(objItem);
		
//		Text text = new Text(getStringFromFile());
//		Text text = new Text(getStringBuilderFromFile());
		Text text = new Text();

		BorderPane pane = new BorderPane();

		
    	ScrollPane sp = new ScrollPane();
		
		
    	VBox vbox = new VBox();
    	
    	Button seqBtn = new Button("Alphabetical Order");
    	Button descBtn = new Button("Reverse Order");
    	
    	vbox.getChildren().addAll(seqBtn, descBtn);
 
		seqBtn.setOnMouseClicked(e -> 
		 FXCollections.sort((ObservableList<String>) objItem)
		);
		

		descBtn.setOnMouseClicked(e -> 
		 FXCollections.reverse((ObservableList<String>) objItem)
		);
		
		
    	sp.setContent(text);
		sp.setPrefSize(200, 480);
		sp.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		sp.setHbarPolicy(ScrollBarPolicy.NEVER);
//        pane.setLeft(sp);
    	pane.setLeft(list);	

        pane.setRight(vbox);
        
        Scene scene = new Scene(pane, 640, 480);
        
        primaryStage.setTitle("Welcome to WordDump");
        primaryStage.setScene(scene);
        primaryStage.show();
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		launch(args);
	}

}
