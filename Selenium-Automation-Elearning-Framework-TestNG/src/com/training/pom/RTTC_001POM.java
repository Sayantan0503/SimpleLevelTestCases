package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RTTC_001POM {
	private WebDriver driver;

	public RTTC_001POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='fa fa-user-o']")
	private WebElement accountLink;

	@FindBy(xpath = "//span[contains(text(),'LOGIN / REGISTER')]")
	private WebElement loginLink;

	@FindBy(linkText="Register")
	private WebElement registerbtn;

	@FindBy(id = "input-firstname")
	private WebElement firstName;

	@FindBy(id = "input-lastname")
	private WebElement lastName;

	@FindBy(id = "input-email")
	private WebElement email;

	@FindBy(id = "input-telephone")
	private WebElement telePhone;

	/*
	 * @FindBy(className="btn btn-primary") private WebElement loginBtn;
	 */

	@FindBy(id = "input-address-1")
	private WebElement address1;

	@FindBy(id = "input-address-2")
	private WebElement address2;

	@FindBy(id = "input-city")
	private WebElement city;

	@FindBy(id = "input-postcode") // working
	private WebElement postcode;

	// @FindBy(name = "country_id")
	// private List<WebElement> country;
	private By country = By.name("country_id");

	// @FindBy(id = "input-zone")
	private By Region = By.name("zone_id");

	@FindBy(id = "input-password")
	private WebElement password;

	@FindBy(id = "input-confirm")
	private WebElement confirmPassword;

	

	@FindBy(xpath = "//label[contains(text(),'No')]")
	private WebElement radiobutton;

	@FindBy(xpath = "//label[@class='checkbox']//input[@value='1']")
	private WebElement checkbox;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueBtn;

	//public void clickaccountLink() {
		//this.accountLink.click();
	//}
	
	@FindBy(xpath="//p[contains(text(),'Congratulations! Your new account has been success')]")
          private WebElement welcomeMessage ;
      
	@FindBy(xpath="//div[@class='text-danger']")
	    private WebElement warningMessage;
	
	
	 public void moveMouseToaccountLink() {
		 Actions act2 =new Actions(driver);
		 act2.moveToElement(accountLink).build().perform();
	 }
	
	
	public void moveMouseTologinLink() {
		Actions act1 = new Actions(driver);
		act1.moveToElement(loginLink).build().perform();
	}
	
	  public void clickloginLink() {
		  this.loginLink.click();
	  }
	
	
	public void clickregisterbtn() {
		this.driver.navigate().refresh();
		this.registerbtn.click();
		
	}

	public void sendfirstName(String firstName) {
		// this.firstName.clear();
		this.firstName.sendKeys(firstName);
	}

	public void sendlastName(String lastName) {
		// this.lastName.clear();
		this.lastName.sendKeys(lastName);
	}

	public void sendemail(String email) {

		this.email.sendKeys(email);
	}

	public void sendtelePhone(String telePhone) {

		this.telePhone.sendKeys(telePhone);
	}

	public void sendaddress1(String address1) {

		this.address1.sendKeys(address1);

	}

	public void sendaddress2(String address2) {

		this.address2.sendKeys(address2);

	}

	public void sendcity(String city) {

		this.city.sendKeys(city);

	}

	public void sendpostcode(String postalcode) {

		this.postcode.sendKeys(postalcode);

	}

	public void selectcountry(String ctry) {
		Select country_id = new Select(driver.findElement(country));
		country_id.selectByVisibleText(ctry);
	}

	public void selectregion(String region) {
		Select zone_id = new Select(driver.findElement(Region));
		zone_id.selectByVisibleText(region);
	}

	public void sendpassword(String password) {

		this.password.sendKeys(password);

	}

	public void sendconfirmPassword(String confirmPassword) {

		this.confirmPassword.sendKeys(confirmPassword);

	}

	public void clickRadiobutton() {

		this.radiobutton.click();

	}

	public void clickcheckBox() {
		this.checkbox.click();
	}

	public void clickcontinueBtn() {
		this.continueBtn.click();
	}
     
	
	public String getTextForwelcomeMesage() {
		return this.welcomeMessage.getText();
	}
	
	public String getTextForwarningMessage() {
		return this.warningMessage.getText();
	}
	
	/*
	 * public void clickLoginBtn() { this.loginBtn.click();
	 */

}
