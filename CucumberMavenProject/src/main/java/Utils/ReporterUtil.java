//package Utils;
//
//import java.io.File;
//import java.io.IOException;
//import org.testng.Assert;
//import org.testng.Reporter;
//import org.testng.TestNG;
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;
//import Base.DriverScript;
//
//public class ReporterUtil extends DriverScript {
//	
//	public static ExtentReports extent;
//	public static ExtentTest test;
//
//	@SuppressWarnings("deprecation")
//	public void Initialize(String type){
//		
//		switch (type) {
//		case "ExtentReport":
//			extent= new ExtentReports(ProjectPath+"//Test-Artifacts//Result_"+TimeStamp+"//ExtentReport.html", true);
//			extent.loadConfig(new File(ProjectPath+"//SeleniumSetup//extent-config//extent-config.xml"));
//			break;
//		case "HTMLReport":
//			break;
//		case "TestNG":
//			fileOper.createDirs( ProjectPath+"\\Test-Artifacts\\Result_"+TimeStamp);
//			TestNG.getDefault().setOutputDirectory(ProjectPath+"\\Test-Artifacts\\Result_"+TimeStamp+"\\TestNG-Output\\");
//			break;
//		default:
//			Assert.assertTrue(false, " Reporter-Initialize : No matching reporting type ");
//		}
//		
//	}
//	
//	public void Flush(String type) throws IOException{
//		switch (type) {
//		case "ExtentReport":
//			extent.flush();
//			extent.close();
//			break;
//		case "HTMLReport":
//			break;
//		case "TestNG":
//			break;
//		default:
//			Assert.assertTrue(false, " Reporter-Flush : No matching reporting type ");
//		}
//		
//	}
//
//	
//	
//	
//	public void StartTest(String type, String[] ScenarioOutlineArr){
//		switch (type) {
//		case "ExtentReport":
//			test=extent.startTest(currScenarioName+" - Iter "+ IterationCount);
//			test.assignAuthor(cucumberUtil.getAuthor(ScenarioOutlineArr));
//			test.assignCategory(cucumberUtil.getCategory(ScenarioOutlineArr));
//			break;
//		case "HTMLReport":
//			break;
//		case "TestNG":
//			Reporter.log("******************** Start Test: "+currScenarioName+" - Iter "+ IterationCount+" ********************");
//			Reporter.log("*** Author - "+cucumberUtil.getAuthor(ScenarioOutlineArr)+" ***");
//			Reporter.log("*** Category - "+cucumberUtil.getCategory(ScenarioOutlineArr)+" ***");
//			break;
//		default:
//			Assert.assertTrue(false, " Reporter-StartTest : No matching reporting type ");
//		}
//	}
//	
//	
//	public void EndTest(String type){
//		switch (type) {
//		case "ExtentReport":
//			extent.endTest(test);
//			break;
//		case "HTMLReport":
//			break;
//		case "TestNG":
//			Reporter.log("******************** End Test: "+currScenarioName+" - Iter "+ IterationCount+" ********************");
//			break;
//		default:
//			Assert.assertTrue(false, " Reporter-EndTest : No matching reporting type ");
//		}
//	}
//	
//	public void Log(String type, String logStatus, String logContent){
//		switch (type) {
//			case "ExtentReport":
//				switch (logStatus) {
//					case "INFO":
//						test.log(LogStatus.INFO, logContent);
//						break;
//					case "ERROR":
//						test.log(LogStatus.ERROR, logContent);
//						break;
//					case "WARNING":
//						test.log(LogStatus.WARNING, logContent);
//						break;
//					case "PASS":
//						test.log(LogStatus.PASS, logContent);
//						break;
//					case "FAIL":
//						test.log(LogStatus.FAIL, logContent);
//						break;	
//					default:
//						Assert.assertTrue(false, " Reporter-Log-ExtentReport : No matching log status ");
//				}
//				break;
//			case "HTMLReport":
//				switch (logStatus) {
//					case "INFO":
//						break;
//					case "ERROR":
//						break;
//					case "WARNING":
//						break;
//					case "PASS":
//						break;
//					case "FAIL":
//						break;	
//					default:
//						Assert.assertTrue(false, " Reporter-Log-HTMLReport : No matching log status ");
//				}
//				break;
//			case "TestNG":
//				switch (logStatus) {
//					case "INFO":
//						Reporter.log("INFO: "+logContent);
//						break;
//					case "ERROR":
//						Reporter.log("ERROR: "+logContent);
//						break;
//					case "WARNING":
//						Reporter.log("WARNING: "+logContent);
//						break;
//					case "PASS":
//						Reporter.log("PASS: "+logContent);
//						break;
//					case "FAIL":
//						Reporter.log("FAIL: "+logContent);
//						break;	
//					default:
//						Assert.assertTrue(false, " Reporter-Log-TestNG : No matching log status ");
//					}
//				break;
//			default:
//				Assert.assertTrue(false, " Reporter-Log : No matching reporting type ");
//			}
//		
//		
//		
//	}
//	
//	
//	public void AddScreenshot(String type, String logStatus, String ScreenshotName){
//		if(screenshotFlag){
//			switch (type) {
//				case "ExtentReport":
//					switch (logStatus) {
//						case "INFO":
//							test.log(LogStatus.INFO, "************************Screenshot-"+ScreenshotName+":************************"+test.addScreenCapture(fBridge.browserCapture(ScreenshotPath, ScreenshotName)));
//							break;
//						case "ERROR":
//							test.log(LogStatus.ERROR, "************************Screenshot-"+ScreenshotName+":************************"+test.addScreenCapture(fBridge.browserCapture(ScreenshotPath, ScreenshotName)));
//							break;
//						case "WARNING":
//							test.log(LogStatus.WARNING, "************************Screenshot-"+ScreenshotName+":************************"+test.addScreenCapture(fBridge.browserCapture(ScreenshotPath, ScreenshotName)));
//							break;	
//						default:
//							Assert.assertTrue(false, " Reporter-AddScreenshot-ExtentReport : No matching log status ");
//					}
//					break;
//				case "HTMLReport":
//					switch (logStatus) {
//					case "INFO":
//							break;
//						case "ERROR":
//							break;
//						case "WARNING":
//							break;	
//						default:
//							Assert.assertTrue(false, " Reporter-AddScreenshot-HTMLReport : No matching log status ");
//					}
//					break;
//				case "TestNG":
//					fBridge.browserCapture(ScreenshotPath, ScreenshotName);
//					break;
//				default:
//					Assert.assertTrue(false, " Reporter-Log : No matching reporting type ");
//				}
//		}
//	}
//}