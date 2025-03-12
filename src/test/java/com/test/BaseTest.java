package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

	WebDriver driver;

	@BeforeMethod
	@Parameters({"browser"})
	public void setUp(String browser1) {
		if(browser1.equals("chrome")){
			driver = new ChromeDriver();
		}else if(browser1.equals("firefox")){
            driver = new FirefoxDriver();
		} else if (browser1.equals("edge")) {
			driver = new EdgeDriver();
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}