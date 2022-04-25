package view;
	
import controlleur.PLYController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.PLYModel;
import sort.SceneLength;
/**
 * Lance le projet , main du projet
 * @author colin
 *
 */
public class Affichage extends Application {

	
	@Override
	public void start(Stage stage) {

		
		final SceneLength sceneLength = new SceneLength();
		final PLYModel model = new PLYModel();
		final PLYController ctr = new PLYController(model);
		ctr.setupDesign(sceneLength.getWIDTHSCENE(), sceneLength.getHEIGHTSCENE());
		
		final PLYView view2 = new PLYView(ctr);
		model.attach(view2);
		
		stage.setTitle("Figure 3D");
		Scene scene = new Scene(ctr.getPane(), sceneLength.getWIDTHSCENE(), sceneLength.getHEIGHTSCENE());
		stage.setScene(scene);
		stage.show();
	}
	/**
	 * Méthode qui lance le projet
	 * @param args
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}
}
