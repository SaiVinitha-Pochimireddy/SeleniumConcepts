package headlesstesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class headlessmode {

	public static void main(String[] args) {
		
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--headless=new");
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.nopcommerce.com/en");
		String title=driver.findElement(By.xpath("//h1[normalize-space()='Free and open-source eCommerce platform']")).getText();
		
		System.out.println(title);
		
		if(title.equals("Free and open-source eCommerce platform"))
		{
			System.out.println("test passed");
		}
		else
		{
		System.out.println("test failed");
		}
		//driver.close();

	}

}
