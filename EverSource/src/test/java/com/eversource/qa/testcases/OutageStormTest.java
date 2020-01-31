package com.eversource.qa.testcases;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.eversource.qa.base.TestBase;
import com.eversource.qa.pages.OutagesAndStormsPage;
import com.eversource.qa.pages.RegionPage;

public class OutageStormTest extends TestBase {
	OutagesAndStormsPage OutagePage;
	RegionPage Area;
	
	@BeforeTest
	public void setup() throws Throwable
	{
		getReportname("EV_OutageStormTest_Validation");
		initialization("Outarge");
		OutagePage = new OutagesAndStormsPage();	
		Area = new RegionPage();
	}

	@Test
	public void stormOutage() throws Throwable
	{
		log("--------------------    EV_Outage_Validation   -----------------");
		//getParentReportname("EV_Outage_Validation");
		
		Area.SelectRegion();
		
		OutagePage.OutageStorm("Outarge");
		
	}
	
	
}
