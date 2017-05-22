package FactoryMethods;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import com.Pages.FlightBooking;
import com.gargoylesoftware.htmlunit.javascript.host.Element;

public class DriverFactory {
	
	
	
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	
	
	
	public WebDriver getDriver(String btype){
		
		
				
		if(btype.toLowerCase().equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Java/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		}
		if(btype.toLowerCase().equals("internet explorer")){
			
			System.setProperty("webdriver.ie.driver", "C:/Program Files (x86)/Java/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			
		}
		return driver;
		
	}
	
	
	public void waitforit(WebElement element){
		
		if(!element.isDisplayed()){
		WebDriverWait wait = new WebDriverWait(driver,5000l);		
		wait.until(ExpectedConditions.visibilityOf(element));
		}
		
		
	}
	
	public void waitforinvisible(String path){
		
		WebDriverWait wait = new WebDriverWait(driver,5000l);		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(path)));
	
		
	}
	
	
	public void Screenshot(WebDriver driver,String step){
		
		  File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  try {
		   	   FileUtils.copyFile(src, new File("./Screenshots/"+step+System.currentTimeMillis()+".png"));
		         }		   
		  catch (IOException e)
		   
		  {		   
		  System.out.println(e.getMessage());		   
		   }	
	}
	
	

}
