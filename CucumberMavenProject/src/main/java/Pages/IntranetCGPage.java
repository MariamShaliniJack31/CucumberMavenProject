package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.DriverScript;
import Utils.Helper;

public class IntranetCGPage extends DriverScript {
		
//		@FindBy(xpath ="//input[contains(@name,'q')]")
//		WebElement SearchTextBox;
//		@FindBy(xpath ="//input[@name='btnK']")
//		WebElement Searchbutton;
//		@FindBy(xpath ="//input[@name='btnI']")
//		WebElement ImFeelingLuckyButton;

	By EditProfile = By.xpath("//a[contains(text(),'edit profile')]");
	//////////////////////////////////////////////////////////////////////////////////////////////////////////

	public IntranetCGPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	public void EditProfileBoxDisplay() {
//		Helper.highLighterMethod(driver,driver.findElement(EditProfile)) ;
//		driver.findElement(EditProfile).clear();
		
		boolean x = driver.findElement(EditProfile).isDisplayed(); 
		System.out.println("Edit Profile Link is Present is : " +x);
	}
}