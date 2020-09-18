package com.crmautomation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crmautomation.base.TestBase;
import com.crmautomation.pages.ContactsPage;
import com.crmautomation.pages.HomePage;
import com.crmautomation.pages.LoginPage;
import com.crmautomation.utils.TestUtil;

public class ContactsPageTest extends TestBase{
	
	HomePage homepage;
	LoginPage loginpage;
	ContactsPage contactspage;
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("email"), prop.getProperty("password"));
		contactspage = homepage.gotoContacts();
	}
	
	@Test
	public void clickOnCheckboxTest() throws InterruptedException {
		Thread.sleep(3000);
		contactspage.clickOnCheckbox();
		boolean isCheckboxClicked = contactspage.getCheckboxLabelText();
		Assert.assertTrue(isCheckboxClicked);
	}
	
//	@DataProvider
//	public Object[][] getCRMData() {
//		Object[][] data = TestUtil.getTestData("Contacts");
//		return data;
//	}
//	
//	@Test(dataProvider="getCRMData")
//	public void newContactTest(String firstname, String lastname, String status) throws InterruptedException {
//		contactspage.createNewContact(firstname,lastname,status);
//		Thread.sleep(10000);
//	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
