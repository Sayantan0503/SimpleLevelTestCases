package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
import com.training.pom.RTTC_004POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_004Tests {

	private WebDriver driver;
	private String baseUrl;
	private RTTC_004POM RTTC_004POM; //
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
		RTTC_004POM = new RTTC_004POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		report = new ExtentReports("report\\RTTC_004Tests.html");
		test = report.startTest("RTTC_004Tests");
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test
	public void validOrderTest() throws InterruptedException {

		RTTC_004POM.clickaccountLink();
		// Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'LOGIN / REGISTER')]"));
		Actions action = new Actions(driver);
		action.moveToElement(element).click();
		RTTC_004POM.sendemail("test0603p2@test2.com");
		RTTC_004POM.sendpassword("pass0803");
		RTTC_004POM.clickloginbutton();
		// RTTC_004POM.clickaccountLink();
		Thread.sleep(2000);

		/*
		 * WebElement
		 * element1=driver.findElement(By.xpath("//i[@class='fa fa-user-o']")); Actions
		 * action1 =new Actions(driver); action1.moveToElement(element1).click();
		 * Thread.sleep(3000);
		 */
		RTTC_004POM.moveMouseToacccountLink();
		// RTTC_004POM.clickaccountLink();
		RTTC_004POM.moveMouseToMyOrders();
		// Thread.sleep(2000);
		RTTC_004POM.clickMyOrders();
		// RTTC_004POM.getTextForMyOrders();

		RTTC_004POM.clickviewicon();

		String expectedResult = "Integer vitae iaculis massa";
		String actualResult = RTTC_004POM.getTextForMyOrders();
		Assert.assertEquals(actualResult, expectedResult);
		// System.out.println("The order item is:" +actualResult);

		if (expectedResult.equals(actualResult)) {
			test.log(LogStatus.PASS, "Test Passed", "Order product details has been displayed");
		} else {
			test.log(LogStatus.FAIL, "Test Failed", "Please review your inputs");
		}

		screenShot.captureScreenShot("My Orders list");
		report.endTest(test);
		report.flush();
	}
}
