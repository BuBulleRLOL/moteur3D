package moteur;

import java.util.logging.Logger;

/**
 * Matrice fait les calculs qui ont besoin d'une matrice pour être effectué
 * @author colin
 *
 */
public class Matrice {
	
	static Logger logger = Logger.getLogger(Matrice.class.getName());
	private int nbLignes;
	private int nbColonnes;
	private double matriceThis[][];

	public void setMatriceThis(double[][] matriceThis) {
		this.matriceThis = matriceThis;
	}

	public Matrice(Point p) {
		this.nbColonnes = 1; 
		this.nbLignes = 4; 
		this.matriceThis = new double[nbLignes][nbColonnes];
		this.matriceThis[0][0] = p.getX();
		this.matriceThis[1][0] = p.getY();
		this.matriceThis[2][0] = p.getZ();
		this.matriceThis[3][0] = 1;
	}
	
	/**
	 * Méthode signant la nouvelles matrice this
	 * @param tabVals
	 */
	public Matrice(double tabVals[][]) {
		this.nbLignes = tabVals.length;
		this.nbColonnes = tabVals[0].length;
		for(int i = 0; i < this.nbLignes; i++) {
			if(tabVals[i].length != this.nbColonnes) {
				throw new IllegalArgumentException("Erreur : Les colonnes doivent avoir la mÃªme longueur.");
			}
		}
		this.matriceThis = tabVals;
	}

	public int getnbLignes() {
		return this.nbLignes;
	}

	public int getnbColonnes() {
		return this.nbColonnes;
	}
	
	/**
	 * Méthode pour récupérer les valeurs de la matrice this
	 * @return
	 */
	public double[][] getValues() {
		return this.matriceThis;
	}
	
	/**
	 * Méthode prennant 2 matrices : la matrice actuelle this et une autre matrice pouvant �tre
	 * une matrice de rotation, translation ou homothétie.
	 * On fait le produit des ces 2 matrices pour obtenir notre nouvelle matrice qui sera la nouvelle matrice this.
	 * @param matrice1
	 * @param matrice2
	 * @return
	 */
	public Matrice calculMatriciel(Matrice matrice1, Matrice matrice2) {
		if(matrice1==null || matrice2==null) {
			logger.fine("Les matrices sont vides");
			return null;
		}
		double tabVals[][];
		int nbl1 = matrice1.getnbLignes();
		int nbl2 = matrice2.getnbLignes();
		int nbc1 = matrice1.getnbColonnes();
		int nbc2 = matrice2.getnbColonnes();
	

		if(nbc1 == nbl2) {
			tabVals = new double[nbl2][nbc2];
		} else {
			throw new IllegalArgumentException("La multiplication est impossible : Les dimensions des 2 matrices sont diffÃ©rentes.");
		}
		for(int i = 0; i < nbl1; i++) {
			for(int j = 0; j < nbc2; j++) {
				//System.out.println("j: "+j);
				tabVals[i][j] = 0;
				for(int k = 0; k < nbc1; k++) {
					//System.out.println("k " +k);
					double valueMat1 = matrice1.getValues()[i][k];
					double valueMat2 = matrice2.getValues()[k][j];
					tabVals[i][j] += valueMat1 * valueMat2;
				}
			}
		}
		Matrice matrice = new Matrice(tabVals);
		return matrice;
	}
	
	/**
	 * Matrice de rotation en X selon l'angle theta et effectuant un
	 * calcul matriciel pour avoir une nouvelle matrice r�pondant aux exigences
	 * thetabis �tant une variable pour �viter de modifier directement le param�tre entrant
	 * @param theta
	 * @return
	 */
	public Matrice rotateX(double theta) {
		double thetabis = theta;
		thetabis = Math.toRadians(thetabis);
		double tabVals[][] = new double[][] {
			{1, 0, 0, 0},
			{0, Math.cos(thetabis), -Math.sin(thetabis), 0},
			{0, Math.sin(thetabis), Math.cos(thetabis), 0},
			{0, 0, 0, 1},
		};
		Matrice matrice = new Matrice(tabVals);
		return calculMatriciel(matrice,this);
	}
    
	/**
	 * Matrice de rotation en Y selon l'angle theta et effectuant un
	 * calcul matriciel pour avoir une nouvelle matrice r�pondant aux exigences
	 * thetabis �tant une variable pour �viter de modifier directement le param�tre entrant
	 * @param theta
	 * @return
	 */
	public Matrice rotateY(double theta) {
		double thetabis = theta;
		thetabis = Math.toRadians(thetabis);
		double tabVals[][] = new double[][] {
			{Math.cos(thetabis), 0, Math.sin(thetabis), 0},
			{0, 1, 0, 0},
			{-Math.sin(thetabis), 0, Math.cos(thetabis), 0},
			{0, 0, 0, 1},
		};
		Matrice matrice = new Matrice(tabVals);
		return calculMatriciel(matrice,this);
	}
    
	/**
	 * Matrice de rotation en Z selon l'angle theta et effectuant un
	 * calcul matriciel pour avoir une nouvelle matrice r�pondant aux exigences
	 * thetabis �tant une variable pour �viter de modifier directement le param�tre entrant
	 * @param theta
	 * @return
	 */
	public Matrice rotateZ(double theta) {
		double thetabis = theta;
		thetabis = Math.toRadians(thetabis);
		double tabVals[][] = new double[][] {
			{Math.cos(thetabis), -Math.sin(thetabis), 0, 0},
			{Math.sin(thetabis), Math.cos(thetabis), 0, 0},
			{0, 0, 1, 0},
			{0, 0, 0, 1},
		};
		Matrice matrice = new Matrice(tabVals);
		return calculMatriciel(matrice,this);
	}
    
	/**
	 * Matrice d'homoth�tie selon le rapport (qui peut �tre la molette ou boutton).
	 * Elle effectue un calcul matriciel pour avoir une nouvelle matrice r�pondant
	 * aux exigences
	 * @param rapport
	 * @return
	 */
	public Matrice homothetie(double rapport) {
		double tabVals[][] = new double[][] {
			{rapport, 0, 0, 0},
			{0, rapport, 0, 0},
			{0, 0, rapport, 0},
			{0, 0, 0, 1}
		};
		Matrice matrice = new Matrice(tabVals);
		return calculMatriciel(matrice,this);
	}
	
	/**
	 * Matrice de translaton selon v1,v2,v3 �tant un vecteur.
	 * Elle effectue un calcul matriciel pour avoir une nouvelle matrice 
	 * r�pondant aux exigences
	 * @param v1
	 * @param v2
	 * @param v3
	 * @return
	 */
	public Matrice translation(double v1, double v2, double v3) {
		double tabVals[][] = new double[][] {
			{1, 0, 0, v1},
			{0, 1, 0, v2},
			{0, 0, 1, v3},
			{0, 0, 0, 1}
		};
		Matrice matrice = new Matrice(tabVals);
		return calculMatriciel(matrice, this);
	}

	public String toString() {
		String res = "";
		for(int i = 0; i < this.nbLignes; i++) {
			for(int j = 0; j < this.nbColonnes; j++) {
				res += this.matriceThis[i][j] + " + ";
			}
			res = res + "\n";
		}
		return res;
	}
}