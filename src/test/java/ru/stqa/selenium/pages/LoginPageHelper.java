package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageHelper extends Page {

    @FindBy(id = "sign-up-in")
    WebElement logInButton;
    @FindBy(name = "login_email")
    WebElement login_emailField;
    @FindBy(name = "login_password")
    WebElement passwordField;

    @FindBy(className = "signin-text")
    WebElement signInButton;

    public LoginPageHelper(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(logInButton, 50);
    }

    public void clickLogInButton(){
        waitUntilElementIsClickable(logInButton,60);
        logInButton.click();
    }

    public void enterLogin(String login) {
        enterValueToTheField(login_emailField,login);
    }

    public void enterPassword(String password) {
        enterValueToTheField(passwordField,password);
    }
    public void clickSigInButton(){
        waitUntilElementIsClickable(signInButton,10);
        signInButton.click();
    }
}
