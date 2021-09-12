package com.gp.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.gp.utility.BrowserFactory;
import com.gp.utility.ConfigDataProvider;
import com.gp.utility.ExcelDataProvider;
import com.gp.utility.Helper;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setUpSuite() {
		Reporter.log("Setting up reportsand test is getting ready", true);
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		ExtentHtmlReporter extent = new ExtentHtmlReporter(
				new File(System.getProperty("user.dir") + "/Reports/GP_"+Helper.getCurrentDateTime()+".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		Reporter.log("Setting done and test can be started", true);

	}

	@BeforeClass
	public void setUp() {
		Reporter.log("Trying to start browser and getting application ready", true);
		driver = BrowserFactory.startAppplication(driver, config.getBrowser(), config.getStaggingURL());
		Reporter.log("Browser and application is up and running", true);
	}

	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}

	@AfterMethod
	public void teardown(ITestResult result) throws IOException {
		Reporter.log("Test is about to end", true);
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.fail("Test failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}else if(result.getStatus() == ITestResult.SUCCESS){
			logger.pass("Test failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());

		}
		report.flush();
		Reporter.log("Test completed>>Reports generated", true);
	}

}
