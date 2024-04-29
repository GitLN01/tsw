package stan;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

	public static void main(String[] args) {
		
		Result result=JUnitCore.runClasses(StanTests.class, APSParameretrizedTests.class);
		
		Logger l=Logger.getLogger(TestRunner.class.toString());
		
		for(Failure f:result.getFailures()) {
			l.warning(f.toString());
		}
		
		l.info("Vreme izvrsavanja testva: "+result.getRunTime());
		l.info("Broj izvrsenig testova: "+result.getRunCount());
		l.info("Uspesnih: "+(result.getRunCount()-result.getFailureCount()-result.getAssumptionFailureCount()-result.getIgnoreCount()));
		l.info("Preskocenih: "+result.getIgnoreCount());
		l.info("Dinamicki preskocenih: "+result.getAssumptionFailureCount());
		l.info("Broj palih testova"+result.getFailureCount());
		
		if(result.wasSuccessful())
			l.info("Svi su uspesno izvrseni");
		else
			l.warning("Nisu svi uspesno izvrseni");
	}

}
