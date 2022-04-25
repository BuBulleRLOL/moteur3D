package moteur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * Petit test Points
 * @author colin
 *
 */
class PointTest {

	@Test
	void test() {
		Point p = new Point(0, 0, 0);
		p.setX(10);
		p.setY(-5.2);
		p.setZ(127.89);
		assertEquals(10, p.getX());
		assertEquals(-5.2, p.getY());
		assertEquals(127.89, p.getZ());
		assertEquals(10.0, p.getX());
		assertNotEquals(10.00001, p.getX());
		p.setX(p.getX()+100);
		p.setY(p.getY()+5.2);
		assertEquals(110, p.getX());
		assertEquals(0, p.getY());
	}

}
