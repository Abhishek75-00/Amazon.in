package pac.Test1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listeners_Class.class)
public class Listen {

	
	
	@Test
	public void Testone() {
		
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		String Title=driver.getTitle();
		Assert.assertEquals(Title, Title);
		
		
}
}