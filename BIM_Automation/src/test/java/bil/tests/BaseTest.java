package bil.tests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import bil.commonUtilities.ConfigFileReader;
import bil.commonUtilities.ConstantDataReader;

public class BaseTest {
	protected WebDriver driver;
	protected boolean flag;
	protected WebDriverWait wait;
	protected JavascriptExecutor executor;

	/*
	 * This method will initialize any driver selected by user from
	 * config.properties file and will return the life of a driver wherever this
	 * function is called.
	 */

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
	 * This method will return the path where screenshot is stored when any test
	 * case fails.
	 */
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot objectOfScreenshot = (TakesScreenshot) driver;
		File screenshotFileSource = objectOfScreenshot.getScreenshotAs(OutputType.FILE);
		String destinationFile = ConfigFileReader.INSTANCE.getReportPath()
				+ ConfigFileReader.INSTANCE.getReportFolderName() + testCaseName
				+ ConfigFileReader.INSTANCE.getImageExtension();
		FileUtils.copyFile(screenshotFileSource, new File(destinationFile));
		return destinationFile;

	}
}
