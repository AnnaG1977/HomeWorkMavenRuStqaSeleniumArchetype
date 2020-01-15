package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageHeader extends Page {

    @FindBy(className = "page-header__heading")
    WebElement pageHeaderHeading;

    @FindBy(className = "mc-avatar-image")
   WebElement avatarImage;

    public PageHeader(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(avatarImage,30);
    }
    public boolean verifyIfAvatarImageIsDisplayed(){
        return avatarImage.isDisplayed();
    }
}
