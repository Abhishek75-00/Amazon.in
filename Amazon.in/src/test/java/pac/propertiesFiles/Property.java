package pac.propertiesFiles;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Property {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		FileInputStream file=new FileInputStream("C:\\Users\\Abhishek\\eclipse-workspace\\Amazon.in\\src\\test\\java\\pac\\propertiesFiles\\Test-Data1\\Browser");

		
		Properties p=new Properties();
		p.load(file);
		String Mybrowser=p.getProperty("browser");
		System.out.println(Mybrowser);
		
		if(Mybrowser.equals("Chrome")) {
			
			WebDriver driver=new ChromeDriver();
			driver.get("https://www.amazon.in/");
			Thread.sleep(2000);
			driver.quit();
		}
		else if(Mybrowser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver","D:\\abhi\\geckodriver.exe");
			FirefoxOptions ops=new FirefoxOptions();
			ops.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			WebDriver driver =new FirefoxDriver(ops);
			driver.get("https://www.amazon.in/");
			Thread.sleep(2000);
			driver.quit();
		}
		else if(Mybrowser.equals("Edge")) {
			WebDriver driver=new EdgeDriver();
			driver.get("https://www.amazon.in/");
			
			Thread.sleep(2000);
			driver.quit();
		}
	
	}

}
