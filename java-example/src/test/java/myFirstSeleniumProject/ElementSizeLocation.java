package myFirstSeleniumProject;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.interactions.internal.Locatable;


import java.util.concurrent.TimeUnit;

public class ElementSizeLocation {
  WebDriver driver;
  String l;

  @Before
  public void start(){
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  }

  @Test
  public void size (){
    driver.navigate().to("http://localhost/litecart/en/");
    Dimension screen = driver.findElement(By.xpath("//div[@class='hidden-xs col-sm-fourths col-md-fifths contact']/p")).getSize();
    System.out.println(screen);
  }

  @Test
  public void location (){
    driver.navigate().to("http://localhost/litecart/en/");
    Point screen = driver.findElement(By.xpath("//div[@class='hidden-xs col-sm-fourths col-md-fifths contact']/p")).getLocation();
    System.out.println(screen);
  }
}
