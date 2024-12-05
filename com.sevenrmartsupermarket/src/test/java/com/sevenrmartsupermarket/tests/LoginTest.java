package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.DashboardPage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.ExcelReader;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class LoginTest 	extends Base {
		LoginPage loginpage;
		DashboardPage dashboardpage;
		
		ExcelReader excelreader;
		
		
		@Test(groups = "regression")
		public void verifytheNameOfWebsite() {
			loginpage = new LoginPage(driver);
			String ActualName=loginpage.gettheNameofWebsite();
			String ExpectedName="7rmart supermarket";
			Assert.assertEquals(ActualName, ExpectedName);
		}
		
		@Test(groups="regression")
		public void verifyAdminUserLogin()
		{
			dashboardpage = new DashboardPage(driver);
			loginpage = new LoginPage(driver);
			excelreader=new ExcelReader();
			loginpage.login("admin","admin");
			excelreader.setExcelFile("LoginDetails", "LoginDetails");
			String userName = excelreader.getCellData(0, 1);
			System.out.println(userName);
			String password = excelreader.getCellData(1, 1);
			System.out.println(password);
			System.out.println(GeneralUtility.getRandomAddress());
			System.out.println(GeneralUtility.getRandomName());	
			String actualProfileName = dashboardpage.getProfileName();
			String expectedProfileName = "Admin";
			Assert.assertEquals(actualProfileName, expectedProfileName);
					
				
			
		}
		
}
