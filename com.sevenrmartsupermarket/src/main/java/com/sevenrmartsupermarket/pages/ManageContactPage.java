package com.sevenrmartsupermarket.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManageContactPage {
	WebDriver driver;
	PageUtility pageutility;
	GeneralUtility generalutility = new GeneralUtility();
	
	@FindBy(xpath = "//h1[text()='Contact Us']")
	private WebElement manageContactTitle;
	@FindBy(xpath = "//table//tbody//tr//td[1]")
	private List<WebElement> allTableContactNames;
	@FindBy(xpath = "//label//following-sibling::textarea[@placeholder='Enter the Address']")
	private WebElement editAddressField;
	@FindBy(xpath = "//button[@name='Update']")
	private WebElement editUpdateBtn;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement editAlertSuccess;
	
	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		pageutility = new PageUtility(driver);
	}

	public String EditContact(String addressname) {
		
		WebElement editAction = driver.findElement(By.xpath("//table//tbody//tr[\"+index+\"]//td[6]//a"));
		pageutility.jsClick(editAction);
		editAddressField.clear();
		editAddressField.sendKeys(addressname);
		pageutility.scrollAndClick(editUpdateBtn);
		return getEditAlertMsg();
	}

	public String getEditAlertMsg() {
		String alertMessage = editAlertSuccess.getText().substring(2, 8);
		String message = editAlertSuccess.getText().substring(9);
		String actualMsg = alertMessage + message;
		System.out.println(actualMsg);
		return actualMsg;
	}
	

}
