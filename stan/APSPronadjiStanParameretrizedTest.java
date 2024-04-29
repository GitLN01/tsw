package stan;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class APSPronadjiStanParameretrizedTest {

	private Stan stan;
	private AgencijaProdajeStanova aps;
	@BeforeClass
	public static void testProveraOperativnogSistema() {
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
		aps=new AgencijaProdajeStanova();
	}
	
	public  APSPronadjiStanParameretrizedTest(Stan stan) {
		this.stan=stan;
	}
	
	@Parameters
	public static Collection<Object[]> stan(){
		return Arrays.asList(new Object[][] {
			{new Stan("Adresa",100,1000)},
			{new Stan("Adresa",100,1000)},
			{new Stan("Adresa",100,1000)},
			{new Stan("Adresa",100,1000)}
		});
	}

	
	@Test
	public void pronadjiStanTest() {
		String adresa=null;
		assertNull(aps.pronadjiStan(adresa));
	}
	
	@Test
	public void pronadjiStanTest2() {
		assertFalse(aps.stan.contains(stan));
		aps.dodajStan(stan);
		LinkedList<Stan> stanovi = new LinkedList<Stan>();
		stanovi.add(stan);
		assertEquals(stanovi, aps.pronadjiStan("Adresa"));
		
	}
	
	@Test
	public void pronadjiStanTest3() {
		assertFalse(aps.stan.contains(stan));
		aps.dodajStan(stan);
		LinkedList<Stan> stanovi = new LinkedList<Stan>();
		stanovi.add(stan);
		assertNotEquals(stanovi, aps.pronadjiStan("Neka druga adresa"));
		
	}
}
