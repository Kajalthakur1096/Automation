package ug.tests;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ug.commonUtils.ConfigFileReader;
import ug.commonUtils.ConstantDataReader;

public class CommonUtilities {

	protected WebDriver driver;
	protected List<String> actualUrlList;
	List<WebElement> elementList;

	// This method will initialize and return the driver object.
	public WebDriver initializeDriver() throws IOException {
		String browserName = ConfigFileReader.INSTANCE.getBrowserName();
		if (browserName.equals(ConstantDataReader.getChromeBrowser())) {
			// Code to set chrome driver
			System.setProperty("webdriver.chrome.driver", ConfigFileReader.INSTANCE.getChromeDriverPath());
			driver = new ChromeDriver();

		} else if (browserName.equals(ConstantDataReader.getFirefoxBrowser())) {
			// Code to set firefox driver
			System.setProperty("webdriver.gecko.driver", ConfigFileReader.INSTANCE.getFireFoxDriverPath());
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(ConfigFileReader.INSTANCE.getImplicitlyWait(), TimeUnit.SECONDS);
		return driver;

	}

	/*
	 * public List<String> openWindows() throws InterruptedException {
	 * List<String> actualUrlList = new ArrayList<String>(); Set<String> abc =
	 * driver.getWindowHandles(); Iterator<String> it = abc.iterator();
	 * it.next(); while (it.hasNext()) { driver.switchTo().window(it.next());
	 * Thread.sleep(2000); // --->alternative?
	 * actualUrlList.add(driver.getCurrentUrl()); } return actualUrlList;
	 * 
	 * }
	 */

}
