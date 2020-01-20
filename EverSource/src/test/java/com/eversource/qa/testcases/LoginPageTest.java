package com.eversource.qa.testcases;



import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
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
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
		Area = new RegionPage();
		paybill = new PayBill();
		AccountHis = new AccountHistory();
	}
	
	
	//Login Test
	@Test(priority=1)
	public void LoginTest() throws Throwable{
		log("-----------------------"+new Object(){}.getClass().getEnclosingMethod().getName()+"--------------");
		
		getReportname(new Object(){}.getClass().getEnclosingMethod().getName());
		
		//Selecting Region
		Area.SelectRegion("New Hampshire");
		
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));	
	}
	
	//Account History Test
	@Test(priority=2)
	public void AccountHistoryTest()throws Throwable{
		
		log("-----------------------"+new Object(){}.getClass().getEnclosingMethod().getName()+"--------------");
		
		getReportname(new Object(){}.getClass().getEnclosingMethod().getName());
		
		 HomePage.clickOnAccountsLink("Account History");
		
		 AccountHis.AccountHistoryTab();
	}
	
	//Pay Bill Test
	@Test(priority=3)
	public void PayBillTest()throws Throwable{
		
		log("-----------------------"+new Object(){}.getClass().getEnclosingMethod().getName()+"--------------");
		
		getReportname(new Object(){}.getClass().getEnclosingMethod().getName());
		
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
