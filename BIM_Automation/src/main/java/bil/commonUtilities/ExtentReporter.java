package bil.commonUtilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	static ExtentReports objectOfExtentReports;

	public static ExtentReports getReportObject() {
		String pathOfReport = ConfigFileReader.INSTANCE.getReportPath()
				+ ConfigFileReader.INSTANCE.getReportFolderName() + ConfigFileReader.INSTANCE.getReportName();
		ExtentSparkReporter objectOfExtentSparkReporter = new ExtentSparkReporter(pathOfReport);

		objectOfExtentSparkReporter.config().setReportName(ConstantDataReader.getExtentReportName());
		objectOfExtentSparkReporter.config().setDocumentTitle(ConstantDataReader.getDocumentTitle());
		objectOfExtentReports = new ExtentReports();
		objectOfExtentReports.attachReporter(objectOfExtentSparkReporter);
		objectOfExtentReports.setSystemInfo(ConstantDataReader.getTesterInfo(), ConstantDataReader.getTesterName());
		return objectOfExtentReports;
	}
}
