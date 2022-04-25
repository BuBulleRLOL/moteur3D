package sort;
/**
 * Class Vecteur pour la lumière
 * @author colin
 *
 */
public class Vecteur {

	private double x;
	private double y;
	private double z;
	/**
	 * Vecteur Lumière qui nous permettra en fonction de x , y et z de savoir où se dirige la lumière
	 * 
	 * @param x = coordonnée X sur le plan
	 * @param y	= coordonnée Y sur le plan
	 * @param z	= coordonnée Z sur le plan
	 */
	public Vecteur(double x, double y , double z) {
		this.x=x;
		this.y=y;
		this.z=z;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}
	/**
	 * Permet d'avoir le vecteur unitaire de la lumière
	 * @return
	 */
	public double getParam() {
		double param = x*x+y*y+z*z;
		return Math.sqrt(param);
	}
}
