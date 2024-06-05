package com.spslog.bdd.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber/automation-report.html", "summary"},
        snippets = CAMELCASE,
        tags = "@regression",
        glue = {"com.spslog.bdd"},
        features = {"src/test/resources/com/spslog/bdd/features"}
)
public class JUnitRunnerTest {
}
