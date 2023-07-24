package Utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Base.DriverScript;

public class Helper extends DriverScript  {

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
	
	public static String getScreenShot() {

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

		File destFile = null;
		try {

			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String filePath = System.getProperty("user.dir") + "/screenshots/" + "_"
					+ formater.format(calendar.getTime()) + ".png";
			destFile = new File(filePath);
			FileUtils.copyFile(scrFile, destFile);

		} catch (Exception t) {
			ErrorUtil.addVerificationFailure(t);
			//LogFile.APPLICATION_LOGS.error("Error in taking screenshot" + t.getMessage());
		}
		return destFile.getAbsolutePath().toString();

	}

}