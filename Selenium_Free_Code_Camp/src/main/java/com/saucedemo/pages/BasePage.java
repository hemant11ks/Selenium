package com.saucedemo.pages;

// With Inheritance the BasePage only has one role that is to be a Parent of PO Classes.
// In Java Parent class is also known as super class.
// The subclass inherits from the Super class.
// Here subclass will be treated as a child class.
// Base class should contain the class members that are necessary in child classes.

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

 // To make our class interact with browser
    public static WebDriver driver;

    public  void setDriver(WebDriver driver){
        BasePage.driver = driver;
    }

    protected WebElement find(By locator){
        return driver.findElement(locator);
    }

    protected void set(By locator, String text){
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    protected void click(By locator){
        find(locator).click();
    }
}
