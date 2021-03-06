package cst8284.assignment1;
import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
 
public class TimelineEvents extends Application {
    
    //main timeline
    private Timeline timeline;
    private AnimationTimer timer;
 
    //variable for storing actual frame
    private Integer i=0;
 
    @Override public void start(Stage stage) {
        Group p = new Group();
        Scene scene = new Scene(p);
        stage.setScene(scene);
        stage.setWidth(500);
        stage.setHeight(500);
        p.setTranslateX(80);
        p.setTranslateY(80);

 /*       
        //create a circle with effect
        final Circle circle = new Circle(220,  Color.rgb(156,216,255));
        circle.setEffect(new Lighting());
        //create a text inside a circle
        final Text text = new Text (i.toString());
        text.setStroke(Color.BLACK);
        //create a layout for circle with text inside
        final StackPane stack = new StackPane();
        stack.getChildren().addAll(circle, text);
        stack.setLayoutX(30);
        stack.setLayoutY(30);
        
        p.getChildren().add(stack);
*/
        final Rectangle rect1 = new Rectangle(10, 10, 100, 100);
        rect1.setArcHeight(20);
        rect1.setArcWidth(20);
        rect1.setFill(Color.RED);
        p.getChildren().add(rect1);       
        
        
        FadeTransition ft = new FadeTransition(Duration.millis(3000), rect1);
        ft.setFromValue(1.0);
        ft.setToValue(0.1);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();        
       
       
        final Rectangle rectPath = new Rectangle (0, 0, 70, 70);
        rectPath.setArcHeight(10);
        rectPath.setArcWidth(10);
        rectPath.setFill(Color.CORNFLOWERBLUE);
        final Text txt1 = new Text ("Catch!!");
        txt1.setStroke(Color.WHITE);
        
        final StackPane stack1 = new StackPane();
        stack1.getChildren().addAll(rectPath, txt1);
        stack1.setLayoutX(30);
        stack1.setLayoutY(30);

        
        
//        p.getChildren().add(rectPath);
        p.getChildren().add(stack1);
        
        Path path = new Path();
        path.getElements().add(new MoveTo(20,20));
        path.getElements().add(new CubicCurveTo(380, 0, 380, 120, 200, 120));
        path.getElements().add(new CubicCurveTo(0, 120, 0, 240, 380, 240));
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(4000));
        pathTransition.setPath(path);
//        pathTransition.setNode(rectPath);
        pathTransition.setNode(stack1);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        pathTransition.setAutoReverse(true);
        pathTransition.play();       

        
        
        Rectangle rectParallel = new Rectangle(10,200,50, 50);
        rectParallel.setArcHeight(15);
        rectParallel.setArcWidth(15);
        rectParallel.setFill(Color.DARKBLUE);
        rectParallel.setTranslateX(50);
        rectParallel.setTranslateY(75);

        final Text txt2 = new Text ("Java!!");
        txt2.setStroke(Color.RED);
        
        final StackPane stack2 = new StackPane();
        stack2.getChildren().addAll(rectParallel, txt2);
        
        
//        p.getChildren().add(rectParallel);
        p.getChildren().add(stack2);
        
        FadeTransition fadeTransition = 
                new FadeTransition(Duration.millis(3000), stack2);
            fadeTransition.setFromValue(1.0f);
            fadeTransition.setToValue(0.3f);
            fadeTransition.setCycleCount(2);
            fadeTransition.setAutoReverse(true);
            TranslateTransition translateTransition =
                new TranslateTransition(Duration.millis(2000), stack2);
            translateTransition.setFromX(50);
            translateTransition.setToX(350);
            translateTransition.setCycleCount(2);
            translateTransition.setAutoReverse(true);
            RotateTransition rotateTransition = 
                new RotateTransition(Duration.millis(3000), stack2);
            rotateTransition.setByAngle(180f);
            rotateTransition.setCycleCount(4);
            rotateTransition.setAutoReverse(true);
            ScaleTransition scaleTransition = 
                new ScaleTransition(Duration.millis(2000), stack2);
            scaleTransition.setToX(2f);
            scaleTransition.setToY(2f);
            scaleTransition.setCycleCount(2);
            scaleTransition.setAutoReverse(true);
            
            ParallelTransition parallelTransition = new ParallelTransition();
            parallelTransition.getChildren().addAll(
                    fadeTransition,
                    translateTransition,
                    rotateTransition,
                    scaleTransition
            );
            parallelTransition.setCycleCount(Timeline.INDEFINITE);
            parallelTransition.play();       
        
            Rectangle rectSeq = new Rectangle(25,25,50,50);
            rectSeq.setArcHeight(15);
            rectSeq.setArcWidth(15);
            rectSeq.setFill(Color.CRIMSON);
            rectSeq.setTranslateX(50);
            rectSeq.setTranslateY(50);
       
            p.getChildren().add(rectSeq);
        
            FadeTransition fadeTransition1 = 
                    new FadeTransition(Duration.millis(1000), rectSeq);
                fadeTransition1.setFromValue(1.0f);
                fadeTransition1.setToValue(0.3f);
                fadeTransition1.setCycleCount(1);
                fadeTransition1.setAutoReverse(true);
         
                TranslateTransition translateTransition1 =
                    new TranslateTransition(Duration.millis(2000), rectSeq);
                translateTransition1.setFromX(50);
                translateTransition1.setToX(375);
                translateTransition1.setCycleCount(1);
                translateTransition1.setAutoReverse(true);
         
                RotateTransition rotateTransition1 = 
                    new RotateTransition(Duration.millis(2000), rectSeq);
                rotateTransition1.setByAngle(180f);
                rotateTransition1.setCycleCount(4);
                rotateTransition1.setAutoReverse(true);
         
                ScaleTransition scaleTransition1 = 
                    new ScaleTransition(Duration.millis(2000), rectSeq);
                scaleTransition1.setFromX(1);
                scaleTransition1.setFromY(1);
                scaleTransition1.setToX(2);
                scaleTransition1.setToY(2);
                scaleTransition1.setCycleCount(1);
                scaleTransition1.setAutoReverse(true);

                SequentialTransition sequentialTransition = new SequentialTransition();
        sequentialTransition.getChildren().addAll(
                fadeTransition1,
                translateTransition1,
                rotateTransition1,
                scaleTransition1);
        sequentialTransition.setCycleCount(Timeline.INDEFINITE);
        sequentialTransition.setAutoReverse(true);

        sequentialTransition.play();           
            
            
        
        
        
        
        stage.show();
  /*             
        
        //create a timeline for moving the circle
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
 
//You can add a specific action when each frame is started.
        timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                text.setText(i.toString());
                i++;
            }
 
        };
 
        //create a keyValue with factory: scaling the circle 2times
        KeyValue keyValueX = new KeyValue(stack.scaleXProperty(), 2);
        KeyValue keyValueY = new KeyValue(stack.scaleYProperty(), 2);
 
        //create a keyFrame, the keyValue is reached at time 2s
        Duration duration = Duration.millis(2000);
        //one can add a specific action when the keyframe is reached
        EventHandler onFinished = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                 stack.setTranslateX(java.lang.Math.random()*200-100);
                 //reset counter
                 i = 0;
            }
        };
 
  KeyFrame keyFrame = new KeyFrame(duration, onFinished , keyValueX, keyValueY);
 
        //add the keyframe to the timeline
        timeline.getKeyFrames().add(keyFrame);
 
        timeline.play();
        timer.start();
*/        
        
    }
        
        
    public static void main(String[] args) {
        Application.launch(args);
    }
  } 