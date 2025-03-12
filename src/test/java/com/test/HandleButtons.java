package com.test;

import java.time.Duration;

//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandleButtons {

	@Test
	public void testAlert() throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/buttons");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Actions action = new Actions(driver);
		
		WebElement doubleClickEl = driver.findElement(By.id("doubleClickBtn"));
		action.doubleClick(doubleClickEl).build().perform();
		String text = driver.findElement(By.id("doubleClickMessage")).getText();
		Assert.assertEquals(text, "You have done a double click");
		
		WebElement rightClickELement = driver.findElement(By.id("rightClickBtn"));
		action.contextClick(rightClickELement).build().perform();
		String text1 = driver.findElement(By.id("rightClickMessage")).getText();
		Assert.assertEquals(text1, "You have done a right click");
	
		WebElement singleClickELement = driver.findElement(By.xpath("//button[text()='Click Me']"));
		action.click(singleClickELement).build().perform();
		
		String text2 = driver.findElement(By.id("dynamicClickMessage")).getText();
		Assert.assertEquals(text2, "You have done a dynamic click");
		
		driver.quit();
	}
}
