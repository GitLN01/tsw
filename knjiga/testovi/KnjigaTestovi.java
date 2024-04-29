package testovi;

import static org.junit.Assert.*;

import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

import knjiga.Knjiga;

public class KnjigaTestovi {
	
	private Knjiga K;
	
	@BeforeClass
	public static void proveriSistem() {
		Assume.assumeTrue(System.getProperty("os.name").contains("Windows"));
	}
	
	@Rule
	public final TestRule timeout = Timeout.seconds(6);
	
	@Rule
	public final TestName name = new TestName();
	
	@Before
	public void init() {
		K = new Knjiga("Put Kraljeva", 4, 5000);
	}

	@Test
	public void getBrKnjigeTest() {
		assertEquals("getBrKnjigeTest", name.getMethodName());
		
		int ocekivaniRez = 4;
		int stvarniRez = K.getBrKnjiga();
		assertEquals(ocekivaniRez, stvarniRez);
	}
	
	@Test(expected = RuntimeException.class)
	public void setBrKnjigeTest1() {
		assertEquals("setBrKnjigeTest1", name.getMethodName());
		
		int ocekivaniRez = 4;
		int stvarniRez = K.getBrKnjiga();
		assertEquals(ocekivaniRez, stvarniRez);
		K.setBrKnjiga(-5);
	}
	
	@Test
	public void setBrKnjigeTest2() {
		assertEquals("setBrKnjigeTest2", name.getMethodName());
		
		K.setBrKnjiga(10);
		int ocekivaniRez = 10;
		int stvarniRez = K.getBrKnjiga();
		assertEquals(ocekivaniRez, stvarniRez);
	}
	
	@Test
	public void getCenaTest() {
		assertEquals("getCenaTest", name.getMethodName());
		
		int ocekivaniRez = 5000;
		int stvarniRez = K.getCena();
		assertEquals(ocekivaniRez, stvarniRez);
	}
	

	@Test(expected = RuntimeException.class)
	public void setCenaTest1() {
		assertEquals("setCenaTest1", name.getMethodName());
		
		int ocekivaniRez = 5000;
		int stvarniRez = K.getCena();
		assertEquals(ocekivaniRez, stvarniRez);
		K.setCena(-5000);
	}
	
	@Test
	public void setCenaTest2() {
		assertEquals("setCenaTest2", name.getMethodName());
		
		K.setCena(3000);
		int ocekivaniRez = 3000;
		int stvarniRez = K.getCena();
		assertEquals(ocekivaniRez, stvarniRez);
	}
	
	@Test
	public void getNaslovTest() {
		assertEquals("getNaslovTest", name.getMethodName());
		
		String ocekivaniRez="Put Kraljeva";
		String stvarniRez=K.getNaslov();
		assertEquals(ocekivaniRez, stvarniRez);
	}
	
	@Test(expected = RuntimeException.class)
	public void setNaslovTest1() {
		assertEquals("setNaslovTest1", name.getMethodName());
		
		String ocekivaniRez="Put Kraljeva";
		String stvarniRez=K.getNaslov();
		assertEquals(ocekivaniRez, stvarniRez);
		K.setNaslov(null);
	}
	
	@Test
	public void setNaslovTest2() {
		assertEquals("setNaslovTest2", name.getMethodName());
		
		K.setNaslov("Poslednja Zelja");
		String ocekivaniRez="Poslednja Zelja";
		String stvarniRez=K.getNaslov();
		assertEquals(ocekivaniRez, stvarniRez);
	}
	
	@Test
	public void profitTest() {
		assertEquals("profitTest", name.getMethodName());
		
		double ocekivaniRez=(K.getBrKnjiga() * K.getCena())*0.2;
		double stvarniRez=K.profit();
		assertEquals(ocekivaniRez, stvarniRez,0.001);
	}
	
	@Test
	public void maliProfitTest1() {
		assertEquals("maliProfitTest1", name.getMethodName());
		
		assertFalse(K.maliProfit());
	}
	
	@Test
	public void maliProfitTest2() {
		assertEquals("maliProfitTest2", name.getMethodName());
		
		K.setBrKnjiga(1);
		K.setCena(50);
		assertTrue(K.maliProfit());
	}
	
	@Test
	public void toStringTest() {
		assertEquals("toStringTest", name.getMethodName());
		
		String ocekivaniRez="Knjiga [naslov=" + K.getNaslov() + ", brKnjiga=" + K.getBrKnjiga() + ", cena knjige =" + K.getCena() + "]";
		String stvarniRez=K.toString();
		assertEquals(ocekivaniRez, stvarniRez);
	}

}
