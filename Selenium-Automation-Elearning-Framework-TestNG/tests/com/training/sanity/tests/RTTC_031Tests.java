package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.RTTC_031POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_031Tests {

	
	private WebDriver driver;
	private String baseUrl;
	private RTTC_031POM RTTC_031POM; // RTTC_001 //To verify whether application allows the user to get registered by
										// entering valid credentials in required fields
	private static Properties properties;
	private ScreenShot screenShot;
	private ExtentTest test;
	private ExtentReports report;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		RTTC_031POM = new RTTC_031POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		report = new ExtentReports("report\\RTTC_031.html");
		test = report.startTest("Test Case RTTC_031");
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);

		driver.quit();
	}

	@Test
	public void invalidLoginTest() throws InterruptedException {

		RTTC_031POM.moveMouseToaccountLink();
		test.log(LogStatus.INFO, "Test Step 1.", "Mouse over to the account link");
		Thread.sleep(3000);

		RTTC_031POM.moveMouseTologinLink();
		test.log(LogStatus.INFO, "Test Step 2.", "Mouse over to the  Login/Register link");
		RTTC_031POM.clickloginLink();
		test.log(LogStatus.INFO, "Test Step 3.", "Clicked on Login/Register link");
         
		RTTC_031POM.sendemail("test0603h3@test2.com");
		test.log(LogStatus.INFO, "Test Step 4", "Enter valid email address");
		
		RTTC_031POM.sendpassword("3456772");
		test.log(LogStatus.INFO, "Test Step 5", "Enter Invalid Password");
		
		RTTC_031POM.clickloginbutton();
		test.log(LogStatus.INFO, "Test Step 6", "Click on login button ");
		
		String expectedResult= "Warning: No match for E-Mail Address and/or Password." ;
		String actualResult=(RTTC_031POM.getTextwarnmsg());
		
		if (expectedResult.equals(actualResult)) {
			test.log(LogStatus.PASS, "Test Passed","Warning message is displayed");
		} else {
			test.log(LogStatus.FAIL, "Test Failed","No warning message is displayed");
		}
		
		Assert.assertEquals(actualResult, expectedResult);
		

		screenShot.captureScreenShot("Invalid Login Test");
		report.endTest(test);
		report.flush();

	}
}
