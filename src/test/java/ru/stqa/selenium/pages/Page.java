package ru.stqa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class Page {

  protected WebDriver driver;





  /*
   * Constructor injecting the WebDriver interface
   * 
   * @param webDriver
   */
  public Page(WebDriver driver) {
    this.driver = driver;
  }

  public String getTitle() {
    return driver.getTitle();
  }

  public void enterValueToTheField(WebElement field, String value) {

    field.click();
    field.clear();
    field.sendKeys(value);
  }
  public void waitUntilElementIsClickable(WebElement element, int time) {
    try {
      new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeClickable(element));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void waitUntilElementIsVisible(WebElement element, int time) {
    try {
      new WebDriverWait(driver,time).until(ExpectedConditions.visibilityOf(element));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public abstract void waitUntilPageIsLoaded();

}
