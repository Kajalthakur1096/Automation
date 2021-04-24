package bil.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import bil.helper.ConfigFileReader;
import bil.helper.Constants;
import bil.helper.TestDataProvider;
import bil.helper.Utils;
import bil.pages.UserRegistrationPage;

public class UserRegistrationTest extends BaseTest {
	protected WebDriver driver;

	public static Logger log = LogManager.getLogger(UserRegistrationTest.class.getName());

	/*
	 * This method will enter the accesscode inside the accesscode input box.
	 */
	private void setAccessCode(String accesscode) {
		UserRegistrationPage objectOfUserRegistrationPage = new UserRegistrationPage(driver);
		/*
		 * I had no choice but to introduce thread here because explicit wait
		 * was unable to interact with access-code web element.Sad.
		 */
		try {
			Thread.sleep(2000);
			objectOfUserRegistrationPage.getRegistrationButton().click();
			objectOfUserRegistrationPage.getAccessCodeButton().sendKeys(accesscode);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		objectOfUserRegistrationPage.getNextButton().click();
	}

	/*
	 * This method will validate the accesscode and will return the boolean flag
	 * if the code entered is either valid or invalid.
	 */
	private boolean validateAccessCode(String accesscode) {
		UserRegistrationPage objectOfUserRegistrationPage = new UserRegistrationPage(driver);
		setAccessCode(accesscode);
		try {
			Thread.sleep(2000);
			if (objectOfUserRegistrationPage.getAccessCodeErrorText().isDisplayed()) {
				return false;
			}
		} catch (Exception e) {
			log.info("Accesscode is valid.");
		}
		return true;
	}

	/*
	 * This method is going to initialize the driver and is going to launch the
	 * website.
	 */
	@BeforeTest
	public void setUp() throws IOException {
		log.info("UserRegistrationTest:Initializing driver");
		driver = initializeDriver();
		log.info("UserRegistrationTest:driver initialised successfully");
		driver.get(ConfigFileReader.INSTANCE.getApplicationUrl());
		log.info("UserRegistrationTest: Url opened successfully");
	}

	/*
	 * This method will register multiple teacher user only of the accesscode is
	 * valid.
	 */
	@Test(enabled = true, dataProvider = "MultipleTeacherRegistrationDataProvider", dataProviderClass = TestDataProvider.class)
	public void registerMultipleTeacherUser(String accesscode, String firstname, String lastname, String password,
			Double usercount) {
		flag = validateAccessCode(accesscode);
		if (flag) {
			for (int i = 0; i < usercount.intValue(); i++) {
				UserRegistrationPage objectOfUserRegistrationPage = new UserRegistrationPage(driver);
				wait = new WebDriverWait(driver, ConfigFileReader.INSTANCE.getExplicitlyWait());
				wait.until(ExpectedConditions.elementToBeClickable(objectOfUserRegistrationPage.getTeacherFirstName()));
				objectOfUserRegistrationPage.getTeacherFirstName().sendKeys((firstname + i));
				objectOfUserRegistrationPage.getTeacherLastName().sendKeys((lastname + i));
				String email = (firstname + i) + Constants.getEmailPeriod() + (lastname + i)
						+ Utils.get4DigitRandomNumberString() + Constants.getEmailDomain();
				objectOfUserRegistrationPage.getTeacherEmail().sendKeys(email);
				objectOfUserRegistrationPage.getTeacherEmailConfirm().sendKeys(email);
				objectOfUserRegistrationPage.getTeacherPassword().sendKeys(password);
				objectOfUserRegistrationPage.getTeacherPasswordConfirm().sendKeys(password);
				objectOfUserRegistrationPage.getTeacherSubmitButton().click();
				wait.until(ExpectedConditions
						.elementToBeClickable(objectOfUserRegistrationPage.getTeacherSchoolCheckbox()));
				objectOfUserRegistrationPage.getTeacherSchoolCheckbox().click();
				objectOfUserRegistrationPage.getTeacherSchoolSubmitButton().click();
				objectOfUserRegistrationPage.getTeacherLoginButton().click();
				// Assert.assertEquals(driver.getCurrentUrl(),
				// Constants.getUrlPath());
				Assert.assertEquals(driver.getCurrentUrl(), Constants.getUrlPath());
				log.info("MultipleTeacherRegistration: Teacher registered successfully");
				if ((i + 1) < usercount.intValue()) {
					setAccessCode(accesscode);
				} else {
					driver.get(Constants.getUrlPath());
				}

			}
		} else {
			log.error("MultipleTeacherRegistration: Accesscode Invalid");
			driver.get(Constants.getUrlPath());

		}

	}

	/*
	 * This method will register multiple student user only of the accesscode is
	 * valid.
	 */
	@Test(enabled = false, dataProvider = "MultipleStudentRegistrationDataProvider", dataProviderClass = TestDataProvider.class)
	public void registerMultipleStudentUser(String accesscode, String firstname, String lastname, String password,
			Double usercount) throws InterruptedException {
		flag = validateAccessCode(accesscode);
		if (flag) {
			for (int i = 0; i < usercount.intValue(); i++) {
				UserRegistrationPage objectOfUserRegistrationPage = new UserRegistrationPage(driver);
				wait = new WebDriverWait(driver, ConfigFileReader.INSTANCE.getExplicitlyWait());
				wait.until(ExpectedConditions.elementToBeClickable(objectOfUserRegistrationPage.getStudentFirstName()));
				objectOfUserRegistrationPage.getStudentFirstName().sendKeys(firstname + i);
				objectOfUserRegistrationPage.getStudentLastName().sendKeys(lastname + i);
				objectOfUserRegistrationPage.getStudentPassword().sendKeys(password);
				objectOfUserRegistrationPage.getStudentPasswordConfirm().sendKeys(password);
				objectOfUserRegistrationPage.getStudentId()
						.sendKeys((firstname + i) + (lastname + i) + Utils.get4DigitRandomNumberString());
				objectOfUserRegistrationPage.getStudentSubmitButton().click();
				wait.until(
						ExpectedConditions.elementToBeClickable(objectOfUserRegistrationPage.getStudentLoginButton()));
				objectOfUserRegistrationPage.getStudentLoginButton().click();
				Assert.assertEquals(driver.getCurrentUrl(), Constants.getUrlPath());
				log.info("MultipleStudentRegistration: Student registered successfully");
				if ((i + 1) < usercount.intValue()) {
					setAccessCode(accesscode);
				} else {
					driver.get(Constants.getUrlPath());
				}
			}
		} else {
			log.error("MultipleStudentRegistration: Accesscode Invalid");
			driver.get(Constants.getUrlPath());

		}
	}

	/*
	 * This method will register multiple DistrictAdmin user only of the
	 * accesscode is valid.
	 */
	@Test(enabled = false, dataProvider = "MultipleDARegistrationDataProvider", dataProviderClass = TestDataProvider.class)
	public void registerMultipleDAUser(String accesscode, String firstname, String lastname, String password,
			Double usercount) {
		flag = validateAccessCode(accesscode);
		if (flag) {
			for (int i = 0; i < usercount.intValue(); i++) {
				UserRegistrationPage objectOfUserRegistrationPage = new UserRegistrationPage(driver);
				wait = new WebDriverWait(driver, ConfigFileReader.INSTANCE.getExplicitlyWait());
				wait.until(ExpectedConditions.elementToBeClickable(objectOfUserRegistrationPage.getDAFirstName()));
				objectOfUserRegistrationPage.getDAFirstName().sendKeys((firstname + i));
				objectOfUserRegistrationPage.getDALastName().sendKeys((lastname + i));
				String email = (firstname + i) + Constants.getEmailPeriod() + (lastname + i)
						+ Utils.get4DigitRandomNumberString() + Constants.getEmailDomain();
				objectOfUserRegistrationPage.getDAEmail().sendKeys(email);
				objectOfUserRegistrationPage.getDAEmailConfirm().sendKeys(email);
				objectOfUserRegistrationPage.getDAPasword().sendKeys(password);
				objectOfUserRegistrationPage.getDAPaswordConfirm().sendKeys(password);
				objectOfUserRegistrationPage.getDASubmitButton().click();
				wait.until(ExpectedConditions.elementToBeClickable(objectOfUserRegistrationPage.getDALoginButton()));
				objectOfUserRegistrationPage.getDALoginButton().click();
				Assert.assertEquals(driver.getCurrentUrl(), Constants.getUrlPath());
				log.info("MultipleDARegistration: DA registered successfully");
				if ((i + 1) < usercount.intValue()) {
					setAccessCode(accesscode);
				} else {
					driver.get(Constants.getUrlPath());
				}

			}
		} else {
			log.error("MultipleDARegistration: Accesscode Invalid");
			driver.get(Constants.getUrlPath());

		}
	}

	/*
	 * This method will register number of teacher users from excel only if the
	 * accesscode is valid.
	 */
	@Test(enabled = true, dataProvider = "TeacherRegistrationDataProvider", dataProviderClass = TestDataProvider.class)
	public void registerTeacherUser(String accesscode, String firstname, String lastname, String email,
			String password) {
		flag = validateAccessCode(accesscode);
		if (flag) {
			UserRegistrationPage objectOfUserRegistrationPage = new UserRegistrationPage(driver);
			wait = new WebDriverWait(driver, ConfigFileReader.INSTANCE.getExplicitlyWait());
			wait.until(ExpectedConditions.elementToBeClickable(objectOfUserRegistrationPage.getTeacherFirstName()));
			objectOfUserRegistrationPage.getTeacherFirstName().sendKeys(firstname);
			objectOfUserRegistrationPage.getTeacherLastName().sendKeys(lastname);
			objectOfUserRegistrationPage.getTeacherEmail().sendKeys(email);
			objectOfUserRegistrationPage.getTeacherEmailConfirm().sendKeys(email);
			objectOfUserRegistrationPage.getTeacherPassword().sendKeys(password);
			objectOfUserRegistrationPage.getTeacherPasswordConfirm().sendKeys(password);
			objectOfUserRegistrationPage.getTeacherSubmitButton().click();
			wait.until(
					ExpectedConditions.elementToBeClickable(objectOfUserRegistrationPage.getTeacherSchoolCheckbox()));
			objectOfUserRegistrationPage.getTeacherSchoolCheckbox().click();
			objectOfUserRegistrationPage.getTeacherSchoolSubmitButton().click();
			objectOfUserRegistrationPage.getTeacherLoginButton().click();
			Assert.assertEquals(driver.getCurrentUrl(), Constants.getUrlPath());
			log.info("registerTeacherUser: Teacher registered successfully");
		} else {
			log.error("registerTeacherUser: Accesscode Invalid");
			driver.get(Constants.getUrlPath());

		}
	}

	/*
	 * This method will register number of student users from excel only if the
	 * accesscode is valid.
	 */
	@Test(enabled = false, dataProvider = "StudentRegistrationDataProvider", dataProviderClass = TestDataProvider.class)
	public void registerStudentUser(String accesscode, String firstname, String lastname, String password,
			String studentId) {
		flag = validateAccessCode(accesscode);
		if (flag) {
			driver.manage().timeouts().implicitlyWait(ConfigFileReader.INSTANCE.getImplicitlyWait(), TimeUnit.SECONDS);
			UserRegistrationPage objectOfUserRegistrationPage = new UserRegistrationPage(driver);
			wait = new WebDriverWait(driver, ConfigFileReader.INSTANCE.getExplicitlyWait());
			wait.until(ExpectedConditions.elementToBeClickable(objectOfUserRegistrationPage.getStudentFirstName()));
			objectOfUserRegistrationPage.getStudentFirstName().sendKeys(firstname);
			objectOfUserRegistrationPage.getStudentLastName().sendKeys(lastname);
			objectOfUserRegistrationPage.getStudentPassword().sendKeys(password);
			objectOfUserRegistrationPage.getStudentPasswordConfirm().sendKeys(password);
			objectOfUserRegistrationPage.getStudentId().sendKeys(studentId);
			objectOfUserRegistrationPage.getStudentSubmitButton().click();
			wait.until(ExpectedConditions.elementToBeClickable(objectOfUserRegistrationPage.getStudentLoginButton()));
			objectOfUserRegistrationPage.getStudentLoginButton().click();
			Assert.assertEquals(driver.getCurrentUrl(), Constants.getUrlPath());
			log.info("registerStudentUser: Student registered successfully");
		} else {
			log.error("registerStudentUser: Accesscode Invalid");
			driver.get(Constants.getUrlPath());

		}
	}

	/*
	 * This method will register number of DistrictAdmin users from excel only
	 * if the accesscode is valid.
	 */
	@Test(enabled = false, dataProvider = "DARegistrationDataProvider", dataProviderClass = TestDataProvider.class)
	public void registerDAUser(String accesscode, String firstname, String lastname, String email, String password) {
		flag = validateAccessCode(accesscode);
		if (flag) {
			UserRegistrationPage objectOfUserRegistrationPage = new UserRegistrationPage(driver);
			wait = new WebDriverWait(driver, ConfigFileReader.INSTANCE.getExplicitlyWait());
			wait.until(ExpectedConditions.elementToBeClickable(objectOfUserRegistrationPage.getDAFirstName()));
			objectOfUserRegistrationPage.getDAFirstName().sendKeys(firstname);
			objectOfUserRegistrationPage.getDALastName().sendKeys(lastname);
			objectOfUserRegistrationPage.getDAEmail().sendKeys(email);
			objectOfUserRegistrationPage.getDAEmailConfirm().sendKeys(email);
			objectOfUserRegistrationPage.getDAPasword().sendKeys(password);
			objectOfUserRegistrationPage.getDAPaswordConfirm().sendKeys(password);
			objectOfUserRegistrationPage.getDASubmitButton().click();
			wait.until(ExpectedConditions.elementToBeClickable(objectOfUserRegistrationPage.getDALoginButton()));
			objectOfUserRegistrationPage.getDALoginButton().click();
			Assert.assertEquals(driver.getCurrentUrl(), Constants.getUrlPath());
			log.info("registerDAUser: DA registered successfully");
		} else {
			log.error("registerDAUser: Accesscode Invalid");
			driver.get(Constants.getUrlPath());
		}
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
