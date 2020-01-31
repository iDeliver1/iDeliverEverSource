package com.eversource.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eversource.qa.base.TestBase;


public class AccountHistory extends TestBase {
	EverSource_HeaderMenu objcheck;
	
	@FindBy(xpath="//span[@class='filter-option pull-left'][contains(text(),'10010730041')]")
	WebElement SelectButton;
	
	@FindBy(xpath="//div[@class='btn-group bootstrap-select form-control dropup open']//span[@class='text'][contains(text(),'ALL')]")
	WebElement SelectAll;
	
	@FindBy(xpath="//a[@id='main_lnkApply']")
	WebElement FilterButton;
	
	@FindBy(xpath="//table[@id='payHistList']")
	WebElement TableVerfication;
	
	public AccountHistory() {
		PageFactory.initElements(driver, this);
		objcheck = new EverSource_HeaderMenu();
	}
	
		public void AccountHistoryTab(String TestName) throws Throwable{
			
			Thread.sleep(5000);

			WaitForObject(SelectButton, "Click");
			WaitForObject(SelectAll, "Click");
			
			FilterButton.click();
			
	
	if(	TableVerfication.findElements(By.tagName("tr")).size()<1){
		log("There is no data");
		Reporting("FAIL"," Table Records ","There is not records in the table","There must be records on table",TestName);
	}
	else{
		log("There is data");
		Reporting("PASS"," Table Records ","There is  records in the table","There must be records on table",TestName);
	}
		}
	
}
