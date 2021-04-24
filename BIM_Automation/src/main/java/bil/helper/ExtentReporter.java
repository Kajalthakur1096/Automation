package bil.helper;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {

	public static ExtentReports getReportObject() {
		ExtentReports objectOfExtentReports;
		String pathOfReport = ConfigFileReader.INSTANCE.getReportPath()
				+ ConfigFileReader.INSTANCE.getReportFolderName() + ConfigFileReader.INSTANCE.getReportName();
		ExtentSparkReporter objectOfExtentSparkReporter = new ExtentSparkReporter(pathOfReport);

		objectOfExtentSparkReporter.config().setReportName(Constants.getExtentReportName());
		objectOfExtentSparkReporter.config().setDocumentTitle(Constants.getDocumentTitle());
		objectOfExtentReports = new ExtentReports();
		objectOfExtentReports.attachReporter(objectOfExtentSparkReporter);
		objectOfExtentReports.setSystemInfo(Constants.getTesterInfo(), Constants.getTesterName());
		return objectOfExtentReports;
	}
}
