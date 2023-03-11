package cucumber.options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src\\test\\java\\feature" }, plugin = {
		"json:target/jsonReports/cucumber_report.json" }, glue = {
				"stepdefinition" }, dryRun = false, monochrome = true, publish = true)
public class TestRunner {

}
