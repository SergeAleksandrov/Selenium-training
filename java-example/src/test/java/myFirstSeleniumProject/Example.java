package myFirstSeleniumProject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Example {
  WebDriver driver;
  String l;

  @Before
  public void start(){
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  }

  @Test
  public void task(){
    driver.navigate().to("http://localhost/litecart/admin/login.php");
    driver.findElement(By.name("remember_me")).click();
    System.out.println(driver.findElement(By.name("remember_me")).isSelected());
  }

  @Test
  public void task2(){
    driver.navigate().to("http://localhost/litecart");
    System.out.println(driver.findElement(By.cssSelector("a.logotype")).isDisplayed());
    System.out.println(driver.findElement(By.cssSelector("a.logotype")).isEnabled());
  }

  @After
  public void finish(){
    driver.quit();
    driver = null;
  }
}
