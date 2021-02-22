package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import commonUtilities.ConfigFileReader;
import commonUtilities.ConstantDataReader;

public class HomeTest {

	protected WebDriver driver;

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

	

}
