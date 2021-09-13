package com.gp.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.gp.pages.AddNeCustomerPage;
import com.gp.pages.BaseClass;
import com.gp.pages.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass{

	@Test
	public void addNewCustomer() {
		logger = report.createTest("Login to GP");

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		logger.info("Sterting application");

		loginPage.loginToGP(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		logger.pass("Login done successfully");
		
		AddNeCustomerPage addcus = PageFactory.initElements(driver, AddNeCustomerPage.class);
		addcus.clickAddNewCustomerLink();
	}
}
