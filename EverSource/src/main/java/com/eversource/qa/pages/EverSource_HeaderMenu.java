package com.eversource.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eversource.qa.base.TestBase;
import com.eversource.qa.util.Extent_reporter;

public class EverSource_HeaderMenu extends TestBase {

	@FindBy(xpath="//div[@class='header-top']")
					
	static WebElement EverSouceTopHeader;
	
	@FindBy(xpath="//div[@class='primary-nav-wrapper']")
	static WebElement EverSouceFileHeader;
	
	@FindBy(xpath="//div[@id='divLeftNav']")
	static WebElement SideBarNavigation;
	
	public EverSource_HeaderMenu(){
		PageFactory.initElements(driver, this);
	}
	
	
	public  void CheckHeaderMenu() throws Throwable{
	
		//WaitForObject(EverSouceTopHeader);
		
		Extent_reporter.Menuvalidation("Header TopMenu ",EverSouceTopHeader);
		
		Extent_reporter.Menuvalidation("Header Menu ",EverSouceFileHeader);
	}
	
	public  void CheckSideMenu() throws Throwable{
		WaitForObject(SideBarNavigation,"Check");
		
		Extent_reporter.Menuvalidation("Side Menu ",SideBarNavigation );
		
		
	}
}
