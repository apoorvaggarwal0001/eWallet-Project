package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
//@CucumberOptions(features="Feature",glue= {"StepDefinition"}, tags= {"@invalidlogin"})
//@CucumberOptions(features="Feature/datatabledemo.feature",glue= {"StepDefinition"}, plugin= {"pretty","html:target/cucumber-htmlrepo"}, monochrome=true)
//@CucumberOptions(features="Feature/scenariooutlinedemo.feature",glue= {"StepDefinition"})
//@CucumberOptions(features="Feature/backgrounddemo.feature",glue= {"StepDefinition"}, plugin= {"pretty","html:target/cucumber-htmlrepo"}, monochrome=true)
@CucumberOptions(features="Feature/transfermoney.feature",glue= {"StepDefinition"}, plugin= {"pretty"}, monochrome=true)
public class TestRunner {
	
}
