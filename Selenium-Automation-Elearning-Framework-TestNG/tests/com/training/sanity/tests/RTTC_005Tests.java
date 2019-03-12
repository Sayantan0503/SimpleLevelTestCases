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
import com.training.pom.RTTC_005POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_005Tests {

	private WebDriver driver;
	private String baseUrl;
	private RTTC_005POM RTTC_005POM; //
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
		RTTC_005POM = new RTTC_005POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		report = new ExtentReports("report\\RTTC_005.html");
		test = report.startTest("RTTC_005Tests");
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
                 //CTRL+A   ,CTRL+SHIFT+F
	@Test
	public void validmodifyPersonalDetailsTest() throws InterruptedException {

		RTTC_005POM.clickaccountLink();
		//WebElement element = driver.findElement(By.xpath("//span[contains(text(),'LOGIN / REGISTER')]"));
		//Actions action = new Actions(driver);
		//action.moveToElement(element).click();

		RTTC_005POM.sendemail("test0603p6@test2.com");
		RTTC_005POM.sendpassword("pass0803");
		Thread.sleep(3000);
		RTTC_005POM.clicklogin();
		RTTC_005POM.clickai();
		Thread.sleep(2000);
		RTTC_005POM.sendfirstName("test0603update");
		RTTC_005POM.sendlastName("lastupdate");
		RTTC_005POM.sendemail2("test0603p6_update@test2.com");
		RTTC_005POM.sendtelephone("1234432100");
		Thread.sleep(3000);
		RTTC_005POM.clickcontinuebtn();
		
		String expectedResult="Success: Your account has been successfully updated." ;
		String actualResult =RTTC_005POM.getTextforupdateMesage();
		Assert.assertEquals(actualResult, expectedResult);
		
		if (expectedResult.equals(actualResult)) {
			test.log(LogStatus.PASS, "Test Pass", "Account has been updated successfully");
		}
		
		else {
			test.log(LogStatus.FAIL, "Test Fail", "Please check your inputs again");
		}
		
        screenShot.captureScreenShot("UpdateProfile");
		report.endTest(test);
		report.flush();
	}
}
