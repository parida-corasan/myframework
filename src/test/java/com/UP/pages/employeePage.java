package com.UP.pages;

import com.UP.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class employeePage {
  
  public employeePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "")
  public WebElement sth1;



    @FindBy()
    public WebElement  sth2;

// from my branch
    
  
  
}
