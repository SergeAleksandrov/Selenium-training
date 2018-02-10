package myFirstSeleniumProject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class NewUser {

  WebDriver driver;
  //WebDriverWait wait;

  @Before

  public void start(){
     driver = new ChromeDriver();
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   }

  @Test

  public void registration(){
   driver.get("http://localhost/litecart/en/");
   driver.findElement(By.cssSelector("p.text-center")).click();
   driver.findElement(By.cssSelector("input.form-control[name=firstname]")).sendKeys("Ivan");
   driver.findElement(By.cssSelector("input.form-control[name=lastname]")).sendKeys("Petrov");
   driver.findElement(By.xpath("//div[@id='box-create-account']/form/div[5]/div[1]/select//option[229]")); // country
   driver.findElement(By.cssSelector("div.row div.form-group.col-md-halfs.required input.form-control[type=email]")).sendKeys("nona10@gmail.com");
   driver.findElement(By.cssSelector("div.input-group input.form-control[name=password][required=required]")).sendKeys("12345");
   driver.findElement(By.cssSelector("input.form-control[name=confirmed_password]")).sendKeys("12345");
   driver.findElement(By.cssSelector("button.btn.btn-default[name=create_account]")).click(); //submit creating of the new account
   driver.findElement(By.xpath("//div[@id='box-account']//a[.='Logout']")).click(); // logout
   driver.findElement(By.cssSelector("input.form-control[type=email]")).sendKeys("nona@gmail.com");
   driver.findElement(By.cssSelector("input.form-control[type=password]")).sendKeys("12345");
   driver.findElement(By.cssSelector("button.btn.btn-default[type=submit]")).click();
   driver.findElement(By.xpath("//div/div[1]/div[2]/aside/div/div[2]/div[2]/ul/li[3]/a")).click();  // logout

  }

  @After
  public void tearDown() {
    driver.quit();
    driver = null;
  }
}
