package stepDefinition;

import Base.SeleniumBaseClass;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends SeleniumBaseClass{
	
	@Before
	public void CucumberBefore(Scenario scenario) {
		System.out.println("Cucumber-Before");
		//cucumberUtil.PreRequisites(scenario);
	}

	@After
	public void CucumberAfter(Scenario scenario) {
		
	}
}
