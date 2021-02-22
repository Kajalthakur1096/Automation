package bil.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Kto5StudentDashboardPage extends BasePage {
By StateSpecificResourcesButton= By.cssSelector("[href*='state-resource']");

	public Kto5StudentDashboardPage(WebDriver driver) {
		this.driver=driver;
	}
	public WebElement getStateSpecificResourcesButton(){
		return driver.findElement(StateSpecificResourcesButton);
	}

}
