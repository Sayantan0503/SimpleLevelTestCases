package com.training.sanity.tests;

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
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.RTTC_001POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_062ExcelTests {

	
	private WebDriver driver;
	private String baseUrl;
	private RTTC_001POM RTTC_001POM; // RTTC_001 //To verify whether application allows the user to get registered by
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
		RTTC_001POM = new RTTC_001POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		report = new ExtentReports("report\\RTTC_062.html");
		test = report.startTest("Test Case RTTC_062");
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);

		driver.quit();
	}

	@Test(dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders.class)
	public void validMultipleUserRegistrationTest(String firstname, String lastname ,String email ,String telephone  ,String address1 ,String address2 , String city, String postalcode, String country , String region , String password , String confirmpassword  ) throws InterruptedException {

		RTTC_001POM.moveMouseToaccountLink();
		test.log(LogStatus.INFO, "Test Step 1.", "Mouse over to the account link");
		Thread.sleep(3000);

		RTTC_001POM.moveMouseTologinLink();
		test.log(LogStatus.INFO, "Test Step 2.", "Mouse over to the  Login/Register link");
		RTTC_001POM.clickloginLink();
		test.log(LogStatus.INFO, "Test Step 3.", "Clicked on Login/Register link");

		RTTC_001POM.clickregisterbtn();
		test.log(LogStatus.INFO, "Test Step 4.", "Clicked on Register button");

		RTTC_001POM.sendfirstName(firstname);
		test.log(LogStatus.INFO, "Test Step 5.", "Enter value on first name");
		RTTC_001POM.sendlastName(lastname);
		test.log(LogStatus.INFO, "Test Step 6.", "Enter value on last name");
		RTTC_001POM.sendemail(email);
		test.log(LogStatus.INFO, "Test Step 7.", "Enter value  on email address");
		RTTC_001POM.sendtelePhone(telephone);
		test.log(LogStatus.INFO, "Test Step 8.", "Enter value on phone number");
		RTTC_001POM.sendaddress1(address1);
		test.log(LogStatus.INFO, "Test Step 9.", "Enter value on address 1");
		RTTC_001POM.sendaddress2(address2);
		test.log(LogStatus.INFO, "Test Step 10.", "Enter value on address 2");
		RTTC_001POM.sendcity(city);
		test.log(LogStatus.INFO, "Test Step 11.", "Enter value on city");
		RTTC_001POM.sendpostcode(postalcode);
		test.log(LogStatus.INFO, "Test Step 12.", "Enter value on post code");
		Thread.sleep(2000);
		RTTC_001POM.selectcountry(country);
		test.log(LogStatus.INFO, "Test Step 13.", "Select country from the dropdown");
		RTTC_001POM.selectregion(region);
		test.log(LogStatus.INFO, "Test Step 14.", "Select region from the dropdown");
		RTTC_001POM.sendpassword(password);
		test.log(LogStatus.INFO, "Test Step 15.", "Enter value on password");
		RTTC_001POM.sendconfirmPassword(confirmpassword);
		test.log(LogStatus.INFO, "Test Step 16.", "Enter value on confirm passowrd");
		RTTC_001POM.clickRadiobutton();
		test.log(LogStatus.INFO, "Test Step 17.", "Click on the radio button ");
		RTTC_001POM.clickcheckBox();
		test.log(LogStatus.INFO, "Test Step 18.", "Click on the checkbox");
		Thread.sleep(2000);
		RTTC_001POM.clickcontinueBtn();
		test.log(LogStatus.INFO, "Test Step 19.", "Click on the continue button");

		String expectedResult = "Congratulations! Your new account has been successfully created!";
		String actualResult = (RTTC_001POM.getTextForwelcomeMesage());
		Assert.assertEquals(actualResult, expectedResult);

		if (expectedResult.equals(actualResult)) {
			test.log(LogStatus.PASS, "Test Passed", "A new accont has been created successfully");
		} else {
			test.log(LogStatus.FAIL, "Test Failed", "No new account has been created ");
		}

		screenShot.captureScreenShot("Multiple User Registration");
		report.endTest(test);
		report.flush();

	}
}
