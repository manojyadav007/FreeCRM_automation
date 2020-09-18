package com.crmautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crmautomation.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactlink;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyPageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyUser(String user) {
		WebElement login_user=driver.findElement(By.xpath("//span[contains(text(),'"+user+"')]"));
		boolean result=login_user.isDisplayed();
		return result;
		
	}
	
	public ContactsPage gotoContacts() {
		contactlink.click();
		return new ContactsPage();
	}

}
