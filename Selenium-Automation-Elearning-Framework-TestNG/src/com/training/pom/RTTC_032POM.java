package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RTTC_032POM {
	private WebDriver driver;

	public RTTC_032POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'Shop Now')]")
	private WebElement shopNowlink;

	@FindBy(xpath = "//a[@href=\"http://retail.upskills.in/ethnic\"]")
	private WebElement ethnicLink;

	@FindBy(xpath = "//a[@href=\"http://retail.upskills.in/ethnic/integer-vitae-iaculis-massa\"]")
	private WebElement product;

	@FindBy(xpath = "//*[@id=\"button-cart\"]")
	private WebElement buttonCart;

	@FindBy(xpath = "//i[@class=\"tb_icon ico-linea-ecommerce-bag\"]")
	private WebElement shoppingCart;

	@FindBy(xpath = "//a[@href=\"http://retail.upskills.in/checkout/cart\"]")
	private WebElement viewCartButton;
	
	@FindBy (xpath="//a[@class='btn btn-primary']")
	private WebElement checkoutButton ;

	public void moveMousetoShopNowlink() {
		Actions act1 = new Actions(driver);
		act1.moveToElement(shopNowlink).build().perform();
	}

	public void moveMouseToethniclink() {
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

	public void clickcheckoutButton () {
		this.checkoutButton.click();
	}

}
