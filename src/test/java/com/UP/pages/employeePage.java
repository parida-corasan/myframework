package com.UP.pages;public class employeePage {
  
  public employeePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "")
  public WebElement sth1;



    @FindBy()
    public WebElement  sth2;


    @FindBy()
    public WebElement sth3;
  
  
}
