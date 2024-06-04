package com.spslog.bdd.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber.html","summary"},
        snippets = CAMELCASE,
        tags = "@regression",
        glue = {"com.spslog.bdd.hook", "com.spslog.bdd.stepdefinitions", "com.spslog.bdd.types"},
        features = {"src/test/resources/com/spslog/bdd/features"}
)
public class JUnitRunnerTest {
}
