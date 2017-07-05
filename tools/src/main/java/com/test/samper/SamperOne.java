package com.test.samper;

import org.testng.annotations.Test;

import com.sun.org.apache.bcel.internal.generic.ConstantPushInstruction;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.test.browser.Browsers;
import com.test.browser.ChooseBrowser;
import com.test.readexcel.Wait;

import com.test.samper.Locators;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class SamperOne implements Locators {
	private WebDriver driver;
	private String projectpath;
	private Wait wait;
	
  @Test
  public void draggerMove(){
	  driver.get(url);
	  wait.waitForElementPresent(jueryhome);
	  driver.switchTo().frame(driver.findElement(By.xpath(iframe)));
	  Point initialPoint = driver.findElement(By.xpath(slider)).getLocation();
	  System.out.println(initialPoint);
	  
	  Actions dragger = new Actions(driver) ;
	  dragger.dragAndDropBy(driver.findElement(By.xpath(slider)), initialPoint.getX()+10, initialPoint.getY()).build().perform();
	  initialPoint = driver.findElement(By.xpath(slider)).getLocation();
	  System.out.println(initialPoint);
	  wait.waitFor(2000);
  }
  
  @Test
  public void selectCity() {
	  driver.get("http://www.daimajiayuan.com/sitejs-8966-1.html");
	  
  }
  
  @Test
  public void dragAndDrop() throws InterruptedException {
	  driver.get("http://www.jd.com");
	  wait.waitFor(5000);
	  JavascriptExecutor js = (JavascriptExecutor)driver;
      js.executeScript("scrollTo(0,10000)");
      Thread.sleep(3000);
	  driver.findElement(By.xpath(".//*[@id='lift']/ul/li[6]/a/span")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath(".//*[@id='portal_5']/div/div/div/div[1]/h3")).click();
	  System.out.println();
	  wait.waitFor(5000);
  }
  
  @Test
  public void changeWindow() {
	  driver.get("http://www.baidu.com");
	  driver.findElement(By.id("kw")).sendKeys("selenium");
	  driver.findElement(By.id("su")).click();
	  driver.findElement(By.xpath("//div[@id='1']/h3/a[1]")).click();
	  Switch switchW = new Switch(driver);
	  switchW.toSpecificWindow("百度翻译");
	  wait.waitForElementPresent("//a[@class='manual-trans-btn']");
	  
	  switchW.toSpecificWindow("hello_百度搜索");
	  wait.waitForElementPresent("//div[@id='s_tab']/b");
  }
  
  @Test
  public void printAllCities() {
	  driver.get("http://www.51job.com");
	  driver.findElement(By.xpath("//p[@class='nlink'/a[3]"));
	  //Select city = new Select(driver.findElement(By.xpath("//select[@id='city']")));
	 // List<WebElement> allcities = driver.findElement(By.xpath(""));
  }
  @BeforeMethod
  public void beforeMethod() {
	  ChooseBrowser browser = new ChooseBrowser(Browsers.firefox);
	  driver = browser.driver;
	  wait = new Wait(driver);
	  
  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.quit();
  }

}
