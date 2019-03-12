package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.relevantcodes.extentreports.LogStatus;

public class RTTC_005POM {
	private WebDriver driver;

	public RTTC_005POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='fa fa-user-o']")
	private WebElement accountLink;

	// @FindBy(xpath = "//span[contains(text(),'LOGIN / REGISTER')]")
	// private WebElement loginLink;

	@FindBy(id = "input-email")
	private WebElement email;

	@FindBy(id = "input-password")
	private WebElement password;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement login;

	@FindBy(linkText = "Edit your account information")
	private WebElement ai;

	@FindBy(name = "firstname")
	private WebElement firstName;

	@FindBy(name = "lastname")
	private WebElement lastName;

	@FindBy(name = "email")
	private WebElement email2;

	@FindBy(name = "telephone")
	private WebElement telephone;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continuebtn;

	@FindBy(xpath = "//div[@class='alert alert-success']")
	private WebElement updateMessage;

	public void clickaccountLink() {
		this.accountLink.click();
	}

	public void sendemail(String email) {

		this.email.sendKeys(email);
	}

	public void sendpassword(String password) {

		this.password.sendKeys(password);

	}

	public void clicklogin() {
		// this.driver.navigate().refresh();
		this.login.click();
	}

	public void clickai() {
		this.ai.click();
	}

	public void sendfirstName(String firstName) {
		this.firstName.clear();
		this.firstName.sendKeys(firstName);

	}

	public void sendlastName(String lastname) {
		this.lastName.clear();
		this.lastName.sendKeys(lastname);
	}

	public void sendemail2(String email2) {
		this.email2.clear();
		this.email2.sendKeys(email2);
	}

	public void sendtelephone(String telephone) {
		this.telephone.clear();
		this.telephone.sendKeys(telephone);
	}

	public void clickcontinuebtn() {
		this.continuebtn.click();
	}

	public String getTextforupdateMesage() {
		return this.updateMessage.getText();
	}

}
