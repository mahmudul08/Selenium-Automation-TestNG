package Homepage_Functionality_Check;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import BrowserManager.TestNG_UTILS;

public class Homepage {
	String url = "https://ajkerdeal.com/";

	@Test(description = "Verify Title is valid", priority = 0)
	public void Titlecheck() throws InterruptedException, IOException {
		WebDriver driver = TestNG_UTILS.getDriver("Chrome");
		driver.get(url);
		String expectedTitle = "Online Shopping BD: Fashion, Electronics & Gadgets | Ajkerdeal";
		String actualTitle = driver.getTitle();

		Assert.assertEquals(actualTitle, expectedTitle);
		Thread.sleep(2000);
		File ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(ss, new File("D:\\SQA\\Final Project\\Selenium Maven\\Ajkerdeal\\Screenshot\\title.jpg"));
		driver.quit();

	}

	@Test(description = "Verify Logo", priority = 1)
	public void VerifyLogo() throws IOException, InterruptedException {
		WebDriver driver = TestNG_UTILS.getDriver("Chrome");
		driver.get(url);
		WebElement logo = driver.findElement(By.xpath("//img[@alt='logo']"));
		if (logo.isDisplayed()) {
			System.out.println("Logo is Displayed");
		} else {
			System.out.println("Logo is not Displayed");
		}
		Thread.sleep(2000);
		File ss = logo.getScreenshotAs(OutputType.FILE);
		Files.copy(ss, new File("D:\\SQA\\Final Project\\Selenium Maven\\Ajkerdeal\\Screenshot\\logo.jpg"));
		driver.quit();

	}

	@Test(description = "Verify search bar", priority = 2)
	public void searchbar() throws InterruptedException, IOException {
		WebDriver driver = TestNG_UTILS.getDriver("Chrome");
		driver.get(url);
		WebElement search = driver.findElement(By.name("search"));
		if (search.isDisplayed()) {
			System.out.println("Search Bar is Displayed");
		} else {
			System.out.println("Search Bar  not Displayed");
		}
		Thread.sleep(2000);
		File ss = search.getScreenshotAs(OutputType.FILE);
		Files.copy(ss, new File("D:\\SQA\\Final Project\\Selenium Maven\\Ajkerdeal\\Screenshot\\searchbar.jpg"));
		driver.quit();
	}

	@Test(description = "Product Check", priority = 3)
	public void ProductCheck() throws InterruptedException, IOException {
		WebDriver driver = TestNG_UTILS.getDriver("Chrome");
		driver.get(url);
		Actions hover = new Actions(driver);
		hover.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'ছেলেদের শপিং')]"))).build().perform();
		Thread.sleep(1000);
		hover.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'প্যান্ট')]"))).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@href='https://ajkerdeal.com/category/mens-shopping-pants-jeans']")).click();
		Thread.sleep(2000);
		File ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(ss, new File("D:\\SQA\\Final Project\\Selenium Maven\\Ajkerdeal\\Screenshot\\productCheck.jpg"));
		driver.quit();
	}

	@Test(description = "Search Button Cheack And Product Search", priority = 4)
	public void SearchProduct() throws InterruptedException, IOException {
		WebDriver driver = TestNG_UTILS.getDriver("Chrome");
		driver.get(url);
		driver.findElement(By.id("txtName")).sendKeys("pant");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='button']")).click();
		String expectedTitle = "আজকেরডিল.কম| বাংলাদেশী অনলাইন শপিং সাইট | অনুসন্ধান";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		File ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(ss, new File("D:\\SQA\\Final Project\\Selenium Maven\\Ajkerdeal\\Screenshot\\searchProduct.jpg"));
		driver.quit();
	}

	@Test(description = "Click Logo and Back to Home", priority = 5)
	public void BackToHome() throws InterruptedException, IOException {
		WebDriver driver = TestNG_UTILS.getDriver("Chrome");
		driver.get(url);
		driver.findElement(By.id("txtName")).sendKeys("pant");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='button']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[@alt='logo']")).click();
		Thread.sleep(1000);
		File ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(ss, new File("D:\\SQA\\Final Project\\Selenium Maven\\Ajkerdeal\\Screenshot\\BackToHome.jpg"));
		driver.quit();
	}

	@Test(description = "Language Changae BAN To ENG", priority = 6)
	public void LanguageChange() throws InterruptedException, IOException {
		WebDriver driver = TestNG_UTILS.getDriver("Chrome");
		driver.get(url);
		driver.findElement(By.xpath("//a[normalize-space()='ENG']")).click();
		Thread.sleep(2000);

		String expectedTitle = "Online Shopping BD - Clothing & Gadget Shop | Ajkerdeal";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		Thread.sleep(2000);
		File ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(ss, new File("D:\\SQA\\Final Project\\Selenium Maven\\Ajkerdeal\\Screenshot\\LanguageChange.jpg"));
		driver.quit();
	}
	
	@Test(description = "Product a order",priority = 7)
	public void ProductOrder() throws InterruptedException, IOException {
		WebDriver driver = TestNG_UTILS.getDriver("Chrome");
		driver.get(url);
		
		driver.findElement(By.xpath("//div[@id='NewHotDealBlock']//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//a[1]//div[1]//img[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='Button1']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='FreeGiftSizeValue']//input[@id='L']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='Button1']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("mail.mahmudul08@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='Button1']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='placeOrder']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
		File ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(ss, new File("D:\\SQA\\Final Project\\Selenium Maven\\Ajkerdeal\\Screenshot\\OrderProduct.jpg"));
		driver.quit();
		
	}
}
