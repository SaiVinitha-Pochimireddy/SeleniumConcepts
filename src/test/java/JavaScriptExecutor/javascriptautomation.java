package JavaScriptExecutor;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class javascriptautomation {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js= (JavascriptExecutor) driver;//if we crate driver with chrome driver then we no to do typecaste
		
		WebElement rbtn= driver.findElement(By.xpath("//input[@id='male']"));
		js.executeScript("arguments[0].click();", rbtn);
		
		WebElement inputbx=driver.findElement(By.xpath("//input[@id='name']"));
		js.executeScript("arguments[0].setAttribute('value','abc')",inputbx);
		
		WebElement chkbox= driver.findElement(By.xpath("//div[@class='form-group']//input[@type='checkbox']"));
		js.executeScript("arguments[0].click();", chkbox);
		

	}

}
