package Listener;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportListener {
	public static ExtentHtmlReporter report = null;
	public static ExtentReports extent = null;
	public static ExtentTest test = null;

	public static ExtentReports setUp() {

		String reportLocation = "./Report/Extent_Report.html";
		System.out.println(reportLocation);
		report = new ExtentHtmlReporter(reportLocation);
		report.config().setDocumentTitle("SiteForwardQA");
		report.config().setReportName("SiteForwardQA");
		report.config().setTheme(Theme.STANDARD);

		System.out.println("Extent report location initialized");
		report.start();

		extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Application", "SiteForwardQA");
		// extent.setSystemInfo("Operating System", System.getProperty("os.name"));

		System.out.println("System info set in Extent Report");

		return extent;

	}

	public static void testStepHandle(String teststatus, WebDriver driver, ExtentTest extenttest, Throwable throwable) {

		switch (teststatus) {

		case "FAIL":
			extenttest.fail(MarkupHelper.createLabel("Test Case Failed :", ExtentColor.RED));

			extenttest.error(throwable.fillInStackTrace());

			if (driver != null) {
				driver.quit();
			}
			break;
		}
	}
}