package sort;

import java.util.Random;

import com.sun.prism.paint.Color;

/**
 * StrokeAndFill Permet de savoir si les boutons btnSegments et btnFaces de PLYController ont été actionné 
 * @author colin
 *
 */
public class StrokeAndFill {

	private boolean filling = true;
	private boolean stroking = true;
	private boolean crazy = false;
	private boolean shadow = false;
	private int rouge;
	private int bleu;
	private int vert;
	private String colFace;
	String hexColor = String.format("#%06X", (0xFFFFFF & 00255000));
	public StrokeAndFill() {
		super();
		rouge=16;
		vert=255;
		bleu=255;	
		// colFace=Integer.toHexString(getRouge())+Integer.toHexString(getVert())+Integer.toHexString(getBleu());
		colFace = "FF11FF"; 
		this.filling = true;
		this.stroking = true;
		//this.colFace = "00FF00";
	}
	
	
	
	public boolean isShadow() {
		return shadow;
	}

	public void setShadow(boolean shadow) {
		this.shadow = shadow;
	}
	
	public String getGrazyColor() {
		Random r = new Random();
		String crazy = "";
		for(int id = 0; id < 6; id++) {
	       crazy = crazy+ r.nextInt(9); // ne pas depasser 9 pour ne pasavoir de couleur trop foncer (si voulu, a regler pour recevoir de l'hexa)
		}
		return crazy;
	}
	
	public boolean isCrazy() {
		return crazy;
	}

	public void setCrazy(boolean crazy) {
		this.crazy = crazy;
	}

	public String getHexColor() {
		return hexColor;
	}

	public boolean isFilling() {
		return filling;
	}
	public void setFilling(boolean filling) {
		this.filling = filling;
	}
	public boolean isStroking() {
		return stroking;
	}
	public void setStroking(boolean stroking) {
		this.stroking = stroking;
	}
	
	public String getColFace() {
		return colFace;
	}
	public void setColFace(String colFace) {
		this.colFace=colFace;
	}


	public int getRouge() {
		return rouge;
	}


	public void setRouge(int d) {
		this.rouge = d;
	}


	public int getBleu() {
		return bleu;
	}


	public void setBleu(int d) {
		this.bleu = d;
	}


	public int getVert() {
		return vert;
	}


	public void setVert(int d) {
		this.vert = d;
	}


	public void setHexColor(String hexColor) {
		this.hexColor = hexColor;
	}
		
}
