package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUserPage;
import com.sevenrmartsupermarket.pages.DashboardPage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.SubCategoryPage;

public class SubCategoryTest extends Base{
	LoginPage loginpage;
	DashboardPage dashboardpage;
	AdminUserPage adminuserpage;
	SubCategoryPage subcategorypage;
	@Test
	public void verifytheTitleListSubCategories () {
		loginpage=new LoginPage(driver);
		dashboardpage = loginpage.login("admin", "admin");
		subcategorypage=dashboardpage.clickSubCategoryMoreInfoText();
		String ActualText=subcategorypage.getTextofListSubCategoryText();
		String ExpectedText="List Sub Categories";
		Assert.assertEquals(ActualText, ExpectedText);
	}
	@Test
	public void verifythatUserisabletoAddtheSubCategory() {
		loginpage=new LoginPage(driver);
		dashboardpage = loginpage.login("admin", "admin");
		subcategorypage=dashboardpage.clickSubCategoryMoreInfoText();
		subcategorypage.clickonNewBtn();
		subcategorypage.clickandSelectfromCategory();
		subcategorypage.enterSubCategoryField();
		subcategorypage.chooseFiletoUpload();
		subcategorypage.tapOnSaveBtn();
		String ActualAlert=subcategorypage.getAlertmessage();
		String ExpectedAlert=ActualAlert;
		Assert.assertEquals(ActualAlert, ExpectedAlert);
		
}
	}
