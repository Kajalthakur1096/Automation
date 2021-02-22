package com.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OnlinePage extends BasePage {
	By startTestButton = By.cssSelector("#btnStartTest");
	By submitTestButton = By.cssSelector("#btnSubmitTest");
	By marksObtained=By.xpath("//*[@id='divResultStatistics']//tr[1]");
	By totalQuestions=By.xpath("//*[@id='divResultStatistics']//tr[2]//b");
	By answeredQuestions=By.xpath("//*[@id='divResultStatistics']//tr[3]//b");
	By unansweredQuestions= By.xpath("//*[@id='divResultStatistics']//tr[4]//b");
	By userAnswers=By.xpath("//*[@class='div-ans-des-wrapper']/p[1]/span[2]");
	By actualAnswers=By.xpath("//*[@class='div-ans-des-wrapper']/p[2]/span[2]");
	
	By selectCorrectAnswer1 = By.cssSelector("#tdOptionNo_A_158");
	By selectCorrectAnswer2 = By.cssSelector("#tdOptionNo_A_161");
	By selectCorrectAnswer3 = By.cssSelector("#tdOptionNo_C_183");
	By selectCorrectAnswer4 = By.cssSelector("#tdOptionNo_A_227");
	By selectCorrectAnswer5 = By.cssSelector("#tdOptionNo_C_228");
	By selectCorrectAnswer6 = By.cssSelector("#tdOptionNo_D_290");
	By selectCorrectAnswer7 = By.cssSelector("#tdOptionNo_E_323");
	By selectCorrectAnswer8 = By.cssSelector("#tdOptionNo_A_322");
	By selectCorrectAnswer9 = By.cssSelector("#tdOptionNo_D_394");
	By selectCorrectAnswer10 = By.cssSelector("#tdOptionNo_C_422");
	By selectCorrectAnswer11 = By.cssSelector("#tdOptionNo_B_488");
	By selectCorrectAnswer12 = By.cssSelector("#tdOptionNo_C_514");
	By selectCorrectAnswer13 = By.cssSelector("#tdOptionNo_C_579");
	By selectCorrectAnswer14 = By.cssSelector("#tdOptionNo_B_665");
	By selectCorrectAnswer15 = By.cssSelector("#tdOptionNo_B_716");
	By selectCorrectAnswer16 = By.cssSelector("#tdOptionNo_C_745");
	By selectCorrectAnswer17 = By.cssSelector("#tdOptionNo_A_755");
	By selectCorrectAnswer18 = By.cssSelector("#tdOptionNo_B_754");
	By selectCorrectAnswer19 = By.cssSelector("#tdOptionNo_D_760");
	By selectCorrectAnswer20 = By.cssSelector("#tdOptionNo_A_777");

	By selectInCorrectAnswer1 = By.cssSelector("#tdOptionNo_B_158");
	By selectInCorrectAnswer2 = By.cssSelector("#tdOptionNo_B_161");
	By selectInCorrectAnswer3 = By.cssSelector("#tdOptionNo_A_183");
	By selectInCorrectAnswer4 = By.cssSelector("#tdOptionNo_B_227");
	By selectInCorrectAnswer5 = By.cssSelector("#tdOptionNo_A_228");
	By selectInCorrectAnswer6 = By.cssSelector("#tdOptionNo_A_290");
	By selectInCorrectAnswer7 = By.cssSelector("#tdOptionNo_A_323");
	By selectInCorrectAnswer8 = By.cssSelector("#tdOptionNo_B_322");
	By selectInCorrectAnswer9 = By.cssSelector("#tdOptionNo_A_394");
	By selectInCorrectAnswer10 = By.cssSelector("#tdOptionNo_B_422");
	By selectInCorrectAnswer11 = By.cssSelector("#tdOptionNo_A_488");
	By selectInCorrectAnswer12 = By.cssSelector("#tdOptionNo_A_514");
	By selectInCorrectAnswer13 = By.cssSelector("#tdOptionNo_A_579");
	By selectInCorrectAnswer14 = By.cssSelector("#tdOptionNo_A_665");
	By selectInCorrectAnswer15 = By.cssSelector("#tdOptionNo_A_716");
	By selectInCorrectAnswer16 = By.cssSelector("#tdOptionNo_A_745");
	By selectInCorrectAnswer17 = By.cssSelector("#tdOptionNo_C_755");
	By selectInCorrectAnswer18 = By.cssSelector("#tdOptionNo_A_754");
	By selectInCorrectAnswer19 = By.cssSelector("#tdOptionNo_A_760");
	By selectInCorrectAnswer20 = By.cssSelector("#tdOptionNo_B_777");

	By selectPartialAnswer1 = By.cssSelector("#tdOptionNo_A_158");
	By selectPartialAnswer2 = By.cssSelector("#tdOptionNo_B_161");
	By selectPartialAnswer3 = By.cssSelector("#tdOptionNo_C_183");
	By selectPartialAnswer4 = By.cssSelector("#tdOptionNo_B_227");
	By selectPartialAnswer5 = By.cssSelector("#tdOptionNo_C_228");
	By selectPartialAnswer6 = By.cssSelector("#tdOptionNo_D_290");
	By selectPartialAnswer7 = By.cssSelector("#tdOptionNo_E_323");
	By selectPartialAnswer8 = By.cssSelector("#tdOptionNo_B_322");
	By selectPartialAnswer9 = By.cssSelector("#tdOptionNo_D_394");
	By selectPartialAnswer10 = By.cssSelector("#tdOptionNo_C_422");

	public OnlinePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement clickStartButton() {
		return driver.findElement(startTestButton);
	}

	public WebElement clickSubmitButton() {
		return driver.findElement(submitTestButton);
	}
	
	public WebElement gettotalQuestions(){
		return driver.findElement(totalQuestions);
	}
	public WebElement getAnsweredQuestions(){
		return driver.findElement(answeredQuestions);
	}
	public WebElement getUnansweredQuestions(){
		return driver.findElement(unansweredQuestions);
	}
	public WebElement getMarksObtained(){
		return driver.findElement(marksObtained);
	}
	public List<WebElement> getUserAnswers(){
		return driver.findElements(userAnswers);
	}
	public List<WebElement> getActualAnswers(){
		return driver.findElements(actualAnswers);
	}

	public WebElement selectCorrectAnswer1() {
		return driver.findElement(selectCorrectAnswer1);
	}

	public WebElement selectCorrectAnswer2() {
		return driver.findElement(selectCorrectAnswer2);
	}

	public WebElement selectCorrectAnswer3() {
		return driver.findElement(selectCorrectAnswer3);
	}

	public WebElement selectCorrectAnswer4() {
		return driver.findElement(selectCorrectAnswer4);
	}

	public WebElement selectCorrectAnswer5() {
		return driver.findElement(selectCorrectAnswer5);
	}

	public WebElement selectCorrectAnswer6() {
		return driver.findElement(selectCorrectAnswer6);
	}

	public WebElement selectCorrectAnswer7() {
		return driver.findElement(selectCorrectAnswer7);
	}

	public WebElement selectCorrectAnswer8() {
		return driver.findElement(selectCorrectAnswer8);
	}

	public WebElement selectCorrectAnswer9() {
		return driver.findElement(selectCorrectAnswer9);
	}

	public WebElement selectCorrectAnswer10() {
		return driver.findElement(selectCorrectAnswer10);
	}

	public WebElement selectCorrectAnswer11() {
		return driver.findElement(selectCorrectAnswer11);
	}

	public WebElement selectCorrectAnswer12() {
		return driver.findElement(selectCorrectAnswer12);
	}

	public WebElement selectCorrectAnswer13() {
		return driver.findElement(selectCorrectAnswer13);
	}

	public WebElement selectCorrectAnswer14() {
		return driver.findElement(selectCorrectAnswer14);
	}

	public WebElement selectCorrectAnswer15() {
		return driver.findElement(selectCorrectAnswer15);
	}

	public WebElement selectCorrectAnswer16() {
		return driver.findElement(selectCorrectAnswer16);
	}

	public WebElement selectCorrectAnswer17() {
		return driver.findElement(selectCorrectAnswer17);
	}

	public WebElement selectCorrectAnswer18() {
		return driver.findElement(selectCorrectAnswer18);
	}

	public WebElement selectCorrectAnswer19() {
		return driver.findElement(selectCorrectAnswer19);
	}

	public WebElement selectCorrectAnswer20() {
		return driver.findElement(selectCorrectAnswer20);
	}

	public WebElement selectInCorrectAnswer1() {
		return driver.findElement(selectInCorrectAnswer1);
	}

	public WebElement selectInCorrectAnswer2() {
		return driver.findElement(selectInCorrectAnswer2);
	}

	public WebElement selectInCorrectAnswer3() {
		return driver.findElement(selectInCorrectAnswer3);
	}

	public WebElement selectInCorrectAnswer4() {
		return driver.findElement(selectInCorrectAnswer4);
	}

	public WebElement selectInCorrectAnswer5() {
		return driver.findElement(selectInCorrectAnswer5);
	}

	public WebElement selectInCorrectAnswer6() {
		return driver.findElement(selectInCorrectAnswer6);
	}

	public WebElement selectInCorrectAnswer7() {
		return driver.findElement(selectInCorrectAnswer7);
	}

	public WebElement selectInCorrectAnswer8() {
		return driver.findElement(selectInCorrectAnswer8);
	}

	public WebElement selectInCorrectAnswer9() {
		return driver.findElement(selectInCorrectAnswer9);
	}

	public WebElement selectInCorrectAnswer10() {
		return driver.findElement(selectInCorrectAnswer10);
	}

	public WebElement selectInCorrectAnswer11() {
		return driver.findElement(selectInCorrectAnswer11);
	}

	public WebElement selectInCorrectAnswer12() {
		return driver.findElement(selectInCorrectAnswer12);
	}

	public WebElement selectInCorrectAnswer13() {
		return driver.findElement(selectInCorrectAnswer13);
	}

	public WebElement selectInCorrectAnswer14() {
		return driver.findElement(selectInCorrectAnswer14);
	}

	public WebElement selectInCorrectAnswer15() {
		return driver.findElement(selectInCorrectAnswer15);
	}

	public WebElement selectInCorrectAnswer16() {
		return driver.findElement(selectInCorrectAnswer16);
	}

	public WebElement selectInCorrectAnswer17() {
		return driver.findElement(selectInCorrectAnswer17);
	}

	public WebElement selectInCorrectAnswer18() {
		return driver.findElement(selectInCorrectAnswer18);
	}

	public WebElement selectInCorrectAnswer19() {
		return driver.findElement(selectInCorrectAnswer19);
	}

	public WebElement selectInCorrectAnswer20() {
		return driver.findElement(selectInCorrectAnswer20);
	}
	public WebElement selectPartialAnswer1() {
		return driver.findElement(selectPartialAnswer1);
	}
	public WebElement selectPartialAnswer2() {
		return driver.findElement(selectPartialAnswer2);
	}
	public WebElement selectPartialAnswer3() {
		return driver.findElement(selectPartialAnswer3);
	}
	public WebElement selectPartialAnswer4() {
		return driver.findElement(selectPartialAnswer4);
	}
	public WebElement selectPartialAnswer5() {
		return driver.findElement(selectPartialAnswer5);
	}
	public WebElement selectPartialAnswer6() {
		return driver.findElement(selectPartialAnswer6);
	}
	public WebElement selectPartialAnswer7() {
		return driver.findElement(selectPartialAnswer7);
	}
	public WebElement selectPartialAnswer8() {
		return driver.findElement(selectPartialAnswer8);
	}
	public WebElement selectPartialAnswer9() {
		return driver.findElement(selectPartialAnswer9);
	}
	public WebElement selectPartialAnswer10() {
		return driver.findElement(selectPartialAnswer10);
	}

}
