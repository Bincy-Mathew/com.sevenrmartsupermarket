package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class HomeTest extends Base {
	LoginPage loginpage;
	HomePage homepage;

	@Test(groups="regression")
	public void verifyProfileName() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.login("admin", "admin");
		String actualProfileName = homepage.getProfileName();
		String expectedProfileName = "Admin";
		Assert.assertEquals(actualProfileName, expectedProfileName);
	}
	@Test (groups={"smoke","regression"},retryAnalyzer = com.sevenrmartsupermarket.listeners.RetryAnalyzer.class)
	public void verifyBgColorOftext() {
		loginpage = new LoginPage(driver);
		
		homepage=loginpage.login("admin", "admin");//object chaining
		String Actual=homepage.getBgColorofHomeText();
		String Expected="rgba(0, 123, 0, 0)";//retry analyzer=fail 3 to 4 times run
		Assert.assertEquals(Actual, Expected);
		String ActualColor=homepage.getColorofHomeText();
		String ExpectedColor=ActualColor;
		Assert.assertEquals(ActualColor, ExpectedColor);

	}
	
	}
