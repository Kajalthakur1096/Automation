package ug.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavigationPage extends BasePage {
	By parentfooter = By
			.xpath("//div[contains(text(),'Data Science') and @class='Footer__header']//following-sibling::ul");
	By childfooter = By.tagName("a");
	By coursebutton = By.cssSelector(".ProgramList__title");
	// By datasciencelink =
	// By.xpath("//div[@class='ProgramList__listWrapper']/ul/li[2]/div");
	By datasciencelink = By.cssSelector("ul.ProgramList__list>li:nth-child(2)>div");
	// By datascienceFooterList =
	// By.xpath("//ul[@class='ProgramList__list']/li[2]/div[2]/div/ul/li/a");
	By datascienceList = By.cssSelector("ul.ProgramList__list>li:nth-child(2)>div:nth-child(2)>div>ul>li>a");

	public NavigationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getCourseButton() {
		return driver.findElement(coursebutton);
	}

	public WebElement getDataScienceLink() {
		return driver.findElement(datasciencelink);
	}

	public WebElement getParentFooter() {
		return driver.findElement(parentfooter);
	}

	public List<WebElement> getChildFooterLinks() {
		return getParentFooter().findElements(childfooter);

	}

	public List<WebElement> getDataScienceLinks() {
		return driver.findElements(datascienceList);
	}
	/*
	 * public List<WebElement> getDataScienceLinks() { return
	 * getDataScienceLink().findElements(datascienceList);
	 * 
	 * }
	 */

}
