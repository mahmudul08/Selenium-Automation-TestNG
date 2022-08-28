package Login_Functionality_Check;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import BrowserManager.TestNG_UTILS;

public class Login_Functionality {
	String url = "https://ajkerdeal.com/";

	@Test(description = "Hover Login button", priority = 0)
	public void HoverLoginCheck() throws InterruptedException, IOException {
		WebDriver driver = TestNG_UTILS.getDriver("Chrome");
		driver.get(url);
		Actions hover = new Actions(driver);
		hover.moveToElement(driver.findElement(By.xpath("//a[@id='hover-Id']"))).build().perform();
		Thread.sleep(1000);

		File ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(ss, new File("D:\\SQA\\Final Project\\Selenium Maven\\Ajkerdeal\\Screenshot\\hover.jpg"));
		driver.quit();
	}

	@Test(description = "Verify Login into Application using valid Credentials", priority = 1)
	public void LoginWithValid() throws InterruptedException, IOException {
		WebDriver driver = TestNG_UTILS.getDriver("Chrome");
		driver.get(url);
		Actions hover = new Actions(driver);
		hover.moveToElement(driver.findElement(By.xpath("//a[@id='hover-Id']"))).build().perform();
		Thread.sleep(1000);

		driver.findElement(By.id("Email")).sendKeys("mail.mahmudul08@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.id("Password")).sendKeys("123456");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='à¦²à¦—à¦‡à¦¨']")).click();
		Thread.sleep(1000);

		String expectedTitle = "Online Shopping BD: Fashion, Electronics & Gadgets | Ajkerdeal";
		String actualTitle = driver.getTitle();

		Assert.assertEquals(actualTitle, expectedTitle);
		Thread.sleep(2000);
		File ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(ss, new File("D:\\SQA\\Final Project\\Selenium Maven\\Ajkerdeal\\Screenshot\\validLogin.jpg"));
		driver.quit();

	}

	@Test(description = "Verify Login into Application using Invalid Email and Valid Password", priority = 2)
	public void OneInvalidCredentials() throws InterruptedException {
		WebDriver driver = TestNG_UTILS.getDriver("Chrome");
		driver.get(url);
		Actions hover = new Actions(driver);
		hover.moveToElement(driver.findElement(By.xpath("//a[@id='hover-Id']"))).build().perform();
		Thread.sleep(1000);

		driver.findElement(By.id("Email")).sendKeys("mahmudul08@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.id("Password")).sendKeys("123456");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='à¦²à¦—à¦‡à¦¨']")).click();
		Thread.sleep(1000);
		driver.quit();

	}

	@Test(description = "Verify Login into Application using All Invalid credentials", priority = 3)
	public void AllInvalidCredentials() throws InterruptedException, IOException {
		WebDriver driver = TestNG_UTILS.getDriver("Chrome");
		driver.get(url);
		Actions hover = new Actions(driver);
		hover.moveToElement(driver.findElement(By.xpath("//a[@id='hover-Id']"))).build().perform();
		Thread.sleep(1000);

		driver.findElement(By.id("Email")).sendKeys("mahmudul08@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.id("Password")).sendKeys("12345666");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='à¦²à¦—à¦‡à¦¨']")).click();
		Thread.sleep(1000);
		driver.quit();

	}

	@Test(description = "Verify Login into Application using valid Credentials use Browser Back Button", priority = 4)
	public void LoginWithValidBrowserBack() throws InterruptedException, IOException {
		WebDriver driver = TestNG_UTILS.getDriver("Chrome");
		driver.get(url);
		Actions hover = new Actions(driver);
		hover.moveToElement(driver.findElement(By.xpath("//a[@id='hover-Id']"))).build().perform();
		Thread.sleep(1000);

		driver.findElement(By.id("Email")).sendKeys("mail.mahmudul08@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.id("Password")).sendKeys("123456");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='à¦²à¦—à¦‡à¦¨']")).click();
		Thread.sleep(3000);
		
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().forward();
		Thread.sleep(1000);

		String expectedTitle = "Online Shopping BD: Fashion, Electronics & Gadgets | Ajkerdeal";
		String actualTitle = driver.getTitle();

		Assert.assertEquals(actualTitle, expectedTitle);
		Thread.sleep(2000);
		File ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(ss, new File("D:\\SQA\\Final Project\\Selenium Maven\\Ajkerdeal\\Screenshot\\browserBack.jpg"));
		driver.quit();

	}
	@Test(description = "Verify Login into Application using valid Credentials and Logout from applicationn", priority = 5)
	public void SignOut() throws InterruptedException, IOException {
		WebDriver driver = TestNG_UTILS.getDriver("Chrome");
		driver.get(url);
		Actions hover = new Actions(driver);
		hover.moveToElement(driver.findElement(By.xpath("//a[@id='hover-Id']"))).build().perform();
		Thread.sleep(1000);

		driver.findElement(By.id("Email")).sendKeys("mail.mahmudul08@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.id("Password")).sendKeys("123456");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='à¦²à¦—à¦‡à¦¨']")).click();
		Thread.sleep(3000);
		
		hover.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'md hasan à¦†à¦ªà¦¨à¦¾à¦° à¦…à§�à¦¯à¦¾à¦•à¦¾à¦‰à¦¨à§�à¦Ÿ')]"))).build().perform();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//a[contains(text(),'à¦¸à¦¾à¦‡à¦¨ à¦†à¦‰à¦Ÿ')]")).click();
		Thread.sleep(1000);

		String expectedTitle = "Online Shopping BD: Fashion, Electronics & Gadgets | Ajkerdeal";
		String actualTitle = driver.getTitle();

		Assert.assertEquals(actualTitle, expectedTitle);
		Thread.sleep(2000);
		File ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(ss, new File("D:\\SQA\\Final Project\\Selenium Maven\\Ajkerdeal\\Screenshot\\signout.jpg"));
		driver.quit();

	}
	
}
