package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
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
import com.training.pom.RTTC_032POM;
import com.training.pom.RTTC_034POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_034Tests {

	private WebDriver driver;
	private String baseUrl;
	private RTTC_034POM RTTC_034POM; // RTTC_001 //To verify whether application allows the user to get registered by
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
		RTTC_034POM = new RTTC_034POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		report = new ExtentReports("report\\RTTC_034.html");
		test = report.startTest("Test Case RTTC_034");
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		// driver.quit();
	}

	@Test
	public void vaildGuestUserOrderTest() throws InterruptedException {

		RTTC_034POM.moveMousetoShopNowlink();
		test.log(LogStatus.INFO, "Test Step 1.", "Mouse over to the Shop Now link");
		Thread.sleep(5000);

		RTTC_034POM.moveMouseToearringlink();
		test.log(LogStatus.INFO, "Test Step 2.", "Mouse over to the  Ethnic link");
		Thread.sleep(3000);

		RTTC_034POM.clickearringLink();
		test.log(LogStatus.INFO, "Test Step 3.", "Clicked on Ethnic link");

		RTTC_034POM.clickproduct();
		test.log(LogStatus.INFO, "Test Step 4", "Click on particular product");

		ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(1));

		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(5000);
		RTTC_034POM.clickbuttonCart();
		test.log(LogStatus.INFO, "Test Step 5", "Click on Add to cart button");

		// RTTC_034POM.getAlert();

		RTTC_034POM.moveMouseToshoppingCart();
		Thread.sleep(3000);
		RTTC_034POM.clickviewCartButton();
		Thread.sleep(5000);
		RTTC_034POM.clickcheckoutButton();
		Thread.sleep(3000);
		RTTC_034POM.clickguestButton();

		/*
		 * List<WebElement> we_Radio_Button = driver.findElements(By.name("account"));
		 * 
		 * System.out.println("Radio Button-Account:"+we_Radio_Button.size());
		 * System.out.println("Printing ALL values..."); for(WebElement
		 * we:we_Radio_Button) { System.out.println(we.getAttribute("account")); }
		 */

		RTTC_034POM.clickcontinueBtn();
		Thread.sleep(3000);
		RTTC_034POM.sendfirstName("test1903m2");
		RTTC_034POM.sendlastName("last");
		RTTC_034POM.sendeMail("test1903m2@test2.com");
		RTTC_034POM.sendtelePhone("12345678");
		RTTC_034POM.sendaddresOne("Howrah");
		RTTC_034POM.sendCity("Kolkata");
		RTTC_034POM.sendPost("700156");
		RTTC_034POM.selectregion("West Bengal");
		// RTTC_034POM.clickcheckBox1();
		Thread.sleep(5000);
		RTTC_034POM.clickcontinueBtn1();
		RTTC_034POM.sendtextArea("This is for testing");
		RTTC_034POM.clickContinueBtn2(); // working ...check for continue btn click and checkbox and confirm order
		Thread.sleep(3000);
		RTTC_034POM.clickCheckBox2();

		RTTC_034POM.clickContinueBtn3();
		Thread.sleep(3000);
		RTTC_034POM.clickConfirmOrder();

		String expectedResult = "Your order has been successfully processed";
		String actualResult = RTTC_034POM.getTextForMessage();

		if (expectedResult.equals(actualResult)) {
			test.log(LogStatus.PASS, "Test Passed", "Warning message is displayed");
		} else {
			test.log(LogStatus.FAIL, "Test Failed", "No warning message is displayed");
		}

		Assert.assertEquals(actualResult, expectedResult);

		screenShot.captureScreenShot("RTTC_034 Test");
		report.endTest(test);
		report.flush();

	}

}
