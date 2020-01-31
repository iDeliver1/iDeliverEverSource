package com.eversource.qa.testcases;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.eversource.qa.base.TestBase;
import com.eversource.qa.pages.AccountHistory;
import com.eversource.qa.pages.HomePage;
import com.eversource.qa.pages.LoginPage;
import com.eversource.qa.pages.PayBill;
import com.eversource.qa.pages.RegionPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homepage;
	String CampName,Account,OrderNo,Contract;
	RegionPage Area;
	PayBill paybill;
	AccountHistory AccountHis;
	
	//Initializing
	@BeforeTest
	public void setUp() throws Throwable{
		getReportname("EV_LoginPageTest_Validation");
		
		initialization();
		loginPage = new LoginPage();
		Area = new RegionPage();
		paybill = new PayBill();
		AccountHis = new AccountHistory();
		Area.SelectRegion();
	}
	
	
	//Login Test
	@Test(priority=1)
	public void LoginTest() throws Throwable{
		log("----------------------- EV_Login_Validation -------------");
		//getParentReportname("EV_Login_Validation");
		//Selecting Region
		
		
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));	
	}
	
	//Account History Test
	@Test(priority=2)
	public void AccountHistoryTest()throws Throwable{
		
		log("----------------------- EV_Account_History_Tab_Validation --------------");
		
		//getParentReportname("EV_Account_History_Tab_Validation");
		
		 HomePage.clickOnAccountsLink("Account History");
		
		 AccountHis.AccountHistoryTab();
	}
	
	//Pay Bill Test
	@Test(priority=3)
	public void PayBillTest()throws Throwable{
		
		log("----------------------- EV_Pay_Bill_Tab_Validation --------------");
		
		//getParentReportname("EV_Pay_Bill_Tab_Validation");
		
		HomePage.clickOnAccountsLink("Pay Bill");
		
		
		paybill.PayBillTab("Aron");
		
	}

	//Closing Browser and saving report 
	@AfterTest
	public void Flush()
	{
		closeBrowser();
	}

}
