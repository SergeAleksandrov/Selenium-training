package myFirstSeleniumProject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Test33 {
  WebDriver driver;
  WebDriverWait wait;
  WebElement element;
  String l, m, j;

  @Before
  public void start() {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    //wait = new WebDriverWait(driver, 30);
  }

  @Test
  public void rightPage() {
    // Page's validation
    driver.navigate().to("http://localhost/litecart/en/");
    //isElementPresent(driver, By.xpath("//div[@id='box-campaign-products']/div/div/div/a"));
    isElementNotPresent(driver, By.xpath("//div[@id='box-campaign-products']/div/div/div/a"));

}
//  // Проверка наличия элементов на странице
//  boolean isElementPresent(WebDriver driver, By locator){
//    return driver.findElements(By.xpath("//div[@id='box-campaign-products']/div/div/div/aaa")).size() > 0;
//  }

  // Проверка отсутствия элементов на странице (без ожидания)
  boolean isElementNotPresent(WebDriver driver, By locator){
    try {
      driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
      return driver.findElements(By.xpath("//div[@id='box-campaign-products']/div/div/div/a")).size() == 0;
    } finally {
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
  }

}

