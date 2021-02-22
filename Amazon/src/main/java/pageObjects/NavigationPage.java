package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavigationPage extends HomePage {
	By mobileCategory = By.xpath("//div[@id='nav-xshop']//a[2]");
	By mobile = By.xpath("//div[@id='gwd-browseMultiCategoryCard-merchandised-search-6']/div/div[1]");
	By productTitle = By.xpath("//span[@id='productTitle']");
	By productPrize = By.xpath("//table/tbody/tr[2]/td[2]/span[1]");
	By addtocart = By.cssSelector("#add-to-cart-button");
	By cartPage= By.cssSelector("#nav-cart");
	By cartPageText= By.xpath("//h1");
	By searchbox = By.cssSelector("#twotabsearchtextbox");
	By tableLink= By.xpath("//*[@id='search']/div[1]/div[2]/div/span[3]/div[2]/div[3]/div/span/div/div/div/div/div[2]/h2/a");
	By cartProductNameList=By.xpath("//ul/li[1]/span/a/span[1]");
	By cartProductPriceList=By.xpath("//p[@class='a-spacing-small']/span");
	By totalprice=By.xpath("//span[@id='sc-subtotal-amount-activecart']");
	
	public NavigationPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getMobileCategory() {
		return driver.findElement(mobileCategory);
	}

	public WebElement getMobile() {
		return driver.findElement(mobile);
	}

	public WebElement getProductPrize() {
		return driver.findElement(productPrize);
	}

	public WebElement getProductTitle() {
		return driver.findElement(productTitle);
	}

	public WebElement getAddtoCart() {
		return driver.findElement(addtocart);
	}
	public WebElement getCartPage() {
		return driver.findElement(cartPage);
	}
	public WebElement getCartPageText() {
		return driver.findElement(cartPageText);
	}
	
	public WebElement getSearchTextBox() {
		return driver.findElement(searchbox);
	}
	
	public WebElement getTableLink() {
		return driver.findElement(tableLink);
	}
	public List<WebElement> getCartProductNameList() {
		return driver.findElements(cartProductNameList);
		  
	}
	public List<WebElement> getCartProductPriceList() {
		return driver.findElements(cartProductPriceList);
		  
	}
	public WebElement getTotalPrice(){
		return driver.findElement(totalprice);
	}
}
