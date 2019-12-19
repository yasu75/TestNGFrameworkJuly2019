package com.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hubspot.base.BasePage;
import com.hubspot.util.Constants;
import com.hubspot.util.ElementUtil;

public class HomePage extends BasePage{
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	By header = By.xpath("//h3[@role='presentational']");
	By accountName = By.xpath("//div[@class='navAccount-accountName']");
	
	
	//By contactsMainTab =By.id("//div[@class='app LayoutFullPage']//div[4]//div[1]");
	By contactsMainTab =By.id("nav-primary-contacts-branch");
	By contactsChildTab = By.id("nav-secondary-contacts");
	
	public HomePage(WebDriver driver){
		this.driver =driver;
		elementUtil = new ElementUtil(driver);
	}
	
	public String getHomePageTitle(){
		return elementUtil.waitForGetPageTitle(Constants.HOME_PAGE_TITLE);
	}
	
	public String getHomePageHeaderValue(){
		return elementUtil.doGetText(header);
	}
	
	public boolean verifyLoggedInAccountName(){
		return elementUtil.isElementDsiplayed(accountName);
	}
	
	public String getLoggedInAccountName(){
		return elementUtil.doGetText(accountName);
	}
	
	private void clickOnContacts(){
		elementUtil.doClick(contactsMainTab);
		elementUtil.doClick(contactsChildTab);
	}
	
	public ContactsPage gotoContactsPage(){
		clickOnContacts();
		return new ContactsPage(driver);
	}
		
}
