package commonUtilities;

import java.util.Arrays;
import java.util.List;

public class ConstantDataReader {
	private static final String BROWSER = "browser";
	private static final String CHROME_BROWSER = "chrome";
	private static final String FIREFOX_BROWSER = "firefox";
	private static final String IMPLICITLY_WAIT = "implicitlyWait";
	private static final String EXPLICITLY_WAIT = "explicitlyWait";
	private static final String URL = "url";
	private static final String URL_PATH = "https://www.amazon.in/";
	private static final String CHROME_DRIVER_PATH = "chromeDriverPath";
	private static final String FIREFOX_DRIVER_PATH = "geckoDriverPath";
	private static final String SHOPPING_CART_TEXT = "Shopping Cart";
	private static final List<String> EXPECTEDPRODUCTNAME = Arrays.asList(
			"SKUDGEAR Multi-Purpose Laptop Desk for Study and Reading with Foldable Non-Slip Legs Reading Table Tray (Black)",
			"Samsung Galaxy M02s (Blue,3GB RAM, 32GB Storage) | 5000 mAh | Triple Camera");

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

	public static String getShoppingCartText() {
		return SHOPPING_CART_TEXT;
	}

	public static List<String> getExpectedProductNameList() {
		return EXPECTEDPRODUCTNAME;
	}

}
