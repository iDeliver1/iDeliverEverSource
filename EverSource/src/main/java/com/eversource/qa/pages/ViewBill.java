package com.eversource.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.eversource.qa.base.TestBase;

public class ViewBill extends TestBase {

	public ViewBill() {
		PageFactory.initElements(driver, this);
	}

}
