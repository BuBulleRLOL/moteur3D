package handler;

import controlleur.PLYController;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
/**
 * CanvasDraggedHandler fait le différenciel entre les coordonnées de la souris actuel et celles au moment ou le bouton de la souris a été pressé (voir CanvasDragHandler)
 * @author colin
 *
 */
public class CanvasDraggedHandler implements EventHandler<MouseEvent> {

	private final PLYController controller;

	private final CanvasMouseData mouseData;
	/**
	 * Constructeur de la classe prend en paramètre notre controller et les coordonnées de la souris
	 * @param controller
	 * @param mouseData
	 */
	public CanvasDraggedHandler(PLYController controller, CanvasMouseData mouseData) {
		this.controller = controller;
		this.mouseData = mouseData;
	}

	@Override
	public void handle(MouseEvent event) {
		if(event.isPrimaryButtonDown()) {
			return;
		}
		else if(event.isSecondaryButtonDown()) {
			double differenceInX = event.getX() - mouseData.getMouseX();
			double differenceInY = event.getY() - mouseData.getMouseY();
			controller.translation(differenceInX, differenceInY);
		}
	}

}
