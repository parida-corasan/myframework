package com.UP.Test;

import com.UP.Utilities.Driver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ebayTest {

@Test
    public  void ebay() throws InterruptedException {
        Driver.getDriver().get("https://www.ebay.com/");
        Thread.sleep(3000);

    WebElement searchBox=Driver.getDriver().findElement(By.id("gh-ac"));
        Actions action=new Actions(Driver.getDriver());
        action.moveToElement(searchBox).build().perform();
    Thread.sleep(3000);

    WebElement list=Driver.getDriver().findElement(By.xpath("//span[@class='ui-helper-hidden-accessible']"));
   action.moveToElement(list).build().perform();
    Thread.sleep(3000);

    Action search = action.sendKeys(searchBox,"iphone").
            keyDown(list,Keys.SHIFT)
            .keyUp(list,Keys.SHIFT).build();

    search.perform();




    Thread.sleep(3000);






   Driver.closeDriver();

    }



}
