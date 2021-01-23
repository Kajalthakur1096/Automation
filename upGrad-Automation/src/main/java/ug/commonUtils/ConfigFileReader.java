package ug.commonUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public enum ConfigFileReader {
	INSTANCE;
	Properties prop;
	FileInputStream fis;

	ConfigFileReader() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\ug\\resources\\config.properties");
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getBrowserName() {
		String browserName = prop.getProperty(ConstantDataReader.getBrowser());
		if (browserName != null)
			return browserName;
		else
			throw new RuntimeException("BrowserName not specified in the config.properties file.");
	}

	public long getImplicitlyWait() {
		String implicitlyWait = prop.getProperty(ConstantDataReader.getImplicitlyWait());
		if (implicitlyWait != null)
			return Long.parseLong(implicitlyWait);
		else
			throw new RuntimeException("implicitlyWait not specified in the config.properties file.");
	}

	public String getApplicationUrl() {
		String url = prop.getProperty(ConstantDataReader.getUrl());
		if (url != null)
			return url;
		else
			throw new RuntimeException("Url not specified in the config.properties file.");
	}

	public String getChromeDriverPath() {
		String chromeDriverPath = prop.getProperty(ConstantDataReader.getChromeDriverPath());
		if (chromeDriverPath != null)
			return chromeDriverPath;
		else
			throw new RuntimeException("chromeDriverPath not specified in the config.properties file.");
	}

	public String getFireFoxDriverPath() {
		String firefoxDriverPath = prop.getProperty(ConstantDataReader.getFirefoxDriverPath());
		if (firefoxDriverPath != null)
			return firefoxDriverPath;
		else
			throw new RuntimeException("firefoxDriverPath not specified in the config.properties file.");
	}

	public long getExplicitlyWait() {
		String explicitlyWait = prop.getProperty(ConstantDataReader.getImplicitlyWait());
		if (explicitlyWait != null)
			return Long.parseLong(explicitlyWait);
		else
			throw new RuntimeException("explicitlyWait not specified in the config.properties file.");
	}

}
