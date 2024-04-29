package Testovi;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import hrana.Pecivo;

public class TestPecivo {
    public Pecivo p;
    @Rule
    public final TestRule timeout = Timeout.seconds(5);
    @BeforeClass
    public static void proveriOS() {
    	Assume.assumeTrue(System.getProperty("os.name").contains("Windows"));
    }
    @Before
    public void init() {
    	p = new Pecivo("Kifla",50,20);
    }
    @Rule
    public final TestName name = new TestName();
    
	@Test
	public void testGetCenaPeciva() {
		assertEquals("testGetCenaPeciva",name.getMethodName());
		int ocekivani = 50;
		int stvarni = p.getCenaPeciva();
		assertEquals(ocekivani,stvarni);
	}

	@Test(expected = RuntimeException.class)
	public void testSetCenaPeciva() {
		assertEquals("testSetCenaPeciva",name.getMethodName());
		int ocekivani = 50;
		int stvarni = p.getCenaPeciva();
		assertEquals(ocekivani,stvarni);
		p.setCenaPeciva(-2);
	}
	@Test
	public void testSetCenaPeciva2() {
		assertEquals("testSetCenaPeciva2",name.getMethodName());
		int ocekivani = 50;
		int stvarni = p.getCenaPeciva();
		assertEquals(ocekivani,stvarni);
		p.setCenaPeciva(2);
	}

	@Test
	public void testGetNazivPeciva() {
		assertEquals("testGetNazivPeciva",name.getMethodName());
		String ocekivani = "Kifla";
		String stvarni = p.getNazivPeciva();
		assertEquals(ocekivani,stvarni);
	}

	@Test(expected = RuntimeException.class)
	public void testSetNazivPeciva() {
		assertEquals("testSetNazivPeciva",name.getMethodName());
		String ocekivani = "Kifla";
		String stvarni = p.getNazivPeciva();
		assertEquals(ocekivani,stvarni);
		p.setNazivPeciva(null);
	}
	@Test
	public void testSetNazivPeciva2() {
		assertEquals("testSetNazivPeciva2",name.getMethodName());
		String ocekivani = "Kifla";
		String stvarni = p.getNazivPeciva();
		assertEquals(ocekivani,stvarni);
		p.setNazivPeciva("Kifla");
	}

	@Test
	public void testGetBrojPeciva() {
		assertEquals("testGetBrojPeciva",name.getMethodName());
		int ocekivani = 20;
		int stvarni = p.getBrojPeciva();
		assertEquals(ocekivani,stvarni);
	}

	@Test(expected = RuntimeException.class)
	public void testSetBrojPeciva() {
		assertEquals("testSetBrojPeciva",name.getMethodName());
		int ocekivani = 20;
		int stvarni = p.getBrojPeciva();
		assertEquals(ocekivani,stvarni);
		p.setBrojPeciva(-2);
	}
	@Test
	public void testSetBrojPeciva2() {
		assertEquals("testSetBrojPeciva2",name.getMethodName());
		int ocekivani = 20;
		int stvarni = p.getBrojPeciva();
		assertEquals(ocekivani,stvarni);
		p.setBrojPeciva(2);
	}
	@Test
	public void testUkupnaCena() {
		double ocekivani = p.getBrojPeciva() * p.getCenaPeciva();
		double stvarni = p.ukupnaCena();
		assertEquals(ocekivani,stvarni,0.001);
	}

	@Test
	public void testViseOdPedeset() {
		assertFalse(p.viseOdPedeset());
	}
	@Test
	public void testViseOdPedeset2() {
		assertFalse(p.viseOdPedeset());
		p.setBrojPeciva(65);
		assertTrue(p.viseOdPedeset());
	}


	@Test
	public void testToString() {
		String ocekivani = "Pecivo [nazivPeciva=" + p.getNazivPeciva() + ", cenaPeciva=" + p.getCenaPeciva() + ", brojPeciva=" + p.getBrojPeciva() + "]";
		String stvarni = p.toString();
		assertEquals(ocekivani,stvarni);
	}

}
