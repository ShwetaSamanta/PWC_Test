package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
static ExtentReports extent;
public static ExtentReports getReport(){
	String path=System.getProperty("user.dir")+"\\reports\\index1.html";
	ExtentSparkReporter reporter= new ExtentSparkReporter(path);
	reporter.config().setReportName("FlipKartPage");
	extent= new ExtentReports();
	extent.attachReporter(reporter);
	return extent;
	
}
}
