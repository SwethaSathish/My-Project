package com.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseMove {
	
	@Test
	public void testMouseMove() {

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/hovers");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Actions actions = new Actions(driver);

		WebElement image1 = driver.findElement(By.xpath("(//div[@class='figure'])[1]"));
		actions.moveToElement(image1).perform();
		WebElement user1 = driver.findElement(By.xpath("(//h5)[1]"));
		System.out.println("User 1: " + user1.getText());

		WebElement image2 = driver.findElement(By.xpath("(//div[@class='figure'])[2]"));
		actions.moveToElement(image2).perform();
		WebElement user2 = driver.findElement(By.xpath("(//h5)[2]"));
		System.out.println("User 2: " + user2.getText());

		WebElement image3 = driver.findElement(By.xpath("(//div[@class='figure'])[3]"));
		actions.moveToElement(image3).perform();
		WebElement user3 = driver.findElement(By.xpath("(//h5)[3]"));
		System.out.println("User 3: " + user3.getText());

		driver.quit();
	}

}