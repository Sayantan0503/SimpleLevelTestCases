package com.training.pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RTTC_031POM {
	private WebDriver driver;

	public RTTC_031POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='fa fa-user-o']")
	private WebElement accountLink;

	@FindBy(xpath = "//span[contains(text(),'LOGIN / REGISTER')]")
	private WebElement loginLink;


	@FindBy(id = "input-email")
	private WebElement email;

	@FindBy(id = "input-password")
	private WebElement password;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement login;
	
	@FindBy (xpath="//div[@class='alert alert-danger']")
	 private WebElement warnMsg;

	public void moveMouseToaccountLink() {
		Actions act2 = new Actions(driver);
		act2.moveToElement(accountLink).build().perform();
	}

	public void moveMouseTologinLink() {
		Actions act1 = new Actions(driver);
		act1.moveToElement(loginLink).build().perform();
	}

	public void clickloginLink() {
		this.loginLink.click();
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
    
	public String getTextwarnmsg() {
		return this.warnMsg.getText();
	}
	
}
