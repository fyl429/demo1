package com.test.selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;

public class IEdriver {
	private WebDriver driver;
	private String projectpath = System.getProperty("user.dir");
	private DesiredCapabilities caps;
  @Test
  public void f() {
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.ie.driver", projectpath+"/tools/IEDriverServer_64.exe");
	  caps = DesiredCapabilities.internetExplorer();
	  caps.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
	  driver = new InternetExplorerDriver(caps);
	  //driver = new InternetExplorerDriver();
	  driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.get("http://www.baidu.com");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
