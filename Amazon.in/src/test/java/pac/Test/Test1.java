package pac.Test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pom.HomePage;
import pom.LoginPage;
import pom.Utility.UtilityClass;

public class Test1 {

	public static void main(String[] args) {
		ChromeOptions op=new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");
		WebDriver driver =new ChromeDriver(op);

		 driver.get("https://e-quarz.com/");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 
		 LoginPage lp=new LoginPage(driver);
		 
	lp.ClickOnButton();
	lp.ClickOnSignIn();
	
	String Users=UtilityClass.fetchDataAsString("Sheet1", 1, 0);
	lp.SendUserName(Users);
	
	
	String Pass=UtilityClass.fetchDataAsString("Sheet1", 1, 1);
	lp.SendPassword(Pass);
	
	
	lp.ClickOnRemember();
	lp.ClickOnSignButton();
	
	
	HomePage hp=new HomePage(driver);
	hp.ClickOnDiscountedCoupon();
	hp.ClickonAllSeller();
	hp.ClickOnDashBoard();
	hp.clickOnLogoutButton();
	
//	driver.quit();
		 
	}

}
