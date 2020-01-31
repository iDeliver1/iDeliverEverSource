package com.eversource.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eversource.qa.base.TestBase;
import com.eversource.qa.util.Extent_reporter;


public class PayBill extends TestBase {

	@FindBy(xpath=" //span[@id='main_lblAccountNo']")
	WebElement AccountNumber;
	
	@FindBy(xpath="//span[@id='main_lblNickName']")
	WebElement AccountNickName;
	
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
	
	@FindBy(xpath="//input[@id='main_txtOtherAmt']")
	WebElement OtherAmtDue;
	
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
	String AccNo,AccDate,DDate,AmtPri,OtherAmountDue = "40.25";
	
	
	
	public PayBill() {
		PageFactory.initElements(driver, this);
		
	}

	
	public void PayBillTab(String PaymentOption ) throws Throwable{
		try{
			if(AccountNickName.getText().isEmpty()){
				AccNo = AccountNumber.getText();
			}
			
		}catch(Exception e){
				
			AccNo = AccountNumber.getText().concat(" "+AccountNickName.getText());
		}
	
		
		
		//Checking PatTest is there or not
		/*if(AccountNickName.getText().isEmpty()){
			AccNo = AccountNumber.getText();
		}
		else{
			AccNo = AccountNumber.getText().concat(" "+AccountNickName.getText());
		}*/
		
		
		log("Account Number is "+AccNo);
		
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
		   
		  //Checking Amount is $0.00 or not
		   AmtPri = AmountPrice.getText();
		   if (AmtPri.contains("0.00")){  //if it is $0.00 the clicking on Other due with input value of $40.25 
			   OtherDue.click();
			   OtherAmtDue.clear();
			   OtherAmtDue.sendKeys(OtherAmountDue);
			   AmtPri ="$"+ OtherAmountDue;
		   }else{
			   AmountDue.click();
		   }
		
		   SelectDateNow.click();
		   AccDate=ActualDate.getText();
		   DDate = DueDate.getText();
		  
		   Submit.click();
		   
		   //Validation for Account Number equals or not
		  
		   Extent_reporter.Argvalidation("Account Number ",AccNo, AccountNumber1.getText());
		   
		 //Validation for Due Date equals or not
		 
		   Extent_reporter.Argvalidation("Due Date ",DDate, DueDate1.getText());
		   
		 //Validation for Amount Price equals or not
	
		   Extent_reporter.Argvalidation("Amount Price ",AmtPri, AmountPrice1.getText());
		   
		 //Validation for Actual Date equals or not
		 
		   Extent_reporter.Argvalidation("Actual Date ",AccDate, ActualDate1.getText());
		
		
		
	}
	
}
