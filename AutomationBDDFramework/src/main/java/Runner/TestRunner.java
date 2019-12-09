package Runner;
import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "F:\\eclipsesetup\\AutomationBDDFramework\\src\\main\\java\\Features\\cartAndCheckout.feature", //the path of the feature files
		glue={"stepDefinition"}, //the path of the step definition files
		//plugin= {"pretty","html:test-outout", "json:json_output/cucumber.json", "junit:junit_xml/cucumber.xml"}, //to generate different types of reporting
		plugin = {"pretty:STDOUT","html:F:\\eclipsesetup\\AutomationBDDFramework\\Reports\\cucumber-pretty",
					    "json:F:\\eclipsesetup\\AutomationBDDFramework\\Reports\\cucumber-json\\cucumber.json",
					    "com.cucumber.listener.ExtentCucumberFormatter:F:\\eclipsesetup\\AutomationBDDFramework\\Reports\\cucumber-extent\\report.html"
					   },

		
		monochrome = true, //display the console output in a proper readable format
		strict = true, //it will check if any step is not defined in step definition file
		dryRun = false //to check the mapping is proper between feature file and step def file
		//tags = {"~@SmokeTest" , "~@RegressionTest", "~@End2End"}			
		)

public class TestRunner {
	
	@AfterClass
	 public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File("F:\\eclipsesetup\\AutomationBDDFramework\\Config\\extent-config.xml"));
	 }
	

}
