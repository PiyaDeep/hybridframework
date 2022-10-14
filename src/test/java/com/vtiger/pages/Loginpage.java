package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.common.commonfuction;




public class Loginpage {
	
	private WebDriver driver;
    private commonfuction cf;
	
	public Loginpage( WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		cf=new commonfuction(driver);
	}

   @FindBy(name="user_name")
   WebElement tb_username;
   @FindBy(name="user_password")
   WebElement tb_userpwd;
   @FindBy(name="Login")
   WebElement btn_userlogin;
   @FindBy(xpath="//*[contains(text(),'	You must specify a valid username and password'")
   WebElement txterrmsg;
   public void login(String userid,String pwd)
   {
	   Setuserid(userid);
	   Setuserpwd(pwd);
	   Setlogin();
   }
   
   public void varifyerrmsg()
   {
	  cf.IsElementDisplay(txterrmsg);
   }
   public void Setuserid(String userid)
   {
	   cf.EnterValue(tb_username, userid);
	   //tb_username.clear();
	   //tb_username.sendKeys(userid);
   }
   public void Setuserpwd(String pwd)
   {
	   cf.EnterValue(tb_userpwd, pwd);
	   //tb_userpwd.clear();
	   //tb_userpwd.sendKeys(pwd);
   }
   public void Setlogin()
   {
	   cf.ClickElement(btn_userlogin);
	   //btn_userlogin.click();
	   
   }
   
   }

	
