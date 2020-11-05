package io.cucumber.skeleton;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
(
	plugin = {"html:target/cucumber-html-report"},
	glue= {"io.cucumber.skeleton"},
	features= {"src/test/resources/FeatureFiles"},
	monochrome=true
)
public class RunCucumberTest
{
	
}
