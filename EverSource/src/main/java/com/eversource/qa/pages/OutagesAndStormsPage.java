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
		AccountField.click();
		AccountField.click();
		AccountField.sendKeys("10730101077");
	
		if (isClickable(GoButton))
		{
			System.out.println("Clickable? " + GoButton.isEnabled());
			GoButton.click();
		}else{
			AccountField.clear();
			AccountField.sendKeys("10730101077");
			GoButton.click();
		}
			
		
		GoButton.click();
		ReportOutage.click();
		NeighborsOut.click();
		CancelButton.click();
		Extent_reporter.Menuvalidation("AddressDisplayed", Address);
		
	}
	
}
