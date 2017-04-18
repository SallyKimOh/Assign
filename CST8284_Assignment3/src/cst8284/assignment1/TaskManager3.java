package cst8284.assignment1;

import java.io.File;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TaskManager3 extends Application {

//	private ToDo[] toDoArray;
	private ArrayList<ToDo> toDoArray;
	private static int currentToDoElement;
	private Stage primaryStage;
	private FileChooser fc = new FileChooser();
	
	private TextField tempTitle,tempDueDate;
	private TextArea tempSubject;
	private RadioButton tempPriority;
	private int tPriority;
	private DatePicker tempDate;
	private ToggleGroup tempGroup;



	@Override
	public void start(Stage primaryStage) {
		setPrimaryStage(primaryStage);
		primaryStage.setTitle("To Do List");
//		primaryStage.setScene(getDefaultScene(new Text("Click here to open")));
		primaryStage.setScene(getSplashScene());
		primaryStage.show();
//		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
//	          public void handle(WindowEvent we) {
//	              System.out.println("Stage is closing");
//	          }
//	      });        

		primaryStage.setOnCloseRequest(e -> getBackUpFile());        
//		primaryStage.setOnCloseRequest(e -> Platform.exit());        
		
	}

	public void getBackUpFile1(){
//		isToDoArrayListDirty();
        System.out.println("Stage is closing");
        
        if (fc.getInitialFileName()!=null) {
        String fileName = fc.getInitialFileName().substring(0,fc.getInitialFileName().lastIndexOf('.'));
        fileName = fileName + "_bak.todo";
        fc.setInitialFileName(fileName);
        saveCenterPaneContents2ToDo("Y");
        }
 //    	primaryStage.close();	
     	Platform.exit();
		
	}

	public void getBackUpFile(){
		isToDoArrayListDirty();
        System.out.println("Stage is closing");
        
        if (fc.getInitialFileName()!=null) {
//        String fileName = fc.getInitialFileName().substring(0,fc.getInitialFileName().lastIndexOf('.'));
//        fileName = fileName + "_bak.todo";
//        fc.setInitialFileName(fileName);
        saveCenterPaneContents2ToDo("Y");
        }
 //    	primaryStage.close();	
     	Platform.exit();
		
	}
	
	
	
	public Scene getDefaultScene(Text defaultText) {
		defaultText.setStyle("-fx-font: 40px Tahoma; -fx-stroke: black; -fx-stroke-width: 1;");
		StackPane startPane = new StackPane();
		startPane.getChildren().add(defaultText);
		
		startPane.setOnMouseClicked(e -> 
			getPrimaryStage().setScene(getToDoScene(null))
		);
		Scene scene = new Scene(startPane, 1024, 768);
		return scene;
	}

	public Scene getSplashScene() {
		StackPane startPane = new StackPane();

		getMenuBar();
		startPane.getChildren().add(blendModeObjects());

		startPane.setOnMouseClicked(e -> 
//			getPrimaryStage().setScene(getToDoScene(null))
			getOpen()
		);
		Scene scene = new Scene(startPane, 1024, 768,Color.TRANSPARENT);
		return scene;
	}
	
    public static Node blendModeObjects() {
        Group g =new Group();
        
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

        g.getChildren().add(stack1);
        
        Path path = new Path();
        path.getElements().add(new MoveTo(20,20));
        path.getElements().add(new CubicCurveTo(480, 0, 380, 120, 200, 120));
        path.getElements().add(new CubicCurveTo(0, 120, 0, 240, 480, 240));
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(4000));
        pathTransition.setPath(path);
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

        DropShadow ds1 = new DropShadow();
        ds1.setOffsetY(5.0f);
        ds1.setOffsetX(5.0f);
        ds1.setColor(Color.CORAL);

        final Text txt2 = new Text (200,100,"QuizMaster");
        txt2.setStroke(Color.DARKSEAGREEN);
        txt2.setEffect(ds1);
        txt2.setFill(Color.RED);
        txt2.setCache(true);
 
        g.getChildren().add(txt2);
        
        
        
        
        final StackPane stack2 = new StackPane();
        stack2.getChildren().addAll(rectParallel, txt2);
        
        g.getChildren().add(stack2);
        
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
        
        return g;
    }

    
	public void getOpen() {

		FileUtils fUtils = new FileUtils();
		
//		FileChooser fc = new FileChooser();
		fc = new FileChooser();
		fc.setTitle("Open ToDo File");
		fc.setInitialDirectory(new File("D:\\"));    			
		fc.getExtensionFilters().addAll(
				new ExtensionFilter("uiz Files", "*.todo"),
				new ExtensionFilter("All Files", "*.*")
		);
		
		File todoFile = fc.showOpenDialog(getPrimaryStage());
		
		System.out.println(todoFile);
		
	    if (fUtils.fileExists(todoFile) && todoFile.getName().endsWith(".todo")) {
//	    	fUtils.getToDoArray(fUtils.getAbsPath(todoFile));
	    	setToDoArray(fUtils.getToDoArray(fUtils.getAbsPath(todoFile)));
			fc.setInitialFileName(todoFile.getAbsolutePath());

			System.out.println("element:"+getToDoElement());
			System.out.println("1arraylen:"+toDoArray.size());
			System.out.println("2arraylen:"+getToDoArray().size());
			isToDoArrayListDirty();			
			getPrimaryStage().setScene(getToDoScene(getToDoArray().get(getToDoElement())));
	    	
	    } else {
//			getPrimaryStage().setScene(getToDoScene(null));
	
	    	String msg = "No File Name Entered. Do you wish exit(OK) or continue (Cancel)?";
	    	String titleMsg ="No File Name Entered.";
	    	
	    	Alert alert = new Alert(AlertType.CONFIRMATION);
	    	if (fUtils.fileExists(todoFile) && (!todoFile.getName().endsWith(".todo"))) {
	    		msg="No todo File choose";
	    		titleMsg="Do you wish exit(OK) or choose exactly .todo file (Cancel)?";
	    	}
	    	alert.setTitle(titleMsg);
	    	alert.setHeaderText(null);
	    	alert.setContentText(msg);
	    	Optional<ButtonType> result = alert.showAndWait();
			    	
	    	if (result.get() == ButtonType.OK){
	    	    Platform.exit();
			    	} else {
			    		alert.close();
			    		getOpen();
	    	}            	
			    	
	    }
	    
	    isToDoArrayListDirty();
//		if (istoDoArrayListDirty()) {
//			getToDoArray().get(getToDoElement()).setRemove(false);
//		}

	}
	 
	public void getSave() {
		
		FileUtils fUtils = new FileUtils();
		
		System.out.println("ini==>"+fc.getInitialFileName());
		System.out.println("filepath==>"+fUtils.getAbsPath());
		System.out.println("Name:"+fc.getInitialFileName());
		
		isToDoArrayListDirty();
		saveCenterPaneContents2ToDo(null);		
		
	}

	public void getAdd() {
		System.out.println(getToDoArray().size());
	
		getToDoArray().add(new ToDo());
		setToDoArray(getToDoArray());
		setToDoElement(getToDoArray().size()-1);
		
		System.out.println("nowEle:"+getToDoElement());
		getPrimaryStage().setScene(getToDoScene(getToDoArray().get(getToDoElement())));
//		getPrimaryStage().setScene(getToDoScene(getToDoArray().get(getToDoArray().size()-1)));
		
//		System.out.println("ori:"+fc.getInitialFileName());
//		System.out.println("new:"+file.getName());
//	
//		
//		FileInputStream inputStream = null;
//		FileOutputStream outputStream = null;
//		if (!file.isFile())
//		{
//			try {
//				inputStream = new FileInputStream(fc.getInitialFileName());
//				File fParent = new File (file.getParent());
//				if (!fParent.exists())
//				{
//					fParent.mkdir();
//				}
//					file.createNewFile();
//
//					outputStream = new FileOutputStream(file);
//					FileChannel fcin = inputStream.getChannel();
//					FileChannel fcout = outputStream.getChannel();
//					long size = 0;
//					size = fcin.size();
//					fcin.transferTo(0, size, fcout);
//					fcout.close();
//					fcin.close();
//					outputStream.close();
//					inputStream.close();
//			
//			
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//		
////		 FileOutputStream out = new FileOutputStream ( fTarget);
////		  byte[] bBuffer = new  byte[ 1024 * 8];
////		  int nRead;
////		  while ( (nRead = io.read( bBuffer)) != -1)
////		  {
////		   out.write( bBuffer, 0, nRead);
////		  }
////		  io.close();
////		  out.close();
//		
//		
//		
//
////		try {
////		file.createNewFile();
////	} catch (IOException e) {
////		// TODO Auto-generated catch block
////		e.printStackTrace();
////	}
//		
//		
//		
//		
////		InputStream is = null;
////		OutputStream os = null;
////		if (fc.getInitialFileName() != null) {
////			try {
////					file.createNewFile();
////			        is = new FileInputStream(fc.getInitialFileName());
////			        os = new FileOutputStream(file.getName());
////			        byte[] buffer = new byte[1024];
////			        int length;
////			        while ((length = is.read(buffer)) > 0) {
////			            os.write(buffer, 0, length);
////			        }
////		    } catch (Exception e) {
////		    	e.getStackTrace();
////		    } finally {
////				try {
////					is.close();
////					os.close();
////				} catch (IOException e) {
////					// TODO Auto-generated catch block
////					e.printStackTrace();
////				}
////		    }
////		}
////
//		
//		
//		
//		
//		
//		FileUtils fUtils = new FileUtils();
//		
////    	fUtils.getToDoArray(file.getAbsolutePath());
////    	setToDoArray(fUtils.getToDoArray(file.getAbsolutePath()));
//
//		
//		toDoArray.get(getToDoElement()).setRemove(true);
//		
//		
//		
//		fc.setInitialFileName(file.getAbsolutePath());
////		toDoArray.get(currentToDoElement).setTitle("");
//		toDoArray.get(getToDoElement()).setTitle("");
//		toDoArray.get(getToDoElement()).setSubject("");
//		toDoArray.get(getToDoElement()).setDueDate(new Date());
//		toDoArray.get(getToDoElement()).setPriority(1);
//		toDoArray.get(getToDoElement()).setRemove(true);
//		getPrimaryStage().setScene(getToDoScene(getToDoArray().get(getToDoElement())));
//		
//		
//		
////		toDoArray.get(currentToDoElement).setTitle("");
////		toDoArray.get(currentToDoElement).setRemove(true);
////		toDoArray.get(getToDoElement()).setTitle("");
////		toDoArray.get(getToDoElement()).setRemove(true);
////		
//		getPrimaryStage().setScene(getToDoScene(getToDoArray().get(getToDoElement())));
//		
//		
//		
//		
////		Writer m_writer;
////		try {
////			
////			m_writer = new FileWriter("./");
////			m_writer.flush();
////		} catch (IOException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		
	}


	public void getRemove() {
		
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Delete");
    	alert.setHeaderText(null);
//    	alert.setContentText("Are you sure deleting this file(OK) or cancel (Cancel)?");
    	alert.setContentText("Are you sure deleting this Element (OK) or cancel (Cancel)?");
 //   	alert.showAndWait();
    	Optional<ButtonType> result = alert.showAndWait();
		    	
    	if (result.get() == ButtonType.OK){
    		toDoArray.remove(getToDoElement());
			alert = new Alert(AlertType.INFORMATION);
    
    		try {
    			new FileUtils().setToDoArrayListToFile(fc.getInitialFileName(), toDoArray);
       			alert.setContentText("Deleting is successful");
    		
//       		System.out.println("remove11:"+fc.getInitialFileName());
//       		
//       		File file = new File(fc.getInitialFileName());
//
//   			alert.setHeaderText(null);
//       		if (file.delete()) {
//       			alert.setContentText("Deleting is successful");
//       		} else {
//       			alert.setContentText("Deleting is fail. Try again");
// //      			getRemove();
//       		}
//    		
    		} catch (Exception e) {
    			alert.setContentText("Deleting is fail. Try again");
    			getRemove();
    			e.fillInStackTrace();
    		}

    		alert.showAndWait();
		} else {
		 	alert.close();
		    		
    	}          	

		System.out.println("afterRemoveEle:"+getToDoElement());
		
				
		if ((getToDoElement()-1 == getToDoArray().size()-1) && (getToDoElement() > 0)) {
			System.out.println("AAAAAAAAAAA");
			setToDoElement(getToDoElement()-1);
		} else if (getToDoElement() == 0) {
			System.out.println("BBBBBB");
			Platform.exit();
		} 
    	getPrimaryStage().setScene(getToDoScene(getToDoArray().get(getToDoElement())));
		
		
	}

	
	
	public void saveCenterPaneContents2ToDo(String btnTypeYN){
		ToDo tdTemp = new ToDo();
		tdTemp.setCompleted(false);
		tdTemp.setEmpty(false);
		tdTemp.setRemove(true);
		
		tdTemp = toDoArray.get(getToDoElement());

//		System.out.println("radio:"+getTempGroup().getSelectedToggle().getUserData());		
		
		Boolean flag = equalValidation(tdTemp);
//		Boolean flag = equalValidation(toDoArray.get(getToDoElement()));
		System.out.println("flag:"+flag);
		
		if (flag) {
			
	    	Alert alert = new Alert(AlertType.CONFIRMATION);
	    	alert.setTitle("Save");
	    	alert.setHeaderText(null);
	    	alert.setContentText("Do you wish to save (OK) or cancel (Cancel)?");
	    	Optional<ButtonType> result = alert.showAndWait();
	    	if (result.get() == ButtonType.OK){
//	    		alert.showAndWait();
			
				System.out.println("11:"+tdTemp.getTitle());
				System.out.println(getTempTitle().getText());
		//		System.out.println(getTempPriority().selectedProperty().getValue());
		//		System.out.println(getTempDate().getValue());
				
		//		RadioButton rb1 = getTempPriority();
		//		System.out.println(rb1.selectedProperty().getValue());
				
		
				tdTemp.setTitle(getTempTitle().getText());
				tdTemp.setSubject(getTempSubject().getText());
		//		tdTemp.setDueDate(Date.valueOf(getTempDate().getValue()));
		//		tdTemp.setPriority(Integer.parseInt(getTempPriority().getText()));
				tdTemp.setPriority(Integer.parseInt(getTempGroup().getSelectedToggle().getUserData().toString()));
		//		tdTemp.setDueDate(Date.valueOf(getTempDueDate().getText()));
				DateFormat formatter = new SimpleDateFormat("YYYY-MM-DD"); 
				Date date = new Date();
				formatter.format(date);
				Format format = new SimpleDateFormat("E MMM dd");
				
				
//				try {
//					
////					date = getTempDueDate().getText()==null? new Date():(Date)formatter.parse(getTempDueDate().getText());
//					date = (Date)formatter.parse(format.format(new Date()));
//				
//				} catch (ParseException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//				date = new Date(117, 2, 15);
				
				date = Date.from(getTempDate().getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
				
//				tdTemp.setDueDate(Date.valueOf(getTempDueDate().getText())==null? new Date():Date.valueOf(getTempDueDate().getText()));
				tdTemp.setDueDate(date);
				
				System.out.println("element:"+getToDoElement());
				System.out.println("arraylen:"+toDoArray.size());
				
				
				new FileUtils().setToDoArrayListToFile(fc.getInitialFileName(),toDoArray);
				getToDoArray().get(getToDoElement()).setRemove(true);
				
				if (btnTypeYN==null)		
				getPrimaryStage().setScene(getToDoScene(getToDoArray().get(getToDoElement())));
	    	} else {
	    		alert.close();
	    	}
	    	
				
		}
	}
	
	public Boolean equalValidation(ToDo tdTemp){
	System.out.println("===dirty==>"+tdTemp.isRemoveSet());
	System.out.println("===dirty==>"+getToDoArray().get(getToDoElement()).isRemoveSet());

	if (getTempTitle()!=null) {

		Date date = Date.from(getTempDate().getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());

		if ((!tdTemp.getTitle().equals(getTempTitle().getText())) || 
				(!tdTemp.getSubject().equals(getTempSubject().getText())) ||
				(!tdTemp.getDueDate().equals(date) ||
				(tdTemp.getPriority() != (Integer.parseInt(getTempGroup().getSelectedToggle().getUserData().toString())))
		)){
			
			getToDoArray().get(getToDoElement()).setRemove(true);
			
		} else {
		
			getToDoArray().get(getToDoElement()).setRemove(false);
		}

	}
		return getToDoArray().get(getToDoElement()).isRemoveSet();
	}
	public void isToDoArrayListDirty(){

		if (toDoArray!=null) {
			if (getToDoArray().get(getToDoElement()).isRemoveSet())
				getToDoArray().get(getToDoElement()).setRemove(false);
		}

	}
		
	public Scene getToDoScene(ToDo td) {
		if (td == null) {  // use null to signal initial setup, i.e. ToDo[0]
			FileUtils fUtils = new FileUtils();
			ArrayList<ToDo> tdRawArray = fUtils.getToDoArray(FileUtils.getAbsPath());
			System.out.println(FileUtils.getAbsPath());
			System.out.println(tdRawArray.size());
			ArrayList<ToDo> tdCompactArray = getToDoArrayWithoutEmpties(tdRawArray);
			setToDoArray(tdCompactArray);
			setToDoElement(0);
			td = getToDoArray().get(getToDoElement());
		}
		return (new Scene(getToDoPane(td)));
	}

	public BorderPane getToDoPane(ToDo td) {
		VBox vbLeft = new VBox();
		vbLeft.setMinWidth(120);

		VBox vbRight = new VBox();
		vbRight.setMinWidth(120);
		
		BorderPane rootNode = new BorderPane();
		
//		rootNode.setTop(getTop());
		rootNode.setTop(getMenuBar());
		rootNode.setLeft(vbLeft);
		rootNode.setRight(vbRight);
		rootNode.setBottom(getBottomPane(td, rootNode));
		rootNode.setCenter(getCenterPane(td));
		
		rootNode.setOnMouseClicked(e-> {
			saveCenterPaneContents2ToDo(null);
			
		});
		
		
		return rootNode;
	}

	public HBox getTop(){
		HBox hBox = new HBox();

		return hBox;
	}

	public MenuBar getMenuBar(){
		Menu file = new Menu("File");
		
		file.setOnAction(e-> {
			saveCenterPaneContents2ToDo(null);
		});
		 
		MenuItem subOpen = new MenuItem("Open");
		MenuItem subSave = new MenuItem("Save");
		MenuItem subAdd = new MenuItem("Add");
		MenuItem subRemove = new MenuItem("Remove");
		MenuItem subExit = new MenuItem("Exit");
		
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().add(file);	
		file.getItems().addAll(subOpen,subSave,subAdd,subRemove,subExit);

		subExit.setOnAction(e -> {
//			if (istoDoArrayListDirty()) {
//				getToDoArray().get(getToDoElement()).setRemove(false);
//			}
			isToDoArrayListDirty();
			Platform.exit();
		});
		
		subOpen.setOnAction(e ->
			getOpen()
		);
		
		subSave.setOnAction(e ->
			getSave()
		);

		subRemove.setOnAction(e ->
			getRemove()
		);
		
		subAdd.setOnAction(e ->
			getAdd()
		);

		return menuBar;
	}
	
	public GridPane getCenterPane(ToDo td) {

		GridPane gp = new GridPane();
		gp.setPadding(new Insets(50));
		gp.setPrefWidth(1200);

		gp.setVgap(10);
		gp.setHgap(40);
		gp.setStyle("-fx-font: 20px Tahoma; -fx-stroke: black; -fx-stroke-width: 1;");

		Label lblTask = new Label("Task");
		gp.add(lblTask, 0, 0);
		TextField txfTitle = new TextField(td.getTitle());
		gp.add(txfTitle, 1, 0);
		
		Label lblSubject = new Label("Subject");
		gp.add(lblSubject, 0, 1);
		TextArea txaSubject = new TextArea(td.getSubject());
		gp.add(txaSubject, 1, 1);

		Label lblDate = new Label("Due Date");
		gp.add(lblDate, 0, 2);
//		TextField txfDate = new TextField(td.getDueDate()==null? null: td.getDueDate().toString());
//		gp.add(txfDate, 1, 2);
		
	    DatePicker datePicker = new DatePicker();
//	    datePicker.setValue(LocalDate.now());
	    if (td.getDueDate()==null) {
		    datePicker.setValue(LocalDate.now());
	    } else {
	    datePicker.setValue(td.getDueDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
	    }
		gp.add(datePicker, 1, 2);
		

		Label lblPriority = new Label("Priority");
		gp.add(lblPriority, 0, 3);
		ToggleGroup tglGroup = new ToggleGroup();
		RadioButton rb1 = (new RadioButton("1   "));
		rb1.setToggleGroup(tglGroup);
		rb1.setUserData("1");
		RadioButton rb2 = (new RadioButton("2   "));
		rb2.setToggleGroup(tglGroup);
		rb2.setUserData("2");
		RadioButton rb3 = (new RadioButton("3   "));
		rb3.setToggleGroup(tglGroup);
		rb3.setUserData("3");
		int pr = td.getPriority();
		RadioButton rbSet = (pr == 1) ? rb1 : (pr == 2) ? rb2 : (pr == 3) ? rb3 : null;
//		rbSet.setSelected(rbSet != null);
		if (rbSet !=null) {
			rbSet.setSelected(rbSet != null);
		} 
		HBox hRadioButtons = new HBox();
		hRadioButtons.getChildren().addAll(rb1, rb2, rb3);
		gp.add(hRadioButtons, 1, 3);

		setTempTitle(txfTitle);
		setTempSubject(txaSubject);
//		setTempDueDate(txfDate);
		setTempDate(datePicker);
		setTempPriority(rbSet);
		setTempGroup(tglGroup);
		
		
		
		return gp;
	}

	public HBox getBottomPane(ToDo td, BorderPane root) {
		
		HBox paneCtlBtns = new HBox(10);
		paneCtlBtns.setStyle("-fx-font: 50px Tahoma; -fx-stroke: black; -fx-stroke-width: 1;");
		paneCtlBtns.setAlignment(Pos.CENTER);
		paneCtlBtns.setPadding(new Insets(50));
		
		Button btnFirst = new Button("\u23ee"); // btnFirst.setMinSize(80, 80);
		Button btnBack = new Button("\u23ea"); // btnBack.setMinSize(80, 80);
		Button btnNext = new Button("\u23e9"); // btnNext.setMinSize(80, 80);
		Button btnLast = new Button("\u23ed"); // btnLast.setMinSize(80, 80);

		btnFirst.setOnAction(e -> {
			setToDoElement(0);
//			saveCenterPaneContents2ToDo1();
			btnBack.fire();
			saveCenterPaneContents2ToDo("Y");
		});
			
		btnBack.setOnAction(e -> {
			int toDoElement = getToDoElement();
			System.out.println("=="+toDoElement);
//			saveCenterPaneContents2ToDo1();
			saveCenterPaneContents2ToDo("Y");
			System.out.println("aaf=="+toDoElement);
			
			setToDoElement(toDoElement <=0 ? 0 : --toDoElement);
			btnFirst.setDisable(getToDoElement()==0); 
			btnBack.setDisable(getToDoElement()==0);
			btnNext.setDisable(getToDoElement()==getToDoArray().size()-1);
			btnLast.setDisable(getToDoElement()==getToDoArray().size()-1);
//			saveCenterPaneContents2ToDo();
			
			root.setCenter(getCenterPane(getToDoArray().get(getToDoElement())));
		});
		
		btnLast.setOnAction(e -> {
//			saveCenterPaneContents2ToDo();
			if (getToDoElement()!=getToDoArray().size()-1 ){
//				saveCenterPaneContents2ToDo1();
				saveCenterPaneContents2ToDo("Y");
			}
			setToDoElement(getToDoArray().size()-1);
			btnNext.fire();
		});
		
		btnNext.setOnAction(e -> {
//			saveCenterPaneContents2ToDo();
			if (getToDoElement()!=getToDoArray().size()-1 ){
//				saveCenterPaneContents2ToDo1();
				saveCenterPaneContents2ToDo("Y");
			}
			int toDoElement = getToDoElement();
			if (toDoElement < getToDoArray().size() -1) setToDoElement(++toDoElement);
			btnFirst.setDisable(toDoElement==0); btnBack.setDisable(toDoElement==0);
			btnNext.setDisable(toDoElement==getToDoArray().size()-1);
			btnLast.setDisable(toDoElement==getToDoArray().size()-1);
			root.setCenter(getCenterPane(getToDoArray().get(getToDoElement())));
			
		});
		
		if (getToDoElement()==0) btnFirst.fire();  // set default button conditions
		paneCtlBtns.getChildren().addAll(btnFirst, btnBack, btnNext, btnLast);
		return paneCtlBtns;
	}

	private ArrayList<ToDo> getToDoArrayWithoutEmpties(ArrayList<ToDo> tdRawAr) {
		
		int toElement = 0;
		for (int fromElement = 0; fromElement < tdRawAr.size(); fromElement++)
			if (!tdRawAr.get(fromElement).isEmptySet())
				tdRawAr.set(toElement++, tdRawAr.get(fromElement));
		
		ArrayList<ToDo> fullArray = new ArrayList<ToDo>();
		
		fullArray.clear();
		fullArray.addAll(tdRawAr);

		return fullArray;
	}
	
	
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage stage) {
		this.primaryStage = stage;
	}


	public ArrayList<ToDo> getToDoArray() {
		return toDoArray;
	}

	public void setToDoArray(ArrayList<ToDo> toDoArray) {
		this.toDoArray = toDoArray;
	}

	
	public static void setToDoElement(int currentElementNumber){
		currentToDoElement = currentElementNumber;
	}
	
	public static int getToDoElement(){
		return currentToDoElement;
	}

	
	
	
	
	public TextField getTempTitle() {
		return tempTitle;
	}

	public void setTempTitle(TextField tempTitle) {
		this.tempTitle = tempTitle;
	}

	public TextField getTempDueDate() {
		return tempDueDate;
	}

	public void setTempDueDate(TextField tempDueDate) {
		this.tempDueDate = tempDueDate;
	}

	public TextArea getTempSubject() {
		return tempSubject;
	}

	public void setTempSubject(TextArea tempSubject) {
		this.tempSubject = tempSubject;
	}

	public RadioButton getTempPriority() {
		return tempPriority;
	}

	public void setTempPriority(RadioButton tempPriority) {
		this.tempPriority = tempPriority;
	}

	public DatePicker getTempDate() {
		return tempDate;
	}

	public void setTempDate(DatePicker tempDate) {
		this.tempDate = tempDate;
	}
	
	

	public int gettPriority() {
		return tPriority;
	}

	public void settPriority(int tPriority) {
		this.tPriority = tPriority;
	}
	
	

	public ToggleGroup getTempGroup() {
		return tempGroup;
	}

	public void setTempGroup(ToggleGroup tempGroup) {
		this.tempGroup = tempGroup;
	}

	public static void main(String[] args) {
		launch(args);
	}

}
