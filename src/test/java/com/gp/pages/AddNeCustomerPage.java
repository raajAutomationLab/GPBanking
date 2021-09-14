package com.gp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNeCustomerPage {

	WebDriver driver;

	public AddNeCustomerPage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(xpath = "/html/body/div[3]/div/ul/li[2]/a")
	WebElement lnkAddNeCustomer;

	@FindBy(name = "name")
	WebElement txtCustomerName;

	@FindBy(name = "rad1")
	WebElement rdGender;

	@FindBy(name = "dob")
	WebElement txtdob;

	@FindBy(name = "addr")
	WebElement txtaddress;

	@FindBy(name = "city")
	WebElement txtcity;

	@FindBy(name = "state")
	WebElement txtstate;

	@FindBy(name = "pinno")
	WebElement txtpinno;

	@FindBy(name = "telephoneno")
	WebElement txttelephoneno;
	
	@FindBy (name="emailid")
	WebElement txtemailid;
	
	@FindBy (name="password")
	WebElement txtpassword;
	
	@FindBy (name="sub")
	WebElement btnSubmit;

	public void clickAddNewCustomerLink() {
		lnkAddNeCustomer.click();
	}

	public void custName(String cname) {
		txtCustomerName.sendKeys(cname);
	}

	public void custGender(String cGender) {
		rdGender.click();
	}

	public void custdob(String mm, String dd, String yy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);

	}

	public void custAddress(String caddress) {
		txtaddress.sendKeys(caddress);
	}

	public void custCity(String ccity) {
		txtcity.sendKeys(ccity);
	}

	public void custState(String cstate) {
		txtstate.sendKeys(cstate);
	}

	public void custPinno(String cpinno) {
		txtpinno.sendKeys(String.valueOf(cpinno));
	}
	
	public void custMobile(String cmobile) {
		txttelephoneno.sendKeys(String.valueOf(cmobile));
	}
	public void custEmail(String cemailid) {
		txtemailid.sendKeys(cemailid);
	}
	
	public void custPasword(String cpassword) {
		txtpassword.sendKeys(cpassword);
	}
	
	public void custSubmit() {
		btnSubmit.click();
	}
}
