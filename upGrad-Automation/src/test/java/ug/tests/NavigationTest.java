package ug.tests;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import ug.commonUtils.ConfigFileReader;
import ug.commonUtils.ConstantDataReader;
import ug.pageObjects.NavigationPage;

public class NavigationTest extends CommonUtilities {
	int listsize, i;

	@BeforeTest
	public void setUp() throws IOException {
		driver = initializeDriver();
		driver.get(ConfigFileReader.INSTANCE.getApplicationUrl());
	}

	/*
	 * This method will select the DataScience option from the Course button,
	 * stores all the list of DataScience link and will navigate through every
	 * links.It will also verify if the links opened is the expected/correct
	 * links or not.
	 */
	@Test
	public void verifyHeaderDataScienceLink() throws InterruptedException {
		actualUrlList = new ArrayList<String>();
		NavigationPage objectOfNavigationPage = new NavigationPage(driver);
		objectOfNavigationPage.getCourseButton().click();
		objectOfNavigationPage.getDataScienceLink().click();
		elementList = objectOfNavigationPage.getDataScienceLinks();
		listsize = elementList.size();
		System.out.println(listsize);
		for (i = 0; i < listsize; i++) {
			actualUrlList.add(elementList.get(i).getAttribute("href"));
		}
		for (i = 0; i < listsize; i++) {
			driver.navigate().to(actualUrlList.get(i));
		}
		for (i = 0; i < actualUrlList.size(); i++) {
			Assert.assertEquals(actualUrlList.get(i), ConstantDataReader.getHeaderExpectedUrlList().get(i));
		}
		System.out.println("verifyHeaderDataScienceLink: Tested successfully");
	}

	/*
	 * This method will get the list of all the DataScience link from the
	 * Footer. It will navigate through each links and also verify if the links
	 * opened is the expected/correct links or not.
	 */

	@Test
	public void verifyFooterDataScienceLink() {
		actualUrlList = new ArrayList<String>();
		NavigationPage objectOfNavigationPage = new NavigationPage(driver);
		elementList = objectOfNavigationPage.getChildFooterLinks();
		listsize = elementList.size();
		for (i = 0; i < listsize; i++) {
			actualUrlList.add(elementList.get(i).getAttribute("href"));

		}
		for (i = 0; i < listsize; i++) {
			driver.navigate().to(actualUrlList.get(i));
		}
		for (i = 0; i < actualUrlList.size(); i++) {
			Assert.assertEquals(actualUrlList.get(i), ConstantDataReader.getFooterExpectedUrlList().get(i));

		}
		System.out.println("verifyFooterDataScienceLink: Tested successfully");
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
