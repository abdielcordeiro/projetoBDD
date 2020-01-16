package br.com.rsinet.HUB_BDD.cucumberTest;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(

 features = "classpath:feature",
 glue="br.com.rsinet.HUB_BDD.stepDefinition",
 plugin = {"pretty"},
 snippets = SnippetType.CAMELCASE,
 monochrome = true
 )

public class TestRunner {

}
