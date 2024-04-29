package artikal;

import static org.junit.Assert.*;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

public class ArtikalTest {

	public Artikal artikal;
	@Before
	public void testProveraOperativnogSistema() {
	    Assume.assumeTrue(System.getProperty("os.name").contains("Windows"));
	}
	
	@Rule
	public final TestName name=new TestName();
	
	@Rule
	public final ErrorCollector ec=new ErrorCollector();
	
	@Rule
	public final TestRule timeout=Timeout.seconds(6);
	
	@Before
	public void init() {
		artikal=new Artikal("Artikal", 100,10);
	}
	
	@Test
	public void getCenaTest() {
		int stvarniRezultat=artikal.getCena();
		assertEquals(100,stvarniRezultat);
	}
	
	@Test(expected=RuntimeException.class)
	public void setCenaTest() {
		int stvarniRezultat=artikal.getCena();
		assertEquals(100, stvarniRezultat);
		
		artikal.setCena(-100);
	}
	
	@Test
	public void setCenaTest2() {
		int ocekivaniRezultat=100;
		int stvarniRezultat=artikal.getCena();
		assertEquals(ocekivaniRezultat,stvarniRezultat);
		
		artikal.setCena(200);
		ocekivaniRezultat=200;
		stvarniRezultat=artikal.getCena();
		assertEquals(ocekivaniRezultat,stvarniRezultat);
	}
	
	@Test
	public void getBrojTest() {
		int stvarniRezultat=artikal.getBroj();
		assertEquals(10,stvarniRezultat);
	}
	
	@Test(expected=RuntimeException.class)
	public void setBrojTest() {
		int ocekivaniRezultat=10;
		int stvarniRezultat=artikal.getBroj();
		assertEquals(ocekivaniRezultat,stvarniRezultat);
		
		artikal.setBroj(-100);
	}
	@Test
	public void setCenaTest3() {
		int ocekivaniRezultat=10;
		int stvarniRezultat=artikal.getBroj();
		assertEquals(ocekivaniRezultat,stvarniRezultat);
		
		artikal.setBroj(20);
		ocekivaniRezultat=20;
		stvarniRezultat=artikal.getBroj();
		assertEquals(ocekivaniRezultat,stvarniRezultat);
	}
	
	@Test
	public void getNazivTest() {
		String stvarniRezultat=artikal.getNaziv();
		assertEquals("Artikal",stvarniRezultat);
	}
	
	@Test(expected=RuntimeException.class)
	public void setNazivTest() {
		String ocekivaniRezultat="Artikal";
		String stvarniRezultat=artikal.getNaziv();
		assertEquals(ocekivaniRezultat,stvarniRezultat);
		
		artikal.setNaziv(null);
	}
	
	@Test
	public void setNazivTest2() {
		String ocekivaniRezultat="Artikal";
		String stvarniRezultat=artikal.getNaziv();
		assertEquals(ocekivaniRezultat,stvarniRezultat);
		
		artikal.setNaziv("NoviArtikal");
		ocekivaniRezultat="NoviArtikal";
		stvarniRezultat=artikal.getNaziv();
		assertEquals(ocekivaniRezultat,stvarniRezultat);
	}
	
	@Test 
	public void ukupnaCenaTest() {
		double ocekivaniRezultat=(artikal.getBroj() * artikal.getCena() * 1.18);
		double stvarniRezultat=artikal.ukupnaCena();
		assertEquals(ocekivaniRezultat,stvarniRezultat,0.001);
	}
	
	@Test
	public void toStringTest() {
		String ocekivaniRezultat="Artikal [naziv=" + artikal.getNaziv()+ ", cena =" + artikal.getCena()+ ", broj =" + artikal.getBroj()+ "]";
		String stvarniRezultat=artikal.toString();
		assertEquals(ocekivaniRezultat,stvarniRezultat);
	}
	
	@Test
	public void viseOdJedanTest() {
		artikal.setBroj(1);
		assertFalse(artikal.viseOdJedan());
	}
	
	@Test
	public void viseOdJedanTest2() {
		artikal.setBroj(2);
		assertTrue(artikal.viseOdJedan());
	}
}
