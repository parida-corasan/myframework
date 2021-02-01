package com.UP.pages;

import com.UP.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class inboxPage {


    public inboxPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath="//input[@class='o_searchview_input']")
    public WebElement searchBox;


    @FindBy(xpath = "//div[@class='o_thread_title']")
    public WebElement afterSearchMessage;




}
