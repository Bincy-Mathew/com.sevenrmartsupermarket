package com.sevenrmartsupermarket.tests;

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
	public void verifyListCategoryNewClick() {
		loginpage = new LoginPage(driver);		
		dashboardpage = loginpage.login("admin", "admin");
		categorypage=dashboardpage.clickCategoryMoreInfoText();
}}
