package com.sevenrmartsupermarket.utilities;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	WebDriver driver;
	Actions actions;
	JavascriptExecutor js;

	public PageUtility(WebDriver driver) {
		this.driver = driver;
		actions = new Actions(driver);
		js = (JavascriptExecutor) driver;
	}
	public void selectDropDownByIndex(WebElement element ,int index)
	{		
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	public void selectDropDownByVisibleText(WebElement element ,String text)

	{
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	public void selectDropDownByValue(WebElement element ,String value)
	{
		Select select = new Select(element);
		select.selectByValue(value);
	}
}
