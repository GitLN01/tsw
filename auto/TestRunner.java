package auto;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

	public static void main(String[] args) {
		
		Result result=JUnitCore.runClasses(AutoGumaTests.class,VRDodajGumuParameterizedTest.class);
		
		Logger l = Logger.getLogger(TestRunner.class.toString());
		
		for (Failure f : result.getFailures()) {
			l.warning(f.toString());
		}
		
		l.info("Vreme izvrsavaja "+result.getRunTime());
		l.info("Broj testova "+result.getRunCount());
		l.info("Uspesnig testova "+(result.getRunCount()-result.getFailureCount()-result.getIgnoreCount()-result.getAssumptionFailureCount()));
		l.info("Preskocenih testova "+result.getIgnoreCount());
		l.info("Dinamicki preskoceno "+result.getAssumptionFailureCount());
		l.info("Neuspesnih testova "+result.getFailureCount());
		
		if(result.wasSuccessful())
			l.info("Svi su uspesno pokrenuti"); 
		else
			l.warning("Svi testovi nisu prosli");
		
	}

}
