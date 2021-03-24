package bil.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import bil.commonUtilities.CalendarUtils;

public class ClassManagement extends BasePage {
	By getStartedButton = By.xpath("//p-footer//button");
	By noActiveClassModal = By
			.xpath("//div[@class='confirmation-modal-container archive']//h2[text()='No active classes']");
	By okayButton = By.xpath("//button[text()='Okay']");
	By addClassButton = By.xpath("//button[@class='add-class-button']");
	By welcomePopup = By.xpath("//div[@class='self-reg-user-welcome-popup-label']");
	// addaclass
	By className = By.cssSelector("#className");
	By addButton = By.xpath("//button[text()='Add']");
	By selectGradeDropdown = By.xpath("//label[text()='Select grade']");
	By gradeList = By.xpath("//li[contains(@class,'ui-dropdown-item')]");
	By selectBookDropdown = By.cssSelector("button.dropdown-toggle.multiselect-dropdown");
	By bookList = By.xpath("//a[@class='ng-star-inserted']");
	By gotoTeacherDashButton = By.xpath("//span[text()='Go to Teacher Dashboard']");

	public ClassManagement(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getWelcomePopup() {
		return driver.findElement(welcomePopup);
	}

	public WebElement getNoActiveClassModal() {
		return driver.findElement(noActiveClassModal);
	}

	public WebElement clickGetStartedButton() {
		return driver.findElement(getStartedButton);
	}

	public WebElement clickOkayButton() {
		return driver.findElement(okayButton);
	}

	public WebElement clickGoToDashboardButton() {
		return driver.findElement(gotoTeacherDashButton);
	}

	public WebElement clickAddClassButton() {
		return driver.findElement(addClassButton);
	}

	public WebElement clickAddButton() {
		return driver.findElement(addButton);
	}

	public WebElement enterClassName() {
		return driver.findElement(className);
	}

	public WebElement selectGradeDropdown() {
		return driver.findElement(selectGradeDropdown);
	}

	public List<WebElement> getGradeDropdownList() {
		return driver.findElements(gradeList);
	}

	public WebElement selectBookDropdown() {
		return driver.findElement(selectBookDropdown);
	}

	public List<WebElement> getBookDropdownList() {
		return driver.findElements(bookList);
	}

	public void selectGrade(String grade) {
		selectGradeDropdown().click();
		List<WebElement> li = getGradeDropdownList();
		selectInputFromList(li, grade);
	}

	public void createNewClass(String className, String grade, String fromDate, String toDate, String book) {
		enterClassName().sendKeys(className);
		selectGrade(grade);
		CalendarUtils.selectCalendarDate(driver, fromDate, toDate);
		selectBook(book);
		clickAddButton().click();
	}

	public void selectBook(String book) {
		selectBookDropdown().click();
		List<WebElement> li = getBookDropdownList();
		selectInputFromList(li, book);
		selectBookDropdown().click();
	}

	public void selectInputFromList(List<WebElement> li, String input) {
		for (WebElement webelement : li) {
			if (webelement.getText().equalsIgnoreCase(input)) {
				webelement.click();
				break;
			}
		}
	}
}
