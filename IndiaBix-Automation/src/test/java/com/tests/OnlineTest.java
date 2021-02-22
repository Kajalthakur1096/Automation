package com.tests;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.General.ConfigFileReader;
import com.General.ConstantDataReader;
import com.General.MarksSummary;
import com.General.TestDataProvider;
import com.pageObjects.OnlinePage;

public class OnlineTest extends BaseTest {
	private OnlinePage objectOfOnlinePage;

	private void verifySubmitWindowAppears() {
		String alertText = driver.switchTo().alert().getText();
		if (alertText.contains("unanswered")) {
			String[] splitText = alertText.split("\\r?\\n");
			String submitText = splitText[2];
			Assert.assertEquals(submitText, ConstantDataReader.getAlertText());
		} else {
			Assert.assertEquals(alertText, ConstantDataReader.getAlertText());
		}
	}

	private String splitMarksObtained() {
		String marks = objectOfOnlinePage.getMarksObtained().getText();
		String[] split = marks.split(":");
		String marks2 = split[1];
		String[] split2 = marks2.split(" ");
		String marksObtained = split2[1];
		return marksObtained;
	}

	private MarksSummary setMarksDetails() {
		MarksSummary objectOfMarksSummary = new MarksSummary();
		objectOfMarksSummary.setMarksObtained(splitMarksObtained());
		objectOfMarksSummary.setTotalQuestionCount(objectOfOnlinePage.gettotalQuestions().getText());
		objectOfMarksSummary.setAnsweredQuestions(objectOfOnlinePage.getAnsweredQuestions().getText());
		objectOfMarksSummary.setUnansweredQuestions(objectOfOnlinePage.getUnansweredQuestions().getText());
		return objectOfMarksSummary;

	}

	private void validateUserAnswers() {
		List<WebElement> useranswersList = objectOfOnlinePage.getUserAnswers();
		List<WebElement> expectedAnswersList = objectOfOnlinePage.getActualAnswers();
		for (int i = 0; i < useranswersList.size(); i++) {
			Assert.assertEquals(useranswersList.get(i).getText(), expectedAnswersList.get(i).getText());
			System.out.println(useranswersList.get(i).getText() + "-" + expectedAnswersList.get(i).getText());

		}
	}

	@BeforeTest
	public void setUp() throws IOException {
		driver = initializeDriver();

	}

	@BeforeMethod
	public void getTestUrl() {
		driver.get(ConfigFileReader.INSTANCE.getApplicationUrl());
		objectOfOnlinePage = new OnlinePage(driver);
		objectOfOnlinePage.clickStartButton().click();
	}

	@Test(dataProvider = "correctDp", dataProviderClass = TestDataProvider.class)
	public void verifyAllAnsweredcorrectly(String marksObtained, String totalQuestions, String answeredQuestions,
			String unansweredQuestions) {
		driver.manage().window().maximize();
		objectOfOnlinePage = new OnlinePage(driver);
		driver.manage().timeouts().implicitlyWait(ConfigFileReader.INSTANCE.getImplicitlyWait(), TimeUnit.SECONDS);
		objectOfOnlinePage.selectCorrectAnswer1().click();
		objectOfOnlinePage.selectCorrectAnswer2().click();
		objectOfOnlinePage.selectCorrectAnswer3().click();
		objectOfOnlinePage.selectCorrectAnswer4().click();
		objectOfOnlinePage.selectCorrectAnswer5().click();
		objectOfOnlinePage.selectCorrectAnswer6().click();
		objectOfOnlinePage.selectCorrectAnswer7().click();
		objectOfOnlinePage.selectCorrectAnswer8().click();
		objectOfOnlinePage.selectCorrectAnswer9().click();
		objectOfOnlinePage.selectCorrectAnswer10().click();
		objectOfOnlinePage.selectCorrectAnswer11().click();
		objectOfOnlinePage.selectCorrectAnswer12().click();
		objectOfOnlinePage.selectCorrectAnswer13().click();
		objectOfOnlinePage.selectCorrectAnswer14().click();
		objectOfOnlinePage.selectCorrectAnswer15().click();
		objectOfOnlinePage.selectCorrectAnswer16().click();
		objectOfOnlinePage.selectCorrectAnswer17().click();
		objectOfOnlinePage.selectCorrectAnswer18().click();
		objectOfOnlinePage.selectCorrectAnswer19().click();
		objectOfOnlinePage.selectCorrectAnswer20().click();
		objectOfOnlinePage.clickSubmitButton().click();
		verifySubmitWindowAppears();
		driver.switchTo().alert().accept();
		MarksSummary objectOfMarksSummary = new MarksSummary();
		objectOfMarksSummary = setMarksDetails();
		Assert.assertEquals(objectOfMarksSummary.getMarksObtained(), marksObtained);
		Assert.assertEquals(objectOfMarksSummary.getTotalQuestionCount(), totalQuestions);
		Assert.assertEquals(objectOfMarksSummary.getAnsweredQuestions(), answeredQuestions);
		Assert.assertEquals(objectOfMarksSummary.getUnansweredQuestions(), unansweredQuestions);
		validateUserAnswers();
	}

	@Test(dataProvider = "inCorrectDp", dataProviderClass = TestDataProvider.class)
	public void verifyAllAnsweredIncorrectly(String marksObtained, String totalQuestions, String answeredQuestions,
			String unansweredQuestions) {
		driver.manage().window().maximize();
		objectOfOnlinePage = new OnlinePage(driver);
		driver.manage().timeouts().implicitlyWait(ConfigFileReader.INSTANCE.getImplicitlyWait(), TimeUnit.SECONDS);
		objectOfOnlinePage.selectInCorrectAnswer1().click();
		objectOfOnlinePage.selectInCorrectAnswer2().click();
		objectOfOnlinePage.selectInCorrectAnswer3().click();
		objectOfOnlinePage.selectInCorrectAnswer4().click();
		objectOfOnlinePage.selectInCorrectAnswer5().click();
		objectOfOnlinePage.selectInCorrectAnswer6().click();
		objectOfOnlinePage.selectInCorrectAnswer7().click();
		objectOfOnlinePage.selectInCorrectAnswer8().click();
		objectOfOnlinePage.selectInCorrectAnswer9().click();
		objectOfOnlinePage.selectInCorrectAnswer10().click();
		objectOfOnlinePage.selectInCorrectAnswer11().click();
		objectOfOnlinePage.selectInCorrectAnswer12().click();
		objectOfOnlinePage.selectInCorrectAnswer13().click();
		objectOfOnlinePage.selectInCorrectAnswer14().click();
		objectOfOnlinePage.selectInCorrectAnswer15().click();
		objectOfOnlinePage.selectInCorrectAnswer16().click();
		objectOfOnlinePage.selectInCorrectAnswer17().click();
		objectOfOnlinePage.selectInCorrectAnswer18().click();
		objectOfOnlinePage.selectInCorrectAnswer19().click();
		objectOfOnlinePage.selectInCorrectAnswer20().click();
		objectOfOnlinePage.clickSubmitButton().click();
		verifySubmitWindowAppears();
		driver.switchTo().alert().accept();
		MarksSummary objectOfMarksSummary = new MarksSummary();
		objectOfMarksSummary = setMarksDetails();
		Assert.assertEquals(objectOfMarksSummary.getMarksObtained(), marksObtained);
		Assert.assertEquals(objectOfMarksSummary.getTotalQuestionCount(), totalQuestions);
		Assert.assertEquals(objectOfMarksSummary.getAnsweredQuestions(), answeredQuestions);
		Assert.assertEquals(objectOfMarksSummary.getUnansweredQuestions(), unansweredQuestions);
		validateUserAnswers();
	}

	@Test(dataProvider = "partialDP", dataProviderClass = TestDataProvider.class)
	public void verifyAnsweredPartially(String marksObtained, String totalQuestions, String answeredQuestions,
			String unansweredQuestions) throws InterruptedException {
		driver.manage().window().maximize();
		objectOfOnlinePage = new OnlinePage(driver);
		driver.manage().timeouts().implicitlyWait(ConfigFileReader.INSTANCE.getImplicitlyWait(), TimeUnit.SECONDS);
		objectOfOnlinePage.selectPartialAnswer1().click();
		objectOfOnlinePage.selectPartialAnswer2().click();
		objectOfOnlinePage.selectPartialAnswer3().click();
		objectOfOnlinePage.selectPartialAnswer4().click();
		objectOfOnlinePage.selectPartialAnswer5().click();
		objectOfOnlinePage.selectPartialAnswer6().click();
		objectOfOnlinePage.selectPartialAnswer7().click();
		objectOfOnlinePage.selectPartialAnswer8().click();
		objectOfOnlinePage.selectPartialAnswer9().click();
		objectOfOnlinePage.selectPartialAnswer10().click();
		objectOfOnlinePage.clickSubmitButton().click();
		verifySubmitWindowAppears();
		driver.switchTo().alert().accept();
		MarksSummary objectOfMarksSummary = new MarksSummary();
		objectOfMarksSummary = setMarksDetails();
		Assert.assertEquals(objectOfMarksSummary.getMarksObtained(), marksObtained);
		Assert.assertEquals(objectOfMarksSummary.getTotalQuestionCount(), totalQuestions);
		Assert.assertEquals(objectOfMarksSummary.getAnsweredQuestions(), answeredQuestions);
		Assert.assertEquals(objectOfMarksSummary.getUnansweredQuestions(), unansweredQuestions);
		validateUserAnswers();
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
