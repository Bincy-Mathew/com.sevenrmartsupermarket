package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class SubCategoryPage {
	WebDriver driver;
	WaitUtility waitutility;
	PageUtility pageutility;
	GeneralUtility generalutility ;
	
	@FindBy(xpath="//h1[text()='List Sub Categories']")
	WebElement ListSubcategoryText;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement NewBtn ;
	@FindBy(xpath="//select[@id='cat_id']")
	WebElement Categorydropdown ;
	@FindBy(xpath="//input[@id='subcategory']")
	WebElement SubCategoryField ;
	@FindBy(xpath="//input[@id='main_img']")
	WebElement ChooseFile ;
	@FindBy(xpath="//button[text()='Save']")
	WebElement SaveBtn;
	
	public SubCategoryPage(WebDriver driver) {
		this.driver = driver;
		waitutility = new WaitUtility(driver);
		pageutility=new PageUtility(driver);
		generalutility = new GeneralUtility();
		PageFactory.initElements(driver, this);
	}
	public String getTextofListSubCategoryText() {
		System.out.println(ListSubcategoryText.getText());
		return (ListSubcategoryText.getText());
	}
	public void clickonNewBtn() {
		NewBtn.click();
	}
	public void clickandSelectfromCategory() {
		Categorydropdown.click();
		pageutility.selectRandomOptionFromDropdown(Categorydropdown);
	}
}
