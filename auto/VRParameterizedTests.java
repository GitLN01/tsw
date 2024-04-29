package auto;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({VRDodajGumuParameterizedTest.class,
	VRPronadjiGumuParameterizedTest.class})
public class VRParameterizedTests {

}
