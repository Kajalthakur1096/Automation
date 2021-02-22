package bil.commonUtilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

	@DataProvider(name = "MRLTeacherLoginDataProvider")
	public static String[][] getMRLTeacherLoginData() throws IOException {
		TestDataReader objectOfTestDataReader = new TestDataReader();
		return objectOfTestDataReader.getLoginData(ConstantDataReader.getMRLTeacherLoginSheetName());

	}

	@DataProvider(name = "OLDTeacherLoginDataProvider")
	public static String[][] getOLDTeacherLoginData() throws IOException {
		TestDataReader objectOfTestDataReader = new TestDataReader();
		return objectOfTestDataReader.getLoginData(ConstantDataReader.getOLDTeacherLoginSheetName());

	}

	@DataProvider(name = "Kto5StudentLoginDataProvider")
	public static String[][] getKto5StudentLoginData() throws IOException {
		TestDataReader objectOfTestDataReader = new TestDataReader();
		return objectOfTestDataReader.getLoginData(ConstantDataReader.getKto5StudentLoginSheetName());

	}

	@DataProvider(name = "GreaterThan5StudentLoginDataProvider")
	public static String[][] getGreaterThan5StudentLoginData() throws IOException {
		TestDataReader objectOfTestDataReader = new TestDataReader();
		return objectOfTestDataReader.getLoginData(ConstantDataReader.getGreaterthanfiveStudentLoginSheetName());

	}

	@DataProvider(name = "OLDStudentLoginDataProvider")
	public static String[][] getOLDStudentLoginData() throws IOException {
		TestDataReader objectOfTestDataReader = new TestDataReader();
		return objectOfTestDataReader.getLoginData(ConstantDataReader.getOLDStudentLoginSheetName());

	}

	@DataProvider(name = "InvalidUserDataProvider")
	public static String[][] getInvalidUserLoginData() throws IOException {
		TestDataReader objectOfTestDataReader = new TestDataReader();
		return objectOfTestDataReader.getLoginData(ConstantDataReader.getInvalidUserLoginSheetName());

	}

	@DataProvider(name = "DistrictAdminLoginDataProvider")
	public static String[][] getDistrictAdminLoginData() throws IOException {
		TestDataReader objectOfTestDataReader = new TestDataReader();
		return objectOfTestDataReader.getLoginData(ConstantDataReader.getDistrictadminloginSheetName());

	}

	@DataProvider(name = "SystemAdminLoginDataProvider")
	public static String[][] getSystemAdminLoginData() throws IOException {
		TestDataReader objectOfTestDataReader = new TestDataReader();
		return objectOfTestDataReader.getLoginData(ConstantDataReader.getSystemadminloginSheetName());

	}

	@DataProvider(name = "TeacherRegistrationDataProvider")
	public static String[][] getTeacherRegistrationData() throws IOException {
		TestDataReader objectOfTestDataReader = new TestDataReader();
		return objectOfTestDataReader.getLoginData(ConstantDataReader.getTeacherRegistrationSheetName());

	}

	@DataProvider(name = "MultipleTeacherRegistrationDataProvider")
	public static String[][] getMultipleTeacherRegistrationData() throws IOException {
		TestDataReader objectOfTestDataReader = new TestDataReader();
		return objectOfTestDataReader.getLoginData(ConstantDataReader.getMultipleTeacherRegistrationSheetName());

	}

	@DataProvider(name = "StudentRegistrationDataProvider")
	public static String[][] getStudentRegistrationData() throws IOException {
		TestDataReader objectOfTestDataReader = new TestDataReader();
		return objectOfTestDataReader.getLoginData(ConstantDataReader.getStudentRegistrationSheetName());

	}

	@DataProvider(name = "DARegistrationDataProvider")
	public static String[][] getDARegistrationData() throws IOException {
		TestDataReader objectOfTestDataReader = new TestDataReader();
		return objectOfTestDataReader.getLoginData(ConstantDataReader.getDARegistrationSheetName());

	}

	@DataProvider(name = "MultipleStudentRegistrationDataProvider")
	public static String[][] getMultipleStudentRegistrationData() throws IOException {
		TestDataReader objectOfTestDataReader = new TestDataReader();
		return objectOfTestDataReader.getLoginData(ConstantDataReader.getMultipleStudentRegistrationSheetName());

	}

	@DataProvider(name = "MultipleDARegistrationDataProvider")
	public static String[][] getMultipleDARegistrationData() throws IOException {
		TestDataReader objectOfTestDataReader = new TestDataReader();
		return objectOfTestDataReader.getLoginData(ConstantDataReader.getMultipleDARegistrationSheetName());

	}

}
