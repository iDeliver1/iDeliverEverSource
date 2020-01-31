package com.eversource.qa.testcases;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.eversource.qa.base.TestBase;
import com.eversource.qa.pages.EditProfile;
import com.eversource.qa.pages.HomePage;
import com.eversource.qa.pages.LoginPage;
import com.eversource.qa.pages.RegionPage;


public class EditProfileTest extends TestBase {
	LoginPage loginPage;
	HomePage homepage;
	RegionPage Area;
	EditProfile EditPro;
	
	//Initializing
	@BeforeTest
	public void setUp() throws Throwable{
		getReportname("EV_EditProfileTest_Validation");
		initialization();
		loginPage = new LoginPage();
		Area = new RegionPage();
		EditPro = new EditProfile();
		Area.SelectRegion();
	}

	
	//Login Test
		@Test(priority=1)
		public void LoginTest() throws Throwable{
			log("-----------------------"+new Object(){}.getClass().getEnclosingMethod().getName()+"--------------");
			
			//getParentReportname("EV_Login_Validation");
			
			//Area.SelectRegion();
			homepage =	 loginPage.login(prop.getProperty("username"), prop.getProperty("password"));	
		}
		
		@Test(priority=2)
		public void ProfileTest()throws Throwable{
			log("-----------------------   EV_Profile_Update_Validation  --------------");
			
			//getParentReportname("EV_Profile_Update_Validation");
			
			EditPro.EditProf();
			
		}
		

		//Closing Browser and saving report 
		@AfterTest
		public void Flush()
		{
			closeBrowser();
			}
		
		

}
