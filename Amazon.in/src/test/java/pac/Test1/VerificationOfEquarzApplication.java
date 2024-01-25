package pac.Test1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pom.HomePage;
import pom.LoginPage;
import pom.Utility.UtilityClass;

public class VerificationOfEquarzApplication {
WebDriver driver;
LoginPage lp;
HomePage hp;
SoftAssert soft;
String Users;
String Pass;
	
	@BeforeClass     // launch browser code // Url code // object creating
	public void launchBrowser() {
		
		driver=new ChromeDriver();
		driver.get("https://e-quarz.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	@BeforeMethod  //  login credentials and create the object
	public void logintoApplication() {
		
		
		lp=new LoginPage(driver);
		lp.ClickOnButton();
		lp.ClickOnSignIn();
		 Users=UtilityClass.fetchDataAsString("Sheet1", 1, 0);
		lp.SendUserName(Users);
		
		
	     Pass=UtilityClass.fetchDataAsString("Sheet1", 1, 1);
		lp.SendPassword(Pass);
		lp.ClickOnRemember();
		lp.ClickOnSignButton();
		
		 hp=new HomePage(driver);
		 soft=new SoftAssert();
		
	}
	@Test
	public void VerifyTheDiscountedCouponHeader() throws InterruptedException {
		hp.ClickOnDashBoard();
		
		String title=driver.getTitle();
		System.out.println(title);
        soft.assertEquals(title, title);
        soft.assertAll();
		hp.ClickOnDashBoard();
	}
	
	@Test
	public void VerifyTheAllSellerHeader() throws Exception {
		hp.ClickonAllSeller();
		String title=driver.getTitle();
		System.out.println(title);
	
		soft.assertEquals(title,title);
		  soft.assertAll();
		hp.ClickOnDashBoard();
	}
	

	@AfterMethod 
	//  Logout
	public void logoutFromApplication()  {
		
		hp.clickOnLogoutButton();
	}
	
	
	@AfterClass // closing browser into this
	public void tearDown() {
		
		driver.quit();
	}
	
	
	

}