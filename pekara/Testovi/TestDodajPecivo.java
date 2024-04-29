package Testovi;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

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
public class TestDodajPecivo {
public Pecivo p;
public Pekara pe;
@Rule
public final TestRule timeout = Timeout.seconds(5);
@BeforeClass
public static void proveriOS() {
	Assume.assumeTrue(System.getProperty("os.name").contains("Windows"));
}
public TestDodajPecivo(Pecivo p) {
	this.p = p;
}

@Parameters
public static Collection<Object[]> lista(){
	return Arrays.asList(new Object[][] {
		{new Pecivo("Kifla",80,20)},
		{new Pecivo("Kifla",80,20)},
		{new Pecivo("Kifla",80,20)},
		{new Pecivo("Kifla",80,20)},
	});
}

@Before
public void init() {
	pe = new Pekara();
}

@Test(expected = NullPointerException.class)
public void testDodajPecivo() {
	p = null;
	pe.dodajPecivo(p);
}
@Test(expected = RuntimeException.class)
public void testDodajPecivo2() {
	
	pe.dodajPecivo(p);
	pe.dodajPecivo(p);
}
@Test
public void testDodajPecivo3() {
	
	assertTrue(pe.lista.contains(p));
}


@After
public void destroy() {
	pe = null;
}
	

}
