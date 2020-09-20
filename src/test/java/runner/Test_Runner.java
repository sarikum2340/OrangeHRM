package runner;



import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features= {"src/test/resources/Features/AssignLeavesFeature.feature"}, glue= {"stepDefinitions"},
dryRun=false,
monochrome=true,
strict=true,
tags="@assignLeaves",
plugin = {"html:Test_Report/testoutput.html","junit:Test_Report/testoutput.xml","json:Test_Report/testoutput.json"})

public class Test_Runner {

}
