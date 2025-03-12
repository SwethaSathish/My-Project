package com.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TakeScreenshotEx {
	
	WebDriver driver;
	
	@Test
	public void testTakeScreenshots() throws IOException {
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
				
		WebElement userElement = driver.findElement(By.id("email1"));
		userElement.clear();
		userElement.sendKeys("test@gmail.com");
		
		WebElement passwordElement = driver.findElement(By.id("pass"));
		passwordElement.clear();
		passwordElement.sendKeys("Password");
		
		WebElement loginButton = driver.findElement(By.name("login"));
		loginButton.click();
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if(result.getStatus() == ITestResult.FAILURE) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File file1 = ts.getScreenshotAs(OutputType.FILE);
			File file2 = new File("page.png");
			FileUtils.copyFile(file1, file2);
		}
		driver.quit();
	}
	

}