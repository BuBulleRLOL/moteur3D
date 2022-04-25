package moteur;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MatriceTest {
	Point p;
	Matrice point;
	Matrice m;
	Matrice n;
	Matrice o;
	Matrice pa;
	Matrice poin;
	Matrice resultat;
	Matrice resultat1;
	Matrice resultat2;
	Matrice resultat3;
	Matrice resultatTranslation;
	
	
	@BeforeEach
	public void init() {
		p = new Point(3, 2, 5);
		double[][] d = new double[][] {{3},
							{2},
							{5},
							{1}};
							
		double[][] d1 = new double[][] {{5,0},
							 {0,3}};
							 
		double[][] d2 = new double[][] {{3,2},
							 {5,1}};
							 
		double[][] d3 = new double[][] {{6,8}};
							 
		double[][] d4 = new double[][] {{4},
							 {2}};
		double[][] dresultat = new double[][] {{15,6},{25,3}};
		double[][] dresultat1 = new double[][] {{46,0},{72,0}};
		double[][] dresultat2 = new double[][] {{30,18},{40,24}};
		double[][] dresultat3 = new double[][] {{32,12},{16,6}};
		double[][] dresultattranslation = new double[][] {{5},{3},{5},{1}};
		point = new Matrice(p);
		poin = new Matrice(d);
		m = new Matrice(d1);
		n = new Matrice(d2);
		o = new Matrice(d3);
		pa = new Matrice(d4);
		resultat = new Matrice(dresultat);
		resultat1 = new Matrice(dresultat1);
		resultat2 = new Matrice(dresultat2);
		resultat3 = new Matrice(dresultat3);
		resultatTranslation = new Matrice(dresultattranslation);
	}
	
	@Test
	public void matriceTest() {
		Assert.assertTrue(Arrays.deepEquals(point.getValues(), poin.getValues()));
	}
	/*		
	@Test
	public void MatriceMultiplication() {
		//System.out.println("n = " + n.toString());
		//System.out.println("m = " + m.toString());
		Assert.assertTrue(Arrays.deepEquals(resultat.getValues(), n.calculMatriciel(m).getValues()));
	}
	
	@Test
		public void MatriceMultiplicationPasMêmeTaille() {
		Assert.assertTrue(Arrays.deepEquals(resultat1.getValues(), n.calculMatriciel(o).getValues()));
		Assert.assertTrue(Arrays.deepEquals(resultat2.getValues(), m.calculMatriciel(o).getValues()));
		Assert.assertTrue(Arrays.deepEquals(resultat3.getValues(), n.calculMatriciel(pa).getValues()));
	}
	*/
	@Test
	public void translationTest() {
		Assert.assertTrue(Arrays.deepEquals(resultatTranslation.getValues(), poin.translation(2, 1, 0).getValues()));
		resultatTranslation.setMatriceThis(new double[][] {{5.12},{9.67},{9},{1}});
		Assert.assertTrue(Arrays.deepEquals(resultatTranslation.getValues(), poin.translation(2, 1, 0).getValues()));
		
		Assert.assertTrue(Arrays.deepEquals(resultatTranslation.getValues(), poin.translation(2, 1, 0).getValues()));
		
		Assert.assertTrue(Arrays.deepEquals(resultatTranslation.getValues(), poin.translation(2, 1, 0).getValues()));
		
	}
}