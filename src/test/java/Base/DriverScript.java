package Base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.security.Credentials;
//import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.cucumber.java.Scenario;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;

//import org.openqa.selenium.winium.DesktopOptions;
//import org.openqa.selenium.winium.WiniumDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverScript {

	public static WebDriver driver = null;
	public static FileInputStream fis;
	public static Properties prop;
	static Scenario scenario;
	
	public DriverScript() {

		try {
			prop = new Properties();
			fis = new FileInputStream("./ConfigProperties.properties");
			prop.load(fis);

		} catch (Exception e) {
			System.out.println("No File Found " + e.getMessage());
			e.printStackTrace();
		}
	}

	//	public static void init() {
	//		String browser = prop.getProperty("Browser");
	//		if (browser.equalsIgnoreCase("Chrome")) {
	//			System.out.println("I am Chrome");
	//			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\mjuturu\\Downloads\\chromedriver_win32\\chromedriver.exe");
	//			WebDriverManager.chromedriver().arch64().setup();;
	//			driver = new ChromeDriver();
	//
	//			//ChromeOptions options = new ChromeOptions();
	//			//options.addArguments("headless");
	//			//driver = new ChromeDriver(options);
	//		}	else if (browser.equalsIgnoreCase("ie")) {
	////			System.setProperty("webdriver.ie.driver", "./sp-browsers/IEDriverServer.exe");
	////			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
	////			caps.setCapability("ignoreZoomSetting", true);
	////			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
	////			driver = new InternetExplorerDriver(caps);
	//		}	else if (browser.equalsIgnoreCase("firefox")) {
	//			System.setProperty("webdriver.gecko.driver", "C:\\Users\\mrufu\\Downloads\\geckodriver-v0.33.0-win32\\geckodriver.exe");
	//			driver = new FirefoxDriver();
	//		}
	//
	//		driver.manage().window().maximize();
	//		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	//		driver.manage().deleteAllCookies();
	//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//	}

	public static void openURL() throws AWTException {

		String browser = prop.getProperty("Browser");
		if (browser.equalsIgnoreCase("Chrome")) {
			System.out.println("I am Chrome in OPENURL");
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\mrufu\\Downloads\\chromedriver_win32\\chromedriver.exe");
			WebDriverManager.chromedriver().arch64().setup();;
			driver = new ChromeDriver();
		}	else if (browser.equalsIgnoreCase("edge")) {
			System.out.println("I am OPENURL EDGE");
			System.setProperty("webdriver.edge.driver", "C:\\Users\\mrufu\\Downloads\\edgedriver_win64\\msedgedriver.exe");
			driver = new InternetExplorerDriver();
		}	else if (browser.equalsIgnoreCase("firefox")) {
			System.out.println("I am FIREFOX in OPENURL");
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\mrufu\\Downloads\\geckodriver-v0.33.0-win64\\geckodriver.exe");
			//WebDriverManager.firefoxdriver().arch64().setup();
			driver = new FirefoxDriver();

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		System.out.println("HIIIII "+prop.getProperty("url"));
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

		String title = driver.getTitle();
		System.out.println("Title is ..... " + title);

		String wndhndle = driver.getWindowHandle();
		System.out.println(wndhndle);


		//Get handles of the windows
		//		        String mainWindowHandle = driver.getWindowHandle();
		//		        Set<String> allWindowHandles = driver.getWindowHandles();
		//		        Iterator<String> iterator = allWindowHandles.iterator();
		//		 
		//		        // Here we will check if child window has other child windows and will fetch the heading of the child window
		//		        while (iterator.hasNext()) {
		//		            String ChildWindow = iterator.next();
		//		                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
		//		                driver.switchTo().window(ChildWindow);
		//		                WebElement text = driver.findElement(By.id("sampleHeading"));
		//		                System.out.println("Heading of child window is " + text.getText());
		//		            }
		//		        }
		//		        
		//		        driver.switchTo().window(mainWindowHandle);

		//				 WebDriverWait wait = new WebDriverWait(driver, 10);
		//
		//				 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(>someid>)));

		// DesktopOptions option = new DesktopOptions();
		// option.setApplicationPath("C:\\Windows\\System32\\calc.exe");
		// WiniumDriver driver = new WiniumDriver(new URL("http://localhost:9999"),
		// option) ;
		// ChromeOptions options = new ChromeOptions();
		// options.addArguments("auth-server-whitelist='https://extfed.xlgroup.com/Home/LoginNtlm?'");
		//	driver.get("https://extfed.xlgroup.com/Home/LoginNtlm?");
		//	Alert a= driver.switchTo().alert();

		//		Robot r = new Robot();
		//		r.keyPress(KeyEvent.VK_TAB);
		//		r.keyRelease(KeyEvent.VK_TAB);
		//		r.keyPress(KeyEvent.VK_TAB);
		//		r.keyRelease(KeyEvent.VK_TAB);
		//
		//
		//		WebDriverWait webdriverWait = new WebDriverWait(driver, 10);
		//		Alert alert = webdriverWait.until(ExpectedConditions.alertIsPresent());
		//		alert.authenticateUsing(new UserAndPassword(username, password));
	}

	public static void openCGURL() throws AWTException {
		driver.get(prop.getProperty("intranetCGurl"));
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		System.out.println("I am opening Intranet CG site");
	}

	public static void tearDown() {
		
		System.out.println("Leaving Byeeee....");
//		driver.close();
//		driver.quit();
	}
}