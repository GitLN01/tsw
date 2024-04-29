package auto;

import static org.junit.Assert.*;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

public class AutoGumaTest {

	public AutoGuma guma;
	
	@Test
	public void testProveraOperativnogSistema() {
	    Assume.assumeTrue(System.getProperty("os.name").contains("Windows"));
	}
	
	@Before
	public void init() {
		guma=new AutoGuma("Marka",true, 18,140,40);
	}
	
	@Rule
	public final TestRule timeout=Timeout.seconds(5);
	
	@Rule 
	public final ErrorCollector ec=new ErrorCollector();
	
	@Rule
	public final TestName name=new TestName();
	
	@Test
	public void getZimskaTest() {
		assertEquals("getZimskaTest", name.getMethodName());
		boolean stvarniRezultat=guma.getZimska();
		boolean ocekivaniRezultat=true;
		try {
			assertEquals(ocekivaniRezultat,stvarniRezultat);
			}
			catch(Throwable t) {
				ec.addError(t);
			}
	}
	
	@Test
	public void setZimskaTest() {
		boolean ocekivaniRezultat=true;
		boolean stvarniRezultat=guma.getZimska();
		try {
		assertEquals(ocekivaniRezultat,stvarniRezultat);
		}
		catch(Throwable t) {
			ec.addError(t);
		}
		guma.setZimska(false);
		ocekivaniRezultat=false;
		stvarniRezultat=guma.getZimska();
		assertEquals(ocekivaniRezultat,stvarniRezultat);
	}
	
	@Test
	public void getMarkaModelTest() {
		String ocekivaniRezultat="Marka";
		String stvarniRezultat=guma.getMarkaModel();
		try {
			assertEquals(ocekivaniRezultat,stvarniRezultat);
			}
			catch(Throwable t) {
				ec.addError(t);
			}
	}
	
	@Test(expected=RuntimeException.class)
	public void setMarkaModelTest() {
		String ocekivaniRezultat="Marka";
		String stvarniRezultat=guma.getMarkaModel();
		assertEquals(ocekivaniRezultat,stvarniRezultat);
		
		guma.setMarkaModel(null);
	}
	
	@Test(expected=RuntimeException.class)
	public void setMarkaModelTest2() {
		String ocekivaniRezultat="Marka";
		String stvarniRezultat=guma.getMarkaModel();
		assertEquals(ocekivaniRezultat,stvarniRezultat);
		
		guma.setMarkaModel("A1");
	}
	
	@Test
	public void setMarkaModelTest3() {
		String ocekivaniRezultat="Marka";
		String stvarniRezultat=guma.getMarkaModel();
		assertEquals(ocekivaniRezultat,stvarniRezultat);
		
		guma.setMarkaModel("NovaMaraka");
		ocekivaniRezultat="NovaMaraka";
		stvarniRezultat=guma.getMarkaModel();
		assertEquals(ocekivaniRezultat,stvarniRezultat);
	}
	
	@Test
	public void getPrecnikTest()
	{
		int ocekivaniRezultat=18;
		int stvarniRezultat=guma.getPrecnik();
		assertEquals(ocekivaniRezultat,stvarniRezultat);
	}
	
	@Test(expected=RuntimeException.class)
	public void setPrecnikTest() {
		int ocekivaniRezultat=18;
		int stvarniRezultat=guma.getPrecnik();
		assertEquals(ocekivaniRezultat,stvarniRezultat);
		
		guma.setPrecnik(10);
	}
	@Test(expected=RuntimeException.class)
	public void setPrecnikTest2() {
		int ocekivaniRezultat=18;
		int stvarniRezultat=guma.getPrecnik();
		assertEquals(ocekivaniRezultat,stvarniRezultat);
		
		guma.setPrecnik(25);
	}
	
	@Test
	public void setPrecnikTest3() {
		int ocekivaniRezultat=18;
		int stvarniRezultat=guma.getPrecnik();
		try {
			assertEquals(ocekivaniRezultat,stvarniRezultat);
			}
			catch(Throwable t) {
				ec.addError(t);
			}
		guma.setPrecnik(20);;
		ocekivaniRezultat=20;
		stvarniRezultat=guma.getPrecnik();
		try {
			assertEquals(ocekivaniRezultat,stvarniRezultat);
			}
			catch(Throwable t) {
				ec.addError(t);
			}
	}
	
	@Test
	public void getSirinaTest()
	{
		int ocekivaniRezultat=140;
		int stvarniRezultat=guma.getSirina();
		assertEquals(ocekivaniRezultat,stvarniRezultat);
	}
	
	@Rule
	public final ExpectedException exception=ExpectedException.none();
	
	@Test
	public void setSirinaTest() {
		exception.expect(RuntimeException.class);
		exception.expectMessage("Sirina van opsega");;
		int ocekivaniRezultat=140;
		int stvarniRezultat=guma.getSirina();
		assertEquals(ocekivaniRezultat,stvarniRezultat);
		guma.setSirina(130);
	}
	
	@Test
	public void setSirinaTest2() {
		exception.expect(RuntimeException.class);
		exception.expectMessage("Sirina van opsega");
		int ocekivaniRezultat=140;
		int stvarniRezultat=guma.getSirina();
		assertEquals(ocekivaniRezultat,stvarniRezultat);
		guma.setSirina(360);
	}
	
	@Test
	public void setSirinaTest3() {
		
		int ocekivaniRezultat=140;
		int stvarniRezultat=guma.getSirina();
		assertEquals(ocekivaniRezultat,stvarniRezultat);
		
		guma.setSirina(150);
		ocekivaniRezultat=150;
		stvarniRezultat=guma.getSirina();
		assertEquals(ocekivaniRezultat,stvarniRezultat);
	}
	
	@Test
	public void getVisinaTest() {
		int ocekivaniRezultat=40;
		int stvarniRezultat=guma.getVisina();
		assertEquals(ocekivaniRezultat,stvarniRezultat);
	}
	@Test
	public void setVisinaTest() {
		int ocekivaniRezultat=40;
		int stvarniRezultat=guma.getVisina();
		assertEquals(ocekivaniRezultat,stvarniRezultat);
		
		try {
			guma.setVisina(100);
			}
			catch(Throwable t) {
				Assume.assumeNoException(t);
			}
	}
	
	@Test
	public void setVisinaTest2() {
		int ocekivaniRezultat=40;
		int stvarniRezultat=guma.getVisina();
		assertEquals(ocekivaniRezultat,stvarniRezultat);
		
		try {
			guma.setVisina(20);
			}
			catch(Throwable t) {
				Assume.assumeNoException(t);
			}
	}
	
	@Test
	public void setVisinaTest3() {
		int ocekivaniRezultat=40;
		int stvarniRezultat=guma.getVisina();
		assertEquals(ocekivaniRezultat,stvarniRezultat);
		
		guma.setVisina(30);
		ocekivaniRezultat=30;
		stvarniRezultat=guma.getVisina();
		
	}
	
	@Test
	public void izracunajCenuTest() {
		double ocekivaniRezultat=(guma.getPrecnik()*3+guma.getSirina()+guma.getVisina())*28.53;
		double stvarniRezultat=guma.izracunajCenu();
		assertEquals(ocekivaniRezultat,stvarniRezultat,0.001);
	}
	
	@Test
	public void toStringTest() {
		String ocekivaniRezultat="AutoGuma [markaModel=" + guma.getMarkaModel() + ", precnik=" + guma.getPrecnik() + ", sirina=" + guma.getSirina() + ", visina="+ guma.getVisina() + "]";
		String stvarniRezultat=guma.toString();
		assertEquals(ocekivaniRezultat,stvarniRezultat);
	}
	
	@Test
	public void povoljnaGumaTest() {
		assertFalse(guma.povoljnaGuma());
	}
	
	@Test
	public void povoljnaGumaTest2() {
		guma.setSirina(140);
		guma.setVisina(30);
		guma.setPrecnik(15);
		guma.povoljnaGuma();
	}
}
