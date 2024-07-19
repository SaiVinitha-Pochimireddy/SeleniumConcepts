package framesAndbrowserSwitch;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class framesAssignment {

	public static void main(String[] args) {
		/*
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//opening main page(parent)
		driver.get("https://the-internet.herokuapp.com/iframe");
		driver.manage().window().maximize();
		
		//switching to iframe
		driver.switchTo().frame(0);
		//clearing the previous text
		driver.findElement(By.xpath("//p[text()='Your content goes here.']")).clear();
		//passing new text
		driver.findElement(By.xpath("//p[text()='Your content goes here.']")).sendKeys("sending new text");
		*/
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://the-internet.herokuapp.com/iframe");
		driver.manage().window().maximize();
		
		driver.switchTo().frame("mce_0_ifr");
		
		driver.findElement(By.id("tinymce")).clear(); // clears box
		driver.findElement(By.id("tinymce")).sendKeys("Welcome to automation");
		
		driver.findElement(By.id("tinymce")).sendKeys(Keys.CONTROL+"A"); //select text
		
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//button[@title='Bold']")).click();//bold text

	}

}
