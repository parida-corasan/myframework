package com.UP.Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features ="@target/rerun.txt",
        glue="com/UP/StepDefinetion"
   // Rerun is build in build in cucumber
   //    allows us to run failed tests again

)
public class FailedTestRunner {

}
