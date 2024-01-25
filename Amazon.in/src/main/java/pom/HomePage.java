package pom;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	@FindBy (xpath="//a[@class='nav-link text-capitalize']")
	private WebElement DiscountedcouponHeader;	
	
	@FindBy (xpath="//a[contains(text(),'All Sellers')]")
	private WebElement AllSellerHeader;
		
	@FindBy (xpath="//a[@class='navbar-tool ml-3']")
	private WebElement DashBoard;
	
	@FindBy (xpath="(//a[@class='dropdown-item'])[3]")
	private WebElement LogOut;

	
	
	
	private WebDriver driver;
    private Actions act;
    private JavascriptExecutor js;
    private WebDriverWait wait;
    
public HomePage(WebDriver driver) {
	

	PageFactory.initElements(driver, this);
	this.driver=driver;
	act=new Actions(driver);
	js=(JavascriptExecutor)driver;
	wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	
}



public void ClickOnDiscountedCoupon () {
	wait.until(ExpectedConditions.visibilityOf(DiscountedcouponHeader));
	DiscountedcouponHeader.click();
}

public void ClickonAllSeller() {
	
	wait.until(ExpectedConditions.visibilityOf(AllSellerHeader));
	AllSellerHeader.click();
}

public void ClickOnDashBoard() {
	wait.until(ExpectedConditions.visibilityOf(DashBoard));
	DashBoard.click();
}

public void clickOnLogoutButton() {
	wait.until(ExpectedConditions.visibilityOf(LogOut));
	
	act.moveToElement(LogOut).click().build().perform();
}
}