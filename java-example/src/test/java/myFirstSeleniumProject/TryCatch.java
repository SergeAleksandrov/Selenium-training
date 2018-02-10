package myFirstSeleniumProject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TryCatch {

  WebDriver sss;
  WebDriverWait wait;

  @Before
  public void setUp() throws Exception {
    sss = new ChromeDriver();
    sss.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

  @Test
  public void odessaMama() {
    sss.get("https://mail.google.com/mail/u/2/#inbox");
    Assert.assertFalse(isElementPresent(By.cssSelector("h1#headingText1")));
  }

  @After
  public void tearDown() {
    sss.quit();
  }

  boolean isElementPresent(By locator) {
    try {
      sss.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }


}
