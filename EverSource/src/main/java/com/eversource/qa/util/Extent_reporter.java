package com.eversource.qa.util;


import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.eversource.qa.base.TestBase;


public class Extent_reporter extends TestBase {
  static ExtentTest logger;
  static ExtentTest parent_logger;
  static ExtentTest child_logger;
  static int Stepnumber=1,i=1,j;
   static int functioncall=1;

//Getting TestName
  public static ExtentTest CreateRoportname(String Step_details,ExtentReports extent1){
	  logger = extent1.createTest(Step_details);
		
		return logger;
		
  }
  
  public static ExtentTest CreateParentRoportname(String Step_details,ExtentReports extent1){
		parent_logger = logger.createNode("Step Number "+i+" "+Step_details);
		functioncall=1;
		j=i;
		i=i+1;
		return parent_logger;
		
	}
	
	public static ExtentTest CreateChildRoportname(String Step_details,ExtentReports extent1){
		if(functioncall==1){ //For Checking Parent Logger is called or not
			Stepnumber=1;
		}
		child_logger = parent_logger.createNode("Step Number "+j+"."+Stepnumber+" "+Step_details);
		Stepnumber=Stepnumber+1;
		functioncall=functioncall+1;
		return child_logger;
		
	}
	
	
//Reporting for Pass & Fail Event 
	public static void Report(String Status1,String ActualStep,String ExpectedStep) throws Throwable{
		if(Status1.equalsIgnoreCase("PASS")){
			child_logger.log(Status.INFO, ExpectedStep);
			child_logger.log(Status.PASS, ActualStep);
			child_logger.addScreenCaptureFromPath(Gernric_functions.fScreenReport());
		}
		else{
			child_logger.log(Status.INFO, ExpectedStep);
			child_logger.log(Status.FAIL, ActualStep);
			closeBrowser();
		}
}
	
	//Validation for actual and expected 
	public static void validation(String Actual,String Expected) throws Throwable{
		
		try{
			Assert.assertEquals(Actual, Expected);
			Report("PASS","Page launch Successfull"+ Actual ,"Should be able to launch "+Expected);
			}catch(Exception e){ 
				Report("FAIL","Page launch unsuccessfull"+ Actual ,"Should be able to launch "+Expected);
			}
	
	}
	
public static void Argvalidation(String StepName,String Actual,String Expected) throws Throwable{
		
		try{
			Assert.assertEquals(Actual, Expected);
			Report("PASS",StepName+" is equal to "+Actual,StepName+"should be equal to "+Expected);
			
			log(StepName+" Validation     "+Actual + " is equal to " +Expected);
			
			}catch(Exception e){ 
				log(StepName+"  Validation    "+ Actual + " is not  equal to " +Expected+" because "+e);
				
				Report("FAIL",StepName+"is equal to "+Actual+""+e,StepName+"should be equal to "+Expected);
			}
	
	}

public static void Menuvalidation(String StepName,WebElement element ) throws Throwable{
	
	try{
		 Assert.assertEquals(true, element.isDisplayed());
		Report("PASS", StepName+" is Visible ",StepName+" Must be visible" );
		log(StepName + " is Visible ");
		}catch(Exception e){ 
			log(StepName+" is not Visible ");
			Report("FAIL",StepName+ " is not visible because"+e ,StepName+" Must be visible");
			
		}

}

}
