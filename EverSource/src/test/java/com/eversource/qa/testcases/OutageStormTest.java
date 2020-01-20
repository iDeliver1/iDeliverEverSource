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
	public void setup()
	{
		initialization();
		OutagePage = new OutagesAndStormsPage();	
		Area = new RegionPage();
	}

	@Test
	public void stormOutage() throws Throwable
	{
		log("-----------------------"+new Object(){}.getClass().getEnclosingMethod().getName()+"--------------");
		getReportname(new Object(){}.getClass().getEnclosingMethod().getName());
		
		Area.SelectRegion("New Hampshire");
		
		OutagePage.OutageStorm();
		
	}
}
