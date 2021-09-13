package com.gp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNeCustomerPage {

	WebDriver driver;
	public AddNeCustomerPage(WebDriver ldriver) {
		this.driver=ldriver;
	}
	
	@FindBy (xpath="/html/body/div[3]/div/ul/li[2]/a")
	WebElement lnkAddNeCustomer;
	
	@FindBy (name="name")
	WebElement txtCustomerName;
	
	public void clickAddNewCustomerLink() {
		lnkAddNeCustomer.click();
	}
	
	public void custName(String cname) {
		txtCustomerName.sendKeys(cname);
	}
	
	public void custdob(String mm, String dd, String yy) {
			
	}
}
