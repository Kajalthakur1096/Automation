package ug.commonUtils;

import java.util.Arrays;
import java.util.List;

public class ConstantDataReader {
	private static final String BROWSER = "browser";
	private static final String CHROME_BROWSER = "chrome";
	private static final String FIREFOX_BROWSER = "firefox";
	private static final String IMPLICITLY_WAIT = "implicitlyWait";
	private static final String EXPLICITLY_WAIT = "explicitlyWait";
	private static final String URL = "url";
	private static final String URL_PATH = "https://www.bigideasmath.com/BIM/login";
	private static final String CHROME_DRIVER_PATH = "chromeDriverPath";
	private static final String FIREFOX_DRIVER_PATH = "geckoDriverPath";
	private static final List<String> FOOTEREXPECTEDURLLIST = Arrays.asList(
			"https://www.upgrad.com/data-science-pgd-iiitb", "https://www.upgrad.com/machine-learning-ai-pgd-iiitb",
			"https://www.upgrad.com/mba-business-analytics-nmims",
			"https://www.upgrad.com/business-analytics-certification", "https://www.upgrad.com/data-science-pgc-iiitb",
			"https://www.upgrad.com/machine-learning-nlp-pgc-iiitb",
			"https://www.upgrad.com/machine-learning-deep-learning-pgc-iiitb",
			"https://www.upgrad.com/data-science-masters-degree-iiitb",
			"https://www.upgrad.com/masters-in-ml-ai-ljmu-iiitb",
			"https://www.upgrad.com/advanced-certification-ml-cloud-iitm",
			"https://www.upgrad.com/machine-learning-ms-ljmu-iitm",
			"https://www.upgrad.com/master-certificate-business-analytics-msu",
			"https://www.upgrad.com/msc-in-data-science-chandigarh-university",
			"https://www.upgrad.com/business-analytics-epgp-liba",
			"https://www.upgrad.com/machine-learning-and-ai-epgp-liba",
			"https://www.upgrad.com/university-of-essex-online#business-analytics");
	private static final List<String> HEADEREXPECTEDURLLIST = Arrays.asList(
			"https://www.upgrad.com/data-science-pgd-iiitb", "https://www.upgrad.com/data-science-masters-degree-iiitb",
			"https://www.upgrad.com/data-science-pgc-iiitb",
			"https://www.upgrad.com/msc-in-data-science-chandigarh-university/",
			"https://www.upgrad.com/master-certificate-business-analytics-msu",
			"https://www.upgrad.com/business-analytics-certification",
			"https://www.upgrad.com/business-analytics-epgp-liba",
			"https://www.upgrad.com/university-of-essex-online#business-analytics");

	public static String getBrowser() {
		return BROWSER;
	}

	public static String getChromeBrowser() {
		return CHROME_BROWSER;
	}

	public static String getFirefoxBrowser() {
		return FIREFOX_BROWSER;
	}

	public static String getImplicitlyWait() {
		return IMPLICITLY_WAIT;
	}

	public static String getUrl() {
		return URL;
	}

	public static String getChromeDriverPath() {
		return CHROME_DRIVER_PATH;
	}

	public static String getFirefoxDriverPath() {
		return FIREFOX_DRIVER_PATH;
	}

	public static String getUrlPath() {
		return URL_PATH;
	}

	public static String getExplicitlyWait() {
		return EXPLICITLY_WAIT;
	}

	public static List<String> getFooterExpectedUrlList() {
		return FOOTEREXPECTEDURLLIST;
	}

	public static List<String> getHeaderExpectedUrlList() {
		return HEADEREXPECTEDURLLIST;
	}

}
