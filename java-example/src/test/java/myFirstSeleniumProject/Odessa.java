package myFirstSeleniumProject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class Odessa {
    WebDriver sss;
    
    @Before
    public void setUp() throws Exception {
        sss = new FirefoxDriver();
        sss.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void odessaMama() {
        sss.get("https://www.google.com.ua/");
        sss.findElement(By.id("gs_ok0")).click();
        sss.findElement(By.id("K32")).click();
        sss.findElement(By.id("lst-ib")).sendKeys("Odessa Ukraine");
        sss.findElement(By.name("btnK")).click();
        sss.findElement(By.id("lst-ib")).clear();
        sss.findElement(By.id("lst-ib")).sendKeys("Odessa Ukraine");
        sss.findElement(By.linkText("Odessa - Wikipedia")).click();
        sss.findElement(By.xpath("//td[@class='maptable']/table/tbody/tr[2]/td[1]/a/img")).click();
        sss.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @After
    public void tearDown() {
        sss.quit();
    }
    

}
