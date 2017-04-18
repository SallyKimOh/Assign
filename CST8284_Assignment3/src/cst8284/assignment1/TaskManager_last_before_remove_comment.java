package cst8284.assignment1;

import java.io.File;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
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
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TaskManager_last_before_remove_comment extends Application {

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
	
	private ListView<String> list = new ListView<String>();
	private ObservableList<String> objItem;
	private ArrayList<ToDo> toDoSortArray = new ArrayList<ToDo>();
    private TableView<ToDo> table = new TableView<ToDo>();
    private ObservableList<ToDo> data;    
//    private boolean saveYN = true;
    





	@Override
	public void start(Stage primaryStage) {
		setPrimaryStage(primaryStage);
		primaryStage.setTitle("To Do List");
		primaryStage.setScene(getSplashScene());
		primaryStage.show();
		primaryStage.setOnCloseRequest(e -> getBackUpFile());        
		
	}
	
	public void getBackUpFile1(){
        System.out.println("Stage is closing");
        
        if (fc.getInitialFileName()!=null) {
        String fileName = fc.getInitialFileName().substring(0,fc.getInitialFileName().lastIndexOf('.'));
        fileName = fileName + "_bak.todo";
        fc.setInitialFileName(fileName);
        saveCenterPaneContents2ToDo("Y");
        }
     	Platform.exit();
		
	}

	public void getBackUpFile(){
		isToDoArrayListDirty();
        System.out.println("Stage is closing");
        
        if (fc.getInitialFileName()!=null) {
        saveCenterPaneContents2ToDo("Y");
        }
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
	    	
			ArrayList<ToDo> tdRawArray = fUtils.getToDoArray(fUtils.getAbsPath(todoFile));
			ArrayList<ToDo> tdCompactArray = getToDoArrayWithoutEmpties(tdRawArray);
			System.out.println("tdCompactArray:"+tdCompactArray.size());

			setToDoArray(tdCompactArray);
			toDoSortArray = new ArrayList<ToDo>();
			
			
			getToDoArray().forEach(item->toDoSortArray.add(item));
			
			setToDoElement(0);

//			setToDoArray(fUtils.getToDoArray(fUtils.getAbsPath(todoFile)));
			fc.setInitialFileName(todoFile.getAbsolutePath());

			System.out.println("element:"+getToDoElement());
			System.out.println("1arraylen:"+toDoArray.size());
			System.out.println("2arraylen:"+getToDoArray().size());
			isToDoArrayListDirty();			
			getPrimaryStage().setScene(getToDoScene(getToDoArray().get(getToDoElement())));
	    	
	    } else {
	
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
	}
	 
	public void getSave() {
		
		System.out.println("Sav3");
		FileUtils fUtils = new FileUtils();
		
		System.out.println("ini==>"+fc.getInitialFileName());
		System.out.println("filepath==>"+fUtils.getAbsPath());
		System.out.println("Name:"+fc.getInitialFileName());
		
		isToDoArrayListDirty();
//		saveYN=true;
		saveCenterPaneContents2ToDo(null);		
		
	}

	public void getAdd() {
		System.out.println(getToDoArray().size());
	
		getToDoArray().add(new ToDo());
		setToDoArray(getToDoArray());
		setToDoElement(getToDoArray().size()-1);
		
		System.out.println("nowEle:"+getToDoElement());
		getPrimaryStage().setScene(getToDoScene(getToDoArray().get(getToDoElement())));
	}


	public void getRemove() {
		
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Delete");
    	alert.setHeaderText(null);
    	alert.setContentText("Are you sure deleting this Element (OK) or cancel (Cancel)?");
    	Optional<ButtonType> result = alert.showAndWait();
		    	
    	if (result.get() == ButtonType.OK){
    		toDoArray.remove(getToDoElement());
			alert = new Alert(AlertType.INFORMATION);
    
    		try {
    			new FileUtils().setToDoArrayListToFile(fc.getInitialFileName(), toDoArray);
       			alert.setContentText("Deleting is successful");
    		
    		} catch (Exception e) {
    			alert.setContentText("Deleting is fail. Try again");
    			getRemove();
    			e.fillInStackTrace();
    		}

    		alert.showAndWait();
		} else {
		 	alert.close();
		    		
    	}          	

		toDoSortArray = new ArrayList<ToDo>();
		getToDoArray().forEach(item->toDoSortArray.add(item));

		if ((getToDoElement()-1 == getToDoArray().size()-1) && (getToDoElement() > 0)) {
			setToDoElement(getToDoElement()-1);
		} else if (getToDoElement() == 0) {
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
		
		tdTemp.setTitle(toDoArray.get(getToDoElement()).getTitle());
		tdTemp.setSubject(toDoArray.get(getToDoElement()).getSubject());
		tdTemp.setDueDate(toDoArray.get(getToDoElement()).getDueDate());
		tdTemp.setPriority(toDoArray.get(getToDoElement()).getPriority());
		
		
		System.out.println("ele:"+getToDoElement());
		
		Boolean flag = false;
		
		System.out.println("getTempTitle==>"+getTempTitle());
		System.out.println("tdTemp.getSubject==>"+tdTemp.getSubject());
		System.out.println("tdTemp.getDueDate==>"+tdTemp.getDueDate());
		System.out.println("tdTemp.getPriority==>"+tdTemp.getPriority());
		
//		if (saveYN) {
			flag = equalValidation(tdTemp);
//		}
		
		if (flag) {
			
	    	Alert alert = new Alert(AlertType.CONFIRMATION);
	    	alert.setTitle("Save");
	    	alert.setHeaderText(null);
	    	alert.setContentText("Do you wish to save (OK) or cancel (Cancel)?");
	    	Optional<ButtonType> result = alert.showAndWait();
	    	if (result.get() == ButtonType.OK){
		
				tdTemp.setTitle(getTempTitle().getText());
				tdTemp.setSubject(getTempSubject().getText());
				tdTemp.setPriority(Integer.parseInt(getTempGroup().getSelectedToggle().getUserData().toString()));
				Date date = new Date();
				date = Date.from(getTempDate().getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
				
				tdTemp.setDueDate(date);
				
				new FileUtils().setToDoArrayListToFile(fc.getInitialFileName(),toDoArray);
				getToDoArray().get(getToDoElement()).setRemove(true);
				
//				getToDoArray().forEach(item->toDoSortArray.add(item));
				getToDoSortArray().add(getToDoArray().get(getToDoElement()));

				if (btnTypeYN==null)		
				getPrimaryStage().setScene(getToDoScene(getToDoArray().get(getToDoElement())));
	    	} else {
	    		alert.close();
	    	}
	    	
				
		}
	}
	
	public Boolean equalValidation(ToDo tdTemp){

		System.out.println("title:"+getTempTitle());
		
	if (getTempTitle()!=null) {
		
		Date date = Date.from(getTempDate().getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
		int temPrio = 0;
		try {
			if (getTempGroup()!= null) {
				temPrio = (Integer.parseInt(getTempGroup().getSelectedToggle().getUserData().toString()));
			} 
		} catch (Exception e) {
			temPrio=0;
		}
		
		if ((!tdTemp.getTitle().equals(getTempTitle().getText())) || 
				(!tdTemp.getSubject().equals(getTempSubject().getText())) ||
				(!tdTemp.getDueDate().equals(date)) ||
				((tdTemp.getPriority() != temPrio)&& (temPrio!=0))
		){
			
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
			ArrayList<ToDo> tdCompactArray = getToDoArrayWithoutEmpties(tdRawArray);
			setToDoArray(tdCompactArray);
			toDoSortArray = new ArrayList<ToDo>();
			getToDoArray().forEach(item->toDoSortArray.add(item));
			setToDoElement(0);
			td = getToDoArray().get(getToDoElement());
			System.out.println("count:"+getToDoArray().size());
		}
		return (new Scene(getToDoPane(td)));
	}

	public BorderPane getToDoPane(ToDo td) {


		BorderPane rootNode = new BorderPane();

		VBox vbLeft = new VBox();
		vbLeft.setMinWidth(120);
		
        ScrollPane sp1 = new ScrollPane();
        
		BorderPane bp = new BorderPane();
		bp.setTop(list);
		bp.setCenter(getLeftPane(rootNode));
		
		sp1.setPrefSize(300, 500);
		sp1.setContent(bp);
		sp1.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		
		BorderPane bp2 = new BorderPane();
		bp2.setTop(getRightPane());
		bp2.setCenter(getRightTablePane());
				
		
		getChangeCenterListView(rootNode);		
		
		
		rootNode.setTop(getMenuBar());
//		rootNode.setLeft(list);		//for listview
//		rootNode.setLeft(getLeftPane());	//tableview
		rootNode.setLeft(sp1);		//total
//		rootNode.setRight(getRightPane());	//listview
//		rootNode.setRight(getRightTablePane());	//table view
		rootNode.setRight(bp2);
		rootNode.setBottom(getBottomPane(td, rootNode));
		rootNode.setCenter(getCenterPane(td));
		
		rootNode.setOnMouseClicked(e-> {
//			saveYN=true;
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
		
//		file.setOnAction(e-> {
//			saveCenterPaneContents2ToDo(null);
//		});
		 
		MenuItem subOpen = new MenuItem("Open");
		MenuItem subSave = new MenuItem("Save");
		MenuItem subAdd = new MenuItem("Add");
		MenuItem subRemove = new MenuItem("Remove");
		MenuItem subExit = new MenuItem("Exit");
		
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().add(file);	
		file.getItems().addAll(subOpen,subSave,subAdd,subRemove,subExit);

		subExit.setOnAction(e -> {
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

		
    	System.out.println("afterelement:"+getToDoElement());

		GridPane gp = new GridPane();
		gp.setPadding(new Insets(50));
		gp.setPrefWidth(1000);

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
	    System.out.println("date:"+td.getDueDate());
	    
	    
	    if (td.getDueDate()==null) {
		    datePicker.setValue(LocalDate.now());
	    } else {
		    Instant instant = Instant.ofEpochMilli(td.getDueDate().getTime());
		    System.out.println(LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate());
	    	datePicker.setValue(LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate());
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
		if (rbSet !=null) {
			rbSet.setSelected(rbSet != null);
		} 
		HBox hRadioButtons = new HBox();
		hRadioButtons.getChildren().addAll(rb1, rb2, rb3);
		gp.add(hRadioButtons, 1, 3);

		setTempTitle(txfTitle);
		setTempSubject(txaSubject);
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
//			saveYN=true;
			isToDoArrayListDirty();
			saveCenterPaneContents2ToDo(null);		
			
			setToDoElement(0);
			btnBack.fire();
		});
			
		btnBack.setOnAction(e -> {
//			saveYN=true;
			int toDoElement = getToDoElement();
			System.out.println("=="+toDoElement);
//			if (getTempTitle()!=null)
//				System.out.println("==>"+getTempTitle());
			if (getToDoElement() != 0) {
				isToDoArrayListDirty();
				saveCenterPaneContents2ToDo(null);		
			}
//			System.out.println("aaf=="+toDoElement);
			
			setToDoElement(toDoElement <=0 ? 0 : --toDoElement);
			btnFirst.setDisable(getToDoElement()==0); 
			btnBack.setDisable(getToDoElement()==0);
			btnNext.setDisable(getToDoElement()==getToDoArray().size()-1);
			btnLast.setDisable(getToDoElement()==getToDoArray().size()-1);
			
			root.setCenter(getCenterPane(getToDoArray().get(getToDoElement())));
		});
		

		btnNext.setOnAction(e -> {
//			saveYN=true;

			isToDoArrayListDirty();
			saveCenterPaneContents2ToDo(null);		
			int toDoElement = getToDoElement();
			if (toDoElement < getToDoArray().size() -1) setToDoElement(++toDoElement);
			btnFirst.setDisable(toDoElement==0); btnBack.setDisable(toDoElement==0);
			btnNext.setDisable(toDoElement==getToDoArray().size()-1);
			btnLast.setDisable(toDoElement==getToDoArray().size()-1);
			root.setCenter(getCenterPane(getToDoArray().get(getToDoElement())));
			
		});
		
		
		
		btnLast.setOnAction(e -> {
//			saveYN=true;
			
			isToDoArrayListDirty();
			saveCenterPaneContents2ToDo(null);		
			setToDoElement(getToDoArray().size()-1);
//			btnNext.fire();

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
		ArrayList<ToDo> fullArray = new ArrayList<ToDo>();
		fullArray.clear();

		for (int fromElement = 0; fromElement < tdRawAr.size(); fromElement++) {
			if (!tdRawAr.get(fromElement).isEmptySet()) {
				tdRawAr.set(toElement++, tdRawAr.get(fromElement));
				fullArray.add(tdRawAr.get(fromElement));
			}
		}
		
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


	public ArrayList<String> getListTitle(){
		ArrayList<String> arrTitle = new ArrayList<String>();
		getToDoSortArray().forEach(item->arrTitle.add(item.getTitle()));
		System.out.println("cnt:"+getToDoSortArray().size());
		
		return arrTitle;
	}

	public ArrayList<ToDo> getTableListView(){
		ArrayList<ToDo> arrTitle = new ArrayList<ToDo>();
		getToDoSortArray().forEach(item->arrTitle.add(item));
		
//		toDoArray = (ArrayList<ToDo>) getToDoSortArray().clone();
		
		System.out.println("cnt:"+getToDoSortArray().size());
		
		return arrTitle;
	}

	
	
	public void getListView(){
		objItem = FXCollections.observableList(getListTitle());

		list.setItems(objItem);

	}
	
	public VBox getRightPane(){
		VBox vbRight = new VBox();
		vbRight.setMinWidth(100);

 
        vbRight.setStyle("-fx-font: 15px Tahoma; -fx-stroke: black; -fx-stroke-width: 1;");
		vbRight.setAlignment(Pos.CENTER);
		vbRight.setPadding(new Insets(20));
        Label label = new Label("ListViewSorting");

    	Button titleBtn = new Button("SortByTitle");
    	Button subjectBtn = new Button("SortBySubject");
    	Button dueBtn = new Button("SortByDueDate");
    	Button priBtn = new Button("SortByPriority");
    	Button comBtn = new Button("SortByCompleted");
    	Button reverseBtn = new Button("SortReverse");

    	titleBtn.setMaxSize(120, 100);
    	subjectBtn.setMaxSize(120, 100);
    	dueBtn.setMaxSize(120, 100);
    	priBtn.setMaxSize(120, 100);
    	comBtn.setMaxSize(120, 100);
    	reverseBtn.setMaxSize(120, 100);
    	
    	vbRight.getChildren().addAll(label,titleBtn, subjectBtn,dueBtn,priBtn,comBtn,reverseBtn);

//		objItem = FXCollections.observableList(getListTitle());
//		list.setItems(objItem);

    	getListView();
    	titleBtn.setOnAction(e-> {
//			saveYN=true;
  
    		getToDoSortArray().sort((ToDo td1, ToDo td2) -> 
    		td1.getTitle().toLowerCase().compareTo(td2.getTitle().toLowerCase())
    		);
    		
    		System.out.println("sort:"+getToDoSortArray().get(0).getTitle());
    		System.out.println("nomal:"+getToDoArray().get(0).getTitle());
//    		objItem = FXCollections.observableList(getListTitle());
//    		list.setItems(objItem);
         	getListView();
    		
    	});

    	subjectBtn.setOnAction(e-> {
//			saveYN=true;

    		getToDoSortArray().sort((ToDo td1, ToDo td2) -> 
    		td1.getSubject().toLowerCase().compareTo(td2.getSubject().toLowerCase())
    		);

//    		objItem = FXCollections.observableList(getListTitle());
//    		list.setItems(objItem);
        	getListView();
    		
    	});

    	dueBtn.setOnAction(e-> {
//			saveYN=true;
    		getToDoSortArray().sort((ToDo td1, ToDo td2) -> 
    		td1.getDueDate().compareTo(td2.getDueDate())
    		);
    		
//    		objItem = FXCollections.observableList(getListTitle());
//    		list.setItems(objItem);
        	getListView();
    	});

    	priBtn.setOnAction(e-> {
//			saveYN=true;
    		getToDoSortArray().sort((ToDo td1, ToDo td2) -> 
    		td1.getPriority() - td2.getPriority()
    		);
    		
//    		objItem = FXCollections.observableList(getListTitle());
//    		list.setItems(objItem);
        	getListView();
    		
    	});

    	comBtn.setOnAction(e-> {
//			saveYN=true;

    		getToDoSortArray().sort((ToDo td1, ToDo td2) ->
    		Boolean.valueOf(td1.isCompleted()).compareTo(Boolean.valueOf(td2.isCompleted()))
    		);
    		
//    		objItem = FXCollections.observableList(getListTitle());
//    		list.setItems(objItem);
        	getListView();
    		
    	});

    	reverseBtn.setOnAction(e-> {
//			saveYN=true;
    		FXCollections.reverse((ObservableList<String>) objItem);
    	});
    	
		
    	return vbRight;
	}

	public VBox getRightTablePane(){
		VBox vbRight = new VBox();
		vbRight.setMinWidth(100);

		vbRight.setStyle("-fx-font: 15px Tahoma; -fx-stroke: black; -fx-stroke-width: 1;");
		vbRight.setAlignment(Pos.CENTER);
		vbRight.setPadding(new Insets(20));


        Label label = new Label("TableViewSorting");
//        label.setFont(new Font("Arial", 20));

		
    	Button titleBtn = new Button("SortByTitle");
    	Button subjectBtn = new Button("SortBySubject");
    	Button dueBtn = new Button("SortByDueDate");
    	Button priBtn = new Button("SortByPriority");
    	Button comBtn = new Button("SortByCompleted");
    	Button reverseBtn = new Button("SortReverse");

    	titleBtn.setMaxSize(120, 100);
    	subjectBtn.setMaxSize(120, 100);
    	dueBtn.setMaxSize(120, 100);
    	priBtn.setMaxSize(120, 100);
    	comBtn.setMaxSize(120, 100);
    	reverseBtn.setMaxSize(120, 100);
    	
    	vbRight.getChildren().addAll(label,titleBtn, subjectBtn,dueBtn,priBtn,comBtn,reverseBtn);

//    	data = FXCollections.observableArrayList(getTableListView());    
//    	table.setItems(data);

    	titleBtn.setOnAction(e-> {
  
    		getToDoSortArray().sort((ToDo td1, ToDo td2) -> 
    		td1.getTitle().toLowerCase().compareTo(td2.getTitle().toLowerCase())
    		);
 
    		data = FXCollections.observableArrayList(getTableListView());
    		table.setItems(data);
    		
    	});

    	subjectBtn.setOnAction(e-> {

    		getToDoSortArray().sort((ToDo td1, ToDo td2) -> 
    		td1.getSubject().toLowerCase().compareTo(td2.getSubject().toLowerCase())
    		);

    		data = FXCollections.observableArrayList(getTableListView());  	
    		table.setItems(data);
    		
    	});

    	dueBtn.setOnAction(e-> {
    		getToDoSortArray().sort((ToDo td1, ToDo td2) -> 
    		td1.getDueDate().compareTo(td2.getDueDate())
    		);
    		
    		data = FXCollections.observableArrayList(getTableListView());  	
    		table.setItems(data);
    
    	});

    	priBtn.setOnAction(e-> {
    		getToDoSortArray().sort((ToDo td1, ToDo td2) -> 
    		td1.getPriority() - td2.getPriority()
    		);
    		
    		data = FXCollections.observableArrayList(getTableListView());  	
    		table.setItems(data);
    	});

    	comBtn.setOnAction(e-> {

    		getToDoSortArray().sort((ToDo td1, ToDo td2) ->
    		Boolean.valueOf(td1.isCompleted()).compareTo(Boolean.valueOf(td2.isCompleted()))
    		);
    		
    		data = FXCollections.observableArrayList(getTableListView());  	
    		table.setItems(data);
    	});

    	reverseBtn.setOnAction(e-> {
    		FXCollections.reverse((ObservableList<ToDo>) data);
    		table.setItems(data);
    	});
    	
		
    	return vbRight;
	}
	
	
	public ArrayList<ToDo> getToDoSortArray() {
		return toDoSortArray;
	}

	public void setToDoSortArray(ArrayList<ToDo> toDoSortArray) {
		this.toDoSortArray = toDoSortArray;
	}
	
	
	public VBox getLeftPane(BorderPane root) {

        table.getItems().clear();
        table = new TableView<ToDo>();

		final Label label = new Label("Table View");
        label.setFont(new Font("Arial", 20));
 
        table.setEditable(false);
 
        TableColumn title = new TableColumn("Title");
        title.setMinWidth(100);
        title.setCellValueFactory(
                new PropertyValueFactory<ToDo, String>("Title"));
 
        TableColumn priority = new TableColumn("Priority");
        priority.setMinWidth(100);
        priority.setCellValueFactory(
                new PropertyValueFactory<ToDo, String>("Priority"));
 
        
        data = FXCollections.observableArrayList(getTableListView());   
        
        table.setItems(data);
        table.getColumns().addAll(title, priority);
        
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);
	
        table.setRowFactory(tv -> {
            TableRow<ToDo> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (! row.isEmpty() && event.getButton()==MouseButton.PRIMARY 
                     && event.getClickCount() == 2) {

                    ToDo clickedRow = row.getItem();
//        	    	saveYN=false;
        			toDoArray = (ArrayList<ToDo>) getToDoSortArray().clone();
        			setToDoElement(row.getIndex());
        			root.setCenter(getCenterPane(getToDoSortArray().get(row.getIndex())));
               }
            });
            return row ;
        });
        
		return vbox;
	}

	
	public void getChangeCenterListView(BorderPane root){
		list.setOnMouseClicked(e->{
//			toDoArray = (ArrayList<ToDo>) getToDoSortArray().clone();
//	    	saveYN=false;
	    	
	    	System.out.println("element:"+getToDoElement());
			toDoArray = (ArrayList<ToDo>) getToDoSortArray().clone();
			setToDoElement(list.getSelectionModel().getSelectedIndex());
	    	
	    	root.setCenter(getCenterPane(getToDoSortArray().get(list.getSelectionModel().getSelectedIndex())));
	    	
	    });
	    	

	}

	
	
}
