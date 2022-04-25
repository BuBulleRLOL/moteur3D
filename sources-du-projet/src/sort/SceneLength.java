package sort;

import java.awt.Dimension;
/**
 * Permet d'avoir la taille de l'écran de l'utilisateur 
 * @author colin
 *
 */
public class SceneLength {
	
	/*R�cup�ration de la taille de l'�cran de l'utilisateur
	 * On essaye d'adapter la fen�tre a un taille "agr�able" d'o� les 0.80
	 */
	Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	private final double widthSize = screenSize.getWidth() * 0.80;
	private final double heightSize = screenSize.getHeight() * 0.80;
	
	public double getWIDTHSCENE() {
		return widthSize;
	}
	
	public double getHEIGHTSCENE() {
		return heightSize;
	}
}