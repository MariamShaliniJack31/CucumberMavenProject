package Listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;

public class ITestListenerExtent extends ExtentReportListenerV5 implements ITestListener {

	public void onTestStart(ITestResult result) {
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("PASS");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("FAIL");
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("SKIP");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onStart(ITestContext context) {
		System.out.println("Testcase Execution Started on QA Env...");
		extent = setUp();
	}

	public void onFinish(ITestContext context) {
		System.out.println("Testcase Execution Completed on QA Env...");
		extent.flush();
		System.out.println("Generated the Report");
	}
}