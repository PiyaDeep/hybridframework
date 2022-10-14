package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends Headerpage {
	
	

	
	public Homepage( WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}

   @FindBy(name="pipeline")
   WebElement map_pipeline;
   
   public boolean variftpipeline()
   {
	  return  map_pipeline.isDisplayed();
   }

}
