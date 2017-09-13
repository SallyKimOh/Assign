import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.math3.distribution.NormalDistribution;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Dashboard extends Application {

	private double mean = 0;
	private double max = 0;
	private double min = 0;
	private double sd = 0;
	private double median = 0;
	private double weightedAverage = 0;
	private List<Double> list;
	
	
	public Button firstEle() {
		
		Button btn = new Button();
		btn.setText("Go!");
		btn.setMaxSize(500, 20);
		
		return btn;
	}
	
	
	public GridPane secondEle(){
		GridPane gp = new GridPane();
		gp.setAlignment(Pos.CENTER_LEFT);
		gp.setHgap(10);
		gp.setVgap(10);
		gp.setPadding(new Insets(5,5,5,5));
		
		Label emean = new Label ("Enter Mean:");
		gp.add(emean, 0, 0);
		TextField meanTxt = new TextField("0");
		meanTxt.setPrefSize(370, 15);
		gp.add(meanTxt, 1,0);

		Label deviation = new Label ("Enter Deviation:");
		gp.add(deviation, 0, 1);
		TextField devTxt = new TextField("10");
		gp.add(devTxt, 1,1);
		
		Label cnt = new Label ("Enter N:");
		gp.add(cnt,0,2);
		TextField cntTxt = new TextField("10");
		gp.add(cntTxt, 1,2);
		
		calculate(Double.parseDouble(meanTxt.getText()),Double.parseDouble(devTxt.getText()),Integer.parseInt(cntTxt.getText()));
		
		
		return gp;
	}
	
	public void calculate(double m, double s,int cnt) {
		
		NormalDistribution  nDist = new NormalDistribution ( m , s ); 
		
//		ArrayList<Double> list = new ArrayList<Double>();
		list = new ArrayList<Double>();
		
		for (int i = 0; i < cnt; i++) {
			list.add(nDist.sample());
		}
		
		Collections.sort(list);
		
		max = list.get(cnt-1);
		
		min = list.get(0);
		mean = nDist.getMean();
		
		int j = cnt >= 10? 10: cnt;
		int jsum = 0;
		double sum = 0;
		double avg = 0;
		
		for ( int i = 0; i < j; i++) {
			sum += j*list.get(i);
			jsum+=(j-i);
		}
		
		avg = sum/jsum;
		weightedAverage = avg;
		
		if ((((double)list.size()-1)/2)==(double)((list.size()-1)/2)) {
			median = list.get(list.size()/2);
		} else {
			median = (list.get(list.size()/2)+list.get((list.size()/2)-1))/2.0;
		}

//		median = list.get(list.size()/2);
		
		Dashboard dash = new Dashboard();
		
		sd = Math.sqrt(dash.differenceOfSquares(list, mean)/list.size());

		
		System.out.println(list);
		System.out.println(max);
		System.out.println(min);
		System.out.println(mean);
		System.out.println(avg);
		System.out.println(median);
		System.out.println(list.get(list.size()/2));
		System.out.println(sd);
		
		
	}
	
	
	public BorderPane elements() {
		
		BorderPane bp = new BorderPane();
		
		Button btn = new Button();
		btn.setText("Go!");
		btn.setMaxSize(500, 20);
	
		
		GridPane gp = new GridPane();
		gp.setAlignment(Pos.CENTER_LEFT);
		gp.setHgap(10);
		gp.setVgap(10);
		gp.setPadding(new Insets(5,5,5,5));
		
		Label emean = new Label ("Enter Mean:");
		gp.add(emean, 0, 0);
		TextField meanTxt = new TextField("0");
		meanTxt.setPrefSize(370, 15);
		gp.add(meanTxt, 1,0);

		Label deviation = new Label ("Enter Deviation:");
		gp.add(deviation, 0, 1);
		TextField devTxt = new TextField("10");
		gp.add(devTxt, 1,1);
		
		Label cnt = new Label ("Enter N:");
		gp.add(cnt,0,2);
		TextField cntTxt = new TextField("10");
		gp.add(cntTxt, 1,2);
		
		bp.setTop(btn);
		bp.setBottom(gp);

		btn.setOnMouseClicked(e->{

			calculate(Double.parseDouble(meanTxt.getText()),Double.parseDouble(devTxt.getText()),Integer.parseInt(cntTxt.getText()));
			newScene();
	    });
	    	
		return bp;
	}
	
	

	public void newScene() {
		
        Stage stage = new Stage();
        TextField tf = new TextField();
        tf.setText(String.format("Mean: %f  Max: %f  Min:%f  SD:%f Median:%f WeightedAverage:%f", mean, max, min, sd, median, weightedAverage));

		ListView<Double> list1 = new ListView<Double>();
		
		ObservableList<Double> objItem = FXCollections.observableList(list);

		list1.setItems(objItem);
		
		BorderPane pane = new BorderPane();
		
    	ScrollPane sp = new ScrollPane();

    	sp.setPrefSize(200, 480);
		pane.setTop(tf);
    	pane.setCenter(list1);	
        
        Scene newScene = new Scene(pane, 700,500);
    	stage.setScene(newScene);
    
    	stage.show();
		
	}
	
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		VBox root = new VBox();
//		root.setAlignment(Pos.CENTER);

//		root.getChildren().addAll(firstEle(),secondEle());
		root.getChildren().addAll(elements());

		
		Scene scene = new Scene(root, 500,150);
		primaryStage.setTitle("Lab2");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}

	
	public double differenceOfSquares(List<Double> list, double mean) {
		double sum = 0;
		
		for(double item : list){
			sum += Math.pow((item-mean),2);
		}	
		return sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
/*
		NormalDistribution  nDist = new NormalDistribution ( 5 , 10 ); 
		
		ArrayList<Double> list = new ArrayList<Double>();
		
		int cnt = 10;
		
		for (int i = 0; i < cnt; i++) {
			list.add(nDist.sample());
		}
		
		Collections.sort(list);
		
		
		double max = list.get(cnt-1);
		
		double min = list.get(0);
		double mean = nDist.getMean();
		
		int j = 10;
		int jsum = 0;
		double sum = 0;
		double avg = 0;
		
		double sd = 0;
		
		
		for ( int i = 0; i < 10; i++) {
			sum += j*list.get(i);
			jsum+=j;
			j--;			
		}
		
		avg = sum/jsum;
		
		double median = 0;
		
		if ((((double)list.size()-1)/2)==(double)((list.size()-1)/2)) {
			median = list.get(list.size()/2);
		} else {
			median = (list.get(list.size()/2)+list.get((list.size()/2)-1))/2.0;
		}

//		median = list.get(list.size()/2);
		
		Dashboard dash = new Dashboard();
		
		sd = Math.sqrt(dash.differenceOfSquares(list, mean)/list.size());

		
		System.out.println(list);
		System.out.println(max);
		System.out.println(min);
		System.out.println(mean);
		System.out.println(avg);
		System.out.println(median);
		System.out.println(list.get(list.size()/2));
		System.out.println(sd);
*/
	}

	
}
