package com.UP.StepDefinetion;

import com.UP.Utilities.Driver;
import com.UP.Utilities.util;
import com.UP.pages.ebayPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.List;

public class ebaySearch {

    ebayPage ebay=new ebayPage();

    @Given("user on Ebay homepage")
    public void userOnEbayHomepage() {
        Driver.getDriver().get("https://www.ebay.com/");
        util.wait(2000);
    }




    @When("user Enter {string} and click {int}nd product on list")
    public void userEnterAndClickNdProductOnList(String product, int nth) {
        ebay.ebaySearchBox.sendKeys(product);
        util.wait(6000);
        List<WebElement>  suggestions=
                Driver.getDriver().findElements(By.xpath("//a[@class='ghAC_sugg ui-corner-all']"));

        for (WebElement sug:suggestions){
            System.out.println(sug.getText());
        }

        suggestions.get(nth-1).click();
        util.wait(2000);
        System.out.println("Driver.getDriver().getTitle() = " + Driver.getDriver().getTitle());

        ebay.secondProduct.click();
        util.wait(3000);


    }

    @And("click Add to Cart button")
    public void clickButton() {
        WebElement addToCard=Driver.getDriver().findElement(By.xpath("(//div[@class='u-cb  ']//span//a)[1]"))   ;

        util.wait(5000);
        addToCard.click();
        util.wait(3000);

    }

    @Then("user should see the correct price")
    public void userShouldSeeTheCorrectPrice() {
        WebElement priceInfo=Driver.getDriver().findElement(By.xpath("//div[@class='mainPrice']//span[@itemprop='price']"));

        util.wait(3000);
        String ActualPrice=priceInfo.getText();
        String ExpectedPrice="US $";
        Assert.assertTrue(ActualPrice.contains(ExpectedPrice));

        Driver.closeDriver();
    }




    @Test
    public void ebayTest(){
        Driver.getDriver().get("https://www.ebay.com/");
        util.wait(2000);

        ebay.ebaySearchBox.sendKeys("iphone");
        util.wait(6000);
        List<WebElement>  suggestions=
                 Driver.getDriver().findElements(By.xpath("//a[@class='ghAC_sugg ui-corner-all']"));

        for (WebElement sug:suggestions){
            System.out.println(sug.getText());
        }

       suggestions.get(11).click();
        util.wait(2000);
        System.out.println("Driver.getDriver().getTitle() = " + Driver.getDriver().getTitle());

        //h3[@class='s-item__title s-item__title--has-tags'])[2]

    WebElement secondProduct= Driver.getDriver().findElement(By.xpath("(//h3[@class='s-item__title s-item__title--has-tags'])[2]"))  ;
        util.wait(2000);
        secondProduct.click();
        util.wait(3000);

WebElement addToCard=Driver.getDriver().findElement(By.xpath("(//div[@class='u-cb  ']//span//a)[1]"))   ;
     util.wait(5000);
     addToCard.click();
     util.wait(3000);




     WebElement priceInfo=Driver.getDriver().findElement(By.xpath("//div[@class='mainPrice']//span[@itemprop='price']"));

     util.wait(3000);
     String ActualPrice=priceInfo.getText();
     String ExpectedPrice="US $";
        System.out.println("ActualPrice = " + ActualPrice);
        Assert.assertTrue(ActualPrice.contains(ExpectedPrice));

        Driver.closeDriver();
    }






}
