package Assignment;

//import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class userLogin {
	//@Test
	public void testLogin() throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Correct user
		driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		String HomepageUrl= "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		String CurrentUrl= driver.getCurrentUrl();
	    System.out.println("Current URL: " + CurrentUrl);
		Assert.assertEquals(HomepageUrl,CurrentUrl);
		driver.quit();
		
		
}
	//@Test
	public void testLogin_Invalid() throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Correct user
		driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys("Admin1");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		String InvalidLoginText = driver.findElement(By.xpath("//p[@class = 'oxd-text oxd-text--p oxd-alert-content-text']")).getText();
	    System.out.println("Invalid login: " + InvalidLoginText);
		Assert.assertEquals("Invalid credentials",InvalidLoginText);
		driver.quit();
		 
		
}
	@Test
	public void addUser() throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Correct user
		driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@href = '/web/index.php/admin/viewAdminModule']")).click();
		
		//driver.findElement(By.xpath("//form[@class='oxd-form']/div/div/div/div/div[2]/input")).sendKeys("Swetha");
		driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")).click();
		driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'][normalize-space()='-- Select --'])[1]")).click();
		
		driver.findElement(By.xpath("//span[contains(text(),'Admin')]")).click();
		
		driver.findElement(By.xpath("(//div[contains(text(),'-- Select --')])[1]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Enabled')]")).click();
		driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("Ravi M B");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@role='option']")).click();
		
		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys("SwethaJagadeesan6");
		driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("Swe1234");
		driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("Swe1234");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(5000);
		String pageUrl= "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers";
		String CurrentUrl= driver.getCurrentUrl();
	    System.out.println("Current URL: " + CurrentUrl);
		Assert.assertEquals(pageUrl,CurrentUrl);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@class='oxd-form']/div/div/div/div/div[2]/input")));
		//Search for added user
		driver.findElement(By.xpath("//form[@class='oxd-form']/div/div/div/div/div[2]/input")).sendKeys("SwethaJagadeesan6");
		driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//span[normalize-space()='(1) Record Found']")).isDisplayed());
		driver.quit();
		 
		
}
}
