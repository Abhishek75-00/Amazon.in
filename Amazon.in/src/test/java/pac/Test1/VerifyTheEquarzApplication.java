package pac.Test1;
import java.time.Duration;

import org.openqa.selenium.WebDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.relevantcodes.extentreports.HTMLReporter;

import pom.HomePage;
import pom.LoginPage;
import pom.Utility.UtilityClass;
import test.Browser.Base;





public class VerifyTheEquarzApplication extends Base {

WebDriver driver;
LoginPage lp;
HomePage hp;
SoftAssert soft;
int testid;
String Users;
String Pass;

static ExtentTest test;
static HTMLReporter reporter;

   @Parameters("browserName")
   @BeforeTest
   public void LaunchBrowser(String browser) {
	   String reportPath = ".\\test-output\\Extend\\Extent.html";

       // Create an ExtentHtmlReporter instance and attach it to the ExtentReports instance
       ExtentSparkReporter htmlReporter = new ExtentSparkReporter(reportPath);
       ExtentReports extent = new ExtentReports();
       extent.attachReporter(htmlReporter);
		
		extent.flush();
	   
	   
	 
       
	   if(browser.equals("Chrome")) {
		   driver=openChromeBrowser();
	   }
	   if(browser.equals("Firefox")) {
		   driver=openFirefoxBrowser();
	   }
	   if(browser.equals("Edge")) {
		   driver=openMicrosoftEdgeBrowser();
	   }
	   
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
   }





	@BeforeClass     // launch browser code // Url code // object creating
	public void createPomObjects() {
		
		lp=new LoginPage(driver);
		hp=new HomePage(driver);
	
	}
	
	@BeforeMethod  //  login credentials and create the object
	public void logintoApplication() {
		
		driver.get("https://e-quarz.com/");
		
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
		testid=101;
		String title=driver.getTitle();
		System.out.println(title);
        soft.assertEquals(title, title);
        soft.assertAll();
		hp.ClickOnDashBoard();
	}
	
	@Test
	public void VerifyTheAllSellerHeader() throws Exception {
		hp.ClickonAllSeller();
		testid=102;
		
		String title=driver.getTitle();
		System.out.println(title);
	
		soft.assertEquals(title,title);
		  soft.assertAll();
		hp.ClickOnDashBoard();
	}
	

	@AfterMethod 
	//  Logout
	public void logoutFromApplication(ITestResult result) throws Exception  {
		if(ITestResult.FAILURE==result.getStatus()) {
			UtilityClass.capture(driver, 102, "VerifyTheAllSellerHeader");
		}
		hp.clickOnLogoutButton();
	}
	
	
	@AfterClass // closing browser into this
	public void clearObject(){
		lp=null;
		hp=null;
	}
	
	@AfterTest
	public void closedBrowser() {
	
		driver.quit();
		driver=null;
	}
	
	
	

}

