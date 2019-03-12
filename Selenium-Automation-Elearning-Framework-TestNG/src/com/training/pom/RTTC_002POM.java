package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RTTC_002POM {
	private WebDriver driver;

	public RTTC_002POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='fa fa-user-o']")
	private WebElement accountLink;

	@FindBy(xpath = "//span[contains(text(),'LOGIN / REGISTER')]")
	private WebElement loginLink;

	@FindBy(linkText = "Register")
	private WebElement registerbtn;

	@FindBy(id = "input-email")
	private WebElement email;

	@FindBy(id = "input-password")
	private WebElement password;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement login;
	
	

	public void clickaccountLink() {
		this.accountLink.click();
	}

	public void clickloginLink() {
		this.loginLink.click();
	}

	public void clickregisterbtn() {
		this.registerbtn.click();
	}

	public void sendemail(String email) {
		// this.firstName.clear();
		this.email.sendKeys(email);
	}

	public void sendpassword(String password) {
		// this.passord.clear();
		this.password.sendKeys(password);
	}

	public void clickloginbutton() {

		this.login.click();

	}
	
	 
}
