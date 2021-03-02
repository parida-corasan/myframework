package com.UP.pages;

import com.UP.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ebayPage {

    public ebayPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

     @FindBy (id = "gh-ac")
public WebElement ebaySearchBox;

    @FindBy(xpath = "(//h3[@class='s-item__title s-item__title--has-tags'])[2]")
    public WebElement secondProduct;



    @FindBy(xpath ="(//div[@class='u-cb  ']//span//a)[1]" )
    public WebElement addToCard;




}
