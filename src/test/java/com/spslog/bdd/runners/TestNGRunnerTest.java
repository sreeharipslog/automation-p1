package com.spslog.bdd.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

import static io.cucumber.testng.CucumberOptions.SnippetType.CAMELCASE;

@CucumberOptions(
        plugin = {
                //"pretty",
                "html:target/cucumber/automation-report.html",
                "summary",
                "progress"
        },
        snippets = CAMELCASE,
        tags = "@regression",
        glue = {"com.spslog.bdd"},
        features = {"src/test/resources/com/spslog/bdd/features"}
)
public class TestNGRunnerTest extends AbstractTestNGCucumberTests {

    // Override the Scenarios method from AbstractTestNGCucumberTests for parallel execution.
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
