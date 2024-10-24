package listener;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.ProjectSpicejet;
import utils.ExtentReportSpicejet;

public class ListenersSpicejet extends ProjectSpicejet implements ITestListener {

	//call getreport() mothod of extentreport class
	ExtentReports  extents=ExtentReportSpicejet.getreport();
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		test=extents.createTest(result.getMethod().getMethodName())
				.assignAuthor("subash")
				.assignDevice("Dell-Windows");
		//loggin
		test.log(Status.INFO,"Test started: "+result.getMethod().getMethodName());

	}
	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed...");
	}


	@Override
	public void onTestFailure(ITestResult result) {

		test.fail(result.getThrowable());
		//get the name of failed test case
		String testName=result.getName();
		//Logic for screenshot capture
		try {
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (IllegalAccessException|IllegalArgumentException|NoSuchFieldException|SecurityException e) {
			e.printStackTrace();
		}
		try {
			String screenshotPath=takeScreenshot(testName, driver);
		    test.addScreenCaptureFromPath(screenshotPath,testName);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		test.log(Status.FAIL, "Test failed but with sucess percentge "+result.getMethod().getMethodName());
	}
	@Override
	public void onFinish(ITestContext context) {
		extents.flush();
	}

}
