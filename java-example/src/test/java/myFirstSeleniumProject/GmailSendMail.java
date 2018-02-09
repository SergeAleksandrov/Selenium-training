package myFirstSeleniumProject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class GmailSendMail {
    WebDriver sss;
    
    @Before
    public void setUp() throws Exception {
        sss = new ChromeDriver();
        sss.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void odessaMama() {
        sss.get("https://mail.google.com/mail/u/2/#inbox");
        sss.findElement(By.cssSelector("input.whsOnd.zHQkBf")).sendKeys("alserge.tmp@gmail.com");
        sss.findElement(By.cssSelector("span.RveJvd.snByac")).click();
        sss.findElement(By.cssSelector("input.whsOnd.zHQkBf")).sendKeys("StephenKing6131");
        sss.findElement(By.cssSelector("div#passwordNext content.CwaK9 span.RveJvd.snByac")).click();
        sss.findElement(By.cssSelector("div.T-I.J-J5-Ji.T-I-KE.L3")).click();  //compose
        sss.findElement(By.cssSelector("textarea.vO[name=to]")).sendKeys("alserge.tmp@gmail.com");
        sss.findElement(By.cssSelector("input[name=subjectbox]")).sendKeys("Greetings");
        sss.findElement(By.cssSelector("div.Am.Al.editable.LW-avf")).sendKeys("Hello, buddy!");
        sss.findElement(By.cssSelector("div.J-J5-Ji.btA div.T-I.J-J5-Ji.aoO.T-I-atl.L3")).click();
        sss.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @After
    public void tearDown() {
        sss.quit();
    }
    

}
