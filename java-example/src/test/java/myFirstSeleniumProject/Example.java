package myFirstSeleniumProject;

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
    driver.get("http://localhost/litecart/en/");
    //System.out.println(driver.findElement(By.xpath("//button[@class='btn btn-default'][@name='login']"))
            //.getAttribute("assignedSlot"));
    driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Hello buddy");
    //System.out.println(driver.findElement(By.xpath("//input[@name='email']")).getAttribute("value"));
    System.out.println(driver.findElement(By.xpath("//input[@name='email']")).getAttribute("value"));
  }
}
