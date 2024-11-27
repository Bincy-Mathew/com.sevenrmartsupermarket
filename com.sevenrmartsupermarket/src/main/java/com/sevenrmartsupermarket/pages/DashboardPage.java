package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.WaitUtility;

public class DashboardPage {
WebDriver driver;
WaitUtility waitutility;

@FindBy(xpath="//li[@class='nav-item has-treeview']")
private WebElement DashboardDropdown;

public DashboardPage(WebDriver driver) {
	this.driver=driver;
	waitutility= new WaitUtility(driver);
	PageFactory.initElements(driver, this);	
}
public void tapOnDashboardDropDown() {
	waitutility.waitElementForClickable(DashboardDropdown, 20);
	DashboardDropdown.click();
}
}
