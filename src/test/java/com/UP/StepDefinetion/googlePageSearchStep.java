package com.UP.StepDefinetion;

import com.UP.Utilities.Driver;
import com.UP.pages.googlePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class googlePageSearchStep {
      googlePage hoPa=new googlePage();

    @Given("user on home page")
    public void user_on_home_page() {
        Driver.getDriver().get("https://www.google.com/");
    }



    @And("user search {string}")
    public void userSearch(String str) {
        hoPa.googleSearchBox.sendKeys(str+ Keys.ENTER);
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        if(str.equals("shah rukh khan")){
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}
        else{
            Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }

    }


    @Then("User should see {string} in the right side of page")
    public void userShouldSeeInTheRightSideOfPage(String str) {
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals(str,hoPa.pageTitle.getText());
    }
}
