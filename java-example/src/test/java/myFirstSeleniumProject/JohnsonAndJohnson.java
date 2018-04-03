package myFirstSeleniumProject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class JohnsonAndJohnson {

  final By NOTIFICATION_DISCLAIMER = By.xpath("//div[@class='disclaimer-button']/input");
  final By SEARCH_BUTTON = By.xpath("//nav[@id='block-searchdropdown']//span[.=' Search ']");
  final By TEXT_FIELD_SEARCH = By.cssSelector("a.link");
  final By KEYWORD_SEARCH = By.xpath("//header/div/div[2]/div/div[1]/nav[2]/ul/li/ul/li[2]/input");

  String url = "https://www.ethicon.com/na/education-support/customer-support";

  WebDriver driver;
  WebDriverWait wait;
  String searchingFieldQuestion;
  String placeholderInitial = "What product are you looking for?";
  String letters = "a";
  String digits = "1";
  String specialCharacters = "$";
  WebElement searchingField, editSearch;

  @Before
  public void start() {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    wait = new WebDriverWait(driver, 10);
    driver.manage().window().maximize();
    driver.navigate().to(url);
    driver.findElement(NOTIFICATION_DISCLAIMER).click();  // closing of the warning
    driver.findElement(SEARCH_BUTTON).isDisplayed(); // checking the presence of element on the page
  }

  @Test
  public void productSpecificationSearch() throws InterruptedException {
    String[] array1 = {"A", "a", "AT", "ATS", "ATS4","ATS45"};

    driver.findElement(SEARCH_BUTTON).click();
    driver.findElement(TEXT_FIELD_SEARCH).click(); // calling the search text field

    searchingField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='edit-keyword']")));
    searchingField.isDisplayed();  // checking the presence of searching field
    editSearch = driver.findElement(By.xpath("//button[@id='edit-search']"));
    editSearch.isDisplayed();  // checking the presence of the button "Search"

    System.out.println(searchingField.getAttribute("placeholder"));
    searchingFieldQuestion = searchingField.getAttribute("placeholder");
    Assert.assertEquals("Verification of the value of a placeholder", searchingFieldQuestion, placeholderInitial);  // verification of the value of a placeholder

    Assert.assertEquals(searchingField.getAttribute("maxLength"), "64"); // Length of the searching text box verification
    System.out.println(searchingField.getAttribute("maxLength"));

    searchingField.clear();
    searchingField.sendKeys(letters); // Letters input verification
    Assert.assertEquals(letters, searchingField.getAttribute("value"));
    System.out.println(searchingField.getAttribute("value"));
    searchingField.clear();
    searchingField.sendKeys(digits); // Digits input verification
    System.out.println(searchingField.getAttribute("value"));
    Assert.assertEquals(digits, searchingField.getAttribute("value"));
    searchingField.clear();
    searchingField.sendKeys(specialCharacters); // Special characters input verification
    System.out.println(searchingField.getAttribute("value"));
    Assert.assertEquals(specialCharacters, searchingField.getAttribute("value"));

    // Verification the correctness of the search (valid credentials)
    for (int j = 0; j < array1.length; j++) {
      String keyword = array1[j];
      driver.findElement(By.xpath("//input[@id='edit-keyword']")).clear();
      driver.findElement(By.xpath("//input[@id='edit-keyword']")).sendKeys(array1[j]);
      Thread.sleep(2000);
      driver.findElement(By.xpath("//button[@id='edit-search']")).click();

      List<WebElement> searchResults = driver.findElements(By.cssSelector("a.eprc-link"));

      for (int i = 0; i < searchResults.size(); i++) {
        WebElement element = searchResults.get(i);
        String searchResult = element.getAttribute("textContent");
        System.out.println(searchResult);
        if (!searchResult.contains(keyword)) {
          System.out.println("Invalid search result");
          //Assert.fail("Invalid search result");
        }
      }
    }
    // Verification the correctness of the search (invalid input)
    String[] array2 = {"TF$%^", "465d", "&^%$", "&j^%$G", "&"};
    int index = new Random().nextInt(array2.length);
    String random = (array2[index]);
    System.out.println(random);
    driver.findElement(By.xpath("//input[@id='edit-keyword']")).clear();
    driver.findElement(By.xpath("//input[@id='edit-keyword']")).sendKeys(random);
    driver.findElement(By.xpath("//button[@id='edit-search']")).click();
    Thread.sleep(2000);
    if (!driver.findElement(By.xpath("//div[@class='col-xs-12 no-results-message']")).isDisplayed()) {
      Assert.fail("Invalid search result");
    }
  }

  @Test
  public void invalidInputSearchingField() throws InterruptedException {
    driver.findElement(SEARCH_BUTTON).click();
    driver.findElement(TEXT_FIELD_SEARCH).click(); // calling the search text field
    searchingField = driver.findElement(By.xpath("//input[@id='edit-keyword']"));
    searchingField.isDisplayed();
    searchingField.clear();
    searchingField.sendKeys(" ");  // Space input in searching field
    driver.findElement(By.cssSelector("button#edit-search.button.js-form-submit.form-submit.btn-primary.btn.icon-before")).click();
    Thread.sleep(5000);
  }

  @Test
  public void keywordSearch() throws InterruptedException {
//    driver.findElement(By.xpath("//nav[@id='block-searchdropdown']//span[.=' Search ']")).click();
//    driver.findElement(By.xpath("//header/div/div[2]/div/div[1]/nav[2]/ul/li/ul/li[2]/input")).click();
    String[] array3 = {"Absorbable Hemostat", "The loose knit structured material of SURGICEL®", "FIBRILLAR™", "Sponge to another absorbable", "&^%^%FJGHJGH"};
    for (int j = 0; j < array3.length; j++) {
      String keyword = array3[j];
      driver.findElement(By.xpath("//nav[@id='block-searchdropdown']//span[.=' Search ']")).click();
      driver.findElement(By.xpath("//header/div/div[2]/div/div[1]/nav[2]/ul/li/ul/li[2]/input")).click();
      Thread.sleep(2000);
      driver.findElement(By.xpath("//header/div/div[2]/div/div[1]/nav[2]/ul/li/ul/li[2]/input")).clear();
      driver.findElement(By.xpath("//header/div/div[2]/div/div[1]/nav[2]/ul/li/ul/li[2]/input")).sendKeys(keyword);
      Thread.sleep(2000);
      driver.findElement(By.xpath("//nav[@id='block-searchdropdown']//i[.='keyboard']")).click();


      List<WebElement> searchResults = driver.findElements(By.cssSelector("div.col-xs-12.search-title"));

      for (int i = 0; i < searchResults.size(); i++) {
        WebElement element = searchResults.get(i);
        String searchResult = element.getText();
        //System.out.println(searchResult);
        if (searchResult.contains(keyword)) {
          System.out.println("Success");
        } else {
          System.out.println("Fail");
        }
      }
    }
  }

//  @After
//  public void finish() {
//    driver.quit();
//    driver = null;
//  }
}


