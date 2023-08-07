package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

import org.testng.annotations.BeforeSuite;

import Log4jUtils.LogFile;


//import org.junit.runner.RunWith;
//import cucumber.api.junit.Cucumber;
//If you want to run with junit, we need @RunWith annotation and junit RunWith and Cucumber jars
//import cucumber.api.CucumberOptions;
//import cucumber.api.testng.AbstractTestNGCucumberTests;
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
//import com.framework.selenium.utility.FileOPerations;
//import com.framework.selenium.utility.PropertyFileUtility;


//@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/Features/FeatureFile.feature"},
glue = {"StepDefinition"} , plugin = {"pretty", "html:target/HTMLReports", 
												"json:target/cucumber.json"})
		
//public class RunCuke {
//
//}
public class TestRunner extends AbstractTestNGCucumberTests {
	
	@BeforeSuite
	public void initialize() {
		
		try {
			System.setProperty("log4j2.configurationFile", System.getProperty("user.dir") +"//src//main//resources//Log4jProperties/log4j2.xml");
			System.out.println( System.getProperty("log4j2.configurationFile") );
			System.out.println("I am in BeforeSuite in TestRunner -- Log4j2");
			LogFile.logger.atLevel(Level.ALL);
			LogFile.startLog(null);
			LogFile.logger.warn("Starting the Suite");
			LogFile.logger.info("Starting the Suite");
			LogFile.logger.trace("Starting the Suite");
			
			LogFile.logger.debug("Starting the Suite");
			LogFile.logger.error("Starting the Suite");
			LogFile.logger.fatal("Starting the Suite");

		} catch (Throwable t) {
			t.printStackTrace();
			System.out.println("Unable to initialize the log file");
			LogFile.logger.error("Error in initialize the Log file");
		}
	}
	
}






//@CucumberOptions(plugin  ={"pretty" , "html:target/destination12"},
//features={"src//test//java//com//cucumber//guru99//features//TC001.feature"},
//glue    ={"com.cucumber.guru99.stepdefinition"})

//public class RunCuke extends AbstractTestNGCucumberTests{
//	
//	//GlobalPaths
//	public static String ProjectPath = System.getProperty("user.dir");
//	public String globalPropPath = ProjectPath+"\\SeleniumSetup\\GlobalPropertyFiles\\global.properties";
//	public static String iedriveraddon = ProjectPath+"\\SeleniumSetup\\BrowserDrivers\\IEDriverServer.exe";
//	public static String geckodriveraddon = ProjectPath+"\\SeleniumSetup\\BrowserDrivers\\geckodriver.exe";
//	public static String chromedriveraddon = ProjectPath+"\\SeleniumSetup\\BrowserDrivers\\chromedriver.exe";
//	
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
//		propFileUtil = new PropertyFileUtility();
//		reporter = new ReporterUtil();
//		fileOper = new FileOperations();
//		
//		globalPropRef = propFileUtil.PropertyFileInitialization(globalPropPath);
//		ReporterType = globalPropRef.getProperty("ReporterType");
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
