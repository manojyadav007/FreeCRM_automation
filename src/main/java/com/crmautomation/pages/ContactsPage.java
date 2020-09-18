package com.crmautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crmautomation.base.TestBase;

public class ContactsPage extends TestBase{
	
	//@FindBy(xpath="//td[contains(text(),'Manoj Yadav')]//preceding-sibling::td/div/input[@type='checkbox']")
	@FindBy(xpath="//td[contains(text(),'Manoj Yadav')]//preceding-sibling::td/div[contains(@class,'checkbox')]")
	WebElement contactsCheckbox;
	
	@FindBy(xpath="//td[contains(text(),'Manoj Yadav')]//preceding-sibling::td/div/input[@type='checkbox']")
	WebElement contactsCheckboxLalbel;
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement newButton;
	
	@FindBy(name="first_name")
	WebElement fName;
	
	@FindBy(name="last_name")
	WebElement lName;
	
	@FindBy(name="status")
	WebElement status;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement saveButton;
	
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyPageTitle() {
		return driver.getTitle();
	}
	
	public void clickOnCheckbox() {
		contactsCheckbox.click();
	}
	
	public boolean getCheckboxLabelText() {
		boolean result = contactsCheckboxLalbel.isSelected();
		return result;
	}
	
	public void createNewContact(String firstname, String lastname, String status_value ) {
		newButton.click();
		fName.sendKeys(firstname);
		lName.sendKeys(lastname);
		status.click();
		driver.findElement(By.xpath("//span[text()='"+status_value+"']")).click();
		saveButton.click();
		
		
	}

}
