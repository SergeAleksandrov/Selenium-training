package myFirstSeleniumProject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginSection {

  WebDriver wd;
  WebDriverWait wait;

  @Before
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wait = new WebDriverWait(wd, 10);
  }

  @Test
  public void sectionLogin (){
    wd.get("http://localhost/litecart/admin/login.php");
    wd.findElement(By.name("username")).sendKeys("admin");
    wd.findElement(By.name("password")).sendKeys("admin");
    wd.findElement(By.name("remember_me")).click();
    wd.findElement(By.xpath("//div[@class='footer']//button[.='Login']")).click();
    wait = new WebDriverWait(wd, 60);
  }

  @After
  public void tearDown() {
    wd.quit();
    wd = null;
  }
}


