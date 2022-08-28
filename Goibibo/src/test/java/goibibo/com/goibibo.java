package goibibo.com;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class goibibo {
  @Test(description = "Check valid Title", priority = 1)
  public void TitleVarify() throws InterruptedException {
	  
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("https://www.goibibo.com/");
	  String actualTitle = driver.getTitle();
	  String expectedTitle = "Goibibo - Best Travel Website. Book Hotels, Flights, Trains, Bus and Cabs with upto 50% off";
		  
	  Assert.assertEquals(actualTitle, expectedTitle);
	  Thread.sleep(2000);
	  driver.quit();
  }
  @Test(description = "Trip Redio Button check", priority = 2)
  public void RedioButton1() {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("https://www.goibibo.com/");
	  
	  List<WebElement> redio1 = driver.findElements(By.xpath("//ul[@class='sc-fvxzrP cCkBwj']"));
	  
	  for(WebElement i : redio1) {
		  System.out.println(i.getText());
	  }
	  driver.quit();
	
  }
  @Test(description = "Search a Trip", priority = 3)
  public void SearchTrip() throws InterruptedException {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("https://www.goibibo.com/");
	  
	  
	  driver.findElement(By.xpath("//span[text()='One-way']")).click();
	  
	  driver.findElement(By.xpath("(//p[text()='Enter city or airport'])[1]")).click();
	  Thread.sleep(2000);
	  
	  driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Pune");
	  Thread.sleep(2000);
	  
	  driver.findElement(By.xpath("//li[1]//div[1]//div[1]//div[1]//p[1]")).click();
	  Thread.sleep(2000);
	  
	  driver.findElement(By.xpath("//input[@type='text']")).sendKeys("kolkata");
	  Thread.sleep(2000);
	  
	  driver.findElement(By.xpath("//li[1]//div[1]//div[1]//div[1]//p[1]//span[1]")).click();
	  Thread.sleep(2000);
	  
	  driver.findElement(By.xpath("//span[text()='Done']")).click();
	  Thread.sleep(2000);
	  
	  driver.findElement(By.xpath("//a[normalize-space()='Done']")).click();
	  Thread.sleep(2000);
	  
	  driver.findElement(By.xpath("//span[text()='student']")).click();
	  Thread.sleep(2000);
	  
	  driver.findElement(By.xpath("//a[text()='Done']")).click();
	  
	  driver.findElement(By.xpath("//span[text()='SEARCH FLIGHTS']")).click();
	  
	  driver.quit();
	
  }
  @Test(description = "Select a fare type check", priority = 4)
  public void Redion2() {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("https://www.goibibo.com/");
	  
	  List<WebElement> redio = driver.findElements(By.xpath("//div[@class='sc-kLwhqv kUoFtj']"));
	  
	  for(WebElement i : redio) {
		  System.out.println(i.getText());
	  }
	  driver.quit();
	
  }
}
