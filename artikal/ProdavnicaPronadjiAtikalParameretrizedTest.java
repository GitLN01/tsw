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
import org.junit.*;
@RunWith(Parameterized.class)
public class ProdavnicaPronadjiAtikalParameretrizedTest {

	private Artikal artikal;
	private Prodavnica prodavnica;
	@Before
	public void testProveraOperativnogSistema() {
	    Assume.assumeTrue(System.getProperty("os.name").contains("Windows"));
	}
	public ProdavnicaPronadjiAtikalParameretrizedTest(Artikal artikal) {
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
	
	@Parameters
	public static Collection<Object[]> lista(){
		return Arrays.asList(new Object[][] {
			{new Artikal("Artikal", 100,10)},
			{new Artikal("Artikal", 100,10)},
			{new Artikal("Artikal", 100,10)},
			{new Artikal("Artikal", 200,20)},
			
		});
	}
	
	@Test
	public void pronadjiArtikalTest() {
		 if (artikal.getCena() == 0) {
		        assertNull(prodavnica.pronadjiArtikle(artikal));
		    } else {
		        assertTrue(prodavnica.pronadjiArtikle(artikal).isEmpty());
		    }
		
	}
	
	@Test
	public void pronadjiArtikalTest2() {
		 assertFalse(prodavnica.lista.contains(artikal));
	        prodavnica.dodajArtikal(artikal);
	        LinkedList<Artikal> lista = new LinkedList<>();
	        if (artikal.viseOdJedan()) {
	            lista.add(artikal);
	        }
	        assertEquals(lista, prodavnica.pronadjiArtikle(artikal));
	    }
	
	@Test
	public void pronadjiArtikalTest3()
	{
		assertFalse(prodavnica.lista.contains(artikal));
	    prodavnica.dodajArtikal(artikal);
	    LinkedList<Artikal> lista = new LinkedList<>();
	    lista.add(artikal);
	    assertEquals(lista, prodavnica.pronadjiArtikle(artikal));
    }
}
