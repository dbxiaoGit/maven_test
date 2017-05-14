package com.test.m2test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest {
	public static WebDriver driver;
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
	  driver.findElement(By.id("kw")).sendKeys(s);
	  driver.findElement(By.id("su")).click();
	  new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.pc")));
	  String res = driver.findElement(By.id("1")).getText();
	  Assert.assertEquals(res, "网页");
  }
  @BeforeMethod
  public void beforeMethod() {
	  driver.navigate().to("https://www.baidu.com");
  }

  @AfterMethod
  public void afterMethod() {
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
