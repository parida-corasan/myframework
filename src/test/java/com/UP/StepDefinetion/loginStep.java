package com.UP.StepDefinetion;

import com.UP.Utilities.Driver;
import com.UP.Utilities.configurationReader;
import com.UP.pages.loginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class loginStep {
    loginPage loginpage = new loginPage();

    @Given("user on login page")
    public void user_on_login_page() {

        Driver.getDriver().get(configurationReader.getProperty("UploginPage"));

    }


    @When("user enter correct email and password as posmanager")
    public void user_enter_correct_credential_as_posmanager() {
        loginpage.eamilBox.sendKeys(configurationReader.getProperty("posEmail"));
        Driver.getDriver().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        loginpage.passwordBox.sendKeys(configurationReader.getProperty("posPassword"));
        Driver.getDriver().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        loginpage.loginButton.click();
    }



    @Then("user should see dashboard")
    public void user_should_see_dashboard() {
        String expectTitle="Odoo";
        String ActualTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(expectTitle,ActualTitle);

    }


    @When("user enter incorrect email and password as posmanager")
    public void user_enter_incorrect_credential_as_posmanager() {
        loginpage.eamilBox.sendKeys("kikiki");
        Driver.getDriver().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        loginpage.passwordBox.sendKeys("jijijiji");
        Driver.getDriver().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        loginpage.loginButton.click();

    }


    @Then("user should see error message")
    public void user_should_see_error_message() {
        String Errormessage="Wrong login/password";
        String actualmessage=loginpage.erorMessage.getText();

        Assert.assertEquals(Errormessage,actualmessage);
    }


    @When("user enter correct email and password as eventmanager")
    public void userEnterCorrectEmailAndPasswordAsEventmanager() {
        loginpage.eamilBox.sendKeys(configurationReader.getProperty("eventEmail"));
        Driver.getDriver().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        loginpage.passwordBox.sendKeys(configurationReader.getProperty("eventPassword"));
        Driver.getDriver().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        loginpage.loginButton.click();
    }
    @Then("eventmanager should see dashboard")
    public void eventmanagerShouldSeeDashboard() {
        String expectTitle="Odoo";
        String ActualTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(expectTitle,ActualTitle);
    }


    @When("user enter incorrect email and password aseventmanager")
    public void userEnterIncorrectEmailAndPasswordAseventmanager() {
        loginpage.eamilBox.sendKeys("kikiki");
        Driver.getDriver().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        loginpage.passwordBox.sendKeys("jijijiji");
        Driver.getDriver().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        loginpage.loginButton.click();
    }


    @Then("eventmanager should see error message")
    public void eventmanagerShouldSeeErrorMessage() {
        String Errormessage="Wrong login/password";
        String actualmessage=loginpage.erorMessage.getText();

        Assert.assertEquals(Errormessage,actualmessage);
    }




    @When("user enter correct email and password as salesmanager")
    public void userEnterCorrectEmailAndPasswordAsSalesmanager() {

        loginpage.eamilBox.sendKeys(configurationReader.getProperty("saleEmail"));
        Driver.getDriver().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        loginpage.passwordBox.sendKeys(configurationReader.getProperty("salePassword"));
        Driver.getDriver().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        loginpage.loginButton.click();
    }
    @Then("salesmanager should see dashboard")
    public void salesmanagerShouldSeeDashboard() {
        String expectTitle="Odoo";
        String ActualTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(expectTitle,ActualTitle);
    }

    @When("user enter incorrect email and password salesmanager")
    public void userEnterIncorrectEmailAndPasswordSalesmanager() {
        loginpage.eamilBox.sendKeys("kikiki");
        Driver.getDriver().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        loginpage.passwordBox.sendKeys("jijijiji");
        Driver.getDriver().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        loginpage.loginButton.click();
    }
    @Then("salesmanager should see error message")
    public void salesmanagerShouldSeeErrorMessage() {
        String Errormessage="Wrong login/password";
        String actualmessage=loginpage.erorMessage.getText();

        Assert.assertEquals(Errormessage,actualmessage);
    }















}


