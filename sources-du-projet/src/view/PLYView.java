package view;

import controlleur.PLYController;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
import model.PLYData;
import moteur.Face;
import moteur.Point;
import sort.BarycentreSort;
import sort.Vecteur;
import utils.Observer;
import utils.Subject;
/**
 * Vue du modèle MVC
 * Dessine les ply et reçoit les updates du modèle
 * @author colin
 *
 */
public class PLYView implements Observer {

	private static final String TEMPLATE_LABEL = "Vertex : %d | Faces : %d";
	private final Vecteur lumiere = new Vecteur(1,-1,1);

	private final PLYController controller;
	/**
	 * Barycentre = moyenne en X des points et en Y
	 */
	private final BarycentreSort baryCentre = new BarycentreSort();
	public PLYView(PLYController ctr) {
		this.controller = ctr;
	}

	@Override
	public void update(Subject subj) {
		update(subj, null);
	}


	/**
	 * Update envoyé par le model à  la vue , permet les modifications de la vue
	 */
	@Override
	public void update(Subject subj, Object data) {
		if (!(data instanceof PLYData)) {
			return;
		}
		PLYData plydata = (PLYData) data;
		baryCentre.baryCentre(plydata);
		controller.centerButton();
		controller.zoomButton();
		controller.setupEventButton();
		controller.setTextLabel(String.format(TEMPLATE_LABEL, plydata.points.length, plydata.faces.length));

		drawLines(plydata);
	}
	/**
	 * Relie les faces entre elles et dessinent les segments
	 * @param data = données des points et faces du ply ouvert
	 */
	private void drawLines(PLYData data) {
		if (data == null || data.isEmpty()) {
			return;
		}
		Canvas canvas = controller.getCanvas();
		clearCanvas(canvas);

		GraphicsContext gc = canvas.getGraphicsContext2D();
		Face[] faces = data.getFaces();

		// DEBUT PHASE SHADOW		
		if(controller.getStrokeAndFill().isShadow()){
			gc.setFill(Paint.valueOf("808080"));
			gc.setStroke(Paint.valueOf("808080"));
			for (Face face : faces) {
				Point[] points = face.getPoints();
				if (points.length > 0) {
					gc.beginPath();

					Point initial = points[0];
					gc.lineTo(initial.getX()-300, initial.getY()+300);

					for (int cpt = 1; cpt < points.length; cpt++) {
						Point point = points[cpt];
						gc.lineTo(point.getX()-300, point.getY()+300);
					}
					int indice = 1;
					if (points.length > indice) {
						gc.lineTo(initial.getX()-300, initial.getY()+300);
					}

					gc.closePath();

					if(controller.getStrokeAndFill().isFilling() && controller.getStrokeAndFill().isStroking()) {											
						gc.fill();
						gc.stroke();
					}
					else if(controller.getStrokeAndFill().isFilling()) {
						gc.fill();
					}
					else {						
						gc.stroke();
					}				
				}
			}
		}
		gc.setStroke(Paint.valueOf("000000"));
		// FIN FACE SHADOW
		for (Face face : faces) {
		
			
			// -----------------------------------------------------------------------------------------
			//Cette partie est censé représenté la lumière mais vu que ca ne fonctionne pas elle est commentée
			
			/*double[] vecteurFace = face.vUnitaire();
			double angleCos = vecteurFace[0]*lumière.getX()+vecteurFace[1]*lumière.getY()+vecteurFace[2]*lumière.getZ();
			angleCos=0.192;
			if(Math.acos(angleCos)<90) {
				//ctr.getStrokeAndFill().setRouge((ctr.getStrokeAndFill().getRouge())*angleCos);
				//ctr.getStrokeAndFill().setVert(ctr.getStrokeAndFill().getVert()*angleCos);
				//ctr.getStrokeAndFill().setBleu(ctr.getStrokeAndFill().getBleu()*angleCos);
				ctr.getStrokeAndFill().setColFace(ctr.getStrokeAndFill().getColFace());
			}*/
			
			// -----------------------------------------------------------------------------------------
			
			Point[] points = face.getPoints();
			if (points.length > 0) {
				gc.beginPath();

				Point initial = points[0];
				gc.lineTo(initial.getX(), initial.getY());

				for (int cpt = 1; cpt < points.length; cpt++) {
					Point point = points[cpt];
					gc.lineTo(point.getX(), point.getY());
				}
				int indice = 1;
				if (points.length > indice) {
					gc.lineTo(initial.getX(), initial.getY());
				}

				gc.closePath();

				if(controller.getStrokeAndFill().isFilling() && controller.getStrokeAndFill().isStroking()) {
					if(controller.getStrokeAndFill().isCrazy()) {
						gc.setFill(Paint.valueOf(controller.getStrokeAndFill().getGrazyColor()));
					}	
					else {
						gc.setFill(Paint.valueOf(controller.getStrokeAndFill().getColFace()));
					}
					gc.fill();
					gc.stroke();
				}
				else if(controller.getStrokeAndFill().isFilling()) {
					if(controller.getStrokeAndFill().isCrazy()) {
						gc.setFill(Paint.valueOf(controller.getStrokeAndFill().getGrazyColor()));
					}
					else {
						gc.setFill(Paint.valueOf(controller.getStrokeAndFill().getColFace()));
					}
					gc.fill();
				}
				else {
					gc.stroke();
				}				
			}
		}
	}
	/**
	 * Clear canvas pour afficher un autre ply
	 * @param canvas
	 */
	private void clearCanvas(Canvas canvas) {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
	}

}
