package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.CategoryPage;
import com.sevenrmartsupermarket.pages.DashboardPage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class CategoryTest extends Base {
	LoginPage loginpage;
	DashboardPage dashboardpage;
	CategoryPage categorypage;

	@Test
	public void verifytheTitleofListCategory() {
		loginpage = new LoginPage(driver);
		dashboardpage = loginpage.login("admin", "admin");
		categorypage = dashboardpage.clickCategoryMoreInfoText();
		String ActualTitle = categorypage.getTitleofListCategory();
		String ExpectedTitle = "List Categories";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}
	@Test
	public void verifythePropertiesOfNewButton() {
		loginpage = new LoginPage(driver);
		dashboardpage = loginpage.login("admin", "admin");
		categorypage = dashboardpage.clickCategoryMoreInfoText();
		String ActualText=categorypage.getTextofNewBtn();
		String ExpectedText="New";
		Assert.assertEquals(ActualText, ExpectedText);
		String ActualBg=categorypage.getCssPropertyOfNewBtn("background-color");
		String ExpectedBg="rgba(220, 53, 69, 1)";
		Assert.assertEquals(ExpectedBg, ActualBg);
		String Actualcolor=categorypage.getCssPropertyOfNewBtn("color");
		String Expectedcolor="rgba(255, 255, 255, 1)";
		boolean ActualButtondisplayed=categorypage.isNewbuttonPresent();
		boolean ExpectedButtondisplayed=ActualButtondisplayed;
		boolean ActualButtonisenabled=categorypage.isNewButtonEnabled();
		boolean ExpectedButtondisenabled=ActualButtonisenabled;
		
}
	}
