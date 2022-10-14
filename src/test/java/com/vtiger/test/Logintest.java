package com.vtiger.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.vtiger.pages.Homepage;
import com.vtiger.pages.Loginpage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Logintest extends Basetest {
	

	
	
	@Test
	public void T01_Invalidlogin()
	{
		String TCName="T01_Invalidlogin";
		Loginpage lp=new Loginpage(driver);
	   lp.login(TestData.get(TCName).get("Userid"),TestData.get(TCName).get("Password"));
	}
	
	@Test
	public void T02_validlogin()
	{
		String TCName="T02_validloginn";
		Loginpage lp=new Loginpage(driver);
		lp.login(TestData.get(TCName).get("Userid"),TestData.get(TCName).get("Password"));
		Homepage hp=new Homepage(driver);
		hp.clicklogout();
		
	}
	

}
