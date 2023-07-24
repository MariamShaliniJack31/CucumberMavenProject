package StepDefinition;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks{
	
	@Before
	public void CucumberBefore(Scenario scenario) {
		System.out.println("Cucumber-Before.......... Before Scenario");
		//cucumberUtil.PreRequisites(scenario);
	}

	@After
	public void CucumberAfter(Scenario scenario) {
		System.out.println("Cucumber-After.............After Sceanrio");
	}
}
