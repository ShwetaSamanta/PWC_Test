package actions;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.ExtentReport;

public class Listeners extends Base implements ITestListener {
ExtentReports extent= ExtentReport.getReport();
ThreadLocal<ExtentTest> extenttest	= new ThreadLocal<ExtentTest>();
ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		test= extent.createTest(result.getMethod().getMethodName());
		extenttest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extenttest.get().log(Status.PASS, "Added Successfully");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extenttest.get().log(Status.FAIL, "Test Case Failed");
		WebDriver driver= null;
		try {
		driver=(WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstanceName());
			}
		catch(Exception e){
			
		}
		String testcasename=result.getMethod().getMethodName();
		try
		{
			extenttest.get().addScreenCaptureFromPath(Screenshots(testcasename,driver), testcasename);
		}catch(Exception e)
		{
			
		}
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

	@Override
	public WebDriver initialization() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return super.initialization();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		
	}

}
