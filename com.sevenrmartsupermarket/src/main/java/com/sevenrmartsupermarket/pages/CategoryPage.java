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

	@FindBy(xpath = "//h1[text()='List Categories']")
	WebElement ListCategoryText;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement NewButton;
	@FindBy(xpath = "//a[text()='Home']")
	WebElement HomeText;

	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		waitutility = new WaitUtility(driver);
		PageFactory.initElements(driver, this);
	}

	public String getTitleofListCategory() {
		System.out.println(ListCategoryText.getText());
		return ListCategoryText.getText();
	}

	public boolean isNewbuttonPresent() {
		System.out.println(NewButton.isDisplayed());
		return NewButton.isDisplayed();
	}

	public boolean isNewButtonEnabled() {
		System.out.println(NewButton.isEnabled());
		return NewButton.isEnabled();
	}

	public String getTextofNewBtn() {
		System.out.println(NewButton.getText());
		return NewButton.getText();
	}

	public String getCssPropertyOfNewBtn(String property) {
		String value = generalutility.getCssProperty(NewButton, property);
		System.out.println(value);
		return value;
	}

	public void clickOnHomeLink() {
		waitutility.waitElementForClickable(HomeText, 20);
		HomeText.click();
	}
}
