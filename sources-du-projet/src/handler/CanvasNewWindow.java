package handler;

import controlleur.PLYController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.PLYModel;
import sort.SceneLength;
import view.PLYView;

/**
 * CanvasNewWindow ouvre une nouvelle fenêtre Cette nouvelle fenêtre doit
 * normalement servir à avoir une 2nd vue du ply en question
 * 
 * @author colin
 *
 */
public class CanvasNewWindow implements EventHandler<ActionEvent> {

	private PLYController controller;
	private PLYView view;
	private PLYModel model;

	public CanvasNewWindow() {
		model = new PLYModel();
		controller = new PLYController(model);
		view = new PLYView(controller);
		model.attach(view);
	}

	@Override
	public void handle(ActionEvent event) {
		SceneLength sceneLength = new SceneLength();

		controller.setupDesign(sceneLength.getWIDTHSCENE(), sceneLength.getHEIGHTSCENE());
		Scene scene = new Scene(controller.getPane(), sceneLength.getWIDTHSCENE(), sceneLength.getHEIGHTSCENE());
		Stage newWindow = new Stage();
		newWindow.setTitle("Second Pane");
		newWindow.setScene(scene);

		newWindow.show();

	}

}
