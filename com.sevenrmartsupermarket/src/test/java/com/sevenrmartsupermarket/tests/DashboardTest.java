package com.sevenrmartsupermarket.tests;

import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUserPage;
import com.sevenrmartsupermarket.pages.DashboardPage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class DashboardTest extends Base {
	LoginPage loginpage;
	DashboardPage dashboardpage;
	AdminUserPage adminuserpage;

	
	@Test(groups = { "smoke", "regression" }, retryAnalyzer = com.sevenrmartsupermarket.listeners.RetryAnalyzer.class)
	public void verifyBackgroundColorandFontColorOfHomeText() {
		loginpage = new LoginPage(driver);
		dashboardpage = loginpage.login("admin", "admin");
		String Actual = dashboardpage.getBgColorofHomeText();
		String Expected = "rgba(0, 0, 0, 0)";
		Assert.assertEquals(Actual, Expected);
		String ActualColor = dashboardpage.getColorofHomeText();
		String ExpectedColor = "rgba(0, 123, 255, 1)";
		Assert.assertEquals(ActualColor, ExpectedColor);

	}

	@Test(groups = { "smoke", "regression" })
	public void verifyallTitlesonSideDashboard() {
		loginpage = new LoginPage(driver);
		dashboardpage = loginpage.login("admin", "admin");
		List<String> ActualTitleNames = dashboardpage.getNamesofTitlesofDashboardSide();
		List<String> ExpectdTitleNames = ActualTitleNames;
		Assert.assertEquals(ActualTitleNames, ExpectdTitleNames);
	}
	

	@Test(groups = { "smoke", "regression" })
	public void verifytheTitleofTileHeaders() {
		loginpage = new LoginPage(driver);
		dashboardpage = loginpage.login("admin", "admin");		
		List<String> ActualTileHeaderNames = dashboardpage.getNamesofAllTiles();
		List<String> ExpectdTileHeaderNames = new ArrayList<String>();
		ExpectdTileHeaderNames.add("Admin Users");
		ExpectdTileHeaderNames.add("Dashboard");
		ExpectdTileHeaderNames.add("Category");
		ExpectdTileHeaderNames.add("Sub Category");
		ExpectdTileHeaderNames.add("Manage Contact");
		ExpectdTileHeaderNames.add("Manage Gift cards &vouchers");
		ExpectdTileHeaderNames.add("Test name");
		ExpectdTileHeaderNames.add("Manage Product");
		ExpectdTileHeaderNames.add("Manage News");
		ExpectdTileHeaderNames.add("Manage Footer Text");
		ExpectdTileHeaderNames.add("Manage Category");
		Assert.assertEquals(ActualTileHeaderNames, ExpectdTileHeaderNames);

	}
	@Test(groups = "smoke")
	public void verifyAdminUserMoreInfo() {
		loginpage = new LoginPage(driver);
		dashboardpage = loginpage.login("admin", "admin");
		String actualtext = dashboardpage.getadminUserMoreInfoText();
		String expectedtext = "More info";
		Assert.assertEquals(actualtext, expectedtext);
		
	}
	@Test(groups = "regression")
	public void verifyAdminUserMoreInfoClick() {
		loginpage = new LoginPage(driver);
		dashboardpage = loginpage.login("admin", "admin");
		adminuserpage = dashboardpage.clickadminUserMoreInfoText();	   
	    String actualtextofAdmin=adminuserpage.getTitleofAdminUser();
	    String expectedtextofAdmin="Admin Users";
	    Assert.assertEquals(actualtextofAdmin, expectedtextofAdmin);
	    
	
}
}