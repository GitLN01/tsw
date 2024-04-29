package Testovi;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import org.junit.After;
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



import hrana.Pecivo;
import hrana.Pekara;
@RunWith(Parameterized.class)
public class TestPronadjiPecivo {
	public Pecivo p;
	public Pekara pe;
	@Rule
	public final TestRule timeout = Timeout.seconds(5);
	@BeforeClass
	public static void proveriOS() {
		Assume.assumeTrue(System.getProperty("os.name").contains("Windows"));
	}
	public TestPronadjiPecivo(Pecivo p) {
		this.p = p;
	}
	@Parameters
	public static Collection<Object[]> lista(){
		return Arrays.asList(new Object[][] {
			{new Pecivo("Djevrek",50,33)},
			{new Pecivo("Djevrek",50,33)},
			{new Pecivo("Djevrek",50,33)},
			{new Pecivo("Djevrek",50,33)},
		});
	}
	@Before
	public void init() {
		pe = new Pekara();
	}
	@Test
	public void testPronadjiPecivo() {
		int cenaPeciva=0;
		pe.pronadjiPecivo(cenaPeciva);
	}
	@Test
	public void testPronadjiPecivo2() {
		assertFalse(pe.lista.contains(p));
		pe.dodajPecivo(p);
		LinkedList<Pecivo> novaLista=new LinkedList<Pecivo>();
		novaLista.add(p);
		assertEquals(novaLista,pe.pronadjiPecivo(50));
		
	}
	@Test
	public void testPronadjiPecivo3() {
		assertFalse(pe.lista.contains(p));
		pe.dodajPecivo(p);
		LinkedList<Pecivo> novaLista=new LinkedList<Pecivo>();
		novaLista.add(p);
		assertNotEquals(novaLista,pe.pronadjiPecivo(80));
		
	}
	
	@After
	public void destroy() {
		pe =null;
	}

}
