package moteur;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * Test de Face
 * @author colin
 *
 */
class FaceTest {
	Point p1 = new Point(1,0,0);
	Point p2 = new Point(0,1,0);
	Point p3 = new Point(0,0,1);
	Point[] points = new Point[10];
	Face face1;
	@BeforeEach
	void init() {
		points[0]=p1;
		points[1]=p2;
		points[2]=p3;
		face1 = new Face(points);
	}
	@Test
	public void isEqual() {
		assertEquals(p1, face1.getPoints()[0]);
	}
	@Test
	public void vDirecteurFaceTest() {
		double[] v1 = new double[3];
		v1[0]= p2.getX()-p1.getX();
		v1[1]= 1;
		v1[2]= 0;
		assertEquals(v1[0], face1.getVecteurDirecteur1()[0]);
		assertEquals(v1[0], face1.getVecteurDirecteur1()[1]);
		assertEquals(v1[0], face1.getVecteurDirecteur1()[2]);
	}
}
