package com.test.browser;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;


public class TestBrowser {
	private WebDriver driver;
  @Test
  public void f() {
	  driver.get("http://www.baidu.com");
  }
  @BeforeMethod
  public void beforeMethod() {
	  ChooseBrowser browser = new ChooseBrowser(Browsers.firefox);
	  driver = browser.driver;
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
