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
  static int Stepnumber=1;
  

//Getting TestName
	public static ExtentTest CreateRoportname(String Step_details,ExtentReports extent1){

		parent_logger = extent1.createTest("Step - "+Stepnumber+" "+Step_details);
		child_logger = parent_logger.createNode("Step - "+Stepnumber+".1 "+Step_details);
		Stepnumber=Stepnumber+1;
		return child_logger;
		
	}
	
	
//Reporting for Pass & Fail Event 
	public static void Report(String Status1,String Detail) throws Throwable{
		if(Status1.equalsIgnoreCase("PASS")){
			child_logger.log(Status.PASS, Detail);
			child_logger.addScreenCaptureFromPath(Gernric_functions.fScreenReport());
		}
		else{
			child_logger.log(Status.FAIL, Detail);
			closeBrowser();
		}
}
	
	//Validation for actual and expected 
	public static void validation(String StepName,String Actual,String Expected) throws Throwable{
		
		try{
			Assert.assertEquals(Actual, Expected);
			Report("PASS", StepName+" is succcessful &  page is open " +Expected);
			}catch(AssertionError e){ 
				Report("FAIL",StepName+ " is unsuccessful because "+e);
			}
	
	}
	
public static void Argvalidation(String StepName,String Actual,String Expected) throws Throwable{
		
		try{
			Assert.assertEquals(Actual, Expected);
			Report("PASS",StepName+"      "+Actual + " is equal to " +Expected);
			log(StepName+"      "+Actual + " is equal to " +Expected);
			}catch(AssertionError e){ 
				log(StepName+"      "+ Actual + " is not  equal to " +Expected+" because "+e);
				Report("FAIL",StepName+"      "+ Actual + " is not  equal to " +Expected+" because "+e);
			}
	
	}

public static void Menuvalidation(String StepName,WebElement element ) throws Throwable{
	
	try{
		Assert.assertEquals(true, element.isDisplayed());
		Report("PASS", StepName+" is Visible " );
		log(StepName + " is Visible ");
		}catch(AssertionError e){ 
			log(StepName+" is not Visible ");
			Report("FAIL",StepName+ " is not visible because "+e);
			
		}

}

}
