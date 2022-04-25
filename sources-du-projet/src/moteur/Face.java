package moteur;

import java.util.Arrays;
/**
 * Face composé d'une liste de points
 * @author colin
 *
 */
public class Face implements Comparable<Face> {
	
	private final Point[] points;
	private double [] vecteurDirecteur1 = new double[3];
	private double [] vecteurDirecteur2  = new double[3];
	
	public Face(Point[] points) {
		this.points = points;
	}
	
	public double[] getVecteurDirecteur1() {
		return vecteurDirecteur1;
	}

	public void setVecteurDirecteur1(double[] vecteurDirecteur1) {
		this.vecteurDirecteur1 = vecteurDirecteur1;
	}

	public Point[] getPoints() {
		return points;
	}

	public double barycentre() {
		return 0;
	}

	@Override
	public String toString() {
		return  Arrays.toString(points);
	}

	/**
	 * Calcul 2 vecteurs directeur de la face
	 */
	public void vDirecteurFace() {

		 vecteurDirecteur1[0] = points[1].getX()-points[0].getX();
		 vecteurDirecteur1[1] =points[1].getY()-points[0].getY();
		 vecteurDirecteur1[2] =points[1].getZ()-points[0].getZ();
		 vecteurDirecteur2[0] = points[2].getX()-points[0].getX();
		 vecteurDirecteur2[1] =points[2].getY()-points[0].getY();
		 vecteurDirecteur2[2] =points[2].getZ()-points[0].getZ();
				 
			 //{points[1].getX()-points[0].getX(),points[1].getY()-points[0].getY(),points[1].getZ()-points[0].getZ()};
		//double[] vecteurDirecteur2  = {points[2].getX()-points[0].getX(),points[2].getY()-points[0].getY(),points[1].getZ()-points[2].getZ()};
		
	}
	/**
	 * Calcul de la lumière mais non fonctionnel
	 * @return
	 */
	public double[] vUnitaire() {
		double[] v3 = {vecteurDirecteur1[1]*vecteurDirecteur2[2]-vecteurDirecteur1[2]*vecteurDirecteur2[1],vecteurDirecteur1[2]*vecteurDirecteur2[0]-vecteurDirecteur1[0]*vecteurDirecteur2[2],vecteurDirecteur1[0]*vecteurDirecteur2[1]-vecteurDirecteur1[1]*vecteurDirecteur2[0]};
		double v= Math.abs(v3[0]*v3[0])+Math.abs(v3[1]*v3[1])+Math.abs(v3[2]*v3[2]);
		double racine = Math.sqrt(v);
		double[] v4 = {v3[0]*racine,v3[1]*racine,v3[2]*racine};
		return v4;
	}
	
	public double getZMini() {
		double min;
		min = points[0].getZ() + points[1].getZ() + points[2].getZ();
		return min;
	}

	@Override
	public int compareTo(Face o) {
		int res;
		res = Double.compare(this.getZMini(), o.getZMini());
		return res;
	}
}
