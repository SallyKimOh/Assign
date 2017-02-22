package cst8284.fileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WordDump extends Application {

	private String fileName;
	private static int wordCtr;
	private FileInfo fileInfo;
	

	
	
	
	public String getFileName() {
		return fileName;
	}



	public void setFileName(String f) {
		this.fileName = f;
	}


	public static int getWordCtr() {
		return wordCtr;
	}



	public static void incrWordCtr(int wordCtr) {
		WordDump.wordCtr = ++wordCtr;
		
	}



	public static String getFileContents(File f) {
		String strList = "";
		
		try {
			Scanner data = new Scanner(f);
			
			while(data.hasNext()) {
				incrWordCtr(wordCtr);
				if (wordCtr!=1)	{
					strList = strList +  "\n  " + data.next();
				} else {
					strList = "  "+data.next();
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

//		File f = new File("bin/ShortWordList.txt");
		File f = new File("bin/LongWordList.txt");
//		System.out.println("path:"+f.getAbsolutePath());
		
		Text text = new Text(getFileContents(f));

		fileInfo = new FileInfo(f);
		
		BorderPane pane = new BorderPane();

    	ScrollPane sp = new ScrollPane();
		
		
		Label lb = new Label();
		lb.setAlignment(Pos.CENTER);
		lb.setText(fileInfo.getInfoString());
		
		Text text1 = new Text(fileInfo.getInfoString());
		
		sp.setContent(text);
		sp.setPrefSize(200, 480);
		sp.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		sp.setHbarPolicy(ScrollBarPolicy.NEVER);
        pane.setLeft(sp);
//        pane.setCenter(lb);
        pane.setCenter(text1);
        
        Scene scene = new Scene(pane, 640, 480);
        
        primaryStage.setTitle("Welcome to WordDump");
        primaryStage.setScene(scene);
        primaryStage.show();
		
	}
/*	
	   public static HBox hbox()
	    {
	        Button btn = new Button();
	        btn.setText("Button1");
	        Button btn2 = new Button();
	        btn2.setText("Button2");
	        Button btn3 = new Button();
	        btn3.setText("Button3");
	        btn.setPrefSize(100, 20);
	        btn2.setPrefSize(100,20);
	        btn3.setPrefSize(100,20);
	        
	        HBox hbox = new HBox();
	        hbox.getStyleClass().add("hbox");
	        hbox.getChildren().addAll(btn, btn2, btn3);
	  
	        return hbox;
	    }
	   
	    public static VBox vbox()
	    {
	    	
	    	
	        Label lbl = new Label("Label1");
	        Label lbl2 = new Label("Label2");
	        VBox vbox = new VBox();
	        vbox.getStyleClass().addAll("vbox");
	        vbox.getChildren().addAll(lbl, lbl2);
	        return vbox;
	    }
	    
	    public static PieChart pc()
	    {
	        ObservableList<PieChart.Data> pieData = 
	                FXCollections.observableArrayList(
	                new PieChart.Data("Rent", 500),
	                        new PieChart.Data("Electric",125), 
	                        new PieChart.Data("Groceries", 235), 
	                        new PieChart.Data("Entertainment", 200),
	                        new PieChart.Data("Cell Phone", 80));
	        
	        PieChart budget = new PieChart(pieData);
	        budget.setTitle("Monthly Expenses");
	        return budget;
	    }
	
	
*/	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		launch(args);
	}

}
