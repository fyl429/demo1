package com.test.readproperties;

import org.testng.annotations.Test;

import com.test.browser.Browsers;
import com.test.browser.ChooseBrowser;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class ReadProperties {
	private WebDriver driver;
	private String projectpath = System.getProperty("user.dir");
	private ParseProperties data;
	private ParseProperties locator;
	
	public void iframe(String... frames) {
		driver.switchTo().defaultContent();
		for(String frame:frames) {
			driver.switchTo().frame(frame);
		}
	}
	
  @Test
  public void f() {
	  Wait wait = new Wait(driver);
	  driver.get(data.getValue("url"));
	  System.out.println(data.getValue("url"));
	  driver.switchTo().frame("x-URS-iframe");
	  driver.findElement(By.xpath(locator.getValue("username"))).clear();
	  driver.findElement(By.xpath(locator.getValue("username"))).sendKeys(data.getValue("username"));
	  driver.findElement(By.xpath(locator.getValue("password"))).sendKeys(data.getValue("password"));
	  driver.findElement(By.xpath(locator.getValue("submit"))).click();
	  driver.switchTo().defaultContent();
	  wait.waitForElementPresent(locator.getValue("homepage"));
	  Assert.assertEquals(driver.findElement(By.xpath(locator.getValue("sendbox"))).isDisplayed(),true);
  }
  
  @Parameters({"data","locator"})
  @BeforeMethod
  public void beforeMethod(String da,String loc1) {
	  ChooseBrowser browser = new ChooseBrowser(Browsers.ie);
	  driver = browser.driver;
	  data = new ParseProperties(System.getProperty("user.dir")+da);
	  locator = new ParseProperties(System.getProperty("user.dir")+loc1);
	  
  }
  
  

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
