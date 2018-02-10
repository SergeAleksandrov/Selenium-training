package myFirstSeleniumProject;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class GetText {

  WebDriver driver;
  String l, m;

  @Before
  public void start(){
    driver=new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  }

  @Test
  public void text(){
    driver.get("http://localhost/litecart/en/");
    driver.findElement(By.cssSelector("input.form-control[type=email]")).sendKeys("nona@gmail.com");
    driver.findElement(By.cssSelector("input.form-control[type=password]")).sendKeys("12345");
    driver.findElement(By.cssSelector("button.btn.btn-default[type=submit]")).click();
    m=driver.findElement(By.xpath("//div[@id='box-account']//a[.='Edit Account']")).getCssValue("color");
    driver.findElement(By.xpath("//div[@id='box-account']//a[.='Edit Account']")).click();
    l=driver.findElement(By.cssSelector("input.form-control[name=firstname]")).getAttribute("value");
    System.out.println(l);
    System.out.println(m);

  }
}
