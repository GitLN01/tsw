package artikal;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

	 public static void main(String[] args)
	 {
		 Result result=JUnitCore.runClasses(ArtikalTests.class,ProdavnicaParameterizedTests.class);
		 
		 Logger l=Logger.getLogger(TestRunner.class.toString());
		 
		 for (Failure f:result.getFailures())
		 {
			 l.warning(f.toString());
		 }
		 
		 l.info("Ukupan broj testova:"+result.getRunCount());
		 l.info("Ukupno vreme "+result.getRunTime());
		 l.info("Uspesno testova "+(result.getRunCount()-result.getFailureCount()-result.getIgnoreCount()-result.getAssumptionFailureCount()));
		 l.info("Dinamicki preskocenih: "+ result.getAssumptionFailureCount());
		 l.info("Preskocenih testova "+result.getIgnoreCount());
		 
		 if(result.wasSuccessful())
			 l.info("Svi su uspesno izvrseni");
		 else
			 l.warning("Nisu svi testovi uspesno izvrseni");
		 
	 }
}
