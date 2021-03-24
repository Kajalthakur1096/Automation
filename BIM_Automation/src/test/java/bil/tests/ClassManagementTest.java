package bil.tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import bil.commonUtilities.ConfigFileReader;
import bil.commonUtilities.TestDataProvider;
import bil.pageObjects.ClassManagement;
import bil.pageObjects.LoginPage;
import bil.pageObjects.TeacherDashboardPage;

public class ClassManagementTest extends BaseTest {
	protected WebDriver driver;
	public static Logger log = LogManager.getLogger(ClassManagementTest.class.getName());

	/*
	 * This method is going to initialize the driver and is going to launch the
	 * website.
	 */
	@BeforeTest
	public void setUp() throws IOException {
		log.info("ClassManagementTest:Initializing driver");
		driver = initializeDriver();
		log.info("ClassManagementTest:driver initialised successfully");
		driver.get(ConfigFileReader.INSTANCE.getApplicationUrl());
		log.info("ClassManagementTest: Url opened successfully");
	}

	/*
	 * This method will Create a new class and verify if the class is created
	 * for New User or not.
	 */
	@Test(enabled = false, dataProvider = "AddClassForNewUserDataProvider", dataProviderClass = TestDataProvider.class)
	public void shouldCreateNewClassForNewUser(String username, String password, String className, String grade,
			String fromDate, String toDate, String book) {
		LoginPage objectOfLoginPage = new LoginPage(driver);
		objectOfLoginPage.LoginUser(username, password);
		log.info("ClassManagementTest:Teacher logged in successfully");
		ClassManagement objectOfClassManagement = new ClassManagement(driver);
		if (objectOfClassManagement.getWelcomePopup().isDisplayed()) {
			objectOfClassManagement.clickGetStartedButton().click();
			objectOfClassManagement.createNewClass(className, grade, fromDate, toDate, book);
			objectOfClassManagement.clickGoToDashboardButton().click();
		}
		TeacherDashboardPage objectOfTeacherDashboardPage = new TeacherDashboardPage(driver);
		Assert.assertEquals(objectOfTeacherDashboardPage.getDashboardClassText(), className);
		// executor = (JavascriptExecutor)driver;
		// executor.executeScript("arguments[0].click();",
		// objectOfTeacherDashboardPage.homeButton());
		Assert.assertEquals(objectOfTeacherDashboardPage.getDashboardClassText(), className);
		log.info("ClassManagementTest:Class created successfully");
		objectOfLoginPage.MRLUserLogout();
	}

	/*
	 * This method will Create a new class and verify if the class is created or
	 * not.
	 */
	@Test(enabled = true, dataProvider = "AddClassWithExistingClassDataProvider", dataProviderClass = TestDataProvider.class)
	public void shouldCreateNewClassWhenClassExist(String username, String password, String className, String grade,
			String fromDate, String toDate, String book) throws InterruptedException {
		LoginPage objectOfLoginPage = new LoginPage(driver);
		objectOfLoginPage.LoginUser(username, password);
		log.info("ClassManagementTest:Teacher logged in successfully");
		TeacherDashboardPage objectOfTeacherDashboardPage = new TeacherDashboardPage(driver);
		objectOfTeacherDashboardPage.getClassManagementButton().click();
		ClassManagement objectOfClassManagement = new ClassManagement(driver);
		objectOfClassManagement.clickAddClassButton().click();
		objectOfClassManagement.createNewClass(className, grade, fromDate, toDate, book);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", objectOfTeacherDashboardPage.homeButton());
		objectOfTeacherDashboardPage.homeButton().click();
		Assert.assertEquals(objectOfTeacherDashboardPage.getDashboardClassText(), className);
		log.info("ClassManagementTest:Class created successfully");
		objectOfLoginPage.MRLUserLogout();

	}

	/*
	 * This method will Create a new class and verify if the class is created
	 * for the user which has no Active class .
	 */
	@Test(enabled = false, dataProvider = "AddClassWithNoActiveClassDataProvider", dataProviderClass = TestDataProvider.class)
	public void shouldCreateNewClassWhenNoActiveClassPresent(String username, String password, String className,
			String grade, String fromDate, String toDate, String book) throws InterruptedException {
		LoginPage objectOfLoginPage = new LoginPage(driver);
		objectOfLoginPage.LoginUser(username, password);
		log.info("ClassManagementTest:Teacher logged in successfully");
		ClassManagement objectOfClassManagement = new ClassManagement(driver);
		if (objectOfClassManagement.getNoActiveClassModal().isDisplayed()) {
			objectOfClassManagement.clickOkayButton().click();
			objectOfClassManagement.createNewClass(className, grade, fromDate, toDate, book);
			log.info("ClassManagementTest:Class created successfully");
		}
		TeacherDashboardPage objectOfTeacherDashboardPage = new TeacherDashboardPage(driver);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", objectOfTeacherDashboardPage.homeButton());
		objectOfTeacherDashboardPage.homeButton().click();
		Assert.assertEquals(objectOfTeacherDashboardPage.getDashboardClassText(), className);
		objectOfLoginPage.MRLUserLogout();

	}

	/*
	 * this method will close the driver when all the tests are executed
	 * successfully.
	 */
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
