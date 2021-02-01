package com.UP.Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt"},
        features ="src/test/resources/Features",
        glue="com/UP/StepDefinetion",
        dryRun =false,
        tags="@login"
       // publish=true
)
public class cukeRunner {
}
