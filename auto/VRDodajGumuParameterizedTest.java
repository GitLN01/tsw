package auto;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import org.junit.Assume;
import org.junit.Before;
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
public class VRDodajGumuParameterizedTest {

	private AutoGuma guma;
	private VulkanizerskaRadnja vr;
	@Test
	public void testProveraOperativnogSistema() {
	    Assume.assumeTrue(System.getProperty("os.name").contains("Windows"));
	}
	
	@Rule
	public final TestRule timeout=Timeout.seconds(5);
	
	@Rule
	public final ErrorCollector ec=new ErrorCollector();
	
	@Rule
	public final TestName name=new TestName();
	
	@Before
	public void init() {
		vr=new VulkanizerskaRadnja();
	}
	
	public VRDodajGumuParameterizedTest(AutoGuma guma) {
		this.guma=guma;
	}
	@Parameters
	public static Collection<Object[]> gume()
	{
		return Arrays.asList(new Object[][] {
			{new AutoGuma("Marka",true, 18,140,40)},
			{new AutoGuma("Marka",true, 18,140,40)},
			{new AutoGuma("Marka",true, 18,140,40)},
			{new AutoGuma("NovaMarka",false, 20,150,50)},		
		});
	}
	
	@Test(expected=NullPointerException.class)
	public void dodajGumuTest() {
		guma=null;
		vr.dodajGumu(guma);
	}
	
	@Test(expected=RuntimeException.class)
	public void dodajGumuTest2(){
		vr.dodajGumu(guma);
		vr.dodajGumu(guma);
	}
	
	@Test
	public void dodajGumuTest3(){
		vr.gume.contains(guma);
		vr.dodajGumu(guma);
		LinkedList<AutoGuma> gume = new LinkedList<AutoGuma>();
		gume.add(guma);
		vr.gume.contains(guma);	
	}
	
	
	
}
