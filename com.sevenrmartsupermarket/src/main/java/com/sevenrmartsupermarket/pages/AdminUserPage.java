package com.sevenrmartsupermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class AdminUserPage {
	WebDriver driver;
	WaitUtility waitutility;
	PageUtility pageutility ;
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
	@FindBy(xpath = "//select[@id='user_type']//option[text()='Admin']")
	private WebElement Admintype;
	@FindBy(xpath = "//button[@name='Create']")
	private WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement successAlert;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchBtn;
	@FindBy(xpath = "//input[@id='un']")
	private WebElement Usernamesearch;
	@FindBy(xpath = "//select[@id='ut']//option[text()='Admin']")
	private WebElement selectAdmin;
	@FindBy(xpath = "//select[@id='ut']")
	private WebElement searchUserType;
	@FindBy(xpath = "//button[@name='Search']")
	private WebElement submitSearchBtn;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td")
	List<WebElement> searchResultdetail;
	@FindBy(xpath = "//a[text()='Home']")
	private WebElement HomeLink;
	@FindBy(xpath = "//table//tbody//tr//td[1]")
	private List<WebElement> getAllNamesFromTable;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement DeleteAlertMsg;

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		waitutility = new WaitUtility(driver);
		pageutility= new PageUtility(driver);
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

	public AdminUserPage enteranUsername(String username) { // userName.click();
		userName.sendKeys(username);
		return this;
	}

	public AdminUserPage enteraPassword(String password) {
		// Password.click();
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

	public List<String> getAllNamesfromAdminUserTable() {
		List<String> allNamesFromTable = generalutility.getTextOfElements(getAllNamesFromTable);
		return allNamesFromTable;
	}

	public String deleteUserFromAdminTable(String uname) {
		List<String> allTableNames = generalutility.getTextOfElements(getAllNamesFromTable);
		int index = 0;
		for (index = 0; index < allTableNames.size(); index++) {
			if (uname.equals(allTableNames.get(index))) {

				index++;
				break;
			}
		}
		WebElement deleteActionTable = driver.findElement(By.xpath("//table//tbody//tr[" + index + "]//td[5]//a[3]"));
		pageutility.jsClick(deleteActionTable);
		driver.switchTo().alert().accept();
		String getActualDeletemsg = getDeleteAlertMsg();
		return getActualDeletemsg;
	}

	private String getDeleteAlertMsg() {
		System.out.println(DeleteAlertMsg.getText());
		return DeleteAlertMsg.getText();
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

	public List<String> getDetailsofSearchresult() {
		List<String> antonyDetails = new ArrayList<String>();
		antonyDetails = generalutility.getTextOfElements(searchResultdetail);
		System.out.println(antonyDetails);
		return antonyDetails;
	}

	public DashboardPage tapOnHomeLink() {
		waitutility.waitElementForClickable(HomeLink, 20);
		HomeLink.click();
		return new DashboardPage(driver);
	}
}