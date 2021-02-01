package com.UP.pages;

import com.UP.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

    public loginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

  @FindBy(xpath="//input[@id='login']")
    public WebElement eamilBox;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;


    @FindBy(xpath="//p")
    public WebElement erorMessage;




}
