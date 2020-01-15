package ru.stqa.selenium;

import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ru.stqa.selenium.pages.HomePage;
import ru.stqa.selenium.pages.LoginPageHelper;
import ru.stqa.selenium.pages.PageHeader;

public class SampleTestNgTest extends TestNgTestBase {

  private HomePage homepage;
  LoginPageHelper loginPage;
  PageHeader pageHeader;

  @BeforeMethod
  public void initPageObjects() {
    homepage = PageFactory.initElements(driver, HomePage.class);
    loginPage = PageFactory.initElements(driver,LoginPageHelper.class);
    pageHeader = PageFactory.initElements(driver, PageHeader.class);
  }

  @Test
  public void testHomePageHasAHeader() {
    driver.get(baseUrl);
    Assert.assertFalse("".equals(homepage.header.getText()));
  }
  @Test
  public  void logInToDropboxPositive(){
    driver.get(baseUrl);
    loginPage.waitUntilPageIsLoaded();
    loginPage.clickLogInButton();
    loginPage.waitUntilPageIsLoaded();
    loginPage.enterLogin(LOGIN);
    loginPage.enterPassword(PASSWORD);
    loginPage.clickSigInButton();
    pageHeader.waitUntilPageIsLoaded();
    Assert.assertTrue(pageHeader.verifyIfAvatarImageIsDisplayed());
  }
}
