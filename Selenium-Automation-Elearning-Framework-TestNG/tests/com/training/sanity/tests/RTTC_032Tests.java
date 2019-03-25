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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.RTTC_032POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_032Tests {

	private WebDriver driver;
	private String baseUrl;
	private RTTC_032POM RTTC_032POM; // RTTC_001 //To verify whether application allows the user to get registered by
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
		RTTC_032POM = new RTTC_032POM(driver);
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
	public void withoutpreLogginginTest() throws InterruptedException {

		RTTC_032POM.moveMousetoShopNowlink();
		test.log(LogStatus.INFO, "Test Step 1.", "Mouse over to the Shop Now link");
		Thread.sleep(3000);

		RTTC_032POM.moveMouseToethniclink();
		test.log(LogStatus.INFO, "Test Step 2.", "Mouse over to the  Ethnic link");

		RTTC_032POM.clickethnicLink();
		test.log(LogStatus.INFO, "Test Step 3.", "Clicked on Ethnic link");

		RTTC_032POM.clickproduct();
		test.log(LogStatus.INFO, "Test Step 4", "Click on particular product");

		ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(1));
		
		
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(5000);
		RTTC_032POM.clickbuttonCart();
		test.log(LogStatus.INFO, "Test Step 5", "Click on Add to cart button");
		
		RTTC_032POM.moveMouseToshoppingCart();
		Thread.sleep(3000);
		RTTC_032POM.clickviewCartButton();
		Thread.sleep(5000);
		RTTC_032POM.clickcheckoutButton();
		Thread.sleep(2000);
		
       /* List<WebElement> we_Radio_Button = driver.findElements(By.name("account"));
        
        System.out.println("Radio Button-Account:"+we_Radio_Button.size());
        System.out.println("Printing ALL values...");
        for(WebElement we:we_Radio_Button) {
            System.out.println(we.getAttribute("value"));
        }*/
		

	
	/* String expectedResult=
	 * "Warning: No match for E-Mail Address and/or Password." ; String
	 * actualResult=(RTTC_031POM.getTextwarnmsg());
	 * 
	 * if (expectedResult.equals(actualResult)) { test.log(LogStatus.PASS,
	 * "Test Passed","Warning message is displayed"); } else {
	 * test.log(LogStatus.FAIL, "Test Failed","No warning message is displayed"); }
	 * 
	 * Assert.assertEquals(actualResult, expectedResult);
	 */

	 screenShot.captureScreenShot("RTTC_032 Test");
	// report.endTest(test);
	// report.flush();

}

}
