package com.UP.Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "html:target/cucumber_report_inbox.html",
        features = "src/test/resources/Features",
        glue="com/UP/StepDefinetion",
        dryRun = false,
        tags="@inbox"
)

public class inboxRunner {
}
