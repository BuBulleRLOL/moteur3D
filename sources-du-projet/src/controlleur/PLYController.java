package controlleur;

import java.util.Timer;
import java.util.TimerTask;

import handler.CanvasDragHandler;
import handler.CanvasDraggedHandler;
import handler.CanvasMouseData;
import handler.CanvasNewWindow;
import handler.CanvasScrollMouse;
import handler.ChooseFileHandler;
import handler.ChooseFileListHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import model.PLYModel;
import sort.SceneLength;
import sort.StrokeAndFill;
import view.OpenFileShow;

/**
 * Controleur du MVC
 * Gère tout le javafx et la dispotion des éléments sur l'AnchorPane
 * @author colin
 *
 */

public class PLYController {

	private static final double LENGTH_LIST = 200;
	private final PLYModel model;
	private boolean rotationAuto = false;
	Timer timer = new Timer();
	
	/**
	 * Variable changeant la couleur du PLY, et rempli ou vide les faces 
	 */
	private StrokeAndFill strokeAndFill = new StrokeAndFill();
	
	private Canvas canvas;
	private Button btnTranslationX = new Button("Right");
	private Button btnTranslationY = new Button("Up");
	private Button btnTranslationMoinsX = new Button("Left");
	private Button btnTranslationMoinsY = new Button("Down");
	private SceneLength sceneLength = new SceneLength();
	private Button btnZoom = new Button("-");
	private Button btnDeZoom = new Button("+");
	private Button btnCenter = new Button("Center");
	private Button btnRotateX = new Button("Rotation en X");
	private Button btnRotateMoinsX = new Button("Rotation en -X");
	private Button btnRotateY = new Button("Rotation en Y");
	private Button btnRotateMoinsY = new Button("Rotation en -Y");
	private Button btnRotateZ = new Button("Rotation en Z");
	private Button btnRotateMoinsZ = new Button("Rotation en -Z");
	public Button autoRotation = new Button("Rotation Automatique");
	private Button newWindow = new Button("Open new Window");
	private Button btnFaces = new Button("Faces");
	private Button btnSegments = new Button("Segments");
	private Button btnCrazy = new Button("Crazy Color");
	private Button btnShadow = new Button("Shadow");
	private Label labelColor = new Label("couleur format : \"FFFFFF\"");
	private TextField textColor = new TextField ();
	private Button submit = new Button("              Colorer              ");
	private Button resetColor = new Button("            Reset Color          ");
	private MenuBar menuBar;
	private TreeView<String> listPLY;
	//private TableView<String> list;

	private AnchorPane pane;
	
	/**
	 * Variable rapportant le nombre de points et de faces à l'utilisateur
	 */
	private Label label;
	
	public StrokeAndFill getStrokeAndFill() {
		return strokeAndFill;
	}

	public void setStrokeAndFill(StrokeAndFill strokeAndFill) {
		this.strokeAndFill = strokeAndFill;
	}
	
	public PLYController(PLYModel model) {
		this.model = model;
	}
	
	/**
	 * 
	 * @param widthScene
	 * @param heightScene
	 * Ajoute les différents éléments de la fenêtre principale
	 */
	public void setupDesign(double widthScene, double heightScene) {
		
		pane = new AnchorPane();
		canvas = new Canvas(widthScene - LENGTH_LIST, heightScene);
		setupEventCanvas();

		listPLY = new TreeView<>();
		listPLY.setRoot(OpenFileShow.getNodesForDirectory());
		listPLY.getSelectionModel().selectedItemProperty().addListener(new ChooseFileListHandler(model));
		label = new Label("Aucune donnée");
		
		setupMenu();

		pane.getChildren().addAll(listPLY, /*list,*/ label, canvas, menuBar,newWindow,autoRotation, btnZoom, btnDeZoom, btnCenter, btnRotateX, btnRotateMoinsX, btnRotateY, btnRotateMoinsY, btnRotateZ, btnRotateMoinsZ, btnTranslationX, btnTranslationMoinsX, btnTranslationY, btnTranslationMoinsY, btnSegments, btnFaces, btnCrazy, btnShadow, labelColor, textColor, submit, resetColor);
		anchorPaneItemsPosition();

	}
	
	/**
	 * Permet de placer le javafx sur l'anchor Pane
	 * Disposition du javafx
	 */
	private void anchorPaneItemsPosition() {

		listPLY.setMaxWidth(LENGTH_LIST);
		//list.setMaxWidth(LENGTH_LIST);
		label.setPrefHeight(pane.getHeight() * 0.1);
		label.setPrefWidth(LENGTH_LIST);
		label.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: " + 2);
		AnchorPane.setBottomAnchor(label, pane.getHeight() * 0.0);
		AnchorPane.setLeftAnchor(canvas, LENGTH_LIST);
		AnchorPane.setLeftAnchor(menuBar, LENGTH_LIST);
		AnchorPane.setRightAnchor(btnZoom, 50.0);
		AnchorPane.setRightAnchor(btnDeZoom, 100.0);
		AnchorPane.setTopAnchor(btnZoom, 35.0);
		AnchorPane.setTopAnchor(btnDeZoom, 35.0);
		AnchorPane.setTopAnchor(btnCenter, 120.0);
		AnchorPane.setRightAnchor(btnCenter, 60.0);
		AnchorPane.setRightAnchor(btnRotateX, 30.0);
		AnchorPane.setRightAnchor(btnRotateMoinsX, 30.0);
		AnchorPane.setRightAnchor(btnRotateY, 30.0);
		AnchorPane.setRightAnchor(btnRotateMoinsY, 30.0);
		AnchorPane.setRightAnchor(btnRotateZ, 30.0);
		AnchorPane.setRightAnchor(btnRotateMoinsZ, 30.0);
		AnchorPane.setTopAnchor(btnRotateX, 210.0);
		AnchorPane.setTopAnchor(btnRotateMoinsX, 240.0);
		AnchorPane.setTopAnchor(btnRotateY, 290.0);
		AnchorPane.setTopAnchor(btnRotateMoinsY, 320.0);
		AnchorPane.setTopAnchor(btnRotateZ, 370.0);
		AnchorPane.setTopAnchor(btnRotateMoinsZ, 400.0);
		AnchorPane.setRightAnchor(btnTranslationX, 30.0);
		AnchorPane.setRightAnchor(btnTranslationMoinsX, 115.0);
		AnchorPane.setRightAnchor(btnTranslationY, 72.5);
		AnchorPane.setRightAnchor(btnTranslationMoinsY, 72.5);
		AnchorPane.setTopAnchor(btnTranslationX, 120.0);
		AnchorPane.setTopAnchor(btnTranslationMoinsX, 120.0);
		AnchorPane.setTopAnchor(btnTranslationY, 90.0);
		AnchorPane.setTopAnchor(btnTranslationMoinsY, 150.0);
		AnchorPane.setTopAnchor(btnFaces, 450.0);
		AnchorPane.setRightAnchor(btnFaces, 30.0);
		AnchorPane.setTopAnchor(btnSegments, 480.0);
		AnchorPane.setRightAnchor(btnSegments, 30.0);
		AnchorPane.setTopAnchor(newWindow, 520.0);
		AnchorPane.setRightAnchor(newWindow, 30.0);
		AnchorPane.setTopAnchor(autoRotation, 560.0);
		AnchorPane.setRightAnchor(autoRotation, 30.0);
		AnchorPane.setTopAnchor(btnCrazy, 600.0);
		AnchorPane.setRightAnchor(btnCrazy, 30.0);
		AnchorPane.setTopAnchor(btnShadow, 640.0);
		AnchorPane.setRightAnchor(btnShadow, 30.0);
		AnchorPane.setTopAnchor(labelColor, 680.0);
		AnchorPane.setRightAnchor(labelColor, 40.0);
		AnchorPane.setTopAnchor(textColor, 700.0);
		AnchorPane.setRightAnchor(textColor, 30.0);
		textColor.setPromptText("FFFFFF");
		textColor.getText();
		AnchorPane.setTopAnchor(submit, 730.0);
		AnchorPane.setRightAnchor(submit, 30.0);
		AnchorPane.setTopAnchor(resetColor, 760.0);
		AnchorPane.setRightAnchor(resetColor, 30.0);
	}

	private void setupMenu() {
		menuBar = new MenuBar();

		Menu fileMenu = new Menu("File");
		MenuItem openFileItem = new MenuItem("Open File");
		fileMenu.getItems().addAll(openFileItem);

		menuBar.getMenus().addAll(fileMenu);

		openFileItem.setOnAction(new ChooseFileHandler(model));
	}
	
	/**
	 * Appelle les méthodes des boutons qui effectue des actions de translation et rotation
	 */
	public void setupEventButton() {
		btnTranslationX.setOnAction(e -> model.translation(30.0, 0));
		btnTranslationY.setOnAction(e -> model.translation(0, -30.0));
		btnTranslationMoinsX.setOnAction(e -> model.translation(-30.0, 0));
		btnTranslationMoinsY.setOnAction(e -> model.translation(0, 30.0));
		btnRotateX.setOnAction(e -> model.rotX(10));
		btnRotateY.setOnAction(e -> model.rotY(10));
		btnRotateZ.setOnAction(e -> model.rotZ(10));
		btnRotateMoinsX.setOnAction(e -> model.rotX(-10));
		btnRotateMoinsY.setOnAction(e -> model.rotY(-10));
		btnRotateMoinsZ.setOnAction(e -> model.rotZ(-10));
		autoRotation.setOnAction(e-> {TimerTask task = new TimerTask() {
			@Override
			public void run() {
				model.rotX(-10);
			}
		};
		if(rotationAuto) {
			timer.cancel();
		} else {
			timer = new Timer();
			timer.schedule(task, 0, 1000);
		}
		this.rotationAuto = !rotationAuto;
		});
		//autoRotation.setOnAction(e -> model.autoRotation());
		newWindow.setOnAction(new CanvasNewWindow());
		btnFaces.setOnAction(e -> model.fillingBoolean(strokeAndFill));
		btnSegments.setOnAction(e -> model.strokingBoolean(strokeAndFill));
		btnCrazy.setOnAction(e -> model.crazyBoolean(strokeAndFill));
		btnShadow.setOnAction(e -> model.shadowBoolean(strokeAndFill));
		submit.setOnAction(e -> model.colorByText(textColor.getText(),strokeAndFill));
		resetColor.setOnAction(e -> model.resetColor(strokeAndFill));
	}
	
	/**
	 * Appelle le model qui effectue le centrage quand bouton pressé
	 */
	public void centerButton() {
		btnCenter.setOnAction(e -> model.center(sceneLength.getWIDTHSCENE(),sceneLength.getHEIGHTSCENE()));
	}
	
	/**
	 * Appelle le model qui effectue le zoom quand bouton pressé
	 */
	public void zoomButton() {
		btnZoom.setOnAction(e -> model.zoom(0.75));
		btnDeZoom.setOnAction(e -> model.zoom(2));
	}
	
	/**
	 * Zoom sur le model en fonction du scroll de la molette de la souris
	 * @param scroll
	 */
	public void zoomScroll(double scroll) {
		model.zoom(scroll);
	}
	
	private void setupEventCanvas() {
		CanvasMouseData mouseData = new CanvasMouseData();
		canvas.setOnDragDetected(new CanvasDragHandler(mouseData));
		canvas.setOnMouseDragged(new CanvasDraggedHandler(this, mouseData));
		canvas.setOnScroll(new CanvasScrollMouse(this));
	}

	public Canvas getCanvas() {
		return canvas;
	}
	
	public void setUpCanvas(Scene scene) {
		canvas = new Canvas(scene.getWidth(), scene.getHeight());
	}
	
	/**
	 * Appelle le model qui effectue la translation
	 * @param difX = translation sur x
	 * @param difY = translation sur Y
	 */
	public void translation(double difX, double difY) {
		model.translation(difX, difY);
	}
	
	/**
	 * Change le text du label 
	 * @param text = les points et les faces du ply
	 */	
	public void setTextLabel(String text) {
		label.setText(text);
	}

	public AnchorPane getPane() {
		return pane;
	}
}