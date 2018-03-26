package myFirstSeleniumProject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import java.lang.Object;
import org.openqa.selenium.JavascriptExecutor;
import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class AlertClass {
  WebDriver driver;
  WebDriverWait wait;
  WebElement element;
  String l, m, j;

  @Before
  public void start() {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    wait = new WebDriverWait(driver, 20);
  }

  @Test

  // Using wait
  public void prostoTak() throws NoAlertPresentException, InterruptedException {
    driver.navigate().to("http://demo.guru99.com/test/delete_customer.php");
    driver.findElement(By.xpath("//input[@type='text']")).sendKeys("11111");
    driver.findElement(By.xpath("//input[@type='submit']")).click();
    Alert alert = wait.until(alertIsPresent());
    l = alert.getText();
    System.out.println(l);
    Thread.sleep(2000);
    alert.dismiss();
    ((JavascriptExecutor)driver).executeScript("window.open()");  // usage of JavaScript in Java
    ((JavascriptExecutor)driver).executeScript("window.open()");  // usage of JavaScript in Java
    driver.getWindowHandles();
  }

    // Without wait

  public void prostoTak2() throws NoAlertPresentException, InterruptedException {
    driver.navigate().to("http://demo.guru99.com/test/delete_customer.php");
    driver.findElement(By.xpath("//input[@type='text']")).sendKeys("11111");
    driver.findElement(By.xpath("//input[@type='submit']")).click();
    Alert alert = driver.switchTo().alert();
    l = alert.getText();
    System.out.println(l);
    alert.accept();
    m = driver.switchTo().alert().getText();
    System.out.println(m);
    Thread.sleep(5000);
    alert.dismiss();

  }




}

