package bil.commonUtilities;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public enum ConfigFileReader {
	INSTANCE;
	Properties prop;

	ConfigFileReader() {
		prop = new Properties();
		try {
			prop.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
		} catch (IOException e) {
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
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

	public String getExcelTestDataPath() {
		String ExcelTestDataPath = prop.getProperty(ConstantDataReader.getExcelPathReader());
		if (ExcelTestDataPath != null)
			return ExcelTestDataPath;
		else
			throw new RuntimeException("ExcelTestDataPath not specified in the config.properties file.");
	}

	public long getExplicitlyWait() {
		String explicitlyWait = prop.getProperty(ConstantDataReader.getImplicitlyWait());
		if (explicitlyWait != null)
			return Long.parseLong(explicitlyWait);
		else
			throw new RuntimeException("explicitlyWait not specified in the config.properties file.");
	}

	public String getImageExtension() {
		String imageExtension = prop.getProperty(ConstantDataReader.getImageExtension());
		if (imageExtension != null)
			return imageExtension;
		else
			throw new RuntimeException("ImageExtensionType not specified in the config.properties file.");
	}

	public String getReportPath() {
		String reportPath = prop.getProperty(ConstantDataReader.getReportPath());
		if (reportPath != null)
			return reportPath;
		else
			throw new RuntimeException("Report folder path not specified in the config.properties file.");

	}

	public String getReportFolderName() {
		String reportFolderName = prop.getProperty(ConstantDataReader.getReportFolderName());
		if (reportFolderName != null)
			return reportFolderName;
		else
			throw new RuntimeException("Report folder name not specified in the config.properties file.");

	}

	public String getReportName() {
		String reportName = prop.getProperty(ConstantDataReader.getReportName());
		if (reportName != null)
			return reportName;
		else
			throw new RuntimeException("Report name not specified in the config.properties file.");

	}

}
