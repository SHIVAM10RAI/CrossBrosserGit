package library;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest implements Constants {
	
	public WebDriver driver;
	
	@BeforeMethod
	@Parameters("myBrowser")
	
	public void before(String myBrowser) throws MalformedURLException {
		 
		//DesiredCapabilities caps = DesiredCapabilities.firefox().chrome();
		
		if(myBrowser.equalsIgnoreCase("firefox"))
		{
			 DesiredCapabilities caps = DesiredCapabilities.firefox();
			    caps.setCapability("platform", "Windows 10");
			    caps.setCapability("version", "38.0");
			    driver = new RemoteWebDriver(new java.net.URL(URL), caps);
			
		}
		else if(myBrowser.equalsIgnoreCase("chrome")){
	  
	   DesiredCapabilities caps = DesiredCapabilities.chrome();
	    caps.setCapability("platform", "Windows 10");
	    caps.setCapability("version", "38.0");
	    driver = new RemoteWebDriver(new java.net.URL(URL), caps);

	}
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get(TEST_URL);
}
	@AfterMethod
	public void close() {
		driver.quit();
	}
}