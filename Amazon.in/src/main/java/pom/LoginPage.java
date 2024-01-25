package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	@FindBy (xpath="(//div[@class='navbar-tool-icon-box bg-secondary'])[1]")
	private WebElement button;
	
	@FindBy(xpath="(//a[@class='dropdown-item'])[1]")
    private WebElement SignIn;
	
	@FindBy (id="si-email")
	private WebElement Username;
	
	@FindBy (id="si-password")
	private WebElement PassWord;
	
	@FindBy (id="remember")
	private WebElement KeepMeSignin;
	
	@FindBy (xpath="//button[text()='Sign in']")
	private WebElement SignInButton;
	
	
	@FindBy(xpath="")
	private List<WebElement> autosuggestion;
	
	
	private WebDriver driver;
	private Actions act;
	private WebDriverWait wait;
	private JavascriptExecutor js;
	
	
	
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
		this.driver=driver;
		act=new Actions(driver);
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		js=(JavascriptExecutor)driver;
		
	}
	

	public void ClickOnButton() {
		
		act.moveToElement(button).click().build().perform();
	}
	
	public void ClickOnSignIn() {
		wait.until(ExpectedConditions.visibilityOf(SignIn));
		SignIn.click();
		
	}
	

   public void SendUserName(String Users) {
	   
	   
//	  // Username.sendKeys("abhishek@marolix.com");
 // js.executeScript("arguments[0].value='abhishek@marolix.com';",Username) ;
	   Username.sendKeys(Users);
   }
	
  public void SendPassword(String Pass) {
	  PassWord.sendKeys(Pass);
  }
  
  public void ClickOnRemember() {
	  KeepMeSignin.click();
  }
  
  public void ClickOnSignButton() {
	SignInButton.click();
  }
	
	
	
	
	
}
