package com.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.base.BaseClass;
import com.utility.DriverUtlis;

public class MyListener extends BaseClass implements ITestListener {

	public void onTestStart(ITestResult result) {
	  test= report.createTest(result.getName())	;

	}

	public void onTestSuccess(ITestResult result) {
	test.log(Status.PASS, "Testcase passed with name"+result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		String path =DriverUtlis.getScreenshot(result.getName());
		test.log(Status.FAIL, "Testcase passed with name"+result.getName());
		test.addScreenCaptureFromPath(path);
	}

	public void onTestSkipped(ITestResult result) {
	 test.log(Status.SKIP, "Testcase skipped with name"+result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		log.info("test suit is ready for the execution");
		
	}

	public void onFinish(ITestContext context) {
		log.info("test suit is successfully executed");
		report.flush();
		
	}
	 

}
