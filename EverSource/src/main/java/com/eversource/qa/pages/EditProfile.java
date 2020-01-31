package com.eversource.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eversource.qa.base.TestBase;
import com.eversource.qa.util.Extent_reporter;
import com.eversource.qa.util.Gernric_functions;

public class EditProfile extends TestBase{

	@FindBy(xpath="//a[@id='userLink']")
	WebElement Userlogo;
	
	@FindBy(xpath="//input[@id='LastName']")
	WebElement UserLastName;
	
	@FindBy(xpath="//input[@id='edit-submit']")
	WebElement SaveUdate;
	
	@FindBy(xpath="//h1[contains(text(),'Edit My Profile')]")
	WebElement SaveVerfication;
	
	public EditProfile() {
		PageFactory.initElements(driver, this);
	}

	
	public void EditProf() throws Throwable{
		waitforElement(10, Userlogo);
		
		
		WaitForObject(Userlogo,"Click");
	
		UserLastName.clear();
		
		UserLastName.sendKeys("Test"+Gernric_functions.fTimestamp());
		
		SaveUdate.click();
		
		Extent_reporter.Menuvalidation("EDIT MY PROFILE Page loads successfully  ", SaveVerfication);
		
	}
}
