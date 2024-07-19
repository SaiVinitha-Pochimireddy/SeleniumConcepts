package WdDriverMethods;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.net.Urls;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigationMethods {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		//driver.get("https://www.opencart.com/");
		//URL url=new URL("https://www.opencart.com/");
		//1. navigate().to() similar to get().
		driver.navigate().to("https://www.opencart.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		//opening another page in same tab
		driver.findElement(By.xpath("//div[@class='hidden-xs hidden-sm']//div[1]//a[2]")).click();
		
		//2. navigate().back()
		driver.navigate().back(); // goes to main page
		
		//3.navigate().forward()
		driver.navigate().forward(); // goes to demo page
		
		//4. navigate().refresh()
		driver.navigate().refresh(); //refresh the demo page

	}

}
