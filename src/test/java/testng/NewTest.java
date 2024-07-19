package testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTest {
	WebDriver driver;
	
  @BeforeTest
  public void nopcommerce() {
	  driver=WebDriverManager.chromedriver().create();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("https://demo.nopcommerce.com/");
  }
  
  @Test(priority=1)
  public void login()
  {
	  driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("Apple");
	  //driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
	  driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
  }
  
  @Test(priority=200)
  public void close()
  {
	  driver.quit();
  }
}
