package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class CategoryPage {
	WebDriver driver;
	WaitUtility waitutility;
	GeneralUtility generalutility = new GeneralUtility();
	
	@FindBy(xpath="//h1[text()='List Categories']")
	WebElement ListCategoryText;
	
	public CategoryPage(WebDriver driver) {
		this.driver=driver;
		waitutility = new WaitUtility(driver);
		PageFactory.initElements(driver, this);
	}
	public String getTitleofListCategory() 
	{
		System.out.println(ListCategoryText.getText());
		return ListCategoryText.getText();	
		}
	
}
