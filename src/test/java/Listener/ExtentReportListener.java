//package Listener;
//
//import org.openqa.selenium.WebDriver;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//
//import com.aventstack.extentreports.markuputils.ExtentColor;
//import com.aventstack.extentreports.markuputils.MarkupHelper;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//import Utils.Helper;
//
//public class ExtentReportListener {
//	public static ExtentHtmlReporter report;
//	public static ExtentReports extent;
//	public static ExtentTest test;
//
//	public static ExtentReports setUp() {
//
//		String reportLocation = "./Report/Extent_Report.html";
//		System.out.println(reportLocation);
//		report = new ExtentHtmlReporter(reportLocation);
//		report.config().setDocumentTitle("GoogleApplicationTitle");
//		report.config().setReportName("GoogleApplicationReportName");
//		report.config().setTheme(Theme.STANDARD);
//
//		System.out.println("Extent report location initialized");
//		report.start();
//
//		extent = new ExtentReports();
//		extent.attachReporter(report);
//		extent.setSystemInfo("Application", "GoogleApplicationSystemInfo");
//		// extent.setSystemInfo("Operating System", System.getProperty("os.name"));
//
//		System.out.println("System info set in Extent Report");
//
//		return extent;
//
//	}
//
//	public static void testStepHandle(String teststatus, WebDriver driver, ExtentTest extenttest, Throwable throwable) {
//
//		switch (teststatus) {
//
//		case "FAIL":
//
//			extenttest.fail(MarkupHelper.createLabel("Test Case Failed :", ExtentColor.RED));
//			extenttest.error(throwable.fillInStackTrace());
//
//			try {
//				extenttest.addScreenCaptureFromPath(Helper.getScreenShot());
//
//			} catch (Exception e) {
//				e.printStackTrace();
//
//			}
//			if (driver != null) {
//				driver.quit();
//			}
//			break;
//
//		case "PASS":
//			extenttest.pass(MarkupHelper.createLabel("Test Case Passed :", ExtentColor.GREEN));
//			break;
//
//		case "SKIP":
//			extenttest.pass(MarkupHelper.createLabel("Test Case Skipped :", ExtentColor.ORANGE));
//			break;
//		}
//		
//		
//	}
//}