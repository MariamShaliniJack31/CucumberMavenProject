package Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Base.DriverScript;

public class Helper extends DriverScript {

	public static void highLighterMethod(WebDriver driver, WebElement ele) {
		try {
			String originalStyle = ele.getAttribute("style");
			JavascriptExecutor js = (JavascriptExecutor) driver;

			for (int i = 0; i < 2; i++) {
				js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
						ele);
				Thread.sleep(150);
				js.executeScript("arguments[0].setAttribute('style', '" + originalStyle + "');", ele);
				Thread.sleep(150);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}