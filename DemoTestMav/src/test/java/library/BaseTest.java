package library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest implements Constants {
	
	public WebDriver driver;
	
	@BeforeMethod
	@Parameters("myBrowser")
	
	public void before(String myBrowser) {
		
		if(myBrowser.equalsIgnoreCase("firefox"))
		{
			System.setProperty(GECKO_KEY, GECKO_PATH);
			driver=new FirefoxDriver();
			
		}
		else if(myBrowser.equalsIgnoreCase("chrome")){
	   System.setProperty(CHROME_KEY, CHROME_PATH);
	   driver=new ChromeDriver();
	}
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get(TEST_URL);
}
	@AfterMethod
	public void close() {
		driver.quit();
	}
}