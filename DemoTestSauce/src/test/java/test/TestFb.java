package test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import library.BaseTest;
import pom.FacebookGooglePO;
import pom.GooglePO;

public class TestFb extends BaseTest{
	
	@Test
	public void facebookTest() {
		try {
			GooglePO googlePO=new GooglePO(driver);
			googlePO.googleSrch("facebook");
			FacebookGooglePO fbGoPO=new FacebookGooglePO(driver);
			Reporter.log("Total no. of Links = "+fbGoPO.allLinksSize(),true);
			fbGoPO.fbSrchResLink().click();
			String eTitle="Facebook – log in or sign up";
			fbGoPO.checkTitle(eTitle);
			String aTitle = driver.getTitle();
			Assert.assertEquals(aTitle, eTitle);
		} catch (Exception e) {			
			e.printStackTrace();
			Reporter.log("Exception generated", true);
			Assert.fail();
		}
	}

}
