package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.RTTC_065POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_065Tests {

	private WebDriver driver;
	private String baseUrl;
	private RTTC_065POM RTTC_065POM;

	private static Properties properties;
	private ScreenShot screenShot;
	private ExtentTest test;
	private ExtentReports report;

	@BeforeTest

	public void setUp() throws Exception {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);

		driver = DriverFactory.getDriver(DriverNames.CHROME);
		RTTC_065POM = new RTTC_065POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		report = new ExtentReports("report\\RTTC_065.html");
		test = report.startTest("Test Case RTTC_065");
		// open the browser
		driver.get(baseUrl);
	}

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(3000);

		driver.quit();
	}

	@Test(priority=0)
	public void validLoginTest() throws InterruptedException {

		// RTTC_065POM.getAttributeusername("value");

		// String atr1 = RTTC_065POM.getAttributeusername("name");
		// System.out.println("The text is "+ atr1);

		RTTC_065POM.sendusername("admin");
		RTTC_065POM.sendpassword("admin@123");
		Thread.sleep(3000);
		RTTC_065POM.clickLoginButton();
		Thread.sleep(5000);
		RTTC_065POM.moveMouseTocategoriesLink();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Thread.sleep(5000);
		RTTC_065POM.clickProductLink();
		RTTC_065POM.clickaddButton();

		RTTC_065POM.sendproducetName("Finger Ring");
		RTTC_065POM.sendmetaTitle("Finger Ring for ladies");
		RTTC_065POM.clickdataTab();
		RTTC_065POM.sendmodelName("SKU-012");
		RTTC_065POM.sendPrice("500");
		RTTC_065POM.sendQuantity("50");
		RTTC_065POM.clickLinks();
		RTTC_065POM.clickcategorieslink();
		Thread.sleep(3000);

		RTTC_065POM.moveMouseTocateValue();
		RTTC_065POM.clickcateValue();
		RTTC_065POM.clickdiscountlink();

		RTTC_065POM.clicksaveButton();
		RTTC_065POM.clicklogoutBtn();

	}

	@Test(priority = 1)

	public void validLoginTest1() throws InterruptedException {

		// driver.navigate().to("http://retail.upskills.in/");

		driver.get("http://retail.upskills.in/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		RTTC_065POM.moveMouseoverToshoplink();
		RTTC_065POM.moveMouseoverToearringlink();
		RTTC_065POM.clickearringlink();
		Thread.sleep(3000);
		RTTC_065POM.sendSearchfiled("Finger Ring");

		String expectedResult = "Rs. 2,603";
		String actualResult = (RTTC_065POM.getTextForimgPrice());

		if (expectedResult.equals(actualResult)) {
			test.log(LogStatus.PASS, "Test Passed", "Warning message is displayed");
		} else {
			test.log(LogStatus.FAIL, "Test Failed", "No warning message is displayed");
		}

		Assert.assertEquals(actualResult, expectedResult);

		screenShot.captureScreenShot("RTTC_065Tests");
		// report.endTest(test);
		// report.flush();

	}

}
