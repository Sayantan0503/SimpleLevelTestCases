package com.training.pom;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RTTC_034POM {
	private WebDriver driver;

	public RTTC_034POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'Shop')]")
	private WebElement shoplink;   //locating shoplink

	@FindBy(xpath = "//span[contains(text(),'Earrings')]")
	private WebElement earringLink;   //locating earring link

	@FindBy(xpath = "//*[@id='ProductsSystem_QQI8r357']/div[1]/div[3]/div/div[3]/div/div/div[1]/h4/a")
	private WebElement product;   //locating product
 
	@FindBy(xpath = "//*[@id='button-cart']")
	private WebElement buttonCart;  //locating button cart

	@FindBy(xpath = "//i[@class=\"tb_icon ico-linea-ecommerce-bag\"]")
	private WebElement shoppingCart;  //locating shopping cart 

	@FindBy(xpath = "//a[@href=\"http://retail.upskills.in/checkout/cart\"]")
	private WebElement viewCartButton;   //locating cart button 

	@FindBy(xpath = "//a[@class='btn btn-primary']")
	private WebElement checkoutButton;   //locating checkout button

	@FindBy(xpath = "//*[@id='collapse-checkout-option']/div/div/div[1]/div[1]/div/div[2]/label/input")
	private WebElement guestButton;    //locating guest button

	@FindBy(xpath = "//input[@id='button-account']")
	private WebElement continueBtn; // locating continue button

	@FindBy(xpath = "//input[@id='input-payment-firstname']")
	private WebElement firstName;   //locating firstname 

	@FindBy(id = "input-payment-lastname")
	private WebElement lastName;   //locating last name

	@FindBy(id = "input-payment-email")
	private WebElement eMail;    //locating email

	@FindBy(id = "input-payment-telephone")
	private WebElement telePhone;  //locating telephone

	@FindBy(id = "input-payment-address-1")
	private WebElement addressOne;

	@FindBy(id = "input-payment-city")
	private WebElement inputCity;

	@FindBy(xpath = "//*[@id='input-payment-postcode']")
	private WebElement postCode;

	@FindBy(xpath = "//select[@id='input-payment-country']")
	private WebElement country;

	// @FindBy(id="input-payment-zone")
	// private WebElement paymentZone;

	// @FindBy (className="#input-payment-zone")
	private By paymentZone = By.cssSelector("#input-payment-zone");

	@FindBy(xpath = "//*[@id='account']/div[1]/div/label/input")
	private WebElement checkBox1;

	@FindBy(xpath = "//div[@class='panel-collapse collapse in']//input[@value='Continue']")
	private WebElement continueBtn1;

	@FindBy(xpath = "//textarea[@name='comment']")
	private WebElement textArea;

	@FindBy(xpath = "//*[@id='button-shipping-method']")
	private WebElement continueBtn2;

	@FindBy(xpath = "//*[@id='collapse-payment-method']/div/div[2]/div[1]/label/input")
	private WebElement checkBox2;

	@FindBy(xpath = "//*[@id='button-payment-method']")
	private WebElement continueBtn3;

	@FindBy(xpath = "//*[@id='button-confirm']")
	private WebElement confirmOrder1;
	
	@FindBy(xpath="//p[contains(text(),'Your order has been successfully processed!')]")
	    private WebElement message;

	public void moveMousetoShopNowlink() {        //method for mouse over to shoplink
		Actions act1 = new Actions(driver);
		act1.moveToElement(shoplink).build().perform();
	}

	public void moveMouseToearringlink() {      //method for mouse over to earring link
		Actions act1 = new Actions(driver);
		act1.moveToElement(earringLink).build().perform();
	}

	public void clickearringLink() {    //method for clicking earring link
		this.earringLink.click();
	}

	public void clickproduct() {    //method for clicking product link
		this.product.click();
	}

	public void clickbuttonCart() {   //method for click button 
		this.buttonCart.click();

	}

	/*
	 * public void getAlert() throws NoAlertPresentException {
	 * 
	 * Alert alt=driver.switchTo().alert(); alt.getText(); alt.dismiss();
	 */

	public void moveMouseToshoppingCart() {
		Actions act2 = new Actions(driver);
		act2.moveToElement(shoppingCart).build().perform();

	}

	public void moveMouseToviewCartButton() {
		Actions act3 = new Actions(driver);
		act3.moveToElement(viewCartButton).build().perform();
	}

	public void clickviewCartButton() {
		this.viewCartButton.click();
	}

	public void clickcheckoutButton() {
		this.checkoutButton.click();
	}

	public void clickguestButton() {
		this.guestButton.click();
	}

	public void clickcontinueBtn() {
		this.continueBtn.click();
	}

	public void sendfirstName(String firstName) {
		this.firstName.sendKeys(firstName); // method for first name
	}

	public void sendlastName(String lastName) {
		this.lastName.sendKeys(lastName); // method for lastName
	}

	public void sendeMail(String eMail) {
		this.eMail.sendKeys(eMail);        //method for email
	}

	public void sendtelePhone(String telePhone) {
		this.telePhone.sendKeys(telePhone);  //method for telephone
	}

	public void sendaddresOne(String addressOne) {
		this.addressOne.sendKeys(addressOne);  //method for addressone
	}

	public void sendCity(String City) {
		this.inputCity.sendKeys(City);
	}

	public void sendPost(String Post) {
		this.postCode.sendKeys(Post);
	}

	public void selectregion(String rgn) {
		Select sec = new Select(driver.findElement(paymentZone));
		sec.selectByVisibleText(rgn);
	}

	public void clickcheckBox1() {
		this.checkBox1.click();
	}

	public void clickcontinueBtn1() {
		this.continueBtn1.click();
	}

	public void sendtextArea(String textArea) {
		this.textArea.sendKeys(textArea);
	}

	public void clickContinueBtn2() {
		this.continueBtn2.click();
	}

	public void clickCheckBox2() {
		this.checkBox2.click();
	}

	public void clickContinueBtn3() {
		this.continueBtn3.click();
	}
    
	public void clickConfirmOrder() {
		this.confirmOrder1.click();
	}
	
     public String getTextForMessage() {
    	   return this.message.getText();
     }
}
