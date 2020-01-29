package com.eversource.qa.pages;


import java.util.List;

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
	
	@FindBy(xpath= "//ul[@class='nav nav-tabs']//a[contains(text(),'My Account')]")
	static 	List<WebElement> checklist ;
	
	static EverSource_HeaderMenu objcheck;
	
	@FindBy(xpath= "//a[contains(text(),'Logout')]")
	WebElement LogoutLink;
	
	
	//Initializing the Page Objects:
			public HomePage(){
				super();
				PageFactory.initElements(driver, this);
				objcheck = new EverSource_HeaderMenu();
			}
			
			//Actions:
			public String validateHomePageTitle(){
				return driver.getTitle();
			}
			
			public boolean verifyCorrectUserName(){
				return SalesForceHomeLogo.isDisplayed();
			}
			
		
			
			public static void clickOnAccountsLink(String regionName ) throws Throwable{
				
				log(regionName);
			
				
				
				Thread.sleep(5000);
				WaitForObject(AccountsLink,"Click");
				
				   //Switch expression  
				   switch(regionName){  
				   //Case statements  
				   
				   case "Account Overview":
					  
					   AccountOverview.click();
					   log("Clicked on Account Overview");
					   break;
				   case "Pay Bill": 
					   WaitForObject(Paybill,"Click");
					   log("Clicked on Pay Bill Link"); 
					   Reporting("PASS"," Click on My Account Tab","User  Clicked successfully on PayBill Tab","User should be abble to click on Pay Bill Tab");
					   objcheck.CheckHeaderMenu();
					   break;
				   case "View Bill": 
					   Viewbill.click();
					   log("Clicked on View Bill Link");
					   break;
				   case "Account History": 
					   WaitForObject(AccHisLink,"Click");
					   log("Clicked on Account History Link");
					   Reporting("PASS"," Click on My Account Tab","User Clicked successfully on Account History Tab","User should be abble to click on Account History Tabs Tab");
					   objcheck.CheckHeaderMenu();
					   objcheck.CheckSideMenu();
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
