package com.eversource.qa.pages;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eversource.qa.base.TestBase;
import com.eversource.qa.util.TestUtil;

public class RegionPage  extends TestBase {

	
	//Page Factory - OR:
	@FindBy(xpath="//div[@id='RegionSelectorModal']//div[@class='modal-dialog']//div[@class='modal-content col-xs-12 col-sm-10 col-sm-offset-1 col-md-12 col-md-offset-0']//div[@class='modal-body']")
	static
	WebElement EverSourceMap;
	
		@FindBy(xpath="//div[@class='col-sm-6 col-xs-8']//img[@class='logo img-responsive']")
		WebElement EverSourcelogo;
		
		@FindBy(xpath="//span[@id='CurrentServiceArea']")
		WebElement ServiceRegionClick;
			
			@FindBy(xpath="//div[@id='map']//a[contains(text(),'New Hampshire')]")
			static
			WebElement new_hampshire_link;
			
			@FindBy(xpath="//div[@id='map']//a[contains(text(),'Connecticut')]")
			static
			WebElement connecticut;
			
			@FindBy(xpath="//div[@id='map']//a[contains(text(),'Western Massachusetts')]")
			static
			WebElement western_massachusetts;
			
			@FindBy(xpath="//div[@id='map']//a[contains(text(),'Eastern Massachusetts')]")
			static
			WebElement eastern_massachusetts;
			
			@FindBy(xpath="//div[@class='btn-group bootstrap-select ddlTerritorySelector dropup open']//ul[@class='dropdown-menu inner']//following-sibling::li")
			List<WebElement> checklist;
			
	
	@FindBy(xpath="//input[@id='login']")
	WebElement yopuser;
	
	@FindBy(xpath="//input[@class='sbut']")
	WebElement yopbtn;
	
	@FindBy(xpath="//div[@id='mailmillieu']/div[2]")
	WebElement yopotp;
	static TestUtil objtest = new TestUtil();
	
	public RegionPage() {
		PageFactory.initElements(driver, this);
		
	}

		public LoginPage SelectRegion(){

			try{
				EverSourceMap.isDisplayed();
			}catch(Exception e){
				ServiceRegionClick.click();
			}
			int regionnumber = getRandomInteger();
	
			
		   //Switch expression  
		   switch(regionnumber){  
		   //Case statements  
		   case 1: new_hampshire_link.click();log("Clicked on New Hampshire Link");
		   break;  
		   case 2: western_massachusetts.click();log("Clicked on western massachusetts Link");  
		   break;  
		   case 3: connecticut.click(); log("Clicked on connecticut Link");
		   break;
		   case 4: eastern_massachusetts.click(); log("Clicked eastern massachusetts Link");
		   break;
		   //Default case statement  
		   default:log("Not region found");  
		   connecticut.click();
		   }  
		
		
		
			return new LoginPage();
		}
}
