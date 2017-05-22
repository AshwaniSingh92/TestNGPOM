package com.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import FactoryMethods.DriverFactory;

import org.openqa.selenium.WebElement ;
public class FlightBooking extends DriverFactory{
	
		
	
	public FlightBooking(WebDriver driver){		
		
		PageFactory.initElements(driver, this);		
		
	}

	
	
	@FindBy(xpath=".//*[@id='chf_header']/div[2]/div/ul/li[1]/a/span")private WebElement homebutton;

	@FindAll(@FindBy(how= How.XPATH,using=".//div[@class='top_first_part clearfix']//div[1]//span[2]//span[1]"))
	static List<WebElement> flightElements;
	
	@FindAll(@FindBy(how= How.XPATH,using=".//div[@class='top_first_part clearfix']//div[6]//span[2]"))
	static List<WebElement> price;
	
	@FindAll(@FindBy(how= How.XPATH,using=".//div[@class='top_first_part clearfix']//div[3]//span[1]"))
	static List<WebElement> arrivaltime;
	
	@FindAll(@FindBy(how= How.XPATH,using=".//div[@class='top_first_part clearfix']//div[4]//span[1]"))
	static List<WebElement> departuretime;
	
	
	

	public static List<WebElement> getArrivaltime() {
		return arrivaltime;
	}



	public static void setArrivaltime(List<WebElement> arrivaltime) {
		FlightBooking.arrivaltime = arrivaltime;
	}



	public static List<WebElement> getDeparturetime() {
		return departuretime;
	}



	public static void setDeparturetime(List<WebElement> departuretime) {
		FlightBooking.departuretime = departuretime;
	}



	public static List<WebElement> getPrice() {
		return price;
	}



	public static void setPrice(List<WebElement> price) {
		FlightBooking.price = price;
	}



	public List<WebElement> getAllElements() {
		return flightElements;
	}



	public static void setAllElements(List<WebElement> allElements) {
		FlightBooking.flightElements = allElements;
	}



	public WebElement getHomebutton() {
		return homebutton;
	}



	public void setHomebutton(WebElement homebutton) {
		this.homebutton = homebutton;
	}
	
	
	
}
