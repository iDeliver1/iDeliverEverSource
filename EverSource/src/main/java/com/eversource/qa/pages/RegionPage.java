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

		public LoginPage SelectRegion(String regionName){

			try{
				EverSourceMap.isDisplayed();
			}catch(Exception e){
				
			}
		regionName = regionName.toLowerCase();
		   //Switch expression  
		   switch(regionName){  
		   //Case statements  
		   case "new hampshire": new_hampshire_link.click();log("Clicked on New Hampshire Link");
		   break;  
		   case "western massachusetts": western_massachusetts.click();log("Clicked on western massachusetts Link");  
		   break;  
		   case "connecticut": connecticut.click(); log("Clicked on connecticut Link");
		   break;
		   case "eastern massachusetts": eastern_massachusetts.click(); log("Clicked eastern massachusetts Link");
		   break;
		   //Default case statement  
		   default:log("Not region found");  
		   connecticut.click();
		   }  
		
		
		
			return new LoginPage();
		}
}
