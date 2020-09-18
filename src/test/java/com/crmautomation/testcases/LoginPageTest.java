package com.crmautomation.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crmautomation.base.TestBase;
import com.crmautomation.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
	}
	
	@Test(priority=1)
	public void pageTitleTest() {		
		String title = loginpage.validateLoginPageTitle();
		assertEquals(title, "Cogmento CRM");
	}
	
	@Test(priority=2)
	public void loginTest() throws InterruptedException {
		loginpage.login(prop.getProperty("email"), prop.getProperty("password"));
		Thread.sleep(6000);
	}
	
	@AfterMethod
	public void quit() {
		driver.quit();
	}

}
