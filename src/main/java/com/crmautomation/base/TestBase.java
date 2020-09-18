package com.crmautomation.base;

import java.beans.EventHandler;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.EventListener;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crmautomation.utils.TestUtil;
import com.crmautomation.utils.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver eventDriver;
	public static WebEventListener eventListener;
	
	Logger log = Logger.getLogger(TestBase.class);
	
	public TestBase() {
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/crmautomation/config/config.properties");
			prop.load(ip);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		 
		
	}
	
	public void initialization() {
		
		String browser = prop.getProperty("browser");
		if(browser.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver","/home/manoj/eclipse-workspace/Library file/selenium/Drivers/chromedriver");
			driver=new ChromeDriver();
			log.info("Launching Chrome browser");
		}else if(browser.contains("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "/home/manoj/eclipse-workspace/Library file/selenium/Drivers/geckodriver");
			driver=new FirefoxDriver();
			log.info("Launching FireFox browser");
		}
		
		eventDriver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		eventDriver.register(eventListener);
		driver=eventDriver;
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITLY_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		
	}
	
}
