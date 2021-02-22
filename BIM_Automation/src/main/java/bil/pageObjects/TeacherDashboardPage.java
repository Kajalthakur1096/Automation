package bil.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TeacherDashboardPage extends BasePage {
	By featuredComponentsText = By.cssSelector("#dashboard-header-text");
	
	public TeacherDashboardPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getFeaturedComponentsText() {
		return driver.findElement(featuredComponentsText);
	}
	
}
