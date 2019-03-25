package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RTTC_033POM {
	private WebDriver driver;

	public RTTC_033POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='fa fa-user-o']") // locating account link
	private WebElement accountLink;

	@FindBy(xpath = "//span[contains(text(),'LOGIN / REGISTER')]") //locating login link 
	private WebElement loginLink;

	@FindBy(id = "input-email")  //locating email
	private WebElement email;

	@FindBy(id = "input-password")  //locating password
	private WebElement password;

	@FindBy(xpath = "//input[@value='Login']")  //locating login
	private WebElement login;

	@FindBy(xpath = "//*[@id='menu_all_categories_Menu_VIfWm2LT_Gd1U2']/a/span") //locating shop Now link
	private WebElement shopNowlink;

	@FindBy(xpath = "//span[contains(text(),'Earrings')]") //locating ethnic Link ;
	private WebElement ethnicLink;

	@FindBy(xpath = "//*[@id='ProductsSystem_QQI8r357']/div[1]/div[3]/div/div[3]/div/div/div[1]/h4/a") //locating product link
	private WebElement product;

	@FindBy(xpath = "//*[@id=\"button-cart\"]") 
	private WebElement buttonCart;

	@FindBy(xpath = "//i[@class=\"tb_icon ico-linea-ecommerce-bag\"]")
	private WebElement shoppingCart;

	@FindBy(xpath = "//a[@href=\"http://retail.upskills.in/checkout/cart\"]")
	private WebElement viewCartButton;

	@FindBy(xpath = "//a[@class='btn btn-primary']")
	private WebElement checkoutButton;

	@FindBy(xpath = "//input[@id='button-payment-address']")
	private WebElement continueBtn;

	private By eaddress = By.xpath("//select[@name='address_id']");

	private By daddress = By.xpath("//*[@id='shipping-existing']/select");

	@FindBy(xpath = "//input[@id='button-shipping-address']")
	private WebElement continuebtn1;

	@FindBy(xpath = "//*[@id='button-shipping-method']")
	private WebElement continuebtn2;

	@FindBy(xpath = "//*[@id='collapse-shipping-method']/div/p[4]/textarea")
	private WebElement txtArea;

	@FindBy(xpath = "//*[@id='collapse-payment-method']/div/div[2]/div[1]/label/input")
	private WebElement chkBox;

	@FindBy(xpath = "//*[@id='button-payment-method']")
	private WebElement continueBtn3;

	@FindBy(id = "button-confirm")
	private WebElement confirmBtn;

	@FindBy(xpath="//p[contains(text(),'Your order has been successfully processed!')]")
	    private WebElement returnMessage ;
	
	
	public void clickaccountLink() {
		this.accountLink.click();
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

	public void moveMousetoShopNowlink() {
		Actions act1 = new Actions(driver);
		act1.moveToElement(shopNowlink).build().perform();
	}

	public void moveMouseToearrings() {
		Actions act1 = new Actions(driver);
		act1.moveToElement(ethnicLink).build().perform();
	}

	public void clickethnicLink() {
		this.ethnicLink.click();
	}

	public void clickproduct() {
		this.product.click();
	}

	public void clickbuttonCart() {
		this.buttonCart.click();
	}

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

	public void clickcontinueBtn() {
		this.continueBtn.click();
	}

	public void selecteaddress(String ea) {

		Select sec = new Select(driver.findElement(eaddress));
		sec.selectByVisibleText(ea);

	}

	public void selectdaddress(String da) {

		Select sec1 = new Select(driver.findElement(daddress));
		sec1.selectByVisibleText(da);
	}

	public void clickcontinuebtn1() {
		this.continuebtn1.click();
	}

	public void sendtxtArea(String txtArea) {
		this.txtArea.sendKeys(txtArea);
	}

	public void clickcontinuebtn2() {
		this.continuebtn2.click();
	}

	public void clickcontinueBtn3() {
		this.continueBtn3.click();
	}

	public void clickchkBox() {
		this.chkBox.click();

	}

	public void clickconfirmBtn() {
		this.confirmBtn.click();
	}

	 public String getTextforreturnMessage() {
		 return this.returnMessage.getText();
	 }
	 
	
	
}
