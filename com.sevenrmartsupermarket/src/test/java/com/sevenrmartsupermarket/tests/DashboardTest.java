package com.sevenrmartsupermarket.tests;

import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.DashboardPage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class DashboardTest extends Base {
	LoginPage loginpage;	
	DashboardPage dashboardpage;

	@Test(groups={"smoke","regression"})
	public void verifyDashboardside() 
	{
		loginpage = new LoginPage(driver);		
		loginpage.login("admin", "admin");
		dashboardpage= new DashboardPage(driver);		
		dashboardpage.tapOnDashboardDropDown();

}
}
