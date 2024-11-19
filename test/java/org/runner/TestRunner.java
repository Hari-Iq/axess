package org.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features	=	"src/test/resources",
		glue		=	"org.StepDefinitions",
		monochrome	=	true,
		dryRun	=	false,
		tags={"@Test2"})


public class TestRunner {
	
}


