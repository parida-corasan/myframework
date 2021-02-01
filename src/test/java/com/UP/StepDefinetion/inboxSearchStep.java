package com.UP.StepDefinetion;

import com.UP.Utilities.Driver;
import com.UP.Utilities.configurationReader;
import com.UP.pages.inboxPage;
import com.UP.pages.loginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class inboxSearchStep {
    inboxPage inboxp=new inboxPage();
    loginPage loginpage=new loginPage();

    @Given("user on #inbox page")
    public void user_on_inbox_page() {
        Driver.getDriver().get(configurationReader.getProperty("UploginPage"));
        loginpage.eamilBox.sendKeys(configurationReader.getProperty("posEmail"));
        Driver.getDriver().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        loginpage.passwordBox.sendKeys(configurationReader.getProperty("posPassword"));
        Driver.getDriver().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        loginpage.loginButton.click();
    }




    @When("user enter {string} in search box")
    public void user_enter_in_search_box(String str) {
       inboxp.searchBox.sendKeys(str + Keys.ENTER);
       Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }



    @Then("use should see message on dashboard")
    public void use_should_see_message_on_dashboard() {
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),5);
        wait.until(ExpectedConditions.textToBePresentInElement(inboxp.afterSearchMessage,"No matches found"));

        Assert.assertEquals(inboxp.afterSearchMessage.getText(),"No matches found");


    }

}
