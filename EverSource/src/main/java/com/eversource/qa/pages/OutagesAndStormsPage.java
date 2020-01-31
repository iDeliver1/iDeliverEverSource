package com.eversource.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eversource.qa.base.TestBase;
import com.eversource.qa.util.Extent_reporter;

public class OutagesAndStormsPage extends TestBase {

	@FindBy(xpath="//ul[@class='nav nav-tabs']//a[contains(text(),'Outages & Storms')]")
	WebElement OutageStorm;
	
	@FindBy(xpath="//ul[@class='list-unstyled']//a[contains(text(),'Report or Check an Outage')]")
	WebElement ReportCheckOutage;
	
	@FindBy(xpath="//input[@id='txtBA']")
	WebElement AccountField;
	
	@FindBy(xpath="//div[@class='col-sm-3 hidden-xs text-center-responsive']//a[@id='btnBillingAccount']")
	
	WebElement GoButton;
	
	@FindBy(xpath="//div[@class='col-sm-3 hidden-xs text-center-responsive']//a[contains(@class,'btn-default disabled')]")
	WebElement DisableGoButton;
	
	
	@FindBy(xpath="//div[@id='dv-ServiceAddress']")
	WebElement Address;
	
	@FindBy(xpath="//a[contains(@class,'btnReportProblem')]")
	WebElement ReportOutage;
	
	@FindBy(xpath="//span[contains(text(),'Neighbors Out')]")
	WebElement NeighborsOut;
	
	@FindBy(xpath="//span[contains(text(),'Neighbors Out')]")
	WebElement CancelButton;
	EverSource_HeaderMenu objcheck;
	
	public OutagesAndStormsPage() {
		PageFactory.initElements(driver, this);
		objcheck = new EverSource_HeaderMenu();
	}

	public void OutageStorm() throws Throwable
	{
		objcheck.CheckHeaderMenu();
		
		
		OutageStorm.click();
		
		ReportCheckOutage.click();
		try{
	
		AccountField.click();
		AccountField.sendKeys("10730101077");
		}catch(Exception e){
			System.out.println(e);
			String cause = e.toString();
			Reporting("Fail", "Insert Account Number", "User Unable to insert account number because of" +cause.substring(1, 88), "User should be able to insert Account Number");
			closeBrowser();
		}
	
	
		try{
			DisableGoButton.isEnabled();
			AccountField.clear();
			AccountField.sendKeys("10730101077");
			GoButton.click();
		}catch(Exception e){
			
		}
		GoButton.click();
		ReportOutage.click();
		Extent_reporter.Menuvalidation("AddressDisplayed Validation", Address);
		
		Thread.sleep(5000);
		NeighborsOut.click();
		CancelButton.click();
		
		
		
		driver.close();
	}
	
}
