package com.test;


import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

public class Checkbox extends BaseTest{

	
	@Test
	public void testCheckBox() {

		driver.get("https://the-internet.herokuapp.com/checkboxes");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement checkbox1 = driver.findElement(By.xpath("//input[1]"));
		WebElement checkbox2 = driver.findElement(By.xpath("//input[2]"));

		if (!checkbox1.isSelected()) {
			checkbox1.click();
		}

		if (checkbox2.isSelected()) {
			checkbox2.click();
		}
	}

}