package com.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.General.ConfigFileReader;
import com.General.ConstantDataReader;

public class BaseTest {

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

		return driver;

	}

	

}
