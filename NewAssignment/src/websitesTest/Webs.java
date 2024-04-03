package websitesTest;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Webs {
	public WebDriver driver;
	@BeforeClass
	public void init() throws InterruptedException {
		
	WebDriver driver;
	
	//driver =new ChromeDriver();
	driver =new EdgeDriver();
	
	driver.manage().window().maximize();
	
	driver.get("https://bookcart.azurewebsites.net/");
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	
	Thread.sleep(500);
	driver.findElement(By.xpath("//span[normalize-space()='Login']")).click();
	driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys("kedartambat");
	driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("Kedar@12345");
	driver.findElement(By.cssSelector("button[class='mdc-button mdc-button--raised mat-mdc-raised-button mat-primary mat-mdc-button-base']")).click();
	js.executeScript("window.scrollBy(0,200)");
	driver.findElement(By.xpath("/html/body/app-root/div/app-home/div/div[2]/div/div[1]/app-book-card/mat-card/mat-card-content/app-addtocart/button")).click();
	driver.findElement(By.xpath("/html/body/app-root/div/app-home/div/div[2]/div/div[2]/app-book-card/mat-card/mat-card-content/app-addtocart/button")).click();
	driver.findElement(By.xpath("/html/body/app-root/div/app-home/div/div[2]/div/div[3]/app-book-card/mat-card/mat-card-content/app-addtocart/button")).click();
	driver.findElement(By.xpath("/html/body/app-root/div/app-home/div/div[2]/div/div[4]/app-book-card/mat-card/mat-card-content/app-addtocart/button")).click();
	driver.findElement(By.xpath("/html/body/app-root/div/app-home/div/div[2]/div/div[5]/app-book-card/mat-card/mat-card-content/app-addtocart/button")).click();
	driver.findElement(By.cssSelector("button[class='mdc-icon-button mat-mdc-icon-button mat-unthemed mat-mdc-button-base']")).click();
	WebElement CartValue =driver.findElement(By.xpath("//*[@class='mat-mdc-cell mdc-data-table__cell cdk-cell cdk-column-action mat-column-action'][5]"));
	driver.findElement(By.xpath("//button[@class='mdc-icon-button mat-mdc-icon-button mat-warn mat-mdc-button-base cdk-focused cdk-mouse-focused']//span[@class='mat-mdc-button-touch-target']")).click();
	WebElement Qut =driver.findElement(By.xpath("//td[contains(text(),'₹470.00')]"));
	WebElement Single =driver.findElement(By.xpath("//td[contains(text(),'₹235.00')]"));
	Assert.assertNotEquals(Qut, Single, "Verify that Total Quantity (multiple Quantity) of Added Products and price of product is Different  ");
	WebElement TotalCartValue =driver.findElement(By.xpath("//*[@class='mat-mdc-cell mdc-data-table__cell cdk-cell cdk-column-action mat-column-action'][5]"));
	Assert.assertNotEquals(CartValue, TotalCartValue, "Verify that if any quantity updated then total price(value) of cart also updated");
	}
	
	@BeforeMethod
	public void precondition() {}
	
	
	@Test
	public void logout() {
		
		
	}
	@AfterMethod
	public void io() {
		
	}
	@AfterClass
	public void tearDown() {
		//driver.quit();
	}
	

}

