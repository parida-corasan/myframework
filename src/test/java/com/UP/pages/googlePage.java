package com.UP.pages;

import com.UP.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class googlePage {

  public googlePage(){
      PageFactory.initElements(Driver.getDriver(),this);
  }

    @FindBy(name = "q")
   public  WebElement  googleSearchBox ;

  @FindBy(xpath = "//h2//span")
    public WebElement pageTitle;







}
