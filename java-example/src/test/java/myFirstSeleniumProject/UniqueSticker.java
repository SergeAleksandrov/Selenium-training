package myFirstSeleniumProject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class UniqueSticker {
  WebDriver driver;

  @Before
  public void start(){
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  }

  @Test
  public void stickerUnique(){
    driver.navigate().to("http://localhost/litecart/en/");
    Assert.assertTrue(areElementsPresent(By.xpath("//div/div[1]/div[2]/main/div[3]/div[1]/div/div/div/div/a/div[1]/div")));
  }

  boolean isElementPresent (By locator){
    try{
      driver.findElement(locator);
      return true;
    }
    catch (NoSuchElementException ex){
      return false;
    }
  }
  boolean areElementsPresent(By locator) {
    return driver.findElements(locator).size() > 0;
  }
}
