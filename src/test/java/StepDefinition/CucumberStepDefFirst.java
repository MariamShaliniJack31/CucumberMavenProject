package StepDefinition;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import Log4jUtils.LogFile;

import Base.DriverScript;
import Listener.ExtentReportListenerV5;
//import Listener.ITestListenerExtent;
import Pages.GoogleHomePage;
import Pages.GoogleHomePageFactory;
import Pages.IntranetCGPage;

//When using info.cukes 1.2.5 use below
//import cucumber.api.java.en.And;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
import io.cucumber.java.en.*;


public class CucumberStepDefFirst extends ExtentReportListenerV5{

	WebDriver driver;
	protected GoogleHomePage ghp;
	
	IntranetCGPage iCGP = new IntranetCGPage();
	//ITestListenerExtent Itestle = new ITestListenerExtent();
	ITestContext context;
	ExtentTest logInfo = null;
	
	public CucumberStepDefFirst() {
		ghp = new GoogleHomePage();
	}
	
//	@Given("^I launch Chrome browser$")
//	public void i_launch_Chrome_browser() throws Throwable {
//			
//		Itestle.onStart(context);  // Ashutosh Code working
//		ExtentTest loginfo = null;
//		try {
//			DriverScript.init();
//		} catch (Exception e) {
//			testStepHandle("PASS", driver, loginfo, e);
//		}
//	}
//	
//	@Given("^I open a Chrome Browser$")
//	public void i_open_a_Chrome_Browser() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//		//DriverScript.openURL();
//		
//	    //throw new PendingException();
//	}
	
	@When("^I open Google Homepage$")
	public void i_open_Google_Homepage() throws AWTException  {
		
		//Itestle.onStart(context);  // Ashutosh Code working
		
		try {
			DriverScript.openURL();
			test = extent.createTest(Feature.class, "Google HomePage");
			test = test.createNode(Scenario.class, "Check if Google Search & Feeling Lucky Buttons");
			logInfo = test.createNode(new GherkinKeyword("Given"), "Opened Google HomePage");
			Log4jUtils.LogFile.logger.info("Launched Google Application");

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);
		}
	}
	
	@Then("^I verify that the page displays search text box$")
	public void i_verify_that_the_page_displays_search_text_box() throws Throwable {
		
		try {
			ghp = new GoogleHomePage();
			ghp.SearchTextBoxDisplay();
			logInfo = test.createNode(new GherkinKeyword("Then"), "I Verify button SearchTextbox " );
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);
		}
	}
	
	@Then("^Enter some Text in Search text box$")
	public void enter_some_Text_in_Search_text_box() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		try {
			ghp.EnterTextinTextBox();
			logInfo = test.createNode(new GherkinKeyword("Then"), "I Enter Text in SearchTextbox " );
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);
		}
	}
	
	@Then("^the page displays Google Search button$")
	public void the_page_displays_Google_Search_button() throws Throwable {
		try {
			ghp.SearchButtonDisplay();
			logInfo = test.createNode(new GherkinKeyword("Then"), "I Verify Search Button" );
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);
		}
	}
	
	@And("^the page displays Im Feeling Lucky button$")
	public void the_page_displays_Im_Feeling_Lucky_button() throws Throwable {
		
		try {
			ghp.ImFeelingLuckyButtonDisplay();
			logInfo = test.createNode(new GherkinKeyword("Then"), "I Verify Feeling Lucky Button" );
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);
		}
	}
	
	@And("^Close the Application$")
	public void close_the_Application() throws Throwable {
		//Itestle.onFinish(context); // Ashutosh code working
		try {
			DriverScript.tearDown();
			logInfo = test.createNode(new GherkinKeyword("Then"), "Closing the Browser" );
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);
		}
	}
	
	@Given("^I launch IntranetGapgemini in Chrome browser$")
	public void i_launch_IntranetGapgemini_in_Chrome_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//DriverScript.init();
		DriverScript.openCGURL();
	    
	}

	@When("^I verify editprofile link$")
	public void i_verify_editprofile_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    iCGP.EditProfileBoxDisplay();
	}

}

//**************************** The below code is working *********************//

//import java.io.FileInputStream;
//import java.util.Properties;
//import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import cucumber.api.java.en.And;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//
//public class CucumberStepDefFirst_Working {
//	
//	public static WebDriver driver; 
//	public static Properties prop = new Properties();
//	public static FileInputStream fis; 
//	
//	@Given("^I launch Chrome browser$")
//	public void i_launch_Chrome_browser() throws Throwable {
//		// Write code here that turns the phrase above into concrete actions
//		
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mjuturu\\Downloads\\chromedriver_win32\\chromedriver.exe");
//		fis = new FileInputStream("./ConfigProperties.properties");
//		prop.load(fis);
//		driver = new ChromeDriver();
//		//driver.get("http://www.google.com");
//		
//		System.out.println( prop.getProperty("url") );
////		driver.get(prop.getProperty("url"));
////		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        
//	}
//
//	@When("^I open Google Homepage$")
//	public void i_open_Google_Homepage() throws Throwable {
//		//Write code here that turns the phrase above into concrete actions
//		//throw new PendingException();
//		driver.get(prop.getProperty("url"));
//		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
//		
//	}
//
//	@Then("^I verify that the page displays search text box$")
//	public void i_verify_that_the_page_displays_search_text_box() throws Throwable {
//		//    // Write code here that turns the phrase above into concrete actions
//		//    throw new PendingException();
//		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
//		if (driver.findElement(By.xpath("//input[@name='q']")).isDisplayed() ) {
//			System.out.println("Search TextBox is displayed in Google HomePage");
//		} else {
//			System.out.println("Search TextBox is NOT displayed in Google HomePage");
//		}	
//	}
//
//	@Then("^the page displays Google Search button$")
//	public void the_page_displays_Google_Search_button() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new PendingException();
//		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
//		if (driver.findElement(By.xpath("//input[@name='btnK']")).isDisplayed() ) {
//			System.out.println("Search Button is displayed in Google HomePage");
//		} else {
//			System.out.println("Search Button is NOT displayed in Google HomePage");
//		}
//	}
//
//	@And("^the page displays Im Feeling Lucky button$")
//	public void the_page_displays_Im_Feeling_Lucky_button() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new PendingException();
//		
//		if (driver.findElement(By.xpath("//input[@name='btnI']")).isDisplayed() ) {
//			System.out.println("I'm Feeling Lucky Button is displayed in Google HomePage");
//		} else {
//			System.out.println("I'm Feeling Lucky Button is NOT displayed in Google HomePage");
//		}
//	}
//	
//	@And("^Close the Application$")
//	public void close_the_Application() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new PendingException();
//		driver.close();
//		driver.quit();
//		System.out.println("Browser Google HomePage is Closed");
//	}
//}
