package TestRunner;
//package runner;
//
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeTest;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Properties;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.Test;
//import Utils.FileOperations;
//import Utils.PropertyFileUtility;
//import Utils.ReporterUtil;
//import cucumber.api.CucumberOptions;
//import cucumber.api.testng.AbstractTestNGCucumberTests;
//
//
//
//@CucumberOptions(plugin  ={"pretty"},
//features={"src/test/java/featureFiles/FeatureFile.feature"},
//glue    ={"stepDefinition"})
//
//public class RunCukesTest extends AbstractTestNGCucumberTests{
//	
//	//GlobalPaths
//	public static String ProjectPath=System.getProperty("user.dir");
//	public String globalPropPath=ProjectPath+"\\SeleniumSetup\\GlobalPropertyFiles\\global.properties";
//	public static String iedriveraddon=ProjectPath+"\\SeleniumSetup\\BrowserDrivers\\IEDriverServer.exe";
//	public static String geckodriveraddon=ProjectPath+"\\SeleniumSetup\\BrowserDrivers\\geckodriver.exe";
//	public static String chromedriveraddon=ProjectPath+"\\SeleniumSetup\\BrowserDrivers\\chromedriver.exe";
//	//Object Reference Initialization
//	public static Properties globalPropRef;
//	public static String ReporterType;
//	public PropertyFileUtility propFileUtil;
//	public static ReporterUtil reporter;
//	
//	public static FileOperations fileOper;
//	public static String TimeStamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new java.util.Date());
//	
//	@BeforeSuite
//	public void BeforeSuite(){
//			   
//		//Utility Object Creation
//		propFileUtil=new PropertyFileUtility();
//		reporter=new ReporterUtil();
//		fileOper=new FileOperations();
//		
//		globalPropRef=propFileUtil.PropertyFileInitialization(globalPropPath);
//		ReporterType=globalPropRef.getProperty("ReporterType");
//		reporter.Initialize(ReporterType);
//		System.out.println("TestNG - BeforeSuite");		
//	}
//	
//	@BeforeTest
//	public void BeforeTest(){
//		System.out.println("TestNG - BeforeTest");
//	}
//	
//	@BeforeClass
//	public void BeforeClass(){
//		System.out.println("TestNG - BeforeClass");
//	}
//	
//	@BeforeMethod
//	public void BeforeMethod(){
//		System.out.println("TestNG - BeforeMethod");
//	}
//	
//	@Test(enabled=false)
//	public void dummyTestMethod() {
//		
//	}
//	
//	@AfterMethod
//	public void AfterMethod(){
//		System.out.println("TestNG - AfterMethod");
//	}
//	
//	@AfterClass
//	public void AfterClass(){
//		System.out.println("TestNG - AfterClass");
//	}
//	
//	@AfterTest
//	public void AfterTest(){
//		System.out.println("TestNG - AfterTest");
//	}
//	
//	@AfterSuite
//	public void AfterSuite() throws IOException{
//		System.out.println("TestNG - AfterSuite");
//		reporter.Flush(ReporterType);
//	}
//}
