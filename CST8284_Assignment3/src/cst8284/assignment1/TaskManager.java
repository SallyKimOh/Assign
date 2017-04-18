package cst8284.assignment1;
/**
 * This class manages ToDo object that is adding ToDo objects and removing ToDo objects.
 * Also Task displays sequential ToDo List and can change order of ToDo
 * @fileName TaskManger.java
 * @author Saeil Kim 040845408
 * @course CST8284
 * @section 300
 * @assignment Assignment3
 * @version 3.0
 * @date 2017.04.17
 * @professor David Houtman
 * @purpose Managine ToDo object for displaying Task and Editing and removing Objects
 * @Create_User David Houtman
 * @Create_date 2017. 03.
 * @Modify_User Saeil Kim
 * @Modify_date 2017. 04. 17.
 * @see java.io.File
 * @see java.time
 * @see javafx.animation
 * @see javafx.application.Application
 * @see javafx.application.Platform
 * @see javafx.collections.FXCollections
 * @see javafx.collections.ObservableList
 * @see javafx.geometry.Insets
 * @see javafx.geometry.Pos
 * @see javafx.scene.Group
 * @see javafx.scene.Node
 * @see javafx.scene.Scene
 * @see javafx.scene.control
 * @see javafx.scene.effect.DropShadow;
 * @see javafx.scene.input.MouseButton;
 * @see javafx.scene.layout
 * @see javafx.scene.paint.Color
 * @see javafx.scene.shape
 * @see javafx.scene.text.Font
 * @see javafx.scene.text.Text
 * @see javafx.stage.FileChooser
 * @see javafx.stage.Stage
 * @see javafx.util.Duration
 */


import java.io.File;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
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
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TaskManager extends Application {

	/**
	 * The toDoArray is ArrayList of ToDo
	 */
	private ArrayList<ToDo> toDoArray;
	/**
	 * The currentToDoElement is currentElement index that is number
	 */
	private static int currentToDoElement;
	/**
	 * The primaryStage is Stage for JavaFx
	 */
	private Stage primaryStage;
	/**
	 * The fc is FileChooser property for standard platform file dialogs
	 */
	private FileChooser fc = new FileChooser();
	/**
	 * The tempTitle and tempDueDate are a TextField for new adding elements of Title and DueDate
	 */
	private TextField tempTitle,tempDueDate;
	/**
	 * The tempSubject is a TextArea for new adding new element of Subject
	 */
	private TextArea tempSubject;
	/**
	 * The tempPriority is a RadioButton value for new adding new element of Priority
	 */
	private RadioButton tempPriority;
	/**
	 * The priority is a number that is a current priority value.
	 */
	private int priority;
	/**
	 * The tempDate is a DueDate. It uses DatePicker.
	 */
	private DatePicker tempDate;
	/**
	 * The tempGroup is a ToggleGroup that supports new element of Grouping for new priorities elements
	 */
	private ToggleGroup tempGroup;
	/**
	 * The list is a ListView<String> property that will display ObservableList.
	 */
	private ListView<String> list = new ListView<String>();
	/**
	 * The objItem is a ObservableList<String> that will be make new Array of String
	 */
	private ObservableList<String> objItem;
	/**
	 * The toDoSortArray is a ArrayList of ToDo that will be worked for sorting of ArrayList of ToDo
	 */
	private ArrayList<ToDo> toDoSortArray = new ArrayList<ToDo>();
	/**
	 * The table is a property of TableView<ToDo> that will be display ObservableList<ToDo>
	 */
    private TableView<ToDo> table = new TableView<ToDo>();
    /**
     * The data is a property of ObservableList for TableView
     */
    private ObservableList<ToDo> data;    

    /**
     * JavaFX creates an application thread for running the application start method, processing input events
     * @param primaryStage Stage
     */
	@Override
	public void start(Stage primaryStage) {
		setPrimaryStage(primaryStage);
		primaryStage.setTitle("To Do List");
		primaryStage.setScene(getSplashScene());
		primaryStage.show();
		primaryStage.setOnCloseRequest(e -> getBackUpFile());        
		
	}

	/**
	 * Creating a backup file from original the original file and exit
	 * @param nothing
	 */
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

	/**
	 * Before exit checking that original files change or not without saving.
	 * If that is not save, this method provides saving that objects
	 */
	public void getBackUpFile(){
		isToDoArrayListDirty();
        System.out.println("Stage is closing");
        
        if (fc.getInitialFileName()!=null) {
        saveCenterPaneContents2ToDo("Y");
        }
     	Platform.exit();
		
	}
	
	
	/**
	 * This method provides default scene when JavaFx launches
	 * @param defaultText Text default scene displays text message. That defaultText will be displayed on the default Scene
	 * @return Scene 
	 */
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


	/**
	 * This method displays animation when JavaFx launches first-time
	 * @return Scene
	 */
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

	/**
	 * This method is working animation for default scene that is getSplashScene
	 * This method provides 3 animations (i.e FadeTransition, ParallelTransition, PathTransition
	 * @return Node
	 */
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

    
    /**
     * This method provides open window dialog box for choosing file using filechooser
     * Also this checks the file extension such as .todo file.
     * Intaking ToDo array for displaying in to the task.
     */
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
		
	    if (FileUtils.fileExists(todoFile) && todoFile.getName().endsWith(".todo")) {
	    	
			ArrayList<ToDo> tdRawArray = fUtils.getToDoArray(FileUtils.getAbsPath(todoFile));
			ArrayList<ToDo> tdCompactArray = getToDoArrayWithoutEmpties(tdRawArray);

			setToDoArray(tdCompactArray);
			toDoSortArray = new ArrayList<ToDo>();
			
			
			getToDoArray().forEach(item->toDoSortArray.add(item));
			
			setToDoElement(0);

			fc.setInitialFileName(todoFile.getAbsolutePath());

			isToDoArrayListDirty();			
			getPrimaryStage().setScene(getToDoScene(getToDoArray().get(getToDoElement())));
	    	
	    } else {
	
	    	String msg = "No File Name Entered. Do you wish exit(OK) or continue (Cancel)?";
	    	String titleMsg ="No File Name Entered.";
	    	
	    	Alert alert = new Alert(AlertType.CONFIRMATION);
	    	if (FileUtils.fileExists(todoFile) && (!todoFile.getName().endsWith(".todo"))) {
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

	/**
	 * This method provides saving function. 
	 * When new arrays add or remove or change, the ToDo object will be saved
	 */
	public void getSave() {
		
		isToDoArrayListDirty();
		saveCenterPaneContents2ToDo(null);		
		
	}

	/**
	 * This method creates new array for adding new Object.
	 * That creates empty data in to the new ToDo Object.
	 */
	public void getAdd() {
		getToDoArray().add(new ToDo());
		setToDoArray(getToDoArray());
		setToDoElement(getToDoArray().size()-1);
		
		System.out.println("nowEle:"+getToDoElement());
		getPrimaryStage().setScene(getToDoScene(getToDoArray().get(getToDoElement())));
	}


	/**
	 * This method removes a ToDo Object from ToDo arrayList.
	 * This shows confirming alarm before delete
	 * 
	 */
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
//    			new FileUtils();
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
//		} else if (getToDoElement() == 0) {
		} else if (getToDoArray().size() < 1) {
			Platform.exit();
		} 

//		if (getToDoArray().size() < 1) Platform.exit();
//		setToDoElement(0);
		
		
		getPrimaryStage().setScene(getToDoScene(getToDoArray().get(getToDoElement())));
		
	}

	
	
	/**
	 * This method provides saving Object when the ToDo Object changes, add and remove)
	 * when data and ArrayList are not same with original ArrayList or data objects, this method will be worked for saving and changing Objects
	 * When file is dirty, this method is working for saving and removing dirty situation of the file
	 * @param btnTypeYN  checking new Scene open or not (when btnTypeYn is null, new Scene will be opened)
	 */
	public void saveCenterPaneContents2ToDo(String btnTypeYN){
		ToDo tdTemp = new ToDo();
		tdTemp.setCompleted(false);
		tdTemp.setEmpty(false);
		tdTemp.setRemove(true);
		
		System.out.println("beforeSave:"+getToDoElement());
		tdTemp = toDoArray.get(getToDoElement());
		
		tdTemp.setTitle(toDoArray.get(getToDoElement()).getTitle());
		tdTemp.setSubject(toDoArray.get(getToDoElement()).getSubject());
		tdTemp.setDueDate(toDoArray.get(getToDoElement()).getDueDate());
		tdTemp.setPriority(toDoArray.get(getToDoElement()).getPriority());
		
		Boolean flag = false;

		flag = equalValidation(tdTemp);
		
		if (flag) {
			
	    	Alert alert = new Alert(AlertType.CONFIRMATION);
	    	alert.setTitle("Save");
	    	alert.setHeaderText(null);
	    	alert.setContentText("Do you wish to save (OK) or cancel (Cancel)?");
	    	Optional<ButtonType> result = alert.showAndWait();
	    	if (result.get() == ButtonType.OK){
		
				tdTemp.setTitle(getTempTitle().getText());
				tdTemp.setSubject(getTempSubject().getText());
				try {
					if (getTempGroup().hasProperties()) 
						tdTemp.setPriority(Integer.parseInt(getTempGroup().getSelectedToggle().getUserData().toString()));
				} catch (Exception e) {
					tdTemp.setPriority(1);	//setting default 1
				}
				
//				tdTemp.setPriority(Integer.parseInt(getTempGroup().getSelectedToggle().getUserData().toString()));
				Date date = new Date();
				date = Date.from(getTempDate().getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
				
				tdTemp.setDueDate(date);
				
				new FileUtils().setToDoArrayListToFile(fc.getInitialFileName(),toDoArray);
				getToDoArray().get(getToDoElement()).setRemove(true);
				
				getToDoSortArray().add(getToDoArray().get(getToDoElement()));

				System.out.println("current:"+getToDoElement());
				if (btnTypeYN==null)		
				getPrimaryStage().setScene(getToDoScene(getToDoArray().get(getToDoElement())));
//				setToDoElement(0);	
//				getPrimaryStage().setScene(getToDoScene(getToDoArray().get(getToDoElement())));
	    	} else {
	    		alert.close();
	    	}
	    	
				
		}
	}
	
	/**
	 * This method is validation check that the file is dirty or not
	 * when the ToDo objects are changed, this method notices that file is dirty
	 * Therefore, that file has to save. 
	 * @param tdTemp original ToDo object before change
	 * @return dirty situation
	 */
	public Boolean equalValidation(ToDo tdTemp){

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


	/**
	 * This method is set-up dirty situation of the file
	 */
	public void isToDoArrayListDirty(){

		if (toDoArray!=null) {
			if (getToDoArray().get(getToDoElement()).isRemoveSet())
				getToDoArray().get(getToDoElement()).setRemove(false);
		}

	}
		
	
	/**
	 * Creating Scene with ToDo Object.
	 * This method creates ToDo ArrayObject without empty data.
	 * Thus, the Scene reflects just not empty data, so that can different ArrayList size with original ArrayList of ToDo
	 * @param td ToDo Object for creating new Scene 
	 * @return Scene That reflects ToDo Object
	 */
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
		}
		return (new Scene(getToDoPane(td)));
	}

	/**
	 * This method draws the screen.
	 * The Scene has Top, VBox, HBox, Buttons, Center and so on. 
	 * Everything add into the BorderPane
	 * @param td ToDo Object for displaying 
	 * @return BorderPane
	 */
	public BorderPane getToDoPane(ToDo td) {


		BorderPane rootNode = new BorderPane();

//		VBox vbLeft = new VBox();
//		vbLeft.setMinWidth(120);
//		
//        ScrollPane sp1 = new ScrollPane();
//        
//		BorderPane bp = new BorderPane();
//		bp.setTop(getLeftPane(rootNode));
//		bp.setCenter(list);
//		
//		sp1.setPrefSize(300, 600);
//		sp1.setContent(bp);
//		sp1.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
//		
//		BorderPane bp2 = new BorderPane();
//		bp2.setTop(getRightTablePane(rootNode));
//		bp2.setCenter(getRightPane(rootNode));
//				
		
		getChangeCenterListView(rootNode);		
		
		
		rootNode.setTop(getMenuBar());
//		rootNode.setLeft(list);		//for listview
		rootNode.setLeft(getLeftPane(rootNode));	//tableview
//		rootNode.setLeft(sp1);		//total
//		rootNode.setRight(getRightPane(rooNode));	//listview
		rootNode.setRight(getRightTablePane(rootNode));	//table view
//		rootNode.setRight(bp2);
		rootNode.setBottom(getBottomPane(td, rootNode));
		rootNode.setCenter(getCenterPane(td));
		
		rootNode.setOnMouseClicked(e-> {
		saveCenterPaneContents2ToDo(null);
			
		});
		
		
		return rootNode;
	}

	/**
	 * This method provides mene on the top.
	 * That includes several menus such as Open, Save, Add, Remove, Exit
	 * For using some function to control ToDo Object, this menu has to need this screen for convenience
	 * @return MenuBar
	 */
	public MenuBar getMenuBar(){
		Menu file = new Menu("File");
		
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
	

	/**
	 * This method services CenterPane.
	 * That center displays ToDo Object data
	 * The file was created ToDo ArrayList and this method shows which date exist in to the file. 
	 * @param td  ToDo Object for displaying
	 * @return GridPane
	 */
	
	public GridPane getCenterPane(ToDo td) {

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

	/**
	 * This method locates bottom of screen.
	 * That has four buttons and that buttons will show first, next, before and last ToDo object data.
	 * Therefore, that buttons provide event to show other ToDo Object data.
	 * @param td ToDo Object for getting data
	 * @param root	while pane this buttons will be located
	 * @return HBox
	 */
	public HBox getBottomPane(ToDo td, BorderPane root) {
		
		HBox paneCtlBtns = new HBox(10);
		paneCtlBtns.setStyle("-fx-font: 20px Tahoma; -fx-stroke: black; -fx-stroke-width: 1;");
		paneCtlBtns.setAlignment(Pos.CENTER);
		paneCtlBtns.setPadding(new Insets(30));
		
		Button btnFirst = new Button("\u23ee"); // btnFirst.setMinSize(80, 80);
		Button btnBack = new Button("\u23ea"); // btnBack.setMinSize(80, 80);
		Button btnNext = new Button("\u23e9"); // btnNext.setMinSize(80, 80);
		Button btnLast = new Button("\u23ed"); // btnLast.setMinSize(80, 80);

		btnFirst.setOnAction(e -> {
			isToDoArrayListDirty();
			saveCenterPaneContents2ToDo(null);		
			
			setToDoElement(0);
			btnBack.fire();
		});
			
		btnBack.setOnAction(e -> {
			int toDoElement = getToDoElement();
			if (getToDoElement() != 0) {
				isToDoArrayListDirty();
				saveCenterPaneContents2ToDo(null);		
			}
			
			setToDoElement(toDoElement <=0 ? 0 : --toDoElement);
			btnFirst.setDisable(getToDoElement()==0); 
			btnBack.setDisable(getToDoElement()==0);
			btnNext.setDisable(getToDoElement()==getToDoArray().size()-1);
			btnLast.setDisable(getToDoElement()==getToDoArray().size()-1);
			
			root.setCenter(getCenterPane(getToDoArray().get(getToDoElement())));
		});
		

		btnNext.setOnAction(e -> {
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
			isToDoArrayListDirty();
			saveCenterPaneContents2ToDo(null);		
			setToDoElement(getToDoArray().size()-1);

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


	/**
	 * This method creates new ArrayList to omit empty data
	 * Some ToDo Objects include empty data, so this method creates new ToDo ArrayList for existing data.
	 * This method will show to display not empty data into the screen.
	 * @param tdRawAr ToDo ArrayList of original
	 * @return ArrayList<ToDo> This arrayList has not empty data from original ToDo arrayList
	 */
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


	/**
	 * This method provides getting primaryStage
	 * @return Stage
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	/**
	 * This method is set-up primaryStage
	 * @param stage Stage
	 */
	public void setPrimaryStage(Stage stage) {
		this.primaryStage = stage;
	}


	/**
	 * This method provides getting toDoArray
	 * @return ArrayList<ToDo>
	 */
	public ArrayList<ToDo> getToDoArray() {
		return toDoArray;
	}

	/**
	 * This method is set-up ArrayList<ToDo>
	 * @param toDoArray
	 */
	public void setToDoArray(ArrayList<ToDo> toDoArray) {
		this.toDoArray = toDoArray;
	}

	/**
	 * This method is set-up CurrentElementNumber
	 * @param currentElementNumber
	 */
	public static void setToDoElement(int currentElementNumber){
		currentToDoElement = currentElementNumber;
	}
	
	/**
	 * This method provides currentToDoElement
	 * @return int currentToDoElement
	 */
	public static int getToDoElement(){
		return currentToDoElement;
	}
	
	/**
	 * This method provides getting new Title
	 * @return TextField new title
	 */
	public TextField getTempTitle() {
		return tempTitle;
	}

	/**
	 * This method is set-up newTitle
	 * @param tempTitle
	 */
	public void setTempTitle(TextField tempTitle) {
		this.tempTitle = tempTitle;
	}

	/**
	 * This method provides getting new DueDate
	 * @return TextField new DueDate
	 */
	public TextField getTempDueDate() {
		return tempDueDate;
	}

	/**
	 * This method is set-up new DueDate
	 * @param tempDueDate
	 */
	public void setTempDueDate(TextField tempDueDate) {
		this.tempDueDate = tempDueDate;
	}

	/**
	 * This method provides getting new Subject
	 * @return TextArea subject
	 */
	public TextArea getTempSubject() {
		return tempSubject;
	}

	/**
	 * This method is set-up new Subject
	 * @param tempSubject
	 */
	public void setTempSubject(TextArea tempSubject) {
		this.tempSubject = tempSubject;
	}

	/**
	 * This method provides getting new priority
	 * @return RadioButton new priority
	 */
	public RadioButton getTempPriority() {
		return tempPriority;
	}

	/**
	 * This method is set-up new priority
	 * @param tempPriority
	 */
	public void setTempPriority(RadioButton tempPriority) {
		this.tempPriority = tempPriority;
	}

	/**
	 * This method provides getting new Date
	 * @return DatePicker new Date
	 */
	public DatePicker getTempDate() {
		return tempDate;
	}

	/**
	 * This method is set-up new DueDate using DatePicker
	 * @param tempDate
	 */
	public void setTempDate(DatePicker tempDate) {
		this.tempDate = tempDate;
	}
	
	/**
	 * This method provides getting priority
	 * @return int priority
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * This method is set-up priority
	 * @param priority
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	/**
	 * This method provides getting new Group of Radio button
	 * @return ToggleGroup new group
	 */
	public ToggleGroup getTempGroup() {
		return tempGroup;
	}

	/**
	 * This method is set-up new Group for RadioButton of priority
	 * @param tempGroup
	 */
	public void setTempGroup(ToggleGroup tempGroup) {
		this.tempGroup = tempGroup;
	}

	/**
	 * Main Method. It will launch of JavaFx
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}


	/**
	 * This method creates new ArrayList<String> for title of ToDo ArrayList.
	 * It creates new ArrayList for sorting. 
	 * @return ArrayList<String>
	 */
	public ArrayList<String> getListTitle(){
		ArrayList<String> arrTitle = new ArrayList<String>();
		getToDoSortArray().forEach(item->arrTitle.add(item.getTitle()));
//		setToDoElement(0);
		
		return arrTitle;
	}

	/**
	 * This method creates new ArrayList<ToD> for tableListView.
	 * This method will be used for sorting
	 * @return ArrayList<ToDo> 
	 */
	public ArrayList<ToDo> getTableListView(){
		ArrayList<ToDo> arrList = new ArrayList<ToDo>();
		getToDoSortArray().forEach(item->arrList.add(item));
//		setToDoArray((ArrayList<ToDo>) getToDoSortArray().clone());
//		setToDoElement(0);
		
//		toDoArray = (ArrayList<ToDo>) getToDoSortArray().clone();
		return arrList;
	}

	
	/**
	 * This method will be display ListView from TitleList of ToDo ArrayList
	 */
	public void getListView(BorderPane root){
		objItem = FXCollections.observableList(getListTitle());
//		setToDoArray((ArrayList<ToDo>) getToDoSortArray().clone());

		list.setItems(objItem);
    	root.setCenter(getCenterPane(getToDoSortArray().get(getToDoElement())));

	}
	
	/**
	 * This method display right pane.
	 * This has several buttons for sorting.
	 * i.e) SortByTitle, SortBySubject, SortByDueDate, SortByPriority, SortByCompleted, Sort Reverse
	 * When the buttons are clicked, left pane will be changed by sorting buttons.
	 * This method is used ListView
	 * @return VBox
	 */
	public VBox getRightPane(BorderPane root){
		VBox vbRight = new VBox(10);
		vbRight.setMinWidth(100);

 
        vbRight.setStyle("-fx-font: 15px Tahoma; -fx-stroke: black; -fx-stroke-width: 1;");
		vbRight.setAlignment(Pos.CENTER);
		vbRight.setPadding(new Insets(50));
        Label label = new Label("ListView Sorting");
        label.setStyle("-fx-font: 20px Tahoma; -fx-text-fill: Blue");
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

    	getListView(root);
    	titleBtn.setOnAction(e-> {
  
    		getToDoSortArray().sort((ToDo td1, ToDo td2) -> 
    		td1.getTitle().toLowerCase().compareTo(td2.getTitle().toLowerCase())
    		);
    		//======= for copy and relocate each arraylist ==============//
			setToDoArray((ArrayList<ToDo>) getToDoSortArray().clone());
			setToDoElement(0);
			//==========================================================//
        	getListView(root);
    		
    	});

    	subjectBtn.setOnAction(e-> {

    		getToDoSortArray().sort((ToDo td1, ToDo td2) -> 
    		td1.getSubject().toLowerCase().compareTo(td2.getSubject().toLowerCase())
    		);
    		//======= for copy and relocate each arraylist ==============//
			setToDoArray((ArrayList<ToDo>) getToDoSortArray().clone());
			setToDoElement(0);
			//==========================================================//
        	getListView(root);
    		
    	});

    	dueBtn.setOnAction(e-> {
    		getToDoSortArray().sort((ToDo td1, ToDo td2) -> 
    		td1.getDueDate().compareTo(td2.getDueDate())
    		);
    		
    		//======= for copy and relocate each arraylist ==============//
			setToDoArray((ArrayList<ToDo>) getToDoSortArray().clone());
			setToDoElement(0);
			//==========================================================//
        	getListView(root);
    	});

    	priBtn.setOnAction(e-> {
    		getToDoSortArray().sort((ToDo td1, ToDo td2) -> 
    		td1.getPriority() - td2.getPriority()
    		);
    		
    		//======= for copy and relocate each arraylist ==============//
			setToDoArray((ArrayList<ToDo>) getToDoSortArray().clone());
			setToDoElement(0);
			//==========================================================//
        	getListView(root);
    		
    	});

    	comBtn.setOnAction(e-> {

    		getToDoSortArray().sort((ToDo td1, ToDo td2) ->
    		Boolean.valueOf(td1.isCompleted()).compareTo(Boolean.valueOf(td2.isCompleted()))
    		);
    		//======= for copy and relocate each arraylist ==============//
			setToDoArray((ArrayList<ToDo>) getToDoSortArray().clone());
			setToDoElement(0);
			//==========================================================//
    		
        	getListView(root);
    		
    	});

    	reverseBtn.setOnAction(e-> {
    		FXCollections.reverse((ObservableList<String>) objItem);
    		//======= for copy and relocate each arraylist ==============//
			setToDoElement(getToDoArray().size()-1);
			//==========================================================//
	    	root.setCenter(getCenterPane(getToDoSortArray().get(getToDoElement())));
    	});
    	
		
    	return vbRight;
	}

	/**
	 * This method display right pane.
	 * This has several buttons for sorting.
	 * i.e) SortByTitle, SortBySubject, SortByDueDate, SortByPriority, SortByCompleted, Sort Reverse
	 * When the buttons are clicked, left pane will be changed by sorting buttons.
	 * This method is used TableView
	 * @return VBox
	 */
	public VBox getRightTablePane(BorderPane root){
		VBox vbRight = new VBox(10);
		vbRight.setMinWidth(100);

		vbRight.setStyle("-fx-font: 15px Tahoma; -fx-stroke: black; -fx-stroke-width: 1;");
		vbRight.setAlignment(Pos.CENTER);
		vbRight.setPadding(new Insets(20));


        Label label = new Label("TableView Sorting");
        label.setStyle("-fx-font: 20px Tahoma; -fx-text-fill: Blue");

        
//    	Button titleBtn = new Button("SortByTitle");
//    	Button subjectBtn = new Button("SortBySubject");
//    	Button dueBtn = new Button("SortByDueDate");
//    	Button priBtn = new Button("SortByPriority");
//    	Button comBtn = new Button("SortByCompleted");
//    	Button reverseBtn = new Button("SortReverse");

    	ToggleButton titleBtn = new ToggleButton("SortByTitle");
    	ToggleButton subjectBtn = new ToggleButton("SortBySubject");
    	ToggleButton dueBtn = new ToggleButton("SortByDueDate");
    	ToggleButton priBtn = new ToggleButton("SortByPriority");
    	ToggleButton comBtn = new ToggleButton("SortByCompleted");
    	ToggleButton reverseBtn = new ToggleButton("SortReverse");

    	ToggleGroup toggleGroup = new ToggleGroup();

    	titleBtn.setToggleGroup(toggleGroup);
    	titleBtn.setUserData("title");
    	subjectBtn.setToggleGroup(toggleGroup);
    	dueBtn.setToggleGroup(toggleGroup);
    	priBtn.setToggleGroup(toggleGroup);   	
    	comBtn.setToggleGroup(toggleGroup);
    	reverseBtn.setToggleGroup(toggleGroup);   	
    	
    	
    	titleBtn.setMaxSize(120, 100);
    	subjectBtn.setMaxSize(120, 100);
    	dueBtn.setMaxSize(120, 100);
    	priBtn.setMaxSize(120, 100);
    	comBtn.setMaxSize(120, 100);
    	reverseBtn.setMaxSize(120, 100);
    	
    	vbRight.getChildren().addAll(label,titleBtn, subjectBtn,dueBtn,priBtn,comBtn,reverseBtn);

    			
    	toggleGroup.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, 
    			Toggle toggle, Toggle new_toggle) -> {
    				
    				titleBtn.setOnAction(e-> {
    		    		  
    		    		getToDoSortArray().sort((ToDo td1, ToDo td2) -> 
    		    		td1.getTitle().toLowerCase().compareTo(td2.getTitle().toLowerCase())
    		    		);
    		 
    		    		data = FXCollections.observableArrayList(getTableListView());
    		    		table.setItems(data);
    		    		//======= for copy and relocate each arraylist ==============//
    					setToDoArray((ArrayList<ToDo>) getToDoSortArray().clone());
    					setToDoElement(0);
    					//==========================================================//
    		    		root.setCenter(getCenterPane(getToDoSortArray().get(getToDoElement())));
    		    	});

    		    	subjectBtn.setOnAction(e-> {

    		    		getToDoSortArray().sort((ToDo td1, ToDo td2) -> 
    		    		td1.getSubject().toLowerCase().compareTo(td2.getSubject().toLowerCase())
    		    		);

    		    		data = FXCollections.observableArrayList(getTableListView());  	
    		    		table.setItems(data);
    		    		//======= for copy and relocate each arraylist ==============//
    					setToDoArray((ArrayList<ToDo>) getToDoSortArray().clone());
    					setToDoElement(0);
    					//==========================================================//
    		    		root.setCenter(getCenterPane(getToDoSortArray().get(getToDoElement())));
    		    	});

    		    	dueBtn.setOnAction(e-> {
    		    		getToDoSortArray().sort((ToDo td1, ToDo td2) -> 
    		    		td1.getDueDate().compareTo(td2.getDueDate())
    		    		);
    		    		
    		    		data = FXCollections.observableArrayList(getTableListView());  	
    		    		table.setItems(data);
    		    		//======= for copy and relocate each arraylist ==============//
    					setToDoArray((ArrayList<ToDo>) getToDoSortArray().clone());
    					setToDoElement(0);
    					//==========================================================//
    		    		root.setCenter(getCenterPane(getToDoSortArray().get(getToDoElement())));
    		    	});

    		    	priBtn.setOnAction(e-> {
    		    		getToDoSortArray().sort((ToDo td1, ToDo td2) -> 
    		    		td1.getPriority() - td2.getPriority()
    		    		);
    		    		
    		    		data = FXCollections.observableArrayList(getTableListView());  	
    		    		table.setItems(data);
    		    		//======= for copy and relocate each arraylist ==============//
    					setToDoArray((ArrayList<ToDo>) getToDoSortArray().clone());
    					setToDoElement(0);
    					//==========================================================//
    		    		root.setCenter(getCenterPane(getToDoSortArray().get(getToDoElement())));
    		    	});

    		    	comBtn.setOnAction(e-> {

    		    		getToDoSortArray().sort((ToDo td1, ToDo td2) ->
    		    		Boolean.valueOf(td1.isCompleted()).compareTo(Boolean.valueOf(td2.isCompleted()))
    		    		);
    		    		
    		    		data = FXCollections.observableArrayList(getTableListView());  	
    		    		table.setItems(data);
    		    		//======= for copy and relocate each arraylist ==============//
    					setToDoArray((ArrayList<ToDo>) getToDoSortArray().clone());
    					setToDoElement(0);
    					//==========================================================//
    		    		root.setCenter(getCenterPane(getToDoSortArray().get(getToDoElement())));
    		    	});

    		    	reverseBtn.setOnAction(e-> {
    		    		FXCollections.reverse((ObservableList<ToDo>) data);
    		    		table.setItems(data);
    		    		toDoSortArray.clear();
    		    		data.forEach(item->toDoSortArray.add(item));
    		    		//======= for copy and relocate each arraylist ==============//
    					setToDoArray((ArrayList<ToDo>) getToDoSortArray().clone());
    					setToDoElement(0);
    					//==========================================================//
    		    		root.setCenter(getCenterPane(getToDoSortArray().get(getToDoElement())));
    		    	});
    		    	
    		    	
    		    	
    				
//    				titleBtn.setOnAction(e-> getToDoSortArray().sort((ToDo td1, ToDo td2) -> td1.getTitle().toLowerCase().compareTo(td2.getTitle().toLowerCase())));
//    		    	subjectBtn.setOnAction(e-> getToDoSortArray().sort((ToDo td1, ToDo td2) -> td1.getSubject().toLowerCase().compareTo(td2.getSubject().toLowerCase())));
//    		    	dueBtn.setOnAction(e-> getToDoSortArray().sort((ToDo td1, ToDo td2) -> td1.getDueDate().compareTo(td2.getDueDate())));
//    		    	priBtn.setOnAction(e-> getToDoSortArray().sort((ToDo td1, ToDo td2) -> td1.getPriority() - td2.getPriority()));
//    		    	comBtn.setOnAction(e-> getToDoSortArray().sort((ToDo td1, ToDo td2) -> Boolean.valueOf(td1.isCompleted()).compareTo(Boolean.valueOf(td2.isCompleted()))));
//    	    		data = FXCollections.observableArrayList(getTableListView());
//    		    	reverseBtn.setOnAction(e-> FXCollections.reverse((ObservableList<ToDo>) data));
//    		    	
//    	    		table.setItems(data);
//    	    		//======= for copy and relocate each arraylist ==============//
//    				setToDoArray((ArrayList<ToDo>) getToDoSortArray().clone());
//    				setToDoElement(0);
//    				//==========================================================//
//    	    		root.setCenter(getCenterPane(getToDoSortArray().get(getToDoElement())));
//    	    		
////    		    	table.setItems(data);
////    		    	//======= for copy and relocate each arraylist ==============//
////    				setToDoElement(getToDoArray().size()-1);
////    				//==========================================================//
////    			    root.setCenter(getCenterPane(getToDoSortArray().get(getToDoElement())));
    	});
    			

/*    	
    	toggleGroup.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, 
    			Toggle toggle, Toggle new_toggle) -> {
    				titleBtn.setOnAction(e-> {
        				System.out.println("TT");
    					
    				});
    				System.out.println("AAAA");
    				if (new_toggle == null)
    					System.out.println("default value");
    				else
    					System.out.println("value==>"+toggleGroup.getSelectedToggle().getUserData());
					System.out.println("value==>"+toggleGroup.getSelectedToggle().getUserData());
        });
    	
*/   

/*    	
    	
    	titleBtn.setOnAction(e-> {
  
    		getToDoSortArray().sort((ToDo td1, ToDo td2) -> 
    		td1.getTitle().toLowerCase().compareTo(td2.getTitle().toLowerCase())
    		);
 
    		data = FXCollections.observableArrayList(getTableListView());
    		table.setItems(data);
    		//======= for copy and relocate each arraylist ==============//
			setToDoArray((ArrayList<ToDo>) getToDoSortArray().clone());
			setToDoElement(0);
			//==========================================================//
    		root.setCenter(getCenterPane(getToDoSortArray().get(getToDoElement())));
    		
    		
    	});

    	subjectBtn.setOnAction(e-> {

    		getToDoSortArray().sort((ToDo td1, ToDo td2) -> 
    		td1.getSubject().toLowerCase().compareTo(td2.getSubject().toLowerCase())
    		);

    		data = FXCollections.observableArrayList(getTableListView());  	
    		table.setItems(data);
    		//======= for copy and relocate each arraylist ==============//
			setToDoArray((ArrayList<ToDo>) getToDoSortArray().clone());
			setToDoElement(0);
			//==========================================================//
	    	root.setCenter(getCenterPane(getToDoSortArray().get(getToDoElement())));
    		
    	});

    	dueBtn.setOnAction(e-> {
    		getToDoSortArray().sort((ToDo td1, ToDo td2) -> 
    		td1.getDueDate().compareTo(td2.getDueDate())
    		);
    		
    		data = FXCollections.observableArrayList(getTableListView());  	
    		table.setItems(data);
    		//======= for copy and relocate each arraylist ==============//
			setToDoArray((ArrayList<ToDo>) getToDoSortArray().clone());
			setToDoElement(0);
			//==========================================================//
	    	root.setCenter(getCenterPane(getToDoSortArray().get(getToDoElement())));
    
    	});

    	priBtn.setOnAction(e-> {
    		getToDoSortArray().sort((ToDo td1, ToDo td2) -> 
    		td1.getPriority() - td2.getPriority()
    		);
    		
    		data = FXCollections.observableArrayList(getTableListView());  	
    		table.setItems(data);
    		//======= for copy and relocate each arraylist ==============//
			setToDoArray((ArrayList<ToDo>) getToDoSortArray().clone());
			setToDoElement(0);
			//==========================================================//
	    	root.setCenter(getCenterPane(getToDoSortArray().get(getToDoElement())));
    	});

    	comBtn.setOnAction(e-> {

    		getToDoSortArray().sort((ToDo td1, ToDo td2) ->
    		Boolean.valueOf(td1.isCompleted()).compareTo(Boolean.valueOf(td2.isCompleted()))
    		);
    		
    		data = FXCollections.observableArrayList(getTableListView());  	
    		table.setItems(data);
    		//======= for copy and relocate each arraylist ==============//
			setToDoArray((ArrayList<ToDo>) getToDoSortArray().clone());
			setToDoElement(0);
			//==========================================================//
	    	root.setCenter(getCenterPane(getToDoSortArray().get(getToDoElement())));
    	});

    	reverseBtn.setOnAction(e-> {
    		FXCollections.reverse((ObservableList<ToDo>) data);
    		table.setItems(data);
    		//======= for copy and relocate each arraylist ==============//
			setToDoElement(getToDoArray().size()-1);
			//==========================================================//
	    	root.setCenter(getCenterPane(getToDoSortArray().get(getToDoElement())));
    	});
*/    	
		
    	return vbRight;
	}
	
	/**
	 * This method provides getting ArrayList of ToDo 
	 * @return ArrayList<ToDo>
	 */
	public ArrayList<ToDo> getToDoSortArray() {
		return toDoSortArray;
	}

	/**
	 * This method is set-up ArrayList of ToDo
	 * @param toDoSortArray
	 */
	public void setToDoSortArray(ArrayList<ToDo> toDoSortArray) {
		this.toDoSortArray = toDoSortArray;
	}
	
	/**
	 * This method displays left pane for Table View
	 * This shows Titles and priorities of ArrayList<ToDo>
	 * @param root BorderPane will add this VBox into the Scene
	 * @return VBox
	 */
	public VBox getLeftPane(BorderPane root) {

        table.getItems().clear();
        table = new TableView<ToDo>();

		final Label label = new Label("Table View");

        label.setStyle("-fx-font: 20px Arial; -fx-text-fill: Blue");
 
        table.setEditable(false);
 
        TableColumn<ToDo, String> title = new TableColumn<ToDo, String>("Title");
        title.setMinWidth(100);
        title.setCellValueFactory(
                new PropertyValueFactory<ToDo, String>("Title"));
 
        TableColumn<ToDo, String> priority = new TableColumn<ToDo, String>("Priority");
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
//        			setToDoArray((ArrayList<ToDo>) getToDoSortArray().clone());
        			setToDoElement(row.getIndex());
        			root.setCenter(getCenterPane(getToDoSortArray().get(row.getIndex())));
               }
            });
            return row ;
        });
        
		return vbox;
	}

	/**
	 * This method displays CenterPane.
	 * When ListView Clicked data, this will reflect center pane to relate on Clicked data
	 * @param root BorderPane for changing new Scene by changing data.
	 */
	public void getChangeCenterListView(BorderPane root){
		list.setOnMouseClicked(e->{
//			toDoArray = (ArrayList<ToDo>) getToDoSortArray().clone();
//			setToDoArray((ArrayList<ToDo>) getToDoSortArray().clone());
			setToDoElement(list.getSelectionModel().getSelectedIndex());
	    	
	    	root.setCenter(getCenterPane(getToDoSortArray().get(list.getSelectionModel().getSelectedIndex())));
	    	
	    });
	    	

	}

	
	
}
