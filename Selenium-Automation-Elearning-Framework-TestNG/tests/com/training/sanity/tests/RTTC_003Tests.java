package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions; // import actions
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.RTTC_003POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

//import common.Assert;

public class RTTC_003Tests {

	private WebDriver driver;
	private String baseUrl;
	private com.training.pom.RTTC_003POM RTTC_003POM;
	private ScreenShot screenShot;
	private static Properties properties;
	private ExtentReports report;
	private ExtentTest test;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);

	}

	@BeforeMethod
	public void setup() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		RTTC_003POM = new RTTC_003POM(driver);
		baseUrl = properties.getProperty("baseURL");

		screenShot = new ScreenShot(driver);
		report = new ExtentReports("report\\RTTC_003.html");
		test = report.startTest("Test Case RTTC_003");	
	    driver.get(baseUrl); // opening the browser
	    
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

	@Test
	public void validResetPasswordTest() throws Exception {

		RTTC_003POM.clickaccountLink();
		test.log(LogStatus.INFO, "Test Step 1.", "Clicked on account link");

		RTTC_003POM.clickfwdpwd();
		test.log(LogStatus.INFO, "Test Step 2.", "Clicked on forget password link");

		RTTC_003POM.sendemail("test0603c1@test2.com");
		test.log(LogStatus.PASS, "Test Step 3.", "Clicked on sendemail link");

		RTTC_003POM.clickcontinueBtn();
		test.log(LogStatus.FAIL, "Test Step 4.", "Clicked on Continue button link");

		String expectedResult = "An email with a confirmation link has been sent your email address.";
		String actualResult = RTTC_003POM.getTextForForgetPassword();
		Assert.assertEquals(actualResult, expectedResult);

		if (expectedResult.equals(actualResult)) {
			test.log(LogStatus.INFO, "Test Passed",
					"An email with a confirmation link has been sent your email address");

		}

		else {
			test.log(LogStatus.INFO, "Test Failed", "Please check your inputs again");
		}

		screenShot.captureScreenShot("ResetPassword");
		// System.out.println("The message is :"+actualResult);

		report.endTest(test);
		report.flush();

	}

}
