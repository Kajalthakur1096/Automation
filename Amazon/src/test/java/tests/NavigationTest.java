package tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonUtilities.ConfigFileReader;
import commonUtilities.ConstantDataReader;
import commonUtilities.ItemDetails;
import pageObjects.NavigationPage;

public class NavigationTest extends HomeTest {
	List<ItemDetails> list1 = new ArrayList<ItemDetails>();
	ItemDetails objectOfItemDetails2;
	List<ItemDetails> list2 = new ArrayList<ItemDetails>();
	Float sum = (float) 0;

	@BeforeTest
	public void setUp() throws IOException {
		driver = initializeDriver();
		driver.get(ConfigFileReader.INSTANCE.getApplicationUrl());
	}

	// This method is going to set the name and price in an itemDetails object
	// and will return the itemDetailsObject
	private ItemDetails getDetails(String Name, String Price) {
		ItemDetails objectOfItemDetails = new ItemDetails();
		objectOfItemDetails.setName(Name);
		objectOfItemDetails.setPrize(getProductPrizeDetails(Price));
		return objectOfItemDetails;
	}

	// This method will convert the string prize into float prize
	private Float getProductPrizeDetails(String Price) {
		Float productprize;
		String[] splitPrize = Price.split("\\s+");
		if (splitPrize[1].contains(",")) {
			String[] p = splitPrize[1].split("\\,");
			String newprize = p[0] + p[1];
			productprize = Float.parseFloat(newprize);
		} else {
			productprize = Float.parseFloat(splitPrize[1]);
		}
		return productprize;
	}

	// This method will switch the driver to newly tab opened.
	private void handleWindows(List<ItemDetails> list1) {
		NavigationPage objectOfNavigationPage = new NavigationPage(driver);
		Set<String> abc = driver.getWindowHandles();
		Iterator<String> it = abc.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		list1.add(getDetails(objectOfNavigationPage.getProductTitle().getText(),
				objectOfNavigationPage.getProductPrize().getText()));
		objectOfNavigationPage.getAddtoCart().click();
		driver.close();
		driver.switchTo().window(parentId);
		driver.get("https://www.amazon.in");
	}

	private Float addProductPrize() {
		for (int i = 0; i < list1.size(); i++) {
			sum = sum + list1.get(i).getPrize();
		}
		return sum;

	}

	// This method will add traverse through 2items. It will also add the items
	// in a list. Also, it will verify if the correct items are added inside the
	// cart or not.
	@Test
	public void verifyCorrectItemsAdded() throws InterruptedException {
		NavigationPage objectOfNavigationPage = new NavigationPage(driver);
		driver.manage().timeouts().implicitlyWait(ConfigFileReader.INSTANCE.getImplicitlyWait(), TimeUnit.SECONDS);
		objectOfNavigationPage.getMobileCategory().click();
		objectOfNavigationPage.getMobile().click();
		list1.add(getDetails(objectOfNavigationPage.getProductTitle().getText(),
				objectOfNavigationPage.getProductPrize().getText()));
		objectOfNavigationPage.getAddtoCart().click();
		driver.get("https://www.amazon.in/");
		objectOfNavigationPage.getSearchTextBox().sendKeys("Table", Keys.ENTER);
		objectOfNavigationPage.getTableLink().click();
		handleWindows(list1);
		objectOfNavigationPage.getCartPage().click();
		Assert.assertEquals(objectOfNavigationPage.getCartPageText().getText(),
				ConstantDataReader.getShoppingCartText());

		List<WebElement> cartProductNamelist = objectOfNavigationPage.getCartProductNameList();
		for (WebElement element : cartProductNamelist) {
			objectOfItemDetails2 = new ItemDetails();
			objectOfItemDetails2.setName(element.getText());
			list2.add(objectOfItemDetails2);
		}
		for (int i = 0; i < cartProductNamelist.size(); i++) {
			Assert.assertEquals(list2.get(i).getName(), ConstantDataReader.getExpectedProductNameList().get(i));
		}
	}

	// This method will will verify that the latest item that is added will
	// appear first in the list.
	@Test
	public void verifyItemsOrder() {
		for (int i = 0; i < list1.size(); i++) {
			Assert.assertEquals(list1.get(i).getName(), list2.get((list1.size() - 1) - i).getName());
		}
	}

	// This method will verify that the total price displayed is same as the
	// expected price
	@Test
	public void verifyItemsPrize() {
		sum = addProductPrize();
		NavigationPage objectOfNavigationPage = new NavigationPage(driver);
		String actualTotalPrice = objectOfNavigationPage.getTotalPrice().getText();
		Assert.assertEquals(getProductPrizeDetails(actualTotalPrice), sum);
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
