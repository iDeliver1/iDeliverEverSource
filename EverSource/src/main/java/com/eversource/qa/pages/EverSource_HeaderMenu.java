package com.eversource.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eversource.qa.base.TestBase;
import com.eversource.qa.util.Extent_reporter;

public class EverSource_HeaderMenu extends TestBase {

	@FindBy(xpath=" //div[@class='header-top']")
	static WebElement EverSouceTopHeader;
	
	@FindBy(xpath=" //div[@class='primary-nav-wrapper']")
	static WebElement EverSouceFileHeader;
	
	@FindBy(xpath=" //div[@id='divLeftNav']")
	static WebElement SideBarNavigation;
	
	public EverSource_HeaderMenu(){
		PageFactory.initElements(driver, this);
	}
	
	
	public static void CheckHeaderMenu() throws Throwable{
		Extent_reporter.Menuvalidation("Header TopMenu Validation",EverSouceTopHeader );
		
		Extent_reporter.Menuvalidation("Header Menu Validation",EverSouceFileHeader );
	}
	
	public static void CheckSideMenu() throws Throwable{
		Extent_reporter.Menuvalidation("Side Menu Validation",SideBarNavigation );
		
		
	}
}
