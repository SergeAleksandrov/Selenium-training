package myFirstSeleniumProject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.Collator;
import java.util.concurrent.TimeUnit;

public class ArraySort {
  WebDriver driver;
  String k, l, m;
  int j;

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
    k = driver.findElement(By.xpath("//div/main/form/table/tbody/tr[1]/td[5]/a")).getText();
    l = driver.findElement(By.xpath("//div/main/form/table/tbody/tr[2]/td[5]/a")).getText();
    m = driver.findElement(By.xpath("//div/main/form/table/tbody/tr[3]/td[5]/a")).getText();


    String Str = new String("Добро пожаловать на ProgLang.su");  //  Замена элемента String
    System.out.println("Итого: " + Str.replace('Д', 'Б'));


    Collator myCollator = Collator.getInstance();
    j = myCollator.compare(k, m);
    if (j < 0)
    System.out.println(k + " greater than " + m);
    else System.out.println(m + " less than " + k);
  }
}


