package com.General;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

	@DataProvider(name = "partialDP")
	public static Object[][] partiallyAnswered() {
		Object[][] data = new Object[1][4];
		data[0][0] = "7/20";
		data[0][1] = "20";
		data[0][2] = "10";
		data[0][3] = "10";
		return data;

	}
	@DataProvider(name = "correctDp")
	public static Object[][] correctlyAnswered() {
		Object[][] data = new Object[1][4];
		data[0][0] = "20/20";
		data[0][1] = "20";
		data[0][2] = "20";
		data[0][3] = "0";
		return data;

	}
	@DataProvider(name = "inCorrectDp")
	public static Object[][] inCorrectlyAnswered() {
		Object[][] data = new Object[1][4];
		data[0][0] = "0/20";
		data[0][1] = "20";
		data[0][2] = "20";
		data[0][3] = "0";
		return data;

	}
}
