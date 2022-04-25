package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import moteur.Point;
import sort.BarycentreSort;

class PLYModelTest {
	PLYModel m = new PLYModel();
	Point[] points = new Point[5];
	
	@BeforeEach
	public void setUp() {
		
		points[0] = new Point(0, 0, 0);
		points[1] = new Point(-200, -200, 0.5);
		points[2] = new Point(147.54, 2, -14000);
		points[3] = new Point(14, 0, 0);
		points[4] = new Point(0, 14, 0);
		PLYData data = new PLYData(points, null);
		m.setData(data);
	}

	@Test
	void test() {

		assertEquals(0, points[0].getX());
		assertEquals(-200, points[1].getY());
		assertEquals(-200, points[1].getY());
		assertEquals(147.54, points[2].getX());

	}

	@Test
	public void translationTest() {
		m.translation(1.0, 2.0);
		assertEquals(1, points[0].getX());
		assertEquals(148.54, points[2].getX());
		assertEquals(2, points[0].getY());

		m.translation(-5, -2);
		assertEquals(-4, points[0].getX());
		assertEquals(0, points[0].getY());

		m.translation(-2.15, 1.88);
		assertEquals(-6.15, points[0].getX());
		assertEquals(1.88, round(points[0].getY(), 2));
		assertEquals(15.88, round(points[4].getY(), 2));
	}

	@Test
	public void zoomTest() {
		m.zoom(1);
		assertEquals(1, points[0].getX());
		assertEquals(1, points[0].getY());
		assertEquals(148.54, points[2].getX());
		assertEquals(15, points[4].getY());
	}
	
	@Test
	public void centerButton() {
		BarycentreSort b = new BarycentreSort(0,0);
		int scenewidth = 1500;
		int sceneheight = 800;
		m.center(scenewidth, sceneheight);
		assertEquals(0,b.getBaryCentreX());
		assertEquals(0,b.getBaryCentreY());
		assertEquals(750,points[0].getX());
		assertEquals(400,points[0].getY());
	}
	/**
	 * Permet d'arrondir à un certain chiffre après la virgule
	 * @param valueToRound
	 * @param places
	 * @return
	 */
	private static double round(double valueToRound, int places) {
		
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    double valueToRoundPrint = valueToRound;
	    valueToRoundPrint = valueToRoundPrint * factor;
	    long tmp = Math.round(valueToRoundPrint);
	    return (double) tmp / factor;
	}

}
