package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.RTTC_033POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_033Tests {

	private WebDriver driver;
	private String baseUrl;
	private RTTC_033POM RTTC_033POM;   //
	private static Properties properties;
	private ScreenShot screenShot;
	private ExtentTest test;
	private ExtentReports report ;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		RTTC_033POM=new RTTC_033POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		report= new ExtentReports("report\\RTTC_033Tests.html");
		test =report.startTest("RTTC_033Tests");
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}
	
	//To verify whether application allows user to get logged in by entering valid credentials in required field
	
	@Test
	public void validOrderTest() throws Exception {
		RTTC_033POM.clickaccountLink();
		test.log(LogStatus.INFO, "Test Step 1.", "Click on account link");
		//loginuserPOM.clickloginLink();
		//loginuserPOM.clickloginbutton();
		RTTC_033POM.sendemail("test0603h4@test2.com");
		test.log(LogStatus.INFO, "Test Step 2.", "Enter value  on email address");
		RTTC_033POM.sendpassword("pass0803");
		test.log(LogStatus.INFO, "Test Step 3.", "Enter value  on password");
		RTTC_033POM.clickloginbutton();
		test.log(LogStatus.INFO, "Test Step 4.", "click on continue button");
		
		Thread.sleep(3000);
		RTTC_033POM.moveMousetoShopNowlink();
		Thread.sleep(3000);
		RTTC_033POM.moveMouseToearrings();
		Thread.sleep(3000);
		RTTC_033POM.clickethnicLink();
		RTTC_033POM.clickproduct();
		
		ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(1));
		
		
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Thread.sleep(5000);
		RTTC_033POM.clickbuttonCart();
		RTTC_033POM.moveMouseToshoppingCart();
		Thread.sleep(5000);
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		RTTC_033POM.clickviewCartButton();
		Thread.sleep(5000);
		RTTC_033POM.clickcheckoutButton();
		Thread.sleep(5000);
		RTTC_033POM.clickcontinueBtn();
		RTTC_033POM.selecteaddress("test1203a1 last, Howrah, Kolkata, West Bengal, India");
		RTTC_033POM.clickcontinueBtn();
		RTTC_033POM.selectdaddress("test1203a1 last, Howrah, Kolkata, West Bengal, India");
		RTTC_033POM.clickcontinuebtn1();
		RTTC_033POM.sendtxtArea("This product is nice"); //running fine
		RTTC_033POM.clickcontinuebtn2();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    
		
		Thread.sleep(3000);
		RTTC_033POM.clickchkBox();
		Thread.sleep(3000);
		RTTC_033POM.clickcontinueBtn3();
		
		Thread.sleep(3000);
		//RTTC_033POM.clickcontinuebtn1();
		
		RTTC_033POM.clickconfirmBtn();
		

		String expectedResult= "Your order has been successfully processed!" ;
		String actualResult =RTTC_033POM.getTextforreturnMessage();
		System.out.println("Displayed Message is  :"  +actualResult);
		
		
		if (expectedResult.equals(actualResult)) {
			test.log(LogStatus.PASS, "Test Passed", "User has successfully placed the order");
		}
			
		else  {
			test.log(LogStatus.FAIL, "Test Failed", "Please check your input credentials");
		}
		 
		Assert.assertEquals(actualResult, expectedResult);
		
		screenShot.captureScreenShot("RTTC_033Tests");
		report.endTest(test);
		report.flush();
	}
}
