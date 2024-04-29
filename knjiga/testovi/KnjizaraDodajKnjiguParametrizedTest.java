package testovi;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import knjiga.Knjiga;
import knjiga.Knjizara;

@RunWith(Parameterized.class)
public class KnjizaraDodajKnjiguParametrizedTest {
	
	private Knjiga K;
	private Knjizara KN;
	
	@BeforeClass
	public static void proveriSistem() {
		Assume.assumeTrue(System.getProperty("os.name").contains("Windows"));
	}
	
	@Rule
	public final TestRule timeout = Timeout.seconds(6);
	
	public KnjizaraDodajKnjiguParametrizedTest(Knjiga K) {
		this.K=K;
	}
	
	@Parameters
	public static Collection<Object []> knjige() {
		return Arrays.asList(new Object[][]{
			{new Knjiga("Put Kraljeva", 5, 5000)},
			{new Knjiga("Poslednja Zelja", 2, 2000)},
			{new Knjiga("Abeceda", 1, 500)},
			{new Knjiga("Citanka", 4, 1000)}
			
		});
	}
	
	@Before
	public void init() {
		KN = new Knjizara();
	}

	@Test(expected = NullPointerException.class)
	public void dodajKnjiguTest1() {
		K=null;
		KN.dodajKnjigu(K);
		assertNull(KN);
	}
	
	@Test(expected = RuntimeException.class)
	public void dodajKnjiguTest2() {
		KN.dodajKnjigu(K);
		KN.dodajKnjigu(K);
	}
	
	@Test
	public void dodajKnjiguTest3() {
		Knjiga K2 = new Knjiga("Pero", 1, 55);
		KN.dodajKnjigu(K2);
	}
	
	@After
	public void destroy() {
		KN=null;
	}
	

}
