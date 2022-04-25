package handler;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
/**
 * Permet de stocker les coordonées de la souris au moment ou l'on veut faire bouger la figure (clique souris pressé)
 * @author colin
 *
 */
public class CanvasDragHandler implements EventHandler<MouseEvent> {
	
	private final CanvasMouseData data;
	
	public CanvasDragHandler(CanvasMouseData data) {
		this.data = data;
	}

	@Override
	public void handle(MouseEvent event) {
		//Clique droit translation
		//Clique gauche rotation
		//Molette pour zoom
		if(event.isPrimaryButtonDown()) {
			return;
		}
		
		else if(event.isSecondaryButtonDown()) {
			data.setMouseX(event.getX());
			data.setMouseY(event.getY());
		}
	}

}
