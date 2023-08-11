package StepDefinition;

//import cucumber.api.Scenario;
//import cucumber.api.java.After;
//import cucumber.api.java.Before;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import java.io.*;
import java.sql.Time;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Base.DriverScript;

public class Hooks extends DriverScript{

	@Before
	public void CucumberBefore(Scenario scenario) {
		System.out.println("Cucumber-Before.......... Before Scenario");
		//cucumberUtil.PreRequisites(scenario);
	}

	@After
	public void CucumberAfter(Scenario scenario) {

		String ScreenshotName = scenario.getName().replaceAll(" ", "_");
		System.out.println("ScreenshotName  : " + ScreenshotName);
		//if (scenario.isFailed()) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
		Allure.addAttachment("Simply.....999116 Scenarios", new ByteArrayInputStream(screenshot));
		scenario.attach(screenshot, "image/png", ScreenshotName);
		//}
		

		System.out.println("Cucumber-After.............After Sceanrio");
		driver.quit();
	}
}
