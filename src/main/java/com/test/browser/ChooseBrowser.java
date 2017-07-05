package com.test.browser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChooseBrowser {
	
	public WebDriver driver;
	public String projectpath = System.getProperty("user.dir");
	public DesiredCapabilities caps;
	
	public ChooseBrowser(Browsers browser) {
		switch(browser) {
			case ie:
				  System.setProperty("webdriver.ie.driver", projectpath+"/tools/IEDriverServer_64.exe");
				  caps = DesiredCapabilities.internetExplorer();
				  caps.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
				  driver = new InternetExplorerDriver(caps);
				  //driver = new InternetExplorerDriver();
				  driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
				  driver.manage().window().maximize();
				  break;
			case firefox:
				  System.setProperty("webdriver.gecko.driver", projectpath+"/tools/geckodriver.exe");
				  caps = DesiredCapabilities.firefox();
				  caps.setCapability("marionette", true);
				  driver = new FirefoxDriver(caps);
				  break;
			case chrome:	
				 System.setProperty("webdriver.chrome.driver", projectpath+"/tools/Chromedriver.exe");
				  driver = new ChromeDriver();
				  driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
				  driver.manage().window().maximize();
				  break;
		}
	}
	
	
}
