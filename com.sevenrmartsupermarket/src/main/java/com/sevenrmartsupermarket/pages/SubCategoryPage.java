package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class SubCategoryPage {
	WebDriver driver;
	WaitUtility waitutility;
	PageUtility pageutility;
	GeneralUtility generalutility;

	@FindBy(xpath = "//h1[text()='List Sub Categories']")
	private WebElement ListSubcategoryText;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement NewBtn;
	@FindBy(xpath = "//select[@id='cat_id']")
	private WebElement Categorydropdown;
	@FindBy(xpath = "//input[@id='subcategory']")
	private WebElement SubCategoryField;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement ChooseFile;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	private WebElement SaveBtn;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement AlertMessage;

	public SubCategoryPage(WebDriver driver) {
		this.driver = driver;
		waitutility = new WaitUtility(driver);
		pageutility = new PageUtility(driver);
		generalutility = new GeneralUtility();
		PageFactory.initElements(driver, this);
	}

	public String getTextofListSubCategoryText() {
		System.out.println(ListSubcategoryText.getText());
		return (ListSubcategoryText.getText());
	}

	public void clickonNewBtn() {
		waitutility.waitElementForClickable(NewBtn, 20);
		NewBtn.click();
	}

	public void clickandSelectfromCategory() {
		waitutility.waitElementForClickable(Categorydropdown, 20);
		Categorydropdown.click();
		pageutility.selectRandomOptionFromDropdown(Categorydropdown);
	}

	public void enterSubCategoryField() {
		waitutility.waitElementForClickable(SubCategoryField, 20);
		SubCategoryField.click();
		String randomName = generalutility.getRandomName(); 
		SubCategoryField.sendKeys(randomName); 
	}

	public void chooseFiletoUpload() {		
		ChooseFile.sendKeys(Constants.IMAGE_PATH);

	}

	public void tapOnSaveBtn() {
		waitutility.waitElementForClickable(SaveBtn, 20);
		try {
			SaveBtn.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Element not clickable, using JavaScript to click");
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", SaveBtn);
		}
	}
	public String getAlertmessage() {
		System.out.println(AlertMessage.getText());
		return AlertMessage.getText();
	}
}

