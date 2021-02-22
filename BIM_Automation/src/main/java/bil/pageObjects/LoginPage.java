package bil.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import bil.commonUtilities.UserCredentials;

public class LoginPage extends BasePage {
	By username = By.cssSelector("input[name='username']");
	By password = By.cssSelector("input[name='password']");
	By login = By.cssSelector("#loginSubmit");
	// By usernameButton = By.cssSelector(".username");
	By usernameButton = By.xpath("//div[@class='k8-header-nav']/div[4]");
	// By mrlLogout = By.cssSelector("[href*='logout']");
	By mrlLogout = By.xpath("//*[@id='Logout']/div");
	By oldMenu = By.cssSelector("#fullName");
	By oldLogout = By.cssSelector("[href*='logout']");
	By checkInvalidUserText = By.cssSelector("div.error");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getInvalidUserText() {
		return driver.findElement(checkInvalidUserText);
	}

	public WebElement getUsername() {
		return driver.findElement(username);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement getOldMenuOption() {
		return driver.findElement(oldMenu);
	}

	public WebElement getLogin() {
		return driver.findElement(login);

	}

	public WebElement getUserNameButton() {
		return driver.findElement(usernameButton);
	}

	public WebElement getMRLLogoutButton() {
		return driver.findElement(mrlLogout);
	}

	public WebElement getOLDLogoutButton() {
		return driver.findElement(oldLogout);
	}

	public TeacherDashboardPage teacherDashboardPage() {
		return new TeacherDashboardPage(driver);

	}
	public OldTeacherDashboardPage oldTeacherDashboardPage() {
		return new OldTeacherDashboardPage(driver);

	}
	public OldStudentDashboardPage oldStudentDashboardPage() {
		return new OldStudentDashboardPage(driver);

	}

	public Kto5StudentDashboardPage kto5StudentDashboardPage() {
		return new Kto5StudentDashboardPage(driver);
	}

	public GreaterThanFiveStudentDashboardPage greaterThanFiveStudentDashboardPage() {
		return new GreaterThanFiveStudentDashboardPage(driver);
	}

	public DistrictAdminPage districtAdminPage() {
		return new DistrictAdminPage(driver);
	}

	public SystemAdminPage systemAdminPage() {
		return new SystemAdminPage(driver);
	}

	public void setLoginDetails(String username, String password) {
		UserCredentials uc = new UserCredentials();
		uc.setUsername(username);
		uc.setPassword(password);
		getUsername().sendKeys(uc.getUsername());
		getPassword().sendKeys(uc.getPassword());
		getLogin().click();
	}

	

	public void MRLUserLogout() {
		getUserNameButton().click();
		getMRLLogoutButton().click();
	}

	public void OldPlatformUserLogout() {
		getOldMenuOption().click();
		getOLDLogoutButton().click();
	}

}
