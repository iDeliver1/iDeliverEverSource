package com.eversource.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.eversource.qa.base.TestBase;
import com.eversource.qa.util.Extent_reporter;


public class PayBill extends TestBase {

	@FindBy(xpath=" //span[@id='main_lblAccountNo']")
	WebElement AccountNumber;
	
	@FindBy(xpath="//span[@class='filter-option pull-left'][contains(text(),'Select Bank Account')]")
	WebElement SelectPaymentOption;
	
	@FindBy(xpath="  //div[@class='btn-group bootstrap-select form-control open']//li[2]//a[1]")
	WebElement PaymentAron;
	
	@FindBy(xpath="  //span[contains(text(),'KUBRA_TEST -3456')]")
	WebElement PaymentKubra;
	
	@FindBy(xpath="  //label[contains(text(),'Amount Due:')]")
	WebElement AmountDue;
	
	@FindBy(xpath=" //span[@id='main_lblAmountDue']")
	WebElement AmountPrice;
	
	@FindBy(xpath=" //label[contains(text(),'Other:')]")
	WebElement OtherDue;
	
	@FindBy(xpath="//label[contains(text(),'Pay Now')]")
	WebElement SelectDateNow;
	
	@FindBy(xpath="//span[@id='main_lblPayASAP']")
	WebElement ActualDate;
	
	@FindBy(xpath=" //label[contains(text(),'Select Other ...')]")
	WebElement SelectDateOther;
	
	@FindBy(xpath="  //input[@id='main_txtOtherDate']")
	WebElement EnterDate;
	
	@FindBy(xpath=" //span[@id='main_lblDueDate']")
	WebElement DueDate;
	
	@FindBy(xpath=" //td[@class='tdDueDate']")
	WebElement DueDate1;
	
	@FindBy(xpath="//td[@class='tdAccountNumber']")
	WebElement AccountNumber1;
	
	@FindBy(xpath="//td[@class='tdPaymentDate']")
	WebElement ActualDate1;
	
	@FindBy(xpath=" //td[@class='tdPaymentAmount']")
	WebElement AmountPrice1;
	
	@FindBy(xpath="//a[@id='main_btnConfirm']")
	WebElement Submit;
	String AccNo,AccDate,DDate,AmtPri;
	
	
	public PayBill() {
		PageFactory.initElements(driver, this);
	}

	
	public void createPayBill(String PaymentOption) throws Throwable{
		
		EverSource_HeaderMenu.CheckHeaderMenu();
		
		
		AccNo = AccountNumber.getText();
		log("Account Number is "+AccountNumber.getText());
		
		SelectPaymentOption.click();
		
		   //Switch expression  for Payment Option
		   switch(PaymentOption){  
		   //Case statements  
		   case "Aron": PaymentAron.click();log("Clicked on Aron Payment Method");
		   break;  
		   case "Kubra": PaymentKubra.click();log("Clicked on Kubra Payment Method");  
		   break;  
		   
		   default:log("No Payment Option found"); 
		   PaymentAron.click();
		   }  
		   
		   AmountDue.click();
		   AmtPri = AmountPrice.getText();
		
		   SelectDateNow.click();
		   AccDate=ActualDate.getText();
		   DDate = DueDate.getText();
		  
		   Submit.click();
		   
		   Extent_reporter.Argvalidation("Account Number Validation",AccNo, AccountNumber1.getText());
		   
		   Extent_reporter.Argvalidation("Due Date Validation",DDate, DueDate1.getText());
		   
		   Extent_reporter.Argvalidation("Amount Price Vaildation",AmtPri, AmountPrice1.getText());
		   
		   Extent_reporter.Argvalidation("Actual Date Validation",AccDate, ActualDate1.getText());
		
		
		
	}
	
}
