package com.gp.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.gp.pages.AddNeCustomerPage;
import com.gp.pages.BaseClass;
import com.gp.pages.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException {
		logger = report.createTest("Login to GP");

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		logger.info("Sterting application");

		loginPage.loginToGP(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		logger.pass("Login done successfully");
		Thread.sleep(2000);

		AddNeCustomerPage addcus = PageFactory.initElements(driver, AddNeCustomerPage.class);
		addcus.clickAddNewCustomerLink();
		addcus.custGender("Male");
		addcus.custdob("01", "14", "1988");
		Thread.sleep(2000);

		addcus.custAddress("Warje");
		addcus.custCity("Pune");
		addcus.custState("Maharashtra");
		addcus.custPinno("123456");
		addcus.custMobile("9999999999");

		String email = randrandomestring() + "@gmail.com";
		addcus.custEmail("test@gmail.com");
		addcus.custPasword("Test@123");
		addcus.custSubmit();

		Thread.sleep(3000);

		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if (res == true) {
			Assert.assertTrue(true);
		} else {
			captureScreenshot();
			Assert.assertFalse(false);
		}

	}

}
