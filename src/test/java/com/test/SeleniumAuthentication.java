package com.test;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumAuthentication {

	@Test
	public void seleniumTest() {
		WebDriver driver = new ChromeDriver();

		HasAuthentication authentication = (HasAuthentication) driver;
		authentication.register(() -> new UsernameAndPassword("admin", "admin"));

		driver.get("https://the-internet.herokuapp.com/basic_auth");
	}
}