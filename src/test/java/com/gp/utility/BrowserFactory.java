package com.gp.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {

	public static WebDriver startAppplication(WebDriver driver, String browserName, String appURL) {

		if (browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver93.exe");
			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {

		} else if (browserName.equals("IE")) {

		} else {
			System.out.println("Sorry, we do not support this browser");
		}

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return driver;
	}

	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}
}
