package com.UP.StepDefinetion;

import com.UP.Utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class hooks {
//cukes runner Automatically run this class

    @Before(order=1)
    public void setUpScenario(){

        System.out.println(" @Before(order=1)===>Scenario set up");
    }

    @Before (order = 2)
    public void setUpDATAbaseConnection(){

        System.out.println("@Before (order = 2)===>Set up data base");
    }




    @After
    public void ScreenshotIFfail(Scenario scenario){
        System.out.println("scenario.getName() = " + scenario.getName());
        System.out.println("scenario.getSourceTagNames() = " + scenario.getSourceTagNames());
        System.out.println("scenario.isFailed() = " + scenario.isFailed());



    byte[] screenshot =
            ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

    scenario.attach(screenshot, "image/png", scenario.getName());


    }




@After(order = 2)
    public void tearDown(){
        Driver.closeDriver();
        System.out.println("closeDriver");
    }






}
