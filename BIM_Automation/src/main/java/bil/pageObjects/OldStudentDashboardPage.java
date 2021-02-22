package bil.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OldStudentDashboardPage extends BasePage {
	By statespecificText = By.xpath("//li//span[text()='State Specific Resources']");

	public OldStudentDashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getStateSpecificText() {
		return driver.findElement(statespecificText);
	}
}
