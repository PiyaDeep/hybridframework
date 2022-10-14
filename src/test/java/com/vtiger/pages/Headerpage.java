package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.common.commonfuction;

public class Headerpage {
	public WebDriver driver;
	 private commonfuction cr;
	public Headerpage( WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		cr=new commonfuction(driver);
	}
	  @FindBy(linkText="Home")
	   WebElement lnk_Home;
	   @FindBy(linkText="Calendar")
	   WebElement lnk_Calendar;
	   @FindBy(linkText="Activities")
	   WebElement lnk_Activities;
	   @FindBy(linkText="Leads")
	   WebElement lnk_Leads;
	   
	   @FindBy(linkText="Accounts")
	   WebElement lnk_Accounts;
	   @FindBy(linkText="Contacts")
	   WebElement lnk_Contacts;
	   @FindBy(linkText="Potentials")
	   WebElement lnk_Potentials;
	   @FindBy(linkText="Products")
	   WebElement lnk_Products;
	   @FindBy(linkText="Logout")
	   WebElement lnk_Logout;
	   public void Varifylogout()
	   {
		   cr.IsElementDisplay(lnk_Logout);
		 //return lnk_Logout.isDisplayed();  
	   }
	   public void clicklogout()
	   {
		   cr.ClickElement(lnk_Logout);
		   //lnk_Logout.click();
	   }
}
