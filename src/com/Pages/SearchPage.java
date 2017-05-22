package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FactoryMethods.DriverFactory;

public class SearchPage extends DriverFactory{
	
	
	public SearchPage (WebDriver driver){
		
		
		PageFactory.initElements(driver, this);	
		
		
	}
	
	
	
	@FindBy (xpath = ".//*[@id='hp-widget__sfrom']") private WebElement textboxone;
	@FindBy (xpath = ".//*[@id='hp-widget__sTo']") private WebElement textboxtwo;
	@FindBy(xpath= ".//*[@id='hp-widget__depart']")private WebElement datebox;
	@FindBy(xpath= ".//*[@id='dp1494341631056']/div/div[1]/table/tbody/tr[4]/td[4]/a")private WebElement datefield;
	@FindBy(xpath= ".//*[@id='hp-widget__paxCounter']")private WebElement pass;
	@FindBy(xpath= ".//*[@id='js-adult_counter']/li[4]")private WebElement passengers;
	@FindBy(xpath=".//*[@id='searchBtn']")private WebElement search;
	
	
	

	


	public WebElement getSearch() {
		return search;
	}

	public void setSearch(WebElement search) {
		this.search = search;
	}

	public WebElement getPass() {
		return pass;
	}

	public void setPass(WebElement pass) {
		this.pass = pass;
	}

	public WebElement getPassengers() {
		return passengers;
	}

	public void setPassengers(WebElement passengers) {
		this.passengers = passengers;
	}

	public WebElement getDatefield() {
		return datefield;
	}

	public void setDatefield(WebElement datefield) {
		this.datefield = datefield;
	}

	public WebElement getTextboxone() {
		return textboxone;
	}




	public void setTextboxone(WebElement textboxone,String param) {
		this.textboxone = textboxone;		
		textboxone.sendKeys(param);
		
	}




	public WebElement getTextboxtwo() {
		return textboxtwo;
	}




	public void setTextboxtwo(WebElement textboxtwo) {
		this.textboxtwo = textboxtwo;
	}


	public WebElement getDatebox() {
		return datebox;
	}



	public void setDatebox(WebElement datebox) {
		this.datebox = datebox;
	}

	
	
	
	
	
}
