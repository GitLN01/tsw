package stan;

import static org.junit.Assert.*;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

public class StanTest {

	public Stan stan;
	@Before
	public void testProveraOperativnogSistema() {
		Assume.assumeTrue(System.getProperty("os.name").contains("Windows"));
	}
	
	@Rule
	public final TestName name=new TestName();
	@Rule 
	public final TestRule timeout=Timeout.seconds(5);
	@Rule
	public final ErrorCollector ec=new ErrorCollector();
	
	@Before
	public void init() {
		stan=new Stan("Adresa",100,1000);
	}
	
	@Test
	public void getKvadraturaTest() {
		assertEquals("getKvadraturaTest", name.getMethodName());
		int ocekivanRezultat=100;
		int stvaranRezultat=stan.getKvdratura();
		try {
		assertEquals(ocekivanRezultat,stvaranRezultat);
		}
		catch(Throwable t) {
			ec.addError(t);
		}
	}
	
	@Test(expected=RuntimeException.class)
	public void setKvadraturaTest() {
		int ocekivanRezultat=100;
		int stvaranRezultat=stan.getKvdratura();
		assertEquals(ocekivanRezultat,stvaranRezultat);
		
		stan.setKvadratura(-1000);
	}
	
	@Test
	public void setKvadraturaTest2() {
		int ocekivanRezultat=100;
		int stvaranRezultat=stan.getKvdratura();
		try {
			assertEquals(ocekivanRezultat,stvaranRezultat);
			}
			catch(Throwable t) {
				ec.addError(t);
			}
		
		stan.setKvadratura(200);
		ocekivanRezultat=200;
		stvaranRezultat=stan.getKvdratura();
		try {
			assertEquals(ocekivanRezultat,stvaranRezultat);
			}
			catch(Throwable t) {
				ec.addError(t);
			}
	}
	
	//CENA PO KVADRATU
	@Test
	public void getCenaPoKvadratuTest() {
		assertEquals("getCenaPoKvadratuTest", name.getMethodName());
		int ocekivanRezultat=1000;
		int stvaranRezultat=stan.getCenaPoKvadratu();
		
		assertEquals(ocekivanRezultat,stvaranRezultat);
		
	}
	
	@Test(expected=RuntimeException.class)
	public void setCenaPoKvadratuTest() {
		int ocekivanRezultat=1000;
		int stvaranRezultat=stan.getCenaPoKvadratu();
		assertEquals(ocekivanRezultat,stvaranRezultat);
		
		stan.setCenaPoKvadratu(-1000);
	}
	
	

	@Test(expected=RuntimeException.class)
	public void setCenaPoKvadratuTest2() {
		int ocekivanRezultat=1000;
		int stvaranRezultat=stan.getCenaPoKvadratu();
		assertEquals(ocekivanRezultat,stvaranRezultat);
		
		stan.setCenaPoKvadratu(6000);
	}
	
	
	@Test
	public void setCenaPoKvadratuTest3() {
		int ocekivanRezultat=1000;
		int stvaranRezultat=stan.getCenaPoKvadratu();
		assertEquals(ocekivanRezultat,stvaranRezultat);
		
		stan.setCenaPoKvadratu(2000);
		ocekivanRezultat=2000;
		stvaranRezultat=stan.getCenaPoKvadratu();
		assertEquals(ocekivanRezultat,stvaranRezultat);
	}
	
	//ADRESA
	@Test
	public void getAdresaTest() {
		assertEquals("getAdresaTest", name.getMethodName());
		String ocekivanRezultat="Adresa";
		String stvaranRezultat=stan.getAdresa();
		
		assertEquals(ocekivanRezultat,stvaranRezultat);
		
	}
	
	@Test(expected=RuntimeException.class)
	public void setAdresaTest() {
		String ocekivanRezultat="Adresa";
		String stvaranRezultat=stan.getAdresa();
		
		assertEquals(ocekivanRezultat,stvaranRezultat);
		stan.setAdresa(null);
	}
	
	@Test
	public void setAdresaTest2() {
		String ocekivanRezultat="Adresa";
		String stvaranRezultat=stan.getAdresa();
		
		assertEquals(ocekivanRezultat,stvaranRezultat);
		stan.setAdresa("NovaAdresa");
		
		ocekivanRezultat="NovaAdresa";
		stvaranRezultat=stan.getAdresa();
		assertEquals(ocekivanRezultat,stvaranRezultat);
	}
	
	@Test
	public void izracunajCenuTest() {
		double ocekivanRezultat=(stan.getKvdratura() *stan.getCenaPoKvadratu());
		double stvaranRezultat=stan.izracunajCenu();
		assertEquals(ocekivanRezultat,stvaranRezultat,0.001);
	}
	
	@Test
	public void toStringTest() {
		String ocekivanRezultat="Stan [adresa=" + stan.getAdresa()+ ", kvadratura=" + stan.getKvdratura() + ", cena po kvadratu=" + stan.getCenaPoKvadratu() + "]";
		String stvaranRezultat=stan.toString();
		assertEquals(ocekivanRezultat,stvaranRezultat);
	}
	
	@Test
	public void povoljanStan() {
		assertFalse(stan.povoljanStan());
	}
	
	@Test
	public void povoljanStan2() {
		stan.setCenaPoKvadratu(0);
		stan.setKvadratura(0);
		assertTrue(stan.povoljanStan());
	}
}
	
	
	
	

