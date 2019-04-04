package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;

public class RTTC_065POM {
	private WebDriver driver;

	public RTTC_065POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='input-username']")
	private WebElement username;

	@FindBy(xpath = "//*[@id='input-password']")
	private WebElement password;

	@FindBy(xpath = "//*[@type='submit']")
	private WebElement loginButton;

	@FindBy(xpath = "//*[@id='menu-catalog']/a/i")
	private WebElement catalog;

	@FindBy(xpath = "//*[@id='menu-catalog']/ul/li[2]/a")
	private WebElement productLink;

	@FindBy(xpath = "//*[@id='content']/div[1]/div/div/a[1]")
	private WebElement addButton;

	@FindBy(xpath = "//input[@id='input-name1']")
	private WebElement producetName;

	@FindBy(id = "input-meta-title1")
	private WebElement metaTitle;

	@FindBy(xpath = "//a[contains(text(),'Data')]")
	private WebElement dataTab;

	@FindBy(xpath = "//input[@id='input-model']")
	private WebElement modelName;

	@FindBy(id = "input-price")
	private WebElement price;

	@FindBy(id = "input-quantity")
	private WebElement quantity;

	@FindBy(xpath = "//a[contains(text(),'Links')]")
	private WebElement links;

	
	 @FindBy (xpath="//input[@placeholder='Categories']")
      private WebElement categories;
	
	 
	// private By cateValue=By.xpath("//*[@id='tab-links']/div[2]/div/ul/li[1]/a");
	
	   @FindBy (xpath="//*[@id='tab-links']/div[2]/div/ul/li[1]/a")
	      private WebElement cateValue ;   //locate Earring from the dropdown 
	   
	   
	   @FindBy (xpath="//a[contains(text(),'Discount')]")
	       private WebElement discountlink;
	  
	   
	   @FindBy(xpath="//*[@id='discount']/tfoot/tr/td[2]/button")
	       private WebElement addButton1;
	   
	   
	   @FindBy(xpath="//*[@id='discount-row0']/td[2]/input")
	        private WebElement quantity1;
	   
	   @FindBy (xpath="//*[@id='discount-row0']/td[4]/input")
	         private WebElement price1;
	   
	   
	   @FindBy(xpath="//*[@id='discount-row0']/td[5]/div/input")
	         private WebElement startDate ;
	    
	   @FindBy (xpath="//*[@id='discount-row0']/td[6]/div/input")
	          private WebElement endDate;
	   
	   @FindBy (xpath="//a[@href='#tab-reward']")
	          private WebElement rewardTab;
	   
	   
	   @FindBy (xpath="//input[@id='input-points']")
	         private WebElement points;
	   
	   
	   @FindBy (xpath="//*[@id='content']/div[1]/div/div/button")
	        private WebElement saveButton ;
	   
	   
	   @FindBy(xpath="//*[@id='header']/ul/li[4]/a/span")
	        private WebElement logoutBtn;
	   
	   
	   @FindBy(xpath="//span[contains(text(),'Shop')]")
	        private WebElement shopLink;
	   
	   @FindBy(xpath="//span[contains(text(),'Earrings')]")
	       private WebElement earrings;
	   
	   @FindBy(xpath="//input[@id='mfilter-opts-search']")
	         private WebElement searchfield;
	   
	   @FindBy(xpath="//span[contains(text(),'2,603')]")
	           private WebElement imgPrice;
	   
	   
	   public String getAttributeusername(String str) {
			 
			return this.username.getAttribute(str);
		}
	   
	   
	   
	public void sendusername(String username) {
		this.username.sendKeys(username);
	}

	public void sendpassword(String password) {
		this.password.sendKeys(password);
	}

	public void clickLoginButton() {
		this.loginButton.click();
	}

	public void moveMouseTocategoriesLink() {
		Actions act = new Actions(driver);
		act.moveToElement(catalog).build().perform();

	}

	public void clickProductLink() {
		this.productLink.click();
	}

	public void clickaddButton() {
		this.addButton.click();
	}

	public void sendproducetName(String productName) {
		
		this.producetName.sendKeys(productName);
	}

	public void sendmetaTitle(String metaTitle) {
		this.metaTitle.sendKeys(metaTitle);
	}

	public void clickdataTab() {
		this.dataTab.click();
	}

	public void sendmodelName(String modelName) {
		this.modelName.sendKeys(modelName);
	}

	public void sendPrice(String price) {
		this.price.sendKeys(price);
	}

	public void sendQuantity(String quantity) {
		this.quantity.sendKeys(quantity);
	}

	public void clickLinks() {
		this.links.click();
	}
    
	
	public void clickcategorieslink() {
		this.categories.click();
	}
	
	
	public void moveMouseTocateValue() {

		Actions act =new Actions(driver);
		 act.moveToElement(cateValue).build().perform();
	}
	
     public void clickcateValue () {
    	 this.cateValue.click();
     }
	

    public void clickdiscountlink() {
    	this.discountlink.click();
    }
    
    
    public void clickaddButton1() {
    	this.addButton1.click();
    }

    public void sendquantity1(String quantity1) {
    	this.quantity1.sendKeys(quantity1);
    }
    
    public void sendprice1(String price1) {
    	this.price1.sendKeys(price1);
    }
    
    public void sendstartDate(String startDate) {
    	this.startDate.sendKeys(startDate);
    }
    
    public void sendendDate(String endDate) {
    	this.endDate.sendKeys(endDate);
    }
     
     public void clickrewardTab() {
    	 this.rewardTab.click();
     }

     public void sendpoints(String points) {
    	 this.points.sendKeys(points);
    	 
     }
     
     
     public void clicksaveButton () {
    	 this.saveButton.click();
     }

     public void clicklogoutBtn() {
    	 this.logoutBtn.click();
     }

     public void moveMouseoverToshoplink() {
    	 Actions act =new Actions(driver);
    	  act.moveToElement(shopLink).build().perform();
     }
    
     public void moveMouseoverToearringlink () {
    	 Actions act =new Actions(driver);
    	 act.moveToElement(earrings).build().perform();
     }

     public void clickearringlink () {
    	 this.earrings.click();
     }
      
    public void sendSearchfiled (String str) {
    	 this.searchfield.sendKeys(str);
    }
   
    public String getTextForimgPrice() {
    	 return this.imgPrice.getText();
    }
    
}







