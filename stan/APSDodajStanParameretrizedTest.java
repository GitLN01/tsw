package stan;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;


import org.junit.After;
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
public class APSDodajStanParameretrizedTest {

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
	
	public APSDodajStanParameretrizedTest(Stan stan) {
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
	
	@Test(expected=NullPointerException.class)
	public void dodajStanTest() {
		stan=null;
		aps.dodajStan(stan);
	}
	
	@Test(expected=RuntimeException.class)
	public void dodajStanTest2() {
		aps.dodajStan(stan);
		aps.dodajStan(stan);
	}
	
	@Test
	public void dodajStanTest3() {
		assertFalse(aps.stan.contains(stan));
		aps.dodajStan(stan);
		assertTrue(aps.stan.contains(stan));
		
	}

}
