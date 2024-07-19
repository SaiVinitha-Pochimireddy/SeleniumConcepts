package locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class normalLocators {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
	//1. using Id
		driver.findElement(By.id("small-searchterms")).sendKeys("Apple");
		
		//2. Using ClassName
		//actual classname=button-1 search-box-button but we use only "button-1" (before 1st space).
		driver.findElement(By.className("button-1")).click();
		Thread.sleep(5000);
		
		//3. using LinkText and Partial LinkText
		driver.findElement(By.linkText("Apple MacBook Pro 13-inch")).click();
		Thread.sleep(5000);
		driver.findElement(By.partialLinkText("Apple")).click();
		Thread.sleep(5000);
		
		//4. using Name
		//email field is there at end of the page.
		driver.findElement(By.name("NewsletterEmail")).sendKeys("abc@gmail.com");
		
		//5. Using Tagname
		//finding nu.of Buttons in page
		List<WebElement> btns=driver.findElements(By.tagName("button"));
		System.out.println("no.of buttons in page are "+btns.size());
		
		driver.get("https://demo.nopcommerce.com/");
		Thread.sleep(5000);
		//finding no.of Slides using classname
		List<WebElement> slds=driver.findElements(By.className("nivoSlider"));
		System.out.println("no.of Slides are "+slds.size());
		
		//closing the browser
		//driver.close();
		

	}

}
