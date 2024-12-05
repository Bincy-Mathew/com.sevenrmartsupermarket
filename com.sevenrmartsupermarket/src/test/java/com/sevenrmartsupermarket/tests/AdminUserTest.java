package com.sevenrmartsupermarket.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUserPage;
import com.sevenrmartsupermarket.pages.DashboardPage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class AdminUserTest extends Base {
	LoginPage loginpage;
	DashboardPage dashboardpage;
	AdminUserPage adminuserpage;

	@Test
	public void verifyUserisdisplayedwithNewButtonText() {
		loginpage = new LoginPage(driver);
		dashboardpage = loginpage.login("admin", "admin");
		adminuserpage = dashboardpage.clickadminUserMoreInfoText();
		String Actualtitle = adminuserpage.getTitleofNewButton();
		String Expectedtitle = "New";
		Assert.assertEquals(Actualtitle, Expectedtitle);
		

	}
	@Test
	public void verifyUserisAbletoAddNewUser() {
		loginpage = new LoginPage(driver);
		dashboardpage = loginpage.login("admin", "admin");
		String username= GeneralUtility.getRandomUsername();
		String password=GeneralUtility.getRandomPassword();
		adminuserpage = dashboardpage.clickadminUserMoreInfoText()
		.tapOnNewButton()
		.enteranUsername(username)
		.enteraPassword(password);
		adminuserpage.tapOnUserTypefield();
		adminuserpage.selectAdminOption();
		adminuserpage.tapOnSaveBtn();
		String Actualalert=adminuserpage.getAlertmessage();
		String Expectedalert=Actualalert;
		Assert.assertEquals(Actualalert, Expectedalert);
		
}
	@Test
	public void verifyUserisAbletoDeleteaUserName() {
		loginpage = new LoginPage(driver);
		dashboardpage = loginpage.login("admin", "admin");		
		adminuserpage = dashboardpage.clickadminUserMoreInfoText();
		String actualDeleteMsg=adminuserpage.deleteUserFromAdminTable("january");
		String expectedDeleteMsg=actualDeleteMsg;
		Assert.assertEquals(actualDeleteMsg, expectedDeleteMsg);
	}
	@Test
	public void verifyUserisAbletoSearchUserName() {
		loginpage = new LoginPage(driver);
		dashboardpage = loginpage.login("admin", "admin");		
		adminuserpage = dashboardpage.clickadminUserMoreInfoText();
		String actualsearchText=adminuserpage.getTitleofSearchButton();
		String expectedsearchText=actualsearchText;
		Assert.assertEquals(actualsearchText, expectedsearchText);
		adminuserpage.tapOnSearchButton();
		adminuserpage.enterSearchUsername();
		adminuserpage.taponSearchUserType();
		adminuserpage.chooseAdminOption();
		adminuserpage.clickonSubmitSearchBtn();
		List<String> ActualDetailsofAntony= adminuserpage.getDetailsofSearchresult();
		List<String> ExpectedDetailsofAntony =ActualDetailsofAntony;
		Assert.assertEquals(ActualDetailsofAntony, ExpectedDetailsofAntony);
		
	}
	
	}
