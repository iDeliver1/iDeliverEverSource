package com.eversource.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eversource.qa.base.TestBase;


public class AccountHistory extends TestBase {
	
	public AccountHistory() {
		PageFactory.initElements(driver, this);
	}
	
		public void CheckMenu() throws Throwable{
			EverSource_HeaderMenu.CheckHeaderMenu();
			
			EverSource_HeaderMenu.CheckSideMenu();
		}
	
}
