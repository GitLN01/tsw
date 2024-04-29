package artikal;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ProdavnicaDodajArtikalParameterizedTest {

	private Artikal artikal;
	private Prodavnica prodavnica;
	@Parameters
	public static Collection<Object[]> lista(){
		return Arrays.asList(new Object[][] {
			{new Artikal("Artikal", 100,10)},
			{new Artikal("Artikal", 100,10)},
			{new Artikal("Artikal", 100,10)},
			{new Artikal("Artikal", 200,20)}	
		});
	}
	
	@Before
	public void testProveraOperativnogSistema() {
	    Assume.assumeTrue(System.getProperty("os.name").contains("Windows"));
	}
	public ProdavnicaDodajArtikalParameterizedTest(Artikal artikal) {
		this.artikal=artikal;
	}
	
	@Before
	public void init() {
		prodavnica=new Prodavnica();
		
	}
	@Rule
	public final ErrorCollector ec=new ErrorCollector();
	
	@Rule
	public final TestRule timeout=Timeout.seconds(5);
	
	
	@Test(expected=NullPointerException.class)
	public void dodajArtikalTest() {
		artikal=null;
		prodavnica.dodajArtikal(artikal);
	}
	
	@Test(expected=RuntimeException.class)
	public void dodajArtikalTest2() {
		prodavnica.dodajArtikal(artikal);
		prodavnica.dodajArtikal(artikal);
	}
	
	
	@Test
	public void dodajArtikalTest3() {
		assertFalse(prodavnica.lista.contains(artikal));
		prodavnica.dodajArtikal(artikal);
		assertTrue(prodavnica.lista.contains(artikal));
	}
	
	
}
