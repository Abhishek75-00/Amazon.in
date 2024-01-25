package pac.Test1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demo {

	private static final String dependsOnMethods = null;
	@BeforeClass
	public void beforeclass() {
		System.out.println("Launch Browser Code");
	}
	@BeforeMethod
	public void beforemethod() {
		System.out.println("Login into the browser");
	}
	
	@Test (invocationCount=1)
	public void TestA() {
		System.out.println("Test - A passed");
	}
	
	@Test 
	public void TestB() {
		System.out.println("Test - B passed");
	}

	@Test (dependsOnMethods= {"TestA","TestB"})
	public void TestC() {
		System.out.println("Test - C passed");
	}
	@Test (enabled=false)
	public void TestD() {
		System.out.println("Test - D passed");
	}
	@Test (timeOut =3000)
	public void TestE() throws Exception {
		System.out.println("Test -E passes");
		Thread.sleep(2500);
	}
	@AfterMethod
	public void aftermethod() {
		System.out.println("Logout code");
	}
	@AfterClass
	public void afterclass() {
		System.out.println("Driver tear down or browser closing code");
	}
	
	
	
	
	
	
	
}
