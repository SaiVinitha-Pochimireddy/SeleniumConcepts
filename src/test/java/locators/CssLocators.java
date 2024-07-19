package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CssLocators {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		//1. tag and Id  tag#idvalue.
		driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("htc");
		
		//2.tag and class  tag.classvalue
		System.out.println(driver.findElement(By.cssSelector("span.cart-label")).getText());
		
		//3.tag and attribute  tag[attr='atrval']
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		//4.tag class and attribute  tag.classvale[attr='atrval']
		driver.findElement(By.cssSelector("input.search-box-text[aria-label='Search store']")).sendKeys("testing");
		
		driver.findElement(By.cssSelector("button[class='button-1 search-box-button']")).click();
		
		driver.findElement(By.linkText("nopCommerce")).click();
		
		//closing the browser
		driver.close();
		
	}

}
