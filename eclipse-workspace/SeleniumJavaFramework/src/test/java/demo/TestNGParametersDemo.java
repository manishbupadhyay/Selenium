package demo;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParametersDemo {

	@Test
	@Parameters({"myName"})
	public void test(@Optional("Manish") String name) {
		System.out.println("Name is : " + name);
	}
}
