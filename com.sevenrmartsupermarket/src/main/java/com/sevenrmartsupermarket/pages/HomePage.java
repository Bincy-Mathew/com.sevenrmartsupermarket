package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class HomePage {
	WebDriver driver;
	WaitUtility waitutility;
	GeneralUtility generalutility= new GeneralUtility();

	@FindBy(xpath="//div[@class='info']")
	private WebElement profilename;
	@FindBy(xpath="//a[text()='Home']")
	private WebElement HomeText;
	
	

	

	public HomePage(WebDriver driver)
	{		
		this.driver = driver;
		waitutility= new WaitUtility(driver);
		PageFactory.initElements(driver, this);	
	}

	

	public String getProfileName()
	{
		System.out.println(profilename.getText());
		return profilename.getText();

	}
	public String getBgColorofHomeText() {
		System.out.println(generalutility.getCssProperty(HomeText, "background-color"));
		return generalutility.getCssProperty(HomeText, "background-color");
	}
	public String getColorofHomeText() {
		System.out.println(generalutility.getCssProperty(HomeText, "color"));
		return generalutility.getCssProperty(HomeText, "color");
	}
	
}
