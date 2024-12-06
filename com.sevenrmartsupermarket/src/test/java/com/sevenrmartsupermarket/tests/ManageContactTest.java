package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.DashboardPage;
import com.sevenrmartsupermarket.pages.Data_Providers;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageContactPage;

public class ManageContactTest extends Base {

	

	LoginPage loginpage;
	DashboardPage dashboardpage;
	ManageContactPage managecontactpage;
	

	@Test(dataProvider = "editmanagecontact",dataProviderClass = Data_Providers.class)

	public void verifyEditEntriesFromManageContact(String address) throws InterruptedException {
   
		loginpage = new LoginPage(driver);	
		dashboardpage = loginpage.login("admin", "admin");
		managecontactpage = new ManageContactPage(driver);
		dashboardpage.clickManageContactPageMoreInfo();	
		String actualAlertMsg = managecontactpage.EditContact(address);
		String expectedAlertMsg = "Alert!Contact Updated Successfully";
		Assert.assertEquals(actualAlertMsg, expectedAlertMsg);

}
	

}
	
	


