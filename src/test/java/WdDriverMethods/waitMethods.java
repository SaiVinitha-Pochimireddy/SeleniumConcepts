package WdDriverMethods;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class waitMethods {

	public static void main(String[] args)  {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		/*
		//1. implicit wait it will be applicable for all elements automatically
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("HTC");
		driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
		
		//2. Explicit wait declaration
		WebDriverWait mywt=new WebDriverWait(driver,Duration.ofSeconds(5));
		
		//usage of "mywt" for each individual element
		WebElement wt=mywt.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.search-box-text.ui-autocomplete-input")));
		wt.sendKeys("apple");
		
		wt=mywt.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.button-1.search-box-button[type='submit']")));
		wt.click();*/
		
		//2.1 Fluent wait same as explicit but contains 2 extra features 1.pollingevery 2.ignoreException
		FluentWait myfwt=new FluentWait(driver);
		myfwt.withTimeout(Duration.ofSeconds(15));
		myfwt.pollingEvery(Duration.ofSeconds(5));//it will repeat for 3 times 3*5=15
		myfwt.ignoring(NoSuchElementException.class);
		
		WebElement fwt= (WebElement) myfwt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='small-searchterms']")));
		fwt.sendKeys("abc");
		fwt=(WebElement)myfwt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Search']")));
		fwt.click();
		
		
	}

}
