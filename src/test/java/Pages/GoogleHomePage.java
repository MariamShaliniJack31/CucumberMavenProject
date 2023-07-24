package Pages;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.DriverScript;
import Utils.Helper;

public class GoogleHomePage extends DriverScript {

	//	WebDriver driver;
	//	@FindBy(xpath="//textarea[contains(@name,'q')]")
	//	public WebElement SearchTextBox;
	//	@FindBy(xpath ="//input[@name='btnK']")
	//	WebElement Searchbutton;
	//	@FindBy(xpath ="//input[@name='btnI']")
	//	WebElement ImFeelingLuckyButton;

	By SearchTextBox = By.xpath("//textarea[contains(@name,'q')]");
	//WebElement SearchTextBox = driver.findElement(By.xpath("//textarea[contains(@name,'q')]"));
	//By Searchbutton = By.xpath("//div[@class='FPdoLc*']//input[@name='btnK']");
	By Searchbutton = By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']");
	By ImFeelingLuckyButton = By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@name='btnI' and @type='submit']");
	//////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	
	public void SearchTextBoxDisplay() {

		Helper.highLighterMethod(driver,driver.findElement(SearchTextBox)) ;
		driver.findElement(SearchTextBox).clear();

		System.out.println("Search Text Box Present is : " + driver.findElement(SearchTextBox).isDisplayed() );
		
		if ( driver.findElement(By.xpath("//a[contains(text(),'Gmail')]")).isDisplayed() ) {
			System.out.println( driver.findElement(By.xpath("//a[contains(text(),'Gmail')]")).getText() );
			System.out.println("Gmail Hyperlink is Present");
		} else {
			System.out.println("Gmail Hyperlink is NOT Present");
		}
	}

	public void EnterTextinTextBox() throws AWTException {

		driver.findElement(SearchTextBox).click();

		Actions actions = new Actions(driver);
		actions.keyDown(Keys.SHIFT);
		actions.sendKeys("CapGemini") ;
		actions.keyUp(Keys.SHIFT);

		Action action = actions.build();
		action.perform();
		

		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(SearchTextBox).sendKeys(Keys.TAB);

//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_CONTROL);
//		robot.keyPress(KeyEvent.VK_ENTER);

	}
	public void SearchButtonDisplay() {

//		 WebDriverWait wait = new WebDriverWait(driver, 10);
//		 WebElement elm = wait.until(ExpectedConditions.visibilityOfElementLocated(Searchbutton));
//		 
//		 if (elm.isEnabled()) {
//			 System.out.println("Search Button is Enabled in Google HomePage"); 
//		 } else	 {
//			 System.out.println("Search Button is NOT Enabled in Google HomePage");
//		 }

		if (driver.findElement(Searchbutton).isDisplayed() ) {
			System.out.println("Search Button is displayed in Google HomePage");
			//driver.findElement(Searchbutton).click();
		} else {
			System.out.println("Search Button is NOT displayed in Google HomePage");
		}
	}

	public void ImFeelingLuckyButtonDisplay() {
		if ( driver.findElement(ImFeelingLuckyButton).isDisplayed() )  {
			System.out.println("I'm Feeling Lucky Button is displayed in Google HomePage");
		} else {
			System.out.println("I'm Feeling Lucky Button is NOT displayed in Google HomePage");
		}
	}
} 
//public class GoogleHomePage extends DriverScript {
//	
//	public GoogleHomePage(WebDriver driver) {
//		PageFactory.initElements(driver, this);
//	}
//	
//	WebDriver driver;
//	//	@FindBy(xpath="//input[contains(@name,'q')]")
//	//public WebElement SearchTextBox;
//	//	@FindBy(xpath ="//input[@name='btnK']")
//	//	WebElement Searchbutton;
//	//	@FindBy(xpath ="//input[@name='btnI']")
//	//	WebElement ImFeelingLuckyButton;
//
//	By SearchTextBox = By.xpath("//input[contains(@name,'q')]");
//	By Searchbutton = By.xpath("//div[@class='FPdoLc*']//input[@name='btnK']");
//	//By Searchbutton = By.xpath("//input[@name='btnK']");
//	By ImFeelingLuckyButton = By.xpath("//input[@name='btnI' and @type='submit']");
//	//////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//	public void SearchTextBoxDisplay() {
//
//		//driver.findElement(SearchTextBox).click();
//		//return SearchTextBox.isDisplayed();
//		Helper.highLighterMethod(driver,driver.findElement(SearchTextBox)) ;
//		driver.findElement(SearchTextBox).clear();
//		
//		//Helper.highLighterMethod(driver,SearchTextBox );
//		//SearchTextBox.clear();
//		System.out.println("Search Text Box Present is : " + (driver.findElement(SearchTextBox)).isDisplayed() );
//		
//		if ( driver.findElement(By.xpath("//a[contains(text(),'Gmail')]")).isDisplayed() ) {
//			System.out.println( driver.findElement(By.xpath("//a[contains(text(),'Gmail')]")).getText() );
//			System.out.println("Gmail Hyperlink is Present");
//		} else {
//			System.out.println("Gmail Hyperlink is NOT Present");
//		}
//	}
//
//	public void SearchButtonDisplay() {
//		if (driver.findElement(Searchbutton).isDisplayed() ) {
//			System.out.println("Search Button is displayed in Google HomePage");
//		} else {
//			System.out.println("Search Button is NOT displayed in Google HomePage");
//		}
//	}
//	
//	public void ImFeelingLuckyButtonDisplay() {
//		if ( driver.findElement(ImFeelingLuckyButton).isDisplayed() )  {
//			System.out.println("I'm Feeling Lucky Button is displayed in Google HomePage");
//		} else {
//			System.out.println("I'm Feeling Lucky Button is NOT displayed in Google HomePage");
//		}
//	}
//}