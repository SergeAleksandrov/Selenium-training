package myFirstSeleniumProject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class AdminPanel {

  WebDriver driver;

  @Before

  public void start(){
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  }

  @Test

  public void panelAdmin(){
    driver.navigate().to("http://localhost/litecart/admin/login.php");

    // login section
    driver.findElement(By.cssSelector("input.form-control[name=username]")).clear();
    driver.findElement(By.cssSelector("input.form-control[name=username]")).sendKeys("admin");
    driver.findElement(By.cssSelector("input.form-control[name=password]")).clear();
    driver.findElement(By.cssSelector("input.form-control[name=password]")).sendKeys("admin");
    driver.findElement(By.cssSelector("button.btn.btn-default[name=login]")).click();

    // left tag bar
    driver.findElement(By.xpath("//li[@id='app-']//span[.='Appearance']")).click();
    driver.findElement(By.xpath("//li[@id='doc-template']//span[.='Template']")).click();
    driver.findElement(By.xpath("//li[@id='doc-logotype']//span[.='Logotype']")).click();
    Assert.assertTrue(isElementPresent(By.xpath("//div/main/h1")));
  }

  boolean isElementPresent(By locator) {
    try {
      driver.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }
}
