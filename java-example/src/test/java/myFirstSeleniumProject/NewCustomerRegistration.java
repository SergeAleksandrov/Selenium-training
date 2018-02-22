package myFirstSeleniumProject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class NewCustomerRegistration {

  WebDriver driver;
  WebDriverWait wait;
  String l;
  String email = "monica.smith7@gmail.com";
  String password = "12345678";

  @Before
  public void start(){
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  }

  @Test
  public void registrationNew(){
    driver.navigate().to("http://localhost/litecart/en/");
    driver.findElement(By.xpath("//div[@id='box-account-login']//a[.='New customers click here']")).click();
    driver.findElement(By.xpath("//div[@id='box-create-account']/form/div[2]/div[1]/input")).sendKeys("Monica");
    driver.findElement(By.xpath("//div[@id='box-create-account']/form/div[2]/div[2]/input")).sendKeys("Smith");
    driver.findElement(By.xpath("//div[@id='box-create-account']/form/div[5]/div[1]/select")).click();
    driver.findElement(By.xpath("//div[@id='box-create-account']/form/div[5]/div[1]/select//option[230]")).click();
    driver.findElement(By.xpath("//div[@id='box-create-account']/form/div[5]/div[2]/select")).click();
    driver.findElement(By.xpath("//div[@id='box-create-account']/form/div[5]/div[2]/select//option[3]")).click();
    driver.findElement(By.xpath("//div[@id='box-create-account']/form/div[6]/div[1]/div/input")).sendKeys(email);
    driver.findElement(By.xpath("//div[@id='box-create-account']/form/div[7]/div[1]/div/input")).sendKeys(password);
    driver.findElement(By.xpath("//div[@id='box-create-account']/form/div[7]/div[2]/div/input")).sendKeys(password);
    driver.findElement(By.xpath("//div[@id='box-create-account']//button[.='Create Account']")).click();
    driver.findElement(By.xpath("//div[@id='box-account']//a[.='Logout']")).click();
    driver.findElement(By.xpath("//div[@id='box-account-login']/form//div[3]//button[.='Sign In']")).click();
    driver.findElement(By.xpath("//div[@id='box-account-login']/form/div[1]/div/input")).sendKeys(email);
    driver.findElement(By.xpath("//div[@id='box-account-login']/form/div[2]/div/input")).sendKeys(password);
    driver.findElement(By.xpath("//div[@id='box-account-login']//button[.='Sign In']")).click();
    driver.findElement(By.xpath("//div[@id='box-account']//a[.='Logout']")).click();
    System.out.println("Test passed successfully");
  }

  @After
  public void finish(){
    driver.quit();
    driver = null;
  }
}
