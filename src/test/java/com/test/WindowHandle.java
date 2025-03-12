package com.test;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowHandle {

	@Test
	public void testWindow() {

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String text = driver.findElement(By.tagName("h3")).getText();
		System.out.println(text);

		driver.findElement(By.partialLinkText("Here")).click();

		String parnetId = driver.getWindowHandle();
		Set<String> ids = driver.getWindowHandles();
		for (String id : ids) {
			if (!id.equals(parnetId)) {
				driver.switchTo().window(id);
			}
		}

		String childWindowText = driver.findElement(By.xpath("//body/div[@class='example']/h3")).getText();
		System.out.println(childWindowText);
		driver.close();
		driver.switchTo().window(parnetId);

		String text1 = driver.findElement(By.tagName("h3")).getText();
		System.out.println(text1);

		driver.quit();
	}
	
	@Test
	public void openWindow() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.google.com");
		
	}

}
