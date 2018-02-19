package myFirstSeleniumProject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class AdminPanel {

  WebDriver driver;
  String l;
  String k, n, m;
  WebDriverWait wait;

  @Before

  public void start(){
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, 30);
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
    System.out.println(l = driver.getTitle());
    driver.findElement(By.xpath("//li[@id='doc-template']//span[.='Template']")).click();
    driver.findElement(By.xpath("//li[@id='doc-logotype']//span[.='Logotype']")).click();
    System.out.println(l = driver.getTitle());
    Assert.assertEquals("Logotype | My Store", l);
    Assert.assertTrue(isElementPresent(By.xpath("//div/main/h1")));
//    Assert.assertTrue(isElementPresent(By.cssSelector("button.btn.btn-default[name=save]")));
//    driver.findElement(By.cssSelector("button.btn.btn-default[name=save]")).getText();
//    driver.findElement(By.cssSelector("button.btn.btn-default[name=save]")).isEnabled();
//    driver.findElement(By.cssSelector("button.btn.btn-default[name=save]")).getSize();
//    Point screen = driver.findElement(By.cssSelector("button.btn.btn-default[name=save]")).getLocation();
//    k = driver.findElement(By.cssSelector("button.btn.btn-default[name=save]")).getCssValue("background");
//    n = driver.findElement(By.cssSelector("button.btn.btn-default[name=save]")).getAttribute("scrollWidth");

    System.out.println(k);
    System.out.println(n);
    //System.out.println(screen);
  }

  boolean isElementPresent(By locator) {
    try {
      wait.until((WebDriver d) -> d.findElement(locator));  // implicit wait
      //driver.findElement(locator);  // explicit wait
      return true;
    } catch (TimeoutException ex) {
      return false;
    }
  }
}
