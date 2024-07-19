package realtimeAssignments;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonPrice {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath(" //input[@id='twotabsearchtextbox']")).sendKeys("iphone 12");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		driver.findElement(By.xpath("//img[@alt='Apple iPhone 12 (256GB) - (Product) RED']")).click();
		/*
		Set<String> winhdls=driver.getWindowHandles();
		for(String winid:winhdls)
		{
			String title= driver.switchTo().window(winid).getTitle();
			System.out.println(title);
			if(title.equals("Apple iPhone 12 (64GB) - (Product) RED : Amazon.in: Electronics"))
			{
				driver.switchTo().window(winid);
			}
			System.out.println(winid);
		}
		//driver.switchTo().window(winid);
		*/
	  String aprice=driver.findElement(By.xpath("//span[normalize-space()='69,900']")).getText();
	  System.out.println("amazon price for iphone 12 "+ aprice);
	  
	  driver.get("https://www.flipkart.com/");
	  driver.manage().window().maximize();
	  try
	  {
		WebElement login=driver.findElement(By.xpath("//div/button[@class='_2KpZ6l _2doB4z']"));
		
			login.click();
		}
	  catch(Exception e)
	  {
		  e.getMessage();
	  }
		driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys("iphone 12");
		driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
		driver.findElement(By.xpath("//img[@alt='APPLE iPhone 12 (Red, 128 GB)']")).click();
		
		String fprice=driver.findElement(By.xpath("//div[@class='CEmiEU']/descendant::div[contains(@class,'_30jeq3 _16Jk6d')]")).getText();
		System.out.println("flipcart price for iphone 12 "+fprice);
		if(Integer.parseInt(aprice)>Integer.parseInt(fprice))
		{
			System.out.println("flipcart price is less by "+(Integer.parseInt(aprice)-Integer.parseInt(fprice)));
		}
		else
		{
			System.out.println("amazon price is less by "+(Integer.parseInt(fprice)-Integer.parseInt(aprice)));
		}
	  //driver.close();

	}

}
