package com.eversource.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eversource.qa.base.TestBase;

public class HomePage extends TestBase{
		
	@FindBy(xpath="//img[@id='phHeaderLogoImage']")
	WebElement SalesForceHomeLogo;
	
	@FindBy(xpath="//ul[@class='list-unstyled']//a[contains(text(),'Pay Bill')]")
	static
	WebElement Paybill;
	
	@FindBy(xpath="//ul[@class='list-unstyled']//a[contains(text(),'Account Overview')]")
	static
	WebElement AccountOverview;
	
	@FindBy(xpath="//ul[@class='list-unstyled']//a[contains(text(),'View Bill')]")
	static 	WebElement Viewbill;
	
	@FindBy(xpath="//li[@id='home_Tab']//a[contains(text(),'Home')]")
	WebElement HomeLink;
	
	@FindBy(xpath="//ul[@class='list-unstyled']//a[contains(text(),'Account History')]")
	static 	WebElement AccHisLink;
	
	@FindBy(xpath= "//ul[@class='nav nav-tabs']//a[contains(text(),'My Account')]")
	static 	WebElement AccountsLink;
	

	
	@FindBy(xpath= "//a[contains(text(),'Logout')]")
	WebElement LogoutLink;
	
	
	//Initializing the Page Objects:
			public HomePage(){
				super();
				PageFactory.initElements(driver, this);
			}
			
			//Actions:
			public String validateHomePageTitle(){
				return driver.getTitle();
			}
			
			public boolean verifyCorrectUserName(){
				return SalesForceHomeLogo.isDisplayed();
			}
			
		
			
			public static void clickOnAccountsLink(String regionName ) throws InterruptedException{
				AccountsLink.click();
				log(regionName);
				
				   //Switch expression  
				   switch(regionName){  
				   //Case statements  
				   case "Account Overview":
					   waitforElement(20, AccountOverview);
					   AccountOverview.click();
					   log("Clicked on Account Overview");
					   break;
				   case "Pay Bill": 
					   waitforElement(20, Paybill);
					   Paybill.click();
					   log("Clicked on Pay Bill Link");  
					   break;
				   case "View Bill": 
					   waitforElement(20, Viewbill);
					   Viewbill.click();
					   log("Clicked on View Bill Link");
					   break;
				   case "Account History": 
					   waitforElement(20, AccHisLink);
					   AccHisLink.click();
					   log("Clicked on Account History Link");
					   break;
				   //Default case statement  
				   default:log("Not link found"); 
				 
				   }  
				  
			}
			
		
			public LogoutPage clickOnLogoutLink(){
				LogoutLink.click();
				return new LogoutPage();
			}
			

}
