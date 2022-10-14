package com.vtiger.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.imageio.stream.FileImageInputStream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestScript.Xls_Reader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Basetest<Xls_Reader2> {
	public WebDriver driver;
	public SoftAssert sa;
	public Properties prop;
	public Map<String,Map<String,String>> TestData;
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest Logger;
	
	
	
	@BeforeSuite
	public void init()
	{
		TestData= readExcelData(System.getProperty("user.dir")+"/src/test/resources/TestData/Data.xlsx","Sheet1");
		System.out.println(TestData);
		System.exit(0);
		prop=readProperties();
		createReport();
		launchapp();
		
	}
	@AfterSuite
	public void closeapp()
	{
	driver.quit();
	}
	//@BeforeClass
	public void launchapp()
	{
		if(prop.getProperty("Browser").equals("chrome"))
		{
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
		}
		else if (prop.getProperty("Browser").equals("firfox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if (prop.getProperty("Browser").equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
		}
	driver.get(prop.getProperty("AppUrl"));
	driver.manage().window().maximize();
	int time=Integer.parseInt(prop.getProperty("GlobalTimeout"));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	
		
	}
	public Properties readProperties()
	{
		try {
			Properties prop = new Properties();
			FileInputStream fis =new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Config/Setting.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return prop;
	}
	public Map<String,Map<String,String>> readExcelData(String path,String sheetname)
	{
		Xls_Reader xr=new Xls_Reader(path);
		int rowcount=xr.getRowCount(sheetname);
		int colomncount=xr.getColumnCount(sheetname);
		Map<String,Map<String,String>> Data=new HashMap<String,Map<String,String>>();
		for(int i=2; i<=rowcount;i++)
		{
			Map<String,String> coldata=new HashMap<String,String>();
			for(int j=1; j<=colomncount;j++)
			{
				coldata.put(xr.getCellData(sheetname, j, 1).trim(), xr.getCellData(sheetname, j, i).trim());
			}
			Data.put(xr.getCellData(sheetname, 0, i).trim(),coldata );
		}
		return Data;
		
		
	}
	
	public void createReport()
	{
		DateFormat f=new SimpleDateFormat("yyyyMMddhhmmss");
	    Date d= new Date();	
	    String str =f.format(d);
	    htmlReporter =new ExtentHtmlReporter(System.getProperty("user.dir")+"/src/test/java/com/vtiger/reports/ExtentReports"+str+".html");
	    extent =new ExtentReports();
	    extent.attachReporter(htmlReporter);
	    extent.setSystemInfo("Hostname", "Atomation nTest Hub ");
	    extent.setSystemInfo("User Name ", "Priyadeep");
	    htmlReporter.config().setDocumentTitle("Title is here");
	    //Name of report
	    htmlReporter.config().setReportName("Name of Report is Here");
	    //Dark theme
	    htmlReporter.config().setTheme(Theme.DARK);
	   
	    
	    
	    
	}
	
}
