package com.test;


	import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.testng.annotations.Test;

	public class DragAndDrop extends BaseTest{

		@Test
		public void testDragAndDrop() {
			driver.get("https://jqueryui.com/droppable/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			driver.switchTo().frame(0);

			WebElement source = driver.findElement(By.id("draggable"));
			WebElement target = driver.findElement(By.id("droppable"));

			Actions actions = new Actions(driver);
			actions.dragAndDrop(source, target).build().perform();

			driver.quit();
		}
		
		@Test
		public void dragAndDropBy() {
			driver.get("https://jqueryui.com/draggable/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			driver.switchTo().frame(0);

			WebElement source = driver.findElement(By.id("draggable"));

			Actions actions = new Actions(driver);
			actions.dragAndDropBy(source, 300, 100).build().perform();

			driver.quit();
		}
	}


	



