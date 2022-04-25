package handler;

import controlleur.PLYController;
import javafx.event.EventHandler;
import javafx.scene.input.ScrollEvent;
/**
 * CanvasScrollMouse permet de zoomer et dézoomer avec la molette de la souris
 * @author colin
 *
 */
public class CanvasScrollMouse implements EventHandler<ScrollEvent> {

	private final PLYController ctr;

	public CanvasScrollMouse(PLYController ctr) {
		this.ctr = ctr;
	}
	
	/*On récupère la valeur du défilement de la molette grâce à getDeltaY()
	 * Si on veut dézoomer :
	 * Alors la valeur sera supérieure à 0 et inversement
	 */
	@Override
	public void handle(ScrollEvent e) {
		double moletteRotation = e.getDeltaY();
		if(moletteRotation > 0) {
			ctr.zoomScroll(1.07);
		}
		else {
			ctr.zoomScroll(0.93);
		}
	}
}