package bil.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserRegistrationPage extends BasePage {
	By registrationButton = By.cssSelector("div.login-tabs>button:nth-child(2)");
	By accessCode = By.cssSelector("#access-code-input");
	By nextButton = By.xpath("//button[text()='NEXT']");
	By errorMessage = By.cssSelector(".access-code-error");
	By teacherFirstName = By.cssSelector("#teacher-first-name");
	By teacherLastName = By.cssSelector("#teacher-last-name");
	By teacherEmail = By.cssSelector("#teacher-email");
	By teacherEmailconfirm = By.cssSelector("#teacher-email-confirm");
	By teacherPassword = By.cssSelector("#teacher-pass");
	By teacherPasswordConfirm = By.cssSelector("#teacher-pass-confirm");
	By teacherSubmitButton = By.xpath("//div[@id='teacher-content-one']//button[text()='Next']");
	By teacherSchoolSubmitButton = By.xpath("//div[@id='teacher-content-two']//button[text()='Next']");
	By teacherSchoolCheckbox = By.cssSelector("#school-not-listed");
	By loginButton = By.cssSelector(".done-reg-btn");
	By studentFirstName = By.cssSelector("#student-first-name");
	By studentLastName = By.cssSelector("#student-last-name");
	By studentPassword = By.cssSelector("#student-pass");
	By studentPasswordConfirm = By.cssSelector("#student-pass-confirm");
	By studentId = By.cssSelector("#student-id");
	By studentSubmitButton = By.xpath("//div[@id='student-content-one']//button[text()='Next']");
	By studentLoginButton = By.xpath("//div[@id='student-content-two']//button[text()='Log in']");
	By DAFirstName = By.cssSelector("#disadmin-first-name");
	By DALastName = By.cssSelector("#disadmin-last-name");
	By DAEmail = By.cssSelector("#disadmin-email");
	By DAEmailConfirm = By.cssSelector("#disadmin-email-confirm");
	By DAPassword = By.cssSelector("#disadmin-pass");
	By DAPasswordConfirm = By.cssSelector("#disadmin-pass-confirm");
	By DASubmitButton = By.xpath("//div[@id='disadmin-content-one']//button[text()='Next']");
	By DALoginButton = By.xpath("//div[@id='disadmin-content-two']//button[text()='Next']");

	public UserRegistrationPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getTeacherSchoolCheckbox() {
		return driver.findElement(teacherSchoolCheckbox);
	}

	public WebElement getTeacherLoginButton() {
		return driver.findElement(loginButton);
	}

	public WebElement getTeacherSchoolSubmitButton() {
		return driver.findElement(teacherSchoolSubmitButton);

	}

	public WebElement getRegistrationButton() {
		return driver.findElement(registrationButton);

	}

	public WebElement getAccessCodeButton() {
		return driver.findElement(accessCode);

	}

	public WebElement getNextButton() {
		return driver.findElement(nextButton);

	}

	public WebElement getAccessCodeErrorText() {
		return driver.findElement(errorMessage);

	}

	public WebElement getTeacherFirstName() {
		return driver.findElement(teacherFirstName);

	}

	public WebElement getTeacherLastName() {
		return driver.findElement(teacherLastName);

	}

	public WebElement getTeacherEmail() {
		return driver.findElement(teacherEmail);

	}

	public WebElement getTeacherEmailConfirm() {
		return driver.findElement(teacherEmailconfirm);

	}

	public WebElement getTeacherPassword() {
		return driver.findElement(teacherPassword);

	}

	public WebElement getTeacherPasswordConfirm() {
		return driver.findElement(teacherPasswordConfirm);

	}

	public WebElement getTeacherSubmitButton() {
		return driver.findElement(teacherSubmitButton);

	}

	public WebElement getStudentFirstName() {
		return driver.findElement(studentFirstName);
	}

	public WebElement getStudentLastName() {
		return driver.findElement(studentLastName);
	}

	public WebElement getStudentPassword() {
		return driver.findElement(studentPassword);
	}

	public WebElement getStudentPasswordConfirm() {
		return driver.findElement(studentPasswordConfirm);
	}

	public WebElement getStudentId() {
		return driver.findElement(studentId);
	}

	public WebElement getStudentSubmitButton() {
		return driver.findElement(studentSubmitButton);
	}

	public WebElement getStudentLoginButton() {
		return driver.findElement(studentLoginButton);
	}

	public WebElement getDAFirstName() {
		return driver.findElement(DAFirstName);
	}

	public WebElement getDALastName() {
		return driver.findElement(DALastName);
	}

	public WebElement getDAEmail() {
		return driver.findElement(DAEmail);
	}

	public WebElement getDAEmailConfirm() {
		return driver.findElement(DAEmailConfirm);
	}

	public WebElement getDAPasword() {
		return driver.findElement(DAPassword);
	}

	public WebElement getDAPaswordConfirm() {
		return driver.findElement(DAPasswordConfirm);
	}

	public WebElement getDASubmitButton() {
		return driver.findElement(DASubmitButton);
	}

	public WebElement getDALoginButton() {
		return driver.findElement(DALoginButton);
	}

}
