package com.qa.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crm.base.TestBase;

public class LoginPage extends TestBase {
	//PageFactory-OR
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//xpath[@type='submit']")
	WebElement click;
	
	@FindBy(xpath="//a[contains(type,'Sign Up')]")
	WebElement signUpBtn;
	
	
	//Intilization page element.
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String loginPagetitle() {
		return driver.getTitle();
	}
	
	public HomePage login() {
		username.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		JavascriptExecutor js= (JavascriptExecutor) driver;
		click.click();
		return new HomePage();
	}
}
