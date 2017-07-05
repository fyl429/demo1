package com.test.groups.testng;

import org.testng.annotations.Test;

import com.test.browser.Browsers;
import com.test.browser.ChooseBrowser;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class RunAsGroups {
	
	private WebDriver driver;
	private ChooseBrowser browser;
	
  @BeforeMethod(groups="browsers")
  public void initial() {
	  browser = new ChooseBrowser(Browsers.firefox);
	  driver = browser.driver;
  }
  
  @AfterMethod(groups="browsers")
  public void release() {
	  driver.quit();
  }
  
  @Test(groups="submodule1")
  public void f() {
	  driver.get("http://www.baidu.com");
	  System.out.println("----testsubmodule1----");
  }
  
  @Test(groups="submodule2")
  public void f1() {
	  driver.get("http://www.163.com");
	  System.out.println("----testsubmodule2----");
  }
  
  @Test(groups="submodule3")
  public void f2() {
	  driver.get("http://www.taobao.com");
	  System.out.println("----testsubmodule3----");
  }
  

}
