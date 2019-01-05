package com.qa.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crm.base.TestBase;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;

public class LoginPageTest extends TestBase {
	public static LoginPage login;
	public static HomePage homepage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		intilization();
		login= new LoginPage();
		
	}
	
	@Test
	public void verifLoginPagetitleTest() {
		String title=login.loginPagetitle();
		Assert.assertEquals(title, "#1 Free CRM for Any Business: Online Customer Relationship Software");
	}
	
	@Test
	public void loginTest() {
		homepage=login.login();
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
