package com.qa.crm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.crm.Util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static String browsername;
	
	
	public TestBase(){
	 try {
		 	prop= new Properties();
			FileInputStream ip= new FileInputStream("/Users/dy0618/eclipse-workspace_US/DemoFreeCrm/src/main/java/com/qa/crm/config/config.properties");
			prop.load(ip);
	 }catch(FileNotFoundException e) {
		 e.printStackTrace(); 
	 } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	
	public static void intilization() {
		browsername=prop.getProperty("browser");
		if(browsername.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver","/Users/dy0618/Downloads/chromedriver 2");
			driver= new ChromeDriver();
		}else if(browsername.equals("FF")) {
			System.setProperty("webdriver.chrome.driver", "");	
			driver= new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOADTIME_OUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITWAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
		
	}

