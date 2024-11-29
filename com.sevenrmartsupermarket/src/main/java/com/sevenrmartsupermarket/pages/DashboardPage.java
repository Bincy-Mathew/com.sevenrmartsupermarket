package com.sevenrmartsupermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class DashboardPage {
	WebDriver driver;
	WaitUtility waitutility;
	GeneralUtility generalutility = new GeneralUtility();

	@FindBy(xpath = "//div[@class='info']")
	private WebElement profilename;
	@FindBy(xpath = "//a[text()='Home']")
	private WebElement HomeText;
	@FindBy(xpath = "//li[@class='nav-item has-treeview']")
	private WebElement DashboardDropdown;
	@FindBy(xpath = "//h3//following-sibling::p")
	List<WebElement> tileHeaders;
	@FindBy(xpath = "//*[starts-with(@class,'nav-icon fas fa')]//following-sibling::p")
	List<WebElement> titles;
	@FindBy(xpath ="//p[text()='Admin Users']/../../div/following-sibling::a" )
	private WebElement adminUserMoreInfo;
	@FindBy(xpath="//p[text()='Category']/../../div/following-sibling::a")
	private WebElement categoryMoreInfo;
	@FindBy(xpath="//p[text()='Sub Category']/../../div/following-sibling::a")
	private WebElement subCategoryMoreInfo;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		waitutility = new WaitUtility(driver);
		PageFactory.initElements(driver, this);
	}

	public String getProfileName() {
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

	public List<String> getNamesofTitlesofDashboardSide() {
		List<String> titlenames = new ArrayList<String>();
		titlenames = generalutility.getTextOfElements(titles);
		System.out.println(titlenames);
		return titlenames;
	}

	public void tapOnDashboardDropDown() {
		waitutility.waitElementForClickable(DashboardDropdown, 20);
		DashboardDropdown.click();
	}

	public List<String> getNamesofAllTiles() {
		List<String> tilenames = new ArrayList<String>();
		tilenames = generalutility.getTextOfElements(tileHeaders);
		System.out.println(tilenames);
		return tilenames;
	}
	public String getadminUserMoreInfoText() {
		System.out.println(adminUserMoreInfo.getText());
		return adminUserMoreInfo.getText();		
	}
	public AdminUserPage clickadminUserMoreInfoText() {
		waitutility.waitElementForClickable(adminUserMoreInfo, 20);
		adminUserMoreInfo.click();
		return new AdminUserPage(driver);
	}
	public CategoryPage clickCategoryMoreInfoText() {
		waitutility.waitElementForClickable(categoryMoreInfo, 20);
		categoryMoreInfo.click();
		return new CategoryPage(driver);
		
}
	public SubCategoryPage clickSubCategoryMoreInfoText() {
		waitutility.waitElementForClickable(categoryMoreInfo, 20);
		subCategoryMoreInfo.click();
		return new SubCategoryPage(driver);

	}
	}
