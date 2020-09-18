package com.crmautomation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crmautomation.base.TestBase;
import com.crmautomation.pages.HomePage;
import com.crmautomation.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	HomePage homepage;
	LoginPage loginpage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		homepage=loginpage.login(prop.getProperty("email"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void verifyPageTitleTest() {
		String title = homepage.verifyPageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	
	@Test(priority=2)
	public void verifyUserTest() {
		boolean result = homepage.verifyUser("Manoj Yadav");
		Assert.assertTrue(result);
	}
	
	@Test(priority=3)
	public void navigateToContactsPageTest() throws InterruptedException {
		homepage.gotoContacts();
		Thread.sleep(6000);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
