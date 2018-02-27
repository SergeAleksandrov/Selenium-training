package myFirstSeleniumProject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CorrectPage {
  WebDriver driver;
  WebDriverWait wait;
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
    m = driver.findElement(By.xpath("//div[@id='box-campaign-products']/div/div/div/a")).getAttribute("href");
    driver.findElement(By.xpath("//div[@id='box-campaign-products']/div/div/div/a")).click();
    driver.findElement(By.xpath("//div[@id='view-full-page']//a[.='View full page ']")).click();
    l = driver.getCurrentUrl();
    Assert.assertEquals(m, l);

    // Product's name validation
    driver.navigate().to("http://localhost/litecart/en/");
    m = driver.findElement(By.xpath("//div/div[1]/div[2]/main/div[3]/div[1]/div/div/div/div/a/div[2]/div[1]")).getAttribute("innerHTML");
    driver.findElement(By.xpath("//div[@id='box-campaign-products']/div/div/div/a")).click();
    driver.findElement(By.xpath("//div[@id='view-full-page']//a[.='View full page ']")).click();
    l = driver.findElement(By.cssSelector("h1.title")).getAttribute("innerHTML");
    Assert.assertEquals(m, l);

    // Price's validation 1
    driver.navigate().to("http://localhost/litecart/en/");
    m = driver.findElement(By.xpath("//div/div[1]/div[2]/main/div[3]/div[1]/div/div/div/div/a/div[2]/div[3]/strong")).getAttribute("innerHTML");
    driver.findElement(By.xpath("//div[@id='box-campaign-products']/div/div/div/a")).click();
    driver.findElement(By.xpath("//div[@id='view-full-page']//a[.='View full page ']")).click();
    l = driver.findElement(By.cssSelector("strong.campaign-price")).getAttribute("innerHTML");
    Assert.assertEquals(m, l);

    // Price's validation 2
    driver.navigate().to("http://localhost/litecart/en/");
    m = driver.findElement(By.xpath("//div[@id='box-campaign-products']//s[.='$22']")).getAttribute("innerHTML");
    driver.findElement(By.xpath("//div[@id='box-campaign-products']/div/div/div/a")).click();
    driver.findElement(By.xpath("//div[@id='view-full-page']//a[.='View full page ']")).click();
    l = driver.findElement(By.xpath("//div[@id='box-product']//del[.='$22']")).getAttribute("innerHTML");
    Assert.assertEquals(m, l);

    // CSS sets are correct
    driver.navigate().to("http://localhost/litecart/en/");
    driver.findElement(By.xpath("//div/div[1]/div[2]/main/div[3]/div[1]/div/div/div/div/a/div[2]/div[3]/strong")).getCssValue("color");
    m = driver.findElement(By.xpath("//div/div[1]/div[2]/main/div[3]/div[1]/div/div/div/div/a/div[2]/div[3]/strong")).getCssValue("font-size");
    driver.findElement(By.xpath("//div[@id='box-campaign-products']/div/div/div/a")).click();
    driver.findElement(By.xpath("//div[@id='view-full-page']//a[.='View full page ']")).click();
    driver.findElement(By.cssSelector("strong.campaign-price")).getCssValue("color");
    l = driver.findElement(By.cssSelector("strong.campaign-price")).getCssValue("font-size");
    //Assert.assertEquals(m,l);
    System.out.println(m);
    System.out.println(l);
  }

  @After
  public void finish() {
    driver.quit();
    driver = null;
  }
}
