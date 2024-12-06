package com.sevenrmartsupermarket.pages;

import org.testng.annotations.DataProvider;

import com.sevenrmartsupermarket.utilities.ExcelReader;

public class Data_Providers {
	ExcelReader excelreader = new ExcelReader();

	@DataProvider(name = "editmanagecontact") // this should be given in our test case
	public Object[][] searchitems() {
		excelreader.setExcelFile("DataProviderExcelRead", "Sheet1");
		return excelreader.getMultidimentionalData(1, 1);
	}

}
