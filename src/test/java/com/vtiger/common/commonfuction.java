package com.vtiger.common;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class commonfuction {

	private WebDriver driver;
	private WebDriverWait wait;
	public   commonfuction(WebDriver driver)
	{
		this.driver=driver;
		wait= new WebDriverWait(driver,Duration.ofSeconds(5));
	}
	
	public void EnterValue(WebElement elm,String value)
	{
		try {
			
			wait.until(ExpectedConditions.visibilityOf(elm));
			elm.clear();
			elm.sendKeys(value);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public void SelectDropdownValue(WebElement elm,String value)
	{
		try {
			wait.until(ExpectedConditions.visibilityOf(elm));
		Select s=new Select(elm);
		s.selectByVisibleText(value);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public void ClickElement(WebElement elm)
	{
		try {
			wait.until(ExpectedConditions.visibilityOf(elm));
			elm.click();
		
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public void IsElementDisplay(WebElement elm)
	{
		try {
			wait.until(ExpectedConditions.visibilityOf(elm));
			elm.isDisplayed();
		
			
		} catch (Exception e)
		{
			
			e.printStackTrace();
		}
	}
	
	
}
