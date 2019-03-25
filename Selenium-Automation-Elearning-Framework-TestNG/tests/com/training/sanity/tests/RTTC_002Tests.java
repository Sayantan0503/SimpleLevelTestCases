package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
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
import com.training.pom.RTTC_002POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_002Tests {

	private WebDriver driver;
	private String baseUrl;
	private RTTC_002POM RTTC_002POM;   //
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
		RTTC_002POM=new RTTC_002POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		report= new ExtentReports("report\\RTTC_002Tests.html");
		test =report.startTest("RTTC_002Tests");
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	//To verify whether application allows user to get logged in by entering valid credentials in required field
	
	@Test
	public void validLoginTest() {
		RTTC_002POM.clickaccountLink();
		test.log(LogStatus.INFO, "Test Step 1.", "Click on account link");
		//loginuserPOM.clickloginLink();
		//loginuserPOM.clickloginbutton();
		RTTC_002POM.sendemail("test0603p2@test2.com");
		test.log(LogStatus.INFO, "Test Step 2.", "Enter value  on email address");
		RTTC_002POM.sendpassword("pass0803");
		test.log(LogStatus.INFO, "Test Step 3.", "Enter value  on password");
		RTTC_002POM.clickloginbutton();
		test.log(LogStatus.INFO, "Test Step 4.", "click on continue button");
		String expectedResult= "My Account" ;
		String actualResult =driver.getTitle();	
		System.out.println("Page title is :"  +driver.getTitle());
		Assert.assertEquals(actualResult, expectedResult);
		
		if (expectedResult.equals(actualResult)) {
			test.log(LogStatus.PASS, "Test Passed", "User has successfully logged in");
		}
			
		else  {
			test.log(LogStatus.FAIL, "Test Failed", "Please check your input credentials");
		}
		screenShot.captureScreenShot("LoginUser");
		report.endTest(test);
		report.flush();
	}
}
