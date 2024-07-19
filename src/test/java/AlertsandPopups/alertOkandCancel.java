package AlertsandPopups;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class alertOkandCancel {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		/*
		//alert contains only ok button
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		//creating Alert class object to switch to alert popup
		Alert ok=driver.switchTo().alert();
		//To click on ok button we use accept method
		ok.accept();
		*/
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		//creating Alert class object to switch to alert popup
		driver.switchTo().alert().dismiss();
		
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		
		driver.switchTo().alert().sendKeys("welcome");
		driver.switchTo().alert().accept();
		String str=driver.findElement(By.xpath("//p[@id='result']")).getText();
		
		if(str.contains("welcome"))
		{
			System.out.println("test passed");
		}
		else
		{
			System.out.println("test failed");
		}
	}

}
