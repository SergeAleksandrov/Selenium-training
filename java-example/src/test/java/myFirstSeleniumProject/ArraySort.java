package myFirstSeleniumProject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ArraySort {
  WebDriver driver;
  String l;

  @Before
  public void start(){
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  }

  @Test
  public void comparison(){
    //login section
    driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
    driver.findElement(By.cssSelector("input.form-control[name=username]")).sendKeys("admin");
    driver.findElement(By.cssSelector("input.form-control[name=password]")).sendKeys("admin");
    driver.findElement(By.cssSelector("button.btn.btn-default[name=login]")).click();

    // the main part
    driver.findElement(By.xpath("//main[@id='main']//a[.='Afghanistan']")).getText();
    driver.findElement(By.xpath("//main[@id='main']//a[.='Åland Islands']")).getText();
    driver.findElement(By.xpath("//main[@id='main']//a[.='Albania']")).getText();
    System.out.println(l);
  }


}


