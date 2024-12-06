package com.sevenrmartsupermarket.utilities;


import java.util.List;
import java.util.Random;

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
	public void selectRandomOptionFromDropdown(WebElement dropdownElement) {
		Select dropdown = new Select(dropdownElement);
		List<WebElement> options = dropdown.getOptions();
		int randomIndex = new Random().nextInt(options.size());
		WebElement selectedOption =options.get(randomIndex);		
		dropdown.selectByIndex(randomIndex);
		selectedOption.click();
		System.out.println("Selected option: " + selectedOption.getText());
	}
	public void jsClick(WebElement element) {
		// TODO Auto-generated method stub
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("arguments[0].click();", element);
	}
	public boolean isClicked(WebElement element) {
		try {
			element.click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public void scrollAndClick(WebElement element) {
		int index = 0;
		while (!isClicked(element)) {
			js.executeScript("window.scrollBy(0," + index + ")");
			index = index + 2;
		}
	}
}
