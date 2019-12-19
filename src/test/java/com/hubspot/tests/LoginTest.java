package com.hubspot.tests;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hubspot.base.BasePage;
import com.hubspot.pages.LoginPage;
import com.hubspot.util.Constants;

@Listeners(com.hubspot.listeners.TestAllureListener.class)

public class LoginTest {
	
	Logger log = Logger.getLogger("LoginTest");
	
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LoginPage loginPage;
	
	@BeforeMethod
	public void setUp(){
		basePage = new BasePage();
		log.info("Browser is launching");
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		loginPage = new LoginPage(driver);
		log.info("setUp confg");
	}
	//priority provides ordered test
	@Test(priority=1, description = "login test with correct username and correct password")
	public void loginTest() throws InterruptedException{
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		log.info("Login test logs: correct pass ans user");
		Thread.sleep(4000);
	}
	
	@Test(priority=2, description = "login test with incorrect username and incorrect password")
	public void loginTest1() throws InterruptedException{
		loginPage.doLogin(prop.getProperty("invalidusername"), prop.getProperty("invalidpassword"));
		//Thread.sleep(4000);
	}
	
	@Test(priority=3, description = "login test with correct username and incorrect password")
	public void loginTest2() throws InterruptedException{
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("invalidpassword"));
		//Thread.sleep(4000);
	}
	
	@Test(priority=4, description = "login page title test... ")
	public void loginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE, "title is in correct...");
	}
	
	@AfterMethod
	public void tearDown(){
		basePage.quitBrowser();
	}

}
