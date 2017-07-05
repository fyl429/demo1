package com.test.selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;

public class Firefoxdriver {
	private WebDriver driver;
	private String projectpath = System.getProperty("user.dir");
	private DesiredCapabilities capabilities;
  @Test
  public void f() {
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.gecko.driver", projectpath+"/tools/geckodriver.exe");
	  capabilities = DesiredCapabilities.firefox();
	  capabilities.setCapability("marionette", true);
	  driver = new FirefoxDriver(capabilities);
		
	  //driver = new FirefoxDriver();
	  driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.get("http://www.baidu.com");
	
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
