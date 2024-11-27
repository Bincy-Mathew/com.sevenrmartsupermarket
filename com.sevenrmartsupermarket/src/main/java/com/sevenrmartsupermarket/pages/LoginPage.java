package com.sevenrmartsupermarket.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.WaitUtility;

public class LoginPage {
	WebDriver driver;
	WaitUtility waitutility;
	Properties properties = new Properties();
	@FindBy(xpath = "//input[@placeholder = 'Username']")
	WebElement userNameField;
	@FindBy(xpath = "//input[@placeholder = 'Password']")
	WebElement passwordField;
	@FindBy(xpath = "//label[contains(text(),'Remember')]")
	WebElement rememberMeField;
	@FindBy(xpath = "//button[contains(text(),'Sign')]")
	WebElement sigInBtn;

	public LoginPage(WebDriver driver) {
	this.driver = driver;
	waitutility= new WaitUtility(driver);
	PageFactory.initElements(driver, this);
	}
	
	public void enterUserName(String userName)
	{
	userNameField.sendKeys(userName);
	}
	
	public void enterPassword(String password)
	{
	passwordField.sendKeys(password);
	}
	
	public void clickRememberMe()
	{
	rememberMeField.click();
	}
	
	public void clickSignInBtn()
	{
	waitutility.waitElementForClickable(sigInBtn, 20);	
	sigInBtn.click();
	}
	public DashboardPage login(String userName, String password) {
		enterUserName(userName);
		enterPassword(password);
		clickSignInBtn();
		return new DashboardPage(driver);//object chaining
		}
	public DashboardPage login() {
		String userName = properties.getProperty("username");
		String password = properties.getProperty("password");
		enterUserName(userName);
		enterPassword(password);
		clickSignInBtn();
		return new DashboardPage(driver);
		}
	}


