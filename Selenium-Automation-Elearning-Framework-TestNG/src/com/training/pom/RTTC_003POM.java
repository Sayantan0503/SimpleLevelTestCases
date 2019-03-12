package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RTTC_003POM {

	private WebDriver driver ;
	
	public RTTC_003POM (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//i[@class='fa fa-user-o']")
	private WebElement accountLink;
	
	//@FindBy(xpath = "//span[contains(text(),'LOGIN / REGISTER')]")
	//private WebElement loginLink;

	
	
	@FindBy(id="input-email")
	private WebElement email;
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy (xpath="//a[contains(text(),'Forgotten Password')]")
	 private WebElement forgetpassword;
	
	@FindBy (xpath="//div[@class='alert alert-success']")
	private WebElement getTextForForgetPassword ;
	
	@FindBy(xpath="//input[@value='Continue']")
	 private WebElement continueBtn;
	
	
	
	public void clickaccountLink() {
		this.accountLink.click();
	}
	
	
	
	public void sendemail(String email) {

		this.email.sendKeys(email);
	}
	
	 public void clickfwdpwd() {
		 this.forgetpassword.click();
		 
	 }
	 
	 public void clickcontinueBtn() {
		 this.continueBtn.click();
	 }
	 
	 public String getTextForForgetPassword() {
		  return this.getTextForForgetPassword.getText();
	 }
	 
	
	
}
