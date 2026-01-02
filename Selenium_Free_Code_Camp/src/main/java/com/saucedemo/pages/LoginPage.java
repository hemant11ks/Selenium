package com.saucedemo.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    // This fields are only access in this file only as this is private
    // These are locators, not actual web elements
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");;
    private By loginButton = By.id("login-button");
    private By errorMessage = By.xpath("#login_button_container h3");

    // There are 4 types of methods:
    // Getter, Setters, Transition & Convenience Methods
    // Getter method - Return the value of the attribute
    // Setter method - Received the param and assign to attribute
    // Transition method - (Imp when out application changes it to different page)
    // Convenience method - Created when combine to one more method

    public void setUsername(String username){
        set(usernameField, username);
    }

    public void setPassword(String password){
        set(passwordField, password);
    }
    // Need to create Transition method
    // We are not using void instead we are using the ProductPage because the Login page transit to Product Page.
    public ProductsPage clickLoginButton(){
        click(loginButton);
        return new ProductsPage();
    }
    // Need to create convenience method
    public  ProductsPage logIntoApplication(String username, String password){
        setUsername(username);
        setPassword(password);
        return clickLoginButton();
    }

    // Get method to get the error message
    public String getErrorMessage(){
        return find(errorMessage).getText();
    }

}
