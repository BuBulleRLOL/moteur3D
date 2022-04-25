package handler;
/**
 * Stock les coordonnées x et y de la souris sur l'écran
 * @author colin
 *
 */
public class CanvasMouseData {
	
	private double mouseX;
	private double mouseY;
	
	public CanvasMouseData() {
		mouseX = mouseY = 0D;
	}
	
	public double getMouseX() {
		return mouseX;
	}
	
	public void setMouseX(double mouseX) {
		this.mouseX = mouseX;
	}
	
	public double getMouseY() {
		return mouseY;
	}
	
	public void setMouseY(double mouseY) {
		this.mouseY = mouseY;
	}

}
