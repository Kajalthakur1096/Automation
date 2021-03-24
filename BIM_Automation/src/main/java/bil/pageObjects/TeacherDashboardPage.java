package bil.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TeacherDashboardPage extends BasePage {
	By featuredComponentsText = By.cssSelector("#dashboard-header-text");
	By classManagementFeaturedComponents = By.xpath("//span[text()='Class Management']");
	By dashboardClassName = By.xpath("//div[contains(@class,'k8-dashboard-class-name')]");
	By homeButton = By.xpath("//div[contains(@class,'k8-home-button')]");

	public TeacherDashboardPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getFeaturedComponentsText() {
		return driver.findElement(featuredComponentsText);
	}

	public WebElement getClassManagementButton() {
		return driver.findElement(classManagementFeaturedComponents);
	}

	public WebElement getClassName() {
		return driver.findElement(dashboardClassName);
	}

	public WebElement homeButton() {
		return driver.findElement(homeButton);
	}

	public String getDashboardClassText() {
		String[] splitTextByColon = getClassName().getText().split("[:][\\s]");
		String className = splitTextByColon[1];
		return className;

	}
}
