package com.UP.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.*;

import java.net.MalformedURLException;
import java.net.URL;
public class Driver {

    private static WebDriver driver;
    private Driver(){
    }

    public static WebDriver getDriver(){
        if(driver==null){
        String browser=configurationReader.getProperty("browser");

        switch (browser){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.chromedriver().setup();
                driver=new FirefoxDriver();
                break;
            case "chrome-headless":
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver(new ChromeOptions().setHeadless(true));
                break;
            case "firefox-headless":
                WebDriverManager.chromedriver().setup();
                driver=new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                break;
            default:
                throw new RuntimeException("Wrong browser name: "+browser);
        }
        }



        return driver;
    }




    public static void closeDriver(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }




}
