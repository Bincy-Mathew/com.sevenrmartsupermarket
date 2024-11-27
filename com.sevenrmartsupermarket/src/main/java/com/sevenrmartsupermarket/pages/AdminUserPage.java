package com.sevenrmartsupermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class AdminUserPage {
	WebDriver driver;
	WaitUtility waitutility;
	GeneralUtility generalutility = new GeneralUtility();
	@FindBy(xpath = "//h1[text()='Admin Users']")
	private WebElement AdminUser;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement NewButton;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement userName;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement Password;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement userType;
	@FindBy(xpath="//select[@id='user_type']//option[text()='Admin']")
	private WebElement Admintype;
	@FindBy(xpath="//button[@name='Create']")
	private WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement successAlert;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchBtn;
	@FindBy(xpath="//input[@id='un']")
	private WebElement Usernamesearch;
	@FindBy(xpath="//select[@id='ut']//option[text()='Admin']")
	private WebElement selectAdmin;
	@FindBy (xpath="//select[@id='ut']")
	private WebElement searchUserType;
	@FindBy(xpath="//button[@name='Search']")
	private WebElement submitSearchBtn;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td")
	List<WebElement> searchResultdetail;
	@FindBy(xpath="//a[text()='Home']")
	private WebElement HomeLink;

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		waitutility = new WaitUtility(driver);
		PageFactory.initElements(driver, this);
	}

	public String getTitleofAdminUser() {
		System.out.println(AdminUser.getText());
		return AdminUser.getText();
	}

	public String getTitleofNewButton() {
		System.out.println(NewButton.getText());
		return NewButton.getText();
	}

	public AdminUserPage tapOnNewButton() {
		NewButton.click();
		return this;
	}
	public AdminUserPage enteranUsername(String username) 
	{   //userName.click();
		userName.sendKeys(username);
		return this;
	}
	public AdminUserPage enteraPassword(String password) {
		//Password.click();
		Password.sendKeys(password);
		return this;
	}
	public void tapOnUserTypefield() {
		userType.click();
	}
	public void selectAdminOption() {
		Admintype.click();
	}
	public void tapOnSaveBtn() {
		saveButton.click();
}
	public String getAlertmessage() {
		System.out.println(successAlert.getText());
		return successAlert.getText();
	}
	public String getTitleofSearchButton() {
		System.out.println(searchBtn.getText());
		return searchBtn.getText();
	}
	public void tapOnSearchButton() {
		waitutility.waitElementForClickable(searchBtn, 20);
		searchBtn.click();		
}
	public void enterSearchUsername() {
		Usernamesearch.sendKeys("Antony");
	}
	public void taponSearchUserType() {
		waitutility.waitElementForClickable(searchUserType, 20);
		searchUserType.click();
	}
	public void chooseAdminOption() {
		waitutility.waitElementForClickable(selectAdmin, 20);
		selectAdmin.click();
	}
	public void clickonSubmitSearchBtn() {
		submitSearchBtn.click();
	}
	public List<String>getDetailsofSearchresult(){
		List<String>antonyDetails=new ArrayList<String>();
		antonyDetails=generalutility.getTextOfElements(searchResultdetail);
		System.out.println(antonyDetails);
		return antonyDetails;
	}
	public DashboardPage tapOnHomeLink() {
		waitutility.waitElementForClickable(HomeLink, 20);
		HomeLink.click();
		return new DashboardPage(driver);
	}
}