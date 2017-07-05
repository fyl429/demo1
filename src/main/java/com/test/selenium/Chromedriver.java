package com.test.selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;

public class Chromedriver {
	private static WebDriver driver;
	private String projectpath = System.getProperty("user.dir");
  @Test
  public void f() {
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", projectpath+"/tools/Chromedriver.exe");
	  driver = new ChromeDriver();
	 // driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.get("http://www.baidu.com");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
