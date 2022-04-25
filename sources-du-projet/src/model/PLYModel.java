package model;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.util.Duration;
import moteur.Matrice;
import moteur.Point;
import sort.BarycentreSort;
import sort.SceneLength;
import sort.StrokeAndFill;
import utils.Subject;
/**
 * PLYModel : MVC
 * Fait les calculs 
 * @author colin
 *
 */
public class PLYModel extends Subject {
	/**
	 * Données du ply chargé
	 */
	private PLYData plyData;
	/**
	 * Paramètre de la scene
	 */
	private final SceneLength SCENELENGTH = new SceneLength();
	/**
	 * Constructeur vide
	 */
	public PLYModel() {
		this(null);
	}
	/**
	 * Constructeur prend en paramètre les données du ply chargé
	 * @param data
	 */
	public PLYModel(PLYData data) {
		super();
		this.plyData = data;
		adjustModel();
	}
	/**
	 * Prend les bonnes données du ply ouvert et le centre
	 * @param data
	 */
	public void setData(PLYData data) {
		this.plyData = data;
		adjustModel();
		notifyWithData();
	}

	/**
	 * Prend en paramètre les coordonées de la souris et modifie les points pour
	 * translater la figure La transition prend en parametre 3 double ici le 3eme
	 * double est Z et est 0
	 * 
	 * @param valeurX = translation sur X
	 * @param valeurY = translation sur Y
	 */
	public void translation(double valeurX, double valeurY) {
		if (plyData.getPoints().length == 0 || plyData.getPoints() == null) {
			return;
		}
		for (Point point : plyData.getPoints()) {
			Matrice matrice = new Matrice(point);
			matrice = matrice.translation(valeurX, valeurY, 0.0);
			point.setX(matrice.getValues()[0][0]);
			point.setY(matrice.getValues()[1][0]);
		}
		notifyWithData();
	}

	/**
	 * Zoom et dézoome
	 * 
	 * @param distanceZoom = ratio du zoom
	 */
	public void zoom(double distanceZoom) {
		for(Point point : plyData.getPoints()) {
			Matrice matrice = new Matrice(point);
			matrice = matrice.homothetie(distanceZoom);
			point.setX(matrice.getValues()[0][0]);
			point.setY(matrice.getValues()[1][0]);
			point.setZ(matrice.getValues()[2][0]);
		}
		center(SCENELENGTH.getWIDTHSCENE(),SCENELENGTH.getHEIGHTSCENE());
		notifyWithData();
	}
	/**
	 * Effectue une rotation des points en X et notifie la vue
	 * De type KeyValue et non void pour essayer de faire fonctionner la rotationAutomatique
	 * @param theta
	 */
	public KeyValue[] rotX(double theta) {
		for(Point point : plyData.getPoints()) {
			Matrice matrice = new Matrice(point);
			matrice = matrice.rotateX(theta);
			point.setX(matrice.getValues()[0][0]);
			point.setY(matrice.getValues()[1][0]);
			point.setZ(matrice.getValues()[2][0]);
		}
		notifyWithData();
		return null;
	}
	/**
	 * Effectue une rotation des points en Y et notifie la vue
	 * @param theta
	 */
	public void rotY(double theta) {
		for(Point point : plyData.getPoints()) {
			Matrice matrice = new Matrice(point);
			matrice = matrice.rotateY(theta);
			point.setX(matrice.getValues()[0][0]);
			point.setY(matrice.getValues()[1][0]);
			point.setZ(matrice.getValues()[2][0]);
		}
		notifyWithData();
	}
	/**
	 * Effectue une rotation des points en Z et notifie la vue
	 * @param theta
	 */
	public void rotZ(double theta) {
		for(Point point : plyData.getPoints()) {
			Matrice matrice = new Matrice(point);
			matrice = matrice.rotateZ(theta);
			point.setX(matrice.getValues()[0][0]);
			point.setY(matrice.getValues()[1][0]);
			point.setZ(matrice.getValues()[2][0]);
		}
		notifyWithData();
	}

	private void notifyWithData() {
		notifyObservers(plyData);
	}
	/**
	 * Centre le ply à l'ouverture
	 */
	private void adjustModel() {
		center(SCENELENGTH.getWIDTHSCENE(),SCENELENGTH.getHEIGHTSCENE());
	}

	/**
	 * Centre le ply au milieu du Canvas
	 * 
	 * @param scenewidth
	 * @param sceneheight
	 */
	public void center(double scenewidth, double sceneheight) {
		if(plyData ==null || plyData.isEmpty()) {
			return;
		}
		BarycentreSort baryCentre = new BarycentreSort();
		baryCentre.baryCentre(plyData);
		double barX = baryCentre.getBaryCentreX();
		double barY = baryCentre.getBaryCentreY();
		baryCentre.setBaryCentreX((scenewidth / 2) - barX);
		baryCentre.setBaryCentreY((sceneheight / 2) - barY);

		translation(baryCentre.getBaryCentreX(), baryCentre.getBaryCentreY());
	}
	/**
	 * Fait tourner la figure sur l'axe X quand le bouton est push
	 * Problème : Le Thread ne permet pas de voir le changement à chaque notifications mais on le voit qu'une fois à la fin (c'est pas ce qu'on veut)
	 * Solution de secours en attendant de réussir le timeLine (CanvasAutoRotation)
	 * Si vous arrivez à le faire fonctionner avec le thread tant mieux
	 * 
	 */
	public void autoRotation() {
		Timeline timeLine = new Timeline();
		timeLine.getKeyFrames().add(new KeyFrame(
				Duration.seconds(2), rotX(-10))
				);
		timeLine.setCycleCount(Timeline.INDEFINITE);

	}
	/**
	 * change la valeur boolean pour l'afichage des faces (oui ou non)
	 * @param strokeAndFill 
	 */
	public void fillingBoolean(StrokeAndFill strokeAndFill) {
		if(strokeAndFill.isFilling()) {
			strokeAndFill.setFilling(false);
		}
		else {
			strokeAndFill.setFilling(true);
		}
		notifyWithData();
	}
	/**
	 * change la valeur boolean pour l'afichage des segments (oui ou non)
	 * @param strokeAndFill 
	 */
	public void strokingBoolean(StrokeAndFill strokeAndFill) {
		if(strokeAndFill.isStroking()) {
			strokeAndFill.setStroking(false);
		}
		else {
			strokeAndFill.setStroking(true);
		}
		notifyWithData();
	}
	/**
	 * change la valeur boolean pour l'afichage des faces en mode crazy color (oui ou non)
	 * @param strokeAndFill 
	 */
	public void crazyBoolean(StrokeAndFill strokeAndFill) {
		if(strokeAndFill.isCrazy()) {
			strokeAndFill.setCrazy(false);
		}
		else {
			strokeAndFill.setCrazy(true);
		}
		notifyWithData();
	}
	/**
	 * change la valeur boolean pour l'afichage de l'ombre(oui ou non)
	 * @param strokeAndFill 
	 */
	public void shadowBoolean(StrokeAndFill strokeAndFill) {
		if(strokeAndFill.isShadow()) {
			strokeAndFill.setShadow(false);
		}
		else {
			strokeAndFill.setShadow(true);
		}
		notifyWithData();
	}
	/**
	 * change la valeur de colFace (couleur d'affichage des faces)
	 * @param strokeAndFill 
	 */
	public void colorByText(String colReq, StrokeAndFill strokeAndFill) {
		if (colReq != null && colReq.length() == 6) {
			boolean valide = true;
			String value = "";
			for(int i = 0; i < 6; i++) {
				if(((int)colReq.charAt(i) >= 48 && (int)colReq.charAt(i) <= 57) || ((int)colReq.charAt(i) >= 65 && (int)colReq.charAt(i) <= 70)) {
					value = value + colReq.charAt(i);
				}
				else {
					valide = false;
				}
			}		
			if(valide) {
				strokeAndFill.setColFace(value);
			}
		}
		notifyWithData();
	}
	/**
	 * change la valeur boolean pour l'afichage de l'ombre(oui ou non)
	 * @param strokeAndFill 
	 */
	public void resetColor(StrokeAndFill strokeAndFill) {
		strokeAndFill.setColFace("FF11FF");
		notifyWithData();
	}
}


