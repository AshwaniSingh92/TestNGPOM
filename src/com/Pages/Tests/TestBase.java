package com.Pages.Tests;

import java.util.Date;


import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Pages.FlightBooking;
import com.Pages.SearchPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.gargoylesoftware.htmlunit.javascript.host.Element;
import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import FactoryMethods.DriverFactory;
import FactoryMethods.ListPopulator;
import FactoryMethods.PropertyReader;

public class TestBase extends DriverFactory {
	
	FlightBooking fob;
	SearchPage sp;	
	WebDriver driver;
	Logger logit = Logger.getLogger(this.getClass());
	ExtentReports report ;
	ExtentTest logger;
	int day;
	
	@BeforeClass
	public void Setup(){
		
		
		Date date = new Date();
		
		PropertyReader prop = new PropertyReader();	
		logger = report.createTest("BeforeSuite Initiated");
		PropertyConfigurator.configure("./Resources/Configuration.Properties");
		
		logger.info("Browser started");
		logit.info("++++++++++Starting new Session++++++++++++++++");		
		driver =getDriver(prop.readProperty("browser"));		
		driver.manage().timeouts().implicitlyWait(10000l, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");	
		logit.info("Entered URL");
		fob = new FlightBooking(driver);
		sp = new SearchPage(driver);
		
		
		
	}

	
	@Test
	public void TC_001(){
		
		try{
			
			Assert.assertTrue("Title Mismatch", driver.getTitle().equals("MakeMyTrip, India's No 1 Travel Site | Book Hotels, Flights, Holiday"));
	
		}catch(Throwable e){
			
			logit.info(e);
			Screenshot(driver, "Title Mismatch");
			Teardown();
			System.exit(0);			
		}
		
	}
	
	@Test
	public void TC_003() throws InterruptedException{	
		
		
	
		try{

			logit.info("Entering from City");
			sp.getTextboxone().clear();
			sp.getTextboxone().sendKeys("DEL");
			Thread.sleep(3000l);
			logit.info("Entering To City");			
			sp.getTextboxone().sendKeys(Keys.ENTER);			
				
			Assert.assertTrue("Value Not Entered", sp.getTextboxone().getAttribute("value").equals("New Delhi (DEL)"));
		
		
		}catch(Throwable e){
			
			logit.info(e);
				
			
			try{				
				
				sp.getTextboxone().clear();
				sp.getTextboxone().sendKeys("DEL");
				Thread.sleep(3000l);
				logit.info("Entering To City");			
				sp.getTextboxone().sendKeys(Keys.ENTER);
				Assert.assertTrue("Value Not Entered", sp.getTextboxone().getAttribute("value").equals("New Delhi (DEL)"));
				logit.info("Re-entry Successful");		
				
			}catch(Throwable e2){			
				
				logit.info(e2);
				logit.info("Retry Failure Quitting Application");
				Screenshot(driver, "Text not entered");
				Teardown();
				System.exit(0);					
				
			}		
			
			
		}
			
		
		
	/*Here Exception is handled in the simplest way possible using Throwable and  TestNG assertions			
		This script will enter wrong value in the TextBox destination City(BLR) 
		and after assertion error it will reenter the correct city(MUM)
		logs can be checked for the correct execution flow
		Screenshot can also be checked to see the entered value */
				
			
		try{
			
			
			logit.info("Clearing the destination city Text Field");
			sp.getTextboxtwo().clear();
			logit.info("Entering To city Text Field");
			sp.getTextboxtwo().sendKeys("BLR");	//willingly entering wrong city to show how exception can be handled
			logit.info("Willingly entering the wrong city :"+sp.getTextboxtwo().getAttribute("value"));
			
			Thread.sleep(3000l);
			sp.getTextboxtwo().sendKeys(Keys.ENTER);			
			Assert.assertTrue("Wrong City entered", sp.getTextboxtwo().getAttribute("value").equals("Mumbai (BOM)"));
			
			
		}catch(Throwable e){
			
			logit.info(e);
			Screenshot(driver, "Wrong Destination entered");
					
			
			try{
			
			logit.info("Re-entering destination city Text Field");			
			logit.info("Clearing the destination city Text Field");
			sp.getTextboxtwo().clear();
			logit.info("Entering destination city Text Field");
			sp.getTextboxtwo().sendKeys("MUM");	
			
			Thread.sleep(3000l);
			sp.getTextboxtwo().sendKeys(Keys.ENTER);			
			Assert.assertTrue("Value Not Entered", sp.getTextboxtwo().getAttribute("value").equals("Mumbai (BOM)"));
			Screenshot(driver, "Destination city corrected");
			logit.info("Destination City entered"+sp.getTextboxtwo().getAttribute("value"));
			
			}catch(Throwable e2){
				
				logit.info(e2);
				logit.info("Retry Failure Quitting Application");
				Screenshot(driver, "Wrong Destination entered");
				Teardown();
				System.exit(0);	
				
			}
			
			
			
		}
			
			
		
	}
	
	
	@Test
	public void TC_004() throws InterruptedException{
		
		logit.info("Clicking on date box");
		sp.getDatebox().click();
		Thread.sleep(3000l);
		sp.getDatebox().sendKeys(Keys.TAB);
		Thread.sleep(3000l);
		logit.info("Clicking on passangers box");
		sp.getPass().click();
		sp.getDatebox().sendKeys(Keys.TAB);
		Thread.sleep(3000l);
			
		
		logit.info("Clicking on Search");
		try{
			
		Thread.sleep(5000l);	
		sp.getSearch().click();
		logit.info("Clicked on Search Button");
		
		}catch(Exception e){
			
			logit.info(e);
			
		}	
		
	}
	
	@Test
	public void TC_005(){
		
	logit.info("Wait for the visibility of the element");
	waitforit(fob.getHomebutton());
		
	}
	
	
	
	@Test
	public void TC_006(){
		
		ListPopulator lp = new ListPopulator();	
		
		try{
			
		logit.info("Populating the flight details");		
		
	System.out.println(lp.lpobject(fob.getAllElements(),fob.getPrice(),fob.getDeparturetime(),fob.getArrivaltime()));
		
		}catch(Exception e){
			
			logit.info("Exception in Flight details populator");			
			
		}
		
	}
	
	
	
	
	
	
	
	@AfterSuite
	public void Teardown(){
		
		logit.info("Quitting driver");
		driver.quit();
		
		
	}
	

}
