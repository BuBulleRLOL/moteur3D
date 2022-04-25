package sort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.PLYData;
import moteur.Point;

class BarycentreSortTest {
	PLYData plyData;
	Point[] points = new Point[5];
	BarycentreSort baryCentre = new BarycentreSort();	
	double moyenneX=0;
	double moyenneY=0;
	
	@BeforeEach
	public void setUp() {
	
		points[0] = new Point(0, 0, 0);
		points[1] = new Point(-200, -200, 0.5);
		points[2] = new Point(147.54, 2, -14000);
		points[3] = new Point(14, 0, 0);
		points[4] = new Point(0, 14, 0);
		plyData = new PLYData(points, null);
		for(int i=0 ; i<points.length;i++) {
			moyenneX = moyenneX+points[i].getX();
			moyenneY = moyenneY+points[i].getY();
		}
		moyenneX = moyenneX/points.length;
		moyenneY = moyenneY/points.length;
	}

	@Test
	void baryCentreTest() {
		assertNotEquals(null, baryCentre.getBaryCentreX());
		assertNotEquals(null, baryCentre.getBaryCentreY());
		assertEquals(0, baryCentre.getBaryCentreX());
		assertEquals(0, baryCentre.getBaryCentreY());

		baryCentre.baryCentre(plyData);
		assertEquals(-7.692, round(moyenneX,3));
		assertEquals(-36.8, moyenneY);
		assertNotEquals(0, baryCentre.getBaryCentreX());
		assertNotEquals(0, baryCentre.getBaryCentreY());
		assertEquals(moyenneX, baryCentre.getBaryCentreX());
		assertEquals(moyenneY, baryCentre.getBaryCentreY());
		
	}
	/**
	 * Permet d'arrondir à un certain chiffre après la virgule
	 * @param value = la valeur que l'on veut arrondir
	 * @param places = le nombre d'arrondi après la virgule
	 * @return
	 */
	private static double round(double value, int places) {
		
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    double valueToRoundPrint = value;
	    valueToRoundPrint = valueToRoundPrint * factor;
	    long tmp = Math.round(valueToRoundPrint);
	    return (double) tmp / factor;
	}
}