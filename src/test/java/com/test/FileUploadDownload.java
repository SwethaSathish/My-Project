package com.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FileUploadDownload {

	@Test
	public void testDownload() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/download");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.linkText("SomeFile.txt")).click();
	}
	
	@Test
	public void testUpload() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/upload");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\Satba\\Downloads\\SomeFile.txt");
		driver.findElement(By.id("file-submit")).click();
	}
}
