package sort;

import model.PLYData;
/**
 * Barycentre permettant d'avoir le centre en X et Y de tout les points
 * Peut etre faire Z?
 *
 * @author colin
 *
 */
public class BarycentreSort {
	
	protected double baryCentreX;
	protected double baryCentreY;
	protected String baryCentre;
	public void baryCentre(PLYData data) {
		for(int i=0;i<data.getPoints().length;i++) {
			baryCentreX = baryCentreX+data.getPoints()[i].getX();
			baryCentreY = baryCentreY+data.getPoints()[i].getY();
		}
		baryCentreX = baryCentreX/data.getPoints().length;
		baryCentreY = baryCentreY/data.getPoints().length;
		
		baryCentre=baryCentreX+" "+baryCentreY;
	}
	
	public BarycentreSort(double baryX,double baryY) {
		this.baryCentreX=baryX;
		this.baryCentreY=baryY;
	}
	public BarycentreSort() {
		
	}
	public double getBaryCentreX() {
		return baryCentreX;
	}
	public double getBaryCentreY() {
		return baryCentreY;
	}

	public void setBaryCentreX(double baryCentreX) {
		this.baryCentreX = baryCentreX;
	}

	public void setBaryCentreY(double baryCentreY) {
		this.baryCentreY = baryCentreY;
	}
	
}
